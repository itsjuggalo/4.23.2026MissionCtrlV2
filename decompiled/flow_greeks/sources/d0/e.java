package d0;

import c0.e;
import d0.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0.f f7415a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0.f f7418d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7416b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7417c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f7419e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f7420f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b.InterfaceC0137b f7421g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b.a f7422h = new b.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f7423i = new ArrayList();

    public e(c0.f fVar) {
        this.f7415a = fVar;
        this.f7418d = fVar;
    }

    public final void a(f fVar, int i10, int i11, f fVar2, ArrayList arrayList, m mVar) {
        int i12;
        f fVar3;
        ArrayList arrayList2;
        p pVar = fVar.f7427d;
        if (pVar.f7479c == null) {
            c0.f fVar4 = this.f7415a;
            if (pVar == fVar4.f3465e || pVar == fVar4.f3467f) {
                return;
            }
            if (mVar == null) {
                mVar = new m(pVar, i11);
                arrayList.add(mVar);
            }
            m mVar2 = mVar;
            pVar.f7479c = mVar2;
            mVar2.a(pVar);
            for (d dVar : pVar.f7484h.f7434k) {
                if (dVar instanceof f) {
                    i12 = i10;
                    fVar3 = fVar2;
                    arrayList2 = arrayList;
                    a((f) dVar, i12, 0, fVar3, arrayList2, mVar2);
                } else {
                    i12 = i10;
                    fVar3 = fVar2;
                    arrayList2 = arrayList;
                }
                i10 = i12;
                fVar2 = fVar3;
                arrayList = arrayList2;
            }
            int i13 = i10;
            f fVar5 = fVar2;
            ArrayList arrayList3 = arrayList;
            for (d dVar2 : pVar.f7485i.f7434k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i13, 1, fVar5, arrayList3, mVar2);
                }
            }
            if (i13 == 1 && (pVar instanceof n)) {
                for (d dVar3 : ((n) pVar).f7459k.f7434k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i13, 2, fVar5, arrayList3, mVar2);
                    }
                }
            }
            for (f fVar6 : pVar.f7484h.f7435l) {
                if (fVar6 == fVar5) {
                    mVar2.f7453b = true;
                }
                a(fVar6, i13, 0, fVar5, arrayList3, mVar2);
            }
            for (f fVar7 : pVar.f7485i.f7435l) {
                if (fVar7 == fVar5) {
                    mVar2.f7453b = true;
                }
                a(fVar7, i13, 1, fVar5, arrayList3, mVar2);
            }
            if (i13 == 1 && (pVar instanceof n)) {
                Iterator it = ((n) pVar).f7459k.f7435l.iterator();
                while (it.hasNext()) {
                    a((f) it.next(), i13, 2, fVar5, arrayList3, mVar2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x0284 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0008 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(c0.f r20) {
        /*
            Method dump skipped, instruction units count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.e.b(c0.f):boolean");
    }

    public void c() {
        d(this.f7419e);
        this.f7423i.clear();
        m.f7451h = 0;
        i(this.f7415a.f3465e, 0, this.f7423i);
        i(this.f7415a.f3467f, 1, this.f7423i);
        this.f7416b = false;
    }

    public void d(ArrayList arrayList) {
        arrayList.clear();
        this.f7418d.f3465e.f();
        this.f7418d.f3467f.f();
        arrayList.add(this.f7418d.f3465e);
        arrayList.add(this.f7418d.f3467f);
        HashSet hashSet = null;
        for (c0.e eVar : this.f7418d.L0) {
            if (eVar instanceof c0.g) {
                arrayList.add(new j(eVar));
            } else {
                if (eVar.g0()) {
                    if (eVar.f3461c == null) {
                        eVar.f3461c = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f3461c);
                } else {
                    arrayList.add(eVar.f3465e);
                }
                if (eVar.i0()) {
                    if (eVar.f3463d == null) {
                        eVar.f3463d = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f3463d);
                } else {
                    arrayList.add(eVar.f3467f);
                }
                if (eVar instanceof c0.i) {
                    arrayList.add(new k(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((p) it.next()).f();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            p pVar = (p) it2.next();
            if (pVar.f7478b != this.f7418d) {
                pVar.d();
            }
        }
    }

    public final int e(c0.f fVar, int i10) {
        int size = this.f7423i.size();
        long jMax = 0;
        for (int i11 = 0; i11 < size; i11++) {
            jMax = Math.max(jMax, ((m) this.f7423i.get(i11)).b(fVar, i10));
        }
        return (int) jMax;
    }

    public boolean f(boolean z10) {
        boolean z11;
        boolean z12 = false;
        if (this.f7416b || this.f7417c) {
            for (c0.e eVar : this.f7415a.L0) {
                eVar.l();
                eVar.f3457a = false;
                eVar.f3465e.r();
                eVar.f3467f.q();
            }
            this.f7415a.l();
            c0.f fVar = this.f7415a;
            fVar.f3457a = false;
            fVar.f3465e.r();
            this.f7415a.f3467f.q();
            this.f7417c = false;
        }
        if (b(this.f7418d)) {
            return false;
        }
        this.f7415a.i1(0);
        this.f7415a.j1(0);
        e.b bVarS = this.f7415a.s(0);
        e.b bVarS2 = this.f7415a.s(1);
        if (this.f7416b) {
            c();
        }
        int iV = this.f7415a.V();
        int iW = this.f7415a.W();
        this.f7415a.f3465e.f7484h.d(iV);
        this.f7415a.f3467f.f7484h.d(iW);
        m();
        e.b bVar = e.b.WRAP_CONTENT;
        if (bVarS == bVar || bVarS2 == bVar) {
            if (z10) {
                Iterator it = this.f7419e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (!((p) it.next()).m()) {
                        z10 = false;
                        break;
                    }
                }
            }
            if (z10 && bVarS == e.b.WRAP_CONTENT) {
                this.f7415a.M0(e.b.FIXED);
                c0.f fVar2 = this.f7415a;
                fVar2.g1(e(fVar2, 0));
                c0.f fVar3 = this.f7415a;
                fVar3.f3465e.f7481e.d(fVar3.U());
            }
            if (z10 && bVarS2 == e.b.WRAP_CONTENT) {
                this.f7415a.c1(e.b.FIXED);
                c0.f fVar4 = this.f7415a;
                fVar4.I0(e(fVar4, 1));
                c0.f fVar5 = this.f7415a;
                fVar5.f3467f.f7481e.d(fVar5.v());
            }
        }
        c0.f fVar6 = this.f7415a;
        e.b bVar2 = fVar6.Z[0];
        e.b bVar3 = e.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == e.b.MATCH_PARENT) {
            int iU = fVar6.U() + iV;
            this.f7415a.f3465e.f7485i.d(iU);
            this.f7415a.f3465e.f7481e.d(iU - iV);
            m();
            c0.f fVar7 = this.f7415a;
            e.b bVar4 = fVar7.Z[1];
            if (bVar4 == bVar3 || bVar4 == e.b.MATCH_PARENT) {
                int iV2 = fVar7.v() + iW;
                this.f7415a.f3467f.f7485i.d(iV2);
                this.f7415a.f3467f.f7481e.d(iV2 - iW);
            }
            m();
            z11 = true;
        } else {
            z11 = false;
        }
        for (p pVar : this.f7419e) {
            if (pVar.f7478b != this.f7415a || pVar.f7483g) {
                pVar.e();
            }
        }
        Iterator it2 = this.f7419e.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z12 = true;
                break;
            }
            p pVar2 = (p) it2.next();
            if (z11 || pVar2.f7478b != this.f7415a) {
                if (!pVar2.f7484h.f7433j || ((!pVar2.f7485i.f7433j && !(pVar2 instanceof j)) || (!pVar2.f7481e.f7433j && !(pVar2 instanceof c) && !(pVar2 instanceof j)))) {
                    break;
                }
            }
        }
        this.f7415a.M0(bVarS);
        this.f7415a.c1(bVarS2);
        return z12;
    }

    public boolean g(boolean z10) {
        if (this.f7416b) {
            for (c0.e eVar : this.f7415a.L0) {
                eVar.l();
                eVar.f3457a = false;
                l lVar = eVar.f3465e;
                lVar.f7481e.f7433j = false;
                lVar.f7483g = false;
                lVar.r();
                n nVar = eVar.f3467f;
                nVar.f7481e.f7433j = false;
                nVar.f7483g = false;
                nVar.q();
            }
            this.f7415a.l();
            c0.f fVar = this.f7415a;
            fVar.f3457a = false;
            l lVar2 = fVar.f3465e;
            lVar2.f7481e.f7433j = false;
            lVar2.f7483g = false;
            lVar2.r();
            n nVar2 = this.f7415a.f3467f;
            nVar2.f7481e.f7433j = false;
            nVar2.f7483g = false;
            nVar2.q();
            c();
        }
        if (b(this.f7418d)) {
            return false;
        }
        this.f7415a.i1(0);
        this.f7415a.j1(0);
        this.f7415a.f3465e.f7484h.d(0);
        this.f7415a.f3467f.f7484h.d(0);
        return true;
    }

    public boolean h(boolean z10, int i10) {
        boolean z11;
        e.b bVar;
        boolean z12 = false;
        e.b bVarS = this.f7415a.s(0);
        e.b bVarS2 = this.f7415a.s(1);
        int iV = this.f7415a.V();
        int iW = this.f7415a.W();
        if (z10 && (bVarS == (bVar = e.b.WRAP_CONTENT) || bVarS2 == bVar)) {
            Iterator it = this.f7419e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p pVar = (p) it.next();
                if (pVar.f7482f == i10 && !pVar.m()) {
                    z10 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z10 && bVarS == e.b.WRAP_CONTENT) {
                    this.f7415a.M0(e.b.FIXED);
                    c0.f fVar = this.f7415a;
                    fVar.g1(e(fVar, 0));
                    c0.f fVar2 = this.f7415a;
                    fVar2.f3465e.f7481e.d(fVar2.U());
                }
            } else if (z10 && bVarS2 == e.b.WRAP_CONTENT) {
                this.f7415a.c1(e.b.FIXED);
                c0.f fVar3 = this.f7415a;
                fVar3.I0(e(fVar3, 1));
                c0.f fVar4 = this.f7415a;
                fVar4.f3467f.f7481e.d(fVar4.v());
            }
        }
        if (i10 == 0) {
            c0.f fVar5 = this.f7415a;
            e.b bVar2 = fVar5.Z[0];
            if (bVar2 == e.b.FIXED || bVar2 == e.b.MATCH_PARENT) {
                int iU = fVar5.U() + iV;
                this.f7415a.f3465e.f7485i.d(iU);
                this.f7415a.f3465e.f7481e.d(iU - iV);
                z11 = true;
            }
            z11 = false;
        } else {
            c0.f fVar6 = this.f7415a;
            e.b bVar3 = fVar6.Z[1];
            if (bVar3 == e.b.FIXED || bVar3 == e.b.MATCH_PARENT) {
                int iV2 = fVar6.v() + iW;
                this.f7415a.f3467f.f7485i.d(iV2);
                this.f7415a.f3467f.f7481e.d(iV2 - iW);
                z11 = true;
            }
            z11 = false;
        }
        m();
        for (p pVar2 : this.f7419e) {
            if (pVar2.f7482f == i10 && (pVar2.f7478b != this.f7415a || pVar2.f7483g)) {
                pVar2.e();
            }
        }
        Iterator it2 = this.f7419e.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z12 = true;
                break;
            }
            p pVar3 = (p) it2.next();
            if (pVar3.f7482f == i10 && (z11 || pVar3.f7478b != this.f7415a)) {
                if (!pVar3.f7484h.f7433j || !pVar3.f7485i.f7433j || (!(pVar3 instanceof c) && !pVar3.f7481e.f7433j)) {
                    break;
                }
            }
        }
        this.f7415a.M0(bVarS);
        this.f7415a.c1(bVarS2);
        return z12;
    }

    public final void i(p pVar, int i10, ArrayList arrayList) {
        for (d dVar : pVar.f7484h.f7434k) {
            if (dVar instanceof f) {
                a((f) dVar, i10, 0, pVar.f7485i, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f7484h, i10, 0, pVar.f7485i, arrayList, null);
            }
        }
        for (d dVar2 : pVar.f7485i.f7434k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i10, 1, pVar.f7484h, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f7485i, i10, 1, pVar.f7484h, arrayList, null);
            }
        }
        int i11 = i10;
        if (i11 == 1) {
            for (d dVar3 : ((n) pVar).f7459k.f7434k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i11, 2, null, arrayList, null);
                }
                i11 = i10;
            }
        }
    }

    public void j() {
        this.f7416b = true;
    }

    public void k() {
        this.f7417c = true;
    }

    public final void l(c0.e eVar, e.b bVar, int i10, e.b bVar2, int i11) {
        b.a aVar = this.f7422h;
        aVar.f7403a = bVar;
        aVar.f7404b = bVar2;
        aVar.f7405c = i10;
        aVar.f7406d = i11;
        this.f7421g.b(eVar, aVar);
        eVar.g1(this.f7422h.f7407e);
        eVar.I0(this.f7422h.f7408f);
        eVar.H0(this.f7422h.f7410h);
        eVar.x0(this.f7422h.f7409g);
    }

    public void m() {
        g gVar;
        for (c0.e eVar : this.f7415a.L0) {
            if (!eVar.f3457a) {
                e.b[] bVarArr = eVar.Z;
                boolean z10 = false;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                int i10 = eVar.f3501w;
                int i11 = eVar.f3503x;
                e.b bVar3 = e.b.WRAP_CONTENT;
                boolean z11 = bVar == bVar3 || (bVar == e.b.MATCH_CONSTRAINT && i10 == 1);
                if (bVar2 == bVar3 || (bVar2 == e.b.MATCH_CONSTRAINT && i11 == 1)) {
                    z10 = true;
                }
                g gVar2 = eVar.f3465e.f7481e;
                boolean z12 = gVar2.f7433j;
                g gVar3 = eVar.f3467f.f7481e;
                boolean z13 = gVar3.f7433j;
                if (z12 && z13) {
                    e.b bVar4 = e.b.FIXED;
                    l(eVar, bVar4, gVar2.f7430g, bVar4, gVar3.f7430g);
                    eVar.f3457a = true;
                } else if (z12 && z10) {
                    l(eVar, e.b.FIXED, gVar2.f7430g, bVar3, gVar3.f7430g);
                    if (bVar2 == e.b.MATCH_CONSTRAINT) {
                        eVar.f3467f.f7481e.f7445m = eVar.v();
                    } else {
                        eVar.f3467f.f7481e.d(eVar.v());
                        eVar.f3457a = true;
                    }
                } else if (z13 && z11) {
                    l(eVar, bVar3, gVar2.f7430g, e.b.FIXED, gVar3.f7430g);
                    if (bVar == e.b.MATCH_CONSTRAINT) {
                        eVar.f3465e.f7481e.f7445m = eVar.U();
                    } else {
                        eVar.f3465e.f7481e.d(eVar.U());
                        eVar.f3457a = true;
                    }
                }
                if (eVar.f3457a && (gVar = eVar.f3467f.f7460l) != null) {
                    gVar.d(eVar.n());
                }
            }
        }
    }

    public void n(b.InterfaceC0137b interfaceC0137b) {
        this.f7421g = interfaceC0137b;
    }
}
