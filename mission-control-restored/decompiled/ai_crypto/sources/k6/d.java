package k6;

import E5.E;
import Q5.k;
import b6.InterfaceC1085o;
import b6.b1;
import d6.i;
import g6.AbstractC1644d;
import g6.C;
import g6.D;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import v.AbstractC2759b;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f18228c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "head");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f18229d = AtomicLongFieldUpdater.newUpdater(d.class, "deqIdx");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f18230e = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "tail");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f18231f = AtomicLongFieldUpdater.newUpdater(d.class, "enqIdx");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f18232g = AtomicIntegerFieldUpdater.newUpdater(d.class, "_availablePermits");
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f18234b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    public /* synthetic */ class a extends o implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18235a = new a();

        public a() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f e(long j7, f fVar) {
            return e.h(j7, fVar);
        }

        @Override // Q5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return e(((Number) obj).longValue(), (f) obj2);
        }
    }

    public static final class b extends s implements k {
        public b() {
            super(1);
        }

        public final void a(Throwable th) {
            d.this.j();
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E.f1657a;
        }
    }

    public /* synthetic */ class c extends o implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f18237a = new c();

        public c() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f e(long j7, f fVar) {
            return e.h(j7, fVar);
        }

        @Override // Q5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return e(((Number) obj).longValue(), (f) obj2);
        }
    }

    public d(int i7, int i8) {
        this.f18233a = i7;
        if (i7 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i7).toString());
        }
        if (i8 < 0 || i8 > i7) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i7).toString());
        }
        f fVar = new f(0L, null, 2);
        this.head = fVar;
        this.tail = fVar;
        this._availablePermits = i7 - i8;
        this.f18234b = new b();
    }

    public final void e(InterfaceC1085o interfaceC1085o) {
        while (h() <= 0) {
            r.d(interfaceC1085o, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (f((b1) interfaceC1085o)) {
                return;
            }
        }
        interfaceC1085o.c(E.f1657a, this.f18234b);
    }

    public final boolean f(b1 b1Var) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18230e;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f18231f.getAndIncrement(this);
        a aVar = a.f18235a;
        long j7 = andIncrement / ((long) e.f18243f);
        loop0: while (true) {
            objC = AbstractC1644d.c(fVar, j7, aVar);
            if (!D.c(objC)) {
                C cB = D.b(objC);
                while (true) {
                    C c7 = (C) atomicReferenceFieldUpdater.get(this);
                    if (c7.f14269c >= cB.f14269c) {
                        break loop0;
                    }
                    if (!cB.q()) {
                        break;
                    }
                    if (AbstractC2759b.a(atomicReferenceFieldUpdater, this, c7, cB)) {
                        if (c7.m()) {
                            c7.k();
                        }
                    } else if (cB.m()) {
                        cB.k();
                    }
                }
            } else {
                break;
            }
        }
        f fVar2 = (f) D.b(objC);
        int i7 = (int) (andIncrement % ((long) e.f18243f));
        if (i.a(fVar2.r(), i7, null, b1Var)) {
            b1Var.a(fVar2, i7);
            return true;
        }
        if (!i.a(fVar2.r(), i7, e.f18239b, e.f18240c)) {
            return false;
        }
        if (b1Var instanceof InterfaceC1085o) {
            r.d(b1Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((InterfaceC1085o) b1Var).c(E.f1657a, this.f18234b);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + b1Var).toString());
    }

    public final void g() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i7;
        int i8;
        do {
            atomicIntegerFieldUpdater = f18232g;
            i7 = atomicIntegerFieldUpdater.get(this);
            i8 = this.f18233a;
            if (i7 <= i8) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i7, i8));
    }

    public final int h() {
        int andDecrement;
        do {
            andDecrement = f18232g.getAndDecrement(this);
        } while (andDecrement > this.f18233a);
        return andDecrement;
    }

    public int i() {
        return Math.max(f18232g.get(this), 0);
    }

    public void j() {
        do {
            int andIncrement = f18232g.getAndIncrement(this);
            if (andIncrement >= this.f18233a) {
                g();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f18233a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!m());
    }

    public boolean k() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f18232g;
            int i7 = atomicIntegerFieldUpdater.get(this);
            if (i7 > this.f18233a) {
                g();
            } else {
                if (i7 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i7, i7 - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean l(Object obj) {
        if (!(obj instanceof InterfaceC1085o)) {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        InterfaceC1085o interfaceC1085o = (InterfaceC1085o) obj;
        Object objE = interfaceC1085o.e(E.f1657a, null, this.f18234b);
        if (objE == null) {
            return false;
        }
        interfaceC1085o.n(objE);
        return true;
    }

    public final boolean m() {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18228c;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f18229d.getAndIncrement(this);
        long j7 = andIncrement / ((long) e.f18243f);
        c cVar = c.f18237a;
        loop0: while (true) {
            objC = AbstractC1644d.c(fVar, j7, cVar);
            if (D.c(objC)) {
                break;
            }
            C cB = D.b(objC);
            while (true) {
                C c7 = (C) atomicReferenceFieldUpdater.get(this);
                if (c7.f14269c >= cB.f14269c) {
                    break loop0;
                }
                if (!cB.q()) {
                    break;
                }
                if (AbstractC2759b.a(atomicReferenceFieldUpdater, this, c7, cB)) {
                    if (c7.m()) {
                        c7.k();
                    }
                } else if (cB.m()) {
                    cB.k();
                }
            }
        }
        f fVar2 = (f) D.b(objC);
        fVar2.b();
        if (fVar2.f14269c > j7) {
            return false;
        }
        int i7 = (int) (andIncrement % ((long) e.f18243f));
        Object andSet = fVar2.r().getAndSet(i7, e.f18239b);
        if (andSet != null) {
            if (andSet == e.f18242e) {
                return false;
            }
            return l(andSet);
        }
        int i8 = e.f18238a;
        for (int i9 = 0; i9 < i8; i9++) {
            if (fVar2.r().get(i7) == e.f18240c) {
                return true;
            }
        }
        return !i.a(fVar2.r(), i7, e.f18239b, e.f18241d);
    }
}
