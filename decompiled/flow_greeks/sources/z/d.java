package z;

import c0.d;
import java.util.Arrays;
import java.util.HashMap;
import z.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f25463r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f25464s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f25465t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f25466u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f25467v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f25468w = 1000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f25469x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f25470y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f25474d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z.b[] f25477g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f25484n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f25487q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25471a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25472b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f25473c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25475e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25476f = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25478h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25479i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean[] f25480j = new boolean[32];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25481k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f25482l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f25483m = 32;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public i[] f25485o = new i[f25468w];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f25486p = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(a aVar);

        i b(d dVar, boolean[] zArr);

        void c(i iVar);

        void clear();

        i getKey();

        boolean isEmpty();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends z.b {
        public b(c cVar) {
            this.f25457e = new j(this, cVar);
        }
    }

    public d() {
        this.f25477g = null;
        this.f25477g = new z.b[32];
        C();
        c cVar = new c();
        this.f25484n = cVar;
        this.f25474d = new h(cVar);
        if (f25467v) {
            this.f25487q = new b(cVar);
        } else {
            this.f25487q = new z.b(cVar);
        }
    }

    public static z.b s(d dVar, i iVar, i iVar2, float f10) {
        return dVar.r().j(iVar, iVar2, f10);
    }

    public static e w() {
        return null;
    }

    public void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public final int B(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f25481k; i10++) {
            this.f25480j[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 < this.f25481k * 2) {
                if (aVar.getKey() != null) {
                    this.f25480j[aVar.getKey().f25504c] = true;
                }
                i iVarB = aVar.b(this, this.f25480j);
                if (iVarB != null) {
                    boolean[] zArr = this.f25480j;
                    int i12 = iVarB.f25504c;
                    if (!zArr[i12]) {
                        zArr[i12] = true;
                    }
                }
                if (iVarB != null) {
                    float f10 = Float.MAX_VALUE;
                    int i13 = -1;
                    for (int i14 = 0; i14 < this.f25482l; i14++) {
                        z.b bVar = this.f25477g[i14];
                        if (bVar.f25453a.f25511j != i.a.UNRESTRICTED && !bVar.f25458f && bVar.t(iVarB)) {
                            float fK = bVar.f25457e.k(iVarB);
                            if (fK < 0.0f) {
                                float f11 = (-bVar.f25454b) / fK;
                                if (f11 < f10) {
                                    i13 = i14;
                                    f10 = f11;
                                }
                            }
                        }
                    }
                    if (i13 > -1) {
                        z.b bVar2 = this.f25477g[i13];
                        bVar2.f25453a.f25505d = -1;
                        bVar2.x(iVarB);
                        i iVar = bVar2.f25453a;
                        iVar.f25505d = i13;
                        iVar.m(this, bVar2);
                    }
                } else {
                    z11 = true;
                }
            }
            return i11;
        }
        return i11;
    }

    public final void C() {
        int i10 = 0;
        if (f25467v) {
            while (i10 < this.f25482l) {
                z.b bVar = this.f25477g[i10];
                if (bVar != null) {
                    this.f25484n.f25459a.a(bVar);
                }
                this.f25477g[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.f25482l) {
            z.b bVar2 = this.f25477g[i10];
            if (bVar2 != null) {
                this.f25484n.f25460b.a(bVar2);
            }
            this.f25477g[i10] = null;
            i10++;
        }
    }

    public void D() {
        c cVar;
        int i10 = 0;
        while (true) {
            cVar = this.f25484n;
            i[] iVarArr = cVar.f25462d;
            if (i10 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i10];
            if (iVar != null) {
                iVar.i();
            }
            i10++;
        }
        cVar.f25461c.c(this.f25485o, this.f25486p);
        this.f25486p = 0;
        Arrays.fill(this.f25484n.f25462d, (Object) null);
        HashMap map = this.f25473c;
        if (map != null) {
            map.clear();
        }
        this.f25472b = 0;
        this.f25474d.clear();
        this.f25481k = 1;
        for (int i11 = 0; i11 < this.f25482l; i11++) {
            z.b bVar = this.f25477g[i11];
            if (bVar != null) {
                bVar.f25455c = false;
            }
        }
        C();
        this.f25482l = 0;
        if (f25467v) {
            this.f25487q = new b(this.f25484n);
        } else {
            this.f25487q = new z.b(this.f25484n);
        }
    }

    public final i a(i.a aVar, String str) {
        i iVar = (i) this.f25484n.f25461c.b();
        if (iVar == null) {
            iVar = new i(aVar, str);
            iVar.l(aVar, str);
        } else {
            iVar.i();
            iVar.l(aVar, str);
        }
        int i10 = this.f25486p;
        int i11 = f25468w;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f25468w = i12;
            this.f25485o = (i[]) Arrays.copyOf(this.f25485o, i12);
        }
        i[] iVarArr = this.f25485o;
        int i13 = this.f25486p;
        this.f25486p = i13 + 1;
        iVarArr[i13] = iVar;
        return iVar;
    }

    public void b(c0.e eVar, c0.e eVar2, float f10, int i10) {
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
        double d10 = f10;
        double d11 = i10;
        bVarR.q(iVarQ2, iVarQ4, iVarQ6, iVarQ8, (float) (Math.sin(d10) * d11));
        d(bVarR);
        z.b bVarR2 = r();
        bVarR2.q(iVarQ, iVarQ3, iVarQ5, iVarQ7, (float) (Math.cos(d10) * d11));
        d(bVarR2);
    }

    public void c(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11, int i12) {
        z.b bVarR = r();
        bVarR.h(iVar, iVar2, i10, f10, iVar3, iVar4, i11);
        if (i12 != 8) {
            bVarR.d(this, i12);
        }
        d(bVarR);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(z.b r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L4
            goto L8a
        L4:
            int r0 = r5.f25482l
            r1 = 1
            int r0 = r0 + r1
            int r2 = r5.f25483m
            if (r0 >= r2) goto L13
            int r0 = r5.f25481k
            int r0 = r0 + r1
            int r2 = r5.f25476f
            if (r0 < r2) goto L16
        L13:
            r5.y()
        L16:
            boolean r0 = r6.f25458f
            r2 = 0
            if (r0 != 0) goto L85
            r6.D(r5)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L25
            goto L8a
        L25:
            r6.r()
            boolean r0 = r6.f(r5)
            if (r0 == 0) goto L7c
            z.i r0 = r5.p()
            r6.f25453a = r0
            int r3 = r5.f25482l
            r5.l(r6)
            int r4 = r5.f25482l
            int r3 = r3 + r1
            if (r4 != r3) goto L7c
            z.d$a r2 = r5.f25487q
            r2.a(r6)
            z.d$a r2 = r5.f25487q
            r5.B(r2, r1)
            int r2 = r0.f25505d
            r3 = -1
            if (r2 != r3) goto L7d
            z.i r2 = r6.f25453a
            if (r2 != r0) goto L5a
            z.i r0 = r6.v(r0)
            if (r0 == 0) goto L5a
            r6.x(r0)
        L5a:
            boolean r0 = r6.f25458f
            if (r0 != 0) goto L63
            z.i r0 = r6.f25453a
            r0.m(r5, r6)
        L63:
            boolean r0 = z.d.f25467v
            if (r0 == 0) goto L6f
            z.c r0 = r5.f25484n
            z.f r0 = r0.f25459a
            r0.a(r6)
            goto L76
        L6f:
            z.c r0 = r5.f25484n
            z.f r0 = r0.f25460b
            r0.a(r6)
        L76:
            int r0 = r5.f25482l
            int r0 = r0 - r1
            r5.f25482l = r0
            goto L7d
        L7c:
            r1 = r2
        L7d:
            boolean r0 = r6.s()
            if (r0 != 0) goto L84
            goto L8a
        L84:
            r2 = r1
        L85:
            if (r2 != 0) goto L8a
            r5.l(r6)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z.d.d(z.b):void");
    }

    public z.b e(i iVar, i iVar2, int i10, int i11) {
        if (f25464s && i11 == 8 && iVar2.f25508g && iVar.f25505d == -1) {
            iVar.k(this, iVar2.f25507f + i10);
            return null;
        }
        z.b bVarR = r();
        bVarR.n(iVar, iVar2, i10);
        if (i11 != 8) {
            bVarR.d(this, i11);
        }
        d(bVarR);
        return bVarR;
    }

    public void f(i iVar, int i10) {
        if (f25464s && iVar.f25505d == -1) {
            float f10 = i10;
            iVar.k(this, f10);
            for (int i11 = 0; i11 < this.f25472b + 1; i11++) {
                i iVar2 = this.f25484n.f25462d[i11];
                if (iVar2 != null && iVar2.f25515n && iVar2.f25516o == iVar.f25504c) {
                    iVar2.k(this, iVar2.f25517p + f10);
                }
            }
            return;
        }
        int i12 = iVar.f25505d;
        if (i12 == -1) {
            z.b bVarR = r();
            bVarR.i(iVar, i10);
            d(bVarR);
            return;
        }
        z.b bVar = this.f25477g[i12];
        if (bVar.f25458f) {
            bVar.f25454b = i10;
            return;
        }
        if (bVar.f25457e.a() == 0) {
            bVar.f25458f = true;
            bVar.f25454b = i10;
        } else {
            z.b bVarR2 = r();
            bVarR2.m(iVar, i10);
            d(bVarR2);
        }
    }

    public void g(i iVar, i iVar2, int i10, boolean z10) {
        z.b bVarR = r();
        i iVarT = t();
        iVarT.f25506e = 0;
        bVarR.o(iVar, iVar2, iVarT, i10);
        d(bVarR);
    }

    public void h(i iVar, i iVar2, int i10, int i11) {
        z.b bVarR = r();
        i iVarT = t();
        iVarT.f25506e = 0;
        bVarR.o(iVar, iVar2, iVarT, i10);
        if (i11 != 8) {
            m(bVarR, (int) (bVarR.f25457e.k(iVarT) * (-1.0f)), i11);
        }
        d(bVarR);
    }

    public void i(i iVar, i iVar2, int i10, boolean z10) {
        z.b bVarR = r();
        i iVarT = t();
        iVarT.f25506e = 0;
        bVarR.p(iVar, iVar2, iVarT, i10);
        d(bVarR);
    }

    public void j(i iVar, i iVar2, int i10, int i11) {
        z.b bVarR = r();
        i iVarT = t();
        iVarT.f25506e = 0;
        bVarR.p(iVar, iVar2, iVarT, i10);
        if (i11 != 8) {
            m(bVarR, (int) (bVarR.f25457e.k(iVarT) * (-1.0f)), i11);
        }
        d(bVarR);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f10, int i10) {
        z.b bVarR = r();
        bVarR.k(iVar, iVar2, iVar3, iVar4, f10);
        if (i10 != 8) {
            bVarR.d(this, i10);
        }
        d(bVarR);
    }

    public final void l(z.b bVar) {
        int i10;
        if (f25465t && bVar.f25458f) {
            bVar.f25453a.k(this, bVar.f25454b);
        } else {
            z.b[] bVarArr = this.f25477g;
            int i11 = this.f25482l;
            bVarArr[i11] = bVar;
            i iVar = bVar.f25453a;
            iVar.f25505d = i11;
            this.f25482l = i11 + 1;
            iVar.m(this, bVar);
        }
        if (f25465t && this.f25471a) {
            int i12 = 0;
            while (i12 < this.f25482l) {
                if (this.f25477g[i12] == null) {
                    System.out.println("WTF");
                }
                z.b bVar2 = this.f25477g[i12];
                if (bVar2 != null && bVar2.f25458f) {
                    bVar2.f25453a.k(this, bVar2.f25454b);
                    if (f25467v) {
                        this.f25484n.f25459a.a(bVar2);
                    } else {
                        this.f25484n.f25460b.a(bVar2);
                    }
                    this.f25477g[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f25482l;
                        if (i13 >= i10) {
                            break;
                        }
                        z.b[] bVarArr2 = this.f25477g;
                        int i15 = i13 - 1;
                        z.b bVar3 = bVarArr2[i13];
                        bVarArr2[i15] = bVar3;
                        i iVar2 = bVar3.f25453a;
                        if (iVar2.f25505d == i13) {
                            iVar2.f25505d = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f25477g[i14] = null;
                    }
                    this.f25482l = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f25471a = false;
        }
    }

    public void m(z.b bVar, int i10, int i11) {
        bVar.e(o(i11, null), i10);
    }

    public final void n() {
        for (int i10 = 0; i10 < this.f25482l; i10++) {
            z.b bVar = this.f25477g[i10];
            bVar.f25453a.f25507f = bVar.f25454b;
        }
    }

    public i o(int i10, String str) {
        if (this.f25481k + 1 >= this.f25476f) {
            y();
        }
        i iVarA = a(i.a.ERROR, str);
        int i11 = this.f25472b + 1;
        this.f25472b = i11;
        this.f25481k++;
        iVarA.f25504c = i11;
        iVarA.f25506e = i10;
        this.f25484n.f25462d[i11] = iVarA;
        this.f25474d.c(iVarA);
        return iVarA;
    }

    public i p() {
        if (this.f25481k + 1 >= this.f25476f) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i10 = this.f25472b + 1;
        this.f25472b = i10;
        this.f25481k++;
        iVarA.f25504c = i10;
        this.f25484n.f25462d[i10] = iVarA;
        return iVarA;
    }

    public i q(Object obj) {
        i iVarH = null;
        if (obj == null) {
            return null;
        }
        if (this.f25481k + 1 >= this.f25476f) {
            y();
        }
        if (obj instanceof c0.d) {
            c0.d dVar = (c0.d) obj;
            iVarH = dVar.h();
            if (iVarH == null) {
                dVar.r(this.f25484n);
                iVarH = dVar.h();
            }
            int i10 = iVarH.f25504c;
            if (i10 != -1 && i10 <= this.f25472b && this.f25484n.f25462d[i10] != null) {
                return iVarH;
            }
            if (i10 != -1) {
                iVarH.i();
            }
            int i11 = this.f25472b + 1;
            this.f25472b = i11;
            this.f25481k++;
            iVarH.f25504c = i11;
            iVarH.f25511j = i.a.UNRESTRICTED;
            this.f25484n.f25462d[i11] = iVarH;
        }
        return iVarH;
    }

    public z.b r() {
        z.b bVar;
        if (f25467v) {
            bVar = (z.b) this.f25484n.f25459a.b();
            if (bVar == null) {
                bVar = new b(this.f25484n);
                f25470y++;
            } else {
                bVar.y();
            }
        } else {
            bVar = (z.b) this.f25484n.f25460b.b();
            if (bVar == null) {
                bVar = new z.b(this.f25484n);
                f25469x++;
            } else {
                bVar.y();
            }
        }
        i.c();
        return bVar;
    }

    public i t() {
        if (this.f25481k + 1 >= this.f25476f) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i10 = this.f25472b + 1;
        this.f25472b = i10;
        this.f25481k++;
        iVarA.f25504c = i10;
        this.f25484n.f25462d[i10] = iVarA;
        return iVarA;
    }

    public final int u(a aVar) {
        float f10;
        float f11;
        for (int i10 = 0; i10 < this.f25482l; i10++) {
            z.b bVar = this.f25477g[i10];
            if (bVar.f25453a.f25511j != i.a.UNRESTRICTED) {
                float f12 = 0.0f;
                if (bVar.f25454b < 0.0f) {
                    boolean z10 = false;
                    int i11 = 0;
                    while (!z10) {
                        i11++;
                        float f13 = Float.MAX_VALUE;
                        int i12 = 0;
                        int i13 = -1;
                        int i14 = -1;
                        int i15 = 0;
                        while (true) {
                            if (i12 >= this.f25482l) {
                                break;
                            }
                            z.b bVar2 = this.f25477g[i12];
                            if (bVar2.f25453a.f25511j == i.a.UNRESTRICTED || bVar2.f25458f || bVar2.f25454b >= f12) {
                                f10 = f12;
                            } else if (f25466u) {
                                int iA = bVar2.f25457e.a();
                                int i16 = 0;
                                while (i16 < iA) {
                                    i iVarC = bVar2.f25457e.c(i16);
                                    float fK = bVar2.f25457e.k(iVarC);
                                    if (fK <= f12) {
                                        f11 = f12;
                                    } else {
                                        f11 = f12;
                                        for (int i17 = 0; i17 < 9; i17++) {
                                            float f14 = iVarC.f25509h[i17] / fK;
                                            if ((f14 < f13 && i17 == i15) || i17 > i15) {
                                                i15 = i17;
                                                i14 = iVarC.f25504c;
                                                i13 = i12;
                                                f13 = f14;
                                            }
                                        }
                                    }
                                    i16++;
                                    f12 = f11;
                                }
                                f10 = f12;
                            } else {
                                f10 = f12;
                                for (int i18 = 1; i18 < this.f25481k; i18++) {
                                    i iVar = this.f25484n.f25462d[i18];
                                    float fK2 = bVar2.f25457e.k(iVar);
                                    if (fK2 > f10) {
                                        for (int i19 = 0; i19 < 9; i19++) {
                                            float f15 = iVar.f25509h[i19] / fK2;
                                            if ((f15 < f13 && i19 == i15) || i19 > i15) {
                                                i15 = i19;
                                                i13 = i12;
                                                i14 = i18;
                                                f13 = f15;
                                            }
                                        }
                                    }
                                }
                            }
                            i12++;
                            f12 = f10;
                        }
                        float f16 = f12;
                        if (i13 != -1) {
                            z.b bVar3 = this.f25477g[i13];
                            bVar3.f25453a.f25505d = -1;
                            bVar3.x(this.f25484n.f25462d[i14]);
                            i iVar2 = bVar3.f25453a;
                            iVar2.f25505d = i13;
                            iVar2.m(this, bVar3);
                        } else {
                            z10 = true;
                        }
                        if (i11 > this.f25481k / 2) {
                            z10 = true;
                        }
                        f12 = f16;
                    }
                    return i11;
                }
            }
        }
        return 0;
    }

    public c v() {
        return this.f25484n;
    }

    public int x(Object obj) {
        i iVarH = ((c0.d) obj).h();
        if (iVarH != null) {
            return (int) (iVarH.f25507f + 0.5f);
        }
        return 0;
    }

    public final void y() {
        int i10 = this.f25475e * 2;
        this.f25475e = i10;
        this.f25477g = (z.b[]) Arrays.copyOf(this.f25477g, i10);
        c cVar = this.f25484n;
        cVar.f25462d = (i[]) Arrays.copyOf(cVar.f25462d, this.f25475e);
        int i11 = this.f25475e;
        this.f25480j = new boolean[i11];
        this.f25476f = i11;
        this.f25483m = i11;
    }

    public void z() {
        if (this.f25474d.isEmpty()) {
            n();
            return;
        }
        if (!this.f25478h && !this.f25479i) {
            A(this.f25474d);
            return;
        }
        for (int i10 = 0; i10 < this.f25482l; i10++) {
            if (!this.f25477g[i10].f25458f) {
                A(this.f25474d);
                return;
            }
        }
        n();
    }
}
