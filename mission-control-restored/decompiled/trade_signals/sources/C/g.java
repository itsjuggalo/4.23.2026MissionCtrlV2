package C;

import C.d;
import C.e;

/* JADX INFO: loaded from: classes.dex */
public class g extends e {

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public float f412L0 = -1.0f;

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    public int f413M0 = -1;

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    public int f414N0 = -1;

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    public boolean f415O0 = true;

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    public d f416P0 = this.f312P;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    public int f417Q0 = 0;

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    public int f418R0 = 0;

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    public boolean f419S0;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420a;

        static {
            int[] iArr = new int[d.b.values().length];
            f420a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f420a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f420a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f420a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f420a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f420a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f420a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f420a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f420a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public g() {
        this.f320X.clear();
        this.f320X.add(this.f416P0);
        int length = this.f319W.length;
        for (int i8 = 0; i8 < length; i8++) {
            this.f319W[i8] = this.f416P0;
        }
    }

    @Override // C.e
    public void g(z.d dVar, boolean z7) {
        f fVar = (f) I();
        if (fVar == null) {
            return;
        }
        d dVarM = fVar.m(d.b.LEFT);
        d dVarM2 = fVar.m(d.b.RIGHT);
        e eVar = this.f324a0;
        boolean z8 = eVar != null && eVar.f322Z[0] == e.b.WRAP_CONTENT;
        if (this.f417Q0 == 0) {
            dVarM = fVar.m(d.b.TOP);
            dVarM2 = fVar.m(d.b.BOTTOM);
            e eVar2 = this.f324a0;
            z8 = eVar2 != null && eVar2.f322Z[1] == e.b.WRAP_CONTENT;
        }
        if (this.f419S0 && this.f416P0.m()) {
            z.i iVarQ = dVar.q(this.f416P0);
            dVar.f(iVarQ, this.f416P0.d());
            if (this.f413M0 != -1) {
                if (z8) {
                    dVar.h(dVar.q(dVarM2), iVarQ, 0, 5);
                }
            } else if (this.f414N0 != -1 && z8) {
                z.i iVarQ2 = dVar.q(dVarM2);
                dVar.h(iVarQ, dVar.q(dVarM), 0, 5);
                dVar.h(iVarQ2, iVarQ, 0, 5);
            }
            this.f419S0 = false;
            return;
        }
        if (this.f413M0 != -1) {
            z.i iVarQ3 = dVar.q(this.f416P0);
            dVar.e(iVarQ3, dVar.q(dVarM), this.f413M0, 8);
            if (z8) {
                dVar.h(dVar.q(dVarM2), iVarQ3, 0, 5);
                return;
            }
            return;
        }
        if (this.f414N0 == -1) {
            if (this.f412L0 != -1.0f) {
                dVar.d(z.d.s(dVar, dVar.q(this.f416P0), dVar.q(dVarM2), this.f412L0));
                return;
            }
            return;
        }
        z.i iVarQ4 = dVar.q(this.f416P0);
        z.i iVarQ5 = dVar.q(dVarM2);
        dVar.e(iVarQ4, iVarQ5, -this.f414N0, 8);
        if (z8) {
            dVar.h(iVarQ4, dVar.q(dVarM), 0, 5);
            dVar.h(iVarQ5, iVarQ4, 0, 5);
        }
    }

    @Override // C.e
    public boolean h() {
        return true;
    }

    @Override // C.e
    public boolean l0() {
        return this.f419S0;
    }

    @Override // C.e
    public d m(d.b bVar) {
        int i8 = a.f420a[bVar.ordinal()];
        if (i8 == 1 || i8 == 2) {
            if (this.f417Q0 == 1) {
                return this.f416P0;
            }
            return null;
        }
        if ((i8 == 3 || i8 == 4) && this.f417Q0 == 0) {
            return this.f416P0;
        }
        return null;
    }

    @Override // C.e
    public boolean m0() {
        return this.f419S0;
    }

    @Override // C.e
    public void m1(z.d dVar, boolean z7) {
        if (I() == null) {
            return;
        }
        int iX = dVar.x(this.f416P0);
        if (this.f417Q0 == 1) {
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
        return this.f416P0;
    }

    public int o1() {
        return this.f417Q0;
    }

    public int p1() {
        return this.f413M0;
    }

    public int q1() {
        return this.f414N0;
    }

    public float r1() {
        return this.f412L0;
    }

    public void s1(int i8) {
        this.f416P0.s(i8);
        this.f419S0 = true;
    }

    public void t1(int i8) {
        if (i8 > -1) {
            this.f412L0 = -1.0f;
            this.f413M0 = i8;
            this.f414N0 = -1;
        }
    }

    public void u1(int i8) {
        if (i8 > -1) {
            this.f412L0 = -1.0f;
            this.f413M0 = -1;
            this.f414N0 = i8;
        }
    }

    public void v1(float f8) {
        if (f8 > -1.0f) {
            this.f412L0 = f8;
            this.f413M0 = -1;
            this.f414N0 = -1;
        }
    }

    public void w1(int i8) {
        if (this.f417Q0 == i8) {
            return;
        }
        this.f417Q0 = i8;
        this.f320X.clear();
        this.f416P0 = this.f417Q0 == 1 ? this.f311O : this.f312P;
        this.f320X.add(this.f416P0);
        int length = this.f319W.length;
        for (int i9 = 0; i9 < length; i9++) {
            this.f319W[i9] = this.f416P0;
        }
    }
}
