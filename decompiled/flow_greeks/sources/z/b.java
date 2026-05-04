package z;

import java.util.ArrayList;
import z.d;
import z.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f25457e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f25453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f25454b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25455c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f25456d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25458f = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        int a();

        boolean b(i iVar);

        i c(int i10);

        void clear();

        void d();

        float e(int i10);

        void f(i iVar, float f10);

        void g(i iVar, float f10, boolean z10);

        float h(i iVar, boolean z10);

        void i(float f10);

        float j(b bVar, boolean z10);

        float k(i iVar);
    }

    public b() {
    }

    public void A(d dVar, i iVar, boolean z10) {
        if (iVar == null || !iVar.f25508g) {
            return;
        }
        this.f25454b += iVar.f25507f * this.f25457e.k(iVar);
        this.f25457e.h(iVar, z10);
        if (z10) {
            iVar.h(this);
        }
        if (d.f25465t && this.f25457e.a() == 0) {
            this.f25458f = true;
            dVar.f25471a = true;
        }
    }

    public void B(d dVar, b bVar, boolean z10) {
        this.f25454b += bVar.f25454b * this.f25457e.j(bVar, z10);
        if (z10) {
            bVar.f25453a.h(this);
        }
        if (d.f25465t && this.f25453a != null && this.f25457e.a() == 0) {
            this.f25458f = true;
            dVar.f25471a = true;
        }
    }

    public void C(d dVar, i iVar, boolean z10) {
        if (iVar == null || !iVar.f25515n) {
            return;
        }
        float fK = this.f25457e.k(iVar);
        this.f25454b += iVar.f25517p * fK;
        this.f25457e.h(iVar, z10);
        if (z10) {
            iVar.h(this);
        }
        this.f25457e.g(dVar.f25484n.f25462d[iVar.f25516o], fK, z10);
        if (d.f25465t && this.f25457e.a() == 0) {
            this.f25458f = true;
            dVar.f25471a = true;
        }
    }

    public void D(d dVar) {
        if (dVar.f25477g.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int iA = this.f25457e.a();
            for (int i10 = 0; i10 < iA; i10++) {
                i iVarC = this.f25457e.c(i10);
                if (iVarC.f25505d != -1 || iVarC.f25508g || iVarC.f25515n) {
                    this.f25456d.add(iVarC);
                }
            }
            int size = this.f25456d.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    i iVar = (i) this.f25456d.get(i11);
                    if (iVar.f25508g) {
                        A(dVar, iVar, true);
                    } else if (iVar.f25515n) {
                        C(dVar, iVar, true);
                    } else {
                        B(dVar, dVar.f25477g[iVar.f25505d], true);
                    }
                }
                this.f25456d.clear();
            } else {
                z10 = true;
            }
        }
        if (d.f25465t && this.f25453a != null && this.f25457e.a() == 0) {
            this.f25458f = true;
            dVar.f25471a = true;
        }
    }

    @Override // z.d.a
    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f25453a = null;
            this.f25457e.clear();
            for (int i10 = 0; i10 < bVar.f25457e.a(); i10++) {
                this.f25457e.g(bVar.f25457e.c(i10), bVar.f25457e.e(i10), true);
            }
        }
    }

    @Override // z.d.a
    public i b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // z.d.a
    public void c(i iVar) {
        int i10 = iVar.f25506e;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f25457e.f(iVar, f10);
    }

    @Override // z.d.a
    public void clear() {
        this.f25457e.clear();
        this.f25453a = null;
        this.f25454b = 0.0f;
    }

    public b d(d dVar, int i10) {
        this.f25457e.f(dVar.o(i10, "ep"), 1.0f);
        this.f25457e.f(dVar.o(i10, "em"), -1.0f);
        return this;
    }

    public b e(i iVar, int i10) {
        this.f25457e.f(iVar, i10);
        return this;
    }

    public boolean f(d dVar) {
        boolean z10;
        i iVarG = g(dVar);
        if (iVarG == null) {
            z10 = true;
        } else {
            x(iVarG);
            z10 = false;
        }
        if (this.f25457e.a() == 0) {
            this.f25458f = true;
        }
        return z10;
    }

    public i g(d dVar) {
        int iA = this.f25457e.a();
        i iVar = null;
        float f10 = 0.0f;
        float f11 = 0.0f;
        boolean z10 = false;
        boolean z11 = false;
        i iVar2 = null;
        for (int i10 = 0; i10 < iA; i10++) {
            float fE = this.f25457e.e(i10);
            i iVarC = this.f25457e.c(i10);
            if (iVarC.f25511j == i.a.UNRESTRICTED) {
                if (iVar == null || f10 > fE) {
                    boolean zU = u(iVarC, dVar);
                    z10 = zU;
                    f10 = fE;
                    iVar = iVarC;
                } else if (!z10 && u(iVarC, dVar)) {
                    f10 = fE;
                    iVar = iVarC;
                    z10 = true;
                }
            } else if (iVar == null && fE < 0.0f) {
                if (iVar2 == null || f11 > fE) {
                    boolean zU2 = u(iVarC, dVar);
                    z11 = zU2;
                    f11 = fE;
                    iVar2 = iVarC;
                } else if (!z11 && u(iVarC, dVar)) {
                    f11 = fE;
                    iVar2 = iVarC;
                    z11 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // z.d.a
    public i getKey() {
        return this.f25453a;
    }

    public b h(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11) {
        if (iVar2 == iVar3) {
            this.f25457e.f(iVar, 1.0f);
            this.f25457e.f(iVar4, 1.0f);
            this.f25457e.f(iVar2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f25457e.f(iVar, 1.0f);
            this.f25457e.f(iVar2, -1.0f);
            this.f25457e.f(iVar3, -1.0f);
            this.f25457e.f(iVar4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f25454b = (-i10) + i11;
                return this;
            }
        } else {
            if (f10 <= 0.0f) {
                this.f25457e.f(iVar, -1.0f);
                this.f25457e.f(iVar2, 1.0f);
                this.f25454b = i10;
                return this;
            }
            if (f10 >= 1.0f) {
                this.f25457e.f(iVar4, -1.0f);
                this.f25457e.f(iVar3, 1.0f);
                this.f25454b = -i11;
                return this;
            }
            float f11 = 1.0f - f10;
            this.f25457e.f(iVar, f11 * 1.0f);
            this.f25457e.f(iVar2, f11 * (-1.0f));
            this.f25457e.f(iVar3, (-1.0f) * f10);
            this.f25457e.f(iVar4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f25454b = ((-i10) * f11) + (i11 * f10);
                return this;
            }
        }
        return this;
    }

    public b i(i iVar, int i10) {
        this.f25453a = iVar;
        float f10 = i10;
        iVar.f25507f = f10;
        this.f25454b = f10;
        this.f25458f = true;
        return this;
    }

    @Override // z.d.a
    public boolean isEmpty() {
        return this.f25453a == null && this.f25454b == 0.0f && this.f25457e.a() == 0;
    }

    public b j(i iVar, i iVar2, float f10) {
        this.f25457e.f(iVar, -1.0f);
        this.f25457e.f(iVar2, f10);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f25457e.f(iVar, -1.0f);
        this.f25457e.f(iVar2, 1.0f);
        this.f25457e.f(iVar3, f10);
        this.f25457e.f(iVar4, -f10);
        return this;
    }

    public b l(float f10, float f11, float f12, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f25454b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f25457e.f(iVar, 1.0f);
            this.f25457e.f(iVar2, -1.0f);
            this.f25457e.f(iVar4, 1.0f);
            this.f25457e.f(iVar3, -1.0f);
            return this;
        }
        if (f10 == 0.0f) {
            this.f25457e.f(iVar, 1.0f);
            this.f25457e.f(iVar2, -1.0f);
            return this;
        }
        if (f12 == 0.0f) {
            this.f25457e.f(iVar3, 1.0f);
            this.f25457e.f(iVar4, -1.0f);
            return this;
        }
        float f13 = (f10 / f11) / (f12 / f11);
        this.f25457e.f(iVar, 1.0f);
        this.f25457e.f(iVar2, -1.0f);
        this.f25457e.f(iVar4, f13);
        this.f25457e.f(iVar3, -f13);
        return this;
    }

    public b m(i iVar, int i10) {
        if (i10 < 0) {
            this.f25454b = i10 * (-1);
            this.f25457e.f(iVar, 1.0f);
            return this;
        }
        this.f25454b = i10;
        this.f25457e.f(iVar, -1.0f);
        return this;
    }

    public b n(i iVar, i iVar2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f25454b = i10;
        }
        if (z10) {
            this.f25457e.f(iVar, 1.0f);
            this.f25457e.f(iVar2, -1.0f);
            return this;
        }
        this.f25457e.f(iVar, -1.0f);
        this.f25457e.f(iVar2, 1.0f);
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f25454b = i10;
        }
        if (z10) {
            this.f25457e.f(iVar, 1.0f);
            this.f25457e.f(iVar2, -1.0f);
            this.f25457e.f(iVar3, -1.0f);
            return this;
        }
        this.f25457e.f(iVar, -1.0f);
        this.f25457e.f(iVar2, 1.0f);
        this.f25457e.f(iVar3, 1.0f);
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f25454b = i10;
        }
        if (z10) {
            this.f25457e.f(iVar, 1.0f);
            this.f25457e.f(iVar2, -1.0f);
            this.f25457e.f(iVar3, 1.0f);
            return this;
        }
        this.f25457e.f(iVar, -1.0f);
        this.f25457e.f(iVar2, 1.0f);
        this.f25457e.f(iVar3, -1.0f);
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f25457e.f(iVar3, 0.5f);
        this.f25457e.f(iVar4, 0.5f);
        this.f25457e.f(iVar, -0.5f);
        this.f25457e.f(iVar2, -0.5f);
        this.f25454b = -f10;
        return this;
    }

    public void r() {
        float f10 = this.f25454b;
        if (f10 < 0.0f) {
            this.f25454b = f10 * (-1.0f);
            this.f25457e.d();
        }
    }

    public boolean s() {
        i iVar = this.f25453a;
        if (iVar != null) {
            return iVar.f25511j == i.a.UNRESTRICTED || this.f25454b >= 0.0f;
        }
        return false;
    }

    public boolean t(i iVar) {
        return this.f25457e.b(iVar);
    }

    public String toString() {
        return z();
    }

    public final boolean u(i iVar, d dVar) {
        return iVar.f25514m <= 1;
    }

    public i v(i iVar) {
        return w(null, iVar);
    }

    public final i w(boolean[] zArr, i iVar) {
        i.a aVar;
        int iA = this.f25457e.a();
        i iVar2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < iA; i10++) {
            float fE = this.f25457e.e(i10);
            if (fE < 0.0f) {
                i iVarC = this.f25457e.c(i10);
                if ((zArr == null || !zArr[iVarC.f25504c]) && iVarC != iVar && (((aVar = iVarC.f25511j) == i.a.SLACK || aVar == i.a.ERROR) && fE < f10)) {
                    f10 = fE;
                    iVar2 = iVarC;
                }
            }
        }
        return iVar2;
    }

    public void x(i iVar) {
        i iVar2 = this.f25453a;
        if (iVar2 != null) {
            this.f25457e.f(iVar2, -1.0f);
            this.f25453a.f25505d = -1;
            this.f25453a = null;
        }
        float fH = this.f25457e.h(iVar, true) * (-1.0f);
        this.f25453a = iVar;
        if (fH == 1.0f) {
            return;
        }
        this.f25454b /= fH;
        this.f25457e.i(fH);
    }

    public void y() {
        this.f25453a = null;
        this.f25457e.clear();
        this.f25454b = 0.0f;
        this.f25458f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String z() {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z.b.z():java.lang.String");
    }

    public b(c cVar) {
        this.f25457e = new z.a(this, cVar);
    }
}
