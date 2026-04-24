package e6;

import h6.InterfaceC1898g;
import h6.InterfaceC1905n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: e6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1700b implements InterfaceC1701c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1898g f17269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f17270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B5.k f17271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f17272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f17273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f17274f;

    public C1700b(InterfaceC1898g jClass, B5.k memberFilter) {
        AbstractC2304t.f(jClass, "jClass");
        AbstractC2304t.f(memberFilter, "memberFilter");
        this.f17269a = jClass;
        this.f17270b = memberFilter;
        C1699a c1699a = new C1699a(this);
        this.f17271c = c1699a;
        U6.h hVarU = U6.r.u(p5.z.P(jClass.M()), c1699a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : hVarU) {
            q6.f name = ((h6.r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f17272d = linkedHashMap;
        U6.h hVarU2 = U6.r.u(p5.z.P(this.f17269a.B()), this.f17270b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : hVarU2) {
            linkedHashMap2.put(((InterfaceC1905n) obj2).getName(), obj2);
        }
        this.f17273e = linkedHashMap2;
        Collection collectionH = this.f17269a.h();
        B5.k kVar = this.f17270b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : collectionH) {
            if (((Boolean) kVar.invoke(obj3)).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(H5.i.b(p5.L.d(p5.r.s(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((h6.w) obj4).getName(), obj4);
        }
        this.f17274f = linkedHashMap3;
    }

    public static final boolean h(C1700b c1700b, h6.r m8) {
        AbstractC2304t.f(m8, "m");
        return ((Boolean) c1700b.f17270b.invoke(m8)).booleanValue() && !h6.p.c(m8);
    }

    @Override // e6.InterfaceC1701c
    public Set a() {
        U6.h hVarU = U6.r.u(p5.z.P(this.f17269a.M()), this.f17271c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = hVarU.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((h6.r) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // e6.InterfaceC1701c
    public Collection b(q6.f name) {
        AbstractC2304t.f(name, "name");
        List list = (List) this.f17272d.get(name);
        return list != null ? list : AbstractC2595q.i();
    }

    @Override // e6.InterfaceC1701c
    public Set c() {
        return this.f17274f.keySet();
    }

    @Override // e6.InterfaceC1701c
    public InterfaceC1905n d(q6.f name) {
        AbstractC2304t.f(name, "name");
        return (InterfaceC1905n) this.f17273e.get(name);
    }

    @Override // e6.InterfaceC1701c
    public h6.w e(q6.f name) {
        AbstractC2304t.f(name, "name");
        return (h6.w) this.f17274f.get(name);
    }

    @Override // e6.InterfaceC1701c
    public Set f() {
        U6.h hVarU = U6.r.u(p5.z.P(this.f17269a.B()), this.f17270b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = hVarU.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((InterfaceC1905n) it.next()).getName());
        }
        return linkedHashSet;
    }
}
