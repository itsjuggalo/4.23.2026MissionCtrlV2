# ainvest_cdp_cookies.ps1 - runs on WINDOWS, talks to Chrome's DevTools on 127.0.0.1 only (nothing exposed).
# Reads the AInvest cookies from the dedicated ainvest-profile Chrome and writes them as JSON to stdout
# for ~/scripts/ainvest_cookie_cdp.py. Usage: powershell -File ainvest_cdp_cookies.ps1 -Port 9347 [-Touch]
param([int]$Port = 9347, [switch]$Touch)
$ErrorActionPreference = 'Stop'
$v = Invoke-RestMethod -Uri "http://127.0.0.1:$Port/json/version" -TimeoutSec 10
$ws = New-Object System.Net.WebSockets.ClientWebSocket
$cts = New-Object System.Threading.CancellationTokenSource 60000
$ws.ConnectAsync([Uri]$v.webSocketDebuggerUrl, $cts.Token).Wait()
$script:id = 0
function Call($method, $params) {
  $script:id++
  $msg = @{ id = $script:id; method = $method; params = $params } | ConvertTo-Json -Compress -Depth 5
  $bytes = [Text.Encoding]::UTF8.GetBytes($msg)
  $ws.SendAsync((New-Object ArraySegment[byte] (,$bytes)), 'Text', $true, $cts.Token).Wait()
  while ($true) {
    $sb = New-Object Text.StringBuilder
    do {
      $buf = New-Object byte[] 65536
      $r = $ws.ReceiveAsync((New-Object ArraySegment[byte] (,$buf)), $cts.Token).Result
      [void]$sb.Append([Text.Encoding]::UTF8.GetString($buf, 0, $r.Count))
    } while (-not $r.EndOfMessage)
    $o = $sb.ToString() | ConvertFrom-Json
    if ($o.id -eq $script:id) { return $o.result }
  }
}
if ($Touch) {   # open AInvest so the site refreshes its session cookies, then close the tab
  $t = Call 'Target.createTarget' @{ url = 'https://www.ainvest.com/' }
  Start-Sleep -Seconds 8
  [void](Call 'Target.closeTarget' @{ targetId = $t.targetId })
}
$all = (Call 'Storage.getCookies' @{}).cookies
$keep = @($all | Where-Object { $_.domain.TrimStart('.') -like '*ainvest.com' } | ForEach-Object { @{ name = $_.name; value = $_.value; domain = $_.domain } })
$ws.Dispose()
ConvertTo-Json -InputObject $keep -Compress -Depth 3
