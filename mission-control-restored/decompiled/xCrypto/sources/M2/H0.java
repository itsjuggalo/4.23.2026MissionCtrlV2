package M2;

import K2.c0;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class H0 extends c0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0424i f1918d;

    public H0(boolean z4, int i4, int i5, C0424i c0424i) {
        this.f1915a = z4;
        this.f1916b = i4;
        this.f1917c = i5;
        this.f1918d = (C0424i) Z1.m.o(c0424i, "autoLoadBalancerFactory");
    }

    @Override // K2.c0.f
    public c0.b a(Map map) {
        Object objC;
        try {
            c0.b bVarF = this.f1918d.f(map);
            if (bVarF == null) {
                objC = null;
            } else {
                if (bVarF.d() != null) {
                    return c0.b.b(bVarF.d());
                }
                objC = bVarF.c();
            }
            return c0.b.a(C0429k0.b(map, this.f1915a, this.f1916b, this.f1917c, objC));
        } catch (RuntimeException e4) {
            return c0.b.b(K2.l0.f1217g.q("failed to parse service config").p(e4));
        }
    }
}
