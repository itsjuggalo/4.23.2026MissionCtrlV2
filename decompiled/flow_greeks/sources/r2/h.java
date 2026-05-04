package r2;

import android.webkit.SafeBrowsingResponse;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import r2.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h extends q2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SafeBrowsingResponse f19227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SafeBrowsingResponseBoundaryInterface f19228b;

    public h(InvocationHandler invocationHandler) {
        this.f19228b = (SafeBrowsingResponseBoundaryInterface) jh.a.a(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    @Override // q2.a
    public void a(boolean z10) {
        a.f fVar = k.f19280z;
        if (fVar.b()) {
            d.a(c(), z10);
        } else {
            if (!fVar.c()) {
                throw k.a();
            }
            b().showInterstitial(z10);
        }
    }

    public final SafeBrowsingResponseBoundaryInterface b() {
        if (this.f19228b == null) {
            this.f19228b = (SafeBrowsingResponseBoundaryInterface) jh.a.a(SafeBrowsingResponseBoundaryInterface.class, l.c().b(this.f19227a));
        }
        return this.f19228b;
    }

    public final SafeBrowsingResponse c() {
        if (this.f19227a == null) {
            this.f19227a = l.c().a(Proxy.getInvocationHandler(this.f19228b));
        }
        return this.f19227a;
    }

    public h(SafeBrowsingResponse safeBrowsingResponse) {
        this.f19227a = safeBrowsingResponse;
    }
}
