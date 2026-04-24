package G4;

import F4.a0;
import F4.j0;
import G4.C0;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import v2.AbstractC2842h;
import v2.AbstractC2844j;
import v2.AbstractC2848n;
import v2.AbstractC2858x;
import v2.C2859y;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f2517b;

        public a(String str, Map map) {
            this.f2516a = (String) AbstractC2848n.o(str, "policyName");
            this.f2517b = (Map) AbstractC2848n.o(map, "rawConfigValue");
        }

        public String a() {
            return this.f2516a;
        }

        public Map b() {
            return this.f2517b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2516a.equals(aVar.f2516a) && this.f2517b.equals(aVar.f2517b);
        }

        public int hashCode() {
            return AbstractC2844j.b(this.f2516a, this.f2517b);
        }

        public String toString() {
            return AbstractC2842h.b(this).d("policyName", this.f2516a).d("rawConfigValue", this.f2517b).toString();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final F4.Q f2518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f2519b;

        public b(F4.Q q8, Object obj) {
            this.f2518a = (F4.Q) AbstractC2848n.o(q8, "provider");
            this.f2519b = obj;
        }

        public Object a() {
            return this.f2519b;
        }

        public F4.Q b() {
            return this.f2518a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC2844j.a(this.f2518a, bVar.f2518a) && AbstractC2844j.a(this.f2519b, bVar.f2519b);
        }

        public int hashCode() {
            return AbstractC2844j.b(this.f2518a, this.f2519b);
        }

        public String toString() {
            return AbstractC2842h.b(this).d("provider", this.f2518a).d("config", this.f2519b).toString();
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
        return AbstractC0521c0.h(map, "backoffMultiplier");
    }

    public static Map b(Map map) {
        if (map == null) {
            return null;
        }
        return AbstractC0521c0.j(map, "healthCheckConfig");
    }

    public static Long c(Map map) {
        return AbstractC0521c0.l(map, "hedgingDelay");
    }

    public static Map d(Map map) {
        return AbstractC0521c0.j(map, "hedgingPolicy");
    }

    public static Long e(Map map) {
        return AbstractC0521c0.l(map, "initialBackoff");
    }

    public static Set f(Map map, String str) {
        List listE = AbstractC0521c0.e(map, str);
        if (listE == null) {
            return null;
        }
        return u(listE);
    }

    public static List g(Map map) {
        String strK;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(AbstractC0521c0.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (strK = AbstractC0521c0.k(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(strK.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Integer h(Map map) {
        return AbstractC0521c0.i(map, "maxAttempts");
    }

    public static Integer i(Map map) {
        return AbstractC0521c0.i(map, "maxAttempts");
    }

    public static Long j(Map map) {
        return AbstractC0521c0.l(map, "maxBackoff");
    }

    public static Integer k(Map map) {
        return AbstractC0521c0.i(map, "maxRequestMessageBytes");
    }

    public static Integer l(Map map) {
        return AbstractC0521c0.i(map, "maxResponseMessageBytes");
    }

    public static List m(Map map) {
        return AbstractC0521c0.f(map, "methodConfig");
    }

    public static String n(Map map) {
        return AbstractC0521c0.k(map, FirebaseAnalytics.Param.METHOD);
    }

    public static List o(Map map) {
        return AbstractC0521c0.f(map, "name");
    }

    public static Set p(Map map) {
        Set setF = f(map, "nonFatalStatusCodes");
        if (setF == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(j0.b.class));
        }
        AbstractC2858x.a(!setF.contains(j0.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return setF;
    }

    public static Long q(Map map) {
        return AbstractC0521c0.l(map, "perAttemptRecvTimeout");
    }

    public static Map r(Map map) {
        return AbstractC0521c0.j(map, "retryPolicy");
    }

    public static Set s(Map map) {
        Set setF = f(map, "retryableStatusCodes");
        AbstractC2858x.a(setF != null, "%s is required in retry policy", "retryableStatusCodes");
        AbstractC2858x.a(true ^ setF.contains(j0.b.OK), "%s must not contain OK", "retryableStatusCodes");
        return setF;
    }

    public static String t(Map map) {
        return AbstractC0521c0.k(map, "service");
    }

    public static Set u(List list) {
        j0.b bVarValueOf;
        EnumSet enumSetNoneOf = EnumSet.noneOf(j0.b.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d8 = (Double) obj;
                int iIntValue = d8.intValue();
                AbstractC2858x.a(((double) iIntValue) == d8.doubleValue(), "Status code %s is not integral", obj);
                bVarValueOf = F4.j0.i(iIntValue).n();
                AbstractC2858x.a(bVarValueOf.g() == d8.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new C2859y("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    bVarValueOf = j0.b.valueOf((String) obj);
                } catch (IllegalArgumentException e8) {
                    throw new C2859y("Status code " + obj + " is not valid", e8);
                }
            }
            enumSetNoneOf.add(bVarValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    public static C0.D v(Map map) {
        Map mapJ;
        if (map == null || (mapJ = AbstractC0521c0.j(map, "retryThrottling")) == null) {
            return null;
        }
        float fFloatValue = AbstractC0521c0.h(mapJ, "maxTokens").floatValue();
        float fFloatValue2 = AbstractC0521c0.h(mapJ, "tokenRatio").floatValue();
        AbstractC2848n.u(fFloatValue > 0.0f, "maxToken should be greater than zero");
        AbstractC2848n.u(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new C0.D(fFloatValue, fFloatValue2);
    }

    public static Long w(Map map) {
        return AbstractC0521c0.l(map, "timeout");
    }

    public static Boolean x(Map map) {
        return AbstractC0521c0.d(map, "waitForReady");
    }

    public static a0.b y(List list, F4.S s8) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            String strA = aVar.a();
            F4.Q qD = s8.d(strA);
            if (qD != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(K0.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                a0.b bVarE = qD.e(aVar.b());
                return bVarE.d() != null ? bVarE : a0.b.a(new b(qD, bVarE.c()));
            }
            arrayList.add(strA);
        }
        return a0.b.b(F4.j0.f1799g.r("None of " + arrayList + " specified by Service Config are available."));
    }

    public static a z(Map map) {
        if (map.size() == 1) {
            String str = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
            return new a(str, AbstractC0521c0.j(map, str));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }
}
