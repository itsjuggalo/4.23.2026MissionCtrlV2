package y3;

import b3.InterfaceC0867e;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t3.AbstractC1815g0;
import t3.C1832p;
import t3.InterfaceC1830o;
import t3.P;
import t3.U0;
import t3.Y;

/* JADX INFO: renamed from: y3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1956j extends Y implements InterfaceC0867e, Z2.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15983h = AtomicReferenceFieldUpdater.newUpdater(C1956j.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t3.I f15984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Z2.e f15985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f15986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f15987g;

    public C1956j(t3.I i4, Z2.e eVar) {
        super(-1);
        this.f15984d = i4;
        this.f15985e = eVar;
        this.f15986f = AbstractC1957k.f15988a;
        this.f15987g = J.b(getContext());
    }

    @Override // t3.Y
    public void a(Object obj, Throwable th) {
        if (obj instanceof t3.D) {
            ((t3.D) obj).f14909b.invoke(th);
        }
    }

    @Override // b3.InterfaceC0867e
    public InterfaceC0867e getCallerFrame() {
        Z2.e eVar = this.f15985e;
        if (eVar instanceof InterfaceC0867e) {
            return (InterfaceC0867e) eVar;
        }
        return null;
    }

    @Override // Z2.e
    public Z2.i getContext() {
        return this.f15985e.getContext();
    }

    @Override // t3.Y
    public Object k() {
        Object obj = this.f15986f;
        this.f15986f = AbstractC1957k.f15988a;
        return obj;
    }

    public final void l() {
        while (f15983h.get(this) == AbstractC1957k.f15989b) {
        }
    }

    public final C1832p m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15983h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f15983h.set(this, AbstractC1957k.f15989b);
                return null;
            }
            if (obj instanceof C1832p) {
                if (androidx.concurrent.futures.b.a(f15983h, this, obj, AbstractC1957k.f15989b)) {
                    return (C1832p) obj;
                }
            } else if (obj != AbstractC1957k.f15989b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final C1832p n() {
        Object obj = f15983h.get(this);
        if (obj instanceof C1832p) {
            return (C1832p) obj;
        }
        return null;
    }

    public final boolean q() {
        return f15983h.get(this) != null;
    }

    public final boolean r(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15983h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            F f4 = AbstractC1957k.f15989b;
            if (kotlin.jvm.internal.r.b(obj, f4)) {
                if (androidx.concurrent.futures.b.a(f15983h, this, f4, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.b.a(f15983h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @Override // Z2.e
    public void resumeWith(Object obj) {
        Z2.i context = this.f15985e.getContext();
        Object objD = t3.G.d(obj, null, 1, null);
        if (this.f15984d.e0(context)) {
            this.f15986f = objD;
            this.f14971c = 0;
            this.f15984d.d0(context, this);
            return;
        }
        AbstractC1815g0 abstractC1815g0B = U0.f14966a.b();
        if (abstractC1815g0B.n0()) {
            this.f15986f = objD;
            this.f14971c = 0;
            abstractC1815g0B.j0(this);
            return;
        }
        abstractC1815g0B.l0(true);
        try {
            Z2.i context2 = getContext();
            Object objC = J.c(context2, this.f15987g);
            try {
                this.f15985e.resumeWith(obj);
                W2.E e4 = W2.E.f5463a;
                while (abstractC1815g0B.q0()) {
                }
            } finally {
                J.a(context2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void s() {
        l();
        C1832p c1832pN = n();
        if (c1832pN != null) {
            c1832pN.s();
        }
    }

    public final Throwable t(InterfaceC1830o interfaceC1830o) {
        F f4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15983h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            f4 = AbstractC1957k.f15989b;
            if (obj != f4) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.b.a(f15983h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.b.a(f15983h, this, f4, interfaceC1830o));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f15984d + ", " + P.c(this.f15985e) + ']';
    }

    @Override // t3.Y
    public Z2.e c() {
        return this;
    }
}
