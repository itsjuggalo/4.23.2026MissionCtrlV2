package qf;

import dd.a0;
import fe.f1;
import fe.y0;
import fe.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.n0;
import qf.n;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f19075d = {n0.g(new g0(f.class, "allDescriptors", "getAllDescriptors()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.e f19076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.i f19077c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends jf.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f19078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f19079b;

        public a(ArrayList arrayList, f fVar) {
            this.f19078a = arrayList;
            this.f19079b = fVar;
        }

        @Override // jf.n
        public void a(fe.b fakeOverride) {
            kotlin.jvm.internal.t.f(fakeOverride, "fakeOverride");
            jf.o.K(fakeOverride, null);
            this.f19078a.add(fakeOverride);
        }

        @Override // jf.m
        public void e(fe.b fromSuper, fe.b fromCurrent) {
            kotlin.jvm.internal.t.f(fromSuper, "fromSuper");
            kotlin.jvm.internal.t.f(fromCurrent, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f19079b.m() + ": " + fromSuper + " vs " + fromCurrent).toString());
        }
    }

    public f(wf.n storageManager, fe.e containingClass) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(containingClass, "containingClass");
        this.f19076b = containingClass;
        this.f19077c = storageManager.e(new e(this));
    }

    public static final List i(f fVar) {
        List listJ = fVar.j();
        return a0.s0(listJ, fVar.k(listJ));
    }

    @Override // qf.l, qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        List listL = l();
        if (listL.isEmpty()) {
            return dd.r.k();
        }
        hg.k kVar = new hg.k();
        for (Object obj : listL) {
            if ((obj instanceof y0) && kotlin.jvm.internal.t.b(((y0) obj).getName(), name)) {
                kVar.add(obj);
            }
        }
        return kVar;
    }

    @Override // qf.l, qf.k
    public Collection c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        List listL = l();
        if (listL.isEmpty()) {
            return dd.r.k();
        }
        hg.k kVar = new hg.k();
        for (Object obj : listL) {
            if ((obj instanceof f1) && kotlin.jvm.internal.t.b(((f1) obj).getName(), name)) {
                kVar.add(obj);
            }
        }
        return kVar;
    }

    @Override // qf.l, qf.n
    public Collection g(d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        return !kindFilter.a(d.f19059p.m()) ? dd.r.k() : l();
    }

    public abstract List j();

    public final List k(List list) {
        Collection collectionK;
        ArrayList arrayList = new ArrayList(3);
        Collection collectionC = this.f19076b.k().c();
        kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = collectionC.iterator();
        while (it.hasNext()) {
            dd.w.z(arrayList2, n.a.a(((r0) it.next()).q(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof fe.b) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            ef.f name = ((fe.b) obj2).getName();
            Object arrayList4 = linkedHashMap.get(name);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(name, arrayList4);
            }
            ((List) arrayList4).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            kotlin.jvm.internal.t.e(key, "component1(...)");
            ef.f fVar = (ef.f) key;
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                Boolean boolValueOf = Boolean.valueOf(((fe.b) obj3) instanceof z);
                Object arrayList5 = linkedHashMap2.get(boolValueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(boolValueOf, arrayList5);
                }
                ((List) arrayList5).add(obj3);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                jf.o oVar = jf.o.f14337f;
                if (zBooleanValue) {
                    collectionK = new ArrayList();
                    for (Object obj4 : list) {
                        if (kotlin.jvm.internal.t.b(((z) obj4).getName(), fVar)) {
                            collectionK.add(obj4);
                        }
                    }
                } else {
                    collectionK = dd.r.k();
                }
                oVar.v(fVar, list3, collectionK, this.f19076b, new a(arrayList, this));
            }
        }
        return hg.a.c(arrayList);
    }

    public final List l() {
        return (List) wf.m.a(this.f19077c, this, f19075d[0]);
    }

    public final fe.e m() {
        return this.f19076b;
    }
}
