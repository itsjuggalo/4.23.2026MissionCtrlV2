package z;

import java.util.Arrays;
import z.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j implements b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static float f25525n = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25526a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25527b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25528c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f25529d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f25530e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f25531f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f25532g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f25533h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f25534i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25535j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25536k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f25537l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f25538m;

    public j(b bVar, c cVar) {
        this.f25537l = bVar;
        this.f25538m = cVar;
        clear();
    }

    @Override // z.b.a
    public int a() {
        return this.f25535j;
    }

    @Override // z.b.a
    public boolean b(i iVar) {
        return p(iVar) != -1;
    }

    @Override // z.b.a
    public i c(int i10) {
        int i11 = this.f25535j;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f25536k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f25538m.f25462d[this.f25531f[i12]];
            }
            i12 = this.f25534i[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // z.b.a
    public void clear() {
        int i10 = this.f25535j;
        for (int i11 = 0; i11 < i10; i11++) {
            i iVarC = c(i11);
            if (iVarC != null) {
                iVarC.h(this.f25537l);
            }
        }
        for (int i12 = 0; i12 < this.f25527b; i12++) {
            this.f25531f[i12] = -1;
            this.f25530e[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f25528c; i13++) {
            this.f25529d[i13] = -1;
        }
        this.f25535j = 0;
        this.f25536k = -1;
    }

    @Override // z.b.a
    public void d() {
        int i10 = this.f25535j;
        int i11 = this.f25536k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f25532g;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f25534i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // z.b.a
    public float e(int i10) {
        int i11 = this.f25535j;
        int i12 = this.f25536k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f25532g[i12];
            }
            i12 = this.f25534i[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // z.b.a
    public void f(i iVar, float f10) {
        float f11 = f25525n;
        if (f10 > (-f11) && f10 < f11) {
            h(iVar, true);
            return;
        }
        if (this.f25535j == 0) {
            m(0, iVar, f10);
            l(iVar, 0);
            this.f25536k = 0;
            return;
        }
        int iP = p(iVar);
        if (iP != -1) {
            this.f25532g[iP] = f10;
            return;
        }
        if (this.f25535j + 1 >= this.f25527b) {
            o();
        }
        int i10 = this.f25535j;
        int i11 = this.f25536k;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = this.f25531f[i11];
            int i15 = iVar.f25504c;
            if (i14 == i15) {
                this.f25532g[i11] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i11;
            }
            i11 = this.f25534i[i11];
            if (i11 == -1) {
                break;
            }
        }
        q(i12, iVar, f10);
    }

    @Override // z.b.a
    public void g(i iVar, float f10, boolean z10) {
        float f11 = f25525n;
        if (f10 <= (-f11) || f10 >= f11) {
            int iP = p(iVar);
            if (iP == -1) {
                f(iVar, f10);
                return;
            }
            float[] fArr = this.f25532g;
            float f12 = fArr[iP] + f10;
            fArr[iP] = f12;
            float f13 = f25525n;
            if (f12 <= (-f13) || f12 >= f13) {
                return;
            }
            fArr[iP] = 0.0f;
            h(iVar, z10);
        }
    }

    @Override // z.b.a
    public float h(i iVar, boolean z10) {
        int iP = p(iVar);
        if (iP == -1) {
            return 0.0f;
        }
        r(iVar);
        float f10 = this.f25532g[iP];
        if (this.f25536k == iP) {
            this.f25536k = this.f25534i[iP];
        }
        this.f25531f[iP] = -1;
        int[] iArr = this.f25533h;
        int i10 = iArr[iP];
        if (i10 != -1) {
            int[] iArr2 = this.f25534i;
            iArr2[i10] = iArr2[iP];
        }
        int i11 = this.f25534i[iP];
        if (i11 != -1) {
            iArr[i11] = iArr[iP];
        }
        this.f25535j--;
        iVar.f25514m--;
        if (z10) {
            iVar.h(this.f25537l);
        }
        return f10;
    }

    @Override // z.b.a
    public void i(float f10) {
        int i10 = this.f25535j;
        int i11 = this.f25536k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f25532g;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f25534i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // z.b.a
    public float j(b bVar, boolean z10) {
        float fK = k(bVar.f25453a);
        h(bVar.f25453a, z10);
        j jVar = (j) bVar.f25457e;
        int iA = jVar.a();
        int i10 = 0;
        int i11 = 0;
        while (i10 < iA) {
            int i12 = jVar.f25531f[i11];
            if (i12 != -1) {
                g(this.f25538m.f25462d[i12], jVar.f25532g[i11] * fK, z10);
                i10++;
            }
            i11++;
        }
        return fK;
    }

    @Override // z.b.a
    public float k(i iVar) {
        int iP = p(iVar);
        if (iP != -1) {
            return this.f25532g[iP];
        }
        return 0.0f;
    }

    public final void l(i iVar, int i10) {
        int[] iArr;
        int i11 = iVar.f25504c % this.f25528c;
        int[] iArr2 = this.f25529d;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f25530e;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            iArr[i12] = i10;
        }
        this.f25530e[i10] = -1;
    }

    public final void m(int i10, i iVar, float f10) {
        this.f25531f[i10] = iVar.f25504c;
        this.f25532g[i10] = f10;
        this.f25533h[i10] = -1;
        this.f25534i[i10] = -1;
        iVar.a(this.f25537l);
        iVar.f25514m++;
        this.f25535j++;
    }

    public final int n() {
        for (int i10 = 0; i10 < this.f25527b; i10++) {
            if (this.f25531f[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    public final void o() {
        int i10 = this.f25527b * 2;
        this.f25531f = Arrays.copyOf(this.f25531f, i10);
        this.f25532g = Arrays.copyOf(this.f25532g, i10);
        this.f25533h = Arrays.copyOf(this.f25533h, i10);
        this.f25534i = Arrays.copyOf(this.f25534i, i10);
        this.f25530e = Arrays.copyOf(this.f25530e, i10);
        for (int i11 = this.f25527b; i11 < i10; i11++) {
            this.f25531f[i11] = -1;
            this.f25530e[i11] = -1;
        }
        this.f25527b = i10;
    }

    public int p(i iVar) {
        if (this.f25535j != 0 && iVar != null) {
            int i10 = iVar.f25504c;
            int i11 = this.f25529d[i10 % this.f25528c];
            if (i11 == -1) {
                return -1;
            }
            if (this.f25531f[i11] == i10) {
                return i11;
            }
            do {
                i11 = this.f25530e[i11];
                if (i11 == -1) {
                    break;
                }
            } while (this.f25531f[i11] != i10);
            if (i11 != -1 && this.f25531f[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void q(int i10, i iVar, float f10) {
        int iN = n();
        m(iN, iVar, f10);
        if (i10 != -1) {
            this.f25533h[iN] = i10;
            int[] iArr = this.f25534i;
            iArr[iN] = iArr[i10];
            iArr[i10] = iN;
        } else {
            this.f25533h[iN] = -1;
            if (this.f25535j > 0) {
                this.f25534i[iN] = this.f25536k;
                this.f25536k = iN;
            } else {
                this.f25534i[iN] = -1;
            }
        }
        int i11 = this.f25534i[iN];
        if (i11 != -1) {
            this.f25533h[i11] = iN;
        }
        l(iVar, iN);
    }

    public final void r(i iVar) {
        int[] iArr;
        int i10;
        int i11 = iVar.f25504c;
        int i12 = i11 % this.f25528c;
        int[] iArr2 = this.f25529d;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            return;
        }
        if (this.f25531f[i13] == i11) {
            int[] iArr3 = this.f25530e;
            iArr2[i12] = iArr3[i13];
            iArr3[i13] = -1;
            return;
        }
        while (true) {
            iArr = this.f25530e;
            i10 = iArr[i13];
            if (i10 == -1 || this.f25531f[i10] == i11) {
                break;
            } else {
                i13 = i10;
            }
        }
        if (i10 == -1 || this.f25531f[i10] != i11) {
            return;
        }
        iArr[i13] = iArr[i10];
        iArr[i10] = -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i10 = this.f25535j;
        for (int i11 = 0; i11 < i10; i11++) {
            i iVarC = c(i11);
            if (iVarC != null) {
                String str2 = str + iVarC + " = " + e(i11) + " ";
                int iP = p(iVarC);
                String str3 = str2 + "[p: ";
                String str4 = (this.f25533h[iP] != -1 ? str3 + this.f25538m.f25462d[this.f25531f[this.f25533h[iP]]] : str3 + "none") + ", n: ";
                str = (this.f25534i[iP] != -1 ? str4 + this.f25538m.f25462d[this.f25531f[this.f25534i[iP]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
