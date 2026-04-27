package A5;

import java.util.concurrent.ScheduledExecutorService;
import r5.AbstractC2590f;
import r5.EnumC2600p;
import r5.S;
import r5.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends S.e {
    @Override // r5.S.e
    public S.i a(S.b bVar) {
        return g().a(bVar);
    }

    @Override // r5.S.e
    public AbstractC2590f b() {
        return g().b();
    }

    @Override // r5.S.e
    public ScheduledExecutorService c() {
        return g().c();
    }

    @Override // r5.S.e
    public p0 d() {
        return g().d();
    }

    @Override // r5.S.e
    public void e() {
        g().e();
    }

    @Override // r5.S.e
    public void f(EnumC2600p enumC2600p, S.j jVar) {
        g().f(enumC2600p, jVar);
    }

    public abstract S.e g();

    public String toString() {
        return H2.g.b(this).d("delegate", g()).toString();
    }
}
