package t5;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r5.C2587c;
import r5.G;
import r5.S;
import t5.C0;

/* JADX INFO: renamed from: t5.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2684k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f23994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f23995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f23996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0.D f23997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f23998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f23999f;

    /* JADX INFO: renamed from: t5.k0$b */
    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C2587c.C0351c f24000g = C2587c.C0351c.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f24001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f24002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f24003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f24004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final D0 f24005e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final U f24006f;

        public b(Map map, boolean z7, int i7, int i8) {
            this.f24001a = K0.w(map);
            this.f24002b = K0.x(map);
            Integer numL = K0.l(map);
            this.f24003c = numL;
            if (numL != null) {
                H2.m.j(numL.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numL);
            }
            Integer numK = K0.k(map);
            this.f24004d = numK;
            if (numK != null) {
                H2.m.j(numK.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numK);
            }
            Map mapR = z7 ? K0.r(map) : null;
            this.f24005e = mapR == null ? null : b(mapR, i7);
            Map mapD = z7 ? K0.d(map) : null;
            this.f24006f = mapD != null ? a(mapD, i8) : null;
        }

        public static U a(Map map, int i7) {
            int iIntValue = ((Integer) H2.m.o(K0.h(map), "maxAttempts cannot be empty")).intValue();
            H2.m.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i7);
            long jLongValue = ((Long) H2.m.o(K0.c(map), "hedgingDelay cannot be empty")).longValue();
            H2.m.i(jLongValue >= 0, "hedgingDelay must not be negative: %s", jLongValue);
            return new U(iMin, jLongValue, K0.p(map));
        }

        public static D0 b(Map map, int i7) {
            int iIntValue = ((Integer) H2.m.o(K0.i(map), "maxAttempts cannot be empty")).intValue();
            H2.m.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i7);
            long jLongValue = ((Long) H2.m.o(K0.e(map), "initialBackoff cannot be empty")).longValue();
            H2.m.i(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            long jLongValue2 = ((Long) H2.m.o(K0.j(map), "maxBackoff cannot be empty")).longValue();
            H2.m.i(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double d7 = (Double) H2.m.o(K0.a(map), "backoffMultiplier cannot be empty");
            double dDoubleValue = d7.doubleValue();
            H2.m.j(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", d7);
            Long lQ = K0.q(map);
            H2.m.j(lQ == null || lQ.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lQ);
            Set setS = K0.s(map);
            H2.m.e((lQ == null && setS.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new D0(iMin, jLongValue, jLongValue2, dDoubleValue, lQ, setS);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return H2.i.a(this.f24001a, bVar.f24001a) && H2.i.a(this.f24002b, bVar.f24002b) && H2.i.a(this.f24003c, bVar.f24003c) && H2.i.a(this.f24004d, bVar.f24004d) && H2.i.a(this.f24005e, bVar.f24005e) && H2.i.a(this.f24006f, bVar.f24006f);
        }

        public int hashCode() {
            return H2.i.b(this.f24001a, this.f24002b, this.f24003c, this.f24004d, this.f24005e, this.f24006f);
        }

        public String toString() {
            return H2.g.b(this).d("timeoutNanos", this.f24001a).d("waitForReady", this.f24002b).d("maxInboundMessageSize", this.f24003c).d("maxOutboundMessageSize", this.f24004d).d("retryPolicy", this.f24005e).d("hedgingPolicy", this.f24006f).toString();
        }
    }

    /* JADX INFO: renamed from: t5.k0$c */
    public static final class c extends r5.G {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2684k0 f24007b;

        @Override // r5.G
        public G.b a(S.g gVar) {
            return G.b.d().b(this.f24007b).a();
        }

        public c(C2684k0 c2684k0) {
            this.f24007b = c2684k0;
        }
    }

    public C2684k0(b bVar, Map map, Map map2, C0.D d7, Object obj, Map map3) {
        this.f23994a = bVar;
        this.f23995b = Collections.unmodifiableMap(new HashMap(map));
        this.f23996c = Collections.unmodifiableMap(new HashMap(map2));
        this.f23997d = d7;
        this.f23998e = obj;
        this.f23999f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public static C2684k0 a() {
        return new C2684k0(null, new HashMap(), new HashMap(), null, null, null);
    }

    public static C2684k0 b(Map map, boolean z7, int i7, int i8, Object obj) {
        C0.D dV = z7 ? K0.v(map) : null;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Map mapB = K0.b(map);
        List<Map> listM = K0.m(map);
        if (listM == null) {
            return new C2684k0(null, map2, map3, dV, obj, mapB);
        }
        b bVar = null;
        for (Map map4 : listM) {
            b bVar2 = new b(map4, z7, i7, i8);
            List<Map> listO = K0.o(map4);
            if (listO != null && !listO.isEmpty()) {
                for (Map map5 : listO) {
                    String strT = K0.t(map5);
                    String strN = K0.n(map5);
                    if (H2.q.a(strT)) {
                        H2.m.j(H2.q.a(strN), "missing service name for method %s", strN);
                        H2.m.j(bVar == null, "Duplicate default method config in service config %s", map);
                        bVar = bVar2;
                    } else if (H2.q.a(strN)) {
                        H2.m.j(!map3.containsKey(strT), "Duplicate service %s", strT);
                        map3.put(strT, bVar2);
                    } else {
                        String strB = r5.a0.b(strT, strN);
                        H2.m.j(!map2.containsKey(strB), "Duplicate method name %s", strB);
                        map2.put(strB, bVar2);
                    }
                }
            }
        }
        return new C2684k0(bVar, map2, map3, dV, obj, mapB);
    }

    public r5.G c() {
        if (this.f23996c.isEmpty() && this.f23995b.isEmpty() && this.f23994a == null) {
            return null;
        }
        return new c();
    }

    public Map d() {
        return this.f23999f;
    }

    public Object e() {
        return this.f23998e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2684k0.class != obj.getClass()) {
            return false;
        }
        C2684k0 c2684k0 = (C2684k0) obj;
        return H2.i.a(this.f23994a, c2684k0.f23994a) && H2.i.a(this.f23995b, c2684k0.f23995b) && H2.i.a(this.f23996c, c2684k0.f23996c) && H2.i.a(this.f23997d, c2684k0.f23997d) && H2.i.a(this.f23998e, c2684k0.f23998e);
    }

    public b f(r5.a0 a0Var) {
        b bVar = (b) this.f23995b.get(a0Var.c());
        if (bVar == null) {
            bVar = (b) this.f23996c.get(a0Var.d());
        }
        return bVar == null ? this.f23994a : bVar;
    }

    public C0.D g() {
        return this.f23997d;
    }

    public int hashCode() {
        return H2.i.b(this.f23994a, this.f23995b, this.f23996c, this.f23997d, this.f23998e);
    }

    public String toString() {
        return H2.g.b(this).d("defaultMethodConfig", this.f23994a).d("serviceMethodMap", this.f23995b).d("serviceMap", this.f23996c).d("retryThrottling", this.f23997d).d("loadBalancingConfig", this.f23998e).toString();
    }
}
