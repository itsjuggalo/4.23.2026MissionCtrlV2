package o8;

import j8.h0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k8.d;
import m8.m;
import o8.l;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f17644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f17645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f17646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f17647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f17648e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f17649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f17650b;

        public a(List list, List list2) {
            this.f17649a = list;
            this.f17650b = list2;
        }
    }

    public j(i iVar, k kVar) {
        this.f17644a = iVar;
        p8.b bVar = new p8.b(iVar.c());
        p8.d dVarJ = iVar.d().j();
        this.f17645b = new l(dVarJ);
        o8.a aVarD = kVar.d();
        o8.a aVarC = kVar.c();
        r8.i iVarD = r8.i.d(r8.g.y(), iVar.c());
        r8.i iVarC = bVar.c(iVarD, aVarD.a(), null);
        r8.i iVarC2 = dVarJ.c(iVarD, aVarC.a(), null);
        this.f17646c = new k(new o8.a(iVarC2, aVarC.f(), dVarJ.b()), new o8.a(iVarC, aVarD.f(), bVar.b()));
        this.f17647d = new ArrayList();
        this.f17648e = new f(iVar);
    }

    public void a(j8.i iVar) {
        this.f17647d.add(iVar);
    }

    public a b(k8.d dVar, h0 h0Var, n nVar) {
        if (dVar.c() == d.a.Merge && dVar.b().b() != null) {
            m.g(this.f17646c.b() != null, "We should always have a full cache before handling merges");
            m.g(this.f17646c.a() != null, "Missing event cache, even though we have a server cache");
        }
        k kVar = this.f17646c;
        l.c cVarB = this.f17645b.b(kVar, dVar, h0Var, nVar);
        m.g(cVarB.f17656a.d().f() || !kVar.d().f(), "Once a server snap is complete, it should never go back");
        k kVar2 = cVarB.f17656a;
        this.f17646c = kVar2;
        return new a(c(cVarB.f17657b, kVar2.c().a(), null), cVarB.f17657b);
    }

    public final List c(List list, r8.i iVar, j8.i iVar2) {
        return this.f17648e.d(list, iVar, iVar2 == null ? this.f17647d : Arrays.asList(iVar2));
    }

    public n d() {
        return this.f17646c.a();
    }

    public n e(j8.l lVar) {
        n nVarB = this.f17646c.b();
        if (nVarB == null) {
            return null;
        }
        if (this.f17644a.g() || !(lVar.isEmpty() || nVarB.z(lVar.K()).isEmpty())) {
            return nVarB.O(lVar);
        }
        return null;
    }

    public n f() {
        return this.f17646c.c().b();
    }

    public List g(j8.i iVar) {
        o8.a aVarC = this.f17646c.c();
        ArrayList arrayList = new ArrayList();
        for (r8.m mVar : aVarC.b()) {
            arrayList.add(c.c(mVar.c(), mVar.d()));
        }
        if (aVarC.f()) {
            arrayList.add(c.n(aVarC.a()));
        }
        return c(arrayList, aVarC.a(), iVar);
    }

    public i h() {
        return this.f17644a;
    }

    public n i() {
        return this.f17646c.d().b();
    }

    public boolean j() {
        return this.f17647d.isEmpty();
    }

    public List k(j8.i iVar, e8.c cVar) {
        List arrayList;
        int i10 = 0;
        if (cVar != null) {
            arrayList = new ArrayList();
            m.g(iVar == null, "A cancel should cancel all event registrations");
            j8.l lVarE = this.f17644a.e();
            Iterator it = this.f17647d.iterator();
            while (it.hasNext()) {
                arrayList.add(new b((j8.i) it.next(), cVar, lVarE));
            }
        } else {
            arrayList = Collections.EMPTY_LIST;
        }
        if (iVar == null) {
            Iterator it2 = this.f17647d.iterator();
            while (it2.hasNext()) {
                ((j8.i) it2.next()).l();
            }
            this.f17647d.clear();
            return arrayList;
        }
        int i11 = -1;
        while (true) {
            if (i10 >= this.f17647d.size()) {
                i10 = i11;
                break;
            }
            j8.i iVar2 = (j8.i) this.f17647d.get(i10);
            if (iVar2.f(iVar)) {
                if (iVar2.h()) {
                    break;
                }
                i11 = i10;
            }
            i10++;
        }
        if (i10 != -1) {
            j8.i iVar3 = (j8.i) this.f17647d.get(i10);
            this.f17647d.remove(i10);
            iVar3.l();
        }
        return arrayList;
    }
}
