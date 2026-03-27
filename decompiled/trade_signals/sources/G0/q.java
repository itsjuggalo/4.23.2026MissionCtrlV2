package G0;

import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class q implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewProviderFactoryBoundaryInterface f2086a;

    public q(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f2086a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // G0.p
    public String[] a() {
        return this.f2086a.getSupportedFeatures();
    }

    @Override // G0.p
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) w7.a.a(StaticsBoundaryInterface.class, this.f2086a.getStatics());
    }

    @Override // G0.p
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) w7.a.a(WebkitToCompatConverterBoundaryInterface.class, this.f2086a.getWebkitToCompatConverter());
    }
}
