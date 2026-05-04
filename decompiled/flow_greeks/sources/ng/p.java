package ng;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ng.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class p extends z0 implements n, id.e, c3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17162f = AtomicIntegerFieldUpdater.newUpdater(p.class, "_decisionAndIndex$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17163g = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17164h = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gd.e f17165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gd.i f17166e;

    public p(gd.e eVar, int i10) {
        super(i10);
        this.f17165d = eVar;
        this.f17166e = eVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = d.f17082a;
    }

    public static final cd.h0 P(pd.k kVar, Throwable th, Object obj, gd.i iVar) {
        kVar.invoke(th);
        return cd.h0.f3852a;
    }

    public static /* synthetic */ void R(p pVar, Object obj, int i10, pd.p pVar2, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            pVar2 = null;
        }
        pVar.Q(obj, i10, pVar2);
    }

    private final boolean T() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17162f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f17162f.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
        return true;
    }

    private final boolean V() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17162f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f17162f.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        return true;
    }

    public final String A() {
        Object objZ = z();
        return objZ instanceof m2 ? "Active" : objZ instanceof s ? "Cancelled" : "Completed";
    }

    public void E() {
        e1 e1VarF = F();
        if (e1VarF != null && isCompleted()) {
            e1VarF.dispose();
            f17164h.set(this, l2.f17156a);
        }
    }

    public final e1 F() {
        y1 y1Var = (y1) getContext().get(y1.N);
        if (y1Var == null) {
            return null;
        }
        e1 e1VarK = c2.k(y1Var, false, new t(this), 1, null);
        y.b.a(f17164h, this, null, e1VarK);
        return e1VarK;
    }

    public final void G(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17163g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof d) {
                if (y.b.a(f17163g, this, obj2, obj)) {
                    return;
                }
            } else if ((obj2 instanceof m) || (obj2 instanceof sg.a0)) {
                J(obj, obj2);
            } else {
                if (obj2 instanceof c0) {
                    c0 c0Var = (c0) obj2;
                    if (!c0Var.c()) {
                        J(obj, obj2);
                    }
                    if (obj2 instanceof s) {
                        Throwable th = c0Var.f17078a;
                        if (obj instanceof m) {
                            o((m) obj, th);
                            return;
                        } else {
                            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            r((sg.a0) obj, th);
                            return;
                        }
                    }
                    return;
                }
                if (obj2 instanceof b0) {
                    b0 b0Var = (b0) obj2;
                    if (b0Var.f17071b != null) {
                        J(obj, obj2);
                    }
                    if (obj instanceof sg.a0) {
                        return;
                    }
                    kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    m mVar = (m) obj;
                    if (b0Var.c()) {
                        o(mVar, b0Var.f17074e);
                        return;
                    } else {
                        if (y.b.a(f17163g, this, obj2, b0.b(b0Var, null, mVar, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (obj instanceof sg.a0) {
                        return;
                    }
                    kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (y.b.a(f17163g, this, obj2, new b0(obj2, (m) obj, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    public final void H(m mVar) {
        G(mVar);
    }

    public final boolean I() {
        if (!a1.c(this.f17199c)) {
            return false;
        }
        gd.e eVar = this.f17165d;
        kotlin.jvm.internal.t.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((sg.h) eVar).r();
    }

    public final void J(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public String K() {
        return "CancellableContinuation";
    }

    public final void L(Throwable th) {
        if (s(th)) {
            return;
        }
        cancel(th);
        u();
    }

    public final void M() {
        Throwable thU;
        gd.e eVar = this.f17165d;
        sg.h hVar = eVar instanceof sg.h ? (sg.h) eVar : null;
        if (hVar == null || (thU = hVar.u(this)) == null) {
            return;
        }
        t();
        cancel(thU);
    }

    public final boolean N() {
        Object obj = f17163g.get(this);
        if ((obj instanceof b0) && ((b0) obj).f17073d != null) {
            t();
            return false;
        }
        f17162f.set(this, 536870911);
        f17163g.set(this, d.f17082a);
        return true;
    }

    public void O(Object obj, final pd.k kVar) {
        Q(obj, this.f17199c, kVar != null ? new pd.p() { // from class: ng.o
            @Override // pd.p
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return p.P(kVar, (Throwable) obj2, obj3, (gd.i) obj4);
            }
        } : null);
    }

    public final void Q(Object obj, int i10, pd.p pVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17163g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof m2)) {
                Object obj3 = obj;
                pd.p pVar2 = pVar;
                if (obj2 instanceof s) {
                    s sVar = (s) obj2;
                    if (sVar.e()) {
                        if (pVar2 != null) {
                            q(pVar2, sVar.f17078a, obj3);
                            return;
                        }
                        return;
                    }
                }
                n(obj3);
                throw new cd.h();
            }
            Object obj4 = obj;
            int i11 = i10;
            pd.p pVar3 = pVar;
            if (y.b.a(f17163g, this, obj2, S((m2) obj2, obj4, i11, pVar3, null))) {
                u();
                v(i11);
                return;
            } else {
                obj = obj4;
                i10 = i11;
                pVar = pVar3;
            }
        }
    }

    public final Object S(m2 m2Var, Object obj, int i10, pd.p pVar, Object obj2) {
        if (obj instanceof c0) {
            return obj;
        }
        if ((a1.b(i10) || obj2 != null) && !(pVar == null && !(m2Var instanceof m) && obj2 == null)) {
            return new b0(obj, m2Var instanceof m ? (m) m2Var : null, pVar, obj2, null, 16, null);
        }
        return obj;
    }

    public final sg.d0 U(Object obj, Object obj2, pd.p pVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17163g;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof m2)) {
                Object obj4 = obj2;
                if ((obj3 instanceof b0) && obj4 != null && ((b0) obj3).f17073d == obj4) {
                    return q.f17176a;
                }
                return null;
            }
            Object obj5 = obj;
            Object obj6 = obj2;
            pd.p pVar2 = pVar;
            if (y.b.a(f17163g, this, obj3, S((m2) obj3, obj5, this.f17199c, pVar2, obj6))) {
                u();
                return q.f17176a;
            }
            obj = obj5;
            pVar = pVar2;
            obj2 = obj6;
        }
    }

    @Override // ng.z0
    public void a(Object obj, Throwable th) {
        Throwable th2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17163g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof m2) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof c0) {
                return;
            }
            if (obj2 instanceof b0) {
                b0 b0Var = (b0) obj2;
                if (b0Var.c()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                Throwable th3 = th;
                th2 = th3;
                if (y.b.a(f17163g, this, obj2, b0.b(b0Var, null, null, null, null, th3, 15, null))) {
                    b0Var.d(this, th2);
                    return;
                }
            } else {
                th2 = th;
                if (y.b.a(f17163g, this, obj2, new b0(obj2, null, null, null, th2, 14, null))) {
                    return;
                }
            }
            th = th2;
        }
    }

    @Override // ng.c3
    public void b(sg.a0 a0Var, int i10) {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17162f;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if ((i11 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        G(a0Var);
    }

    @Override // ng.n
    public void c(Object obj, pd.p pVar) {
        Q(obj, this.f17199c, pVar);
    }

    @Override // ng.n
    public boolean cancel(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17163g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof m2)) {
                return false;
            }
        } while (!y.b.a(f17163g, this, obj, new s(this, th, (obj instanceof m) || (obj instanceof sg.a0))));
        m2 m2Var = (m2) obj;
        if (m2Var instanceof m) {
            o((m) obj, th);
        } else if (m2Var instanceof sg.a0) {
            r((sg.a0) obj, th);
        }
        u();
        v(this.f17199c);
        return true;
    }

    @Override // ng.z0
    public final gd.e d() {
        return this.f17165d;
    }

    @Override // ng.z0
    public Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // ng.n
    public void f(pd.k kVar) {
        r.c(this, new m.a(kVar));
    }

    @Override // ng.z0
    public Object g(Object obj) {
        return obj instanceof b0 ? ((b0) obj).f17070a : obj;
    }

    @Override // id.e
    public id.e getCallerFrame() {
        gd.e eVar = this.f17165d;
        if (eVar instanceof id.e) {
            return (id.e) eVar;
        }
        return null;
    }

    @Override // gd.e
    public gd.i getContext() {
        return this.f17166e;
    }

    @Override // ng.n
    public Object h(Throwable th) {
        return U(new c0(th, false, 2, null), null, null);
    }

    @Override // ng.n
    public boolean isCompleted() {
        return !(z() instanceof m2);
    }

    @Override // ng.n
    public void j(k0 k0Var, Object obj) {
        gd.e eVar = this.f17165d;
        sg.h hVar = eVar instanceof sg.h ? (sg.h) eVar : null;
        R(this, obj, (hVar != null ? hVar.f20390d : null) == k0Var ? 4 : this.f17199c, null, 4, null);
    }

    @Override // ng.n
    public Object k(Object obj, Object obj2, pd.p pVar) {
        return U(obj, obj2, pVar);
    }

    @Override // ng.z0
    public Object l() {
        return z();
    }

    public final Void n(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void o(m mVar, Throwable th) {
        try {
            mVar.a(th);
        } catch (Throwable th2) {
            m0.a(getContext(), new d0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // ng.n
    public void p(Object obj) {
        v(this.f17199c);
    }

    public final void q(pd.p pVar, Throwable th, Object obj) {
        try {
            pVar.invoke(th, obj, getContext());
        } catch (Throwable th2) {
            m0.a(getContext(), new d0("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void r(sg.a0 a0Var, Throwable th) {
        int i10 = f17162f.get(this) & 536870911;
        if (i10 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            a0Var.s(i10, th, getContext());
        } catch (Throwable th2) {
            m0.a(getContext(), new d0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // gd.e
    public void resumeWith(Object obj) {
        R(this, e0.c(obj, this), this.f17199c, null, 4, null);
    }

    public final boolean s(Throwable th) {
        if (!I()) {
            return false;
        }
        gd.e eVar = this.f17165d;
        kotlin.jvm.internal.t.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((sg.h) eVar).s(th);
    }

    public final void t() {
        e1 e1VarX = x();
        if (e1VarX == null) {
            return;
        }
        e1VarX.dispose();
        f17164h.set(this, l2.f17156a);
    }

    public String toString() {
        return K() + '(' + r0.c(this.f17165d) + "){" + A() + "}@" + r0.b(this);
    }

    public final void u() {
        if (I()) {
            return;
        }
        t();
    }

    public final void v(int i10) {
        if (T()) {
            return;
        }
        a1.a(this, i10);
    }

    public Throwable w(y1 y1Var) {
        return y1Var.getCancellationException();
    }

    public final e1 x() {
        return (e1) f17164h.get(this);
    }

    public final Object y() {
        y1 y1Var;
        boolean zI = I();
        if (V()) {
            if (x() == null) {
                F();
            }
            if (zI) {
                M();
            }
            return hd.c.f();
        }
        if (zI) {
            M();
        }
        Object objZ = z();
        if (objZ instanceof c0) {
            throw ((c0) objZ).f17078a;
        }
        if (!a1.b(this.f17199c) || (y1Var = (y1) getContext().get(y1.N)) == null || y1Var.isActive()) {
            return g(objZ);
        }
        CancellationException cancellationException = y1Var.getCancellationException();
        a(objZ, cancellationException);
        throw cancellationException;
    }

    public final Object z() {
        return f17163g.get(this);
    }
}
