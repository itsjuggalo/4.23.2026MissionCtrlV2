package sg;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ng.i1;
import ng.r0;
import ng.v2;
import ng.z0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends z0 implements id.e, gd.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f20389h = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ng.k0 f20390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gd.e f20391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f20392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f20393g;

    public h(ng.k0 k0Var, gd.e eVar) {
        super(-1);
        this.f20390d = k0Var;
        this.f20391e = eVar;
        this.f20392f = i.f20394a;
        this.f20393g = k0.g(getContext());
    }

    @Override // id.e
    public id.e getCallerFrame() {
        gd.e eVar = this.f20391e;
        if (eVar instanceof id.e) {
            return (id.e) eVar;
        }
        return null;
    }

    @Override // gd.e
    public gd.i getContext() {
        return this.f20391e.getContext();
    }

    @Override // ng.z0
    public Object l() {
        Object obj = this.f20392f;
        this.f20392f = i.f20394a;
        return obj;
    }

    public final void m() {
        while (f20389h.get(this) == i.f20395b) {
        }
    }

    public final ng.p n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20389h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f20389h.set(this, i.f20395b);
                return null;
            }
            if (obj instanceof ng.p) {
                if (y.b.a(f20389h, this, obj, i.f20395b)) {
                    return (ng.p) obj;
                }
            } else if (obj != i.f20395b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final ng.p o() {
        Object obj = f20389h.get(this);
        if (obj instanceof ng.p) {
            return (ng.p) obj;
        }
        return null;
    }

    public final boolean r() {
        return f20389h.get(this) != null;
    }

    @Override // gd.e
    public void resumeWith(Object obj) {
        Object objB = ng.e0.b(obj);
        if (this.f20390d.a0(getContext())) {
            this.f20392f = objB;
            this.f17199c = 0;
            this.f20390d.Z(getContext(), this);
            return;
        }
        i1 i1VarB = v2.f17190a.b();
        if (i1VarB.l0()) {
            this.f20392f = objB;
            this.f17199c = 0;
            i1VarB.h0(this);
            return;
        }
        i1VarB.j0(true);
        try {
            gd.i context = getContext();
            Object objI = k0.i(context, this.f20393g);
            try {
                this.f20391e.resumeWith(obj);
                cd.h0 h0Var = cd.h0.f3852a;
                while (i1VarB.o0()) {
                }
            } finally {
                k0.f(context, objI);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final boolean s(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20389h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            d0 d0Var = i.f20395b;
            if (kotlin.jvm.internal.t.b(obj, d0Var)) {
                if (y.b.a(f20389h, this, d0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (y.b.a(f20389h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void t() {
        m();
        ng.p pVarO = o();
        if (pVarO != null) {
            pVarO.t();
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f20390d + ", " + r0.c(this.f20391e) + ']';
    }

    public final Throwable u(ng.n nVar) {
        d0 d0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20389h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            d0Var = i.f20395b;
            if (obj != d0Var) {
                if (obj instanceof Throwable) {
                    if (y.b.a(f20389h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!y.b.a(f20389h, this, d0Var, nVar));
        return null;
    }

    @Override // ng.z0
    public gd.e d() {
        return this;
    }
}
