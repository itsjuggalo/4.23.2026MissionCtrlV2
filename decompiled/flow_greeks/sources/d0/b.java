package d0;

import c0.d;
import c0.e;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7397a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f7398b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0.f f7399c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f7400k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f7401l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f7402m = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e.b f7403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e.b f7404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7406d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7407e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7408f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7409g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f7410h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f7411i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7412j;
    }

    /* JADX INFO: renamed from: d0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0137b {
        void a();

        void b(c0.e eVar, a aVar);
    }

    public b(c0.f fVar) {
        this.f7399c = fVar;
    }

    public final boolean a(InterfaceC0137b interfaceC0137b, c0.e eVar, int i10) {
        this.f7398b.f7403a = eVar.y();
        this.f7398b.f7404b = eVar.R();
        this.f7398b.f7405c = eVar.U();
        this.f7398b.f7406d = eVar.v();
        a aVar = this.f7398b;
        aVar.f7411i = false;
        aVar.f7412j = i10;
        e.b bVar = aVar.f7403a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z10 = bVar == bVar2;
        boolean z11 = aVar.f7404b == bVar2;
        boolean z12 = z10 && eVar.f3464d0 > 0.0f;
        boolean z13 = z11 && eVar.f3464d0 > 0.0f;
        if (z12 && eVar.f3505y[0] == 4) {
            aVar.f7403a = e.b.FIXED;
        }
        if (z13 && eVar.f3505y[1] == 4) {
            aVar.f7404b = e.b.FIXED;
        }
        interfaceC0137b.b(eVar, aVar);
        eVar.g1(this.f7398b.f7407e);
        eVar.I0(this.f7398b.f7408f);
        eVar.H0(this.f7398b.f7410h);
        eVar.x0(this.f7398b.f7409g);
        a aVar2 = this.f7398b;
        aVar2.f7412j = a.f7400k;
        return aVar2.f7411i;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0093 A[PHI: r10
      0x0093: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0061, B:34:0x0067, B:52:0x0090, B:50:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(c0.f r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = r13.L0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.O1(r1)
            d0.b$b r2 = r13.E1()
            r3 = 0
            r4 = r3
        L12:
            if (r4 >= r0) goto La0
            java.util.ArrayList r5 = r13.L0
            java.lang.Object r5 = r5.get(r4)
            c0.e r5 = (c0.e) r5
            boolean r6 = r5 instanceof c0.g
            if (r6 == 0) goto L22
            goto L9c
        L22:
            boolean r6 = r5 instanceof c0.a
            if (r6 == 0) goto L28
            goto L9c
        L28:
            boolean r6 = r5.j0()
            if (r6 == 0) goto L30
            goto L9c
        L30:
            if (r1 == 0) goto L47
            d0.l r6 = r5.f3465e
            if (r6 == 0) goto L47
            d0.n r7 = r5.f3467f
            if (r7 == 0) goto L47
            d0.g r6 = r6.f7481e
            boolean r6 = r6.f7433j
            if (r6 == 0) goto L47
            d0.g r6 = r7.f7481e
            boolean r6 = r6.f7433j
            if (r6 == 0) goto L47
            goto L9c
        L47:
            c0.e$b r6 = r5.s(r3)
            r7 = 1
            c0.e$b r8 = r5.s(r7)
            c0.e$b r9 = c0.e.b.MATCH_CONSTRAINT
            if (r6 != r9) goto L60
            int r10 = r5.f3501w
            if (r10 == r7) goto L60
            if (r8 != r9) goto L60
            int r10 = r5.f3503x
            if (r10 == r7) goto L60
            r10 = r7
            goto L61
        L60:
            r10 = r3
        L61:
            if (r10 != 0) goto L93
            boolean r11 = r13.O1(r7)
            if (r11 == 0) goto L93
            if (r6 != r9) goto L78
            int r11 = r5.f3501w
            if (r11 != 0) goto L78
            if (r8 == r9) goto L78
            boolean r11 = r5.g0()
            if (r11 != 0) goto L78
            r10 = r7
        L78:
            if (r8 != r9) goto L87
            int r11 = r5.f3503x
            if (r11 != 0) goto L87
            if (r6 == r9) goto L87
            boolean r11 = r5.g0()
            if (r11 != 0) goto L87
            r10 = r7
        L87:
            if (r6 == r9) goto L8b
            if (r8 != r9) goto L93
        L8b:
            float r6 = r5.f3464d0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L93
            goto L94
        L93:
            r7 = r10
        L94:
            if (r7 == 0) goto L97
            goto L9c
        L97:
            int r6 = d0.b.a.f7400k
            r12.a(r2, r5, r6)
        L9c:
            int r4 = r4 + 1
            goto L12
        La0:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.b.b(c0.f):void");
    }

    public final void c(c0.f fVar, String str, int i10, int i11, int i12) {
        int iG = fVar.G();
        int iF = fVar.F();
        fVar.W0(0);
        fVar.V0(0);
        fVar.g1(i11);
        fVar.I0(i12);
        fVar.W0(iG);
        fVar.V0(iF);
        this.f7399c.S1(i10);
        this.f7399c.o1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [int] */
    public long d(c0.f fVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean zD1;
        int i19;
        int i20;
        int i21;
        c0.f fVar2;
        long j10;
        int i22;
        boolean z10;
        int i23;
        b bVar = this;
        InterfaceC0137b interfaceC0137bE1 = fVar.E1();
        int size = fVar.L0.size();
        int iU = fVar.U();
        int iV = fVar.v();
        boolean zB = c0.j.b(i10, 128);
        boolean z11 = false;
        boolean z12 = zB || c0.j.b(i10, 64);
        if (z12) {
            for (int i24 = 0; i24 < size; i24++) {
                c0.e eVar = (c0.e) fVar.L0.get(i24);
                e.b bVarY = eVar.y();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                boolean z13 = (bVarY == bVar2) && (eVar.R() == bVar2) && eVar.t() > 0.0f;
                if ((eVar.g0() && z13) || ((eVar.i0() && z13) || eVar.g0() || eVar.i0())) {
                    z12 = false;
                    break;
                }
            }
        }
        if (z12) {
            boolean z14 = z.d.f25463r;
        }
        boolean z15 = z12 & ((i13 == 1073741824 && i15 == 1073741824) || zB);
        if (z15) {
            int iMin = Math.min(fVar.E(), i14);
            int iMin2 = Math.min(fVar.D(), i16);
            if (i13 == 1073741824 && fVar.U() != iMin) {
                fVar.g1(iMin);
                fVar.H1();
            }
            if (i15 == 1073741824 && fVar.v() != iMin2) {
                fVar.I0(iMin2);
                fVar.H1();
            }
            if (i13 == 1073741824 && i15 == 1073741824) {
                zD1 = fVar.B1(zB);
                i19 = 2;
            } else {
                boolean zC1 = fVar.C1(zB);
                if (i13 == 1073741824) {
                    zC1 &= fVar.D1(zB, 0);
                    i19 = 1;
                } else {
                    i19 = 0;
                }
                if (i15 == 1073741824) {
                    zD1 = fVar.D1(zB, 1) & zC1;
                    i19++;
                } else {
                    zD1 = zC1;
                }
            }
            if (zD1) {
                fVar.l1(i13 == 1073741824, i15 == 1073741824);
            }
        } else {
            zD1 = false;
            i19 = 0;
        }
        long j11 = 0;
        if (zD1 && i19 == 2) {
            return 0L;
        }
        int iF1 = fVar.F1();
        if (size > 0) {
            b(fVar);
        }
        e(fVar);
        int size2 = bVar.f7397a.size();
        if (size > 0) {
            bVar.c(fVar, "First pass", 0, iU, iV);
            i20 = iU;
            i21 = iV;
        } else {
            i20 = iU;
            i21 = iV;
        }
        if (size2 > 0) {
            e.b bVarY2 = fVar.y();
            e.b bVar3 = e.b.WRAP_CONTENT;
            boolean z16 = bVarY2 == bVar3;
            boolean z17 = fVar.R() == bVar3;
            int iMax = Math.max(fVar.U(), bVar.f7399c.G());
            int iMax2 = Math.max(fVar.v(), bVar.f7399c.F());
            int i25 = 0;
            while (i25 < size2) {
                long j12 = j11;
                i25++;
                j11 = j12;
            }
            j10 = j11;
            int i26 = 0;
            for (int i27 = 2; i26 < i27; i27 = 2) {
                boolean zA = z11;
                for (?? r14 = zA; r14 < size2; r14++) {
                    c0.e eVar2 = (c0.e) bVar.f7397a.get(r14);
                    if ((eVar2 instanceof c0.h) || (eVar2 instanceof c0.g)) {
                        i22 = i20;
                    } else {
                        i22 = i20;
                        if (eVar2.T() != 8 && (!z15 || !eVar2.f3465e.f7481e.f7433j || !eVar2.f3467f.f7481e.f7433j)) {
                            int iU2 = eVar2.U();
                            int iV2 = eVar2.v();
                            z10 = z15;
                            int iN = eVar2.n();
                            int i28 = a.f7401l;
                            boolean z18 = zA;
                            if (i26 == 1) {
                                i28 = a.f7402m;
                            }
                            zA = z18 | bVar.a(interfaceC0137bE1, eVar2, i28);
                            int iU3 = eVar2.U();
                            i23 = i26;
                            int iV3 = eVar2.v();
                            if (iU3 != iU2) {
                                eVar2.g1(iU3);
                                if (z16 && eVar2.K() > iMax) {
                                    iMax = Math.max(iMax, eVar2.K() + eVar2.m(d.b.RIGHT).e());
                                }
                                zA = true;
                            }
                            if (iV3 != iV2) {
                                eVar2.I0(iV3);
                                if (z17 && eVar2.p() > iMax2) {
                                    iMax2 = Math.max(iMax2, eVar2.p() + eVar2.m(d.b.BOTTOM).e());
                                }
                                zA = true;
                            }
                            if (eVar2.X() && iN != eVar2.n()) {
                                zA = true;
                            }
                        }
                        bVar = this;
                        i20 = i22;
                        z15 = z10;
                        i26 = i23;
                    }
                    z10 = z15;
                    i23 = i26;
                    bVar = this;
                    i20 = i22;
                    z15 = z10;
                    i26 = i23;
                }
                int i29 = i20;
                boolean z19 = z15;
                int i30 = i26;
                if (!zA) {
                    break;
                }
                i26 = i30 + 1;
                c(fVar, "intermediate pass", i26, i29, i21);
                bVar = this;
                i20 = i29;
                z15 = z19;
                z11 = false;
            }
            fVar2 = fVar;
        } else {
            fVar2 = fVar;
            j10 = 0;
        }
        fVar2.R1(iF1);
        return j10;
    }

    public void e(c0.f fVar) {
        this.f7397a.clear();
        int size = fVar.L0.size();
        for (int i10 = 0; i10 < size; i10++) {
            c0.e eVar = (c0.e) fVar.L0.get(i10);
            e.b bVarY = eVar.y();
            e.b bVar = e.b.MATCH_CONSTRAINT;
            if (bVarY == bVar || eVar.R() == bVar) {
                this.f7397a.add(eVar);
            }
        }
        fVar.H1();
    }
}
