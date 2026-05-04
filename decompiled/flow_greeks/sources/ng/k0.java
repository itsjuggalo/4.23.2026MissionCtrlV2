package ng;

import gd.f;
import gd.i;
import ng.k0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k0 extends gd.a implements gd.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f17152b = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends gd.b {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static final k0 d(i.b bVar) {
            if (bVar instanceof k0) {
                return (k0) bVar;
            }
            return null;
        }

        public a() {
            super(gd.f.K, new pd.k() { // from class: ng.j0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return k0.a.d((i.b) obj);
                }
            });
        }
    }

    public k0() {
        super(gd.f.K);
    }

    public static /* synthetic */ k0 d0(k0 k0Var, int i10, String str, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        return k0Var.c0(i10, str);
    }

    @Override // gd.f
    public final void O(gd.e eVar) {
        kotlin.jvm.internal.t.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((sg.h) eVar).t();
    }

    @Override // gd.f
    public final gd.e R(gd.e eVar) {
        return new sg.h(this, eVar);
    }

    public abstract void Z(gd.i iVar, Runnable runnable);

    public boolean a0(gd.i iVar) {
        return true;
    }

    public /* synthetic */ k0 b0(int i10) {
        return c0(i10, null);
    }

    public k0 c0(int i10, String str) {
        sg.l.a(i10);
        return new sg.k(this, i10, str);
    }

    @Override // gd.a, gd.i.b, gd.i
    public i.b get(i.c cVar) {
        return f.a.a(this, cVar);
    }

    @Override // gd.a, gd.i.b, gd.i
    public gd.i minusKey(i.c cVar) {
        return f.a.b(this, cVar);
    }

    public String toString() {
        return r0.a(this) + '@' + r0.b(this);
    }
}
