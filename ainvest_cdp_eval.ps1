# ainvest_cdp_eval.ps1 - Windows-side CDP (127.0.0.1 only): open -Url in the ainvest-profile Chrome, wait,
# evaluate -Expr (async JS returning a string) in the page, print the result. Diagnostic helper for AIME.
param([int]$Port = 9347, [string]$Addr = "127.0.0.1", [string]$Url, [string]$Expr, [int]$Wait = 10)
$ErrorActionPreference = 'Stop'
$v = Invoke-RestMethod -Uri "http://${Addr}:$Port/json/version" -TimeoutSec 10
$ws = New-Object System.Net.WebSockets.ClientWebSocket
$cts = New-Object System.Threading.CancellationTokenSource 120000
$ws.ConnectAsync([Uri]$v.webSocketDebuggerUrl, $cts.Token).Wait()
$script:id = 0
function Call($method, $params, $session) {
  $script:id++
  $m = @{ id = $script:id; method = $method; params = $params }
  if ($session) { $m.sessionId = $session }
  $bytes = [Text.Encoding]::UTF8.GetBytes(($m | ConvertTo-Json -Compress -Depth 6))
  $ws.SendAsync((New-Object ArraySegment[byte] (,$bytes)), 'Text', $true, $cts.Token).Wait()
  while ($true) {
    $sb = New-Object Text.StringBuilder
    do { $buf = New-Object byte[] 262144
         $r = $ws.ReceiveAsync((New-Object ArraySegment[byte] (,$buf)), $cts.Token).Result
         [void]$sb.Append([Text.Encoding]::UTF8.GetString($buf, 0, $r.Count)) } while (-not $r.EndOfMessage)
    $o = $sb.ToString() | ConvertFrom-Json
    if ($o.id -eq $script:id) { return $o.result }
  }
}
$t = Call 'Target.createTarget' @{ url = $Url }
Start-Sleep -Seconds $Wait
$s = (Call 'Target.attachToTarget' @{ targetId = $t.targetId; flatten = $true }).sessionId
$res = Call 'Runtime.evaluate' @{ expression = $Expr; awaitPromise = $true; returnByValue = $true } $s
[void](Call 'Target.closeTarget' @{ targetId = $t.targetId })
$ws.Dispose()
$res.result.value
