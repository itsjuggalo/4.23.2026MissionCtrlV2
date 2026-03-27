package M0;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebkitToCompatConverterBoundaryInterface f3802a;

    public s(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.f3802a = webkitToCompatConverterBoundaryInterface;
    }

    public SafeBrowsingResponse a(InvocationHandler invocationHandler) {
        return r.a(this.f3802a.convertSafeBrowsingResponse(invocationHandler));
    }

    public InvocationHandler b(SafeBrowsingResponse safeBrowsingResponse) {
        return this.f3802a.convertSafeBrowsingResponse(safeBrowsingResponse);
    }

    public WebResourceError c(InvocationHandler invocationHandler) {
        return (WebResourceError) this.f3802a.convertWebResourceError(invocationHandler);
    }

    public InvocationHandler d(WebResourceError webResourceError) {
        return this.f3802a.convertWebResourceError(webResourceError);
    }
}
