package v0;

import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewProviderFactoryBoundaryInterface f15285a;

    public n(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f15285a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // v0.m
    public String[] a() {
        return this.f15285a.getSupportedFeatures();
    }

    @Override // v0.m
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) S3.a.a(StaticsBoundaryInterface.class, this.f15285a.getStatics());
    }

    @Override // v0.m
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) S3.a.a(WebkitToCompatConverterBoundaryInterface.class, this.f15285a.getWebkitToCompatConverter());
    }
}
