package tb;

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
import rb.b1;
import rb.k1;
import tb.b2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j2 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f21453b;

        public a(String str, Map map) {
            this.f21452a = (String) p6.n.o(str, "policyName");
            this.f21453b = (Map) p6.n.o(map, "rawConfigValue");
        }

        public String a() {
            return this.f21452a;
        }

        public Map b() {
            return this.f21453b;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f21452a.equals(aVar.f21452a) && this.f21453b.equals(aVar.f21453b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return p6.j.b(this.f21452a, this.f21453b);
        }

        public String toString() {
            return p6.h.b(this).d("policyName", this.f21452a).d("rawConfigValue", this.f21453b).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rb.s0 f21454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f21455b;

        public b(rb.s0 s0Var, Object obj) {
            this.f21454a = (rb.s0) p6.n.o(s0Var, "provider");
            this.f21455b = obj;
        }

        public Object a() {
            return this.f21455b;
        }

        public rb.s0 b() {
            return this.f21454a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (p6.j.a(this.f21454a, bVar.f21454a) && p6.j.a(this.f21455b, bVar.f21455b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return p6.j.b(this.f21454a, this.f21455b);
        }

        public String toString() {
            return p6.h.b(this).d("provider", this.f21454a).d("config", this.f21455b).toString();
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
        return b1.h(map, "backoffMultiplier");
    }

    public static Map b(Map map) {
        if (map == null) {
            return null;
        }
        return b1.j(map, "healthCheckConfig");
    }

    public static Long c(Map map) {
        return b1.l(map, "hedgingDelay");
    }

    public static Map d(Map map) {
        return b1.j(map, "hedgingPolicy");
    }

    public static Long e(Map map) {
        return b1.l(map, "initialBackoff");
    }

    public static Set f(Map map, String str) {
        List listE = b1.e(map, str);
        if (listE == null) {
            return null;
        }
        return u(listE);
    }

    public static List g(Map map) {
        String strK;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(b1.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (strK = b1.k(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(strK.toLowerCase(Locale.ROOT), Collections.EMPTY_MAP));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Integer h(Map map) {
        return b1.i(map, "maxAttempts");
    }

    public static Integer i(Map map) {
        return b1.i(map, "maxAttempts");
    }

    public static Long j(Map map) {
        return b1.l(map, "maxBackoff");
    }

    public static Integer k(Map map) {
        return b1.i(map, "maxRequestMessageBytes");
    }

    public static Integer l(Map map) {
        return b1.i(map, "maxResponseMessageBytes");
    }

    public static List m(Map map) {
        return b1.f(map, "methodConfig");
    }

    public static String n(Map map) {
        return b1.k(map, FirebaseAnalytics.Param.METHOD);
    }

    public static List o(Map map) {
        return b1.f(map, "name");
    }

    public static Set p(Map map) {
        Set setF = f(map, "nonFatalStatusCodes");
        if (setF == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(k1.b.class));
        }
        p6.x.a(!setF.contains(k1.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return setF;
    }

    public static Long q(Map map) {
        return b1.l(map, "perAttemptRecvTimeout");
    }

    public static Map r(Map map) {
        return b1.j(map, "retryPolicy");
    }

    public static Set s(Map map) {
        Set setF = f(map, "retryableStatusCodes");
        p6.x.a(setF != null, "%s is required in retry policy", "retryableStatusCodes");
        p6.x.a(true ^ setF.contains(k1.b.OK), "%s must not contain OK", "retryableStatusCodes");
        return setF;
    }

    public static String t(Map map) {
        return b1.k(map, "service");
    }

    public static Set u(List list) {
        k1.b bVarValueOf;
        EnumSet enumSetNoneOf = EnumSet.noneOf(k1.b.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d10 = (Double) obj;
                int iIntValue = d10.intValue();
                p6.x.a(((double) iIntValue) == d10.doubleValue(), "Status code %s is not integral", obj);
                bVarValueOf = rb.k1.i(iIntValue).n();
                p6.x.a(bVarValueOf.c() == d10.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new p6.y("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    bVarValueOf = k1.b.valueOf((String) obj);
                } catch (IllegalArgumentException e10) {
                    throw new p6.y("Status code " + obj + " is not valid", e10);
                }
            }
            enumSetNoneOf.add(bVarValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    public static b2.d0 v(Map map) {
        Map mapJ;
        if (map == null || (mapJ = b1.j(map, "retryThrottling")) == null) {
            return null;
        }
        float fFloatValue = b1.h(mapJ, "maxTokens").floatValue();
        float fFloatValue2 = b1.h(mapJ, "tokenRatio").floatValue();
        p6.n.u(fFloatValue > 0.0f, "maxToken should be greater than zero");
        p6.n.u(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new b2.d0(fFloatValue, fFloatValue2);
    }

    public static Long w(Map map) {
        return b1.l(map, "timeout");
    }

    public static Boolean x(Map map) {
        return b1.d(map, "waitForReady");
    }

    public static b1.b y(List list, rb.t0 t0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            String strA = aVar.a();
            rb.s0 s0VarD = t0Var.d(strA);
            if (s0VarD != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(j2.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                b1.b bVarE = s0VarD.e(aVar.b());
                return bVarE.d() != null ? bVarE : b1.b.a(new b(s0VarD, bVarE.c()));
            }
            arrayList.add(strA);
        }
        return b1.b.b(rb.k1.f19594g.r("None of " + arrayList + " specified by Service Config are available."));
    }

    public static a z(Map map) {
        if (map.size() == 1) {
            String str = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
            return new a(str, b1.j(map, str));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }
}
