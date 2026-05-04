package j8;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import j8.f0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import r8.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends c.AbstractC0339c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f14143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f14144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u f14145c;

        public a(f0 f0Var, Map map, u uVar) {
            this.f14143a = f0Var;
            this.f14144b = map;
            this.f14145c = uVar;
        }

        @Override // r8.c.AbstractC0339c
        public void b(r8.b bVar, r8.n nVar) {
            r8.n nVarH = t.h(nVar, this.f14143a.a(bVar), this.f14144b);
            if (nVarH != nVar) {
                this.f14145c.c(new l(bVar.b()), nVarH);
            }
        }
    }

    public static boolean b(Number number) {
        return ((number instanceof Double) || (number instanceof Float)) ? false : true;
    }

    public static Map c(m8.a aVar) {
        HashMap map = new HashMap();
        map.put(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(aVar.millis()));
        return map;
    }

    public static Object d(Map map, f0 f0Var, Map map2) {
        if (!map.containsKey("increment")) {
            return null;
        }
        Object obj = map.get("increment");
        if (!(obj instanceof Number)) {
            return null;
        }
        Number number = (Number) obj;
        r8.n nVarB = f0Var.b();
        if (!nVarB.J() || !(nVarB.getValue() instanceof Number)) {
            return number;
        }
        Number number2 = (Number) nVarB.getValue();
        if (b(number) && b(number2)) {
            long jLongValue = number.longValue();
            long jLongValue2 = number2.longValue();
            long j10 = jLongValue + jLongValue2;
            if (((jLongValue ^ j10) & (jLongValue2 ^ j10)) >= 0) {
                return Long.valueOf(j10);
            }
        }
        return Double.valueOf(number.doubleValue() + number2.doubleValue());
    }

    public static Object e(Object obj, f0 f0Var, Map map) {
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map2 = (Map) obj;
        if (map2.containsKey(".sv")) {
            Object obj2 = map2.get(".sv");
            Object objJ = obj2 instanceof String ? j((String) obj2, map) : obj2 instanceof Map ? d((Map) obj2, f0Var, map) : null;
            if (objJ != null) {
                return objJ;
            }
        }
        return obj;
    }

    public static b f(b bVar, y yVar, l lVar, Map map) {
        b bVarQ = b.q();
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            bVarQ = bVarQ.a((l) entry.getKey(), h((r8.n) entry.getValue(), new f0.a(yVar, lVar.u((l) entry.getKey())), map));
        }
        return bVarQ;
    }

    public static r8.n g(r8.n nVar, y yVar, l lVar, Map map) {
        return h(nVar, new f0.a(yVar, lVar), map);
    }

    public static r8.n h(r8.n nVar, f0 f0Var, Map map) {
        Object value = nVar.n().getValue();
        Object objE = e(value, f0Var.a(r8.b.h(".priority")), map);
        if (nVar.J()) {
            Object objE2 = e(nVar.getValue(), f0Var, map);
            if (!objE2.equals(nVar.getValue()) || !m8.m.d(objE, value)) {
                return r8.o.b(objE2, r8.r.d(objE));
            }
        } else if (!nVar.isEmpty()) {
            r8.c cVar = (r8.c) nVar;
            u uVar = new u(cVar);
            cVar.q(new a(f0Var, map, uVar));
            return !uVar.b().n().equals(objE) ? uVar.b().D(r8.r.d(objE)) : uVar.b();
        }
        return nVar;
    }

    public static r8.n i(r8.n nVar, r8.n nVar2, Map map) {
        return h(nVar, new f0.b(nVar2), map);
    }

    public static Object j(String str, Map map) {
        if (DiagnosticsEntry.TIMESTAMP_KEY.equals(str) && map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }
}
