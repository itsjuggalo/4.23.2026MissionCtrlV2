package r2;

import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewProviderFactoryBoundaryInterface f19284a;

    public n(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f19284a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // r2.m
    public String[] a() {
        return this.f19284a.getSupportedFeatures();
    }

    @Override // r2.m
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) jh.a.a(StaticsBoundaryInterface.class, this.f19284a.getStatics());
    }

    @Override // r2.m
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) jh.a.a(WebkitToCompatConverterBoundaryInterface.class, this.f19284a.getWebkitToCompatConverter());
    }
}
