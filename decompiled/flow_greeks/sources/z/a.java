package z;

import java.util.Arrays;
import z.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static float f25441l = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f25443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f25444c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25442a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25445d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f25446e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f25447f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f25448g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f25449h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f25450i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25451j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25452k = false;

    public a(b bVar, c cVar) {
        this.f25443b = bVar;
        this.f25444c = cVar;
    }

    @Override // z.b.a
    public int a() {
        return this.f25442a;
    }

    @Override // z.b.a
    public boolean b(i iVar) {
        int i10 = this.f25450i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f25442a; i11++) {
            if (this.f25447f[i10] == iVar.f25504c) {
                return true;
            }
            i10 = this.f25448g[i10];
        }
        return false;
    }

    @Override // z.b.a
    public i c(int i10) {
        int i11 = this.f25450i;
        for (int i12 = 0; i11 != -1 && i12 < this.f25442a; i12++) {
            if (i12 == i10) {
                return this.f25444c.f25462d[this.f25447f[i11]];
            }
            i11 = this.f25448g[i11];
        }
        return null;
    }

    @Override // z.b.a
    public final void clear() {
        int i10 = this.f25450i;
        for (int i11 = 0; i10 != -1 && i11 < this.f25442a; i11++) {
            i iVar = this.f25444c.f25462d[this.f25447f[i10]];
            if (iVar != null) {
                iVar.h(this.f25443b);
            }
            i10 = this.f25448g[i10];
        }
        this.f25450i = -1;
        this.f25451j = -1;
        this.f25452k = false;
        this.f25442a = 0;
    }

    @Override // z.b.a
    public void d() {
        int i10 = this.f25450i;
        for (int i11 = 0; i10 != -1 && i11 < this.f25442a; i11++) {
            float[] fArr = this.f25449h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f25448g[i10];
        }
    }

    @Override // z.b.a
    public float e(int i10) {
        int i11 = this.f25450i;
        for (int i12 = 0; i11 != -1 && i12 < this.f25442a; i12++) {
            if (i12 == i10) {
                return this.f25449h[i11];
            }
            i11 = this.f25448g[i11];
        }
        return 0.0f;
    }

    @Override // z.b.a
    public final void f(i iVar, float f10) {
        if (f10 == 0.0f) {
            h(iVar, true);
            return;
        }
        int i10 = this.f25450i;
        if (i10 == -1) {
            this.f25450i = 0;
            this.f25449h[0] = f10;
            this.f25447f[0] = iVar.f25504c;
            this.f25448g[0] = -1;
            iVar.f25514m++;
            iVar.a(this.f25443b);
            this.f25442a++;
            if (this.f25452k) {
                return;
            }
            int i11 = this.f25451j + 1;
            this.f25451j = i11;
            int[] iArr = this.f25447f;
            if (i11 >= iArr.length) {
                this.f25452k = true;
                this.f25451j = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f25442a; i13++) {
            int i14 = this.f25447f[i10];
            int i15 = iVar.f25504c;
            if (i14 == i15) {
                this.f25449h[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f25448g[i10];
        }
        int length = this.f25451j;
        int i16 = length + 1;
        if (this.f25452k) {
            int[] iArr2 = this.f25447f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i16;
        }
        int[] iArr3 = this.f25447f;
        if (length >= iArr3.length && this.f25442a < iArr3.length) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.f25447f;
                if (i17 >= iArr4.length) {
                    break;
                }
                if (iArr4[i17] == -1) {
                    length = i17;
                    break;
                }
                i17++;
            }
        }
        int[] iArr5 = this.f25447f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i18 = this.f25445d * 2;
            this.f25445d = i18;
            this.f25452k = false;
            this.f25451j = length - 1;
            this.f25449h = Arrays.copyOf(this.f25449h, i18);
            this.f25447f = Arrays.copyOf(this.f25447f, this.f25445d);
            this.f25448g = Arrays.copyOf(this.f25448g, this.f25445d);
        }
        this.f25447f[length] = iVar.f25504c;
        this.f25449h[length] = f10;
        if (i12 != -1) {
            int[] iArr6 = this.f25448g;
            iArr6[length] = iArr6[i12];
            iArr6[i12] = length;
        } else {
            this.f25448g[length] = this.f25450i;
            this.f25450i = length;
        }
        iVar.f25514m++;
        iVar.a(this.f25443b);
        int i19 = this.f25442a + 1;
        this.f25442a = i19;
        if (!this.f25452k) {
            this.f25451j++;
        }
        int[] iArr7 = this.f25447f;
        if (i19 >= iArr7.length) {
            this.f25452k = true;
        }
        if (this.f25451j >= iArr7.length) {
            this.f25452k = true;
            this.f25451j = iArr7.length - 1;
        }
    }

    @Override // z.b.a
    public void g(i iVar, float f10, boolean z10) {
        float f11 = f25441l;
        if (f10 <= (-f11) || f10 >= f11) {
            int i10 = this.f25450i;
            if (i10 == -1) {
                this.f25450i = 0;
                this.f25449h[0] = f10;
                this.f25447f[0] = iVar.f25504c;
                this.f25448g[0] = -1;
                iVar.f25514m++;
                iVar.a(this.f25443b);
                this.f25442a++;
                if (this.f25452k) {
                    return;
                }
                int i11 = this.f25451j + 1;
                this.f25451j = i11;
                int[] iArr = this.f25447f;
                if (i11 >= iArr.length) {
                    this.f25452k = true;
                    this.f25451j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f25442a; i13++) {
                int i14 = this.f25447f[i10];
                int i15 = iVar.f25504c;
                if (i14 == i15) {
                    float[] fArr = this.f25449h;
                    float f12 = fArr[i10] + f10;
                    float f13 = f25441l;
                    if (f12 > (-f13) && f12 < f13) {
                        f12 = 0.0f;
                    }
                    fArr[i10] = f12;
                    if (f12 == 0.0f) {
                        if (i10 == this.f25450i) {
                            this.f25450i = this.f25448g[i10];
                        } else {
                            int[] iArr2 = this.f25448g;
                            iArr2[i12] = iArr2[i10];
                        }
                        if (z10) {
                            iVar.h(this.f25443b);
                        }
                        if (this.f25452k) {
                            this.f25451j = i10;
                        }
                        iVar.f25514m--;
                        this.f25442a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i12 = i10;
                }
                i10 = this.f25448g[i10];
            }
            int length = this.f25451j;
            int i16 = length + 1;
            if (this.f25452k) {
                int[] iArr3 = this.f25447f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i16;
            }
            int[] iArr4 = this.f25447f;
            if (length >= iArr4.length && this.f25442a < iArr4.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr5 = this.f25447f;
                    if (i17 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i17] == -1) {
                        length = i17;
                        break;
                    }
                    i17++;
                }
            }
            int[] iArr6 = this.f25447f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i18 = this.f25445d * 2;
                this.f25445d = i18;
                this.f25452k = false;
                this.f25451j = length - 1;
                this.f25449h = Arrays.copyOf(this.f25449h, i18);
                this.f25447f = Arrays.copyOf(this.f25447f, this.f25445d);
                this.f25448g = Arrays.copyOf(this.f25448g, this.f25445d);
            }
            this.f25447f[length] = iVar.f25504c;
            this.f25449h[length] = f10;
            if (i12 != -1) {
                int[] iArr7 = this.f25448g;
                iArr7[length] = iArr7[i12];
                iArr7[i12] = length;
            } else {
                this.f25448g[length] = this.f25450i;
                this.f25450i = length;
            }
            iVar.f25514m++;
            iVar.a(this.f25443b);
            this.f25442a++;
            if (!this.f25452k) {
                this.f25451j++;
            }
            int i19 = this.f25451j;
            int[] iArr8 = this.f25447f;
            if (i19 >= iArr8.length) {
                this.f25452k = true;
                this.f25451j = iArr8.length - 1;
            }
        }
    }

    @Override // z.b.a
    public final float h(i iVar, boolean z10) {
        if (this.f25446e == iVar) {
            this.f25446e = null;
        }
        int i10 = this.f25450i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f25442a) {
            if (this.f25447f[i10] == iVar.f25504c) {
                if (i10 == this.f25450i) {
                    this.f25450i = this.f25448g[i10];
                } else {
                    int[] iArr = this.f25448g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    iVar.h(this.f25443b);
                }
                iVar.f25514m--;
                this.f25442a--;
                this.f25447f[i10] = -1;
                if (this.f25452k) {
                    this.f25451j = i10;
                }
                return this.f25449h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f25448g[i10];
        }
        return 0.0f;
    }

    @Override // z.b.a
    public void i(float f10) {
        int i10 = this.f25450i;
        for (int i11 = 0; i10 != -1 && i11 < this.f25442a; i11++) {
            float[] fArr = this.f25449h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f25448g[i10];
        }
    }

    @Override // z.b.a
    public float j(b bVar, boolean z10) {
        float fK = k(bVar.f25453a);
        h(bVar.f25453a, z10);
        b.a aVar = bVar.f25457e;
        int iA = aVar.a();
        for (int i10 = 0; i10 < iA; i10++) {
            i iVarC = aVar.c(i10);
            g(iVarC, aVar.k(iVarC) * fK, z10);
        }
        return fK;
    }

    @Override // z.b.a
    public final float k(i iVar) {
        int i10 = this.f25450i;
        for (int i11 = 0; i10 != -1 && i11 < this.f25442a; i11++) {
            if (this.f25447f[i10] == iVar.f25504c) {
                return this.f25449h[i10];
            }
            i10 = this.f25448g[i10];
        }
        return 0.0f;
    }

    public String toString() {
        int i10 = this.f25450i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f25442a; i11++) {
            str = ((str + " -> ") + this.f25449h[i10] + " : ") + this.f25444c.f25462d[this.f25447f[i10]];
            i10 = this.f25448g[i10];
        }
        return str;
    }
}
