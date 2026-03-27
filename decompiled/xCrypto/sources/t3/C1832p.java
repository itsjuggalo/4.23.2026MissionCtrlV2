package t3;

import W2.C0739g;
import a3.AbstractC0787c;
import b3.InterfaceC0867e;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t3.InterfaceC1846w0;
import y3.C1956j;

/* JADX INFO: renamed from: t3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1832p extends Y implements InterfaceC1830o, InterfaceC0867e, b1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15023f = AtomicIntegerFieldUpdater.newUpdater(C1832p.class, "_decisionAndIndex");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15024g = AtomicReferenceFieldUpdater.newUpdater(C1832p.class, Object.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15025h = AtomicReferenceFieldUpdater.newUpdater(C1832p.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Z2.e f15026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Z2.i f15027e;

    public C1832p(Z2.e eVar, int i4) {
        super(i4);
        this.f15026d = eVar;
        this.f15027e = eVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = C1808d.f14982a;
    }

    public static /* synthetic */ void L(C1832p c1832p, Object obj, int i4, i3.k kVar, int i5, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i5 & 4) != 0) {
            kVar = null;
        }
        c1832p.K(obj, i4, kVar);
    }

    private final boolean N() {
        int i4;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15023f;
        do {
            i4 = atomicIntegerFieldUpdater.get(this);
            int i5 = i4 >> 29;
            if (i5 != 0) {
                if (i5 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f15023f.compareAndSet(this, i4, 1073741824 + (536870911 & i4)));
        return true;
    }

    private final boolean P() {
        int i4;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15023f;
        do {
            i4 = atomicIntegerFieldUpdater.get(this);
            int i5 = i4 >> 29;
            if (i5 != 0) {
                if (i5 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f15023f.compareAndSet(this, i4, 536870912 + (536870911 & i4)));
        return true;
    }

    public void A() {
        InterfaceC1807c0 interfaceC1807c0B = B();
        if (interfaceC1807c0B != null && isCompleted()) {
            interfaceC1807c0B.dispose();
            f15025h.set(this, K0.f14951a);
        }
    }

    public final InterfaceC1807c0 B() {
        InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) getContext().get(InterfaceC1846w0.f15039M);
        if (interfaceC1846w0 == null) {
            return null;
        }
        InterfaceC1807c0 interfaceC1807c0E = InterfaceC1846w0.a.e(interfaceC1846w0, true, false, new C1839t(this), 2, null);
        androidx.concurrent.futures.b.a(f15025h, this, null, interfaceC1807c0E);
        return interfaceC1807c0E;
    }

    public final void C(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15024g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof C1808d)) {
                if (obj2 instanceof AbstractC1826m ? true : obj2 instanceof y3.C) {
                    F(obj, obj2);
                } else {
                    if (obj2 instanceof C) {
                        C c4 = (C) obj2;
                        if (!c4.b()) {
                            F(obj, obj2);
                        }
                        if (obj2 instanceof C1837s) {
                            if (obj2 == null) {
                                c4 = null;
                            }
                            Throwable th = c4 != null ? c4.f14907a : null;
                            if (obj instanceof AbstractC1826m) {
                                m((AbstractC1826m) obj, th);
                                return;
                            } else {
                                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                q((y3.C) obj, th);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj2 instanceof B) {
                        B b4 = (B) obj2;
                        if (b4.f14902b != null) {
                            F(obj, obj2);
                        }
                        if (obj instanceof y3.C) {
                            return;
                        }
                        kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        AbstractC1826m abstractC1826m = (AbstractC1826m) obj;
                        if (b4.c()) {
                            m(abstractC1826m, b4.f14905e);
                            return;
                        } else {
                            if (androidx.concurrent.futures.b.a(f15024g, this, obj2, B.b(b4, null, abstractC1826m, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (obj instanceof y3.C) {
                            return;
                        }
                        kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (androidx.concurrent.futures.b.a(f15024g, this, obj2, new B(obj2, (AbstractC1826m) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (androidx.concurrent.futures.b.a(f15024g, this, obj2, obj)) {
                return;
            }
        }
    }

    public final boolean D() {
        if (!Z.c(this.f14971c)) {
            return false;
        }
        Z2.e eVar = this.f15026d;
        kotlin.jvm.internal.r.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C1956j) eVar).q();
    }

    public final AbstractC1826m E(i3.k kVar) {
        return kVar instanceof AbstractC1826m ? (AbstractC1826m) kVar : new C1840t0(kVar);
    }

    public final void F(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public String G() {
        return "CancellableContinuation";
    }

    public final void H(Throwable th) {
        if (r(th)) {
            return;
        }
        cancel(th);
        t();
    }

    public final void I() {
        Throwable thT;
        Z2.e eVar = this.f15026d;
        C1956j c1956j = eVar instanceof C1956j ? (C1956j) eVar : null;
        if (c1956j == null || (thT = c1956j.t(this)) == null) {
            return;
        }
        s();
        cancel(thT);
    }

    public final boolean J() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15024g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof B) && ((B) obj).f14904d != null) {
            s();
            return false;
        }
        f15023f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, C1808d.f14982a);
        return true;
    }

    public final void K(Object obj, int i4, i3.k kVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15024g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof L0)) {
                Object obj3 = obj;
                i3.k kVar2 = kVar;
                if (obj2 instanceof C1837s) {
                    C1837s c1837s = (C1837s) obj2;
                    if (c1837s.c()) {
                        if (kVar2 != null) {
                            n(kVar2, c1837s.f14907a);
                            return;
                        }
                        return;
                    }
                }
                l(obj3);
                throw new C0739g();
            }
            Object obj4 = obj;
            int i5 = i4;
            i3.k kVar3 = kVar;
            if (androidx.concurrent.futures.b.a(f15024g, this, obj2, M((L0) obj2, obj4, i5, kVar3, null))) {
                t();
                u(i5);
                return;
            } else {
                obj = obj4;
                i4 = i5;
                kVar = kVar3;
            }
        }
    }

    public final Object M(L0 l02, Object obj, int i4, i3.k kVar, Object obj2) {
        if (obj instanceof C) {
            return obj;
        }
        if ((Z.b(i4) || obj2 != null) && !(kVar == null && !(l02 instanceof AbstractC1826m) && obj2 == null)) {
            return new B(obj, l02 instanceof AbstractC1826m ? (AbstractC1826m) l02 : null, kVar, obj2, null, 16, null);
        }
        return obj;
    }

    public final y3.F O(Object obj, Object obj2, i3.k kVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15024g;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof L0)) {
                Object obj4 = obj2;
                if ((obj3 instanceof B) && obj4 != null && ((B) obj3).f14904d == obj4) {
                    return AbstractC1834q.f15029a;
                }
                return null;
            }
            Object obj5 = obj;
            Object obj6 = obj2;
            i3.k kVar2 = kVar;
            if (androidx.concurrent.futures.b.a(f15024g, this, obj3, M((L0) obj3, obj5, this.f14971c, kVar2, obj6))) {
                t();
                return AbstractC1834q.f15029a;
            }
            obj = obj5;
            kVar = kVar2;
            obj2 = obj6;
        }
    }

    @Override // t3.Y
    public void a(Object obj, Throwable th) {
        Throwable th2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15024g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof L0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof C) {
                return;
            }
            if (obj2 instanceof B) {
                B b4 = (B) obj2;
                if (b4.c()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                Throwable th3 = th;
                th2 = th3;
                if (androidx.concurrent.futures.b.a(f15024g, this, obj2, B.b(b4, null, null, null, null, th3, 15, null))) {
                    b4.d(this, th2);
                    return;
                }
            } else {
                th2 = th;
                if (androidx.concurrent.futures.b.a(f15024g, this, obj2, new B(obj2, null, null, null, th2, 14, null))) {
                    return;
                }
            }
            th = th2;
        }
    }

    @Override // t3.b1
    public void b(y3.C c4, int i4) {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15023f;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            if ((i5 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, ((i5 >> 29) << 29) + i4));
        C(c4);
    }

    @Override // t3.Y
    public final Z2.e c() {
        return this.f15026d;
    }

    @Override // t3.InterfaceC1830o
    public boolean cancel(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15024g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof L0)) {
                return false;
            }
        } while (!androidx.concurrent.futures.b.a(f15024g, this, obj, new C1837s(this, th, (obj instanceof AbstractC1826m) || (obj instanceof y3.C))));
        L0 l02 = (L0) obj;
        if (l02 instanceof AbstractC1826m) {
            m((AbstractC1826m) obj, th);
        } else if (l02 instanceof y3.C) {
            q((y3.C) obj, th);
        }
        t();
        u(this.f14971c);
        return true;
    }

    @Override // t3.Y
    public Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // t3.Y
    public Object e(Object obj) {
        return obj instanceof B ? ((B) obj).f14901a : obj;
    }

    @Override // t3.InterfaceC1830o
    public void g(i3.k kVar) {
        C(E(kVar));
    }

    @Override // b3.InterfaceC0867e
    public InterfaceC0867e getCallerFrame() {
        Z2.e eVar = this.f15026d;
        if (eVar instanceof InterfaceC0867e) {
            return (InterfaceC0867e) eVar;
        }
        return null;
    }

    @Override // Z2.e
    public Z2.i getContext() {
        return this.f15027e;
    }

    @Override // t3.InterfaceC1830o
    public void h(Object obj, i3.k kVar) {
        K(obj, this.f14971c, kVar);
    }

    @Override // t3.InterfaceC1830o
    public Object i(Throwable th) {
        return O(new C(th, false, 2, null), null, null);
    }

    @Override // t3.InterfaceC1830o
    public boolean isCompleted() {
        return !(y() instanceof L0);
    }

    @Override // t3.InterfaceC1830o
    public void j(I i4, Object obj) {
        Z2.e eVar = this.f15026d;
        C1956j c1956j = eVar instanceof C1956j ? (C1956j) eVar : null;
        L(this, obj, (c1956j != null ? c1956j.f15984d : null) == i4 ? 4 : this.f14971c, null, 4, null);
    }

    @Override // t3.Y
    public Object k() {
        return y();
    }

    public final Void l(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void m(AbstractC1826m abstractC1826m, Throwable th) {
        try {
            abstractC1826m.a(th);
        } catch (Throwable th2) {
            K.a(getContext(), new F("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void n(i3.k kVar, Throwable th) {
        try {
            kVar.invoke(th);
        } catch (Throwable th2) {
            K.a(getContext(), new F("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // t3.InterfaceC1830o
    public Object o(Object obj, Object obj2, i3.k kVar) {
        return O(obj, obj2, kVar);
    }

    @Override // t3.InterfaceC1830o
    public void p(Object obj) {
        u(this.f14971c);
    }

    public final void q(y3.C c4, Throwable th) {
        int i4 = f15023f.get(this) & 536870911;
        if (i4 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            c4.o(i4, th, getContext());
        } catch (Throwable th2) {
            K.a(getContext(), new F("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final boolean r(Throwable th) {
        if (!D()) {
            return false;
        }
        Z2.e eVar = this.f15026d;
        kotlin.jvm.internal.r.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C1956j) eVar).r(th);
    }

    @Override // Z2.e
    public void resumeWith(Object obj) {
        L(this, G.c(obj, this), this.f14971c, null, 4, null);
    }

    public final void s() {
        InterfaceC1807c0 interfaceC1807c0W = w();
        if (interfaceC1807c0W == null) {
            return;
        }
        interfaceC1807c0W.dispose();
        f15025h.set(this, K0.f14951a);
    }

    public final void t() {
        if (D()) {
            return;
        }
        s();
    }

    public String toString() {
        return G() + '(' + P.c(this.f15026d) + "){" + z() + "}@" + P.b(this);
    }

    public final void u(int i4) {
        if (N()) {
            return;
        }
        Z.a(this, i4);
    }

    public Throwable v(InterfaceC1846w0 interfaceC1846w0) {
        return interfaceC1846w0.getCancellationException();
    }

    public final InterfaceC1807c0 w() {
        return (InterfaceC1807c0) f15025h.get(this);
    }

    public final Object x() {
        InterfaceC1846w0 interfaceC1846w0;
        boolean zD = D();
        if (P()) {
            if (w() == null) {
                B();
            }
            if (zD) {
                I();
            }
            return AbstractC0787c.e();
        }
        if (zD) {
            I();
        }
        Object objY = y();
        if (objY instanceof C) {
            throw ((C) objY).f14907a;
        }
        if (!Z.b(this.f14971c) || (interfaceC1846w0 = (InterfaceC1846w0) getContext().get(InterfaceC1846w0.f15039M)) == null || interfaceC1846w0.isActive()) {
            return e(objY);
        }
        CancellationException cancellationException = interfaceC1846w0.getCancellationException();
        a(objY, cancellationException);
        throw cancellationException;
    }

    public final Object y() {
        return f15024g.get(this);
    }

    public final String z() {
        Object objY = y();
        return objY instanceof L0 ? "Active" : objY instanceof C1837s ? "Cancelled" : "Completed";
    }
}
