package t5;

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
import r5.c0;
import r5.l0;
import t5.C0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f23480b;

        public a(String str, Map map) {
            this.f23479a = (String) H2.m.o(str, "policyName");
            this.f23480b = (Map) H2.m.o(map, "rawConfigValue");
        }

        public String a() {
            return this.f23479a;
        }

        public Map b() {
            return this.f23480b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f23479a.equals(aVar.f23479a) && this.f23480b.equals(aVar.f23480b);
        }

        public int hashCode() {
            return H2.i.b(this.f23479a, this.f23480b);
        }

        public String toString() {
            return H2.g.b(this).d("policyName", this.f23479a).d("rawConfigValue", this.f23480b).toString();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r5.T f23481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f23482b;

        public b(r5.T t7, Object obj) {
            this.f23481a = (r5.T) H2.m.o(t7, "provider");
            this.f23482b = obj;
        }

        public Object a() {
            return this.f23482b;
        }

        public r5.T b() {
            return this.f23481a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return H2.i.a(this.f23481a, bVar.f23481a) && H2.i.a(this.f23482b, bVar.f23482b);
        }

        public int hashCode() {
            return H2.i.b(this.f23481a, this.f23482b);
        }

        public String toString() {
            return H2.g.b(this).d("provider", this.f23481a).d("config", this.f23482b).toString();
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
        return AbstractC2668c0.h(map, "backoffMultiplier");
    }

    public static Map b(Map map) {
        if (map == null) {
            return null;
        }
        return AbstractC2668c0.j(map, "healthCheckConfig");
    }

    public static Long c(Map map) {
        return AbstractC2668c0.l(map, "hedgingDelay");
    }

    public static Map d(Map map) {
        return AbstractC2668c0.j(map, "hedgingPolicy");
    }

    public static Long e(Map map) {
        return AbstractC2668c0.l(map, "initialBackoff");
    }

    public static Set f(Map map, String str) {
        List listE = AbstractC2668c0.e(map, str);
        if (listE == null) {
            return null;
        }
        return u(listE);
    }

    public static List g(Map map) {
        String strK;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(AbstractC2668c0.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (strK = AbstractC2668c0.k(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(strK.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Integer h(Map map) {
        return AbstractC2668c0.i(map, "maxAttempts");
    }

    public static Integer i(Map map) {
        return AbstractC2668c0.i(map, "maxAttempts");
    }

    public static Long j(Map map) {
        return AbstractC2668c0.l(map, "maxBackoff");
    }

    public static Integer k(Map map) {
        return AbstractC2668c0.i(map, "maxRequestMessageBytes");
    }

    public static Integer l(Map map) {
        return AbstractC2668c0.i(map, "maxResponseMessageBytes");
    }

    public static List m(Map map) {
        return AbstractC2668c0.f(map, "methodConfig");
    }

    public static String n(Map map) {
        return AbstractC2668c0.k(map, "method");
    }

    public static List o(Map map) {
        return AbstractC2668c0.f(map, "name");
    }

    public static Set p(Map map) {
        Set setF = f(map, "nonFatalStatusCodes");
        if (setF == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(l0.b.class));
        }
        H2.w.a(!setF.contains(l0.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return setF;
    }

    public static Long q(Map map) {
        return AbstractC2668c0.l(map, "perAttemptRecvTimeout");
    }

    public static Map r(Map map) {
        return AbstractC2668c0.j(map, "retryPolicy");
    }

    public static Set s(Map map) {
        Set setF = f(map, "retryableStatusCodes");
        H2.w.a(setF != null, "%s is required in retry policy", "retryableStatusCodes");
        H2.w.a(true ^ setF.contains(l0.b.OK), "%s must not contain OK", "retryableStatusCodes");
        return setF;
    }

    public static String t(Map map) {
        return AbstractC2668c0.k(map, "service");
    }

    public static Set u(List list) {
        l0.b bVarValueOf;
        EnumSet enumSetNoneOf = EnumSet.noneOf(l0.b.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d7 = (Double) obj;
                int iIntValue = d7.intValue();
                H2.w.a(((double) iIntValue) == d7.doubleValue(), "Status code %s is not integral", obj);
                bVarValueOf = r5.l0.h(iIntValue).m();
                H2.w.a(bVarValueOf.c() == d7.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new H2.x("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    bVarValueOf = l0.b.valueOf((String) obj);
                } catch (IllegalArgumentException e7) {
                    throw new H2.x("Status code " + obj + " is not valid", e7);
                }
            }
            enumSetNoneOf.add(bVarValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    public static C0.D v(Map map) {
        Map mapJ;
        if (map == null || (mapJ = AbstractC2668c0.j(map, "retryThrottling")) == null) {
            return null;
        }
        float fFloatValue = AbstractC2668c0.h(mapJ, "maxTokens").floatValue();
        float fFloatValue2 = AbstractC2668c0.h(mapJ, "tokenRatio").floatValue();
        H2.m.u(fFloatValue > 0.0f, "maxToken should be greater than zero");
        H2.m.u(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new C0.D(fFloatValue, fFloatValue2);
    }

    public static Long w(Map map) {
        return AbstractC2668c0.l(map, "timeout");
    }

    public static Boolean x(Map map) {
        return AbstractC2668c0.d(map, "waitForReady");
    }

    public static c0.b y(List list, r5.U u7) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            String strA = aVar.a();
            r5.T tD = u7.d(strA);
            if (tD != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(K0.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                c0.b bVarE = tD.e(aVar.b());
                return bVarE.d() != null ? bVarE : c0.b.a(new b(tD, bVarE.c()));
            }
            arrayList.add(strA);
        }
        return c0.b.b(r5.l0.f22707g.q("None of " + arrayList + " specified by Service Config are available."));
    }

    public static a z(Map map) {
        if (map.size() == 1) {
            String str = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
            return new a(str, AbstractC2668c0.j(map, str));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }
}
