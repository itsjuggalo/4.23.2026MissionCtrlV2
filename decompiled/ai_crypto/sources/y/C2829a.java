package y;

import java.util.Arrays;
import y.C2830b;

/* JADX INFO: renamed from: y.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2829a implements C2830b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static float f25363l = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2830b f25365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2831c f25366c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25364a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25367d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f25368e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f25369f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f25370g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f25371h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f25372i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25373j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25374k = false;

    public C2829a(C2830b c2830b, C2831c c2831c) {
        this.f25365b = c2830b;
        this.f25366c = c2831c;
    }

    @Override // y.C2830b.a
    public boolean a(i iVar) {
        int i7 = this.f25372i;
        if (i7 == -1) {
            return false;
        }
        for (int i8 = 0; i7 != -1 && i8 < this.f25364a; i8++) {
            if (this.f25369f[i7] == iVar.f25421c) {
                return true;
            }
            i7 = this.f25370g[i7];
        }
        return false;
    }

    @Override // y.C2830b.a
    public final float b(i iVar, boolean z7) {
        if (this.f25368e == iVar) {
            this.f25368e = null;
        }
        int i7 = this.f25372i;
        if (i7 == -1) {
            return 0.0f;
        }
        int i8 = 0;
        int i9 = -1;
        while (i7 != -1 && i8 < this.f25364a) {
            if (this.f25369f[i7] == iVar.f25421c) {
                if (i7 == this.f25372i) {
                    this.f25372i = this.f25370g[i7];
                } else {
                    int[] iArr = this.f25370g;
                    iArr[i9] = iArr[i7];
                }
                if (z7) {
                    iVar.c(this.f25365b);
                }
                iVar.f25431m--;
                this.f25364a--;
                this.f25369f[i7] = -1;
                if (this.f25374k) {
                    this.f25373j = i7;
                }
                return this.f25371h[i7];
            }
            i8++;
            i9 = i7;
            i7 = this.f25370g[i7];
        }
        return 0.0f;
    }

    @Override // y.C2830b.a
    public void c(i iVar, float f7, boolean z7) {
        float f8 = f25363l;
        if (f7 <= (-f8) || f7 >= f8) {
            int i7 = this.f25372i;
            if (i7 == -1) {
                this.f25372i = 0;
                this.f25371h[0] = f7;
                this.f25369f[0] = iVar.f25421c;
                this.f25370g[0] = -1;
                iVar.f25431m++;
                iVar.a(this.f25365b);
                this.f25364a++;
                if (this.f25374k) {
                    return;
                }
                int i8 = this.f25373j + 1;
                this.f25373j = i8;
                int[] iArr = this.f25369f;
                if (i8 >= iArr.length) {
                    this.f25374k = true;
                    this.f25373j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i9 = -1;
            for (int i10 = 0; i7 != -1 && i10 < this.f25364a; i10++) {
                int i11 = this.f25369f[i7];
                int i12 = iVar.f25421c;
                if (i11 == i12) {
                    float[] fArr = this.f25371h;
                    float f9 = fArr[i7] + f7;
                    float f10 = f25363l;
                    if (f9 > (-f10) && f9 < f10) {
                        f9 = 0.0f;
                    }
                    fArr[i7] = f9;
                    if (f9 == 0.0f) {
                        if (i7 == this.f25372i) {
                            this.f25372i = this.f25370g[i7];
                        } else {
                            int[] iArr2 = this.f25370g;
                            iArr2[i9] = iArr2[i7];
                        }
                        if (z7) {
                            iVar.c(this.f25365b);
                        }
                        if (this.f25374k) {
                            this.f25373j = i7;
                        }
                        iVar.f25431m--;
                        this.f25364a--;
                        return;
                    }
                    return;
                }
                if (i11 < i12) {
                    i9 = i7;
                }
                i7 = this.f25370g[i7];
            }
            int length = this.f25373j;
            int i13 = length + 1;
            if (this.f25374k) {
                int[] iArr3 = this.f25369f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i13;
            }
            int[] iArr4 = this.f25369f;
            if (length >= iArr4.length && this.f25364a < iArr4.length) {
                int i14 = 0;
                while (true) {
                    int[] iArr5 = this.f25369f;
                    if (i14 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i14] == -1) {
                        length = i14;
                        break;
                    }
                    i14++;
                }
            }
            int[] iArr6 = this.f25369f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i15 = this.f25367d * 2;
                this.f25367d = i15;
                this.f25374k = false;
                this.f25373j = length - 1;
                this.f25371h = Arrays.copyOf(this.f25371h, i15);
                this.f25369f = Arrays.copyOf(this.f25369f, this.f25367d);
                this.f25370g = Arrays.copyOf(this.f25370g, this.f25367d);
            }
            this.f25369f[length] = iVar.f25421c;
            this.f25371h[length] = f7;
            if (i9 != -1) {
                int[] iArr7 = this.f25370g;
                iArr7[length] = iArr7[i9];
                iArr7[i9] = length;
            } else {
                this.f25370g[length] = this.f25372i;
                this.f25372i = length;
            }
            iVar.f25431m++;
            iVar.a(this.f25365b);
            this.f25364a++;
            if (!this.f25374k) {
                this.f25373j++;
            }
            int i16 = this.f25373j;
            int[] iArr8 = this.f25369f;
            if (i16 >= iArr8.length) {
                this.f25374k = true;
                this.f25373j = iArr8.length - 1;
            }
        }
    }

    @Override // y.C2830b.a
    public final void clear() {
        int i7 = this.f25372i;
        for (int i8 = 0; i7 != -1 && i8 < this.f25364a; i8++) {
            i iVar = this.f25366c.f25384d[this.f25369f[i7]];
            if (iVar != null) {
                iVar.c(this.f25365b);
            }
            i7 = this.f25370g[i7];
        }
        this.f25372i = -1;
        this.f25373j = -1;
        this.f25374k = false;
        this.f25364a = 0;
    }

    @Override // y.C2830b.a
    public final float d(i iVar) {
        int i7 = this.f25372i;
        for (int i8 = 0; i7 != -1 && i8 < this.f25364a; i8++) {
            if (this.f25369f[i7] == iVar.f25421c) {
                return this.f25371h[i7];
            }
            i7 = this.f25370g[i7];
        }
        return 0.0f;
    }

    @Override // y.C2830b.a
    public int e() {
        return this.f25364a;
    }

    @Override // y.C2830b.a
    public float f(C2830b c2830b, boolean z7) {
        float fD = d(c2830b.f25375a);
        b(c2830b.f25375a, z7);
        C2830b.a aVar = c2830b.f25379e;
        int iE = aVar.e();
        for (int i7 = 0; i7 < iE; i7++) {
            i iVarG = aVar.g(i7);
            c(iVarG, aVar.d(iVarG) * fD, z7);
        }
        return fD;
    }

    @Override // y.C2830b.a
    public i g(int i7) {
        int i8 = this.f25372i;
        for (int i9 = 0; i8 != -1 && i9 < this.f25364a; i9++) {
            if (i9 == i7) {
                return this.f25366c.f25384d[this.f25369f[i8]];
            }
            i8 = this.f25370g[i8];
        }
        return null;
    }

    @Override // y.C2830b.a
    public void h() {
        int i7 = this.f25372i;
        for (int i8 = 0; i7 != -1 && i8 < this.f25364a; i8++) {
            float[] fArr = this.f25371h;
            fArr[i7] = fArr[i7] * (-1.0f);
            i7 = this.f25370g[i7];
        }
    }

    @Override // y.C2830b.a
    public float i(int i7) {
        int i8 = this.f25372i;
        for (int i9 = 0; i8 != -1 && i9 < this.f25364a; i9++) {
            if (i9 == i7) {
                return this.f25371h[i8];
            }
            i8 = this.f25370g[i8];
        }
        return 0.0f;
    }

    @Override // y.C2830b.a
    public final void j(i iVar, float f7) {
        if (f7 == 0.0f) {
            b(iVar, true);
            return;
        }
        int i7 = this.f25372i;
        if (i7 == -1) {
            this.f25372i = 0;
            this.f25371h[0] = f7;
            this.f25369f[0] = iVar.f25421c;
            this.f25370g[0] = -1;
            iVar.f25431m++;
            iVar.a(this.f25365b);
            this.f25364a++;
            if (this.f25374k) {
                return;
            }
            int i8 = this.f25373j + 1;
            this.f25373j = i8;
            int[] iArr = this.f25369f;
            if (i8 >= iArr.length) {
                this.f25374k = true;
                this.f25373j = iArr.length - 1;
                return;
            }
            return;
        }
        int i9 = -1;
        for (int i10 = 0; i7 != -1 && i10 < this.f25364a; i10++) {
            int i11 = this.f25369f[i7];
            int i12 = iVar.f25421c;
            if (i11 == i12) {
                this.f25371h[i7] = f7;
                return;
            }
            if (i11 < i12) {
                i9 = i7;
            }
            i7 = this.f25370g[i7];
        }
        int length = this.f25373j;
        int i13 = length + 1;
        if (this.f25374k) {
            int[] iArr2 = this.f25369f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i13;
        }
        int[] iArr3 = this.f25369f;
        if (length >= iArr3.length && this.f25364a < iArr3.length) {
            int i14 = 0;
            while (true) {
                int[] iArr4 = this.f25369f;
                if (i14 >= iArr4.length) {
                    break;
                }
                if (iArr4[i14] == -1) {
                    length = i14;
                    break;
                }
                i14++;
            }
        }
        int[] iArr5 = this.f25369f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i15 = this.f25367d * 2;
            this.f25367d = i15;
            this.f25374k = false;
            this.f25373j = length - 1;
            this.f25371h = Arrays.copyOf(this.f25371h, i15);
            this.f25369f = Arrays.copyOf(this.f25369f, this.f25367d);
            this.f25370g = Arrays.copyOf(this.f25370g, this.f25367d);
        }
        this.f25369f[length] = iVar.f25421c;
        this.f25371h[length] = f7;
        if (i9 != -1) {
            int[] iArr6 = this.f25370g;
            iArr6[length] = iArr6[i9];
            iArr6[i9] = length;
        } else {
            this.f25370g[length] = this.f25372i;
            this.f25372i = length;
        }
        iVar.f25431m++;
        iVar.a(this.f25365b);
        int i16 = this.f25364a + 1;
        this.f25364a = i16;
        if (!this.f25374k) {
            this.f25373j++;
        }
        int[] iArr7 = this.f25369f;
        if (i16 >= iArr7.length) {
            this.f25374k = true;
        }
        if (this.f25373j >= iArr7.length) {
            this.f25374k = true;
            this.f25373j = iArr7.length - 1;
        }
    }

    @Override // y.C2830b.a
    public void k(float f7) {
        int i7 = this.f25372i;
        for (int i8 = 0; i7 != -1 && i8 < this.f25364a; i8++) {
            float[] fArr = this.f25371h;
            fArr[i7] = fArr[i7] / f7;
            i7 = this.f25370g[i7];
        }
    }

    public String toString() {
        int i7 = this.f25372i;
        String str = "";
        for (int i8 = 0; i7 != -1 && i8 < this.f25364a; i8++) {
            str = ((str + " -> ") + this.f25371h[i7] + " : ") + this.f25366c.f25384d[this.f25369f[i7]];
            i7 = this.f25370g[i7];
        }
        return str;
    }
}
