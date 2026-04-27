package G4;

import F4.C0489c;
import F4.F;
import F4.P;
import G4.C0;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v2.AbstractC2842h;
import v2.AbstractC2844j;
import v2.AbstractC2848n;
import v2.AbstractC2852r;

/* JADX INFO: renamed from: G4.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0537k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f3021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f3023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0.D f3024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f3025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f3026f;

    /* JADX INFO: renamed from: G4.k0$b */
    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0489c.C0029c f3027g = C0489c.C0029c.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f3028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f3029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f3030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f3031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final D0 f3032e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final U f3033f;

        public b(Map map, boolean z7, int i8, int i9) {
            this.f3028a = K0.w(map);
            this.f3029b = K0.x(map);
            Integer numL = K0.l(map);
            this.f3030c = numL;
            if (numL != null) {
                AbstractC2848n.j(numL.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numL);
            }
            Integer numK = K0.k(map);
            this.f3031d = numK;
            if (numK != null) {
                AbstractC2848n.j(numK.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numK);
            }
            Map mapR = z7 ? K0.r(map) : null;
            this.f3032e = mapR == null ? null : b(mapR, i8);
            Map mapD = z7 ? K0.d(map) : null;
            this.f3033f = mapD != null ? a(mapD, i9) : null;
        }

        public static U a(Map map, int i8) {
            int iIntValue = ((Integer) AbstractC2848n.o(K0.h(map), "maxAttempts cannot be empty")).intValue();
            AbstractC2848n.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i8);
            long jLongValue = ((Long) AbstractC2848n.o(K0.c(map), "hedgingDelay cannot be empty")).longValue();
            AbstractC2848n.i(jLongValue >= 0, "hedgingDelay must not be negative: %s", jLongValue);
            return new U(iMin, jLongValue, K0.p(map));
        }

        public static D0 b(Map map, int i8) {
            int iIntValue = ((Integer) AbstractC2848n.o(K0.i(map), "maxAttempts cannot be empty")).intValue();
            AbstractC2848n.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i8);
            long jLongValue = ((Long) AbstractC2848n.o(K0.e(map), "initialBackoff cannot be empty")).longValue();
            AbstractC2848n.i(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            long jLongValue2 = ((Long) AbstractC2848n.o(K0.j(map), "maxBackoff cannot be empty")).longValue();
            AbstractC2848n.i(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double d8 = (Double) AbstractC2848n.o(K0.a(map), "backoffMultiplier cannot be empty");
            double dDoubleValue = d8.doubleValue();
            AbstractC2848n.j(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", d8);
            Long lQ = K0.q(map);
            AbstractC2848n.j(lQ == null || lQ.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lQ);
            Set setS = K0.s(map);
            AbstractC2848n.e((lQ == null && setS.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new D0(iMin, jLongValue, jLongValue2, dDoubleValue, lQ, setS);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC2844j.a(this.f3028a, bVar.f3028a) && AbstractC2844j.a(this.f3029b, bVar.f3029b) && AbstractC2844j.a(this.f3030c, bVar.f3030c) && AbstractC2844j.a(this.f3031d, bVar.f3031d) && AbstractC2844j.a(this.f3032e, bVar.f3032e) && AbstractC2844j.a(this.f3033f, bVar.f3033f);
        }

        public int hashCode() {
            return AbstractC2844j.b(this.f3028a, this.f3029b, this.f3030c, this.f3031d, this.f3032e, this.f3033f);
        }

        public String toString() {
            return AbstractC2842h.b(this).d("timeoutNanos", this.f3028a).d("waitForReady", this.f3029b).d("maxInboundMessageSize", this.f3030c).d("maxOutboundMessageSize", this.f3031d).d("retryPolicy", this.f3032e).d("hedgingPolicy", this.f3033f).toString();
        }
    }

    /* JADX INFO: renamed from: G4.k0$c */
    public static final class c extends F4.F {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0537k0 f3034b;

        public c(C0537k0 c0537k0) {
            this.f3034b = c0537k0;
        }

        @Override // F4.F
        public F.b a(P.g gVar) {
            return F.b.d().b(this.f3034b).a();
        }
    }

    public C0537k0(b bVar, Map map, Map map2, C0.D d8, Object obj, Map map3) {
        this.f3021a = bVar;
        this.f3022b = Collections.unmodifiableMap(new HashMap(map));
        this.f3023c = Collections.unmodifiableMap(new HashMap(map2));
        this.f3024d = d8;
        this.f3025e = obj;
        this.f3026f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public static C0537k0 a() {
        return new C0537k0(null, new HashMap(), new HashMap(), null, null, null);
    }

    public static C0537k0 b(Map map, boolean z7, int i8, int i9, Object obj) {
        C0.D dV = z7 ? K0.v(map) : null;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Map mapB = K0.b(map);
        List<Map> listM = K0.m(map);
        if (listM == null) {
            return new C0537k0(null, map2, map3, dV, obj, mapB);
        }
        b bVar = null;
        for (Map map4 : listM) {
            b bVar2 = new b(map4, z7, i8, i9);
            List<Map> listO = K0.o(map4);
            if (listO != null && !listO.isEmpty()) {
                for (Map map5 : listO) {
                    String strT = K0.t(map5);
                    String strN = K0.n(map5);
                    if (AbstractC2852r.b(strT)) {
                        AbstractC2848n.j(AbstractC2852r.b(strN), "missing service name for method %s", strN);
                        AbstractC2848n.j(bVar == null, "Duplicate default method config in service config %s", map);
                        bVar = bVar2;
                    } else if (AbstractC2852r.b(strN)) {
                        AbstractC2848n.j(!map3.containsKey(strT), "Duplicate service %s", strT);
                        map3.put(strT, bVar2);
                    } else {
                        String strB = F4.Y.b(strT, strN);
                        AbstractC2848n.j(!map2.containsKey(strB), "Duplicate method name %s", strB);
                        map2.put(strB, bVar2);
                    }
                }
            }
        }
        return new C0537k0(bVar, map2, map3, dV, obj, mapB);
    }

    public F4.F c() {
        if (this.f3023c.isEmpty() && this.f3022b.isEmpty() && this.f3021a == null) {
            return null;
        }
        return new c();
    }

    public Map d() {
        return this.f3026f;
    }

    public Object e() {
        return this.f3025e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0537k0.class != obj.getClass()) {
            return false;
        }
        C0537k0 c0537k0 = (C0537k0) obj;
        return AbstractC2844j.a(this.f3021a, c0537k0.f3021a) && AbstractC2844j.a(this.f3022b, c0537k0.f3022b) && AbstractC2844j.a(this.f3023c, c0537k0.f3023c) && AbstractC2844j.a(this.f3024d, c0537k0.f3024d) && AbstractC2844j.a(this.f3025e, c0537k0.f3025e);
    }

    public b f(F4.Y y7) {
        b bVar = (b) this.f3022b.get(y7.c());
        if (bVar == null) {
            bVar = (b) this.f3023c.get(y7.d());
        }
        return bVar == null ? this.f3021a : bVar;
    }

    public C0.D g() {
        return this.f3024d;
    }

    public int hashCode() {
        return AbstractC2844j.b(this.f3021a, this.f3022b, this.f3023c, this.f3024d, this.f3025e);
    }

    public String toString() {
        return AbstractC2842h.b(this).d("defaultMethodConfig", this.f3021a).d("serviceMethodMap", this.f3022b).d("serviceMap", this.f3023c).d("retryThrottling", this.f3024d).d("loadBalancingConfig", this.f3025e).toString();
    }
}
