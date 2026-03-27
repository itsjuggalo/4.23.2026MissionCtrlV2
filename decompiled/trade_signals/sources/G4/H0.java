package G4;

import F4.a0;
import java.util.Map;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class H0 extends a0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0532i f2506d;

    public H0(boolean z7, int i8, int i9, C0532i c0532i) {
        this.f2503a = z7;
        this.f2504b = i8;
        this.f2505c = i9;
        this.f2506d = (C0532i) AbstractC2848n.o(c0532i, "autoLoadBalancerFactory");
    }

    @Override // F4.a0.f
    public a0.b a(Map map) {
        Object objC;
        try {
            a0.b bVarF = this.f2506d.f(map);
            if (bVarF == null) {
                objC = null;
            } else {
                if (bVarF.d() != null) {
                    return a0.b.b(bVarF.d());
                }
                objC = bVarF.c();
            }
            return a0.b.a(C0537k0.b(map, this.f2503a, this.f2504b, this.f2505c, objC));
        } catch (RuntimeException e8) {
            return a0.b.b(F4.j0.f1799g.r("failed to parse service config").q(e8));
        }
    }
}
