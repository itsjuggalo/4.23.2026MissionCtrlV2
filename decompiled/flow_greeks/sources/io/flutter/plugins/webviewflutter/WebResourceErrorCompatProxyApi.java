package io.flutter.plugins.webviewflutter;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class WebResourceErrorCompatProxyApi extends PigeonApiWebResourceErrorCompat {
    public WebResourceErrorCompatProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceErrorCompat
    public String description(q2.b bVar) {
        return bVar.a().toString();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceErrorCompat
    public long errorCode(q2.b bVar) {
        return bVar.b();
    }
}
