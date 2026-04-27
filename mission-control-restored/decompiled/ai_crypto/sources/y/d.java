package y;

import java.util.Arrays;
import java.util.HashMap;
import y.i;
import z.d;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f25385q = 1000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f25386r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static long f25387s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static long f25388t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f25391c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C2830b[] f25394f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C2831c f25401m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f25404p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25389a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap f25390b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25392d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25393e = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25395g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25396h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean[] f25397i = new boolean[32];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25398j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25399k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f25400l = 32;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i[] f25402n = new i[f25385q];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f25403o = 0;

    public interface a {
        i a(d dVar, boolean[] zArr);

        void b(a aVar);

        void c(i iVar);

        void clear();

        i getKey();
    }

    public class b extends C2830b {
        public b(C2831c c2831c) {
            this.f25379e = new j(this, c2831c);
        }
    }

    public d() {
        this.f25394f = null;
        this.f25394f = new C2830b[32];
        C();
        C2831c c2831c = new C2831c();
        this.f25401m = c2831c;
        this.f25391c = new h(c2831c);
        if (f25386r) {
            this.f25404p = new b(c2831c);
        } else {
            this.f25404p = new C2830b(c2831c);
        }
    }

    public static C2830b s(d dVar, i iVar, i iVar2, float f7) {
        return dVar.r().j(iVar, iVar2, f7);
    }

    public static e w() {
        return null;
    }

    public void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public final int B(a aVar, boolean z7) {
        for (int i7 = 0; i7 < this.f25398j; i7++) {
            this.f25397i[i7] = false;
        }
        boolean z8 = false;
        int i8 = 0;
        while (!z8) {
            i8++;
            if (i8 >= this.f25398j * 2) {
                return i8;
            }
            if (aVar.getKey() != null) {
                this.f25397i[aVar.getKey().f25421c] = true;
            }
            i iVarA = aVar.a(this, this.f25397i);
            if (iVarA != null) {
                boolean[] zArr = this.f25397i;
                int i9 = iVarA.f25421c;
                if (zArr[i9]) {
                    return i8;
                }
                zArr[i9] = true;
            }
            if (iVarA != null) {
                float f7 = Float.MAX_VALUE;
                int i10 = -1;
                for (int i11 = 0; i11 < this.f25399k; i11++) {
                    C2830b c2830b = this.f25394f[i11];
                    if (c2830b.f25375a.f25428j != i.a.UNRESTRICTED && !c2830b.f25380f && c2830b.t(iVarA)) {
                        float fD = c2830b.f25379e.d(iVarA);
                        if (fD < 0.0f) {
                            float f8 = (-c2830b.f25376b) / fD;
                            if (f8 < f7) {
                                i10 = i11;
                                f7 = f8;
                            }
                        }
                    }
                }
                if (i10 > -1) {
                    C2830b c2830b2 = this.f25394f[i10];
                    c2830b2.f25375a.f25422d = -1;
                    c2830b2.y(iVarA);
                    i iVar = c2830b2.f25375a;
                    iVar.f25422d = i10;
                    iVar.g(c2830b2);
                }
            } else {
                z8 = true;
            }
        }
        return i8;
    }

    public final void C() {
        int i7 = 0;
        if (f25386r) {
            while (true) {
                C2830b[] c2830bArr = this.f25394f;
                if (i7 >= c2830bArr.length) {
                    return;
                }
                C2830b c2830b = c2830bArr[i7];
                if (c2830b != null) {
                    this.f25401m.f25381a.a(c2830b);
                }
                this.f25394f[i7] = null;
                i7++;
            }
        } else {
            while (true) {
                C2830b[] c2830bArr2 = this.f25394f;
                if (i7 >= c2830bArr2.length) {
                    return;
                }
                C2830b c2830b2 = c2830bArr2[i7];
                if (c2830b2 != null) {
                    this.f25401m.f25382b.a(c2830b2);
                }
                this.f25394f[i7] = null;
                i7++;
            }
        }
    }

    public void D() {
        C2831c c2831c;
        int i7 = 0;
        while (true) {
            c2831c = this.f25401m;
            i[] iVarArr = c2831c.f25384d;
            if (i7 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i7];
            if (iVar != null) {
                iVar.d();
            }
            i7++;
        }
        c2831c.f25383c.c(this.f25402n, this.f25403o);
        this.f25403o = 0;
        Arrays.fill(this.f25401m.f25384d, (Object) null);
        HashMap map = this.f25390b;
        if (map != null) {
            map.clear();
        }
        this.f25389a = 0;
        this.f25391c.clear();
        this.f25398j = 1;
        for (int i8 = 0; i8 < this.f25399k; i8++) {
            this.f25394f[i8].f25377c = false;
        }
        C();
        this.f25399k = 0;
        if (f25386r) {
            this.f25404p = new b(this.f25401m);
        } else {
            this.f25404p = new C2830b(this.f25401m);
        }
    }

    public final i a(i.a aVar, String str) {
        i iVar = (i) this.f25401m.f25383c.b();
        if (iVar == null) {
            iVar = new i(aVar, str);
            iVar.f(aVar, str);
        } else {
            iVar.d();
            iVar.f(aVar, str);
        }
        int i7 = this.f25403o;
        int i8 = f25385q;
        if (i7 >= i8) {
            int i9 = i8 * 2;
            f25385q = i9;
            this.f25402n = (i[]) Arrays.copyOf(this.f25402n, i9);
        }
        i[] iVarArr = this.f25402n;
        int i10 = this.f25403o;
        this.f25403o = i10 + 1;
        iVarArr[i10] = iVar;
        return iVar;
    }

    public void b(z.e eVar, z.e eVar2, float f7, int i7) {
        d.b bVar = d.b.LEFT;
        i iVarQ = q(eVar.k(bVar));
        d.b bVar2 = d.b.TOP;
        i iVarQ2 = q(eVar.k(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i iVarQ3 = q(eVar.k(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i iVarQ4 = q(eVar.k(bVar4));
        i iVarQ5 = q(eVar2.k(bVar));
        i iVarQ6 = q(eVar2.k(bVar2));
        i iVarQ7 = q(eVar2.k(bVar3));
        i iVarQ8 = q(eVar2.k(bVar4));
        C2830b c2830bR = r();
        double d7 = f7;
        double d8 = i7;
        c2830bR.q(iVarQ2, iVarQ4, iVarQ6, iVarQ8, (float) (Math.sin(d7) * d8));
        d(c2830bR);
        C2830b c2830bR2 = r();
        c2830bR2.q(iVarQ, iVarQ3, iVarQ5, iVarQ7, (float) (Math.cos(d7) * d8));
        d(c2830bR2);
    }

    public void c(i iVar, i iVar2, int i7, float f7, i iVar3, i iVar4, int i8, int i9) {
        C2830b c2830bR = r();
        c2830bR.h(iVar, iVar2, i7, f7, iVar3, iVar4, i8);
        if (i9 != 8) {
            c2830bR.d(this, i9);
        }
        d(c2830bR);
    }

    public void d(C2830b c2830b) {
        i iVarW;
        if (c2830b == null) {
            return;
        }
        boolean z7 = true;
        if (this.f25399k + 1 >= this.f25400l || this.f25398j + 1 >= this.f25393e) {
            y();
        }
        boolean z8 = false;
        if (!c2830b.f25380f) {
            c2830b.D(this);
            if (c2830b.u()) {
                return;
            }
            c2830b.r();
            if (c2830b.f(this)) {
                i iVarP = p();
                c2830b.f25375a = iVarP;
                l(c2830b);
                this.f25404p.b(c2830b);
                B(this.f25404p, true);
                if (iVarP.f25422d == -1) {
                    if (c2830b.f25375a == iVarP && (iVarW = c2830b.w(iVarP)) != null) {
                        c2830b.y(iVarW);
                    }
                    if (!c2830b.f25380f) {
                        c2830b.f25375a.g(c2830b);
                    }
                    this.f25399k--;
                }
            } else {
                z7 = false;
            }
            if (!c2830b.s()) {
                return;
            } else {
                z8 = z7;
            }
        }
        if (z8) {
            return;
        }
        l(c2830b);
    }

    public C2830b e(i iVar, i iVar2, int i7, int i8) {
        if (i8 == 8 && iVar2.f25425g && iVar.f25422d == -1) {
            iVar.e(this, iVar2.f25424f + i7);
            return null;
        }
        C2830b c2830bR = r();
        c2830bR.n(iVar, iVar2, i7);
        if (i8 != 8) {
            c2830bR.d(this, i8);
        }
        d(c2830bR);
        return c2830bR;
    }

    public void f(i iVar, int i7) {
        int i8 = iVar.f25422d;
        if (i8 == -1) {
            iVar.e(this, i7);
            return;
        }
        if (i8 == -1) {
            C2830b c2830bR = r();
            c2830bR.i(iVar, i7);
            d(c2830bR);
            return;
        }
        C2830b c2830b = this.f25394f[i8];
        if (c2830b.f25380f) {
            c2830b.f25376b = i7;
            return;
        }
        if (c2830b.f25379e.e() == 0) {
            c2830b.f25380f = true;
            c2830b.f25376b = i7;
        } else {
            C2830b c2830bR2 = r();
            c2830bR2.m(iVar, i7);
            d(c2830bR2);
        }
    }

    public void g(i iVar, i iVar2, int i7, boolean z7) {
        C2830b c2830bR = r();
        i iVarT = t();
        iVarT.f25423e = 0;
        c2830bR.o(iVar, iVar2, iVarT, i7);
        d(c2830bR);
    }

    public void h(i iVar, i iVar2, int i7, int i8) {
        C2830b c2830bR = r();
        i iVarT = t();
        iVarT.f25423e = 0;
        c2830bR.o(iVar, iVar2, iVarT, i7);
        if (i8 != 8) {
            m(c2830bR, (int) (c2830bR.f25379e.d(iVarT) * (-1.0f)), i8);
        }
        d(c2830bR);
    }

    public void i(i iVar, i iVar2, int i7, boolean z7) {
        C2830b c2830bR = r();
        i iVarT = t();
        iVarT.f25423e = 0;
        c2830bR.p(iVar, iVar2, iVarT, i7);
        d(c2830bR);
    }

    public void j(i iVar, i iVar2, int i7, int i8) {
        C2830b c2830bR = r();
        i iVarT = t();
        iVarT.f25423e = 0;
        c2830bR.p(iVar, iVar2, iVarT, i7);
        if (i8 != 8) {
            m(c2830bR, (int) (c2830bR.f25379e.d(iVarT) * (-1.0f)), i8);
        }
        d(c2830bR);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f7, int i7) {
        C2830b c2830bR = r();
        c2830bR.k(iVar, iVar2, iVar3, iVar4, f7);
        if (i7 != 8) {
            c2830bR.d(this, i7);
        }
        d(c2830bR);
    }

    public final void l(C2830b c2830b) {
        if (f25386r) {
            C2830b c2830b2 = this.f25394f[this.f25399k];
            if (c2830b2 != null) {
                this.f25401m.f25381a.a(c2830b2);
            }
        } else {
            C2830b c2830b3 = this.f25394f[this.f25399k];
            if (c2830b3 != null) {
                this.f25401m.f25382b.a(c2830b3);
            }
        }
        C2830b[] c2830bArr = this.f25394f;
        int i7 = this.f25399k;
        c2830bArr[i7] = c2830b;
        i iVar = c2830b.f25375a;
        iVar.f25422d = i7;
        this.f25399k = i7 + 1;
        iVar.g(c2830b);
    }

    public void m(C2830b c2830b, int i7, int i8) {
        c2830b.e(o(i8, null), i7);
    }

    public final void n() {
        for (int i7 = 0; i7 < this.f25399k; i7++) {
            C2830b c2830b = this.f25394f[i7];
            c2830b.f25375a.f25424f = c2830b.f25376b;
        }
    }

    public i o(int i7, String str) {
        if (this.f25398j + 1 >= this.f25393e) {
            y();
        }
        i iVarA = a(i.a.ERROR, str);
        int i8 = this.f25389a + 1;
        this.f25389a = i8;
        this.f25398j++;
        iVarA.f25421c = i8;
        iVarA.f25423e = i7;
        this.f25401m.f25384d[i8] = iVarA;
        this.f25391c.c(iVarA);
        return iVarA;
    }

    public i p() {
        if (this.f25398j + 1 >= this.f25393e) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i7 = this.f25389a + 1;
        this.f25389a = i7;
        this.f25398j++;
        iVarA.f25421c = i7;
        this.f25401m.f25384d[i7] = iVarA;
        return iVarA;
    }

    public i q(Object obj) {
        i iVarE = null;
        if (obj == null) {
            return null;
        }
        if (this.f25398j + 1 >= this.f25393e) {
            y();
        }
        if (obj instanceof z.d) {
            z.d dVar = (z.d) obj;
            iVarE = dVar.e();
            if (iVarE == null) {
                dVar.l(this.f25401m);
                iVarE = dVar.e();
            }
            int i7 = iVarE.f25421c;
            if (i7 == -1 || i7 > this.f25389a || this.f25401m.f25384d[i7] == null) {
                if (i7 != -1) {
                    iVarE.d();
                }
                int i8 = this.f25389a + 1;
                this.f25389a = i8;
                this.f25398j++;
                iVarE.f25421c = i8;
                iVarE.f25428j = i.a.UNRESTRICTED;
                this.f25401m.f25384d[i8] = iVarE;
            }
        }
        return iVarE;
    }

    public C2830b r() {
        C2830b c2830b;
        if (f25386r) {
            c2830b = (C2830b) this.f25401m.f25381a.b();
            if (c2830b == null) {
                c2830b = new b(this.f25401m);
                f25388t++;
            } else {
                c2830b.z();
            }
        } else {
            c2830b = (C2830b) this.f25401m.f25382b.b();
            if (c2830b == null) {
                c2830b = new C2830b(this.f25401m);
                f25387s++;
            } else {
                c2830b.z();
            }
        }
        i.b();
        return c2830b;
    }

    public i t() {
        if (this.f25398j + 1 >= this.f25393e) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i7 = this.f25389a + 1;
        this.f25389a = i7;
        this.f25398j++;
        iVarA.f25421c = i7;
        this.f25401m.f25384d[i7] = iVarA;
        return iVarA;
    }

    public final int u(a aVar) {
        for (int i7 = 0; i7 < this.f25399k; i7++) {
            C2830b c2830b = this.f25394f[i7];
            if (c2830b.f25375a.f25428j != i.a.UNRESTRICTED && c2830b.f25376b < 0.0f) {
                boolean z7 = false;
                int i8 = 0;
                while (!z7) {
                    i8++;
                    float f7 = Float.MAX_VALUE;
                    int i9 = -1;
                    int i10 = -1;
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (i11 >= this.f25399k) {
                            break;
                        }
                        C2830b c2830b2 = this.f25394f[i11];
                        if (c2830b2.f25375a.f25428j != i.a.UNRESTRICTED && !c2830b2.f25380f && c2830b2.f25376b < 0.0f) {
                            for (int i13 = 1; i13 < this.f25398j; i13++) {
                                i iVar = this.f25401m.f25384d[i13];
                                float fD = c2830b2.f25379e.d(iVar);
                                if (fD > 0.0f) {
                                    for (int i14 = 0; i14 < 9; i14++) {
                                        float f8 = iVar.f25426h[i14] / fD;
                                        if ((f8 < f7 && i14 == i12) || i14 > i12) {
                                            f7 = f8;
                                            i9 = i11;
                                            i10 = i13;
                                            i12 = i14;
                                        }
                                    }
                                }
                            }
                        }
                        i11++;
                    }
                    if (i9 != -1) {
                        C2830b c2830b3 = this.f25394f[i9];
                        c2830b3.f25375a.f25422d = -1;
                        c2830b3.y(this.f25401m.f25384d[i10]);
                        i iVar2 = c2830b3.f25375a;
                        iVar2.f25422d = i9;
                        iVar2.g(c2830b3);
                    } else {
                        z7 = true;
                    }
                    if (i8 > this.f25398j / 2) {
                        z7 = true;
                    }
                }
                return i8;
            }
        }
        return 0;
    }

    public C2831c v() {
        return this.f25401m;
    }

    public int x(Object obj) {
        i iVarE = ((z.d) obj).e();
        if (iVarE != null) {
            return (int) (iVarE.f25424f + 0.5f);
        }
        return 0;
    }

    public final void y() {
        int i7 = this.f25392d * 2;
        this.f25392d = i7;
        this.f25394f = (C2830b[]) Arrays.copyOf(this.f25394f, i7);
        C2831c c2831c = this.f25401m;
        c2831c.f25384d = (i[]) Arrays.copyOf(c2831c.f25384d, this.f25392d);
        int i8 = this.f25392d;
        this.f25397i = new boolean[i8];
        this.f25393e = i8;
        this.f25400l = i8;
    }

    public void z() {
        if (!this.f25395g && !this.f25396h) {
            A(this.f25391c);
            return;
        }
        for (int i7 = 0; i7 < this.f25399k; i7++) {
            if (!this.f25394f[i7].f25380f) {
                A(this.f25391c);
                return;
            }
        }
        n();
    }
}
