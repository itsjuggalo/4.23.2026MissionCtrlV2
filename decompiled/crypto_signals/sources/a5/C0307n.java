package a5;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: a5.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0307n extends J implements InterfaceC0305l, K4.d, D0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4144f = AtomicIntegerFieldUpdater.newUpdater(C0307n.class, "_decisionAndIndex$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4145k = AtomicReferenceFieldUpdater.newUpdater(C0307n.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4146l = AtomicReferenceFieldUpdater.newUpdater(C0307n.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final I4.d f4147d;
    public final I4.i e;

    public C0307n(int i, I4.d dVar) {
        super(i);
        this.f4147d = dVar;
        this.e = dVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = C0292b.f4107a;
    }

    public static Object B(s0 s0Var, Object obj, int i, R4.q qVar) {
        if (obj instanceof C0315w) {
            return obj;
        }
        if (i != 1 && i != 2) {
            return obj;
        }
        if (qVar != null || (s0Var instanceof InterfaceC0304k)) {
            return new C0314v(obj, s0Var instanceof InterfaceC0304k ? (InterfaceC0304k) s0Var : null, qVar, (CancellationException) null, 16);
        }
        return obj;
    }

    public static void v(s0 s0Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + s0Var + ", already has " + obj).toString());
    }

    public final void A(AbstractC0317y abstractC0317y) {
        G4.l lVar = G4.l.f540a;
        I4.d dVar = this.f4147d;
        f5.f fVar = dVar instanceof f5.f ? (f5.f) dVar : null;
        z(lVar, (fVar != null ? fVar.f6507d : null) == abstractC0317y ? 4 : this.f4086c, null);
    }

    public final f5.t C(Object obj, R4.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4145k;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z6 = obj2 instanceof s0;
            f5.t tVar = C.f4074a;
            if (!z6) {
                boolean z7 = obj2 instanceof C0314v;
                return null;
            }
            Object objB = B((s0) obj2, obj, this.f4086c, qVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objB)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!u()) {
                n();
            }
            return tVar;
        }
    }

    @Override // a5.InterfaceC0305l
    public final f5.t a(Object obj, R4.q qVar) {
        return C(obj, qVar);
    }

    @Override // a5.D0
    public final void b(f5.r rVar, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f4144f;
            i6 = atomicIntegerFieldUpdater.get(this);
            if ((i6 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, ((i6 >> 29) << 29) + i));
        t(rVar);
    }

    @Override // a5.J
    public final void c(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4145k;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof s0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof C0315w) {
                return;
            }
            if (!(obj instanceof C0314v)) {
                cancellationException2 = cancellationException;
                C0314v c0314v = new C0314v(obj, (InterfaceC0304k) null, (R4.q) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0314v)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            C0314v c0314v2 = (C0314v) obj;
            if (c0314v2.e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            C0314v c0314vA = C0314v.a(c0314v2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0314vA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    cancellationException2 = cancellationException;
                }
            }
            InterfaceC0304k interfaceC0304k = c0314v2.f4156b;
            if (interfaceC0304k != null) {
                j(interfaceC0304k, cancellationException);
            }
            R4.q qVar = c0314v2.f4157c;
            if (qVar != null) {
                k(qVar, cancellationException, c0314v2.f4155a);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // a5.J
    public final I4.d d() {
        return this.f4147d;
    }

    @Override // a5.InterfaceC0305l
    public final void e(Object obj) {
        o(this.f4086c);
    }

    @Override // a5.J
    public final Throwable f(Object obj) {
        Throwable thF = super.f(obj);
        if (thF != null) {
            return thF;
        }
        return null;
    }

    @Override // a5.J
    public final Object g(Object obj) {
        return obj instanceof C0314v ? ((C0314v) obj).f4155a : obj;
    }

    @Override // K4.d
    public final K4.d getCallerFrame() {
        I4.d dVar = this.f4147d;
        if (dVar instanceof K4.d) {
            return (K4.d) dVar;
        }
        return null;
    }

    @Override // I4.d
    public final I4.i getContext() {
        return this.e;
    }

    @Override // a5.J
    public final Object i() {
        return f4145k.get(this);
    }

    public final void j(InterfaceC0304k interfaceC0304k, Throwable th) {
        try {
            interfaceC0304k.a(th);
        } catch (Throwable th2) {
            C.l(this.e, new G4.e("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(R4.q qVar, Throwable th, Object obj) {
        I4.i iVar = this.e;
        try {
            qVar.b(th, obj, iVar);
        } catch (Throwable th2) {
            C.l(iVar, new G4.e("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void l(f5.r rVar, Throwable th) {
        I4.i iVar = this.e;
        int i = f4144f.get(this) & 536870911;
        if (i == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            rVar.h(i, iVar);
        } catch (Throwable th2) {
            C.l(iVar, new G4.e("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final boolean m(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4145k;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof s0)) {
                return false;
            }
            C0308o c0308o = new C0308o(this, th, (obj instanceof InterfaceC0304k) || (obj instanceof f5.r));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0308o)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            s0 s0Var = (s0) obj;
            if (s0Var instanceof InterfaceC0304k) {
                j((InterfaceC0304k) obj, th);
            } else if (s0Var instanceof f5.r) {
                l((f5.r) obj, th);
            }
            if (!u()) {
                n();
            }
            o(this.f4086c);
            return true;
        }
    }

    public final void n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4146l;
        M m5 = (M) atomicReferenceFieldUpdater.get(this);
        if (m5 == null) {
            return;
        }
        m5.a();
        atomicReferenceFieldUpdater.set(this, r0.f4154a);
    }

    public final void o(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f4144f;
            i6 = atomicIntegerFieldUpdater.get(this);
            int i7 = i6 >> 29;
            if (i7 != 0) {
                if (i7 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                I4.d dVar = this.f4147d;
                boolean z6 = i == 4;
                if (!z6 && (dVar instanceof f5.f)) {
                    boolean z7 = i == 1 || i == 2;
                    int i8 = this.f4086c;
                    if (z7 == (i8 == 1 || i8 == 2)) {
                        f5.f fVar = (f5.f) dVar;
                        AbstractC0317y abstractC0317y = fVar.f6507d;
                        I4.i context = fVar.e.getContext();
                        if (abstractC0317y.h(context)) {
                            abstractC0317y.g(context, this);
                            return;
                        }
                        V vA = x0.a();
                        if (vA.f4101c < 4294967296L) {
                            vA.l(true);
                            try {
                                C.s(this, dVar, true);
                                do {
                                } while (vA.n());
                            } finally {
                                try {
                                } finally {
                                }
                            }
                            return;
                        }
                        H4.f fVar2 = vA.e;
                        if (fVar2 == null) {
                            fVar2 = new H4.f();
                            vA.e = fVar2;
                        }
                        fVar2.addLast(this);
                        return;
                    }
                }
                C.s(this, dVar, z6);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, 1073741824 + (536870911 & i6)));
    }

    public Throwable p(p0 p0Var) {
        return p0Var.getCancellationException();
    }

    public final Object q() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        boolean zU = u();
        do {
            atomicIntegerFieldUpdater = f4144f;
            i = atomicIntegerFieldUpdater.get(this);
            int i6 = i >> 29;
            if (i6 != 0) {
                if (i6 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zU) {
                    x();
                }
                Object obj = f4145k.get(this);
                if (obj instanceof C0315w) {
                    throw ((C0315w) obj).f4160a;
                }
                int i7 = this.f4086c;
                if (i7 == 1 || i7 == 2) {
                    InterfaceC0295c0 interfaceC0295c0 = (InterfaceC0295c0) this.e.get(C0318z.f4167b);
                    if (interfaceC0295c0 != null && !interfaceC0295c0.isActive()) {
                        CancellationException cancellationException = interfaceC0295c0.getCancellationException();
                        c(cancellationException);
                        throw cancellationException;
                    }
                }
                return g(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((M) f4146l.get(this)) == null) {
            s();
        }
        if (zU) {
            x();
        }
        return J4.a.f791a;
    }

    public final void r() {
        M mS = s();
        if (mS == null || (f4145k.get(this) instanceof s0)) {
            return;
        }
        mS.a();
        f4146l.set(this, r0.f4154a);
    }

    @Override // I4.d
    public final void resumeWith(Object obj) {
        Throwable thA = G4.h.a(obj);
        if (thA != null) {
            obj = new C0315w(thA, false);
        }
        z(obj, this.f4086c, null);
    }

    public final M s() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        InterfaceC0295c0 interfaceC0295c0 = (InterfaceC0295c0) this.e.get(C0318z.f4167b);
        if (interfaceC0295c0 == null) {
            return null;
        }
        M m5 = C.m(interfaceC0295c0, true, new C0309p(this, 0));
        do {
            atomicReferenceFieldUpdater = f4146l;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, m5)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return m5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
    
        v(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ad, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(a5.s0 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a5.C0307n.f4145k
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof a5.C0292b
            if (r1 == 0) goto L19
        La:
            boolean r1 = r0.compareAndSet(r7, r2, r8)
            if (r1 == 0) goto L12
            goto La1
        L12:
            java.lang.Object r1 = r0.get(r7)
            if (r1 == r2) goto La
            goto L0
        L19:
            boolean r1 = r2 instanceof a5.InterfaceC0304k
            r3 = 0
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof f5.r
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof a5.C0315w
            if (r1 == 0) goto L56
            r0 = r2
            a5.w r0 = (a5.C0315w) r0
            r0.getClass()
            r1 = 1
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = a5.C0315w.f4159b
            r5 = 0
            boolean r1 = r4.compareAndSet(r0, r5, r1)
            if (r1 == 0) goto L52
            boolean r1 = r2 instanceof a5.C0308o
            if (r1 == 0) goto La1
            if (r2 == 0) goto L3d
            goto L3e
        L3d:
            r0 = r3
        L3e:
            if (r0 == 0) goto L42
            java.lang.Throwable r3 = r0.f4160a
        L42:
            boolean r0 = r8 instanceof a5.InterfaceC0304k
            if (r0 == 0) goto L4c
            a5.k r8 = (a5.InterfaceC0304k) r8
            r7.j(r8, r3)
            return
        L4c:
            f5.r r8 = (f5.r) r8
            r7.l(r8, r3)
            return
        L52:
            v(r8, r2)
            throw r3
        L56:
            boolean r1 = r2 instanceof a5.C0314v
            if (r1 == 0) goto L8a
            r1 = r2
            a5.v r1 = (a5.C0314v) r1
            a5.k r4 = r1.f4156b
            if (r4 != 0) goto L86
            boolean r4 = r8 instanceof f5.r
            if (r4 == 0) goto L66
            goto La1
        L66:
            r4 = r8
            a5.k r4 = (a5.InterfaceC0304k) r4
            java.lang.Throwable r5 = r1.e
            if (r5 == 0) goto L71
            r7.j(r4, r5)
            return
        L71:
            r5 = 29
            a5.v r1 = a5.C0314v.a(r1, r4, r3, r5)
        L77:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L7e
            goto La1
        L7e:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L77
            goto L0
        L86:
            v(r8, r2)
            throw r3
        L8a:
            boolean r1 = r8 instanceof f5.r
            if (r1 == 0) goto L8f
            goto La1
        L8f:
            r3 = r8
            a5.k r3 = (a5.InterfaceC0304k) r3
            a5.v r1 = new a5.v
            r4 = 0
            r5 = 0
            r6 = 28
            r1.<init>(r2, r3, r4, r5, r6)
        L9b:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto La2
        La1:
            return
        La2:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L9b
            goto L0
        Laa:
            v(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.C0307n.t(a5.s0):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(w());
        sb.append('(');
        sb.append(C.u(this.f4147d));
        sb.append("){");
        Object obj = f4145k.get(this);
        sb.append(obj instanceof s0 ? "Active" : obj instanceof C0308o ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(C.j(this));
        return sb.toString();
    }

    public final boolean u() {
        if (this.f4086c != 2) {
            return false;
        }
        I4.d dVar = this.f4147d;
        kotlin.jvm.internal.j.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return f5.f.f6506l.get((f5.f) dVar) != null;
    }

    public String w() {
        return "CancellableContinuation";
    }

    public final void x() {
        I4.d dVar = this.f4147d;
        Throwable th = null;
        f5.f fVar = dVar instanceof f5.f ? (f5.f) dVar : null;
        if (fVar != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5.f.f6506l;
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                f5.t tVar = f5.a.f6497c;
                if (obj == tVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, tVar, this)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != tVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            n();
            m(th);
        }
    }

    public final void y(Object obj, R4.q qVar) {
        z(obj, this.f4086c, qVar);
    }

    public final void z(Object obj, int i, R4.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4145k;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof s0) {
                Object objB = B((s0) obj2, obj, i, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objB)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!u()) {
                    n();
                }
                o(i);
                return;
            }
            if (obj2 instanceof C0308o) {
                C0308o c0308o = (C0308o) obj2;
                c0308o.getClass();
                if (C0308o.f4149c.compareAndSet(c0308o, 0, 1)) {
                    if (qVar != null) {
                        k(qVar, c0308o.f4160a, obj);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }
}
