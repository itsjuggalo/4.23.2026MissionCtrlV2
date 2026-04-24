package H3;

import G3.r;
import G3.s;
import K3.AbstractC0612b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G3.k f2637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f2638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2639c;

    public f(G3.k kVar, m mVar) {
        this(kVar, mVar, new ArrayList());
    }

    public static f c(r rVar, d dVar) {
        if (!rVar.e()) {
            return null;
        }
        if (dVar != null && dVar.c().isEmpty()) {
            return null;
        }
        if (dVar == null) {
            return rVar.j() ? new c(rVar.getKey(), m.f2654c) : new o(rVar.getKey(), rVar.getData(), m.f2654c);
        }
        s data = rVar.getData();
        s sVar = new s();
        HashSet hashSet = new HashSet();
        for (G3.q qVar : dVar.c()) {
            if (!hashSet.contains(qVar)) {
                if (data.i(qVar) == null && qVar.q() > 1) {
                    qVar = (G3.q) qVar.s();
                }
                sVar.l(qVar, data.i(qVar));
                hashSet.add(qVar);
            }
        }
        return new l(rVar.getKey(), sVar, d.b(hashSet), m.f2654c);
    }

    public abstract d a(r rVar, d dVar, Q2.s sVar);

    public abstract void b(r rVar, i iVar);

    public s d(G3.h hVar) {
        s sVar = null;
        for (e eVar : this.f2639c) {
            C2105D c2105dA = eVar.b().a(hVar.i(eVar.a()));
            if (c2105dA != null) {
                if (sVar == null) {
                    sVar = new s();
                }
                sVar.l(eVar.a(), c2105dA);
            }
        }
        return sVar;
    }

    public abstract d e();

    public List f() {
        return this.f2639c;
    }

    public G3.k g() {
        return this.f2637a;
    }

    public m h() {
        return this.f2638b;
    }

    public boolean i(f fVar) {
        return this.f2637a.equals(fVar.f2637a) && this.f2638b.equals(fVar.f2638b);
    }

    public int j() {
        return (g().hashCode() * 31) + this.f2638b.hashCode();
    }

    public String k() {
        return "key=" + this.f2637a + ", precondition=" + this.f2638b;
    }

    public Map l(Q2.s sVar, r rVar) {
        HashMap map = new HashMap(this.f2639c.size());
        for (e eVar : this.f2639c) {
            map.put(eVar.a(), eVar.b().c(rVar.i(eVar.a()), sVar));
        }
        return map;
    }

    public Map m(r rVar, List list) {
        HashMap map = new HashMap(this.f2639c.size());
        AbstractC0612b.d(this.f2639c.size() == list.size(), "server transform count (%d) should match field transform count (%d)", Integer.valueOf(list.size()), Integer.valueOf(this.f2639c.size()));
        for (int i7 = 0; i7 < list.size(); i7++) {
            e eVar = (e) this.f2639c.get(i7);
            map.put(eVar.a(), eVar.b().b(rVar.i(eVar.a()), (C2105D) list.get(i7)));
        }
        return map;
    }

    public void n(r rVar) {
        AbstractC0612b.d(rVar.getKey().equals(g()), "Can only apply a mutation to a document with the same key", new Object[0]);
    }

    public f(G3.k kVar, m mVar, List list) {
        this.f2637a = kVar;
        this.f2638b = mVar;
        this.f2639c = list;
    }
}
