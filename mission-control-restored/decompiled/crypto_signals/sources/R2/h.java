package R2;

import Z1.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import s3.I0;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.h f2780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f2781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2782c;

    public h(Q2.h hVar, m mVar) {
        this(hVar, mVar, new ArrayList());
    }

    public static h c(Q2.k kVar, f fVar) {
        if (!kVar.c()) {
            return null;
        }
        if (fVar != null && fVar.f2777a.isEmpty()) {
            return null;
        }
        Q2.h hVar = kVar.f2679a;
        if (fVar == null) {
            return kVar.e() ? new e(hVar, m.f2791c) : new o(hVar, kVar.e, m.f2791c, new ArrayList());
        }
        Q2.l lVar = kVar.e;
        Q2.l lVar2 = new Q2.l();
        HashSet hashSet = new HashSet();
        for (Q2.j jVar : fVar.f2777a) {
            if (!hashSet.contains(jVar)) {
                if (lVar.f(jVar) == null && jVar.f2668a.size() > 1) {
                    jVar = (Q2.j) jVar.k();
                }
                lVar2.g(jVar, lVar.f(jVar));
                hashSet.add(jVar);
            }
        }
        return new l(hVar, lVar2, new f(hashSet), m.f2791c);
    }

    public abstract f a(Q2.k kVar, f fVar, r rVar);

    public abstract void b(Q2.k kVar, j jVar);

    public abstract f d();

    public final boolean e(h hVar) {
        return this.f2780a.equals(hVar.f2780a) && this.f2781b.equals(hVar.f2781b);
    }

    public final int f() {
        return this.f2781b.hashCode() + (this.f2780a.f2674a.hashCode() * 31);
    }

    public final String g() {
        return "key=" + this.f2780a + ", precondition=" + this.f2781b;
    }

    public final HashMap h(r rVar, Q2.k kVar) {
        List<g> list = this.f2782c;
        HashMap map = new HashMap(list.size());
        for (g gVar : list) {
            p pVar = gVar.f2779b;
            Q2.l lVar = kVar.e;
            Q2.j jVar = gVar.f2778a;
            map.put(jVar, pVar.a(lVar.f(jVar), rVar));
        }
        return map;
    }

    public final HashMap i(Q2.k kVar, ArrayList arrayList) {
        List list = this.f2782c;
        HashMap map = new HashMap(list.size());
        D1.b.w("server transform count (%d) should match field transform count (%d)", list.size() == arrayList.size(), Integer.valueOf(arrayList.size()), Integer.valueOf(list.size()));
        for (int i = 0; i < arrayList.size(); i++) {
            g gVar = (g) list.get(i);
            p pVar = gVar.f2779b;
            Q2.l lVar = kVar.e;
            Q2.j jVar = gVar.f2778a;
            map.put(jVar, pVar.c(lVar.f(jVar), (I0) arrayList.get(i)));
        }
        return map;
    }

    public final void j(Q2.k kVar) {
        D1.b.w("Can only apply a mutation to a document with the same key", kVar.f2679a.equals(this.f2780a), new Object[0]);
    }

    public h(Q2.h hVar, m mVar, List list) {
        this.f2780a = hVar;
        this.f2781b = mVar;
        this.f2782c = list;
    }
}
