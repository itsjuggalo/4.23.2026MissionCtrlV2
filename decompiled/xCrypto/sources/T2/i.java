package T2;

import K2.S;
import K2.T;
import K2.U;
import K2.c0;
import K2.l0;
import M2.AbstractC0413c0;
import M2.K0;
import M2.R0;
import T2.h;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends T {
    @Override // K2.S.c
    public S a(S.e eVar) {
        return new h(eVar, R0.f1954a);
    }

    @Override // K2.T
    public String b() {
        return "outlier_detection_experimental";
    }

    @Override // K2.T
    public int c() {
        return 5;
    }

    @Override // K2.T
    public boolean d() {
        return true;
    }

    @Override // K2.T
    public c0.b e(Map map) {
        try {
            return f(map);
        } catch (RuntimeException e4) {
            return c0.b.b(l0.f1230t.p(e4).q("Failed parsing configuration for " + b()));
        }
    }

    public final c0.b f(Map map) {
        Long l4 = AbstractC0413c0.l(map, "interval");
        Long l5 = AbstractC0413c0.l(map, "baseEjectionTime");
        Long l6 = AbstractC0413c0.l(map, "maxEjectionTime");
        Integer numI = AbstractC0413c0.i(map, "maxEjectionPercentage");
        h.g.a aVar = new h.g.a();
        if (l4 != null) {
            aVar.e(l4);
        }
        if (l5 != null) {
            aVar.b(l5);
        }
        if (l6 != null) {
            aVar.g(l6);
        }
        if (numI != null) {
            aVar.f(numI);
        }
        Map mapJ = AbstractC0413c0.j(map, "successRateEjection");
        if (mapJ != null) {
            h.g.c.a aVar2 = new h.g.c.a();
            Integer numI2 = AbstractC0413c0.i(mapJ, "stdevFactor");
            Integer numI3 = AbstractC0413c0.i(mapJ, "enforcementPercentage");
            Integer numI4 = AbstractC0413c0.i(mapJ, "minimumHosts");
            Integer numI5 = AbstractC0413c0.i(mapJ, "requestVolume");
            if (numI2 != null) {
                aVar2.e(numI2);
            }
            if (numI3 != null) {
                aVar2.b(numI3);
            }
            if (numI4 != null) {
                aVar2.c(numI4);
            }
            if (numI5 != null) {
                aVar2.d(numI5);
            }
            aVar.h(aVar2.a());
        }
        Map mapJ2 = AbstractC0413c0.j(map, "failurePercentageEjection");
        if (mapJ2 != null) {
            h.g.b.a aVar3 = new h.g.b.a();
            Integer numI6 = AbstractC0413c0.i(mapJ2, "threshold");
            Integer numI7 = AbstractC0413c0.i(mapJ2, "enforcementPercentage");
            Integer numI8 = AbstractC0413c0.i(mapJ2, "minimumHosts");
            Integer numI9 = AbstractC0413c0.i(mapJ2, "requestVolume");
            if (numI6 != null) {
                aVar3.e(numI6);
            }
            if (numI7 != null) {
                aVar3.b(numI7);
            }
            if (numI8 != null) {
                aVar3.c(numI8);
            }
            if (numI9 != null) {
                aVar3.d(numI9);
            }
            aVar.d(aVar3.a());
        }
        List listA = K0.A(AbstractC0413c0.f(map, "childPolicy"));
        if (listA == null || listA.isEmpty()) {
            return c0.b.b(l0.f1229s.q("No child policy in outlier_detection_experimental LB policy: " + map));
        }
        c0.b bVarY = K0.y(listA, U.b());
        if (bVarY.d() != null) {
            return bVarY;
        }
        aVar.c((K0.b) bVarY.c());
        return c0.b.a(aVar.a());
    }
}
