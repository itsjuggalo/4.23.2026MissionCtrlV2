# ainvest_cdp_ask_capture.ps1 - Windows-side CDP (local only). In the EXISTING AIME tab matching -Match: enable Network,
# type -Question into the chat box, press Enter, and print every non-analytics request it makes for -Seconds
# (URL, method, headers minus cookie/authorization, body) as JSON lines. Used once to learn AIME's current API.
param([int]$Port = 9333, [string]$Addr = "[::1]", [string]$Match = 'ainvest.com/aime', [string]$Question = 'Reply with the single word OK.', [int]$Seconds = 45, [int]$X = 600, [int]$Y = 1000)
$ErrorActionPreference = 'Stop'
$v = Invoke-RestMethod -Uri "http://${Addr}:$Port/json/version" -TimeoutSec 10
$ws = New-Object System.Net.WebSockets.ClientWebSocket
$cts = New-Object System.Threading.CancellationTokenSource (($Seconds + 20) * 1000)
$ws.ConnectAsync([Uri]$v.webSocketDebuggerUrl, $cts.Token).Wait()
$script:id = 0; $script:queue = New-Object System.Collections.ArrayList
function Recv() {
  $sb = New-Object Text.StringBuilder
  do { $buf = New-Object byte[] 1048576
       $r = $ws.ReceiveAsync((New-Object ArraySegment[byte] (,$buf)), $cts.Token).Result
       [void]$sb.Append([Text.Encoding]::UTF8.GetString($buf, 0, $r.Count)) } while (-not $r.EndOfMessage)
  return ($sb.ToString() | ConvertFrom-Json)
}
function Call($method, $params, $session) {
  $script:id++
  $m = @{ id = $script:id; method = $method; params = $params }
  if ($session) { $m.sessionId = $session }
  $b = [Text.Encoding]::UTF8.GetBytes(($m | ConvertTo-Json -Compress -Depth 6))
  $ws.SendAsync((New-Object ArraySegment[byte] (,$b)), 'Text', $true, $cts.Token).Wait()
  while ($true) { $o = Recv; if ($o.id -eq $script:id) { return $o.result }; if ($o.method) { [void]$script:queue.Add($o) } }
}
function Show($o) {
  if ($o.method -eq 'Target.attachedToTarget') { $script:id++; $m = @{ id = $script:id; method = 'Network.enable'; params = @{}; sessionId = $o.params.sessionId }; $b = [Text.Encoding]::UTF8.GetBytes(($m | ConvertTo-Json -Compress)); $ws.SendAsync((New-Object ArraySegment[byte] (,$b)), 'Text', $true, $cts.Token).Wait(); return }
  if ($o.method -ne 'Network.requestWillBeSent') { return }
  $rq = $o.params.request
  if ($rq.url -match 'clarity|google|stat\.ainvest|apm\.ainvest|\.(js|css|png|svg|woff2?|jpg|webp|gif)(\?|$)') { return }
  $h = @{}; foreach ($p in $rq.headers.PSObject.Properties) { if ($p.Name -notmatch '^(cookie|authorization)$') { $h[$p.Name] = $p.Value } }
  @{ url = $rq.url; method = $rq.method; headers = $h; body = $rq.postData } | ConvertTo-Json -Compress -Depth 6
}
$t = (Call 'Target.getTargets' @{}).targetInfos | Where-Object { $_.type -eq 'page' -and $_.url -like "*$Match*" } | Select-Object -First 1
if (-not $t) { "NO_TAB"; exit 2 }
"TAB " + $t.url
$s = (Call 'Target.attachToTarget' @{ targetId = $t.targetId; flatten = $true }).sessionId
[void](Call 'Network.enable' @{} $s)
[void](Call 'Target.activateTarget' @{ targetId = $t.targetId })
[void](Call 'Target.setAutoAttach' @{ autoAttach = $true; waitForDebuggerOnStart = $false; flatten = $true } $s)
foreach ($ty in 'mousePressed','mouseReleased') { [void](Call 'Input.dispatchMouseEvent' @{ type = $ty; x = $X; y = $Y; button = 'left'; clickCount = 1 } $s) }
Start-Sleep -Milliseconds 400
[void](Call 'Input.insertText' @{ text = $Question } $s)
Start-Sleep -Milliseconds 400
[void](Call 'Input.dispatchKeyEvent' @{ type = 'keyDown'; key = 'Enter'; code = 'Enter'; windowsVirtualKeyCode = 13; text = "`r" } $s)
[void](Call 'Input.dispatchKeyEvent' @{ type = 'keyUp'; key = 'Enter'; code = 'Enter'; windowsVirtualKeyCode = 13 } $s)
foreach ($o in $script:queue) { Show $o }
$end = (Get-Date).AddSeconds($Seconds)
while ((Get-Date) -lt $end) { try { $o = Recv } catch { break }; Show $o }
$ws.Dispose()
