package c0;

import c0.d;
import c0.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends i {
    public int N0 = 0;
    public boolean O0 = true;
    public int P0 = 0;
    public boolean Q0 = false;

    @Override // c0.e
    public void g(z.d dVar, boolean z10) {
        d[] dVarArr;
        boolean z11;
        int i10;
        int i11;
        int i12;
        d[] dVarArr2 = this.W;
        dVarArr2[0] = this.O;
        dVarArr2[2] = this.P;
        dVarArr2[1] = this.Q;
        dVarArr2[3] = this.R;
        int i13 = 0;
        while (true) {
            dVarArr = this.W;
            if (i13 >= dVarArr.length) {
                break;
            }
            d dVar2 = dVarArr[i13];
            dVar2.f3445i = dVar.q(dVar2);
            i13++;
        }
        int i14 = this.N0;
        if (i14 < 0 || i14 >= 4) {
            return;
        }
        d dVar3 = dVarArr[i14];
        if (!this.Q0) {
            p1();
        }
        if (this.Q0) {
            this.Q0 = false;
            int i15 = this.N0;
            if (i15 == 0 || i15 == 1) {
                dVar.f(this.O.f3445i, this.f3468f0);
                dVar.f(this.Q.f3445i, this.f3468f0);
                return;
            } else {
                if (i15 == 2 || i15 == 3) {
                    dVar.f(this.P.f3445i, this.f3470g0);
                    dVar.f(this.R.f3445i, this.f3470g0);
                    return;
                }
                return;
            }
        }
        for (int i16 = 0; i16 < this.M0; i16++) {
            e eVar = this.L0[i16];
            if ((this.O0 || eVar.h()) && ((((i11 = this.N0) == 0 || i11 == 1) && eVar.y() == e.b.MATCH_CONSTRAINT && eVar.O.f3442f != null && eVar.Q.f3442f != null) || (((i12 = this.N0) == 2 || i12 == 3) && eVar.R() == e.b.MATCH_CONSTRAINT && eVar.P.f3442f != null && eVar.R.f3442f != null))) {
                z11 = true;
                break;
            }
        }
        z11 = false;
        boolean z12 = this.O.k() || this.Q.k();
        boolean z13 = this.P.k() || this.R.k();
        int i17 = !(!z11 && (((i10 = this.N0) == 0 && z12) || ((i10 == 2 && z13) || ((i10 == 1 && z12) || (i10 == 3 && z13))))) ? 4 : 5;
        for (int i18 = 0; i18 < this.M0; i18++) {
            e eVar2 = this.L0[i18];
            if (this.O0 || eVar2.h()) {
                z.i iVarQ = dVar.q(eVar2.W[this.N0]);
                d[] dVarArr3 = eVar2.W;
                int i19 = this.N0;
                d dVar4 = dVarArr3[i19];
                dVar4.f3445i = iVarQ;
                d dVar5 = dVar4.f3442f;
                int i20 = (dVar5 == null || dVar5.f3440d != this) ? 0 : dVar4.f3443g;
                if (i19 == 0 || i19 == 2) {
                    dVar.i(dVar3.f3445i, iVarQ, this.P0 - i20, z11);
                } else {
                    dVar.g(dVar3.f3445i, iVarQ, this.P0 + i20, z11);
                }
                dVar.e(dVar3.f3445i, iVarQ, this.P0 + i20, i17);
            }
        }
        int i21 = this.N0;
        if (i21 == 0) {
            dVar.e(this.Q.f3445i, this.O.f3445i, 0, 8);
            dVar.e(this.O.f3445i, this.f3458a0.Q.f3445i, 0, 4);
            dVar.e(this.O.f3445i, this.f3458a0.O.f3445i, 0, 0);
            return;
        }
        if (i21 == 1) {
            dVar.e(this.O.f3445i, this.Q.f3445i, 0, 8);
            dVar.e(this.O.f3445i, this.f3458a0.O.f3445i, 0, 4);
            dVar.e(this.O.f3445i, this.f3458a0.Q.f3445i, 0, 0);
        } else if (i21 == 2) {
            dVar.e(this.R.f3445i, this.P.f3445i, 0, 8);
            dVar.e(this.P.f3445i, this.f3458a0.R.f3445i, 0, 4);
            dVar.e(this.P.f3445i, this.f3458a0.P.f3445i, 0, 0);
        } else if (i21 == 3) {
            dVar.e(this.P.f3445i, this.R.f3445i, 0, 8);
            dVar.e(this.P.f3445i, this.f3458a0.P.f3445i, 0, 4);
            dVar.e(this.P.f3445i, this.f3458a0.R.f3445i, 0, 0);
        }
    }

    @Override // c0.e
    public boolean h() {
        return true;
    }

    @Override // c0.e
    public boolean l0() {
        return this.Q0;
    }

    @Override // c0.e
    public boolean m0() {
        return this.Q0;
    }

    public boolean p1() {
        int i10;
        int i11;
        int i12;
        boolean z10 = true;
        int i13 = 0;
        while (true) {
            i10 = this.M0;
            if (i13 >= i10) {
                break;
            }
            e eVar = this.L0[i13];
            if ((this.O0 || eVar.h()) && ((((i11 = this.N0) == 0 || i11 == 1) && !eVar.l0()) || (((i12 = this.N0) == 2 || i12 == 3) && !eVar.m0()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z11 = false;
        for (int i14 = 0; i14 < this.M0; i14++) {
            e eVar2 = this.L0[i14];
            if (this.O0 || eVar2.h()) {
                if (!z11) {
                    int i15 = this.N0;
                    if (i15 == 0) {
                        iMax = eVar2.m(d.b.LEFT).d();
                    } else if (i15 == 1) {
                        iMax = eVar2.m(d.b.RIGHT).d();
                    } else if (i15 == 2) {
                        iMax = eVar2.m(d.b.TOP).d();
                    } else if (i15 == 3) {
                        iMax = eVar2.m(d.b.BOTTOM).d();
                    }
                    z11 = true;
                }
                int i16 = this.N0;
                if (i16 == 0) {
                    iMax = Math.min(iMax, eVar2.m(d.b.LEFT).d());
                } else if (i16 == 1) {
                    iMax = Math.max(iMax, eVar2.m(d.b.RIGHT).d());
                } else if (i16 == 2) {
                    iMax = Math.min(iMax, eVar2.m(d.b.TOP).d());
                } else if (i16 == 3) {
                    iMax = Math.max(iMax, eVar2.m(d.b.BOTTOM).d());
                }
            }
        }
        int i17 = iMax + this.P0;
        int i18 = this.N0;
        if (i18 == 0 || i18 == 1) {
            C0(i17, i17);
        } else {
            F0(i17, i17);
        }
        this.Q0 = true;
        return true;
    }

    public boolean q1() {
        return this.O0;
    }

    public int r1() {
        return this.N0;
    }

    public int s1() {
        return this.P0;
    }

    public int t1() {
        int i10 = this.N0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    @Override // c0.e
    public String toString() {
        String str = "[Barrier] " + r() + " {";
        for (int i10 = 0; i10 < this.M0; i10++) {
            e eVar = this.L0[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + eVar.r();
        }
        return str + "}";
    }

    public void u1() {
        for (int i10 = 0; i10 < this.M0; i10++) {
            e eVar = this.L0[i10];
            if (this.O0 || eVar.h()) {
                int i11 = this.N0;
                if (i11 == 0 || i11 == 1) {
                    eVar.P0(0, true);
                } else if (i11 == 2 || i11 == 3) {
                    eVar.P0(1, true);
                }
            }
        }
    }

    public void v1(boolean z10) {
        this.O0 = z10;
    }

    public void w1(int i10) {
        this.N0 = i10;
    }

    public void x1(int i10) {
        this.P0 = i10;
    }
}
