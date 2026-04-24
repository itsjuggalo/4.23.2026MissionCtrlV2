package h7;

import B5.o;
import B5.p;
import Y6.InterfaceC1015l;
import Y6.T0;
import a7.l;
import d7.A;
import d7.AbstractC1640a;
import d7.B;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import s5.InterfaceC2711i;
import y.AbstractC2965b;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18729c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "head$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18730d = AtomicLongFieldUpdater.newUpdater(i.class, "deqIdx$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18731e = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "tail$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18732f = AtomicLongFieldUpdater.newUpdater(i.class, "enqIdx$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18733g = AtomicIntegerFieldUpdater.newUpdater(i.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f18735b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public /* synthetic */ class a extends AbstractC2302q implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18736a = new a();

        public a() {
            super(2, j.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // B5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m(((Number) obj).longValue(), (k) obj2);
        }

        public final k m(long j8, k kVar) {
            return j.h(j8, kVar);
        }
    }

    public /* synthetic */ class b extends AbstractC2302q implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f18737a = new b();

        public b() {
            super(2, j.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // B5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m(((Number) obj).longValue(), (k) obj2);
        }

        public final k m(long j8, k kVar) {
            return j.h(j8, kVar);
        }
    }

    public i(int i8, int i9) {
        this.f18734a = i8;
        if (i8 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i8).toString());
        }
        if (i9 < 0 || i9 > i8) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i8).toString());
        }
        k kVar = new k(0L, null, 2);
        this.head$volatile = kVar;
        this.tail$volatile = kVar;
        this._availablePermits$volatile = i8 - i9;
        this.f18735b = new p() { // from class: h7.h
            @Override // B5.p
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return i.p(this.f18728a, (Throwable) obj, (C2470H) obj2, (InterfaceC2711i) obj3);
            }
        };
    }

    public static final C2470H p(i iVar, Throwable th, C2470H c2470h, InterfaceC2711i interfaceC2711i) {
        iVar.q();
        return C2470H.f21956a;
    }

    public final void f(InterfaceC1015l interfaceC1015l) {
        while (i() <= 0) {
            AbstractC2304t.d(interfaceC1015l, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (g((T0) interfaceC1015l)) {
                return;
            }
        }
        interfaceC1015l.q(C2470H.f21956a, this.f18735b);
    }

    public final boolean g(T0 t02) {
        Object objC;
        k kVar = (k) f18731e.get(this);
        long andIncrement = f18732f.getAndIncrement(this);
        a aVar = a.f18736a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18731e;
        long j8 = andIncrement / ((long) j.f18743f);
        loop0: while (true) {
            objC = AbstractC1640a.c(kVar, j8, aVar);
            if (!B.c(objC)) {
                A aB = B.b(objC);
                while (true) {
                    A a8 = (A) atomicReferenceFieldUpdater.get(this);
                    if (a8.f17024c >= aB.f17024c) {
                        break loop0;
                    }
                    if (!aB.u()) {
                        break;
                    }
                    if (AbstractC2965b.a(atomicReferenceFieldUpdater, this, a8, aB)) {
                        if (a8.p()) {
                            a8.n();
                        }
                    } else if (aB.p()) {
                        aB.n();
                    }
                }
            } else {
                break;
            }
        }
        k kVar2 = (k) B.b(objC);
        int i8 = (int) (andIncrement % ((long) j.f18743f));
        if (l.a(kVar2.v(), i8, null, t02)) {
            t02.b(kVar2, i8);
            return true;
        }
        if (!l.a(kVar2.v(), i8, j.f18739b, j.f18740c)) {
            return false;
        }
        if (t02 instanceof InterfaceC1015l) {
            AbstractC2304t.d(t02, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((InterfaceC1015l) t02).q(C2470H.f21956a, this.f18735b);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + t02).toString());
    }

    public final void h() {
        int i8;
        do {
            i8 = f18733g.get(this);
            if (i8 <= this.f18734a) {
                return;
            }
        } while (!f18733g.compareAndSet(this, i8, this.f18734a));
    }

    public final int i() {
        int andDecrement;
        do {
            andDecrement = f18733g.getAndDecrement(this);
        } while (andDecrement > this.f18734a);
        return andDecrement;
    }

    public final int j() {
        return Math.max(f18733g.get(this), 0);
    }

    public final void q() {
        do {
            int andIncrement = f18733g.getAndIncrement(this);
            if (andIncrement >= this.f18734a) {
                h();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f18734a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!t());
    }

    public final boolean r() {
        while (true) {
            int i8 = f18733g.get(this);
            if (i8 > this.f18734a) {
                h();
            } else {
                if (i8 <= 0) {
                    return false;
                }
                if (f18733g.compareAndSet(this, i8, i8 - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean s(Object obj) {
        if (!(obj instanceof InterfaceC1015l)) {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        InterfaceC1015l interfaceC1015l = (InterfaceC1015l) obj;
        Object objI = interfaceC1015l.i(C2470H.f21956a, null, this.f18735b);
        if (objI == null) {
            return false;
        }
        interfaceC1015l.s(objI);
        return true;
    }

    public final boolean t() {
        Object objC;
        k kVar = (k) f18729c.get(this);
        long andIncrement = f18730d.getAndIncrement(this);
        long j8 = andIncrement / ((long) j.f18743f);
        b bVar = b.f18737a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18729c;
        loop0: while (true) {
            objC = AbstractC1640a.c(kVar, j8, bVar);
            if (B.c(objC)) {
                break;
            }
            A aB = B.b(objC);
            while (true) {
                A a8 = (A) atomicReferenceFieldUpdater.get(this);
                if (a8.f17024c >= aB.f17024c) {
                    break loop0;
                }
                if (!aB.u()) {
                    break;
                }
                if (AbstractC2965b.a(atomicReferenceFieldUpdater, this, a8, aB)) {
                    if (a8.p()) {
                        a8.n();
                    }
                } else if (aB.p()) {
                    aB.n();
                }
            }
        }
        k kVar2 = (k) B.b(objC);
        kVar2.c();
        if (kVar2.f17024c > j8) {
            return false;
        }
        int i8 = (int) (andIncrement % ((long) j.f18743f));
        Object andSet = kVar2.v().getAndSet(i8, j.f18739b);
        if (andSet != null) {
            if (andSet == j.f18742e) {
                return false;
            }
            return s(andSet);
        }
        int i9 = j.f18738a;
        for (int i10 = 0; i10 < i9; i10++) {
            if (kVar2.v().get(i8) == j.f18740c) {
                return true;
            }
        }
        return !l.a(kVar2.v(), i8, j.f18739b, j.f18741d);
    }
}
