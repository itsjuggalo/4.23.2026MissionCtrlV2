package C;

import C.d;
import C.e;

/* JADX INFO: loaded from: classes.dex */
public class a extends i {

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    public int f240N0 = 0;

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    public boolean f241O0 = true;

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    public int f242P0 = 0;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    public boolean f243Q0 = false;

    @Override // C.e
    public void g(z.d dVar, boolean z7) {
        d[] dVarArr;
        boolean z8;
        z.i iVar;
        d dVar2;
        int i8;
        int i9;
        int i10;
        z.i iVar2;
        int i11;
        d[] dVarArr2 = this.f319W;
        dVarArr2[0] = this.f311O;
        dVarArr2[2] = this.f312P;
        dVarArr2[1] = this.f313Q;
        dVarArr2[3] = this.f314R;
        int i12 = 0;
        while (true) {
            dVarArr = this.f319W;
            if (i12 >= dVarArr.length) {
                break;
            }
            d dVar3 = dVarArr[i12];
            dVar3.f274i = dVar.q(dVar3);
            i12++;
        }
        int i13 = this.f240N0;
        if (i13 < 0 || i13 >= 4) {
            return;
        }
        d dVar4 = dVarArr[i13];
        if (!this.f243Q0) {
            p1();
        }
        if (this.f243Q0) {
            this.f243Q0 = false;
            int i14 = this.f240N0;
            if (i14 == 0 || i14 == 1) {
                dVar.f(this.f311O.f274i, this.f334f0);
                iVar2 = this.f313Q.f274i;
                i11 = this.f334f0;
            } else {
                if (i14 != 2 && i14 != 3) {
                    return;
                }
                dVar.f(this.f312P.f274i, this.f336g0);
                iVar2 = this.f314R.f274i;
                i11 = this.f336g0;
            }
            dVar.f(iVar2, i11);
            return;
        }
        for (int i15 = 0; i15 < this.f422M0; i15++) {
            e eVar = this.f421L0[i15];
            if ((this.f241O0 || eVar.h()) && ((((i9 = this.f240N0) == 0 || i9 == 1) && eVar.y() == e.b.MATCH_CONSTRAINT && eVar.f311O.f271f != null && eVar.f313Q.f271f != null) || (((i10 = this.f240N0) == 2 || i10 == 3) && eVar.R() == e.b.MATCH_CONSTRAINT && eVar.f312P.f271f != null && eVar.f314R.f271f != null))) {
                z8 = true;
                break;
            }
        }
        z8 = false;
        boolean z9 = this.f311O.k() || this.f313Q.k();
        boolean z10 = this.f312P.k() || this.f314R.k();
        int i16 = !(!z8 && (((i8 = this.f240N0) == 0 && z9) || ((i8 == 2 && z10) || ((i8 == 1 && z9) || (i8 == 3 && z10))))) ? 4 : 5;
        for (int i17 = 0; i17 < this.f422M0; i17++) {
            e eVar2 = this.f421L0[i17];
            if (this.f241O0 || eVar2.h()) {
                z.i iVarQ = dVar.q(eVar2.f319W[this.f240N0]);
                d[] dVarArr3 = eVar2.f319W;
                int i18 = this.f240N0;
                d dVar5 = dVarArr3[i18];
                dVar5.f274i = iVarQ;
                d dVar6 = dVar5.f271f;
                int i19 = (dVar6 == null || dVar6.f269d != this) ? 0 : dVar5.f272g;
                if (i18 == 0 || i18 == 2) {
                    dVar.i(dVar4.f274i, iVarQ, this.f242P0 - i19, z8);
                } else {
                    dVar.g(dVar4.f274i, iVarQ, this.f242P0 + i19, z8);
                }
                dVar.e(dVar4.f274i, iVarQ, this.f242P0 + i19, i16);
            }
        }
        int i20 = this.f240N0;
        if (i20 == 0) {
            dVar.e(this.f313Q.f274i, this.f311O.f274i, 0, 8);
            dVar.e(this.f311O.f274i, this.f324a0.f313Q.f274i, 0, 4);
            iVar = this.f311O.f274i;
            dVar2 = this.f324a0.f311O;
        } else if (i20 == 1) {
            dVar.e(this.f311O.f274i, this.f313Q.f274i, 0, 8);
            dVar.e(this.f311O.f274i, this.f324a0.f311O.f274i, 0, 4);
            iVar = this.f311O.f274i;
            dVar2 = this.f324a0.f313Q;
        } else if (i20 == 2) {
            dVar.e(this.f314R.f274i, this.f312P.f274i, 0, 8);
            dVar.e(this.f312P.f274i, this.f324a0.f314R.f274i, 0, 4);
            iVar = this.f312P.f274i;
            dVar2 = this.f324a0.f312P;
        } else {
            if (i20 != 3) {
                return;
            }
            dVar.e(this.f312P.f274i, this.f314R.f274i, 0, 8);
            dVar.e(this.f312P.f274i, this.f324a0.f312P.f274i, 0, 4);
            iVar = this.f312P.f274i;
            dVar2 = this.f324a0.f314R;
        }
        dVar.e(iVar, dVar2.f274i, 0, 0);
    }

    @Override // C.e
    public boolean h() {
        return true;
    }

    @Override // C.e
    public boolean l0() {
        return this.f243Q0;
    }

    @Override // C.e
    public boolean m0() {
        return this.f243Q0;
    }

    public boolean p1() {
        int i8;
        d.b bVar;
        d.b bVar2;
        d.b bVar3;
        int i9;
        int i10;
        boolean z7 = true;
        int i11 = 0;
        while (true) {
            i8 = this.f422M0;
            if (i11 >= i8) {
                break;
            }
            e eVar = this.f421L0[i11];
            if ((this.f241O0 || eVar.h()) && ((((i9 = this.f240N0) == 0 || i9 == 1) && !eVar.l0()) || (((i10 = this.f240N0) == 2 || i10 == 3) && !eVar.m0()))) {
                z7 = false;
            }
            i11++;
        }
        if (!z7 || i8 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z8 = false;
        for (int i12 = 0; i12 < this.f422M0; i12++) {
            e eVar2 = this.f421L0[i12];
            if (this.f241O0 || eVar2.h()) {
                if (!z8) {
                    int i13 = this.f240N0;
                    if (i13 == 0) {
                        bVar3 = d.b.LEFT;
                    } else if (i13 == 1) {
                        bVar3 = d.b.RIGHT;
                    } else if (i13 == 2) {
                        bVar3 = d.b.TOP;
                    } else {
                        if (i13 == 3) {
                            bVar3 = d.b.BOTTOM;
                        }
                        z8 = true;
                    }
                    iMax = eVar2.m(bVar3).d();
                    z8 = true;
                }
                int i14 = this.f240N0;
                if (i14 == 0) {
                    bVar2 = d.b.LEFT;
                } else {
                    if (i14 == 1) {
                        bVar = d.b.RIGHT;
                    } else if (i14 == 2) {
                        bVar2 = d.b.TOP;
                    } else if (i14 == 3) {
                        bVar = d.b.BOTTOM;
                    }
                    iMax = Math.max(iMax, eVar2.m(bVar).d());
                }
                iMax = Math.min(iMax, eVar2.m(bVar2).d());
            }
        }
        int i15 = iMax + this.f242P0;
        int i16 = this.f240N0;
        if (i16 == 0 || i16 == 1) {
            C0(i15, i15);
        } else {
            F0(i15, i15);
        }
        this.f243Q0 = true;
        return true;
    }

    public boolean q1() {
        return this.f241O0;
    }

    public int r1() {
        return this.f240N0;
    }

    public int s1() {
        return this.f242P0;
    }

    public int t1() {
        int i8 = this.f240N0;
        if (i8 == 0 || i8 == 1) {
            return 0;
        }
        return (i8 == 2 || i8 == 3) ? 1 : -1;
    }

    @Override // C.e
    public String toString() {
        String str = "[Barrier] " + r() + " {";
        for (int i8 = 0; i8 < this.f422M0; i8++) {
            e eVar = this.f421L0[i8];
            if (i8 > 0) {
                str = str + ", ";
            }
            str = str + eVar.r();
        }
        return str + "}";
    }

    public void u1() {
        for (int i8 = 0; i8 < this.f422M0; i8++) {
            e eVar = this.f421L0[i8];
            if (this.f241O0 || eVar.h()) {
                int i9 = this.f240N0;
                if (i9 == 0 || i9 == 1) {
                    eVar.P0(0, true);
                } else if (i9 == 2 || i9 == 3) {
                    eVar.P0(1, true);
                }
            }
        }
    }

    public void v1(boolean z7) {
        this.f241O0 = z7;
    }

    public void w1(int i8) {
        this.f240N0 = i8;
    }

    public void x1(int i8) {
        this.f242P0 = i8;
    }
}
