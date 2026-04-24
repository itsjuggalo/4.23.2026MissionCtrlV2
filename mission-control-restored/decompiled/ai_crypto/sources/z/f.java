package z;

import A.b;
import java.util.Arrays;
import z.e;

/* JADX INFO: loaded from: classes.dex */
public class f extends k {

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public int f25913C0;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public int f25914D0;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public int f25915E0;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public int f25916F0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public A.b f25931x0 = new A.b(this);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public A.e f25932y0 = new A.e(this);

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public b.InterfaceC0000b f25933z0 = null;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public boolean f25911A0 = false;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public y.d f25912B0 = new y.d();

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    public int f25917G0 = 0;

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    public int f25918H0 = 0;

    /* JADX INFO: renamed from: I0, reason: collision with root package name */
    public c[] f25919I0 = new c[4];

    /* JADX INFO: renamed from: J0, reason: collision with root package name */
    public c[] f25920J0 = new c[4];

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    public boolean f25921K0 = false;

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public boolean f25922L0 = false;

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    public boolean f25923M0 = false;

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    public int f25924N0 = 0;

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    public int f25925O0 = 0;

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    public int f25926P0 = 263;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    public boolean f25927Q0 = false;

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    public boolean f25928R0 = false;

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    public boolean f25929S0 = false;

    /* JADX INFO: renamed from: T0, reason: collision with root package name */
    public int f25930T0 = 0;

    @Override // z.e
    public void E0(boolean z7, boolean z8) {
        super.E0(z7, z8);
        int size = this.f25944w0.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((e) this.f25944w0.get(i7)).E0(z7, z8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c8 A[PHI: r0 r5
      0x01c8: PHI (r0v26 ??) = (r0v25 ??), (r0v28 ??), (r0v28 ??), (r0v28 ??) binds: [B:70:0x018d, B:78:0x01b0, B:79:0x01b2, B:81:0x01b8] A[DONT_GENERATE, DONT_INLINE]
      0x01c8: PHI (r5v11 boolean) = (r5v10 boolean), (r5v13 boolean), (r5v13 boolean), (r5v13 boolean) binds: [B:70:0x018d, B:78:0x01b0, B:79:0x01b2, B:81:0x01b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean] */
    @Override // z.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G0() {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z.f.G0():void");
    }

    public void J0(e eVar, int i7) {
        if (i7 == 0) {
            L0(eVar);
        } else if (i7 == 1) {
            M0(eVar);
        }
    }

    public boolean K0(y.d dVar) {
        f(dVar);
        int size = this.f25944w0.size();
        boolean z7 = false;
        for (int i7 = 0; i7 < size; i7++) {
            e eVar = (e) this.f25944w0.get(i7);
            eVar.l0(0, false);
            eVar.l0(1, false);
            if (eVar instanceof C2850a) {
                z7 = true;
            }
        }
        if (z7) {
            for (int i8 = 0; i8 < size; i8++) {
                e eVar2 = (e) this.f25944w0.get(i8);
                if (eVar2 instanceof C2850a) {
                    ((C2850a) eVar2).J0();
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            e eVar3 = (e) this.f25944w0.get(i9);
            if (eVar3.e()) {
                eVar3.f(dVar);
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            e eVar4 = (e) this.f25944w0.get(i10);
            if (eVar4 instanceof f) {
                e.b[] bVarArr = eVar4.f25843M;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                e.b bVar3 = e.b.WRAP_CONTENT;
                if (bVar == bVar3) {
                    eVar4.i0(e.b.FIXED);
                }
                if (bVar2 == bVar3) {
                    eVar4.w0(e.b.FIXED);
                }
                eVar4.f(dVar);
                if (bVar == bVar3) {
                    eVar4.i0(bVar);
                }
                if (bVar2 == bVar3) {
                    eVar4.w0(bVar2);
                }
            } else {
                j.a(this, dVar, eVar4);
                if (!eVar4.e()) {
                    eVar4.f(dVar);
                }
            }
        }
        if (this.f25917G0 > 0) {
            b.a(this, dVar, 0);
        }
        if (this.f25918H0 > 0) {
            b.a(this, dVar, 1);
        }
        return true;
    }

    public final void L0(e eVar) {
        int i7 = this.f25917G0 + 1;
        c[] cVarArr = this.f25920J0;
        if (i7 >= cVarArr.length) {
            this.f25920J0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f25920J0[this.f25917G0] = new c(eVar, 0, V0());
        this.f25917G0++;
    }

    public final void M0(e eVar) {
        int i7 = this.f25918H0 + 1;
        c[] cVarArr = this.f25919I0;
        if (i7 >= cVarArr.length) {
            this.f25919I0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f25919I0[this.f25918H0] = new c(eVar, 1, V0());
        this.f25918H0++;
    }

    public boolean N0(boolean z7) {
        return this.f25932y0.f(z7);
    }

    public boolean O0(boolean z7) {
        return this.f25932y0.g(z7);
    }

    public boolean P0(boolean z7, int i7) {
        return this.f25932y0.h(z7, i7);
    }

    public b.InterfaceC0000b Q0() {
        return this.f25933z0;
    }

    public int R0() {
        return this.f25926P0;
    }

    public void S0() {
        this.f25932y0.j();
    }

    public void T0() {
        this.f25932y0.k();
    }

    public boolean U0() {
        return this.f25929S0;
    }

    public boolean V0() {
        return this.f25911A0;
    }

    @Override // z.k, z.e
    public void W() {
        this.f25912B0.D();
        this.f25913C0 = 0;
        this.f25915E0 = 0;
        this.f25914D0 = 0;
        this.f25916F0 = 0;
        this.f25927Q0 = false;
        super.W();
    }

    public boolean W0() {
        return this.f25928R0;
    }

    public long X0(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f25913C0 = i14;
        this.f25914D0 = i15;
        return this.f25931x0.d(this, i7, i14, i15, i8, i9, i10, i11, i12, i13);
    }

    public boolean Y0(int i7) {
        return (this.f25926P0 & i7) == i7;
    }

    public final void Z0() {
        this.f25917G0 = 0;
        this.f25918H0 = 0;
    }

    public void a1(b.InterfaceC0000b interfaceC0000b) {
        this.f25933z0 = interfaceC0000b;
        this.f25932y0.n(interfaceC0000b);
    }

    public void b1(int i7) {
        this.f25926P0 = i7;
        y.d.f25386r = j.b(i7, 256);
    }

    public void c1(boolean z7) {
        this.f25911A0 = z7;
    }

    public void d1(y.d dVar, boolean[] zArr) {
        zArr[2] = false;
        F0(dVar);
        int size = this.f25944w0.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((e) this.f25944w0.get(i7)).F0(dVar);
        }
    }

    public void e1() {
        this.f25931x0.e(this);
    }
}
