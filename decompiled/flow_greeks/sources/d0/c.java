package d0;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f7413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7414l;

    public c(c0.e eVar, int i10) {
        super(eVar);
        this.f7413k = new ArrayList();
        this.f7482f = i10;
        q();
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0160  */
    @Override // d0.p, d0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(d0.d r27) {
        /*
            Method dump skipped, instruction units count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.c.a(d0.d):void");
    }

    @Override // d0.p
    public void d() {
        Iterator it = this.f7413k.iterator();
        while (it.hasNext()) {
            ((p) it.next()).d();
        }
        int size = this.f7413k.size();
        if (size < 1) {
            return;
        }
        c0.e eVar = ((p) this.f7413k.get(0)).f7478b;
        c0.e eVar2 = ((p) this.f7413k.get(size - 1)).f7478b;
        if (this.f7482f == 0) {
            c0.d dVar = eVar.O;
            c0.d dVar2 = eVar2.Q;
            f fVarI = i(dVar, 0);
            int iE = dVar.e();
            c0.e eVarR = r();
            if (eVarR != null) {
                iE = eVarR.O.e();
            }
            if (fVarI != null) {
                b(this.f7484h, fVarI, iE);
            }
            f fVarI2 = i(dVar2, 0);
            int iE2 = dVar2.e();
            c0.e eVarS = s();
            if (eVarS != null) {
                iE2 = eVarS.Q.e();
            }
            if (fVarI2 != null) {
                b(this.f7485i, fVarI2, -iE2);
            }
        } else {
            c0.d dVar3 = eVar.P;
            c0.d dVar4 = eVar2.R;
            f fVarI3 = i(dVar3, 1);
            int iE3 = dVar3.e();
            c0.e eVarR2 = r();
            if (eVarR2 != null) {
                iE3 = eVarR2.P.e();
            }
            if (fVarI3 != null) {
                b(this.f7484h, fVarI3, iE3);
            }
            f fVarI4 = i(dVar4, 1);
            int iE4 = dVar4.e();
            c0.e eVarS2 = s();
            if (eVarS2 != null) {
                iE4 = eVarS2.R.e();
            }
            if (fVarI4 != null) {
                b(this.f7485i, fVarI4, -iE4);
            }
        }
        this.f7484h.f7424a = this;
        this.f7485i.f7424a = this;
    }

    @Override // d0.p
    public void e() {
        for (int i10 = 0; i10 < this.f7413k.size(); i10++) {
            ((p) this.f7413k.get(i10)).e();
        }
    }

    @Override // d0.p
    public void f() {
        this.f7479c = null;
        Iterator it = this.f7413k.iterator();
        while (it.hasNext()) {
            ((p) it.next()).f();
        }
    }

    @Override // d0.p
    public long j() {
        int size = this.f7413k.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            p pVar = (p) this.f7413k.get(i10);
            j10 = j10 + ((long) pVar.f7484h.f7429f) + pVar.j() + ((long) pVar.f7485i.f7429f);
        }
        return j10;
    }

    @Override // d0.p
    public boolean m() {
        int size = this.f7413k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!((p) this.f7413k.get(i10)).m()) {
                return false;
            }
        }
        return true;
    }

    public final void q() {
        c0.e eVar;
        c0.e eVar2 = this.f7478b;
        c0.e eVarJ = eVar2.J(this.f7482f);
        while (true) {
            c0.e eVar3 = eVarJ;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                eVarJ = eVar2.J(this.f7482f);
            }
        }
        this.f7478b = eVar;
        this.f7413k.add(eVar.L(this.f7482f));
        c0.e eVarH = eVar.H(this.f7482f);
        while (eVarH != null) {
            this.f7413k.add(eVarH.L(this.f7482f));
            eVarH = eVarH.H(this.f7482f);
        }
        for (p pVar : this.f7413k) {
            int i10 = this.f7482f;
            if (i10 == 0) {
                pVar.f7478b.f3461c = this;
            } else if (i10 == 1) {
                pVar.f7478b.f3463d = this;
            }
        }
        if (this.f7482f == 0 && ((c0.f) this.f7478b.I()).K1() && this.f7413k.size() > 1) {
            ArrayList arrayList = this.f7413k;
            this.f7478b = ((p) arrayList.get(arrayList.size() - 1)).f7478b;
        }
        this.f7414l = this.f7482f == 0 ? this.f7478b.x() : this.f7478b.Q();
    }

    public final c0.e r() {
        for (int i10 = 0; i10 < this.f7413k.size(); i10++) {
            p pVar = (p) this.f7413k.get(i10);
            if (pVar.f7478b.T() != 8) {
                return pVar.f7478b;
            }
        }
        return null;
    }

    public final c0.e s() {
        for (int size = this.f7413k.size() - 1; size >= 0; size--) {
            p pVar = (p) this.f7413k.get(size);
            if (pVar.f7478b.T() != 8) {
                return pVar.f7478b;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f7482f == 0 ? "horizontal : " : "vertical : ");
        for (p pVar : this.f7413k) {
            sb2.append("<");
            sb2.append(pVar);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
