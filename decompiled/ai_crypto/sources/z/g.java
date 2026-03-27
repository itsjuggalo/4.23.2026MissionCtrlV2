package z;

import k4.C2105D;
import z.d;
import z.e;

/* JADX INFO: loaded from: classes.dex */
public class g extends e {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public float f25936w0 = -1.0f;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f25937x0 = -1;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f25938y0 = -1;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public d f25939z0 = this.f25833C;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public int f25934A0 = 0;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public int f25935B0 = 0;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25940a;

        static {
            int[] iArr = new int[d.b.values().length];
            f25940a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25940a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25940a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25940a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25940a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25940a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25940a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25940a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25940a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public g() {
        this.f25841K.clear();
        this.f25841K.add(this.f25939z0);
        int length = this.f25840J.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.f25840J[i7] = this.f25939z0;
        }
    }

    @Override // z.e
    public void F0(y.d dVar) {
        if (E() == null) {
            return;
        }
        int iX = dVar.x(this.f25939z0);
        if (this.f25934A0 == 1) {
            B0(iX);
            C0(0);
            e0(E().t());
            A0(0);
            return;
        }
        B0(0);
        C0(iX);
        A0(E().N());
        e0(0);
    }

    public int G0() {
        return this.f25934A0;
    }

    public int H0() {
        return this.f25937x0;
    }

    public int I0() {
        return this.f25938y0;
    }

    public float J0() {
        return this.f25936w0;
    }

    public void K0(int i7) {
        if (i7 > -1) {
            this.f25936w0 = -1.0f;
            this.f25937x0 = i7;
            this.f25938y0 = -1;
        }
    }

    public void L0(int i7) {
        if (i7 > -1) {
            this.f25936w0 = -1.0f;
            this.f25937x0 = -1;
            this.f25938y0 = i7;
        }
    }

    public void M0(float f7) {
        if (f7 > -1.0f) {
            this.f25936w0 = f7;
            this.f25937x0 = -1;
            this.f25938y0 = -1;
        }
    }

    public void N0(int i7) {
        if (this.f25934A0 == i7) {
            return;
        }
        this.f25934A0 = i7;
        this.f25841K.clear();
        if (this.f25934A0 == 1) {
            this.f25939z0 = this.f25832B;
        } else {
            this.f25939z0 = this.f25833C;
        }
        this.f25841K.add(this.f25939z0);
        int length = this.f25840J.length;
        for (int i8 = 0; i8 < length; i8++) {
            this.f25840J[i8] = this.f25939z0;
        }
    }

    @Override // z.e
    public void f(y.d dVar) {
        f fVar = (f) E();
        if (fVar == null) {
            return;
        }
        d dVarK = fVar.k(d.b.LEFT);
        d dVarK2 = fVar.k(d.b.RIGHT);
        e eVar = this.f25844N;
        boolean z7 = eVar != null && eVar.f25843M[0] == e.b.WRAP_CONTENT;
        if (this.f25934A0 == 0) {
            dVarK = fVar.k(d.b.TOP);
            dVarK2 = fVar.k(d.b.BOTTOM);
            e eVar2 = this.f25844N;
            z7 = eVar2 != null && eVar2.f25843M[1] == e.b.WRAP_CONTENT;
        }
        if (this.f25937x0 != -1) {
            y.i iVarQ = dVar.q(this.f25939z0);
            dVar.e(iVarQ, dVar.q(dVarK), this.f25937x0, 8);
            if (z7) {
                dVar.h(dVar.q(dVarK2), iVarQ, 0, 5);
                return;
            }
            return;
        }
        if (this.f25938y0 == -1) {
            if (this.f25936w0 != -1.0f) {
                dVar.d(y.d.s(dVar, dVar.q(this.f25939z0), dVar.q(dVarK2), this.f25936w0));
                return;
            }
            return;
        }
        y.i iVarQ2 = dVar.q(this.f25939z0);
        y.i iVarQ3 = dVar.q(dVarK2);
        dVar.e(iVarQ2, iVarQ3, -this.f25938y0, 8);
        if (z7) {
            dVar.h(iVarQ2, dVar.q(dVarK), 0, 5);
            dVar.h(iVarQ3, iVarQ2, 0, 5);
        }
    }

    @Override // z.e
    public boolean g() {
        return true;
    }

    @Override // z.e
    public d k(d.b bVar) {
        switch (a.f25940a[bVar.ordinal()]) {
            case 1:
            case 2:
                if (this.f25934A0 == 1) {
                    return this.f25939z0;
                }
                break;
            case 3:
            case 4:
                if (this.f25934A0 == 0) {
                    return this.f25939z0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return null;
        }
        throw new AssertionError(bVar.name());
    }
}
