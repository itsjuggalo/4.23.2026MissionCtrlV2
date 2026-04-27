package y;

import java.util.ArrayList;
import y.d;
import y.i;

/* JADX INFO: renamed from: y.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2830b implements d.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f25379e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f25375a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f25376b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25377c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f25378d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25380f = false;

    /* JADX INFO: renamed from: y.b$a */
    public interface a {
        boolean a(i iVar);

        float b(i iVar, boolean z7);

        void c(i iVar, float f7, boolean z7);

        void clear();

        float d(i iVar);

        int e();

        float f(C2830b c2830b, boolean z7);

        i g(int i7);

        void h();

        float i(int i7);

        void j(i iVar, float f7);

        void k(float f7);
    }

    public C2830b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String A() {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.C2830b.A():java.lang.String");
    }

    public void B(d dVar, i iVar, boolean z7) {
        if (iVar.f25425g) {
            this.f25376b += iVar.f25424f * this.f25379e.d(iVar);
            this.f25379e.b(iVar, z7);
            if (z7) {
                iVar.c(this);
            }
        }
    }

    public void C(C2830b c2830b, boolean z7) {
        this.f25376b += c2830b.f25376b * this.f25379e.f(c2830b, z7);
        if (z7) {
            c2830b.f25375a.c(this);
        }
    }

    public void D(d dVar) {
        if (dVar.f25394f.length == 0) {
            return;
        }
        boolean z7 = false;
        while (!z7) {
            int iE = this.f25379e.e();
            for (int i7 = 0; i7 < iE; i7++) {
                i iVarG = this.f25379e.g(i7);
                if (iVarG.f25422d != -1 || iVarG.f25425g) {
                    this.f25378d.add(iVarG);
                }
            }
            if (this.f25378d.size() > 0) {
                for (i iVar : this.f25378d) {
                    if (iVar.f25425g) {
                        B(dVar, iVar, true);
                    } else {
                        C(dVar.f25394f[iVar.f25422d], true);
                    }
                }
                this.f25378d.clear();
            } else {
                z7 = true;
            }
        }
    }

    @Override // y.d.a
    public i a(d dVar, boolean[] zArr) {
        return x(zArr, null);
    }

    @Override // y.d.a
    public void b(d.a aVar) {
        if (aVar instanceof C2830b) {
            C2830b c2830b = (C2830b) aVar;
            this.f25375a = null;
            this.f25379e.clear();
            for (int i7 = 0; i7 < c2830b.f25379e.e(); i7++) {
                this.f25379e.c(c2830b.f25379e.g(i7), c2830b.f25379e.i(i7), true);
            }
        }
    }

    @Override // y.d.a
    public void c(i iVar) {
        int i7 = iVar.f25423e;
        float f7 = 1.0f;
        if (i7 != 1) {
            if (i7 == 2) {
                f7 = 1000.0f;
            } else if (i7 == 3) {
                f7 = 1000000.0f;
            } else if (i7 == 4) {
                f7 = 1.0E9f;
            } else if (i7 == 5) {
                f7 = 1.0E12f;
            }
        }
        this.f25379e.j(iVar, f7);
    }

    @Override // y.d.a
    public void clear() {
        this.f25379e.clear();
        this.f25375a = null;
        this.f25376b = 0.0f;
    }

    public C2830b d(d dVar, int i7) {
        this.f25379e.j(dVar.o(i7, "ep"), 1.0f);
        this.f25379e.j(dVar.o(i7, "em"), -1.0f);
        return this;
    }

    public C2830b e(i iVar, int i7) {
        this.f25379e.j(iVar, i7);
        return this;
    }

    public boolean f(d dVar) {
        boolean z7;
        i iVarG = g(dVar);
        if (iVarG == null) {
            z7 = true;
        } else {
            y(iVarG);
            z7 = false;
        }
        if (this.f25379e.e() == 0) {
            this.f25380f = true;
        }
        return z7;
    }

    public i g(d dVar) {
        int iE = this.f25379e.e();
        i iVar = null;
        float f7 = 0.0f;
        float f8 = 0.0f;
        boolean z7 = false;
        boolean z8 = false;
        i iVar2 = null;
        for (int i7 = 0; i7 < iE; i7++) {
            float fI = this.f25379e.i(i7);
            i iVarG = this.f25379e.g(i7);
            if (iVarG.f25428j == i.a.UNRESTRICTED) {
                if (iVar == null || f7 > fI) {
                    boolean zV = v(iVarG, dVar);
                    z7 = zV;
                    f7 = fI;
                    iVar = iVarG;
                } else if (!z7 && v(iVarG, dVar)) {
                    f7 = fI;
                    iVar = iVarG;
                    z7 = true;
                }
            } else if (iVar == null && fI < 0.0f) {
                if (iVar2 == null || f8 > fI) {
                    boolean zV2 = v(iVarG, dVar);
                    z8 = zV2;
                    f8 = fI;
                    iVar2 = iVarG;
                } else if (!z8 && v(iVarG, dVar)) {
                    f8 = fI;
                    iVar2 = iVarG;
                    z8 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // y.d.a
    public i getKey() {
        return this.f25375a;
    }

    public C2830b h(i iVar, i iVar2, int i7, float f7, i iVar3, i iVar4, int i8) {
        if (iVar2 == iVar3) {
            this.f25379e.j(iVar, 1.0f);
            this.f25379e.j(iVar4, 1.0f);
            this.f25379e.j(iVar2, -2.0f);
            return this;
        }
        if (f7 == 0.5f) {
            this.f25379e.j(iVar, 1.0f);
            this.f25379e.j(iVar2, -1.0f);
            this.f25379e.j(iVar3, -1.0f);
            this.f25379e.j(iVar4, 1.0f);
            if (i7 > 0 || i8 > 0) {
                this.f25376b = (-i7) + i8;
            }
        } else if (f7 <= 0.0f) {
            this.f25379e.j(iVar, -1.0f);
            this.f25379e.j(iVar2, 1.0f);
            this.f25376b = i7;
        } else if (f7 >= 1.0f) {
            this.f25379e.j(iVar4, -1.0f);
            this.f25379e.j(iVar3, 1.0f);
            this.f25376b = -i8;
        } else {
            float f8 = 1.0f - f7;
            this.f25379e.j(iVar, f8 * 1.0f);
            this.f25379e.j(iVar2, f8 * (-1.0f));
            this.f25379e.j(iVar3, (-1.0f) * f7);
            this.f25379e.j(iVar4, 1.0f * f7);
            if (i7 > 0 || i8 > 0) {
                this.f25376b = ((-i7) * f8) + (i8 * f7);
            }
        }
        return this;
    }

    public C2830b i(i iVar, int i7) {
        this.f25375a = iVar;
        float f7 = i7;
        iVar.f25424f = f7;
        this.f25376b = f7;
        this.f25380f = true;
        return this;
    }

    public C2830b j(i iVar, i iVar2, float f7) {
        this.f25379e.j(iVar, -1.0f);
        this.f25379e.j(iVar2, f7);
        return this;
    }

    public C2830b k(i iVar, i iVar2, i iVar3, i iVar4, float f7) {
        this.f25379e.j(iVar, -1.0f);
        this.f25379e.j(iVar2, 1.0f);
        this.f25379e.j(iVar3, f7);
        this.f25379e.j(iVar4, -f7);
        return this;
    }

    public C2830b l(float f7, float f8, float f9, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f25376b = 0.0f;
        if (f8 == 0.0f || f7 == f9) {
            this.f25379e.j(iVar, 1.0f);
            this.f25379e.j(iVar2, -1.0f);
            this.f25379e.j(iVar4, 1.0f);
            this.f25379e.j(iVar3, -1.0f);
        } else if (f7 == 0.0f) {
            this.f25379e.j(iVar, 1.0f);
            this.f25379e.j(iVar2, -1.0f);
        } else if (f9 == 0.0f) {
            this.f25379e.j(iVar3, 1.0f);
            this.f25379e.j(iVar4, -1.0f);
        } else {
            float f10 = (f7 / f8) / (f9 / f8);
            this.f25379e.j(iVar, 1.0f);
            this.f25379e.j(iVar2, -1.0f);
            this.f25379e.j(iVar4, f10);
            this.f25379e.j(iVar3, -f10);
        }
        return this;
    }

    public C2830b m(i iVar, int i7) {
        if (i7 < 0) {
            this.f25376b = i7 * (-1);
            this.f25379e.j(iVar, 1.0f);
        } else {
            this.f25376b = i7;
            this.f25379e.j(iVar, -1.0f);
        }
        return this;
    }

    public C2830b n(i iVar, i iVar2, int i7) {
        boolean z7 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z7 = true;
            }
            this.f25376b = i7;
        }
        if (z7) {
            this.f25379e.j(iVar, 1.0f);
            this.f25379e.j(iVar2, -1.0f);
        } else {
            this.f25379e.j(iVar, -1.0f);
            this.f25379e.j(iVar2, 1.0f);
        }
        return this;
    }

    public C2830b o(i iVar, i iVar2, i iVar3, int i7) {
        boolean z7 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z7 = true;
            }
            this.f25376b = i7;
        }
        if (z7) {
            this.f25379e.j(iVar, 1.0f);
            this.f25379e.j(iVar2, -1.0f);
            this.f25379e.j(iVar3, -1.0f);
        } else {
            this.f25379e.j(iVar, -1.0f);
            this.f25379e.j(iVar2, 1.0f);
            this.f25379e.j(iVar3, 1.0f);
        }
        return this;
    }

    public C2830b p(i iVar, i iVar2, i iVar3, int i7) {
        boolean z7 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z7 = true;
            }
            this.f25376b = i7;
        }
        if (z7) {
            this.f25379e.j(iVar, 1.0f);
            this.f25379e.j(iVar2, -1.0f);
            this.f25379e.j(iVar3, 1.0f);
        } else {
            this.f25379e.j(iVar, -1.0f);
            this.f25379e.j(iVar2, 1.0f);
            this.f25379e.j(iVar3, -1.0f);
        }
        return this;
    }

    public C2830b q(i iVar, i iVar2, i iVar3, i iVar4, float f7) {
        this.f25379e.j(iVar3, 0.5f);
        this.f25379e.j(iVar4, 0.5f);
        this.f25379e.j(iVar, -0.5f);
        this.f25379e.j(iVar2, -0.5f);
        this.f25376b = -f7;
        return this;
    }

    public void r() {
        float f7 = this.f25376b;
        if (f7 < 0.0f) {
            this.f25376b = f7 * (-1.0f);
            this.f25379e.h();
        }
    }

    public boolean s() {
        i iVar = this.f25375a;
        return iVar != null && (iVar.f25428j == i.a.UNRESTRICTED || this.f25376b >= 0.0f);
    }

    public boolean t(i iVar) {
        return this.f25379e.a(iVar);
    }

    public String toString() {
        return A();
    }

    public boolean u() {
        return this.f25375a == null && this.f25376b == 0.0f && this.f25379e.e() == 0;
    }

    public final boolean v(i iVar, d dVar) {
        return iVar.f25431m <= 1;
    }

    public i w(i iVar) {
        return x(null, iVar);
    }

    public final i x(boolean[] zArr, i iVar) {
        i.a aVar;
        int iE = this.f25379e.e();
        i iVar2 = null;
        float f7 = 0.0f;
        for (int i7 = 0; i7 < iE; i7++) {
            float fI = this.f25379e.i(i7);
            if (fI < 0.0f) {
                i iVarG = this.f25379e.g(i7);
                if ((zArr == null || !zArr[iVarG.f25421c]) && iVarG != iVar && (((aVar = iVarG.f25428j) == i.a.SLACK || aVar == i.a.ERROR) && fI < f7)) {
                    f7 = fI;
                    iVar2 = iVarG;
                }
            }
        }
        return iVar2;
    }

    public void y(i iVar) {
        i iVar2 = this.f25375a;
        if (iVar2 != null) {
            this.f25379e.j(iVar2, -1.0f);
            this.f25375a = null;
        }
        float fB = this.f25379e.b(iVar, true) * (-1.0f);
        this.f25375a = iVar;
        if (fB == 1.0f) {
            return;
        }
        this.f25376b /= fB;
        this.f25379e.k(fB);
    }

    public void z() {
        this.f25375a = null;
        this.f25379e.clear();
        this.f25376b = 0.0f;
        this.f25380f = false;
    }

    public C2830b(C2831c c2831c) {
        this.f25379e = new C2829a(this, c2831c);
    }
}
