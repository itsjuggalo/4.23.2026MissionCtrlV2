package z;

import z.e;

/* JADX INFO: renamed from: z.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2850a extends i {

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f25788y0 = 0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f25789z0 = true;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public int f25787A0 = 0;

    public boolean G0() {
        return this.f25789z0;
    }

    public int H0() {
        return this.f25788y0;
    }

    public int I0() {
        return this.f25787A0;
    }

    public void J0() {
        for (int i7 = 0; i7 < this.f25942x0; i7++) {
            e eVar = this.f25941w0[i7];
            int i8 = this.f25788y0;
            if (i8 == 0 || i8 == 1) {
                eVar.l0(0, true);
            } else if (i8 == 2 || i8 == 3) {
                eVar.l0(1, true);
            }
        }
    }

    public void K0(boolean z7) {
        this.f25789z0 = z7;
    }

    public void L0(int i7) {
        this.f25788y0 = i7;
    }

    public void M0(int i7) {
        this.f25787A0 = i7;
    }

    @Override // z.e
    public void f(y.d dVar) {
        d[] dVarArr;
        boolean z7;
        int i7;
        int i8;
        int i9;
        d[] dVarArr2 = this.f25840J;
        dVarArr2[0] = this.f25832B;
        dVarArr2[2] = this.f25833C;
        dVarArr2[1] = this.f25834D;
        dVarArr2[3] = this.f25835E;
        int i10 = 0;
        while (true) {
            dVarArr = this.f25840J;
            if (i10 >= dVarArr.length) {
                break;
            }
            d dVar2 = dVarArr[i10];
            dVar2.f25818g = dVar.q(dVar2);
            i10++;
        }
        int i11 = this.f25788y0;
        if (i11 < 0 || i11 >= 4) {
            return;
        }
        d dVar3 = dVarArr[i11];
        for (int i12 = 0; i12 < this.f25942x0; i12++) {
            e eVar = this.f25941w0[i12];
            if ((this.f25789z0 || eVar.g()) && ((((i8 = this.f25788y0) == 0 || i8 == 1) && eVar.w() == e.b.MATCH_CONSTRAINT && eVar.f25832B.f25815d != null && eVar.f25834D.f25815d != null) || (((i9 = this.f25788y0) == 2 || i9 == 3) && eVar.K() == e.b.MATCH_CONSTRAINT && eVar.f25833C.f25815d != null && eVar.f25835E.f25815d != null))) {
                z7 = true;
                break;
            }
        }
        z7 = false;
        boolean z8 = this.f25832B.h() || this.f25834D.h();
        boolean z9 = this.f25833C.h() || this.f25835E.h();
        int i13 = !(!z7 && (((i7 = this.f25788y0) == 0 && z8) || ((i7 == 2 && z9) || ((i7 == 1 && z8) || (i7 == 3 && z9))))) ? 4 : 5;
        for (int i14 = 0; i14 < this.f25942x0; i14++) {
            e eVar2 = this.f25941w0[i14];
            if (this.f25789z0 || eVar2.g()) {
                y.i iVarQ = dVar.q(eVar2.f25840J[this.f25788y0]);
                d[] dVarArr3 = eVar2.f25840J;
                int i15 = this.f25788y0;
                d dVar4 = dVarArr3[i15];
                dVar4.f25818g = iVarQ;
                d dVar5 = dVar4.f25815d;
                int i16 = (dVar5 == null || dVar5.f25813b != this) ? 0 : dVar4.f25816e;
                if (i15 == 0 || i15 == 2) {
                    dVar.i(dVar3.f25818g, iVarQ, this.f25787A0 - i16, z7);
                } else {
                    dVar.g(dVar3.f25818g, iVarQ, this.f25787A0 + i16, z7);
                }
                dVar.e(dVar3.f25818g, iVarQ, this.f25787A0 + i16, i13);
            }
        }
        int i17 = this.f25788y0;
        if (i17 == 0) {
            dVar.e(this.f25834D.f25818g, this.f25832B.f25818g, 0, 8);
            dVar.e(this.f25832B.f25818g, this.f25844N.f25834D.f25818g, 0, 4);
            dVar.e(this.f25832B.f25818g, this.f25844N.f25832B.f25818g, 0, 0);
            return;
        }
        if (i17 == 1) {
            dVar.e(this.f25832B.f25818g, this.f25834D.f25818g, 0, 8);
            dVar.e(this.f25832B.f25818g, this.f25844N.f25832B.f25818g, 0, 4);
            dVar.e(this.f25832B.f25818g, this.f25844N.f25834D.f25818g, 0, 0);
        } else if (i17 == 2) {
            dVar.e(this.f25835E.f25818g, this.f25833C.f25818g, 0, 8);
            dVar.e(this.f25833C.f25818g, this.f25844N.f25835E.f25818g, 0, 4);
            dVar.e(this.f25833C.f25818g, this.f25844N.f25833C.f25818g, 0, 0);
        } else if (i17 == 3) {
            dVar.e(this.f25833C.f25818g, this.f25835E.f25818g, 0, 8);
            dVar.e(this.f25833C.f25818g, this.f25844N.f25833C.f25818g, 0, 4);
            dVar.e(this.f25833C.f25818g, this.f25844N.f25835E.f25818g, 0, 0);
        }
    }

    @Override // z.e
    public boolean g() {
        return true;
    }

    @Override // z.e
    public String toString() {
        String str = "[Barrier] " + p() + " {";
        for (int i7 = 0; i7 < this.f25942x0; i7++) {
            e eVar = this.f25941w0[i7];
            if (i7 > 0) {
                str = str + ", ";
            }
            str = str + eVar.p();
        }
        return str + "}";
    }
}
