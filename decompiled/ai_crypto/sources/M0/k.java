package M0;

import M0.a;
import android.webkit.SafeBrowsingResponse;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class k extends L0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SafeBrowsingResponse f3730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SafeBrowsingResponseBoundaryInterface f3731b;

    public k(InvocationHandler invocationHandler) {
        this.f3731b = (SafeBrowsingResponseBoundaryInterface) A6.a.a(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    @Override // L0.a
    public void a(boolean z7) {
        a.f fVar = n.f3797z;
        if (fVar.c()) {
            f.a(c(), z7);
        } else {
            if (!fVar.d()) {
                throw n.a();
            }
            b().showInterstitial(z7);
        }
    }

    public final SafeBrowsingResponseBoundaryInterface b() {
        if (this.f3731b == null) {
            this.f3731b = (SafeBrowsingResponseBoundaryInterface) A6.a.a(SafeBrowsingResponseBoundaryInterface.class, o.c().b(this.f3730a));
        }
        return this.f3731b;
    }

    public final SafeBrowsingResponse c() {
        if (this.f3730a == null) {
            this.f3730a = o.c().a(Proxy.getInvocationHandler(this.f3731b));
        }
        return this.f3730a;
    }

    public k(SafeBrowsingResponse safeBrowsingResponse) {
        this.f3730a = safeBrowsingResponse;
    }
}
