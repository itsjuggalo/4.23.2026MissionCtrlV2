package k9;

import bb.d0;
import j9.r;
import j9.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.k f14776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f14777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14778c;

    public f(j9.k kVar, m mVar) {
        this(kVar, mVar, new ArrayList());
    }

    public static f c(r rVar, d dVar) {
        if (!rVar.d()) {
            return null;
        }
        if (dVar != null && dVar.c().isEmpty()) {
            return null;
        }
        if (dVar == null) {
            return rVar.i() ? new c(rVar.getKey(), m.f14793c) : new o(rVar.getKey(), rVar.getData(), m.f14793c);
        }
        s data = rVar.getData();
        s sVar = new s();
        HashSet hashSet = new HashSet();
        for (j9.q qVar : dVar.c()) {
            if (!hashSet.contains(qVar)) {
                if (data.i(qVar) == null && qVar.u() > 1) {
                    qVar = (j9.q) qVar.w();
                }
                sVar.l(qVar, data.i(qVar));
                hashSet.add(qVar);
            }
        }
        return new l(rVar.getKey(), sVar, d.b(hashSet), m.f14793c);
    }

    public abstract d a(r rVar, d dVar, a7.s sVar);

    public abstract void b(r rVar, i iVar);

    public s d(j9.h hVar) {
        s sVar = null;
        for (e eVar : this.f14778c) {
            d0 d0VarA = eVar.b().a(hVar.h(eVar.a()));
            if (d0VarA != null) {
                if (sVar == null) {
                    sVar = new s();
                }
                sVar.l(eVar.a(), d0VarA);
            }
        }
        return sVar;
    }

    public abstract d e();

    public List f() {
        return this.f14778c;
    }

    public j9.k g() {
        return this.f14776a;
    }

    public m h() {
        return this.f14777b;
    }

    public boolean i(f fVar) {
        return this.f14776a.equals(fVar.f14776a) && this.f14777b.equals(fVar.f14777b);
    }

    public int j() {
        return (g().hashCode() * 31) + this.f14777b.hashCode();
    }

    public String k() {
        return "key=" + this.f14776a + ", precondition=" + this.f14777b;
    }

    public Map l(a7.s sVar, r rVar) {
        HashMap map = new HashMap(this.f14778c.size());
        for (e eVar : this.f14778c) {
            map.put(eVar.a(), eVar.b().c(rVar.h(eVar.a()), sVar));
        }
        return map;
    }

    public Map m(r rVar, List list) {
        HashMap map = new HashMap(this.f14778c.size());
        n9.b.d(this.f14778c.size() == list.size(), "server transform count (%d) should match field transform count (%d)", Integer.valueOf(list.size()), Integer.valueOf(this.f14778c.size()));
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = (e) this.f14778c.get(i10);
            map.put(eVar.a(), eVar.b().b(rVar.h(eVar.a()), (d0) list.get(i10)));
        }
        return map;
    }

    public void n(r rVar) {
        n9.b.d(rVar.getKey().equals(g()), "Can only apply a mutation to a document with the same key", new Object[0]);
    }

    public f(j9.k kVar, m mVar, List list) {
        this.f14776a = kVar;
        this.f14777b = mVar;
        this.f14778c = list;
    }
}
