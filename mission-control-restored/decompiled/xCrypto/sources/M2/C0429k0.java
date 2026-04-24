package M2;

import K2.C0355c;
import K2.G;
import K2.S;
import M2.C0;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: M2.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0429k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0.E f2446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f2448f;

    /* JADX INFO: renamed from: M2.k0$b */
    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0355c.C0031c f2449g = C0355c.C0031c.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f2450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f2451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f2452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f2453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final D0 f2454e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final U f2455f;

        public b(Map map, boolean z4, int i4, int i5) {
            this.f2450a = K0.w(map);
            this.f2451b = K0.x(map);
            Integer numL = K0.l(map);
            this.f2452c = numL;
            if (numL != null) {
                Z1.m.j(numL.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numL);
            }
            Integer numK = K0.k(map);
            this.f2453d = numK;
            if (numK != null) {
                Z1.m.j(numK.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numK);
            }
            Map mapR = z4 ? K0.r(map) : null;
            this.f2454e = mapR == null ? null : b(mapR, i4);
            Map mapD = z4 ? K0.d(map) : null;
            this.f2455f = mapD != null ? a(mapD, i5) : null;
        }

        public static U a(Map map, int i4) {
            int iIntValue = ((Integer) Z1.m.o(K0.h(map), "maxAttempts cannot be empty")).intValue();
            Z1.m.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i4);
            long jLongValue = ((Long) Z1.m.o(K0.c(map), "hedgingDelay cannot be empty")).longValue();
            Z1.m.i(jLongValue >= 0, "hedgingDelay must not be negative: %s", jLongValue);
            return new U(iMin, jLongValue, K0.p(map));
        }

        public static D0 b(Map map, int i4) {
            int iIntValue = ((Integer) Z1.m.o(K0.i(map), "maxAttempts cannot be empty")).intValue();
            Z1.m.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i4);
            long jLongValue = ((Long) Z1.m.o(K0.e(map), "initialBackoff cannot be empty")).longValue();
            Z1.m.i(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            long jLongValue2 = ((Long) Z1.m.o(K0.j(map), "maxBackoff cannot be empty")).longValue();
            Z1.m.i(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double d4 = (Double) Z1.m.o(K0.a(map), "backoffMultiplier cannot be empty");
            double dDoubleValue = d4.doubleValue();
            Z1.m.j(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", d4);
            Long lQ = K0.q(map);
            Z1.m.j(lQ == null || lQ.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lQ);
            Set setS = K0.s(map);
            Z1.m.e((lQ == null && setS.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new D0(iMin, jLongValue, jLongValue2, dDoubleValue, lQ, setS);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Z1.i.a(this.f2450a, bVar.f2450a) && Z1.i.a(this.f2451b, bVar.f2451b) && Z1.i.a(this.f2452c, bVar.f2452c) && Z1.i.a(this.f2453d, bVar.f2453d) && Z1.i.a(this.f2454e, bVar.f2454e) && Z1.i.a(this.f2455f, bVar.f2455f);
        }

        public int hashCode() {
            return Z1.i.b(this.f2450a, this.f2451b, this.f2452c, this.f2453d, this.f2454e, this.f2455f);
        }

        public String toString() {
            return Z1.g.b(this).d("timeoutNanos", this.f2450a).d("waitForReady", this.f2451b).d("maxInboundMessageSize", this.f2452c).d("maxOutboundMessageSize", this.f2453d).d("retryPolicy", this.f2454e).d("hedgingPolicy", this.f2455f).toString();
        }
    }

    /* JADX INFO: renamed from: M2.k0$c */
    public static final class c extends K2.G {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0429k0 f2456b;

        @Override // K2.G
        public G.b a(S.g gVar) {
            return G.b.d().b(this.f2456b).a();
        }

        public c(C0429k0 c0429k0) {
            this.f2456b = c0429k0;
        }
    }

    public C0429k0(b bVar, Map map, Map map2, C0.E e4, Object obj, Map map3) {
        this.f2443a = bVar;
        this.f2444b = Collections.unmodifiableMap(new HashMap(map));
        this.f2445c = Collections.unmodifiableMap(new HashMap(map2));
        this.f2446d = e4;
        this.f2447e = obj;
        this.f2448f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public static C0429k0 a() {
        return new C0429k0(null, new HashMap(), new HashMap(), null, null, null);
    }

    public static C0429k0 b(Map map, boolean z4, int i4, int i5, Object obj) {
        C0.E eV = z4 ? K0.v(map) : null;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Map mapB = K0.b(map);
        List<Map> listM = K0.m(map);
        if (listM == null) {
            return new C0429k0(null, map2, map3, eV, obj, mapB);
        }
        b bVar = null;
        for (Map map4 : listM) {
            b bVar2 = new b(map4, z4, i4, i5);
            List<Map> listO = K0.o(map4);
            if (listO != null && !listO.isEmpty()) {
                for (Map map5 : listO) {
                    String strT = K0.t(map5);
                    String strN = K0.n(map5);
                    if (Z1.q.a(strT)) {
                        Z1.m.j(Z1.q.a(strN), "missing service name for method %s", strN);
                        Z1.m.j(bVar == null, "Duplicate default method config in service config %s", map);
                        bVar = bVar2;
                    } else if (Z1.q.a(strN)) {
                        Z1.m.j(!map3.containsKey(strT), "Duplicate service %s", strT);
                        map3.put(strT, bVar2);
                    } else {
                        String strB = K2.a0.b(strT, strN);
                        Z1.m.j(!map2.containsKey(strB), "Duplicate method name %s", strB);
                        map2.put(strB, bVar2);
                    }
                }
            }
        }
        return new C0429k0(bVar, map2, map3, eV, obj, mapB);
    }

    public K2.G c() {
        if (this.f2445c.isEmpty() && this.f2444b.isEmpty() && this.f2443a == null) {
            return null;
        }
        return new c();
    }

    public Map d() {
        return this.f2448f;
    }

    public Object e() {
        return this.f2447e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0429k0.class == obj.getClass()) {
            C0429k0 c0429k0 = (C0429k0) obj;
            if (Z1.i.a(this.f2443a, c0429k0.f2443a) && Z1.i.a(this.f2444b, c0429k0.f2444b) && Z1.i.a(this.f2445c, c0429k0.f2445c) && Z1.i.a(this.f2446d, c0429k0.f2446d) && Z1.i.a(this.f2447e, c0429k0.f2447e)) {
                return true;
            }
        }
        return false;
    }

    public b f(K2.a0 a0Var) {
        b bVar = (b) this.f2444b.get(a0Var.c());
        if (bVar == null) {
            bVar = (b) this.f2445c.get(a0Var.d());
        }
        return bVar == null ? this.f2443a : bVar;
    }

    public C0.E g() {
        return this.f2446d;
    }

    public int hashCode() {
        return Z1.i.b(this.f2443a, this.f2444b, this.f2445c, this.f2446d, this.f2447e);
    }

    public String toString() {
        return Z1.g.b(this).d("defaultMethodConfig", this.f2443a).d("serviceMethodMap", this.f2444b).d("serviceMap", this.f2445c).d("retryThrottling", this.f2446d).d("loadBalancingConfig", this.f2447e).toString();
    }
}
