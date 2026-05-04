package r2;

import android.webkit.WebResourceError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import r2.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j extends q2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebResourceError f19232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebResourceErrorBoundaryInterface f19233b;

    public j(InvocationHandler invocationHandler) {
        this.f19233b = (WebResourceErrorBoundaryInterface) jh.a.a(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    @Override // q2.b
    public CharSequence a() {
        a.b bVar = k.f19276v;
        if (bVar.b()) {
            return b.a(d());
        }
        if (bVar.c()) {
            return c().getDescription();
        }
        throw k.a();
    }

    @Override // q2.b
    public int b() {
        a.b bVar = k.f19277w;
        if (bVar.b()) {
            return b.b(d());
        }
        if (bVar.c()) {
            return c().getErrorCode();
        }
        throw k.a();
    }

    public final WebResourceErrorBoundaryInterface c() {
        if (this.f19233b == null) {
            this.f19233b = (WebResourceErrorBoundaryInterface) jh.a.a(WebResourceErrorBoundaryInterface.class, l.c().d(this.f19232a));
        }
        return this.f19233b;
    }

    public final WebResourceError d() {
        if (this.f19232a == null) {
            this.f19232a = l.c().c(Proxy.getInvocationHandler(this.f19233b));
        }
        return this.f19232a;
    }

    public j(WebResourceError webResourceError) {
        this.f19232a = webResourceError;
    }
}
