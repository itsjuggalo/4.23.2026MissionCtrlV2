package ac;

import ac.h;
import java.util.List;
import java.util.Map;
import rb.b1;
import rb.k1;
import rb.r0;
import rb.s0;
import rb.t0;
import tb.j2;
import tb.q2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends s0 {
    @Override // rb.r0.c
    public r0 a(r0.e eVar) {
        return new h(eVar, q2.f21623a);
    }

    @Override // rb.s0
    public String b() {
        return "outlier_detection_experimental";
    }

    @Override // rb.s0
    public int c() {
        return 5;
    }

    @Override // rb.s0
    public boolean d() {
        return true;
    }

    @Override // rb.s0
    public b1.b e(Map map) {
        try {
            return f(map);
        } catch (RuntimeException e10) {
            return b1.b.b(k1.f19607t.q(e10).r("Failed parsing configuration for " + b()));
        }
    }

    public final b1.b f(Map map) {
        Long l10 = tb.b1.l(map, "interval");
        Long l11 = tb.b1.l(map, "baseEjectionTime");
        Long l12 = tb.b1.l(map, "maxEjectionTime");
        Integer numI = tb.b1.i(map, "maxEjectionPercentage");
        h.g.a aVar = new h.g.a();
        if (l10 != null) {
            aVar.e(l10);
        }
        if (l11 != null) {
            aVar.b(l11);
        }
        if (l12 != null) {
            aVar.g(l12);
        }
        if (numI != null) {
            aVar.f(numI);
        }
        Map mapJ = tb.b1.j(map, "successRateEjection");
        if (mapJ != null) {
            h.g.c.a aVar2 = new h.g.c.a();
            Integer numI2 = tb.b1.i(mapJ, "stdevFactor");
            Integer numI3 = tb.b1.i(mapJ, "enforcementPercentage");
            Integer numI4 = tb.b1.i(mapJ, "minimumHosts");
            Integer numI5 = tb.b1.i(mapJ, "requestVolume");
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
        Map mapJ2 = tb.b1.j(map, "failurePercentageEjection");
        if (mapJ2 != null) {
            h.g.b.a aVar3 = new h.g.b.a();
            Integer numI6 = tb.b1.i(mapJ2, "threshold");
            Integer numI7 = tb.b1.i(mapJ2, "enforcementPercentage");
            Integer numI8 = tb.b1.i(mapJ2, "minimumHosts");
            Integer numI9 = tb.b1.i(mapJ2, "requestVolume");
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
        List listA = j2.A(tb.b1.f(map, "childPolicy"));
        if (listA == null || listA.isEmpty()) {
            return b1.b.b(k1.f19606s.r("No child policy in outlier_detection_experimental LB policy: " + map));
        }
        b1.b bVarY = j2.y(listA, t0.b());
        if (bVarY.d() != null) {
            return bVarY;
        }
        aVar.c((j2.b) bVarY.c());
        return b1.b.a(aVar.a());
    }
}
