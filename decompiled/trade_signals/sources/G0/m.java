package G0;

import G0.a;
import android.webkit.WebResourceError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class m extends F0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebResourceError f2020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebResourceErrorBoundaryInterface f2021b;

    public m(WebResourceError webResourceError) {
        this.f2020a = webResourceError;
    }

    @Override // F0.b
    public CharSequence a() {
        a.b bVar = n.f2078v;
        if (bVar.c()) {
            return b.a(d());
        }
        if (bVar.d()) {
            return c().getDescription();
        }
        throw n.a();
    }

    @Override // F0.b
    public int b() {
        a.b bVar = n.f2079w;
        if (bVar.c()) {
            return b.b(d());
        }
        if (bVar.d()) {
            return c().getErrorCode();
        }
        throw n.a();
    }

    public final WebResourceErrorBoundaryInterface c() {
        if (this.f2021b == null) {
            this.f2021b = (WebResourceErrorBoundaryInterface) w7.a.a(WebResourceErrorBoundaryInterface.class, o.c().d(this.f2020a));
        }
        return this.f2021b;
    }

    public final WebResourceError d() {
        if (this.f2020a == null) {
            this.f2020a = o.c().c(Proxy.getInvocationHandler(this.f2021b));
        }
        return this.f2020a;
    }

    public m(InvocationHandler invocationHandler) {
        this.f2021b = (WebResourceErrorBoundaryInterface) w7.a.a(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }
}
