package r2;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebkitToCompatConverterBoundaryInterface f19285a;

    public p(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.f19285a = webkitToCompatConverterBoundaryInterface;
    }

    public SafeBrowsingResponse a(InvocationHandler invocationHandler) {
        return o.a(this.f19285a.convertSafeBrowsingResponse(invocationHandler));
    }

    public InvocationHandler b(SafeBrowsingResponse safeBrowsingResponse) {
        return this.f19285a.convertSafeBrowsingResponse(safeBrowsingResponse);
    }

    public WebResourceError c(InvocationHandler invocationHandler) {
        return (WebResourceError) this.f19285a.convertWebResourceError(invocationHandler);
    }

    public InvocationHandler d(WebResourceError webResourceError) {
        return this.f19285a.convertWebResourceError(webResourceError);
    }
}
