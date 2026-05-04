package se;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ve.g f20215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f20216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pd.k f20217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f20218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f20219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f20220f;

    public b(ve.g jClass, pd.k memberFilter) {
        kotlin.jvm.internal.t.f(jClass, "jClass");
        kotlin.jvm.internal.t.f(memberFilter, "memberFilter");
        this.f20215a = jClass;
        this.f20216b = memberFilter;
        a aVar = new a(this);
        this.f20217c = aVar;
        jg.h hVarX = jg.t.x(dd.a0.Q(jClass.L()), aVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : hVarX) {
            ef.f name = ((ve.r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f20218d = linkedHashMap;
        jg.h hVarX2 = jg.t.x(dd.a0.Q(this.f20215a.C()), this.f20216b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : hVarX2) {
            linkedHashMap2.put(((ve.n) obj2).getName(), obj2);
        }
        this.f20219e = linkedHashMap2;
        Collection collectionL = this.f20215a.l();
        pd.k kVar = this.f20216b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : collectionL) {
            if (((Boolean) kVar.invoke(obj3)).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((ve.w) obj4).getName(), obj4);
        }
        this.f20220f = linkedHashMap3;
    }

    public static final boolean h(b bVar, ve.r m10) {
        kotlin.jvm.internal.t.f(m10, "m");
        return ((Boolean) bVar.f20216b.invoke(m10)).booleanValue() && !ve.p.c(m10);
    }

    @Override // se.c
    public Set a() {
        jg.h hVarX = jg.t.x(dd.a0.Q(this.f20215a.L()), this.f20217c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = hVarX.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((ve.r) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // se.c
    public ve.w b(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        return (ve.w) this.f20220f.get(name);
    }

    @Override // se.c
    public Set c() {
        return this.f20220f.keySet();
    }

    @Override // se.c
    public ve.n d(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        return (ve.n) this.f20219e.get(name);
    }

    @Override // se.c
    public Collection e(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        List list = (List) this.f20218d.get(name);
        return list != null ? list : dd.r.k();
    }

    @Override // se.c
    public Set f() {
        jg.h hVarX = jg.t.x(dd.a0.Q(this.f20215a.C()), this.f20216b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = hVarX.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((ve.n) it.next()).getName());
        }
        return linkedHashSet;
    }
}
