package z;

import java.util.Arrays;
import java.util.Comparator;
import z.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h extends z.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i[] f25492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i[] f25493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25494j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f25495k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f25496l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f25504c - iVar2.f25504c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f25498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f25499b;

        public b(h hVar) {
            this.f25499b = hVar;
        }

        public boolean a(i iVar, float f10) {
            boolean z10 = true;
            if (!this.f25498a.f25502a) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = iVar.f25510i[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f10;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        this.f25498a.f25510i[i10] = f12;
                    } else {
                        this.f25498a.f25510i[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.f25498a.f25510i;
                float f13 = fArr[i11] + (iVar.f25510i[i11] * f10);
                fArr[i11] = f13;
                if (Math.abs(f13) < 1.0E-4f) {
                    this.f25498a.f25510i[i11] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                h.this.G(this.f25498a);
            }
            return false;
        }

        public void b(i iVar) {
            this.f25498a = iVar;
        }

        public final boolean c() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f25498a.f25510i[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(i iVar) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = iVar.f25510i[i10];
                float f11 = this.f25498a.f25510i[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f25498a.f25510i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f25498a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f25498a.f25510i[i10] + " ";
                }
            }
            return str + "] " + this.f25498a;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f25491g = 128;
        this.f25492h = new i[128];
        this.f25493i = new i[128];
        this.f25494j = 0;
        this.f25495k = new b(this);
        this.f25496l = cVar;
    }

    @Override // z.b
    public void B(d dVar, z.b bVar, boolean z10) {
        i iVar = bVar.f25453a;
        if (iVar == null) {
            return;
        }
        b.a aVar = bVar.f25457e;
        int iA = aVar.a();
        for (int i10 = 0; i10 < iA; i10++) {
            i iVarC = aVar.c(i10);
            float fE = aVar.e(i10);
            this.f25495k.b(iVarC);
            if (this.f25495k.a(iVar, fE)) {
                F(iVarC);
            }
            this.f25454b += bVar.f25454b * fE;
        }
        G(iVar);
    }

    public final void F(i iVar) {
        int i10;
        int i11 = this.f25494j + 1;
        i[] iVarArr = this.f25492h;
        if (i11 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f25492h = iVarArr2;
            this.f25493i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f25492h;
        int i12 = this.f25494j;
        iVarArr3[i12] = iVar;
        int i13 = i12 + 1;
        this.f25494j = i13;
        if (i13 > 1 && iVarArr3[i12].f25504c > iVar.f25504c) {
            int i14 = 0;
            while (true) {
                i10 = this.f25494j;
                if (i14 >= i10) {
                    break;
                }
                this.f25493i[i14] = this.f25492h[i14];
                i14++;
            }
            Arrays.sort(this.f25493i, 0, i10, new a());
            for (int i15 = 0; i15 < this.f25494j; i15++) {
                this.f25492h[i15] = this.f25493i[i15];
            }
        }
        iVar.f25502a = true;
        iVar.a(this);
    }

    public final void G(i iVar) {
        int i10 = 0;
        while (i10 < this.f25494j) {
            if (this.f25492h[i10] == iVar) {
                while (true) {
                    int i11 = this.f25494j;
                    if (i10 >= i11 - 1) {
                        this.f25494j = i11 - 1;
                        iVar.f25502a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f25492h;
                        int i12 = i10 + 1;
                        iVarArr[i10] = iVarArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
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
            int r2 = r4.f25494j
            if (r0 >= r2) goto L32
            z.i[] r2 = r4.f25492h
            r2 = r2[r0]
            int r3 = r2.f25504c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            z.h$b r3 = r4.f25495k
            r3.b(r2)
            if (r1 != r5) goto L22
            z.h$b r2 = r4.f25495k
            boolean r2 = r2.c()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            z.h$b r2 = r4.f25495k
            z.i[] r3 = r4.f25492h
            r3 = r3[r1]
            boolean r2 = r2.d(r3)
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
            z.i[] r5 = r4.f25492h
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z.h.b(z.d, boolean[]):z.i");
    }

    @Override // z.b, z.d.a
    public void c(i iVar) {
        this.f25495k.b(iVar);
        this.f25495k.e();
        iVar.f25510i[iVar.f25506e] = 1.0f;
        F(iVar);
    }

    @Override // z.b, z.d.a
    public void clear() {
        this.f25494j = 0;
        this.f25454b = 0.0f;
    }

    @Override // z.b, z.d.a
    public boolean isEmpty() {
        return this.f25494j == 0;
    }

    @Override // z.b
    public String toString() {
        String str = " goal -> (" + this.f25454b + ") : ";
        for (int i10 = 0; i10 < this.f25494j; i10++) {
            this.f25495k.b(this.f25492h[i10]);
            str = str + this.f25495k + " ";
        }
        return str;
    }
}
