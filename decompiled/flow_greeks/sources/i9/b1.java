package i9;

import i9.q0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends h1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m1 f11875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11876k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v0 f11868c = new v0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f11869d = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w0 f11871f = new w0();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d1 f11872g = new d1(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s0 f11873h = new s0();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c1 f11874i = new c1();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f11870e = new HashMap();

    public static b1 o() {
        b1 b1Var = new b1();
        b1Var.u(new u0(b1Var));
        return b1Var;
    }

    public static b1 p(q0.b bVar, p pVar) {
        b1 b1Var = new b1();
        b1Var.u(new y0(b1Var, bVar, pVar));
        return b1Var;
    }

    @Override // i9.h1
    public a a() {
        return this.f11873h;
    }

    @Override // i9.h1
    public b b(e9.j jVar) {
        t0 t0Var = (t0) this.f11870e.get(jVar);
        if (t0Var != null) {
            return t0Var;
        }
        t0 t0Var2 = new t0();
        this.f11870e.put(jVar, t0Var2);
        return t0Var2;
    }

    @Override // i9.h1
    public g c() {
        return this.f11868c;
    }

    @Override // i9.h1
    public e1 e(e9.j jVar, m mVar) {
        z0 z0Var = (z0) this.f11869d.get(jVar);
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0Var2 = new z0(this, jVar);
        this.f11869d.put(jVar, z0Var2);
        return z0Var2;
    }

    @Override // i9.h1
    public f1 f() {
        return new a1();
    }

    @Override // i9.h1
    public m1 g() {
        return this.f11875j;
    }

    @Override // i9.h1
    public boolean j() {
        return this.f11876k;
    }

    @Override // i9.h1
    public Object k(String str, n9.y yVar) {
        this.f11875j.g();
        try {
            return yVar.get();
        } finally {
            this.f11875j.onTransactionCommitted();
        }
    }

    @Override // i9.h1
    public void l(String str, Runnable runnable) {
        this.f11875j.g();
        try {
            runnable.run();
        } finally {
            this.f11875j.onTransactionCommitted();
        }
    }

    @Override // i9.h1
    public void m() {
        n9.b.d(this.f11876k, "MemoryPersistence shutdown without start", new Object[0]);
        this.f11876k = false;
    }

    @Override // i9.h1
    public void n() {
        n9.b.d(!this.f11876k, "MemoryPersistence double-started!", new Object[0]);
        this.f11876k = true;
    }

    @Override // i9.h1
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public w0 d(e9.j jVar) {
        return this.f11871f;
    }

    public Iterable r() {
        return this.f11869d.values();
    }

    @Override // i9.h1
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public c1 h() {
        return this.f11874i;
    }

    @Override // i9.h1
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public d1 i() {
        return this.f11872g;
    }

    public final void u(m1 m1Var) {
        this.f11875j = m1Var;
    }
}
