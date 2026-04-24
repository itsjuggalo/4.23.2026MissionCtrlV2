package N4;

import F4.AbstractC0492f;
import F4.EnumC0502p;
import F4.P;
import F4.n0;
import java.util.concurrent.ScheduledExecutorService;
import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends P.e {
    @Override // F4.P.e
    public P.i a(P.b bVar) {
        return g().a(bVar);
    }

    @Override // F4.P.e
    public AbstractC0492f b() {
        return g().b();
    }

    @Override // F4.P.e
    public ScheduledExecutorService c() {
        return g().c();
    }

    @Override // F4.P.e
    public n0 d() {
        return g().d();
    }

    @Override // F4.P.e
    public void e() {
        g().e();
    }

    @Override // F4.P.e
    public void f(EnumC0502p enumC0502p, P.j jVar) {
        g().f(enumC0502p, jVar);
    }

    public abstract P.e g();

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", g()).toString();
    }
}
