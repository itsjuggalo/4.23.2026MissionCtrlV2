package z;

import java.util.Arrays;
import z.b;

/* JADX INFO: loaded from: classes.dex */
public class j implements b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static float f24605n = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24606a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24607b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24608c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f24609d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f24610e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f24611f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f24612g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f24613h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f24614i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f24615j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f24616k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f24617l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f24618m;

    public j(b bVar, c cVar) {
        this.f24617l = bVar;
        this.f24618m = cVar;
        clear();
    }

    @Override // z.b.a
    public int a() {
        return this.f24615j;
    }

    @Override // z.b.a
    public boolean b(i iVar) {
        return p(iVar) != -1;
    }

    @Override // z.b.a
    public i c(int i8) {
        int i9 = this.f24615j;
        if (i9 == 0) {
            return null;
        }
        int i10 = this.f24616k;
        for (int i11 = 0; i11 < i9; i11++) {
            if (i11 == i8 && i10 != -1) {
                return this.f24618m.f24542d[this.f24611f[i10]];
            }
            i10 = this.f24614i[i10];
            if (i10 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // z.b.a
    public void clear() {
        int i8 = this.f24615j;
        for (int i9 = 0; i9 < i8; i9++) {
            i iVarC = c(i9);
            if (iVarC != null) {
                iVarC.i(this.f24617l);
            }
        }
        for (int i10 = 0; i10 < this.f24607b; i10++) {
            this.f24611f[i10] = -1;
            this.f24610e[i10] = -1;
        }
        for (int i11 = 0; i11 < this.f24608c; i11++) {
            this.f24609d[i11] = -1;
        }
        this.f24615j = 0;
        this.f24616k = -1;
    }

    @Override // z.b.a
    public void d() {
        int i8 = this.f24615j;
        int i9 = this.f24616k;
        for (int i10 = 0; i10 < i8; i10++) {
            float[] fArr = this.f24612g;
            fArr[i9] = fArr[i9] * (-1.0f);
            i9 = this.f24614i[i9];
            if (i9 == -1) {
                return;
            }
        }
    }

    @Override // z.b.a
    public float e(int i8) {
        int i9 = this.f24615j;
        int i10 = this.f24616k;
        for (int i11 = 0; i11 < i9; i11++) {
            if (i11 == i8) {
                return this.f24612g[i10];
            }
            i10 = this.f24614i[i10];
            if (i10 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // z.b.a
    public void f(i iVar, float f8) {
        float f9 = f24605n;
        if (f8 > (-f9) && f8 < f9) {
            h(iVar, true);
            return;
        }
        if (this.f24615j == 0) {
            m(0, iVar, f8);
            l(iVar, 0);
            this.f24616k = 0;
            return;
        }
        int iP = p(iVar);
        if (iP != -1) {
            this.f24612g[iP] = f8;
            return;
        }
        if (this.f24615j + 1 >= this.f24607b) {
            o();
        }
        int i8 = this.f24615j;
        int i9 = this.f24616k;
        int i10 = -1;
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = this.f24611f[i9];
            int i13 = iVar.f24584c;
            if (i12 == i13) {
                this.f24612g[i9] = f8;
                return;
            }
            if (i12 < i13) {
                i10 = i9;
            }
            i9 = this.f24614i[i9];
            if (i9 == -1) {
                break;
            }
        }
        q(i10, iVar, f8);
    }

    @Override // z.b.a
    public void g(i iVar, float f8, boolean z7) {
        float f9 = f24605n;
        if (f8 <= (-f9) || f8 >= f9) {
            int iP = p(iVar);
            if (iP == -1) {
                f(iVar, f8);
                return;
            }
            float[] fArr = this.f24612g;
            float f10 = fArr[iP] + f8;
            fArr[iP] = f10;
            float f11 = f24605n;
            if (f10 <= (-f11) || f10 >= f11) {
                return;
            }
            fArr[iP] = 0.0f;
            h(iVar, z7);
        }
    }

    @Override // z.b.a
    public float h(i iVar, boolean z7) {
        int iP = p(iVar);
        if (iP == -1) {
            return 0.0f;
        }
        r(iVar);
        float f8 = this.f24612g[iP];
        if (this.f24616k == iP) {
            this.f24616k = this.f24614i[iP];
        }
        this.f24611f[iP] = -1;
        int[] iArr = this.f24613h;
        int i8 = iArr[iP];
        if (i8 != -1) {
            int[] iArr2 = this.f24614i;
            iArr2[i8] = iArr2[iP];
        }
        int i9 = this.f24614i[iP];
        if (i9 != -1) {
            iArr[i9] = iArr[iP];
        }
        this.f24615j--;
        iVar.f24594m--;
        if (z7) {
            iVar.i(this.f24617l);
        }
        return f8;
    }

    @Override // z.b.a
    public void i(float f8) {
        int i8 = this.f24615j;
        int i9 = this.f24616k;
        for (int i10 = 0; i10 < i8; i10++) {
            float[] fArr = this.f24612g;
            fArr[i9] = fArr[i9] / f8;
            i9 = this.f24614i[i9];
            if (i9 == -1) {
                return;
            }
        }
    }

    @Override // z.b.a
    public float j(b bVar, boolean z7) {
        float fK = k(bVar.f24533a);
        h(bVar.f24533a, z7);
        j jVar = (j) bVar.f24537e;
        int iA = jVar.a();
        int i8 = 0;
        int i9 = 0;
        while (i8 < iA) {
            int i10 = jVar.f24611f[i9];
            if (i10 != -1) {
                g(this.f24618m.f24542d[i10], jVar.f24612g[i9] * fK, z7);
                i8++;
            }
            i9++;
        }
        return fK;
    }

    @Override // z.b.a
    public float k(i iVar) {
        int iP = p(iVar);
        if (iP != -1) {
            return this.f24612g[iP];
        }
        return 0.0f;
    }

    public final void l(i iVar, int i8) {
        int[] iArr;
        int i9 = iVar.f24584c % this.f24608c;
        int[] iArr2 = this.f24609d;
        int i10 = iArr2[i9];
        if (i10 == -1) {
            iArr2[i9] = i8;
        } else {
            while (true) {
                iArr = this.f24610e;
                int i11 = iArr[i10];
                if (i11 == -1) {
                    break;
                } else {
                    i10 = i11;
                }
            }
            iArr[i10] = i8;
        }
        this.f24610e[i8] = -1;
    }

    public final void m(int i8, i iVar, float f8) {
        this.f24611f[i8] = iVar.f24584c;
        this.f24612g[i8] = f8;
        this.f24613h[i8] = -1;
        this.f24614i[i8] = -1;
        iVar.a(this.f24617l);
        iVar.f24594m++;
        this.f24615j++;
    }

    public final int n() {
        for (int i8 = 0; i8 < this.f24607b; i8++) {
            if (this.f24611f[i8] == -1) {
                return i8;
            }
        }
        return -1;
    }

    public final void o() {
        int i8 = this.f24607b * 2;
        this.f24611f = Arrays.copyOf(this.f24611f, i8);
        this.f24612g = Arrays.copyOf(this.f24612g, i8);
        this.f24613h = Arrays.copyOf(this.f24613h, i8);
        this.f24614i = Arrays.copyOf(this.f24614i, i8);
        this.f24610e = Arrays.copyOf(this.f24610e, i8);
        for (int i9 = this.f24607b; i9 < i8; i9++) {
            this.f24611f[i9] = -1;
            this.f24610e[i9] = -1;
        }
        this.f24607b = i8;
    }

    public int p(i iVar) {
        if (this.f24615j != 0 && iVar != null) {
            int i8 = iVar.f24584c;
            int i9 = this.f24609d[i8 % this.f24608c];
            if (i9 == -1) {
                return -1;
            }
            if (this.f24611f[i9] == i8) {
                return i9;
            }
            do {
                i9 = this.f24610e[i9];
                if (i9 == -1) {
                    break;
                }
            } while (this.f24611f[i9] != i8);
            if (i9 != -1 && this.f24611f[i9] == i8) {
                return i9;
            }
        }
        return -1;
    }

    public final void q(int i8, i iVar, float f8) {
        int iN = n();
        m(iN, iVar, f8);
        if (i8 != -1) {
            this.f24613h[iN] = i8;
            int[] iArr = this.f24614i;
            iArr[iN] = iArr[i8];
            iArr[i8] = iN;
        } else {
            this.f24613h[iN] = -1;
            if (this.f24615j > 0) {
                this.f24614i[iN] = this.f24616k;
                this.f24616k = iN;
            } else {
                this.f24614i[iN] = -1;
            }
        }
        int i9 = this.f24614i[iN];
        if (i9 != -1) {
            this.f24613h[i9] = iN;
        }
        l(iVar, iN);
    }

    public final void r(i iVar) {
        int[] iArr;
        int i8;
        int i9 = iVar.f24584c;
        int i10 = i9 % this.f24608c;
        int[] iArr2 = this.f24609d;
        int i11 = iArr2[i10];
        if (i11 == -1) {
            return;
        }
        if (this.f24611f[i11] == i9) {
            int[] iArr3 = this.f24610e;
            iArr2[i10] = iArr3[i11];
            iArr3[i11] = -1;
            return;
        }
        while (true) {
            iArr = this.f24610e;
            i8 = iArr[i11];
            if (i8 == -1 || this.f24611f[i8] == i9) {
                break;
            } else {
                i11 = i8;
            }
        }
        if (i8 == -1 || this.f24611f[i8] != i9) {
            return;
        }
        iArr[i11] = iArr[i8];
        iArr[i8] = -1;
    }

    public String toString() {
        StringBuilder sb;
        String str = hashCode() + " { ";
        int i8 = this.f24615j;
        for (int i9 = 0; i9 < i8; i9++) {
            i iVarC = c(i9);
            if (iVarC != null) {
                String str2 = str + iVarC + " = " + e(i9) + " ";
                int iP = p(iVarC);
                String str3 = str2 + "[p: ";
                if (this.f24613h[iP] != -1) {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(this.f24618m.f24542d[this.f24611f[this.f24613h[iP]]]);
                } else {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append("none");
                }
                String str4 = sb.toString() + ", n: ";
                str = (this.f24614i[iP] != -1 ? str4 + this.f24618m.f24542d[this.f24611f[this.f24614i[iP]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
