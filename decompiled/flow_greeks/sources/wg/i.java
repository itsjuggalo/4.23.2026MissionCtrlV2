package wg;

import cd.h0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import ng.c3;
import ng.n;
import pd.o;
import pd.p;
import pg.l;
import sg.a0;
import sg.b0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f24104c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "head$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f24105d = AtomicLongFieldUpdater.newUpdater(i.class, "deqIdx$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f24106e = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "tail$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f24107f = AtomicLongFieldUpdater.newUpdater(i.class, "enqIdx$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f24108g = AtomicIntegerFieldUpdater.newUpdater(i.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f24110b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends q implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24111a = new a();

        public a() {
            super(2, j.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // pd.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return o(((Number) obj).longValue(), (k) obj2);
        }

        public final k o(long j10, k kVar) {
            return j.h(j10, kVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b extends q implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f24112a = new b();

        public b() {
            super(2, j.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // pd.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return o(((Number) obj).longValue(), (k) obj2);
        }

        public final k o(long j10, k kVar) {
            return j.h(j10, kVar);
        }
    }

    public i(int i10, int i11) {
        this.f24109a = i10;
        if (i10 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i10).toString());
        }
        if (i11 < 0 || i11 > i10) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i10).toString());
        }
        k kVar = new k(0L, null, 2);
        this.head$volatile = kVar;
        this.tail$volatile = kVar;
        this._availablePermits$volatile = i10 - i11;
        this.f24110b = new p() { // from class: wg.h
            @Override // pd.p
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return i.p(this.f24103a, (Throwable) obj, (h0) obj2, (gd.i) obj3);
            }
        };
    }

    public static final h0 p(i iVar, Throwable th, h0 h0Var, gd.i iVar2) {
        iVar.q();
        return h0.f3852a;
    }

    public final void f(n nVar) {
        while (i() <= 0) {
            t.d(nVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (g((c3) nVar)) {
                return;
            }
        }
        nVar.c(h0.f3852a, this.f24110b);
    }

    public final boolean g(c3 c3Var) {
        Object objC;
        k kVar = (k) f24106e.get(this);
        long andIncrement = f24107f.getAndIncrement(this);
        a aVar = a.f24111a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f24106e;
        long j10 = andIncrement / ((long) j.f24118f);
        loop0: while (true) {
            objC = sg.a.c(kVar, j10, aVar);
            if (!b0.c(objC)) {
                a0 a0VarB = b0.b(objC);
                while (true) {
                    a0 a0Var = (a0) atomicReferenceFieldUpdater.get(this);
                    if (a0Var.f20378c >= a0VarB.f20378c) {
                        break loop0;
                    }
                    if (!a0VarB.u()) {
                        break;
                    }
                    if (y.b.a(atomicReferenceFieldUpdater, this, a0Var, a0VarB)) {
                        if (a0Var.p()) {
                            a0Var.n();
                        }
                    } else if (a0VarB.p()) {
                        a0VarB.n();
                    }
                }
            } else {
                break;
            }
        }
        k kVar2 = (k) b0.b(objC);
        int i10 = (int) (andIncrement % ((long) j.f24118f));
        if (l.a(kVar2.v(), i10, null, c3Var)) {
            c3Var.b(kVar2, i10);
            return true;
        }
        if (!l.a(kVar2.v(), i10, j.f24114b, j.f24115c)) {
            return false;
        }
        if (c3Var instanceof n) {
            t.d(c3Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((n) c3Var).c(h0.f3852a, this.f24110b);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + c3Var).toString());
    }

    public final void h() {
        int i10;
        do {
            i10 = f24108g.get(this);
            if (i10 <= this.f24109a) {
                return;
            }
        } while (!f24108g.compareAndSet(this, i10, this.f24109a));
    }

    public final int i() {
        int andDecrement;
        do {
            andDecrement = f24108g.getAndDecrement(this);
        } while (andDecrement > this.f24109a);
        return andDecrement;
    }

    public final int j() {
        return Math.max(f24108g.get(this), 0);
    }

    public final void q() {
        do {
            int andIncrement = f24108g.getAndIncrement(this);
            if (andIncrement >= this.f24109a) {
                h();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f24109a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!t());
    }

    public final boolean r() {
        while (true) {
            int i10 = f24108g.get(this);
            if (i10 > this.f24109a) {
                h();
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (f24108g.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean s(Object obj) {
        if (!(obj instanceof n)) {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        n nVar = (n) obj;
        Object objK = nVar.k(h0.f3852a, null, this.f24110b);
        if (objK == null) {
            return false;
        }
        nVar.p(objK);
        return true;
    }

    public final boolean t() {
        Object objC;
        k kVar = (k) f24104c.get(this);
        long andIncrement = f24105d.getAndIncrement(this);
        long j10 = andIncrement / ((long) j.f24118f);
        b bVar = b.f24112a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f24104c;
        loop0: while (true) {
            objC = sg.a.c(kVar, j10, bVar);
            if (b0.c(objC)) {
                break;
            }
            a0 a0VarB = b0.b(objC);
            while (true) {
                a0 a0Var = (a0) atomicReferenceFieldUpdater.get(this);
                if (a0Var.f20378c >= a0VarB.f20378c) {
                    break loop0;
                }
                if (!a0VarB.u()) {
                    break;
                }
                if (y.b.a(atomicReferenceFieldUpdater, this, a0Var, a0VarB)) {
                    if (a0Var.p()) {
                        a0Var.n();
                    }
                } else if (a0VarB.p()) {
                    a0VarB.n();
                }
            }
        }
        k kVar2 = (k) b0.b(objC);
        kVar2.c();
        if (kVar2.f20378c > j10) {
            return false;
        }
        int i10 = (int) (andIncrement % ((long) j.f24118f));
        Object andSet = kVar2.v().getAndSet(i10, j.f24114b);
        if (andSet != null) {
            if (andSet == j.f24117e) {
                return false;
            }
            return s(andSet);
        }
        int i11 = j.f24113a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (kVar2.v().get(i10) == j.f24115c) {
                return true;
            }
        }
        return !l.a(kVar2.v(), i10, j.f24114b, j.f24116d);
    }
}
