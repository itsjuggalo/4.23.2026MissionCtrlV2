package wg;

import cd.h0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ng.c3;
import ng.k0;
import ng.n;
import ng.r;
import ng.r0;
import pd.p;
import sg.a0;
import wg.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class f extends i implements wg.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f24096i = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "owner$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f24097h;
    private volatile /* synthetic */ Object owner$volatile;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a implements n, c3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ng.p f24098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f24099b;

        public a(ng.p pVar, Object obj) {
            this.f24098a = pVar;
            this.f24099b = obj;
        }

        public static final h0 g(f fVar, a aVar, Throwable th) {
            fVar.c(aVar.f24099b);
            return h0.f3852a;
        }

        public static final h0 m(f fVar, a aVar, Throwable th, h0 h0Var, gd.i iVar) {
            f.x().set(fVar, aVar.f24099b);
            fVar.c(aVar.f24099b);
            return h0.f3852a;
        }

        @Override // ng.c3
        public void b(a0 a0Var, int i10) {
            this.f24098a.b(a0Var, i10);
        }

        @Override // ng.n
        public boolean cancel(Throwable th) {
            return this.f24098a.cancel(th);
        }

        @Override // ng.n
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(h0 h0Var, p pVar) {
            f.x().set(f.this, this.f24099b);
            ng.p pVar2 = this.f24098a;
            final f fVar = f.this;
            pVar2.O(h0Var, new pd.k() { // from class: wg.e
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return f.a.g(fVar, this, (Throwable) obj);
                }
            });
        }

        @Override // ng.n
        public void f(pd.k kVar) {
            this.f24098a.f(kVar);
        }

        @Override // gd.e
        public gd.i getContext() {
            return this.f24098a.getContext();
        }

        @Override // ng.n
        public Object h(Throwable th) {
            return this.f24098a.h(th);
        }

        @Override // ng.n
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void j(k0 k0Var, h0 h0Var) {
            this.f24098a.j(k0Var, h0Var);
        }

        @Override // ng.n
        public boolean isCompleted() {
            return this.f24098a.isCompleted();
        }

        @Override // ng.n
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Object k(h0 h0Var, Object obj, p pVar) {
            final f fVar = f.this;
            Object objK = this.f24098a.k(h0Var, obj, new p() { // from class: wg.d
                @Override // pd.p
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return f.a.m(fVar, this, (Throwable) obj2, (h0) obj3, (gd.i) obj4);
                }
            });
            if (objK != null) {
                f.x().set(f.this, this.f24099b);
            }
            return objK;
        }

        @Override // ng.n
        public void p(Object obj) {
            this.f24098a.p(obj);
        }

        @Override // gd.e
        public void resumeWith(Object obj) {
            this.f24098a.resumeWith(obj);
        }
    }

    public f(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner$volatile = z10 ? null : g.f24101a;
        this.f24097h = new p() { // from class: wg.b
            @Override // pd.p
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                f fVar = this.f24089a;
                android.support.v4.media.session.b.a(obj);
                return f.B(fVar, null, obj2, obj3);
            }
        };
    }

    public static final p B(final f fVar, vg.e eVar, final Object obj, Object obj2) {
        return new p() { // from class: wg.c
            @Override // pd.p
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return f.C(this.f24090a, obj, (Throwable) obj3, obj4, (gd.i) obj5);
            }
        };
    }

    public static final h0 C(f fVar, Object obj, Throwable th, Object obj2, gd.i iVar) {
        fVar.c(obj);
        return h0.f3852a;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater x() {
        return f24096i;
    }

    public static /* synthetic */ Object z(f fVar, Object obj, gd.e eVar) {
        if (fVar.a(obj)) {
            return h0.f3852a;
        }
        Object objA = fVar.A(obj, eVar);
        return objA == hd.c.f() ? objA : h0.f3852a;
    }

    public final Object A(Object obj, gd.e eVar) {
        ng.p pVarB = r.b(hd.b.c(eVar));
        try {
            f(new a(pVarB, obj));
            Object objY = pVarB.y();
            if (objY == hd.c.f()) {
                id.h.c(eVar);
            }
            return objY == hd.c.f() ? objY : h0.f3852a;
        } catch (Throwable th) {
            pVarB.M();
            throw th;
        }
    }

    public final int D(Object obj) {
        while (!r()) {
            if (obj == null) {
                return 1;
            }
            int iY = y(obj);
            if (iY == 1) {
                return 2;
            }
            if (iY == 2) {
                return 1;
            }
        }
        f24096i.set(this, obj);
        return 0;
    }

    @Override // wg.a
    public boolean a(Object obj) {
        int iD = D(obj);
        if (iD == 0) {
            return true;
        }
        if (iD == 1) {
            return false;
        }
        if (iD != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // wg.a
    public boolean b() {
        return j() == 0;
    }

    @Override // wg.a
    public void c(Object obj) {
        while (b()) {
            Object obj2 = f24096i.get(this);
            if (obj2 != g.f24101a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (y.b.a(f24096i, this, obj2, g.f24101a)) {
                    q();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    @Override // wg.a
    public Object d(Object obj, gd.e eVar) {
        return z(this, obj, eVar);
    }

    public String toString() {
        return "Mutex@" + r0.b(this) + "[isLocked=" + b() + ",owner=" + f24096i.get(this) + ']';
    }

    public final int y(Object obj) {
        while (b()) {
            Object obj2 = f24096i.get(this);
            if (obj2 != g.f24101a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }
}
