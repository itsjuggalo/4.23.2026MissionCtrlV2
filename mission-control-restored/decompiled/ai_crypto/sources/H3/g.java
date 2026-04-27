package H3;

import F3.C0499h0;
import G3.r;
import G3.v;
import K3.AbstractC0612b;
import Q2.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f2641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2643d;

    public g(int i7, s sVar, List list, List list2) {
        AbstractC0612b.d(!list2.isEmpty(), "Cannot create an empty mutation batch", new Object[0]);
        this.f2640a = i7;
        this.f2641b = sVar;
        this.f2642c = list;
        this.f2643d = list2;
    }

    public Map a(Map map, Set set) {
        HashMap map2 = new HashMap();
        for (G3.k kVar : f()) {
            r rVar = (r) ((C0499h0) map.get(kVar)).a();
            d dVarB = b(rVar, ((C0499h0) map.get(kVar)).b());
            if (set.contains(kVar)) {
                dVarB = null;
            }
            f fVarC = f.c(rVar, dVarB);
            if (fVarC != null) {
                map2.put(kVar, fVarC);
            }
            if (!rVar.p()) {
                rVar.n(v.f2475b);
            }
        }
        return map2;
    }

    public d b(r rVar, d dVar) {
        for (int i7 = 0; i7 < this.f2642c.size(); i7++) {
            f fVar = (f) this.f2642c.get(i7);
            if (fVar.g().equals(rVar.getKey())) {
                dVar = fVar.a(rVar, dVar, this.f2641b);
            }
        }
        for (int i8 = 0; i8 < this.f2643d.size(); i8++) {
            f fVar2 = (f) this.f2643d.get(i8);
            if (fVar2.g().equals(rVar.getKey())) {
                dVar = fVar2.a(rVar, dVar, this.f2641b);
            }
        }
        return dVar;
    }

    public void c(r rVar, h hVar) {
        int size = this.f2643d.size();
        List listE = hVar.e();
        AbstractC0612b.d(listE.size() == size, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(listE.size()));
        for (int i7 = 0; i7 < size; i7++) {
            f fVar = (f) this.f2643d.get(i7);
            if (fVar.g().equals(rVar.getKey())) {
                fVar.b(rVar, (i) listE.get(i7));
            }
        }
    }

    public List d() {
        return this.f2642c;
    }

    public int e() {
        return this.f2640a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f2640a == gVar.f2640a && this.f2641b.equals(gVar.f2641b) && this.f2642c.equals(gVar.f2642c) && this.f2643d.equals(gVar.f2643d);
    }

    public Set f() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f2643d.iterator();
        while (it.hasNext()) {
            hashSet.add(((f) it.next()).g());
        }
        return hashSet;
    }

    public s g() {
        return this.f2641b;
    }

    public List h() {
        return this.f2643d;
    }

    public int hashCode() {
        return (((((this.f2640a * 31) + this.f2641b.hashCode()) * 31) + this.f2642c.hashCode()) * 31) + this.f2643d.hashCode();
    }

    public String toString() {
        return "MutationBatch(batchId=" + this.f2640a + ", localWriteTime=" + this.f2641b + ", baseMutations=" + this.f2642c + ", mutations=" + this.f2643d + ')';
    }
}
