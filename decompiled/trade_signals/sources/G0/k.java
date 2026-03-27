package G0;

import G0.a;
import android.webkit.SafeBrowsingResponse;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class k extends F0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SafeBrowsingResponse f2015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SafeBrowsingResponseBoundaryInterface f2016b;

    public k(SafeBrowsingResponse safeBrowsingResponse) {
        this.f2015a = safeBrowsingResponse;
    }

    @Override // F0.a
    public void a(boolean z7) {
        a.f fVar = n.f2082z;
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
        if (this.f2016b == null) {
            this.f2016b = (SafeBrowsingResponseBoundaryInterface) w7.a.a(SafeBrowsingResponseBoundaryInterface.class, o.c().b(this.f2015a));
        }
        return this.f2016b;
    }

    public final SafeBrowsingResponse c() {
        if (this.f2015a == null) {
            this.f2015a = o.c().a(Proxy.getInvocationHandler(this.f2016b));
        }
        return this.f2015a;
    }

    public k(InvocationHandler invocationHandler) {
        this.f2016b = (SafeBrowsingResponseBoundaryInterface) w7.a.a(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }
}
