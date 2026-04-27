package z;

import java.util.Arrays;
import java.util.Comparator;
import z.b;

/* JADX INFO: loaded from: classes.dex */
public class h extends z.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f24571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i[] f24572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i[] f24573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f24574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f24575k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f24576l;

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f24584c - iVar2.f24584c;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f24578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f24579b;

        public b(h hVar) {
            this.f24579b = hVar;
        }

        public boolean a(i iVar, float f8) {
            boolean z7 = true;
            if (!this.f24578a.f24582a) {
                for (int i8 = 0; i8 < 9; i8++) {
                    float f9 = iVar.f24590i[i8];
                    if (f9 != 0.0f) {
                        float f10 = f9 * f8;
                        if (Math.abs(f10) < 1.0E-4f) {
                            f10 = 0.0f;
                        }
                        this.f24578a.f24590i[i8] = f10;
                    } else {
                        this.f24578a.f24590i[i8] = 0.0f;
                    }
                }
                return true;
            }
            for (int i9 = 0; i9 < 9; i9++) {
                float[] fArr = this.f24578a.f24590i;
                float f11 = fArr[i9] + (iVar.f24590i[i9] * f8);
                fArr[i9] = f11;
                if (Math.abs(f11) < 1.0E-4f) {
                    this.f24578a.f24590i[i9] = 0.0f;
                } else {
                    z7 = false;
                }
            }
            if (z7) {
                h.this.G(this.f24578a);
            }
            return false;
        }

        public void b(i iVar) {
            this.f24578a = iVar;
        }

        public final boolean c() {
            for (int i8 = 8; i8 >= 0; i8--) {
                float f8 = this.f24578a.f24590i[i8];
                if (f8 > 0.0f) {
                    return false;
                }
                if (f8 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(i iVar) {
            int i8 = 8;
            while (true) {
                if (i8 < 0) {
                    break;
                }
                float f8 = iVar.f24590i[i8];
                float f9 = this.f24578a.f24590i[i8];
                if (f9 == f8) {
                    i8--;
                } else if (f9 < f8) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f24578a.f24590i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f24578a != null) {
                for (int i8 = 0; i8 < 9; i8++) {
                    str = str + this.f24578a.f24590i[i8] + " ";
                }
            }
            return str + "] " + this.f24578a;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f24571g = 128;
        this.f24572h = new i[128];
        this.f24573i = new i[128];
        this.f24574j = 0;
        this.f24575k = new b(this);
        this.f24576l = cVar;
    }

    @Override // z.b
    public void B(d dVar, z.b bVar, boolean z7) {
        i iVar = bVar.f24533a;
        if (iVar == null) {
            return;
        }
        b.a aVar = bVar.f24537e;
        int iA = aVar.a();
        for (int i8 = 0; i8 < iA; i8++) {
            i iVarC = aVar.c(i8);
            float fE = aVar.e(i8);
            this.f24575k.b(iVarC);
            if (this.f24575k.a(iVar, fE)) {
                F(iVarC);
            }
            this.f24534b += bVar.f24534b * fE;
        }
        G(iVar);
    }

    public final void F(i iVar) {
        int i8;
        int i9 = this.f24574j + 1;
        i[] iVarArr = this.f24572h;
        if (i9 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f24572h = iVarArr2;
            this.f24573i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f24572h;
        int i10 = this.f24574j;
        iVarArr3[i10] = iVar;
        int i11 = i10 + 1;
        this.f24574j = i11;
        if (i11 > 1 && iVarArr3[i10].f24584c > iVar.f24584c) {
            int i12 = 0;
            while (true) {
                i8 = this.f24574j;
                if (i12 >= i8) {
                    break;
                }
                this.f24573i[i12] = this.f24572h[i12];
                i12++;
            }
            Arrays.sort(this.f24573i, 0, i8, new a());
            for (int i13 = 0; i13 < this.f24574j; i13++) {
                this.f24572h[i13] = this.f24573i[i13];
            }
        }
        iVar.f24582a = true;
        iVar.a(this);
    }

    public final void G(i iVar) {
        int i8 = 0;
        while (i8 < this.f24574j) {
            if (this.f24572h[i8] == iVar) {
                while (true) {
                    int i9 = this.f24574j;
                    if (i8 >= i9 - 1) {
                        this.f24574j = i9 - 1;
                        iVar.f24582a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f24572h;
                        int i10 = i8 + 1;
                        iVarArr[i8] = iVarArr[i10];
                        i8 = i10;
                    }
                }
            } else {
                i8++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    @Override // z.b, z.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z.i b(z.d r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.f24574j
            if (r0 >= r2) goto L30
            z.i[] r2 = r4.f24572h
            r2 = r2[r0]
            int r3 = r2.f24584c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2d
        L12:
            z.h$b r3 = r4.f24575k
            r3.b(r2)
            z.h$b r2 = r4.f24575k
            if (r1 != r5) goto L22
            boolean r2 = r2.c()
            if (r2 == 0) goto L2d
            goto L2c
        L22:
            z.i[] r3 = r4.f24572h
            r3 = r3[r1]
            boolean r2 = r2.d(r3)
            if (r2 == 0) goto L2d
        L2c:
            r1 = r0
        L2d:
            int r0 = r0 + 1
            goto L3
        L30:
            if (r1 != r5) goto L34
            r5 = 0
            return r5
        L34:
            z.i[] r5 = r4.f24572h
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z.h.b(z.d, boolean[]):z.i");
    }

    @Override // z.b, z.d.a
    public void c(i iVar) {
        this.f24575k.b(iVar);
        this.f24575k.e();
        iVar.f24590i[iVar.f24586e] = 1.0f;
        F(iVar);
    }

    @Override // z.b, z.d.a
    public void clear() {
        this.f24574j = 0;
        this.f24534b = 0.0f;
    }

    @Override // z.b, z.d.a
    public boolean isEmpty() {
        return this.f24574j == 0;
    }

    @Override // z.b
    public String toString() {
        String str = " goal -> (" + this.f24534b + ") : ";
        for (int i8 = 0; i8 < this.f24574j; i8++) {
            this.f24575k.b(this.f24572h[i8]);
            str = str + this.f24575k + " ";
        }
        return str;
    }
}
