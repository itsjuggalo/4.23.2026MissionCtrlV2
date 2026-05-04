package c0;

import c0.d;
import c0.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g extends e {
    public float L0 = -1.0f;
    public int M0 = -1;
    public int N0 = -1;
    public boolean O0 = true;
    public d P0 = this.P;
    public int Q0 = 0;
    public int R0 = 0;
    public boolean S0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3532a;

        static {
            int[] iArr = new int[d.b.values().length];
            f3532a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3532a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3532a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3532a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3532a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3532a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3532a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3532a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3532a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public g() {
        this.X.clear();
        this.X.add(this.P0);
        int length = this.W.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.W[i10] = this.P0;
        }
    }

    @Override // c0.e
    public void g(z.d dVar, boolean z10) {
        f fVar = (f) I();
        if (fVar == null) {
            return;
        }
        d dVarM = fVar.m(d.b.LEFT);
        d dVarM2 = fVar.m(d.b.RIGHT);
        e eVar = this.f3458a0;
        boolean z11 = eVar != null && eVar.Z[0] == e.b.WRAP_CONTENT;
        if (this.Q0 == 0) {
            dVarM = fVar.m(d.b.TOP);
            dVarM2 = fVar.m(d.b.BOTTOM);
            e eVar2 = this.f3458a0;
            z11 = eVar2 != null && eVar2.Z[1] == e.b.WRAP_CONTENT;
        }
        if (this.S0 && this.P0.m()) {
            z.i iVarQ = dVar.q(this.P0);
            dVar.f(iVarQ, this.P0.d());
            if (this.M0 != -1) {
                if (z11) {
                    dVar.h(dVar.q(dVarM2), iVarQ, 0, 5);
                }
            } else if (this.N0 != -1 && z11) {
                z.i iVarQ2 = dVar.q(dVarM2);
                dVar.h(iVarQ, dVar.q(dVarM), 0, 5);
                dVar.h(iVarQ2, iVarQ, 0, 5);
            }
            this.S0 = false;
            return;
        }
        if (this.M0 != -1) {
            z.i iVarQ3 = dVar.q(this.P0);
            dVar.e(iVarQ3, dVar.q(dVarM), this.M0, 8);
            if (z11) {
                dVar.h(dVar.q(dVarM2), iVarQ3, 0, 5);
                return;
            }
            return;
        }
        if (this.N0 == -1) {
            if (this.L0 != -1.0f) {
                dVar.d(z.d.s(dVar, dVar.q(this.P0), dVar.q(dVarM2), this.L0));
                return;
            }
            return;
        }
        z.i iVarQ4 = dVar.q(this.P0);
        z.i iVarQ5 = dVar.q(dVarM2);
        dVar.e(iVarQ4, iVarQ5, -this.N0, 8);
        if (z11) {
            dVar.h(iVarQ4, dVar.q(dVarM), 0, 5);
            dVar.h(iVarQ5, iVarQ4, 0, 5);
        }
    }

    @Override // c0.e
    public boolean h() {
        return true;
    }

    @Override // c0.e
    public boolean l0() {
        return this.S0;
    }

    @Override // c0.e
    public d m(d.b bVar) {
        int i10 = a.f3532a[bVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            if (this.Q0 == 1) {
                return this.P0;
            }
            return null;
        }
        if ((i10 == 3 || i10 == 4) && this.Q0 == 0) {
            return this.P0;
        }
        return null;
    }

    @Override // c0.e
    public boolean m0() {
        return this.S0;
    }

    @Override // c0.e
    public void m1(z.d dVar, boolean z10) {
        if (I() == null) {
            return;
        }
        int iX = dVar.x(this.P0);
        if (this.Q0 == 1) {
            i1(iX);
            j1(0);
            I0(I().v());
            g1(0);
            return;
        }
        i1(0);
        j1(iX);
        g1(I().U());
        I0(0);
    }

    public d n1() {
        return this.P0;
    }

    public int o1() {
        return this.Q0;
    }

    public int p1() {
        return this.M0;
    }

    public int q1() {
        return this.N0;
    }

    public float r1() {
        return this.L0;
    }

    public void s1(int i10) {
        this.P0.s(i10);
        this.S0 = true;
    }

    public void t1(int i10) {
        if (i10 > -1) {
            this.L0 = -1.0f;
            this.M0 = i10;
            this.N0 = -1;
        }
    }

    public void u1(int i10) {
        if (i10 > -1) {
            this.L0 = -1.0f;
            this.M0 = -1;
            this.N0 = i10;
        }
    }

    public void v1(float f10) {
        if (f10 > -1.0f) {
            this.L0 = f10;
            this.M0 = -1;
            this.N0 = -1;
        }
    }

    public void w1(int i10) {
        if (this.Q0 == i10) {
            return;
        }
        this.Q0 = i10;
        this.X.clear();
        if (this.Q0 == 1) {
            this.P0 = this.O;
        } else {
            this.P0 = this.P;
        }
        this.X.add(this.P0);
        int length = this.W.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.W[i11] = this.P0;
        }
    }
}
