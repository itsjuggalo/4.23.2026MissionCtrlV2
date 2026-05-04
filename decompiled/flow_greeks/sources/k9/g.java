package k9;

import a7.s;
import i9.g1;
import j9.r;
import j9.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f14780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f14782d;

    public g(int i10, s sVar, List list, List list2) {
        n9.b.d(!list2.isEmpty(), "Cannot create an empty mutation batch", new Object[0]);
        this.f14779a = i10;
        this.f14780b = sVar;
        this.f14781c = list;
        this.f14782d = list2;
    }

    public Map a(Map map, Set set) {
        HashMap map2 = new HashMap();
        for (j9.k kVar : f()) {
            r rVar = (r) ((g1) map.get(kVar)).a();
            d dVarB = b(rVar, ((g1) map.get(kVar)).b());
            if (set.contains(kVar)) {
                dVarB = null;
            }
            f fVarC = f.c(rVar, dVarB);
            if (fVarC != null) {
                map2.put(kVar, fVarC);
            }
            if (!rVar.o()) {
                rVar.m(v.f14278b);
            }
        }
        return map2;
    }

    public d b(r rVar, d dVar) {
        for (int i10 = 0; i10 < this.f14781c.size(); i10++) {
            f fVar = (f) this.f14781c.get(i10);
            if (fVar.g().equals(rVar.getKey())) {
                dVar = fVar.a(rVar, dVar, this.f14780b);
            }
        }
        for (int i11 = 0; i11 < this.f14782d.size(); i11++) {
            f fVar2 = (f) this.f14782d.get(i11);
            if (fVar2.g().equals(rVar.getKey())) {
                dVar = fVar2.a(rVar, dVar, this.f14780b);
            }
        }
        return dVar;
    }

    public void c(r rVar, h hVar) {
        int size = this.f14782d.size();
        List listE = hVar.e();
        n9.b.d(listE.size() == size, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(listE.size()));
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = (f) this.f14782d.get(i10);
            if (fVar.g().equals(rVar.getKey())) {
                fVar.b(rVar, (i) listE.get(i10));
            }
        }
    }

    public List d() {
        return this.f14781c;
    }

    public int e() {
        return this.f14779a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f14779a == gVar.f14779a && this.f14780b.equals(gVar.f14780b) && this.f14781c.equals(gVar.f14781c) && this.f14782d.equals(gVar.f14782d)) {
                return true;
            }
        }
        return false;
    }

    public Set f() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f14782d.iterator();
        while (it.hasNext()) {
            hashSet.add(((f) it.next()).g());
        }
        return hashSet;
    }

    public s g() {
        return this.f14780b;
    }

    public List h() {
        return this.f14782d;
    }

    public int hashCode() {
        return (((((this.f14779a * 31) + this.f14780b.hashCode()) * 31) + this.f14781c.hashCode()) * 31) + this.f14782d.hashCode();
    }

    public String toString() {
        return "MutationBatch(batchId=" + this.f14779a + ", localWriteTime=" + this.f14780b + ", baseMutations=" + this.f14781c + ", mutations=" + this.f14782d + ')';
    }
}
