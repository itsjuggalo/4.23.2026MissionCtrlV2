package ac;

import java.util.concurrent.ScheduledExecutorService;
import rb.o1;
import rb.p;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends r0.e {
    @Override // rb.r0.e
    public r0.i a(r0.b bVar) {
        return g().a(bVar);
    }

    @Override // rb.r0.e
    public rb.f b() {
        return g().b();
    }

    @Override // rb.r0.e
    public ScheduledExecutorService c() {
        return g().c();
    }

    @Override // rb.r0.e
    public o1 d() {
        return g().d();
    }

    @Override // rb.r0.e
    public void e() {
        g().e();
    }

    @Override // rb.r0.e
    public void f(p pVar, r0.j jVar) {
        g().f(pVar, jVar);
    }

    public abstract r0.e g();

    public String toString() {
        return p6.h.b(this).d("delegate", g()).toString();
    }
}
