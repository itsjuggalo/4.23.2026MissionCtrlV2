package j8;

import java.util.concurrent.atomic.AtomicBoolean;
import o8.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f14009b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f14008a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14010c = false;

    public abstract i a(o8.i iVar);

    public abstract o8.d b(o8.c cVar, o8.i iVar);

    public abstract void c(e8.c cVar);

    public abstract void d(o8.d dVar);

    public abstract o8.i e();

    public abstract boolean f(i iVar);

    public boolean g() {
        return this.f14010c;
    }

    public boolean h() {
        return this.f14008a.get();
    }

    public abstract boolean i(e.a aVar);

    public void j(boolean z10) {
        this.f14010c = z10;
    }

    public void k(j jVar) {
        m8.m.f(!h());
        m8.m.f(this.f14009b == null);
        this.f14009b = jVar;
    }

    public void l() {
        j jVar;
        if (!this.f14008a.compareAndSet(false, true) || (jVar = this.f14009b) == null) {
            return;
        }
        jVar.a(this);
        this.f14009b = null;
    }
}
