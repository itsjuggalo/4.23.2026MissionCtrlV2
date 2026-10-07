# ainvest_cdp_shot.ps1 - Windows-side CDP (local only): PNG screenshot of the EXISTING tab matching -Match to -Out,
# plus a list of input-like elements. Read-only diagnostic for AIME.
param([int]$Port = 9333, [string]$Addr = "[::1]", [string]$Match = 'ainvest.com', [string]$Out)
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
  $b = [Text.Encoding]::UTF8.GetBytes(($m | ConvertTo-Json -Compress -Depth 6))
  $ws.SendAsync((New-Object ArraySegment[byte] (,$b)), 'Text', $true, $cts.Token).Wait()
  while ($true) {
    $sb = New-Object Text.StringBuilder
    do { $buf = New-Object byte[] 4194304
         $r = $ws.ReceiveAsync((New-Object ArraySegment[byte] (,$buf)), $cts.Token).Result
         [void]$sb.Append([Text.Encoding]::UTF8.GetString($buf, 0, $r.Count)) } while (-not $r.EndOfMessage)
    $o = $sb.ToString() | ConvertFrom-Json
    if ($o.id -eq $script:id) { return $o.result }
  }
}
$t = (Call 'Target.getTargets' @{}).targetInfos | Where-Object { $_.type -eq 'page' -and $_.url -like "*$Match*" } | Select-Object -First 1
if (-not $t) { "NO_TAB"; exit 2 }
[void](Call "Target.activateTarget" @{ targetId = $t.targetId })
Start-Sleep -Seconds 2
$s = (Call 'Target.attachToTarget' @{ targetId = $t.targetId; flatten = $true }).sessionId
$png = (Call 'Page.captureScreenshot' @{ format = 'png' } $s).data
[IO.File]::WriteAllBytes($Out, [Convert]::FromBase64String($png))
$js = '[...document.querySelectorAll("textarea,input,[contenteditable],[role=textbox]")].map(e => e.tagName + " ce=" + e.getAttribute("contenteditable") + " ph=" + (e.placeholder||e.getAttribute("data-placeholder")||"") + " vis=" + !!e.offsetParent + " cls=" + (e.className||"").toString().slice(0,60)).join("\n")'
"TAB " + $t.url
(Call 'Runtime.evaluate' @{ expression = $js; returnByValue = $true } $s).result.value
$ws.Dispose()
