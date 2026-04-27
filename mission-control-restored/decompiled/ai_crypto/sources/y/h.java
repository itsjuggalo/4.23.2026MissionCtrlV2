package y;

import java.util.Arrays;
import java.util.Comparator;
import y.C2830b;

/* JADX INFO: loaded from: classes.dex */
public class h extends C2830b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i[] f25409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i[] f25410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f25412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C2831c f25413l;

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f25421c - iVar2.f25421c;
        }
    }

    public class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f25415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f25416b;

        public b(h hVar) {
            this.f25416b = hVar;
        }

        public boolean a(i iVar, float f7) {
            boolean z7 = true;
            if (!this.f25415a.f25419a) {
                for (int i7 = 0; i7 < 9; i7++) {
                    float f8 = iVar.f25427i[i7];
                    if (f8 != 0.0f) {
                        float f9 = f8 * f7;
                        if (Math.abs(f9) < 1.0E-4f) {
                            f9 = 0.0f;
                        }
                        this.f25415a.f25427i[i7] = f9;
                    } else {
                        this.f25415a.f25427i[i7] = 0.0f;
                    }
                }
                return true;
            }
            for (int i8 = 0; i8 < 9; i8++) {
                float[] fArr = this.f25415a.f25427i;
                float f10 = fArr[i8] + (iVar.f25427i[i8] * f7);
                fArr[i8] = f10;
                if (Math.abs(f10) < 1.0E-4f) {
                    this.f25415a.f25427i[i8] = 0.0f;
                } else {
                    z7 = false;
                }
            }
            if (z7) {
                h.this.G(this.f25415a);
            }
            return false;
        }

        public void b(i iVar) {
            this.f25415a = iVar;
        }

        public final boolean c() {
            for (int i7 = 8; i7 >= 0; i7--) {
                float f7 = this.f25415a.f25427i[i7];
                if (f7 > 0.0f) {
                    return false;
                }
                if (f7 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f25415a.f25421c - ((i) obj).f25421c;
        }

        public final boolean h(i iVar) {
            int i7 = 8;
            while (true) {
                if (i7 < 0) {
                    break;
                }
                float f7 = iVar.f25427i[i7];
                float f8 = this.f25415a.f25427i[i7];
                if (f8 == f7) {
                    i7--;
                } else if (f8 < f7) {
                    return true;
                }
            }
            return false;
        }

        public void i() {
            Arrays.fill(this.f25415a.f25427i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f25415a != null) {
                for (int i7 = 0; i7 < 9; i7++) {
                    str = str + this.f25415a.f25427i[i7] + " ";
                }
            }
            return str + "] " + this.f25415a;
        }
    }

    public h(C2831c c2831c) {
        super(c2831c);
        this.f25408g = 128;
        this.f25409h = new i[128];
        this.f25410i = new i[128];
        this.f25411j = 0;
        this.f25412k = new b(this);
        this.f25413l = c2831c;
    }

    @Override // y.C2830b
    public void C(C2830b c2830b, boolean z7) {
        i iVar = c2830b.f25375a;
        if (iVar == null) {
            return;
        }
        C2830b.a aVar = c2830b.f25379e;
        int iE = aVar.e();
        for (int i7 = 0; i7 < iE; i7++) {
            i iVarG = aVar.g(i7);
            float fI = aVar.i(i7);
            this.f25412k.b(iVarG);
            if (this.f25412k.a(iVar, fI)) {
                F(iVarG);
            }
            this.f25376b += c2830b.f25376b * fI;
        }
        G(iVar);
    }

    public final void F(i iVar) {
        int i7;
        int i8 = this.f25411j + 1;
        i[] iVarArr = this.f25409h;
        if (i8 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f25409h = iVarArr2;
            this.f25410i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f25409h;
        int i9 = this.f25411j;
        iVarArr3[i9] = iVar;
        int i10 = i9 + 1;
        this.f25411j = i10;
        if (i10 > 1 && iVarArr3[i9].f25421c > iVar.f25421c) {
            int i11 = 0;
            while (true) {
                i7 = this.f25411j;
                if (i11 >= i7) {
                    break;
                }
                this.f25410i[i11] = this.f25409h[i11];
                i11++;
            }
            Arrays.sort(this.f25410i, 0, i7, new a());
            for (int i12 = 0; i12 < this.f25411j; i12++) {
                this.f25409h[i12] = this.f25410i[i12];
            }
        }
        iVar.f25419a = true;
        iVar.a(this);
    }

    public final void G(i iVar) {
        int i7 = 0;
        while (i7 < this.f25411j) {
            if (this.f25409h[i7] == iVar) {
                while (true) {
                    int i8 = this.f25411j;
                    if (i7 >= i8 - 1) {
                        this.f25411j = i8 - 1;
                        iVar.f25419a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f25409h;
                        int i9 = i7 + 1;
                        iVarArr[i7] = iVarArr[i9];
                        i7 = i9;
                    }
                }
            } else {
                i7++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // y.C2830b, y.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y.i a(y.d r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.f25411j
            if (r0 >= r2) goto L32
            y.i[] r2 = r4.f25409h
            r2 = r2[r0]
            int r3 = r2.f25421c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            y.h$b r3 = r4.f25412k
            r3.b(r2)
            if (r1 != r5) goto L22
            y.h$b r2 = r4.f25412k
            boolean r2 = r2.c()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            y.h$b r2 = r4.f25412k
            y.i[] r3 = r4.f25409h
            r3 = r3[r1]
            boolean r2 = r2.h(r3)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r0
        L2f:
            int r0 = r0 + 1
            goto L3
        L32:
            if (r1 != r5) goto L36
            r5 = 0
            return r5
        L36:
            y.i[] r5 = r4.f25409h
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: y.h.a(y.d, boolean[]):y.i");
    }

    @Override // y.C2830b, y.d.a
    public void c(i iVar) {
        this.f25412k.b(iVar);
        this.f25412k.i();
        iVar.f25427i[iVar.f25423e] = 1.0f;
        F(iVar);
    }

    @Override // y.C2830b, y.d.a
    public void clear() {
        this.f25411j = 0;
        this.f25376b = 0.0f;
    }

    @Override // y.C2830b
    public String toString() {
        String str = " goal -> (" + this.f25376b + ") : ";
        for (int i7 = 0; i7 < this.f25411j; i7++) {
            this.f25412k.b(this.f25409h[i7]);
            str = str + this.f25412k + " ";
        }
        return str;
    }
}
