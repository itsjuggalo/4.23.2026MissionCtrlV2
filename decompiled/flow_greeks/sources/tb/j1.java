package tb;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rb.c;
import rb.g0;
import rb.r0;
import tb.b2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f21439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f21440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b2.d0 f21441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f21442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f21443f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c.C0344c f21444g = c.C0344c.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f21445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f21446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f21447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f21448d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c2 f21449e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final t0 f21450f;

        public b(Map map, boolean z10, int i10, int i11) {
            this.f21445a = j2.w(map);
            this.f21446b = j2.x(map);
            Integer numL = j2.l(map);
            this.f21447c = numL;
            if (numL != null) {
                p6.n.j(numL.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numL);
            }
            Integer numK = j2.k(map);
            this.f21448d = numK;
            if (numK != null) {
                p6.n.j(numK.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numK);
            }
            Map mapR = z10 ? j2.r(map) : null;
            this.f21449e = mapR == null ? null : b(mapR, i10);
            Map mapD = z10 ? j2.d(map) : null;
            this.f21450f = mapD != null ? a(mapD, i11) : null;
        }

        public static t0 a(Map map, int i10) {
            int iIntValue = ((Integer) p6.n.o(j2.h(map), "maxAttempts cannot be empty")).intValue();
            p6.n.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i10);
            long jLongValue = ((Long) p6.n.o(j2.c(map), "hedgingDelay cannot be empty")).longValue();
            p6.n.i(jLongValue >= 0, "hedgingDelay must not be negative: %s", jLongValue);
            return new t0(iMin, jLongValue, j2.p(map));
        }

        public static c2 b(Map map, int i10) {
            int iIntValue = ((Integer) p6.n.o(j2.i(map), "maxAttempts cannot be empty")).intValue();
            p6.n.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i10);
            long jLongValue = ((Long) p6.n.o(j2.e(map), "initialBackoff cannot be empty")).longValue();
            p6.n.i(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            long jLongValue2 = ((Long) p6.n.o(j2.j(map), "maxBackoff cannot be empty")).longValue();
            p6.n.i(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double d10 = (Double) p6.n.o(j2.a(map), "backoffMultiplier cannot be empty");
            double dDoubleValue = d10.doubleValue();
            p6.n.j(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", d10);
            Long lQ = j2.q(map);
            p6.n.j(lQ == null || lQ.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lQ);
            Set setS = j2.s(map);
            p6.n.e((lQ == null && setS.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new c2(iMin, jLongValue, jLongValue2, dDoubleValue, lQ, setS);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return p6.j.a(this.f21445a, bVar.f21445a) && p6.j.a(this.f21446b, bVar.f21446b) && p6.j.a(this.f21447c, bVar.f21447c) && p6.j.a(this.f21448d, bVar.f21448d) && p6.j.a(this.f21449e, bVar.f21449e) && p6.j.a(this.f21450f, bVar.f21450f);
        }

        public int hashCode() {
            return p6.j.b(this.f21445a, this.f21446b, this.f21447c, this.f21448d, this.f21449e, this.f21450f);
        }

        public String toString() {
            return p6.h.b(this).d("timeoutNanos", this.f21445a).d("waitForReady", this.f21446b).d("maxInboundMessageSize", this.f21447c).d("maxOutboundMessageSize", this.f21448d).d("retryPolicy", this.f21449e).d("hedgingPolicy", this.f21450f).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends rb.g0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j1 f21451b;

        @Override // rb.g0
        public g0.b a(r0.g gVar) {
            return g0.b.d().b(this.f21451b).a();
        }

        public c(j1 j1Var) {
            this.f21451b = j1Var;
        }
    }

    public j1(b bVar, Map map, Map map2, b2.d0 d0Var, Object obj, Map map3) {
        this.f21438a = bVar;
        this.f21439b = Collections.unmodifiableMap(new HashMap(map));
        this.f21440c = Collections.unmodifiableMap(new HashMap(map2));
        this.f21441d = d0Var;
        this.f21442e = obj;
        this.f21443f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public static j1 a() {
        return new j1(null, new HashMap(), new HashMap(), null, null, null);
    }

    public static j1 b(Map map, boolean z10, int i10, int i11, Object obj) {
        b2.d0 d0VarV = z10 ? j2.v(map) : null;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Map mapB = j2.b(map);
        List<Map> listM = j2.m(map);
        if (listM == null) {
            return new j1(null, map2, map3, d0VarV, obj, mapB);
        }
        b bVar = null;
        for (Map map4 : listM) {
            b bVar2 = new b(map4, z10, i10, i11);
            List<Map> listO = j2.o(map4);
            if (listO != null && !listO.isEmpty()) {
                for (Map map5 : listO) {
                    String strT = j2.t(map5);
                    String strN = j2.n(map5);
                    if (p6.r.b(strT)) {
                        p6.n.j(p6.r.b(strN), "missing service name for method %s", strN);
                        p6.n.j(bVar == null, "Duplicate default method config in service config %s", map);
                        bVar = bVar2;
                    } else if (p6.r.b(strN)) {
                        p6.n.j(!map3.containsKey(strT), "Duplicate service %s", strT);
                        map3.put(strT, bVar2);
                    } else {
                        String strB = rb.z0.b(strT, strN);
                        p6.n.j(!map2.containsKey(strB), "Duplicate method name %s", strB);
                        map2.put(strB, bVar2);
                    }
                }
            }
        }
        return new j1(bVar, map2, map3, d0VarV, obj, mapB);
    }

    public rb.g0 c() {
        if (this.f21440c.isEmpty() && this.f21439b.isEmpty() && this.f21438a == null) {
            return null;
        }
        return new c();
    }

    public Map d() {
        return this.f21443f;
    }

    public Object e() {
        return this.f21442e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j1.class == obj.getClass()) {
            j1 j1Var = (j1) obj;
            if (p6.j.a(this.f21438a, j1Var.f21438a) && p6.j.a(this.f21439b, j1Var.f21439b) && p6.j.a(this.f21440c, j1Var.f21440c) && p6.j.a(this.f21441d, j1Var.f21441d) && p6.j.a(this.f21442e, j1Var.f21442e)) {
                return true;
            }
        }
        return false;
    }

    public b f(rb.z0 z0Var) {
        b bVar = (b) this.f21439b.get(z0Var.c());
        if (bVar == null) {
            bVar = (b) this.f21440c.get(z0Var.d());
        }
        return bVar == null ? this.f21438a : bVar;
    }

    public b2.d0 g() {
        return this.f21441d;
    }

    public int hashCode() {
        return p6.j.b(this.f21438a, this.f21439b, this.f21440c, this.f21441d, this.f21442e);
    }

    public String toString() {
        return p6.h.b(this).d("defaultMethodConfig", this.f21438a).d("serviceMethodMap", this.f21439b).d("serviceMap", this.f21440c).d("retryThrottling", this.f21441d).d("loadBalancingConfig", this.f21442e).toString();
    }
}
