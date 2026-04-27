package M0;

import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class q implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewProviderFactoryBoundaryInterface f3801a;

    public q(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f3801a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // M0.p
    public String[] a() {
        return this.f3801a.getSupportedFeatures();
    }

    @Override // M0.p
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) A6.a.a(StaticsBoundaryInterface.class, this.f3801a.getStatics());
    }

    @Override // M0.p
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) A6.a.a(WebkitToCompatConverterBoundaryInterface.class, this.f3801a.getWebkitToCompatConverter());
    }
}
