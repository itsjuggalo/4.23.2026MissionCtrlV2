package d0;

import c0.d;
import c0.e;
import d0.b;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b.a f7446a = new b.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f7447b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f7448c = 0;

    public static boolean a(int i10, c0.e eVar) {
        e.b bVar;
        e.b bVar2;
        e.b bVarY = eVar.y();
        e.b bVarR = eVar.R();
        c0.f fVar = eVar.I() != null ? (c0.f) eVar.I() : null;
        if (fVar != null) {
            fVar.y();
            e.b bVar3 = e.b.FIXED;
        }
        if (fVar != null) {
            fVar.R();
            e.b bVar4 = e.b.FIXED;
        }
        e.b bVar5 = e.b.FIXED;
        boolean z10 = bVarY == bVar5 || eVar.l0() || bVarY == e.b.WRAP_CONTENT || (bVarY == (bVar2 = e.b.MATCH_CONSTRAINT) && eVar.f3501w == 0 && eVar.f3464d0 == 0.0f && eVar.Y(0)) || (bVarY == bVar2 && eVar.f3501w == 1 && eVar.b0(0, eVar.U()));
        boolean z11 = bVarR == bVar5 || eVar.m0() || bVarR == e.b.WRAP_CONTENT || (bVarR == (bVar = e.b.MATCH_CONSTRAINT) && eVar.f3503x == 0 && eVar.f3464d0 == 0.0f && eVar.Y(1)) || (bVarR == bVar && eVar.f3503x == 1 && eVar.b0(1, eVar.v()));
        if (eVar.f3464d0 <= 0.0f || !(z10 || z11)) {
            return z10 && z11;
        }
        return true;
    }

    public static void b(int i10, c0.e eVar, b.InterfaceC0137b interfaceC0137b, boolean z10) {
        c0.d dVar;
        c0.d dVar2;
        boolean z11;
        c0.d dVar3;
        c0.d dVar4;
        if (eVar.e0()) {
            return;
        }
        boolean z12 = true;
        f7447b++;
        if (!(eVar instanceof c0.f) && eVar.k0()) {
            int i11 = i10 + 1;
            if (a(i11, eVar)) {
                c0.f.N1(i11, eVar, interfaceC0137b, new b.a(), b.a.f7400k);
            }
        }
        c0.d dVarM = eVar.m(d.b.LEFT);
        c0.d dVarM2 = eVar.m(d.b.RIGHT);
        int iD = dVarM.d();
        int iD2 = dVarM2.d();
        if (dVarM.c() != null && dVarM.m()) {
            for (c0.d dVar5 : dVarM.c()) {
                c0.e eVar2 = dVar5.f3440d;
                int i12 = i10 + 1;
                boolean zA = a(i12, eVar2);
                if (eVar2.k0() && zA) {
                    z11 = z12;
                    c0.f.N1(i12, eVar2, interfaceC0137b, new b.a(), b.a.f7400k);
                } else {
                    z11 = z12;
                }
                boolean z13 = ((dVar5 == eVar2.O && (dVar4 = eVar2.Q.f3442f) != null && dVar4.m()) || (dVar5 == eVar2.Q && (dVar3 = eVar2.O.f3442f) != null && dVar3.m())) ? z11 : false;
                e.b bVarY = eVar2.y();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarY != bVar || zA) {
                    if (!eVar2.k0()) {
                        c0.d dVar6 = eVar2.O;
                        if (dVar5 == dVar6 && eVar2.Q.f3442f == null) {
                            int iE = dVar6.e() + iD;
                            eVar2.C0(iE, eVar2.U() + iE);
                            b(i12, eVar2, interfaceC0137b, z10);
                        } else {
                            c0.d dVar7 = eVar2.Q;
                            if (dVar5 == dVar7 && dVar6.f3442f == null) {
                                int iE2 = iD - dVar7.e();
                                eVar2.C0(iE2 - eVar2.U(), iE2);
                                b(i12, eVar2, interfaceC0137b, z10);
                            } else if (z13 && !eVar2.g0()) {
                                d(i12, interfaceC0137b, eVar2, z10);
                            }
                        }
                    }
                } else if (eVar2.y() == bVar && eVar2.A >= 0 && eVar2.f3507z >= 0 && ((eVar2.T() == 8 || (eVar2.f3501w == 0 && eVar2.t() == 0.0f)) && !eVar2.g0() && !eVar2.j0() && z13 && !eVar2.g0())) {
                    e(i12, eVar, interfaceC0137b, eVar2, z10);
                }
                z12 = z11;
            }
        }
        boolean z14 = z12;
        if (eVar instanceof c0.g) {
            return;
        }
        if (dVarM2.c() != null && dVarM2.m()) {
            for (c0.d dVar8 : dVarM2.c()) {
                c0.e eVar3 = dVar8.f3440d;
                int i13 = i10 + 1;
                boolean zA2 = a(i13, eVar3);
                if (eVar3.k0() && zA2) {
                    c0.f.N1(i13, eVar3, interfaceC0137b, new b.a(), b.a.f7400k);
                }
                boolean z15 = ((dVar8 == eVar3.O && (dVar2 = eVar3.Q.f3442f) != null && dVar2.m()) || (dVar8 == eVar3.Q && (dVar = eVar3.O.f3442f) != null && dVar.m())) ? z14 : false;
                e.b bVarY2 = eVar3.y();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVarY2 != bVar2 || zA2) {
                    if (!eVar3.k0()) {
                        c0.d dVar9 = eVar3.O;
                        if (dVar8 == dVar9 && eVar3.Q.f3442f == null) {
                            int iE3 = dVar9.e() + iD2;
                            eVar3.C0(iE3, eVar3.U() + iE3);
                            b(i13, eVar3, interfaceC0137b, z10);
                        } else {
                            c0.d dVar10 = eVar3.Q;
                            if (dVar8 == dVar10 && dVar9.f3442f == null) {
                                int iE4 = iD2 - dVar10.e();
                                eVar3.C0(iE4 - eVar3.U(), iE4);
                                b(i13, eVar3, interfaceC0137b, z10);
                            } else if (z15 && !eVar3.g0()) {
                                d(i13, interfaceC0137b, eVar3, z10);
                            }
                        }
                    }
                } else if (eVar3.y() == bVar2 && eVar3.A >= 0 && eVar3.f3507z >= 0 && (eVar3.T() == 8 || (eVar3.f3501w == 0 && eVar3.t() == 0.0f))) {
                    if (!eVar3.g0() && !eVar3.j0() && z15 && !eVar3.g0()) {
                        e(i13, eVar, interfaceC0137b, eVar3, z10);
                    }
                }
            }
        }
        eVar.o0();
    }

    public static void c(int i10, c0.a aVar, b.InterfaceC0137b interfaceC0137b, int i11, boolean z10) {
        if (aVar.p1()) {
            if (i11 == 0) {
                b(i10 + 1, aVar, interfaceC0137b, z10);
            } else {
                i(i10 + 1, aVar, interfaceC0137b);
            }
        }
    }

    public static void d(int i10, b.InterfaceC0137b interfaceC0137b, c0.e eVar, boolean z10) {
        float fW = eVar.w();
        int iD = eVar.O.f3442f.d();
        int iD2 = eVar.Q.f3442f.d();
        int iE = eVar.O.e() + iD;
        int iE2 = iD2 - eVar.Q.e();
        if (iD == iD2) {
            fW = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iU = eVar.U();
        int i11 = (iD2 - iD) - iU;
        if (iD > iD2) {
            i11 = (iD - iD2) - iU;
        }
        int i12 = ((int) (i11 > 0 ? (fW * i11) + 0.5f : fW * i11)) + iD;
        int i13 = i12 + iU;
        if (iD > iD2) {
            i13 = i12 - iU;
        }
        eVar.C0(i12, i13);
        b(i10 + 1, eVar, interfaceC0137b, z10);
    }

    public static void e(int i10, c0.e eVar, b.InterfaceC0137b interfaceC0137b, c0.e eVar2, boolean z10) {
        float fW = eVar2.w();
        int iD = eVar2.O.f3442f.d() + eVar2.O.e();
        int iD2 = eVar2.Q.f3442f.d() - eVar2.Q.e();
        if (iD2 >= iD) {
            int iU = eVar2.U();
            if (eVar2.T() != 8) {
                int i11 = eVar2.f3501w;
                if (i11 == 2) {
                    iU = (int) (eVar2.w() * 0.5f * (eVar instanceof c0.f ? eVar.U() : eVar.I().U()));
                } else if (i11 == 0) {
                    iU = iD2 - iD;
                }
                iU = Math.max(eVar2.f3507z, iU);
                int i12 = eVar2.A;
                if (i12 > 0) {
                    iU = Math.min(i12, iU);
                }
            }
            int i13 = iD + ((int) ((fW * ((iD2 - iD) - iU)) + 0.5f));
            eVar2.C0(i13, iU + i13);
            b(i10 + 1, eVar2, interfaceC0137b, z10);
        }
    }

    public static void f(int i10, b.InterfaceC0137b interfaceC0137b, c0.e eVar) {
        float fP = eVar.P();
        int iD = eVar.P.f3442f.d();
        int iD2 = eVar.R.f3442f.d();
        int iE = eVar.P.e() + iD;
        int iE2 = iD2 - eVar.R.e();
        if (iD == iD2) {
            fP = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iV = eVar.v();
        int i11 = (iD2 - iD) - iV;
        if (iD > iD2) {
            i11 = (iD - iD2) - iV;
        }
        int i12 = (int) (i11 > 0 ? (fP * i11) + 0.5f : fP * i11);
        int i13 = iD + i12;
        int i14 = i13 + iV;
        if (iD > iD2) {
            i13 = iD - i12;
            i14 = i13 - iV;
        }
        eVar.F0(i13, i14);
        i(i10 + 1, eVar, interfaceC0137b);
    }

    public static void g(int i10, c0.e eVar, b.InterfaceC0137b interfaceC0137b, c0.e eVar2) {
        float fP = eVar2.P();
        int iD = eVar2.P.f3442f.d() + eVar2.P.e();
        int iD2 = eVar2.R.f3442f.d() - eVar2.R.e();
        if (iD2 >= iD) {
            int iV = eVar2.v();
            if (eVar2.T() != 8) {
                int i11 = eVar2.f3503x;
                if (i11 == 2) {
                    iV = (int) (fP * 0.5f * (eVar instanceof c0.f ? eVar.v() : eVar.I().v()));
                } else if (i11 == 0) {
                    iV = iD2 - iD;
                }
                iV = Math.max(eVar2.C, iV);
                int i12 = eVar2.D;
                if (i12 > 0) {
                    iV = Math.min(i12, iV);
                }
            }
            int i13 = iD + ((int) ((fP * ((iD2 - iD) - iV)) + 0.5f));
            eVar2.F0(i13, iV + i13);
            i(i10 + 1, eVar2, interfaceC0137b);
        }
    }

    public static void h(c0.f fVar, b.InterfaceC0137b interfaceC0137b) {
        e.b bVarY = fVar.y();
        e.b bVarR = fVar.R();
        f7447b = 0;
        f7448c = 0;
        fVar.s0();
        ArrayList arrayListN1 = fVar.n1();
        int size = arrayListN1.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c0.e) arrayListN1.get(i10)).s0();
        }
        boolean zK1 = fVar.K1();
        if (bVarY == e.b.FIXED) {
            fVar.C0(0, fVar.U());
        } else {
            fVar.D0(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            c0.e eVar = (c0.e) arrayListN1.get(i11);
            if (eVar instanceof c0.g) {
                c0.g gVar = (c0.g) eVar;
                if (gVar.o1() == 1) {
                    if (gVar.p1() != -1) {
                        gVar.s1(gVar.p1());
                    } else if (gVar.q1() != -1 && fVar.l0()) {
                        gVar.s1(fVar.U() - gVar.q1());
                    } else if (fVar.l0()) {
                        gVar.s1((int) ((gVar.r1() * fVar.U()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((eVar instanceof c0.a) && ((c0.a) eVar).t1() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                c0.e eVar2 = (c0.e) arrayListN1.get(i12);
                if (eVar2 instanceof c0.g) {
                    c0.g gVar2 = (c0.g) eVar2;
                    if (gVar2.o1() == 1) {
                        b(0, gVar2, interfaceC0137b, zK1);
                    }
                }
            }
        }
        b(0, fVar, interfaceC0137b, zK1);
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                c0.e eVar3 = (c0.e) arrayListN1.get(i13);
                if (eVar3 instanceof c0.a) {
                    c0.a aVar = (c0.a) eVar3;
                    if (aVar.t1() == 0) {
                        c(0, aVar, interfaceC0137b, 0, zK1);
                    }
                }
            }
        }
        if (bVarR == e.b.FIXED) {
            fVar.F0(0, fVar.v());
        } else {
            fVar.E0(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i14 = 0; i14 < size; i14++) {
            c0.e eVar4 = (c0.e) arrayListN1.get(i14);
            if (eVar4 instanceof c0.g) {
                c0.g gVar3 = (c0.g) eVar4;
                if (gVar3.o1() == 0) {
                    if (gVar3.p1() != -1) {
                        gVar3.s1(gVar3.p1());
                    } else if (gVar3.q1() != -1 && fVar.m0()) {
                        gVar3.s1(fVar.v() - gVar3.q1());
                    } else if (fVar.m0()) {
                        gVar3.s1((int) ((gVar3.r1() * fVar.v()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((eVar4 instanceof c0.a) && ((c0.a) eVar4).t1() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i15 = 0; i15 < size; i15++) {
                c0.e eVar5 = (c0.e) arrayListN1.get(i15);
                if (eVar5 instanceof c0.g) {
                    c0.g gVar4 = (c0.g) eVar5;
                    if (gVar4.o1() == 0) {
                        i(1, gVar4, interfaceC0137b);
                    }
                }
            }
        }
        i(0, fVar, interfaceC0137b);
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                c0.e eVar6 = (c0.e) arrayListN1.get(i16);
                if (eVar6 instanceof c0.a) {
                    c0.a aVar2 = (c0.a) eVar6;
                    if (aVar2.t1() == 1) {
                        c(0, aVar2, interfaceC0137b, 1, zK1);
                    }
                }
            }
        }
        for (int i17 = 0; i17 < size; i17++) {
            c0.e eVar7 = (c0.e) arrayListN1.get(i17);
            if (eVar7.k0() && a(0, eVar7)) {
                c0.f.N1(0, eVar7, interfaceC0137b, f7446a, b.a.f7400k);
                if (!(eVar7 instanceof c0.g)) {
                    b(0, eVar7, interfaceC0137b, zK1);
                    i(0, eVar7, interfaceC0137b);
                } else if (((c0.g) eVar7).o1() == 0) {
                    i(0, eVar7, interfaceC0137b);
                } else {
                    b(0, eVar7, interfaceC0137b, zK1);
                }
            }
        }
    }

    public static void i(int i10, c0.e eVar, b.InterfaceC0137b interfaceC0137b) {
        c0.d dVar;
        c0.d dVar2;
        c0.d dVar3;
        c0.d dVar4;
        if (eVar.n0()) {
            return;
        }
        boolean z10 = true;
        f7448c++;
        if (!(eVar instanceof c0.f) && eVar.k0()) {
            int i11 = i10 + 1;
            if (a(i11, eVar)) {
                c0.f.N1(i11, eVar, interfaceC0137b, new b.a(), b.a.f7400k);
            }
        }
        c0.d dVarM = eVar.m(d.b.TOP);
        c0.d dVarM2 = eVar.m(d.b.BOTTOM);
        int iD = dVarM.d();
        int iD2 = dVarM2.d();
        if (dVarM.c() != null && dVarM.m()) {
            for (c0.d dVar5 : dVarM.c()) {
                c0.e eVar2 = dVar5.f3440d;
                int i12 = i10 + 1;
                boolean zA = a(i12, eVar2);
                if (eVar2.k0() && zA) {
                    c0.f.N1(i12, eVar2, interfaceC0137b, new b.a(), b.a.f7400k);
                }
                boolean z11 = ((dVar5 == eVar2.P && (dVar4 = eVar2.R.f3442f) != null && dVar4.m()) || (dVar5 == eVar2.R && (dVar3 = eVar2.P.f3442f) != null && dVar3.m())) ? z10 : false;
                e.b bVarR = eVar2.R();
                boolean z12 = z10;
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarR != bVar || zA) {
                    if (!eVar2.k0()) {
                        c0.d dVar6 = eVar2.P;
                        if (dVar5 == dVar6 && eVar2.R.f3442f == null) {
                            int iE = dVar6.e() + iD;
                            eVar2.F0(iE, eVar2.v() + iE);
                            i(i12, eVar2, interfaceC0137b);
                        } else {
                            c0.d dVar7 = eVar2.R;
                            if (dVar5 == dVar7 && dVar6.f3442f == null) {
                                int iE2 = iD - dVar7.e();
                                eVar2.F0(iE2 - eVar2.v(), iE2);
                                i(i12, eVar2, interfaceC0137b);
                            } else if (z11 && !eVar2.i0()) {
                                f(i12, interfaceC0137b, eVar2);
                            }
                        }
                    }
                } else if (eVar2.R() == bVar && eVar2.D >= 0 && eVar2.C >= 0 && ((eVar2.T() == 8 || (eVar2.f3503x == 0 && eVar2.t() == 0.0f)) && !eVar2.i0() && !eVar2.j0() && z11 && !eVar2.i0())) {
                    g(i12, eVar, interfaceC0137b, eVar2);
                }
                z10 = z12;
            }
        }
        boolean z13 = z10;
        if (eVar instanceof c0.g) {
            return;
        }
        if (dVarM2.c() != null && dVarM2.m()) {
            for (c0.d dVar8 : dVarM2.c()) {
                c0.e eVar3 = dVar8.f3440d;
                int i13 = i10 + 1;
                boolean zA2 = a(i13, eVar3);
                if (eVar3.k0() && zA2) {
                    c0.f.N1(i13, eVar3, interfaceC0137b, new b.a(), b.a.f7400k);
                }
                boolean z14 = ((dVar8 == eVar3.P && (dVar2 = eVar3.R.f3442f) != null && dVar2.m()) || (dVar8 == eVar3.R && (dVar = eVar3.P.f3442f) != null && dVar.m())) ? z13 : false;
                e.b bVarR2 = eVar3.R();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVarR2 != bVar2 || zA2) {
                    if (!eVar3.k0()) {
                        c0.d dVar9 = eVar3.P;
                        if (dVar8 == dVar9 && eVar3.R.f3442f == null) {
                            int iE3 = dVar9.e() + iD2;
                            eVar3.F0(iE3, eVar3.v() + iE3);
                            i(i13, eVar3, interfaceC0137b);
                        } else {
                            c0.d dVar10 = eVar3.R;
                            if (dVar8 == dVar10 && dVar9.f3442f == null) {
                                int iE4 = iD2 - dVar10.e();
                                eVar3.F0(iE4 - eVar3.v(), iE4);
                                i(i13, eVar3, interfaceC0137b);
                            } else if (z14 && !eVar3.i0()) {
                                f(i13, interfaceC0137b, eVar3);
                            }
                        }
                    }
                } else if (eVar3.R() == bVar2 && eVar3.D >= 0 && eVar3.C >= 0 && (eVar3.T() == 8 || (eVar3.f3503x == 0 && eVar3.t() == 0.0f))) {
                    if (!eVar3.i0() && !eVar3.j0() && z14 && !eVar3.i0()) {
                        g(i13, eVar, interfaceC0137b, eVar3);
                    }
                }
            }
        }
        c0.d dVarM3 = eVar.m(d.b.BASELINE);
        if (dVarM3.c() != null && dVarM3.m()) {
            int iD3 = dVarM3.d();
            for (c0.d dVar11 : dVarM3.c()) {
                c0.e eVar4 = dVar11.f3440d;
                int i14 = i10 + 1;
                boolean zA3 = a(i14, eVar4);
                if (eVar4.k0() && zA3) {
                    c0.f.N1(i14, eVar4, interfaceC0137b, new b.a(), b.a.f7400k);
                }
                if (eVar4.R() != e.b.MATCH_CONSTRAINT || zA3) {
                    if (!eVar4.k0() && dVar11 == eVar4.S) {
                        eVar4.B0(dVar11.e() + iD3);
                        i(i14, eVar4, interfaceC0137b);
                    }
                }
            }
        }
        eVar.p0();
    }
}
