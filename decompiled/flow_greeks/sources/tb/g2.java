package tb;

import java.util.Map;
import rb.b1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g2 extends b1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f21381d;

    public g2(boolean z10, int i10, int i11, i iVar) {
        this.f21378a = z10;
        this.f21379b = i10;
        this.f21380c = i11;
        this.f21381d = (i) p6.n.o(iVar, "autoLoadBalancerFactory");
    }

    @Override // rb.b1.f
    public b1.b a(Map map) {
        Object objC;
        try {
            b1.b bVarF = this.f21381d.f(map);
            if (bVarF == null) {
                objC = null;
            } else {
                if (bVarF.d() != null) {
                    return b1.b.b(bVarF.d());
                }
                objC = bVarF.c();
            }
            return b1.b.a(j1.b(map, this.f21378a, this.f21379b, this.f21380c, objC));
        } catch (RuntimeException e10) {
            return b1.b.b(rb.k1.f19594g.r("failed to parse service config").q(e10));
        }
    }
}
