package L3;

import H3.j;
import L3.C0401y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0401y.a f1441a = new C0401y.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0401y.a f1442b = new C0401y.a();

    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ H3.e f1443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ K3.a f1444b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(H3.e eVar, K3.a aVar) {
            super(0);
            this.f1443a = eVar;
            this.f1444b = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map invoke() {
            return F.b(this.f1443a, this.f1444b);
        }
    }

    public static final Map b(H3.e eVar, K3.a aVar) {
        String[] strArrNames;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        k(eVar, aVar);
        int iF = eVar.f();
        for (int i4 = 0; i4 < iF; i4++) {
            List listH = eVar.h(i4);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listH) {
                if (obj instanceof K3.q) {
                    arrayList.add(obj);
                }
            }
            K3.q qVar = (K3.q) X2.x.Y(arrayList);
            if (qVar != null && (strArrNames = qVar.names()) != null) {
                for (String str : strArrNames) {
                    c(linkedHashMap, eVar, str, i4);
                }
            }
        }
        return linkedHashMap.isEmpty() ? X2.L.e() : linkedHashMap;
    }

    public static final void c(Map map, H3.e eVar, String str, int i4) {
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i4));
            return;
        }
        throw new D("The suggested name '" + str + "' for property " + eVar.g(i4) + " is already one of the names for property " + eVar.g(((Number) X2.L.f(map, str)).intValue()) + " in " + eVar);
    }

    public static final Map d(K3.a aVar, H3.e descriptor) {
        kotlin.jvm.internal.r.f(aVar, "<this>");
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return (Map) K3.y.a(aVar).b(descriptor, f1441a, new a(descriptor, aVar));
    }

    public static final C0401y.a e() {
        return f1441a;
    }

    public static final String f(H3.e eVar, K3.a json, int i4) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        kotlin.jvm.internal.r.f(json, "json");
        k(eVar, json);
        return eVar.g(i4);
    }

    public static final int g(H3.e eVar, K3.a json, String name) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(name, "name");
        k(eVar, json);
        int iD = eVar.d(name);
        return (iD == -3 && json.f().k()) ? h(json, eVar, name) : iD;
    }

    public static final int h(K3.a aVar, H3.e eVar, String str) {
        Integer num = (Integer) d(aVar, eVar).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int i(H3.e eVar, K3.a json, String name, String suffix) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(name, "name");
        kotlin.jvm.internal.r.f(suffix, "suffix");
        int iG = g(eVar, json, name);
        if (iG != -3) {
            return iG;
        }
        throw new F3.g(eVar.a() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static /* synthetic */ int j(H3.e eVar, K3.a aVar, String str, String str2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str2 = "";
        }
        return i(eVar, aVar, str, str2);
    }

    public static final K3.r k(H3.e eVar, K3.a json) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        kotlin.jvm.internal.r.f(json, "json");
        if (kotlin.jvm.internal.r.b(eVar.e(), j.a.f766a)) {
            json.f().h();
        }
        return null;
    }
}
