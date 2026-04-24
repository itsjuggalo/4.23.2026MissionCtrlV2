package M2;

import K2.c0;
import K2.l0;
import M2.C0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class K0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f1929b;

        public a(String str, Map map) {
            this.f1928a = (String) Z1.m.o(str, "policyName");
            this.f1929b = (Map) Z1.m.o(map, "rawConfigValue");
        }

        public String a() {
            return this.f1928a;
        }

        public Map b() {
            return this.f1929b;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f1928a.equals(aVar.f1928a) && this.f1929b.equals(aVar.f1929b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Z1.i.b(this.f1928a, this.f1929b);
        }

        public String toString() {
            return Z1.g.b(this).d("policyName", this.f1928a).d("rawConfigValue", this.f1929b).toString();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K2.T f1930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1931b;

        public b(K2.T t4, Object obj) {
            this.f1930a = (K2.T) Z1.m.o(t4, "provider");
            this.f1931b = obj;
        }

        public Object a() {
            return this.f1931b;
        }

        public K2.T b() {
            return this.f1930a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (Z1.i.a(this.f1930a, bVar.f1930a) && Z1.i.a(this.f1931b, bVar.f1931b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Z1.i.b(this.f1930a, this.f1931b);
        }

        public String toString() {
            return Z1.g.b(this).d("provider", this.f1930a).d("config", this.f1931b).toString();
        }
    }

    public static List A(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(z((Map) it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Double a(Map map) {
        return AbstractC0413c0.h(map, "backoffMultiplier");
    }

    public static Map b(Map map) {
        if (map == null) {
            return null;
        }
        return AbstractC0413c0.j(map, "healthCheckConfig");
    }

    public static Long c(Map map) {
        return AbstractC0413c0.l(map, "hedgingDelay");
    }

    public static Map d(Map map) {
        return AbstractC0413c0.j(map, "hedgingPolicy");
    }

    public static Long e(Map map) {
        return AbstractC0413c0.l(map, "initialBackoff");
    }

    public static Set f(Map map, String str) {
        List listE = AbstractC0413c0.e(map, str);
        if (listE == null) {
            return null;
        }
        return u(listE);
    }

    public static List g(Map map) {
        String strK;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(AbstractC0413c0.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (strK = AbstractC0413c0.k(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(strK.toLowerCase(Locale.ROOT), Collections.EMPTY_MAP));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Integer h(Map map) {
        return AbstractC0413c0.i(map, "maxAttempts");
    }

    public static Integer i(Map map) {
        return AbstractC0413c0.i(map, "maxAttempts");
    }

    public static Long j(Map map) {
        return AbstractC0413c0.l(map, "maxBackoff");
    }

    public static Integer k(Map map) {
        return AbstractC0413c0.i(map, "maxRequestMessageBytes");
    }

    public static Integer l(Map map) {
        return AbstractC0413c0.i(map, "maxResponseMessageBytes");
    }

    public static List m(Map map) {
        return AbstractC0413c0.f(map, "methodConfig");
    }

    public static String n(Map map) {
        return AbstractC0413c0.k(map, "method");
    }

    public static List o(Map map) {
        return AbstractC0413c0.f(map, "name");
    }

    public static Set p(Map map) {
        Set setF = f(map, "nonFatalStatusCodes");
        if (setF == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(l0.b.class));
        }
        Z1.w.a(!setF.contains(l0.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return setF;
    }

    public static Long q(Map map) {
        return AbstractC0413c0.l(map, "perAttemptRecvTimeout");
    }

    public static Map r(Map map) {
        return AbstractC0413c0.j(map, "retryPolicy");
    }

    public static Set s(Map map) {
        Set setF = f(map, "retryableStatusCodes");
        Z1.w.a(setF != null, "%s is required in retry policy", "retryableStatusCodes");
        Z1.w.a(true ^ setF.contains(l0.b.OK), "%s must not contain OK", "retryableStatusCodes");
        return setF;
    }

    public static String t(Map map) {
        return AbstractC0413c0.k(map, "service");
    }

    public static Set u(List list) {
        l0.b bVarValueOf;
        EnumSet enumSetNoneOf = EnumSet.noneOf(l0.b.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d4 = (Double) obj;
                int iIntValue = d4.intValue();
                Z1.w.a(((double) iIntValue) == d4.doubleValue(), "Status code %s is not integral", obj);
                bVarValueOf = K2.l0.h(iIntValue).m();
                Z1.w.a(bVarValueOf.g() == d4.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new Z1.x("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    bVarValueOf = l0.b.valueOf((String) obj);
                } catch (IllegalArgumentException e4) {
                    throw new Z1.x("Status code " + obj + " is not valid", e4);
                }
            }
            enumSetNoneOf.add(bVarValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    public static C0.E v(Map map) {
        Map mapJ;
        if (map == null || (mapJ = AbstractC0413c0.j(map, "retryThrottling")) == null) {
            return null;
        }
        float fFloatValue = AbstractC0413c0.h(mapJ, "maxTokens").floatValue();
        float fFloatValue2 = AbstractC0413c0.h(mapJ, "tokenRatio").floatValue();
        Z1.m.u(fFloatValue > 0.0f, "maxToken should be greater than zero");
        Z1.m.u(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new C0.E(fFloatValue, fFloatValue2);
    }

    public static Long w(Map map) {
        return AbstractC0413c0.l(map, "timeout");
    }

    public static Boolean x(Map map) {
        return AbstractC0413c0.d(map, "waitForReady");
    }

    public static c0.b y(List list, K2.U u4) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            String strA = aVar.a();
            K2.T tD = u4.d(strA);
            if (tD != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(K0.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                c0.b bVarE = tD.e(aVar.b());
                return bVarE.d() != null ? bVarE : c0.b.a(new b(tD, bVarE.c()));
            }
            arrayList.add(strA);
        }
        return c0.b.b(K2.l0.f1217g.q("None of " + arrayList + " specified by Service Config are available."));
    }

    public static a z(Map map) {
        if (map.size() == 1) {
            String str = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
            return new a(str, AbstractC0413c0.j(map, str));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }
}
