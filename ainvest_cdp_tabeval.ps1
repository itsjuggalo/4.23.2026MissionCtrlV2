# ainvest_cdp_tabeval.ps1 - Windows-side CDP (127.0.0.1 only): evaluate -Expr in the EXISTING ainvest-profile tab
# whose URL matches -Match (default ainvest.com). Read-only diagnostic for AIME; prints the string result.
param([int]$Port = 9333, [string]$Addr = "127.0.0.1", [string]$Match = 'ainvest.com', [string]$Expr)
$ErrorActionPreference = 'Stop'
$v = Invoke-RestMethod -Uri "http://${Addr}:$Port/json/version" -TimeoutSec 10
$ws = New-Object System.Net.WebSockets.ClientWebSocket
$cts = New-Object System.Threading.CancellationTokenSource 60000
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
$targets = (Call 'Target.getTargets' @{}).targetInfos | Where-Object { $_.type -eq 'page' -and $_.url -like "*$Match*" }
foreach ($t in $targets) {
  $s = (Call 'Target.attachToTarget' @{ targetId = $t.targetId; flatten = $true }).sessionId
  $res = Call 'Runtime.evaluate' @{ expression = $Expr; awaitPromise = $true; returnByValue = $true } $s
  "TAB " + $t.url
  $res.result.value
  [void](Call 'Target.detachFromTarget' @{ sessionId = $s })
}
if (-not $targets) { "NO_TAB matching $Match; pages: " + (((Call 'Target.getTargets' @{}).targetInfos | Where-Object type -eq 'page' | ForEach-Object url) -join ' | ') }
$ws.Dispose()
