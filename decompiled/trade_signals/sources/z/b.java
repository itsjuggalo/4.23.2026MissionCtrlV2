package z;

import java.util.ArrayList;
import z.d;
import z.i;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f24537e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f24533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f24534b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24535c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f24536d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f24538f = false;

    public interface a {
        int a();

        boolean b(i iVar);

        i c(int i8);

        void clear();

        void d();

        float e(int i8);

        void f(i iVar, float f8);

        void g(i iVar, float f8, boolean z7);

        float h(i iVar, boolean z7);

        void i(float f8);

        float j(b bVar, boolean z7);

        float k(i iVar);
    }

    public b() {
    }

    public void A(d dVar, i iVar, boolean z7) {
        if (iVar == null || !iVar.f24588g) {
            return;
        }
        this.f24534b += iVar.f24587f * this.f24537e.k(iVar);
        this.f24537e.h(iVar, z7);
        if (z7) {
            iVar.i(this);
        }
        if (d.f24545t && this.f24537e.a() == 0) {
            this.f24538f = true;
            dVar.f24551a = true;
        }
    }

    public void B(d dVar, b bVar, boolean z7) {
        this.f24534b += bVar.f24534b * this.f24537e.j(bVar, z7);
        if (z7) {
            bVar.f24533a.i(this);
        }
        if (d.f24545t && this.f24533a != null && this.f24537e.a() == 0) {
            this.f24538f = true;
            dVar.f24551a = true;
        }
    }

    public void C(d dVar, i iVar, boolean z7) {
        if (iVar == null || !iVar.f24595n) {
            return;
        }
        float fK = this.f24537e.k(iVar);
        this.f24534b += iVar.f24597p * fK;
        this.f24537e.h(iVar, z7);
        if (z7) {
            iVar.i(this);
        }
        this.f24537e.g(dVar.f24564n.f24542d[iVar.f24596o], fK, z7);
        if (d.f24545t && this.f24537e.a() == 0) {
            this.f24538f = true;
            dVar.f24551a = true;
        }
    }

    public void D(d dVar) {
        if (dVar.f24557g.length == 0) {
            return;
        }
        boolean z7 = false;
        while (!z7) {
            int iA = this.f24537e.a();
            for (int i8 = 0; i8 < iA; i8++) {
                i iVarC = this.f24537e.c(i8);
                if (iVarC.f24585d != -1 || iVarC.f24588g || iVarC.f24595n) {
                    this.f24536d.add(iVarC);
                }
            }
            int size = this.f24536d.size();
            if (size > 0) {
                for (int i9 = 0; i9 < size; i9++) {
                    i iVar = (i) this.f24536d.get(i9);
                    if (iVar.f24588g) {
                        A(dVar, iVar, true);
                    } else if (iVar.f24595n) {
                        C(dVar, iVar, true);
                    } else {
                        B(dVar, dVar.f24557g[iVar.f24585d], true);
                    }
                }
                this.f24536d.clear();
            } else {
                z7 = true;
            }
        }
        if (d.f24545t && this.f24533a != null && this.f24537e.a() == 0) {
            this.f24538f = true;
            dVar.f24551a = true;
        }
    }

    @Override // z.d.a
    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f24533a = null;
            this.f24537e.clear();
            for (int i8 = 0; i8 < bVar.f24537e.a(); i8++) {
                this.f24537e.g(bVar.f24537e.c(i8), bVar.f24537e.e(i8), true);
            }
        }
    }

    @Override // z.d.a
    public i b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // z.d.a
    public void c(i iVar) {
        int i8 = iVar.f24586e;
        float f8 = 1.0f;
        if (i8 != 1) {
            if (i8 == 2) {
                f8 = 1000.0f;
            } else if (i8 == 3) {
                f8 = 1000000.0f;
            } else if (i8 == 4) {
                f8 = 1.0E9f;
            } else if (i8 == 5) {
                f8 = 1.0E12f;
            }
        }
        this.f24537e.f(iVar, f8);
    }

    @Override // z.d.a
    public void clear() {
        this.f24537e.clear();
        this.f24533a = null;
        this.f24534b = 0.0f;
    }

    public b d(d dVar, int i8) {
        this.f24537e.f(dVar.o(i8, "ep"), 1.0f);
        this.f24537e.f(dVar.o(i8, "em"), -1.0f);
        return this;
    }

    public b e(i iVar, int i8) {
        this.f24537e.f(iVar, i8);
        return this;
    }

    public boolean f(d dVar) {
        boolean z7;
        i iVarG = g(dVar);
        if (iVarG == null) {
            z7 = true;
        } else {
            x(iVarG);
            z7 = false;
        }
        if (this.f24537e.a() == 0) {
            this.f24538f = true;
        }
        return z7;
    }

    public i g(d dVar) {
        int iA = this.f24537e.a();
        i iVar = null;
        float f8 = 0.0f;
        float f9 = 0.0f;
        boolean zU = false;
        boolean zU2 = false;
        i iVar2 = null;
        for (int i8 = 0; i8 < iA; i8++) {
            float fE = this.f24537e.e(i8);
            i iVarC = this.f24537e.c(i8);
            if (iVarC.f24591j == i.a.UNRESTRICTED) {
                if (iVar == null || f8 > fE) {
                    zU = u(iVarC, dVar);
                    f8 = fE;
                    iVar = iVarC;
                } else if (!zU && u(iVarC, dVar)) {
                    f8 = fE;
                    iVar = iVarC;
                    zU = true;
                }
            } else if (iVar == null && fE < 0.0f) {
                if (iVar2 == null || f9 > fE) {
                    zU2 = u(iVarC, dVar);
                    f9 = fE;
                    iVar2 = iVarC;
                } else if (!zU2 && u(iVarC, dVar)) {
                    f9 = fE;
                    iVar2 = iVarC;
                    zU2 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // z.d.a
    public i getKey() {
        return this.f24533a;
    }

    public b h(i iVar, i iVar2, int i8, float f8, i iVar3, i iVar4, int i9) {
        float f9;
        int i10;
        if (iVar2 == iVar3) {
            this.f24537e.f(iVar, 1.0f);
            this.f24537e.f(iVar4, 1.0f);
            this.f24537e.f(iVar2, -2.0f);
            return this;
        }
        if (f8 == 0.5f) {
            this.f24537e.f(iVar, 1.0f);
            this.f24537e.f(iVar2, -1.0f);
            this.f24537e.f(iVar3, -1.0f);
            this.f24537e.f(iVar4, 1.0f);
            if (i8 > 0 || i9 > 0) {
                i10 = (-i8) + i9;
                f9 = i10;
            }
            return this;
        }
        if (f8 <= 0.0f) {
            this.f24537e.f(iVar, -1.0f);
            this.f24537e.f(iVar2, 1.0f);
            f9 = i8;
        } else {
            if (f8 < 1.0f) {
                float f10 = 1.0f - f8;
                this.f24537e.f(iVar, f10 * 1.0f);
                this.f24537e.f(iVar2, f10 * (-1.0f));
                this.f24537e.f(iVar3, (-1.0f) * f8);
                this.f24537e.f(iVar4, 1.0f * f8);
                if (i8 > 0 || i9 > 0) {
                    f9 = ((-i8) * f10) + (i9 * f8);
                }
                return this;
            }
            this.f24537e.f(iVar4, -1.0f);
            this.f24537e.f(iVar3, 1.0f);
            i10 = -i9;
            f9 = i10;
        }
        this.f24534b = f9;
        return this;
    }

    public b i(i iVar, int i8) {
        this.f24533a = iVar;
        float f8 = i8;
        iVar.f24587f = f8;
        this.f24534b = f8;
        this.f24538f = true;
        return this;
    }

    @Override // z.d.a
    public boolean isEmpty() {
        return this.f24533a == null && this.f24534b == 0.0f && this.f24537e.a() == 0;
    }

    public b j(i iVar, i iVar2, float f8) {
        this.f24537e.f(iVar, -1.0f);
        this.f24537e.f(iVar2, f8);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f8) {
        this.f24537e.f(iVar, -1.0f);
        this.f24537e.f(iVar2, 1.0f);
        this.f24537e.f(iVar3, f8);
        this.f24537e.f(iVar4, -f8);
        return this;
    }

    public b l(float f8, float f9, float f10, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f24534b = 0.0f;
        if (f9 == 0.0f || f8 == f10) {
            this.f24537e.f(iVar, 1.0f);
            this.f24537e.f(iVar2, -1.0f);
            this.f24537e.f(iVar4, 1.0f);
            this.f24537e.f(iVar3, -1.0f);
        } else if (f8 == 0.0f) {
            this.f24537e.f(iVar, 1.0f);
            this.f24537e.f(iVar2, -1.0f);
        } else if (f10 == 0.0f) {
            this.f24537e.f(iVar3, 1.0f);
            this.f24537e.f(iVar4, -1.0f);
        } else {
            float f11 = (f8 / f9) / (f10 / f9);
            this.f24537e.f(iVar, 1.0f);
            this.f24537e.f(iVar2, -1.0f);
            this.f24537e.f(iVar4, f11);
            this.f24537e.f(iVar3, -f11);
        }
        return this;
    }

    public b m(i iVar, int i8) {
        a aVar;
        float f8;
        if (i8 < 0) {
            this.f24534b = i8 * (-1);
            aVar = this.f24537e;
            f8 = 1.0f;
        } else {
            this.f24534b = i8;
            aVar = this.f24537e;
            f8 = -1.0f;
        }
        aVar.f(iVar, f8);
        return this;
    }

    public b n(i iVar, i iVar2, int i8) {
        boolean z7 = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z7 = true;
            }
            this.f24534b = i8;
        }
        if (z7) {
            this.f24537e.f(iVar, 1.0f);
            this.f24537e.f(iVar2, -1.0f);
        } else {
            this.f24537e.f(iVar, -1.0f);
            this.f24537e.f(iVar2, 1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i8) {
        boolean z7 = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z7 = true;
            }
            this.f24534b = i8;
        }
        if (z7) {
            this.f24537e.f(iVar, 1.0f);
            this.f24537e.f(iVar2, -1.0f);
            this.f24537e.f(iVar3, -1.0f);
        } else {
            this.f24537e.f(iVar, -1.0f);
            this.f24537e.f(iVar2, 1.0f);
            this.f24537e.f(iVar3, 1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i8) {
        boolean z7 = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z7 = true;
            }
            this.f24534b = i8;
        }
        if (z7) {
            this.f24537e.f(iVar, 1.0f);
            this.f24537e.f(iVar2, -1.0f);
            this.f24537e.f(iVar3, 1.0f);
        } else {
            this.f24537e.f(iVar, -1.0f);
            this.f24537e.f(iVar2, 1.0f);
            this.f24537e.f(iVar3, -1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f8) {
        this.f24537e.f(iVar3, 0.5f);
        this.f24537e.f(iVar4, 0.5f);
        this.f24537e.f(iVar, -0.5f);
        this.f24537e.f(iVar2, -0.5f);
        this.f24534b = -f8;
        return this;
    }

    public void r() {
        float f8 = this.f24534b;
        if (f8 < 0.0f) {
            this.f24534b = f8 * (-1.0f);
            this.f24537e.d();
        }
    }

    public boolean s() {
        i iVar = this.f24533a;
        return iVar != null && (iVar.f24591j == i.a.UNRESTRICTED || this.f24534b >= 0.0f);
    }

    public boolean t(i iVar) {
        return this.f24537e.b(iVar);
    }

    public String toString() {
        return z();
    }

    public final boolean u(i iVar, d dVar) {
        return iVar.f24594m <= 1;
    }

    public i v(i iVar) {
        return w(null, iVar);
    }

    public final i w(boolean[] zArr, i iVar) {
        i.a aVar;
        int iA = this.f24537e.a();
        i iVar2 = null;
        float f8 = 0.0f;
        for (int i8 = 0; i8 < iA; i8++) {
            float fE = this.f24537e.e(i8);
            if (fE < 0.0f) {
                i iVarC = this.f24537e.c(i8);
                if ((zArr == null || !zArr[iVarC.f24584c]) && iVarC != iVar && (((aVar = iVarC.f24591j) == i.a.SLACK || aVar == i.a.ERROR) && fE < f8)) {
                    f8 = fE;
                    iVar2 = iVarC;
                }
            }
        }
        return iVar2;
    }

    public void x(i iVar) {
        i iVar2 = this.f24533a;
        if (iVar2 != null) {
            this.f24537e.f(iVar2, -1.0f);
            this.f24533a.f24585d = -1;
            this.f24533a = null;
        }
        float fH = this.f24537e.h(iVar, true) * (-1.0f);
        this.f24533a = iVar;
        if (fH == 1.0f) {
            return;
        }
        this.f24534b /= fH;
        this.f24537e.i(fH);
    }

    public void y() {
        this.f24533a = null;
        this.f24537e.clear();
        this.f24534b = 0.0f;
        this.f24538f = false;
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1043)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:997)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public java.lang.String z() {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z.b.z():java.lang.String");
    }

    public b(c cVar) {
        this.f24537e = new C2997a(this, cVar);
    }
}
