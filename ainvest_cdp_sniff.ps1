# ainvest_cdp_sniff.ps1 - Windows-side CDP on 127.0.0.1 (nothing exposed). Watches every AInvest tab in the
# ainvest-profile Chrome for the next AIME "stream-query" request (Mike types a question in AIME) and prints its
# URL, non-secret request headers and JSON body as one JSON line. Cookie/Authorization headers are dropped.
param([int]$Port = 9333, [int]$Minutes = 6)
$ErrorActionPreference = 'Stop'
$v = Invoke-RestMethod -Uri "http://127.0.0.1:$Port/json/version" -TimeoutSec 10
$ws = New-Object System.Net.WebSockets.ClientWebSocket
$cts = New-Object System.Threading.CancellationTokenSource ($Minutes * 60000)
$ws.ConnectAsync([Uri]$v.webSocketDebuggerUrl, $cts.Token).Wait()
$script:id = 0
function Send($method, $params, $session) {
  $script:id++
  $m = @{ id = $script:id; method = $method; params = $params }
  if ($session) { $m.sessionId = $session }
  $b = [Text.Encoding]::UTF8.GetBytes(($m | ConvertTo-Json -Compress -Depth 6))
  $ws.SendAsync((New-Object ArraySegment[byte] (,$b)), 'Text', $true, $cts.Token).Wait()
}
function Recv() {
  $sb = New-Object Text.StringBuilder
  do { $buf = New-Object byte[] 1048576
       $r = $ws.ReceiveAsync((New-Object ArraySegment[byte] (,$buf)), $cts.Token).Result
       [void]$sb.Append([Text.Encoding]::UTF8.GetString($buf, 0, $r.Count)) } while (-not $r.EndOfMessage)
  return ($sb.ToString() | ConvertFrom-Json)
}
# auto-attach to every page (existing and new) and enable Network in each
Send 'Target.setDiscoverTargets' @{ discover = $true }
Send 'Target.setAutoAttach' @{ autoAttach = $true; waitForDebuggerOnStart = $false; flatten = $true }
$targets = (Invoke-RestMethod -Uri "http://127.0.0.1:$Port/json/list" -TimeoutSec 10) | Where-Object { $_.type -eq 'page' }
foreach ($t in $targets) { Send 'Target.attachToTarget' @{ targetId = $t.id; flatten = $true } }
$deadline = (Get-Date).AddMinutes($Minutes)
while ((Get-Date) -lt $deadline) {
  try { $o = Recv } catch { Write-Output ("RECV_ERR " + $_.Exception.InnerException.Message + " " + $_.Exception.Message); break }
  if ($o.method -eq 'Target.attachedToTarget') { Send 'Network.enable' @{} $o.params.sessionId; continue }
  if ($o.method -eq 'Target.targetCreated' -and $o.params.targetInfo.type -eq 'page') {
    Send 'Target.attachToTarget' @{ targetId = $o.params.targetInfo.targetId; flatten = $true }; continue }
  if ($o.method -eq 'Network.requestWillBeSent' -and $o.params.request.url -match 'stream-query|aime') {
    $rq = $o.params.request
    if ($rq.method -ne 'POST') { continue }
    $h = @{}; foreach ($p in $rq.headers.PSObject.Properties) { if ($p.Name -notmatch '^(cookie|authorization)$') { $h[$p.Name] = $p.Value } }
    @{ url = $rq.url; headers = $h; body = $rq.postData } | ConvertTo-Json -Compress -Depth 6
    if ($rq.url -match 'stream-query') { break }
  }
}
$ws.Dispose()
