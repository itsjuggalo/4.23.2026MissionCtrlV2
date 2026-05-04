package j8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o8.e;
import o8.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f14154a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l8.e f14155b;

    public w(l8.e eVar) {
        this.f14155b = eVar;
    }

    public List a(i iVar, h0 h0Var, o8.a aVar) {
        o8.i iVarE = iVar.e();
        o8.j jVarG = g(iVarE, h0Var, aVar);
        if (!iVarE.g()) {
            HashSet hashSet = new HashSet();
            Iterator it = jVarG.f().iterator();
            while (it.hasNext()) {
                hashSet.add(((r8.m) it.next()).c());
            }
            this.f14155b.j(iVarE, hashSet);
        }
        if (!this.f14154a.containsKey(iVarE.d())) {
            this.f14154a.put(iVarE.d(), jVarG);
        }
        this.f14154a.put(iVarE.d(), jVarG);
        jVarG.a(iVar);
        return jVarG.g(iVar);
    }

    public List b(k8.d dVar, h0 h0Var, r8.n nVar) {
        o8.h hVarB = dVar.b().b();
        if (hVarB != null) {
            o8.j jVar = (o8.j) this.f14154a.get(hVarB);
            m8.m.f(jVar != null);
            return c(jVar, dVar, h0Var, nVar);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f14154a.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(c((o8.j) ((Map.Entry) it.next()).getValue(), dVar, h0Var, nVar));
        }
        return arrayList;
    }

    public final List c(o8.j jVar, k8.d dVar, h0 h0Var, r8.n nVar) {
        j.a aVarB = jVar.b(dVar, h0Var, nVar);
        if (!jVar.h().g()) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (o8.c cVar : aVarB.f17650b) {
                e.a aVarJ = cVar.j();
                if (aVarJ == e.a.CHILD_ADDED) {
                    hashSet2.add(cVar.i());
                } else if (aVarJ == e.a.CHILD_REMOVED) {
                    hashSet.add(cVar.i());
                }
            }
            if (!hashSet2.isEmpty() || !hashSet.isEmpty()) {
                this.f14155b.h(jVar.h(), hashSet2, hashSet);
            }
        }
        return aVarB.f17649a;
    }

    public r8.n d(l lVar) {
        Iterator it = this.f14154a.values().iterator();
        while (it.hasNext()) {
            r8.n nVarE = ((o8.j) it.next()).e(lVar);
            if (nVarE != null) {
                return nVarE;
            }
        }
        return null;
    }

    public o8.j e() {
        Iterator it = this.f14154a.entrySet().iterator();
        while (it.hasNext()) {
            o8.j jVar = (o8.j) ((Map.Entry) it.next()).getValue();
            if (jVar.h().g()) {
                return jVar;
            }
        }
        return null;
    }

    public List f() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f14154a.entrySet().iterator();
        while (it.hasNext()) {
            o8.j jVar = (o8.j) ((Map.Entry) it.next()).getValue();
            if (!jVar.h().g()) {
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    public o8.j g(o8.i iVar, h0 h0Var, o8.a aVar) {
        boolean z10;
        o8.j jVar = (o8.j) this.f14154a.get(iVar.d());
        if (jVar != null) {
            return jVar;
        }
        r8.n nVarB = h0Var.b(aVar.f() ? aVar.b() : null);
        if (nVarB != null) {
            z10 = true;
        } else {
            nVarB = h0Var.e(aVar.b() != null ? aVar.b() : r8.g.y());
            z10 = false;
        }
        return new o8.j(iVar, new o8.k(new o8.a(r8.i.d(nVarB, iVar.c()), z10, false), aVar));
    }

    public boolean h() {
        return e() != null;
    }

    public boolean i() {
        return this.f14154a.isEmpty();
    }

    public m8.g j(o8.i iVar, i iVar2, e8.c cVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean zH = h();
        if (iVar.f()) {
            Iterator it = this.f14154a.entrySet().iterator();
            while (it.hasNext()) {
                o8.j jVar = (o8.j) ((Map.Entry) it.next()).getValue();
                arrayList2.addAll(jVar.k(iVar2, cVar));
                if (jVar.j()) {
                    it.remove();
                    if (!jVar.h().g()) {
                        arrayList.add(jVar.h());
                    }
                }
            }
        } else {
            o8.j jVar2 = (o8.j) this.f14154a.get(iVar.d());
            if (jVar2 != null) {
                arrayList2.addAll(jVar2.k(iVar2, cVar));
                if (jVar2.j()) {
                    this.f14154a.remove(iVar.d());
                    if (!jVar2.h().g()) {
                        arrayList.add(jVar2.h());
                    }
                }
            }
        }
        if (zH && !h()) {
            arrayList.add(o8.i.a(iVar.e()));
        }
        return new m8.g(arrayList, arrayList2);
    }

    public boolean k(o8.i iVar) {
        return l(iVar) != null;
    }

    public o8.j l(o8.i iVar) {
        return iVar.g() ? e() : (o8.j) this.f14154a.get(iVar.d());
    }
}
