package B6;

import B6.n;
import I6.S;
import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import R5.InterfaceC0868z;
import R5.Z;
import R5.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.O;
import p5.AbstractC2595q;
import p5.z;
import u6.AbstractC2798m;
import u6.C2800o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f207d = {O.g(new G(f.class, "allDescriptors", "getAllDescriptors()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0848e f208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H6.i f209c;

    public static final class a extends AbstractC2798m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f211b;

        public a(ArrayList arrayList, f fVar) {
            this.f210a = arrayList;
            this.f211b = fVar;
        }

        @Override // u6.AbstractC2799n
        public void a(InterfaceC0845b fakeOverride) {
            AbstractC2304t.f(fakeOverride, "fakeOverride");
            C2800o.K(fakeOverride, null);
            this.f210a.add(fakeOverride);
        }

        @Override // u6.AbstractC2798m
        public void e(InterfaceC0845b fromSuper, InterfaceC0845b fromCurrent) {
            AbstractC2304t.f(fromSuper, "fromSuper");
            AbstractC2304t.f(fromCurrent, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f211b.m() + ": " + fromSuper + " vs " + fromCurrent).toString());
        }
    }

    public f(H6.n storageManager, InterfaceC0848e containingClass) {
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(containingClass, "containingClass");
        this.f208b = containingClass;
        this.f209c = storageManager.e(new e(this));
    }

    public static final List i(f fVar) {
        List listJ = fVar.j();
        return z.r0(listJ, fVar.k(listJ));
    }

    @Override // B6.l, B6.k
    public Collection a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        List listL = l();
        if (listL.isEmpty()) {
            return AbstractC2595q.i();
        }
        S6.k kVar = new S6.k();
        for (Object obj : listL) {
            if ((obj instanceof Z) && AbstractC2304t.b(((Z) obj).getName(), name)) {
                kVar.add(obj);
            }
        }
        return kVar;
    }

    @Override // B6.l, B6.k
    public Collection d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        List listL = l();
        if (listL.isEmpty()) {
            return AbstractC2595q.i();
        }
        S6.k kVar = new S6.k();
        for (Object obj : listL) {
            if ((obj instanceof g0) && AbstractC2304t.b(((g0) obj).getName(), name)) {
                kVar.add(obj);
            }
        }
        return kVar;
    }

    @Override // B6.l, B6.n
    public Collection g(d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        return !kindFilter.a(d.f191p.m()) ? AbstractC2595q.i() : l();
    }

    public abstract List j();

    public final List k(List list) {
        Collection collectionI;
        ArrayList arrayList = new ArrayList(3);
        Collection collectionR = this.f208b.l().r();
        AbstractC2304t.e(collectionR, "getSupertypes(...)");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = collectionR.iterator();
        while (it.hasNext()) {
            p5.v.x(arrayList2, n.a.a(((S) it.next()).r(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof InterfaceC0845b) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            q6.f name = ((InterfaceC0845b) obj2).getName();
            Object arrayList4 = linkedHashMap.get(name);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(name, arrayList4);
            }
            ((List) arrayList4).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            AbstractC2304t.e(key, "component1(...)");
            q6.f fVar = (q6.f) key;
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                Boolean boolValueOf = Boolean.valueOf(((InterfaceC0845b) obj3) instanceof InterfaceC0868z);
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
                C2800o c2800o = C2800o.f23551f;
                if (zBooleanValue) {
                    collectionI = new ArrayList();
                    for (Object obj4 : list) {
                        if (AbstractC2304t.b(((InterfaceC0868z) obj4).getName(), fVar)) {
                            collectionI.add(obj4);
                        }
                    }
                } else {
                    collectionI = AbstractC2595q.i();
                }
                c2800o.v(fVar, list3, collectionI, this.f208b, new a(arrayList, this));
            }
        }
        return S6.a.c(arrayList);
    }

    public final List l() {
        return (List) H6.m.a(this.f209c, this, f207d[0]);
    }

    public final InterfaceC0848e m() {
        return this.f208b;
    }
}
