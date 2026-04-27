package z;

import java.util.Arrays;
import z.b;

/* JADX INFO: renamed from: z.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2997a implements b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static float f24521l = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f24523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f24524c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f24522a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24525d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f24526e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f24527f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f24528g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f24529h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f24530i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f24531j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f24532k = false;

    public C2997a(b bVar, c cVar) {
        this.f24523b = bVar;
        this.f24524c = cVar;
    }

    @Override // z.b.a
    public int a() {
        return this.f24522a;
    }

    @Override // z.b.a
    public boolean b(i iVar) {
        int i8 = this.f24530i;
        if (i8 == -1) {
            return false;
        }
        for (int i9 = 0; i8 != -1 && i9 < this.f24522a; i9++) {
            if (this.f24527f[i8] == iVar.f24584c) {
                return true;
            }
            i8 = this.f24528g[i8];
        }
        return false;
    }

    @Override // z.b.a
    public i c(int i8) {
        int i9 = this.f24530i;
        for (int i10 = 0; i9 != -1 && i10 < this.f24522a; i10++) {
            if (i10 == i8) {
                return this.f24524c.f24542d[this.f24527f[i9]];
            }
            i9 = this.f24528g[i9];
        }
        return null;
    }

    @Override // z.b.a
    public final void clear() {
        int i8 = this.f24530i;
        for (int i9 = 0; i8 != -1 && i9 < this.f24522a; i9++) {
            i iVar = this.f24524c.f24542d[this.f24527f[i8]];
            if (iVar != null) {
                iVar.i(this.f24523b);
            }
            i8 = this.f24528g[i8];
        }
        this.f24530i = -1;
        this.f24531j = -1;
        this.f24532k = false;
        this.f24522a = 0;
    }

    @Override // z.b.a
    public void d() {
        int i8 = this.f24530i;
        for (int i9 = 0; i8 != -1 && i9 < this.f24522a; i9++) {
            float[] fArr = this.f24529h;
            fArr[i8] = fArr[i8] * (-1.0f);
            i8 = this.f24528g[i8];
        }
    }

    @Override // z.b.a
    public float e(int i8) {
        int i9 = this.f24530i;
        for (int i10 = 0; i9 != -1 && i10 < this.f24522a; i10++) {
            if (i10 == i8) {
                return this.f24529h[i9];
            }
            i9 = this.f24528g[i9];
        }
        return 0.0f;
    }

    @Override // z.b.a
    public final void f(i iVar, float f8) {
        if (f8 == 0.0f) {
            h(iVar, true);
            return;
        }
        int i8 = this.f24530i;
        if (i8 == -1) {
            this.f24530i = 0;
            this.f24529h[0] = f8;
            this.f24527f[0] = iVar.f24584c;
            this.f24528g[0] = -1;
            iVar.f24594m++;
            iVar.a(this.f24523b);
            this.f24522a++;
            if (this.f24532k) {
                return;
            }
            int i9 = this.f24531j + 1;
            this.f24531j = i9;
            int[] iArr = this.f24527f;
            if (i9 >= iArr.length) {
                this.f24532k = true;
                this.f24531j = iArr.length - 1;
                return;
            }
            return;
        }
        int i10 = -1;
        for (int i11 = 0; i8 != -1 && i11 < this.f24522a; i11++) {
            int i12 = this.f24527f[i8];
            int i13 = iVar.f24584c;
            if (i12 == i13) {
                this.f24529h[i8] = f8;
                return;
            }
            if (i12 < i13) {
                i10 = i8;
            }
            i8 = this.f24528g[i8];
        }
        int length = this.f24531j;
        int i14 = length + 1;
        if (this.f24532k) {
            int[] iArr2 = this.f24527f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i14;
        }
        int[] iArr3 = this.f24527f;
        if (length >= iArr3.length && this.f24522a < iArr3.length) {
            int i15 = 0;
            while (true) {
                int[] iArr4 = this.f24527f;
                if (i15 >= iArr4.length) {
                    break;
                }
                if (iArr4[i15] == -1) {
                    length = i15;
                    break;
                }
                i15++;
            }
        }
        int[] iArr5 = this.f24527f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i16 = this.f24525d * 2;
            this.f24525d = i16;
            this.f24532k = false;
            this.f24531j = length - 1;
            this.f24529h = Arrays.copyOf(this.f24529h, i16);
            this.f24527f = Arrays.copyOf(this.f24527f, this.f24525d);
            this.f24528g = Arrays.copyOf(this.f24528g, this.f24525d);
        }
        this.f24527f[length] = iVar.f24584c;
        this.f24529h[length] = f8;
        int[] iArr6 = this.f24528g;
        if (i10 != -1) {
            iArr6[length] = iArr6[i10];
            iArr6[i10] = length;
        } else {
            iArr6[length] = this.f24530i;
            this.f24530i = length;
        }
        iVar.f24594m++;
        iVar.a(this.f24523b);
        int i17 = this.f24522a + 1;
        this.f24522a = i17;
        if (!this.f24532k) {
            this.f24531j++;
        }
        int[] iArr7 = this.f24527f;
        if (i17 >= iArr7.length) {
            this.f24532k = true;
        }
        if (this.f24531j >= iArr7.length) {
            this.f24532k = true;
            this.f24531j = iArr7.length - 1;
        }
    }

    @Override // z.b.a
    public void g(i iVar, float f8, boolean z7) {
        float f9 = f24521l;
        if (f8 <= (-f9) || f8 >= f9) {
            int i8 = this.f24530i;
            if (i8 == -1) {
                this.f24530i = 0;
                this.f24529h[0] = f8;
                this.f24527f[0] = iVar.f24584c;
                this.f24528g[0] = -1;
                iVar.f24594m++;
                iVar.a(this.f24523b);
                this.f24522a++;
                if (this.f24532k) {
                    return;
                }
                int i9 = this.f24531j + 1;
                this.f24531j = i9;
                int[] iArr = this.f24527f;
                if (i9 >= iArr.length) {
                    this.f24532k = true;
                    this.f24531j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i10 = -1;
            for (int i11 = 0; i8 != -1 && i11 < this.f24522a; i11++) {
                int i12 = this.f24527f[i8];
                int i13 = iVar.f24584c;
                if (i12 == i13) {
                    float[] fArr = this.f24529h;
                    float f10 = fArr[i8] + f8;
                    float f11 = f24521l;
                    if (f10 > (-f11) && f10 < f11) {
                        f10 = 0.0f;
                    }
                    fArr[i8] = f10;
                    if (f10 == 0.0f) {
                        if (i8 == this.f24530i) {
                            this.f24530i = this.f24528g[i8];
                        } else {
                            int[] iArr2 = this.f24528g;
                            iArr2[i10] = iArr2[i8];
                        }
                        if (z7) {
                            iVar.i(this.f24523b);
                        }
                        if (this.f24532k) {
                            this.f24531j = i8;
                        }
                        iVar.f24594m--;
                        this.f24522a--;
                        return;
                    }
                    return;
                }
                if (i12 < i13) {
                    i10 = i8;
                }
                i8 = this.f24528g[i8];
            }
            int length = this.f24531j;
            int i14 = length + 1;
            if (this.f24532k) {
                int[] iArr3 = this.f24527f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i14;
            }
            int[] iArr4 = this.f24527f;
            if (length >= iArr4.length && this.f24522a < iArr4.length) {
                int i15 = 0;
                while (true) {
                    int[] iArr5 = this.f24527f;
                    if (i15 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i15] == -1) {
                        length = i15;
                        break;
                    }
                    i15++;
                }
            }
            int[] iArr6 = this.f24527f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i16 = this.f24525d * 2;
                this.f24525d = i16;
                this.f24532k = false;
                this.f24531j = length - 1;
                this.f24529h = Arrays.copyOf(this.f24529h, i16);
                this.f24527f = Arrays.copyOf(this.f24527f, this.f24525d);
                this.f24528g = Arrays.copyOf(this.f24528g, this.f24525d);
            }
            this.f24527f[length] = iVar.f24584c;
            this.f24529h[length] = f8;
            int[] iArr7 = this.f24528g;
            if (i10 != -1) {
                iArr7[length] = iArr7[i10];
                iArr7[i10] = length;
            } else {
                iArr7[length] = this.f24530i;
                this.f24530i = length;
            }
            iVar.f24594m++;
            iVar.a(this.f24523b);
            this.f24522a++;
            if (!this.f24532k) {
                this.f24531j++;
            }
            int i17 = this.f24531j;
            int[] iArr8 = this.f24527f;
            if (i17 >= iArr8.length) {
                this.f24532k = true;
                this.f24531j = iArr8.length - 1;
            }
        }
    }

    @Override // z.b.a
    public final float h(i iVar, boolean z7) {
        if (this.f24526e == iVar) {
            this.f24526e = null;
        }
        int i8 = this.f24530i;
        if (i8 == -1) {
            return 0.0f;
        }
        int i9 = 0;
        int i10 = -1;
        while (i8 != -1 && i9 < this.f24522a) {
            if (this.f24527f[i8] == iVar.f24584c) {
                if (i8 == this.f24530i) {
                    this.f24530i = this.f24528g[i8];
                } else {
                    int[] iArr = this.f24528g;
                    iArr[i10] = iArr[i8];
                }
                if (z7) {
                    iVar.i(this.f24523b);
                }
                iVar.f24594m--;
                this.f24522a--;
                this.f24527f[i8] = -1;
                if (this.f24532k) {
                    this.f24531j = i8;
                }
                return this.f24529h[i8];
            }
            i9++;
            i10 = i8;
            i8 = this.f24528g[i8];
        }
        return 0.0f;
    }

    @Override // z.b.a
    public void i(float f8) {
        int i8 = this.f24530i;
        for (int i9 = 0; i8 != -1 && i9 < this.f24522a; i9++) {
            float[] fArr = this.f24529h;
            fArr[i8] = fArr[i8] / f8;
            i8 = this.f24528g[i8];
        }
    }

    @Override // z.b.a
    public float j(b bVar, boolean z7) {
        float fK = k(bVar.f24533a);
        h(bVar.f24533a, z7);
        b.a aVar = bVar.f24537e;
        int iA = aVar.a();
        for (int i8 = 0; i8 < iA; i8++) {
            i iVarC = aVar.c(i8);
            g(iVarC, aVar.k(iVarC) * fK, z7);
        }
        return fK;
    }

    @Override // z.b.a
    public final float k(i iVar) {
        int i8 = this.f24530i;
        for (int i9 = 0; i8 != -1 && i9 < this.f24522a; i9++) {
            if (this.f24527f[i8] == iVar.f24584c) {
                return this.f24529h[i8];
            }
            i8 = this.f24528g[i8];
        }
        return 0.0f;
    }

    public String toString() {
        int i8 = this.f24530i;
        String str = "";
        for (int i9 = 0; i8 != -1 && i9 < this.f24522a; i9++) {
            str = ((str + " -> ") + this.f24529h[i8] + " : ") + this.f24524c.f24542d[this.f24527f[i8]];
            i8 = this.f24528g[i8];
        }
        return str;
    }
}
