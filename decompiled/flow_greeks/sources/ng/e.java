package ng;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17086b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0[] f17087a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a extends d2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f17088h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer$volatile");
        private volatile /* synthetic */ Object _disposer$volatile;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final n f17089e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e1 f17090f;

        public a(n nVar) {
            this.f17089e = nVar;
        }

        public final void A(b bVar) {
            f17088h.set(this, bVar);
        }

        public final void B(e1 e1Var) {
            this.f17090f = e1Var;
        }

        @Override // ng.d2
        public boolean u() {
            return false;
        }

        @Override // ng.d2
        public void v(Throwable th) {
            if (th != null) {
                Object objH = this.f17089e.h(th);
                if (objH != null) {
                    this.f17089e.p(objH);
                    b bVarX = x();
                    if (bVarX != null) {
                        bVarX.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (e.d().decrementAndGet(e.this) == 0) {
                n nVar = this.f17089e;
                u0[] u0VarArr = e.this.f17087a;
                ArrayList arrayList = new ArrayList(u0VarArr.length);
                for (u0 u0Var : u0VarArr) {
                    arrayList.add(u0Var.getCompleted());
                }
                nVar.resumeWith(cd.r.b(arrayList));
            }
        }

        public final b x() {
            return (b) f17088h.get(this);
        }

        public final e1 y() {
            e1 e1Var = this.f17090f;
            if (e1Var != null) {
                return e1Var;
            }
            kotlin.jvm.internal.t.s("handle");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a[] f17092a;

        public b(a[] aVarArr) {
            this.f17092a = aVarArr;
        }

        @Override // ng.m
        public void a(Throwable th) {
            b();
        }

        public final void b() {
            for (a aVar : this.f17092a) {
                aVar.y().dispose();
            }
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f17092a + ']';
        }
    }

    public e(u0[] u0VarArr) {
        this.f17087a = u0VarArr;
        this.notCompletedCount$volatile = u0VarArr.length;
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater d() {
        return f17086b;
    }

    public final Object c(gd.e eVar) {
        p pVar = new p(hd.b.c(eVar), 1);
        pVar.E();
        int length = this.f17087a.length;
        a[] aVarArr = new a[length];
        for (int i10 = 0; i10 < length; i10++) {
            u0 u0Var = this.f17087a[i10];
            u0Var.start();
            a aVar = new a(pVar);
            aVar.B(c2.k(u0Var, false, aVar, 1, null));
            cd.h0 h0Var = cd.h0.f3852a;
            aVarArr[i10] = aVar;
        }
        b bVar = new b(aVarArr);
        for (int i11 = 0; i11 < length; i11++) {
            aVarArr[i11].A(bVar);
        }
        if (pVar.isCompleted()) {
            bVar.b();
        } else {
            r.c(pVar, bVar);
        }
        Object objY = pVar.y();
        if (objY == hd.c.f()) {
            id.h.c(eVar);
        }
        return objY;
    }
}
