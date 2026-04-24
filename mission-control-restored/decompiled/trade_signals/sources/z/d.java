package z;

import C.d;
import java.util.Arrays;
import java.util.HashMap;
import z.i;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f24543r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f24544s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f24545t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f24546u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f24547v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f24548w = 1000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f24549x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f24550y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f24554d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z.b[] f24557g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f24564n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f24567q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24551a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24552b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f24553c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24555e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24556f = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f24558h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f24559i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean[] f24560j = new boolean[32];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f24561k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f24562l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f24563m = 32;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public i[] f24565o = new i[f24548w];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f24566p = 0;

    public interface a {
        void a(a aVar);

        i b(d dVar, boolean[] zArr);

        void c(i iVar);

        void clear();

        i getKey();

        boolean isEmpty();
    }

    public class b extends z.b {
        public b(c cVar) {
            this.f24537e = new j(this, cVar);
        }
    }

    public d() {
        this.f24557g = null;
        this.f24557g = new z.b[32];
        C();
        c cVar = new c();
        this.f24564n = cVar;
        this.f24554d = new h(cVar);
        this.f24567q = f24547v ? new b(cVar) : new z.b(cVar);
    }

    public static z.b s(d dVar, i iVar, i iVar2, float f8) {
        return dVar.r().j(iVar, iVar2, f8);
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
        for (int i8 = 0; i8 < this.f24561k; i8++) {
            this.f24560j[i8] = false;
        }
        boolean z8 = false;
        int i9 = 0;
        while (!z8) {
            i9++;
            if (i9 >= this.f24561k * 2) {
                return i9;
            }
            if (aVar.getKey() != null) {
                this.f24560j[aVar.getKey().f24584c] = true;
            }
            i iVarB = aVar.b(this, this.f24560j);
            if (iVarB != null) {
                boolean[] zArr = this.f24560j;
                int i10 = iVarB.f24584c;
                if (zArr[i10]) {
                    return i9;
                }
                zArr[i10] = true;
            }
            if (iVarB != null) {
                float f8 = Float.MAX_VALUE;
                int i11 = -1;
                for (int i12 = 0; i12 < this.f24562l; i12++) {
                    z.b bVar = this.f24557g[i12];
                    if (bVar.f24533a.f24591j != i.a.UNRESTRICTED && !bVar.f24538f && bVar.t(iVarB)) {
                        float fK = bVar.f24537e.k(iVarB);
                        if (fK < 0.0f) {
                            float f9 = (-bVar.f24534b) / fK;
                            if (f9 < f8) {
                                i11 = i12;
                                f8 = f9;
                            }
                        }
                    }
                }
                if (i11 > -1) {
                    z.b bVar2 = this.f24557g[i11];
                    bVar2.f24533a.f24585d = -1;
                    bVar2.x(iVarB);
                    i iVar = bVar2.f24533a;
                    iVar.f24585d = i11;
                    iVar.n(this, bVar2);
                }
            } else {
                z8 = true;
            }
        }
        return i9;
    }

    public final void C() {
        int i8 = 0;
        if (f24547v) {
            while (i8 < this.f24562l) {
                z.b bVar = this.f24557g[i8];
                if (bVar != null) {
                    this.f24564n.f24539a.a(bVar);
                }
                this.f24557g[i8] = null;
                i8++;
            }
            return;
        }
        while (i8 < this.f24562l) {
            z.b bVar2 = this.f24557g[i8];
            if (bVar2 != null) {
                this.f24564n.f24540b.a(bVar2);
            }
            this.f24557g[i8] = null;
            i8++;
        }
    }

    public void D() {
        c cVar;
        int i8 = 0;
        while (true) {
            cVar = this.f24564n;
            i[] iVarArr = cVar.f24542d;
            if (i8 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i8];
            if (iVar != null) {
                iVar.k();
            }
            i8++;
        }
        cVar.f24541c.c(this.f24565o, this.f24566p);
        this.f24566p = 0;
        Arrays.fill(this.f24564n.f24542d, (Object) null);
        HashMap map = this.f24553c;
        if (map != null) {
            map.clear();
        }
        this.f24552b = 0;
        this.f24554d.clear();
        this.f24561k = 1;
        for (int i9 = 0; i9 < this.f24562l; i9++) {
            z.b bVar = this.f24557g[i9];
            if (bVar != null) {
                bVar.f24535c = false;
            }
        }
        C();
        this.f24562l = 0;
        this.f24567q = f24547v ? new b(this.f24564n) : new z.b(this.f24564n);
    }

    public final i a(i.a aVar, String str) {
        i iVar = (i) this.f24564n.f24541c.b();
        if (iVar == null) {
            iVar = new i(aVar, str);
        } else {
            iVar.k();
        }
        iVar.m(aVar, str);
        int i8 = this.f24566p;
        int i9 = f24548w;
        if (i8 >= i9) {
            int i10 = i9 * 2;
            f24548w = i10;
            this.f24565o = (i[]) Arrays.copyOf(this.f24565o, i10);
        }
        i[] iVarArr = this.f24565o;
        int i11 = this.f24566p;
        this.f24566p = i11 + 1;
        iVarArr[i11] = iVar;
        return iVar;
    }

    public void b(C.e eVar, C.e eVar2, float f8, int i8) {
        d.b bVar = d.b.LEFT;
        i iVarQ = q(eVar.m(bVar));
        d.b bVar2 = d.b.TOP;
        i iVarQ2 = q(eVar.m(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i iVarQ3 = q(eVar.m(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i iVarQ4 = q(eVar.m(bVar4));
        i iVarQ5 = q(eVar2.m(bVar));
        i iVarQ6 = q(eVar2.m(bVar2));
        i iVarQ7 = q(eVar2.m(bVar3));
        i iVarQ8 = q(eVar2.m(bVar4));
        z.b bVarR = r();
        double d8 = f8;
        double d9 = i8;
        bVarR.q(iVarQ2, iVarQ4, iVarQ6, iVarQ8, (float) (Math.sin(d8) * d9));
        d(bVarR);
        z.b bVarR2 = r();
        bVarR2.q(iVarQ, iVarQ3, iVarQ5, iVarQ7, (float) (Math.cos(d8) * d9));
        d(bVarR2);
    }

    public void c(i iVar, i iVar2, int i8, float f8, i iVar3, i iVar4, int i9, int i10) {
        z.b bVarR = r();
        bVarR.h(iVar, iVar2, i8, f8, iVar3, iVar4, i9);
        if (i10 != 8) {
            bVarR.d(this, i10);
        }
        d(bVarR);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(z.b r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r5.f24562l
            r1 = 1
            int r0 = r0 + r1
            int r2 = r5.f24563m
            if (r0 >= r2) goto L12
            int r0 = r5.f24561k
            int r0 = r0 + r1
            int r2 = r5.f24556f
            if (r0 < r2) goto L15
        L12:
            r5.y()
        L15:
            boolean r0 = r6.f24538f
            r2 = 0
            if (r0 != 0) goto L82
            r6.D(r5)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L24
            return
        L24:
            r6.r()
            boolean r0 = r6.f(r5)
            if (r0 == 0) goto L79
            z.i r0 = r5.p()
            r6.f24533a = r0
            int r3 = r5.f24562l
            r5.l(r6)
            int r4 = r5.f24562l
            int r3 = r3 + r1
            if (r4 != r3) goto L79
            z.d$a r2 = r5.f24567q
            r2.a(r6)
            z.d$a r2 = r5.f24567q
            r5.B(r2, r1)
            int r2 = r0.f24585d
            r3 = -1
            if (r2 != r3) goto L7a
            z.i r2 = r6.f24533a
            if (r2 != r0) goto L59
            z.i r0 = r6.v(r0)
            if (r0 == 0) goto L59
            r6.x(r0)
        L59:
            boolean r0 = r6.f24538f
            if (r0 != 0) goto L62
            z.i r0 = r6.f24533a
            r0.n(r5, r6)
        L62:
            boolean r0 = z.d.f24547v
            if (r0 == 0) goto L6e
            z.c r0 = r5.f24564n
            z.f r0 = r0.f24539a
        L6a:
            r0.a(r6)
            goto L73
        L6e:
            z.c r0 = r5.f24564n
            z.f r0 = r0.f24540b
            goto L6a
        L73:
            int r0 = r5.f24562l
            int r0 = r0 - r1
            r5.f24562l = r0
            goto L7a
        L79:
            r1 = r2
        L7a:
            boolean r0 = r6.s()
            if (r0 != 0) goto L81
            return
        L81:
            r2 = r1
        L82:
            if (r2 != 0) goto L87
            r5.l(r6)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z.d.d(z.b):void");
    }

    public z.b e(i iVar, i iVar2, int i8, int i9) {
        if (f24544s && i9 == 8 && iVar2.f24588g && iVar.f24585d == -1) {
            iVar.l(this, iVar2.f24587f + i8);
            return null;
        }
        z.b bVarR = r();
        bVarR.n(iVar, iVar2, i8);
        if (i9 != 8) {
            bVarR.d(this, i9);
        }
        d(bVarR);
        return bVarR;
    }

    public void f(i iVar, int i8) {
        z.b bVarR;
        if (f24544s && iVar.f24585d == -1) {
            float f8 = i8;
            iVar.l(this, f8);
            for (int i9 = 0; i9 < this.f24552b + 1; i9++) {
                i iVar2 = this.f24564n.f24542d[i9];
                if (iVar2 != null && iVar2.f24595n && iVar2.f24596o == iVar.f24584c) {
                    iVar2.l(this, iVar2.f24597p + f8);
                }
            }
            return;
        }
        int i10 = iVar.f24585d;
        if (i10 != -1) {
            z.b bVar = this.f24557g[i10];
            if (!bVar.f24538f) {
                if (bVar.f24537e.a() == 0) {
                    bVar.f24538f = true;
                } else {
                    bVarR = r();
                    bVarR.m(iVar, i8);
                }
            }
            bVar.f24534b = i8;
            return;
        }
        bVarR = r();
        bVarR.i(iVar, i8);
        d(bVarR);
    }

    public void g(i iVar, i iVar2, int i8, boolean z7) {
        z.b bVarR = r();
        i iVarT = t();
        iVarT.f24586e = 0;
        bVarR.o(iVar, iVar2, iVarT, i8);
        d(bVarR);
    }

    public void h(i iVar, i iVar2, int i8, int i9) {
        z.b bVarR = r();
        i iVarT = t();
        iVarT.f24586e = 0;
        bVarR.o(iVar, iVar2, iVarT, i8);
        if (i9 != 8) {
            m(bVarR, (int) (bVarR.f24537e.k(iVarT) * (-1.0f)), i9);
        }
        d(bVarR);
    }

    public void i(i iVar, i iVar2, int i8, boolean z7) {
        z.b bVarR = r();
        i iVarT = t();
        iVarT.f24586e = 0;
        bVarR.p(iVar, iVar2, iVarT, i8);
        d(bVarR);
    }

    public void j(i iVar, i iVar2, int i8, int i9) {
        z.b bVarR = r();
        i iVarT = t();
        iVarT.f24586e = 0;
        bVarR.p(iVar, iVar2, iVarT, i8);
        if (i9 != 8) {
            m(bVarR, (int) (bVarR.f24537e.k(iVarT) * (-1.0f)), i9);
        }
        d(bVarR);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f8, int i8) {
        z.b bVarR = r();
        bVarR.k(iVar, iVar2, iVar3, iVar4, f8);
        if (i8 != 8) {
            bVarR.d(this, i8);
        }
        d(bVarR);
    }

    public final void l(z.b bVar) {
        int i8;
        if (f24545t && bVar.f24538f) {
            bVar.f24533a.l(this, bVar.f24534b);
        } else {
            z.b[] bVarArr = this.f24557g;
            int i9 = this.f24562l;
            bVarArr[i9] = bVar;
            i iVar = bVar.f24533a;
            iVar.f24585d = i9;
            this.f24562l = i9 + 1;
            iVar.n(this, bVar);
        }
        if (f24545t && this.f24551a) {
            int i10 = 0;
            while (i10 < this.f24562l) {
                if (this.f24557g[i10] == null) {
                    System.out.println("WTF");
                }
                z.b bVar2 = this.f24557g[i10];
                if (bVar2 != null && bVar2.f24538f) {
                    bVar2.f24533a.l(this, bVar2.f24534b);
                    (f24547v ? this.f24564n.f24539a : this.f24564n.f24540b).a(bVar2);
                    this.f24557g[i10] = null;
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (true) {
                        i8 = this.f24562l;
                        if (i11 >= i8) {
                            break;
                        }
                        z.b[] bVarArr2 = this.f24557g;
                        int i13 = i11 - 1;
                        z.b bVar3 = bVarArr2[i11];
                        bVarArr2[i13] = bVar3;
                        i iVar2 = bVar3.f24533a;
                        if (iVar2.f24585d == i11) {
                            iVar2.f24585d = i13;
                        }
                        i12 = i11;
                        i11++;
                    }
                    if (i12 < i8) {
                        this.f24557g[i12] = null;
                    }
                    this.f24562l = i8 - 1;
                    i10--;
                }
                i10++;
            }
            this.f24551a = false;
        }
    }

    public void m(z.b bVar, int i8, int i9) {
        bVar.e(o(i9, null), i8);
    }

    public final void n() {
        for (int i8 = 0; i8 < this.f24562l; i8++) {
            z.b bVar = this.f24557g[i8];
            bVar.f24533a.f24587f = bVar.f24534b;
        }
    }

    public i o(int i8, String str) {
        if (this.f24561k + 1 >= this.f24556f) {
            y();
        }
        i iVarA = a(i.a.ERROR, str);
        int i9 = this.f24552b + 1;
        this.f24552b = i9;
        this.f24561k++;
        iVarA.f24584c = i9;
        iVarA.f24586e = i8;
        this.f24564n.f24542d[i9] = iVarA;
        this.f24554d.c(iVarA);
        return iVarA;
    }

    public i p() {
        if (this.f24561k + 1 >= this.f24556f) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i8 = this.f24552b + 1;
        this.f24552b = i8;
        this.f24561k++;
        iVarA.f24584c = i8;
        this.f24564n.f24542d[i8] = iVarA;
        return iVarA;
    }

    public i q(Object obj) {
        i iVarH = null;
        if (obj == null) {
            return null;
        }
        if (this.f24561k + 1 >= this.f24556f) {
            y();
        }
        if (obj instanceof C.d) {
            C.d dVar = (C.d) obj;
            iVarH = dVar.h();
            if (iVarH == null) {
                dVar.r(this.f24564n);
                iVarH = dVar.h();
            }
            int i8 = iVarH.f24584c;
            if (i8 == -1 || i8 > this.f24552b || this.f24564n.f24542d[i8] == null) {
                if (i8 != -1) {
                    iVarH.k();
                }
                int i9 = this.f24552b + 1;
                this.f24552b = i9;
                this.f24561k++;
                iVarH.f24584c = i9;
                iVarH.f24591j = i.a.UNRESTRICTED;
                this.f24564n.f24542d[i9] = iVarH;
            }
        }
        return iVarH;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f A[PHI: r0
      0x001f: PHI (r0v6 z.b) = (r0v4 z.b), (r0v11 z.b) binds: [B:9:0x002d, B:5:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z.b r() {
        /*
            r5 = this;
            boolean r0 = z.d.f24547v
            r1 = 1
            if (r0 == 0) goto L23
            z.c r0 = r5.f24564n
            z.f r0 = r0.f24539a
            java.lang.Object r0 = r0.b()
            z.b r0 = (z.b) r0
            if (r0 != 0) goto L1f
            z.d$b r0 = new z.d$b
            z.c r3 = r5.f24564n
            r0.<init>(r3)
            long r3 = z.d.f24550y
            long r3 = r3 + r1
            z.d.f24550y = r3
            goto L3b
        L1f:
            r0.y()
            goto L3b
        L23:
            z.c r0 = r5.f24564n
            z.f r0 = r0.f24540b
            java.lang.Object r0 = r0.b()
            z.b r0 = (z.b) r0
            if (r0 != 0) goto L1f
            z.b r0 = new z.b
            z.c r3 = r5.f24564n
            r0.<init>(r3)
            long r3 = z.d.f24549x
            long r3 = r3 + r1
            z.d.f24549x = r3
        L3b:
            z.i.g()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z.d.r():z.b");
    }

    public i t() {
        if (this.f24561k + 1 >= this.f24556f) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i8 = this.f24552b + 1;
        this.f24552b = i8;
        this.f24561k++;
        iVarA.f24584c = i8;
        this.f24564n.f24542d[i8] = iVarA;
        return iVarA;
    }

    public final int u(a aVar) {
        for (int i8 = 0; i8 < this.f24562l; i8++) {
            z.b bVar = this.f24557g[i8];
            if (bVar.f24533a.f24591j != i.a.UNRESTRICTED && bVar.f24534b < 0.0f) {
                boolean z7 = false;
                int i9 = 0;
                while (!z7) {
                    i9++;
                    float f8 = Float.MAX_VALUE;
                    int i10 = 0;
                    int i11 = -1;
                    int i12 = -1;
                    int i13 = 0;
                    while (true) {
                        if (i10 >= this.f24562l) {
                            break;
                        }
                        z.b bVar2 = this.f24557g[i10];
                        if (bVar2.f24533a.f24591j != i.a.UNRESTRICTED && !bVar2.f24538f && bVar2.f24534b < 0.0f) {
                            int i14 = 9;
                            if (f24546u) {
                                int iA = bVar2.f24537e.a();
                                int i15 = 0;
                                while (i15 < iA) {
                                    i iVarC = bVar2.f24537e.c(i15);
                                    float fK = bVar2.f24537e.k(iVarC);
                                    if (fK > 0.0f) {
                                        int i16 = 0;
                                        while (i16 < i14) {
                                            float f9 = iVarC.f24589h[i16] / fK;
                                            if ((f9 < f8 && i16 == i13) || i16 > i13) {
                                                i13 = i16;
                                                i12 = iVarC.f24584c;
                                                i11 = i10;
                                                f8 = f9;
                                            }
                                            i16++;
                                            i14 = 9;
                                        }
                                    }
                                    i15++;
                                    i14 = 9;
                                }
                            } else {
                                for (int i17 = 1; i17 < this.f24561k; i17++) {
                                    i iVar = this.f24564n.f24542d[i17];
                                    float fK2 = bVar2.f24537e.k(iVar);
                                    if (fK2 > 0.0f) {
                                        for (int i18 = 0; i18 < 9; i18++) {
                                            float f10 = iVar.f24589h[i18] / fK2;
                                            if ((f10 < f8 && i18 == i13) || i18 > i13) {
                                                i11 = i10;
                                                i12 = i17;
                                                i13 = i18;
                                                f8 = f10;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i10++;
                    }
                    if (i11 != -1) {
                        z.b bVar3 = this.f24557g[i11];
                        bVar3.f24533a.f24585d = -1;
                        bVar3.x(this.f24564n.f24542d[i12]);
                        i iVar2 = bVar3.f24533a;
                        iVar2.f24585d = i11;
                        iVar2.n(this, bVar3);
                    } else {
                        z7 = true;
                    }
                    if (i9 > this.f24561k / 2) {
                        z7 = true;
                    }
                }
                return i9;
            }
        }
        return 0;
    }

    public c v() {
        return this.f24564n;
    }

    public int x(Object obj) {
        i iVarH = ((C.d) obj).h();
        if (iVarH != null) {
            return (int) (iVarH.f24587f + 0.5f);
        }
        return 0;
    }

    public final void y() {
        int i8 = this.f24555e * 2;
        this.f24555e = i8;
        this.f24557g = (z.b[]) Arrays.copyOf(this.f24557g, i8);
        c cVar = this.f24564n;
        cVar.f24542d = (i[]) Arrays.copyOf(cVar.f24542d, this.f24555e);
        int i9 = this.f24555e;
        this.f24560j = new boolean[i9];
        this.f24556f = i9;
        this.f24563m = i9;
    }

    public void z() {
        if (this.f24554d.isEmpty()) {
            n();
            return;
        }
        if (this.f24558h || this.f24559i) {
            for (int i8 = 0; i8 < this.f24562l; i8++) {
                if (this.f24557g[i8].f24538f) {
                }
            }
            n();
            return;
        }
        A(this.f24554d);
    }
}
