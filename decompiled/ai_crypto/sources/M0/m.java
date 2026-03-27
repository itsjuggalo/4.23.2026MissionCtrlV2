package M0;

import M0.a;
import android.webkit.WebResourceError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class m extends L0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebResourceError f3735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebResourceErrorBoundaryInterface f3736b;

    public m(InvocationHandler invocationHandler) {
        this.f3736b = (WebResourceErrorBoundaryInterface) A6.a.a(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    @Override // L0.b
    public CharSequence a() {
        a.b bVar = n.f3793v;
        if (bVar.c()) {
            return b.a(d());
        }
        if (bVar.d()) {
            return c().getDescription();
        }
        throw n.a();
    }

    @Override // L0.b
    public int b() {
        a.b bVar = n.f3794w;
        if (bVar.c()) {
            return b.b(d());
        }
        if (bVar.d()) {
            return c().getErrorCode();
        }
        throw n.a();
    }

    public final WebResourceErrorBoundaryInterface c() {
        if (this.f3736b == null) {
            this.f3736b = (WebResourceErrorBoundaryInterface) A6.a.a(WebResourceErrorBoundaryInterface.class, o.c().d(this.f3735a));
        }
        return this.f3736b;
    }

    public final WebResourceError d() {
        if (this.f3735a == null) {
            this.f3735a = o.c().c(Proxy.getInvocationHandler(this.f3736b));
        }
        return this.f3735a;
    }

    public m(WebResourceError webResourceError) {
        this.f3735a = webResourceError;
    }
}
