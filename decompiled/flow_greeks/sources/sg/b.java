package sg;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f20379a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f20380b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(b bVar) {
        this._prev$volatile = bVar;
    }

    public final void c() {
        f20380b.set(this, null);
    }

    public final b d() {
        b bVarH = h();
        while (bVarH != null && bVarH.k()) {
            bVarH = (b) f20380b.get(bVarH);
        }
        return bVarH;
    }

    public final b e() {
        b bVarF;
        b bVarF2 = f();
        kotlin.jvm.internal.t.c(bVarF2);
        while (bVarF2.k() && (bVarF = bVarF2.f()) != null) {
            bVarF2 = bVarF;
        }
        return bVarF2;
    }

    public final b f() {
        Object objG = g();
        if (objG == a.f20376a) {
            return null;
        }
        return (b) objG;
    }

    public final Object g() {
        return f20379a.get(this);
    }

    public final b h() {
        return (b) f20380b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return y.b.a(f20379a, this, null, a.f20376a);
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            b bVarD = d();
            b bVarE = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20380b;
            do {
                obj = atomicReferenceFieldUpdater.get(bVarE);
            } while (!y.b.a(atomicReferenceFieldUpdater, bVarE, obj, ((b) obj) == null ? null : bVarD));
            if (bVarD != null) {
                f20379a.set(bVarD, bVarE);
            }
            if (!bVarE.k() || bVarE.l()) {
                if (bVarD == null || !bVarD.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(b bVar) {
        return y.b.a(f20379a, this, null, bVar);
    }
}
