package fh;

import bh.l;
import bh.m;
import fh.v;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v.a f9575a = new v.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v.a f9576b = new v.a();

    public static final Map b(bh.e eVar, eh.b bVar) {
        String lowerCase;
        String[] strArrNames;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean zD = d(bVar, eVar);
        m(eVar, bVar);
        int iL = eVar.l();
        for (int i10 = 0; i10 < iL; i10++) {
            List listN = eVar.n(i10);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listN) {
                if (obj instanceof eh.x) {
                    arrayList.add(obj);
                }
            }
            eh.x xVar = (eh.x) dd.a0.x0(arrayList);
            if (xVar != null && (strArrNames = xVar.names()) != null) {
                for (String lowerCase2 : strArrNames) {
                    if (zD) {
                        lowerCase2 = lowerCase2.toLowerCase(Locale.ROOT);
                        kotlin.jvm.internal.t.e(lowerCase2, "toLowerCase(...)");
                    }
                    c(linkedHashMap, eVar, lowerCase2, i10);
                }
            }
            if (zD) {
                lowerCase = eVar.m(i10).toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.t.e(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                c(linkedHashMap, eVar, lowerCase, i10);
            }
        }
        return linkedHashMap.isEmpty() ? dd.o0.h() : linkedHashMap;
    }

    public static final void c(Map map, bh.e eVar, String str, int i10) {
        String str2 = kotlin.jvm.internal.t.b(eVar.h(), l.b.f3401a) ? "enum value" : "property";
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i10));
            return;
        }
        throw new b0("The suggested name '" + str + "' for " + str2 + ' ' + eVar.m(i10) + " is already one of the names for " + str2 + ' ' + eVar.m(((Number) dd.o0.i(map, str)).intValue()) + " in " + eVar);
    }

    public static final boolean d(eh.b bVar, bh.e eVar) {
        return bVar.f().h() && kotlin.jvm.internal.t.b(eVar.h(), l.b.f3401a);
    }

    public static final Map e(final eh.b bVar, final bh.e descriptor) {
        kotlin.jvm.internal.t.f(bVar, "<this>");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return (Map) eh.g0.a(bVar).b(descriptor, f9575a, new Function0() { // from class: fh.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return e0.f(descriptor, bVar);
            }
        });
    }

    public static final Map f(bh.e eVar, eh.b bVar) {
        return b(eVar, bVar);
    }

    public static final v.a g() {
        return f9575a;
    }

    public static final String h(bh.e eVar, eh.b json, int i10) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        kotlin.jvm.internal.t.f(json, "json");
        m(eVar, json);
        return eVar.m(i10);
    }

    public static final int i(bh.e eVar, eh.b json, String name) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(name, "name");
        if (d(json, eVar)) {
            String lowerCase = name.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.t.e(lowerCase, "toLowerCase(...)");
            return l(eVar, json, lowerCase);
        }
        m(eVar, json);
        int iK = eVar.k(name);
        return (iK == -3 && json.f().o()) ? l(eVar, json, name) : iK;
    }

    public static final int j(bh.e eVar, eh.b json, String name, String suffix) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(suffix, "suffix");
        int i10 = i(eVar, json, name);
        if (i10 != -3) {
            return i10;
        }
        throw new zg.j(eVar.i() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static /* synthetic */ int k(bh.e eVar, eh.b bVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        return j(eVar, bVar, str, str2);
    }

    public static final int l(bh.e eVar, eh.b bVar, String str) {
        Integer num = (Integer) e(bVar, eVar).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final eh.y m(bh.e eVar, eh.b json) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        kotlin.jvm.internal.t.f(json, "json");
        if (kotlin.jvm.internal.t.b(eVar.h(), m.a.f3402a)) {
            json.f().l();
        }
        return null;
    }
}
