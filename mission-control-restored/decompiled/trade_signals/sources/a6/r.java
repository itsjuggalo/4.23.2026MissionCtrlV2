package a6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import q6.b;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f10153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f10154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f10155c;

    static {
        r rVar = new r();
        f10153a = rVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f10154b = linkedHashMap;
        q6.i iVar = q6.i.f22733a;
        rVar.c(iVar.l(), rVar.a("java.util.ArrayList", "java.util.LinkedList"));
        rVar.c(iVar.n(), rVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        rVar.c(iVar.m(), rVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        b.a aVar = q6.b.f22655d;
        rVar.c(aVar.c(new q6.c("java.util.function.Function")), rVar.a("java.util.function.UnaryOperator"));
        rVar.c(aVar.c(new q6.c("java.util.function.BiFunction")), rVar.a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(o5.w.a(((q6.b) entry.getKey()).a(), ((q6.b) entry.getValue()).a()));
        }
        f10155c = p5.M.u(arrayList);
    }

    public final List a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(q6.b.f22655d.c(new q6.c(str)));
        }
        return arrayList;
    }

    public final q6.c b(q6.c classFqName) {
        AbstractC2304t.f(classFqName, "classFqName");
        return (q6.c) f10155c.get(classFqName);
    }

    public final void c(q6.b bVar, List list) {
        Map map = f10154b;
        for (Object obj : list) {
            map.put(obj, bVar);
        }
    }
}
