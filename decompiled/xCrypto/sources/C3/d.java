package C3;

import W2.E;
import i3.k;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import t3.InterfaceC1830o;
import t3.b1;
import v3.i;
import y3.AbstractC1950d;
import y3.C;
import y3.D;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f270c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "head");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f271d = AtomicLongFieldUpdater.newUpdater(d.class, "deqIdx");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f272e = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "tail");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f273f = AtomicLongFieldUpdater.newUpdater(d.class, "enqIdx");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f274g = AtomicIntegerFieldUpdater.newUpdater(d.class, "_availablePermits");
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f276b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    public /* synthetic */ class a extends o implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f277a = new a();

        public a() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f d(long j4, f fVar) {
            return e.h(j4, fVar);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return d(((Number) obj).longValue(), (f) obj2);
        }
    }

    public static final class b extends s implements k {
        public b() {
            super(1);
        }

        public final void a(Throwable th) {
            d.this.j();
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E.f5463a;
        }
    }

    public /* synthetic */ class c extends o implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f279a = new c();

        public c() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f d(long j4, f fVar) {
            return e.h(j4, fVar);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return d(((Number) obj).longValue(), (f) obj2);
        }
    }

    public d(int i4, int i5) {
        this.f275a = i4;
        if (i4 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i4).toString());
        }
        if (i5 < 0 || i5 > i4) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i4).toString());
        }
        f fVar = new f(0L, null, 2);
        this.head = fVar;
        this.tail = fVar;
        this._availablePermits = i4 - i5;
        this.f276b = new b();
    }

    public final void e(InterfaceC1830o interfaceC1830o) {
        while (h() <= 0) {
            r.d(interfaceC1830o, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (f((b1) interfaceC1830o)) {
                return;
            }
        }
        interfaceC1830o.h(E.f5463a, this.f276b);
    }

    public final boolean f(b1 b1Var) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f272e;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f273f.getAndIncrement(this);
        a aVar = a.f277a;
        long j4 = andIncrement / ((long) e.f285f);
        loop0: while (true) {
            objC = AbstractC1950d.c(fVar, j4, aVar);
            if (!D.c(objC)) {
                C cB = D.b(objC);
                while (true) {
                    C c4 = (C) atomicReferenceFieldUpdater.get(this);
                    if (c4.f15955c >= cB.f15955c) {
                        break loop0;
                    }
                    if (!cB.q()) {
                        break;
                    }
                    if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, c4, cB)) {
                        if (c4.m()) {
                            c4.k();
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
        int i4 = (int) (andIncrement % ((long) e.f285f));
        if (i.a(fVar2.r(), i4, null, b1Var)) {
            b1Var.b(fVar2, i4);
            return true;
        }
        if (!i.a(fVar2.r(), i4, e.f281b, e.f282c)) {
            return false;
        }
        if (b1Var instanceof InterfaceC1830o) {
            r.d(b1Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((InterfaceC1830o) b1Var).h(E.f5463a, this.f276b);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + b1Var).toString());
    }

    public final void g() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i4;
        int i5;
        do {
            atomicIntegerFieldUpdater = f274g;
            i4 = atomicIntegerFieldUpdater.get(this);
            i5 = this.f275a;
            if (i4 <= i5) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, i5));
    }

    public final int h() {
        int andDecrement;
        do {
            andDecrement = f274g.getAndDecrement(this);
        } while (andDecrement > this.f275a);
        return andDecrement;
    }

    public int i() {
        return Math.max(f274g.get(this), 0);
    }

    public void j() {
        do {
            int andIncrement = f274g.getAndIncrement(this);
            if (andIncrement >= this.f275a) {
                g();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f275a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!m());
    }

    public boolean k() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f274g;
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 > this.f275a) {
                g();
            } else {
                if (i4 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i4, i4 - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean l(Object obj) {
        if (!(obj instanceof InterfaceC1830o)) {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        InterfaceC1830o interfaceC1830o = (InterfaceC1830o) obj;
        Object objO = interfaceC1830o.o(E.f5463a, null, this.f276b);
        if (objO == null) {
            return false;
        }
        interfaceC1830o.p(objO);
        return true;
    }

    public final boolean m() {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f270c;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f271d.getAndIncrement(this);
        long j4 = andIncrement / ((long) e.f285f);
        c cVar = c.f279a;
        loop0: while (true) {
            objC = AbstractC1950d.c(fVar, j4, cVar);
            if (D.c(objC)) {
                break;
            }
            C cB = D.b(objC);
            while (true) {
                C c4 = (C) atomicReferenceFieldUpdater.get(this);
                if (c4.f15955c >= cB.f15955c) {
                    break loop0;
                }
                if (!cB.q()) {
                    break;
                }
                if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, c4, cB)) {
                    if (c4.m()) {
                        c4.k();
                    }
                } else if (cB.m()) {
                    cB.k();
                }
            }
        }
        f fVar2 = (f) D.b(objC);
        fVar2.b();
        if (fVar2.f15955c > j4) {
            return false;
        }
        int i4 = (int) (andIncrement % ((long) e.f285f));
        Object andSet = fVar2.r().getAndSet(i4, e.f281b);
        if (andSet != null) {
            if (andSet == e.f284e) {
                return false;
            }
            return l(andSet);
        }
        int i5 = e.f280a;
        for (int i6 = 0; i6 < i5; i6++) {
            if (fVar2.r().get(i4) == e.f282c) {
                return true;
            }
        }
        return !i.a(fVar2.r(), i4, e.f281b, e.f283d);
    }
}
