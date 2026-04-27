package T2;

import K2.AbstractC0358f;
import K2.EnumC0368p;
import K2.S;
import K2.p0;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends S.e {
    @Override // K2.S.e
    public S.i a(S.b bVar) {
        return g().a(bVar);
    }

    @Override // K2.S.e
    public AbstractC0358f b() {
        return g().b();
    }

    @Override // K2.S.e
    public ScheduledExecutorService c() {
        return g().c();
    }

    @Override // K2.S.e
    public p0 d() {
        return g().d();
    }

    @Override // K2.S.e
    public void e() {
        g().e();
    }

    @Override // K2.S.e
    public void f(EnumC0368p enumC0368p, S.j jVar) {
        g().f(enumC0368p, jVar);
    }

    public abstract S.e g();

    public String toString() {
        return Z1.g.b(this).d("delegate", g()).toString();
    }
}
