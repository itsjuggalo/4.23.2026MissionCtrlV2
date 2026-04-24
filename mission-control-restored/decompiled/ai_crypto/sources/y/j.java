package y;

import java.util.Arrays;
import y.C2830b;

/* JADX INFO: loaded from: classes.dex */
public class j implements C2830b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static float f25439n = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25440a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25441b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25442c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f25443d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f25444e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f25445f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f25446g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f25447h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f25448i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25449j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25450k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C2830b f25451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C2831c f25452m;

    public j(C2830b c2830b, C2831c c2831c) {
        this.f25451l = c2830b;
        this.f25452m = c2831c;
        clear();
    }

    @Override // y.C2830b.a
    public boolean a(i iVar) {
        return p(iVar) != -1;
    }

    @Override // y.C2830b.a
    public float b(i iVar, boolean z7) {
        int iP = p(iVar);
        if (iP == -1) {
            return 0.0f;
        }
        r(iVar);
        float f7 = this.f25446g[iP];
        if (this.f25450k == iP) {
            this.f25450k = this.f25448i[iP];
        }
        this.f25445f[iP] = -1;
        int[] iArr = this.f25447h;
        int i7 = iArr[iP];
        if (i7 != -1) {
            int[] iArr2 = this.f25448i;
            iArr2[i7] = iArr2[iP];
        }
        int i8 = this.f25448i[iP];
        if (i8 != -1) {
            iArr[i8] = iArr[iP];
        }
        this.f25449j--;
        iVar.f25431m--;
        if (z7) {
            iVar.c(this.f25451l);
        }
        return f7;
    }

    @Override // y.C2830b.a
    public void c(i iVar, float f7, boolean z7) {
        float f8 = f25439n;
        if (f7 <= (-f8) || f7 >= f8) {
            int iP = p(iVar);
            if (iP == -1) {
                j(iVar, f7);
                return;
            }
            float[] fArr = this.f25446g;
            float f9 = fArr[iP] + f7;
            fArr[iP] = f9;
            float f10 = f25439n;
            if (f9 <= (-f10) || f9 >= f10) {
                return;
            }
            fArr[iP] = 0.0f;
            b(iVar, z7);
        }
    }

    @Override // y.C2830b.a
    public void clear() {
        int i7 = this.f25449j;
        for (int i8 = 0; i8 < i7; i8++) {
            i iVarG = g(i8);
            if (iVarG != null) {
                iVarG.c(this.f25451l);
            }
        }
        for (int i9 = 0; i9 < this.f25441b; i9++) {
            this.f25445f[i9] = -1;
            this.f25444e[i9] = -1;
        }
        for (int i10 = 0; i10 < this.f25442c; i10++) {
            this.f25443d[i10] = -1;
        }
        this.f25449j = 0;
        this.f25450k = -1;
    }

    @Override // y.C2830b.a
    public float d(i iVar) {
        int iP = p(iVar);
        if (iP != -1) {
            return this.f25446g[iP];
        }
        return 0.0f;
    }

    @Override // y.C2830b.a
    public int e() {
        return this.f25449j;
    }

    @Override // y.C2830b.a
    public float f(C2830b c2830b, boolean z7) {
        float fD = d(c2830b.f25375a);
        b(c2830b.f25375a, z7);
        j jVar = (j) c2830b.f25379e;
        int iE = jVar.e();
        int i7 = 0;
        int i8 = 0;
        while (i7 < iE) {
            int i9 = jVar.f25445f[i8];
            if (i9 != -1) {
                c(this.f25452m.f25384d[i9], jVar.f25446g[i8] * fD, z7);
                i7++;
            }
            i8++;
        }
        return fD;
    }

    @Override // y.C2830b.a
    public i g(int i7) {
        int i8 = this.f25449j;
        if (i8 == 0) {
            return null;
        }
        int i9 = this.f25450k;
        for (int i10 = 0; i10 < i8; i10++) {
            if (i10 == i7 && i9 != -1) {
                return this.f25452m.f25384d[this.f25445f[i9]];
            }
            i9 = this.f25448i[i9];
            if (i9 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // y.C2830b.a
    public void h() {
        int i7 = this.f25449j;
        int i8 = this.f25450k;
        for (int i9 = 0; i9 < i7; i9++) {
            float[] fArr = this.f25446g;
            fArr[i8] = fArr[i8] * (-1.0f);
            i8 = this.f25448i[i8];
            if (i8 == -1) {
                return;
            }
        }
    }

    @Override // y.C2830b.a
    public float i(int i7) {
        int i8 = this.f25449j;
        int i9 = this.f25450k;
        for (int i10 = 0; i10 < i8; i10++) {
            if (i10 == i7) {
                return this.f25446g[i9];
            }
            i9 = this.f25448i[i9];
            if (i9 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // y.C2830b.a
    public void j(i iVar, float f7) {
        float f8 = f25439n;
        if (f7 > (-f8) && f7 < f8) {
            b(iVar, true);
            return;
        }
        if (this.f25449j == 0) {
            m(0, iVar, f7);
            l(iVar, 0);
            this.f25450k = 0;
            return;
        }
        int iP = p(iVar);
        if (iP != -1) {
            this.f25446g[iP] = f7;
            return;
        }
        if (this.f25449j + 1 >= this.f25441b) {
            o();
        }
        int i7 = this.f25449j;
        int i8 = this.f25450k;
        int i9 = -1;
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = this.f25445f[i8];
            int i12 = iVar.f25421c;
            if (i11 == i12) {
                this.f25446g[i8] = f7;
                return;
            }
            if (i11 < i12) {
                i9 = i8;
            }
            i8 = this.f25448i[i8];
            if (i8 == -1) {
                break;
            }
        }
        q(i9, iVar, f7);
    }

    @Override // y.C2830b.a
    public void k(float f7) {
        int i7 = this.f25449j;
        int i8 = this.f25450k;
        for (int i9 = 0; i9 < i7; i9++) {
            float[] fArr = this.f25446g;
            fArr[i8] = fArr[i8] / f7;
            i8 = this.f25448i[i8];
            if (i8 == -1) {
                return;
            }
        }
    }

    public final void l(i iVar, int i7) {
        int[] iArr;
        int i8 = iVar.f25421c % this.f25442c;
        int[] iArr2 = this.f25443d;
        int i9 = iArr2[i8];
        if (i9 == -1) {
            iArr2[i8] = i7;
        } else {
            while (true) {
                iArr = this.f25444e;
                int i10 = iArr[i9];
                if (i10 == -1) {
                    break;
                } else {
                    i9 = i10;
                }
            }
            iArr[i9] = i7;
        }
        this.f25444e[i7] = -1;
    }

    public final void m(int i7, i iVar, float f7) {
        this.f25445f[i7] = iVar.f25421c;
        this.f25446g[i7] = f7;
        this.f25447h[i7] = -1;
        this.f25448i[i7] = -1;
        iVar.a(this.f25451l);
        iVar.f25431m++;
        this.f25449j++;
    }

    public final int n() {
        for (int i7 = 0; i7 < this.f25441b; i7++) {
            if (this.f25445f[i7] == -1) {
                return i7;
            }
        }
        return -1;
    }

    public final void o() {
        int i7 = this.f25441b * 2;
        this.f25445f = Arrays.copyOf(this.f25445f, i7);
        this.f25446g = Arrays.copyOf(this.f25446g, i7);
        this.f25447h = Arrays.copyOf(this.f25447h, i7);
        this.f25448i = Arrays.copyOf(this.f25448i, i7);
        this.f25444e = Arrays.copyOf(this.f25444e, i7);
        for (int i8 = this.f25441b; i8 < i7; i8++) {
            this.f25445f[i8] = -1;
            this.f25444e[i8] = -1;
        }
        this.f25441b = i7;
    }

    public int p(i iVar) {
        if (this.f25449j == 0) {
            return -1;
        }
        int i7 = iVar.f25421c;
        int i8 = this.f25443d[i7 % this.f25442c];
        if (i8 == -1) {
            return -1;
        }
        if (this.f25445f[i8] == i7) {
            return i8;
        }
        do {
            i8 = this.f25444e[i8];
            if (i8 == -1) {
                break;
            }
        } while (this.f25445f[i8] != i7);
        if (i8 != -1 && this.f25445f[i8] == i7) {
            return i8;
        }
        return -1;
    }

    public final void q(int i7, i iVar, float f7) {
        int iN = n();
        m(iN, iVar, f7);
        if (i7 != -1) {
            this.f25447h[iN] = i7;
            int[] iArr = this.f25448i;
            iArr[iN] = iArr[i7];
            iArr[i7] = iN;
        } else {
            this.f25447h[iN] = -1;
            if (this.f25449j > 0) {
                this.f25448i[iN] = this.f25450k;
                this.f25450k = iN;
            } else {
                this.f25448i[iN] = -1;
            }
        }
        int i8 = this.f25448i[iN];
        if (i8 != -1) {
            this.f25447h[i8] = iN;
        }
        l(iVar, iN);
    }

    public final void r(i iVar) {
        int[] iArr;
        int i7;
        int i8 = iVar.f25421c;
        int i9 = i8 % this.f25442c;
        int[] iArr2 = this.f25443d;
        int i10 = iArr2[i9];
        if (i10 == -1) {
            return;
        }
        if (this.f25445f[i10] == i8) {
            int[] iArr3 = this.f25444e;
            iArr2[i9] = iArr3[i10];
            iArr3[i10] = -1;
            return;
        }
        while (true) {
            iArr = this.f25444e;
            i7 = iArr[i10];
            if (i7 == -1 || this.f25445f[i7] == i8) {
                break;
            } else {
                i10 = i7;
            }
        }
        if (i7 == -1 || this.f25445f[i7] != i8) {
            return;
        }
        iArr[i10] = iArr[i7];
        iArr[i7] = -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i7 = this.f25449j;
        for (int i8 = 0; i8 < i7; i8++) {
            i iVarG = g(i8);
            if (iVarG != null) {
                String str2 = str + iVarG + " = " + i(i8) + " ";
                int iP = p(iVarG);
                String str3 = str2 + "[p: ";
                String str4 = (this.f25447h[iP] != -1 ? str3 + this.f25452m.f25384d[this.f25445f[this.f25447h[iP]]] : str3 + "none") + ", n: ";
                str = (this.f25448i[iP] != -1 ? str4 + this.f25452m.f25384d[this.f25445f[this.f25448i[iP]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
