# ainvest_cdp_aime_probe.ps1 - Windows-side CDP on 127.0.0.1 only. Opens AIME in the ainvest-profile Chrome,
# types a question, and prints the outgoing AIME request (URL, non-secret headers, body) as JSON lines.
param([int]$Port = 9333, [string]$Url = 'https://www.ainvest.com/aime/', [string]$Q = 'hi')
$ErrorActionPreference = 'Stop'
$v = Invoke-RestMethod -Uri "http://127.0.0.1:$Port/json/version" -TimeoutSec 10
$ws = New-Object System.Net.WebSockets.ClientWebSocket
$cts = New-Object System.Threading.CancellationTokenSource 180000
$ws.ConnectAsync([Uri]$v.webSocketDebuggerUrl, $cts.Token).Wait()
$script:id = 0; $script:events = New-Object System.Collections.ArrayList
function Recv() {
  $sb = New-Object Text.StringBuilder
  do { $buf = New-Object byte[] 1048576
       $r = $ws.ReceiveAsync((New-Object ArraySegment[byte] (,$buf)), $cts.Token).Result
       [void]$sb.Append([Text.Encoding]::UTF8.GetString($buf, 0, $r.Count)) } while (-not $r.EndOfMessage)
  return ($sb.ToString() | ConvertFrom-Json)
}
function Call($method, $params, $session) {
  $script:id++; $my = $script:id
  $m = @{ id = $my; method = $method; params = $params }; if ($session) { $m.sessionId = $session }
  $b = [Text.Encoding]::UTF8.GetBytes(($m | ConvertTo-Json -Compress -Depth 6))
  $ws.SendAsync((New-Object ArraySegment[byte] (,$b)), 'Text', $true, $cts.Token).Wait()
  while ($true) { $o = Recv; if ($o.id -eq $my) { return $o.result }; if ($o.method) { [void]$script:events.Add($o) } }
}
function Report() {
  foreach ($o in $script:events) {
    if ($o.method -eq 'Network.requestWillBeSent' -and $o.params.request.method -eq 'POST' -and $o.params.request.url -match 'aime|stream') {
      $rq = $o.params.request; $h = @{}
      foreach ($p in $rq.headers.PSObject.Properties) { if ($p.Name -notmatch '^(cookie|authorization)$') { $h[$p.Name] = $p.Value } }
      @{ url = $rq.url; headers = $h; body = $rq.postData } | ConvertTo-Json -Compress -Depth 6
    }
  }
  $script:events.Clear()
}
$t = Call 'Target.createTarget' @{ url = 'about:blank' }
$s = (Call 'Target.attachToTarget' @{ targetId = $t.targetId; flatten = $true }).sessionId
[void](Call 'Network.enable' @{} $s); [void](Call 'Page.enable' @{} $s)
[void](Call 'Page.navigate' @{ url = $Url } $s)
Start-Sleep -Seconds 12
$found = Call 'Runtime.evaluate' @{ returnByValue = $true; expression = "(() => { const el = document.querySelector('textarea, [contenteditable=true], input[type=text]'); if (!el) return 'NO_INPUT ' + location.href; el.focus(); return 'FOCUSED ' + el.tagName + ' ' + location.href; })()" } $s
Write-Output ('PAGE: ' + $found.result.value)
[void](Call 'Input.insertText' @{ text = $Q } $s)
foreach ($type in 'keyDown','keyUp') { [void](Call 'Input.dispatchKeyEvent' @{ type = $type; key = 'Enter'; code = 'Enter'; windowsVirtualKeyCode = 13; text = "`r" } $s) }
$end = (Get-Date).AddSeconds(25)
while ((Get-Date) -lt $end) { [void](Call 'Runtime.evaluate' @{ expression = '1' } $s); Start-Sleep -Milliseconds 500 }
Report
[void](Call 'Target.closeTarget' @{ targetId = $t.targetId })
$ws.Dispose()
