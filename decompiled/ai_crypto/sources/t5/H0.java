package t5;

import java.util.Map;
import r5.c0;

/* JADX INFO: loaded from: classes2.dex */
public final class H0 extends c0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2679i f23469d;

    public H0(boolean z7, int i7, int i8, C2679i c2679i) {
        this.f23466a = z7;
        this.f23467b = i7;
        this.f23468c = i8;
        this.f23469d = (C2679i) H2.m.o(c2679i, "autoLoadBalancerFactory");
    }

    @Override // r5.c0.f
    public c0.b a(Map map) {
        Object objC;
        try {
            c0.b bVarF = this.f23469d.f(map);
            if (bVarF == null) {
                objC = null;
            } else {
                if (bVarF.d() != null) {
                    return c0.b.b(bVarF.d());
                }
                objC = bVarF.c();
            }
            return c0.b.a(C2684k0.b(map, this.f23466a, this.f23467b, this.f23468c, objC));
        } catch (RuntimeException e7) {
            return c0.b.b(r5.l0.f22707g.q("failed to parse service config").p(e7));
        }
    }
}
