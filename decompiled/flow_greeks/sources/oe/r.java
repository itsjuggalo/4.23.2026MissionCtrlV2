package oe;

import ef.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f18056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f18057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f18058c;

    static {
        r rVar = new r();
        f18056a = rVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f18057b = linkedHashMap;
        ef.i iVar = ef.i.f8818a;
        rVar.c(iVar.l(), rVar.a("java.util.ArrayList", "java.util.LinkedList"));
        rVar.c(iVar.n(), rVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        rVar.c(iVar.m(), rVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        b.a aVar = ef.b.f8779d;
        rVar.c(aVar.c(new ef.c("java.util.function.Function")), rVar.a("java.util.function.UnaryOperator"));
        rVar.c(aVar.c(new ef.c("java.util.function.BiFunction")), rVar.a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(cd.w.a(((ef.b) entry.getKey()).a(), ((ef.b) entry.getValue()).a()));
        }
        f18058c = dd.o0.t(arrayList);
    }

    public final List a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(ef.b.f8779d.c(new ef.c(str)));
        }
        return arrayList;
    }

    public final ef.c b(ef.c classFqName) {
        kotlin.jvm.internal.t.f(classFqName, "classFqName");
        return (ef.c) f18058c.get(classFqName);
    }

    public final void c(ef.b bVar, List list) {
        Map map = f18057b;
        for (Object obj : list) {
            map.put(obj, bVar);
        }
    }
}
