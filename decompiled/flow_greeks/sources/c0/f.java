package c0;

import c0.e;
import d0.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends k {
    public int O0;
    public int S0;
    public int T0;
    public int U0;
    public int V0;
    public d0.b M0 = new d0.b(this);
    public d0.e N0 = new d0.e(this);
    public b.InterfaceC0137b P0 = null;
    public boolean Q0 = false;
    public z.d R0 = new z.d();
    public int W0 = 0;
    public int X0 = 0;
    public c[] Y0 = new c[4];
    public c[] Z0 = new c[4];

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public boolean f3516a1 = false;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f3517b1 = false;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public boolean f3518c1 = false;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f3519d1 = 0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public int f3520e1 = 0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public int f3521f1 = 257;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f3522g1 = false;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f3523h1 = false;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public boolean f3524i1 = false;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public int f3525j1 = 0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public WeakReference f3526k1 = null;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public WeakReference f3527l1 = null;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public WeakReference f3528m1 = null;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public WeakReference f3529n1 = null;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public HashSet f3530o1 = new HashSet();

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public b.a f3531p1 = new b.a();

    public static boolean N1(int i10, e eVar, b.InterfaceC0137b interfaceC0137b, b.a aVar, int i11) {
        int i12;
        int i13;
        if (interfaceC0137b == null) {
            return false;
        }
        if (eVar.T() == 8 || (eVar instanceof g) || (eVar instanceof a)) {
            aVar.f7407e = 0;
            aVar.f7408f = 0;
            return false;
        }
        aVar.f7403a = eVar.y();
        aVar.f7404b = eVar.R();
        aVar.f7405c = eVar.U();
        aVar.f7406d = eVar.v();
        aVar.f7411i = false;
        aVar.f7412j = i11;
        e.b bVar = aVar.f7403a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z10 = bVar == bVar2;
        boolean z11 = aVar.f7404b == bVar2;
        boolean z12 = z10 && eVar.f3464d0 > 0.0f;
        boolean z13 = z11 && eVar.f3464d0 > 0.0f;
        if (z10 && eVar.Y(0) && eVar.f3501w == 0 && !z12) {
            aVar.f7403a = e.b.WRAP_CONTENT;
            if (z11 && eVar.f3503x == 0) {
                aVar.f7403a = e.b.FIXED;
            }
            z10 = false;
        }
        if (z11 && eVar.Y(1) && eVar.f3503x == 0 && !z13) {
            aVar.f7404b = e.b.WRAP_CONTENT;
            if (z10 && eVar.f3501w == 0) {
                aVar.f7404b = e.b.FIXED;
            }
            z11 = false;
        }
        if (eVar.l0()) {
            aVar.f7403a = e.b.FIXED;
            z10 = false;
        }
        if (eVar.m0()) {
            aVar.f7404b = e.b.FIXED;
            z11 = false;
        }
        if (z12) {
            if (eVar.f3505y[0] == 4) {
                aVar.f7403a = e.b.FIXED;
            } else if (!z11) {
                e.b bVar3 = aVar.f7404b;
                e.b bVar4 = e.b.FIXED;
                if (bVar3 == bVar4) {
                    i13 = aVar.f7406d;
                } else {
                    aVar.f7403a = e.b.WRAP_CONTENT;
                    interfaceC0137b.b(eVar, aVar);
                    i13 = aVar.f7408f;
                }
                aVar.f7403a = bVar4;
                aVar.f7405c = (int) (eVar.t() * i13);
            }
        }
        if (z13) {
            if (eVar.f3505y[1] == 4) {
                aVar.f7404b = e.b.FIXED;
            } else if (!z10) {
                e.b bVar5 = aVar.f7403a;
                e.b bVar6 = e.b.FIXED;
                if (bVar5 == bVar6) {
                    i12 = aVar.f7405c;
                } else {
                    aVar.f7404b = e.b.WRAP_CONTENT;
                    interfaceC0137b.b(eVar, aVar);
                    i12 = aVar.f7407e;
                }
                aVar.f7404b = bVar6;
                if (eVar.u() == -1) {
                    aVar.f7406d = (int) (i12 / eVar.t());
                } else {
                    aVar.f7406d = (int) (eVar.t() * i12);
                }
            }
        }
        interfaceC0137b.b(eVar, aVar);
        eVar.g1(aVar.f7407e);
        eVar.I0(aVar.f7408f);
        eVar.H0(aVar.f7410h);
        eVar.x0(aVar.f7409g);
        aVar.f7412j = b.a.f7400k;
        return aVar.f7411i;
    }

    public void A1(d dVar) {
        WeakReference weakReference = this.f3526k1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f3526k1.get()).d()) {
            this.f3526k1 = new WeakReference(dVar);
        }
    }

    public boolean B1(boolean z10) {
        return this.N0.f(z10);
    }

    public boolean C1(boolean z10) {
        return this.N0.g(z10);
    }

    public boolean D1(boolean z10, int i10) {
        return this.N0.h(z10, i10);
    }

    public b.InterfaceC0137b E1() {
        return this.P0;
    }

    public int F1() {
        return this.f3521f1;
    }

    public z.d G1() {
        return this.R0;
    }

    public void H1() {
        this.N0.j();
    }

    public void I1() {
        this.N0.k();
    }

    public boolean J1() {
        return this.f3524i1;
    }

    public boolean K1() {
        return this.Q0;
    }

    public boolean L1() {
        return this.f3523h1;
    }

    @Override // c0.e
    public void M(StringBuilder sb2) {
        sb2.append(this.f3485o + ":{\n");
        sb2.append("  actualWidth:" + this.f3460b0);
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.f3462c0);
        sb2.append("\n");
        Iterator it = n1().iterator();
        while (it.hasNext()) {
            ((e) it.next()).M(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }

    public long M1(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.S0 = i17;
        this.T0 = i18;
        return this.M0.d(this, i10, i17, i18, i11, i12, i13, i14, i15, i16);
    }

    public boolean O1(int i10) {
        return (this.f3521f1 & i10) == i10;
    }

    public final void P1() {
        this.W0 = 0;
        this.X0 = 0;
    }

    public void Q1(b.InterfaceC0137b interfaceC0137b) {
        this.P0 = interfaceC0137b;
        this.N0.n(interfaceC0137b);
    }

    public void R1(int i10) {
        this.f3521f1 = i10;
        z.d.f25463r = O1(512);
    }

    public void S1(int i10) {
        this.O0 = i10;
    }

    public void T1(boolean z10) {
        this.Q0 = z10;
    }

    public boolean U1(z.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zO1 = O1(64);
        m1(dVar, zO1);
        int size = this.L0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = (e) this.L0.get(i10);
            eVar.m1(dVar, zO1);
            if (eVar.a0()) {
                z10 = true;
            }
        }
        return z10;
    }

    public void V1() {
        this.M0.e(this);
    }

    @Override // c0.e
    public void l1(boolean z10, boolean z11) {
        super.l1(z10, z11);
        int size = this.L0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e) this.L0.get(i10)).l1(z10, z11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0325 A[PHI: r13 r19
      0x0325: PHI (r13v9 ??) = (r13v8 ??), (r13v11 ??), (r13v11 ??), (r13v11 ??) binds: [B:148:0x02e1, B:157:0x030a, B:158:0x030c, B:160:0x0312] A[DONT_GENERATE, DONT_INLINE]
      0x0325: PHI (r19v4 ??) = (r19v3 ??), (r19v6 ??), (r19v6 ??), (r19v6 ??) binds: [B:148:0x02e1, B:157:0x030a, B:158:0x030c, B:160:0x0312] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x032c  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v11 */
    /* JADX WARN: Type inference failed for: r19v12 */
    /* JADX WARN: Type inference failed for: r19v13 */
    /* JADX WARN: Type inference failed for: r19v14 */
    /* JADX WARN: Type inference failed for: r19v15 */
    /* JADX WARN: Type inference failed for: r19v17 */
    /* JADX WARN: Type inference failed for: r19v18 */
    /* JADX WARN: Type inference failed for: r19v19 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v20 */
    /* JADX WARN: Type inference failed for: r19v21 */
    /* JADX WARN: Type inference failed for: r19v22 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r19v8 */
    /* JADX WARN: Type inference failed for: r19v9 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [boolean] */
    @Override // c0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o1() {
        /*
            Method dump skipped, instruction units count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.f.o1():void");
    }

    @Override // c0.k, c0.e
    public void r0() {
        this.R0.D();
        this.S0 = 0;
        this.U0 = 0;
        this.T0 = 0;
        this.V0 = 0;
        this.f3522g1 = false;
        super.r0();
    }

    public void r1(e eVar, int i10) {
        if (i10 == 0) {
            t1(eVar);
        } else if (i10 == 1) {
            y1(eVar);
        }
    }

    public boolean s1(z.d dVar) {
        f fVar;
        z.d dVar2;
        boolean zO1 = O1(64);
        g(dVar, zO1);
        int size = this.L0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = (e) this.L0.get(i10);
            eVar.P0(0, false);
            eVar.P0(1, false);
            if (eVar instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                e eVar2 = (e) this.L0.get(i11);
                if (eVar2 instanceof a) {
                    ((a) eVar2).u1();
                }
            }
        }
        this.f3530o1.clear();
        for (int i12 = 0; i12 < size; i12++) {
            e eVar3 = (e) this.L0.get(i12);
            if (eVar3.f()) {
                eVar3.g(dVar, zO1);
            }
        }
        while (this.f3530o1.size() > 0) {
            int size2 = this.f3530o1.size();
            Iterator it = this.f3530o1.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.b.a((e) it.next());
                throw null;
            }
            if (size2 == this.f3530o1.size()) {
                Iterator it2 = this.f3530o1.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).g(dVar, zO1);
                }
                this.f3530o1.clear();
            }
        }
        if (z.d.f25463r) {
            HashSet<e> hashSet = new HashSet();
            for (int i13 = 0; i13 < size; i13++) {
                e eVar4 = (e) this.L0.get(i13);
                if (!eVar4.f()) {
                    hashSet.add(eVar4);
                }
            }
            fVar = this;
            dVar2 = dVar;
            fVar.e(this, dVar2, hashSet, y() == e.b.WRAP_CONTENT ? 0 : 1, false);
            for (e eVar5 : hashSet) {
                j.a(this, dVar2, eVar5);
                eVar5.g(dVar2, zO1);
            }
        } else {
            fVar = this;
            dVar2 = dVar;
            for (int i14 = 0; i14 < size; i14++) {
                e eVar6 = (e) fVar.L0.get(i14);
                if (eVar6 instanceof f) {
                    e.b[] bVarArr = eVar6.Z;
                    e.b bVar = bVarArr[0];
                    e.b bVar2 = bVarArr[1];
                    e.b bVar3 = e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        eVar6.M0(e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.c1(e.b.FIXED);
                    }
                    eVar6.g(dVar2, zO1);
                    if (bVar == bVar3) {
                        eVar6.M0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.c1(bVar2);
                    }
                } else {
                    j.a(this, dVar2, eVar6);
                    if (!eVar6.f()) {
                        eVar6.g(dVar2, zO1);
                    }
                }
            }
        }
        if (fVar.W0 > 0) {
            b.b(this, dVar2, null, 0);
        }
        if (fVar.X0 > 0) {
            b.b(this, dVar2, null, 1);
        }
        return true;
    }

    public final void t1(e eVar) {
        int i10 = this.W0 + 1;
        c[] cVarArr = this.Z0;
        if (i10 >= cVarArr.length) {
            this.Z0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.Z0[this.W0] = new c(eVar, 0, K1());
        this.W0++;
    }

    public void u1(d dVar) {
        WeakReference weakReference = this.f3529n1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f3529n1.get()).d()) {
            this.f3529n1 = new WeakReference(dVar);
        }
    }

    public void v1(d dVar) {
        WeakReference weakReference = this.f3527l1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f3527l1.get()).d()) {
            this.f3527l1 = new WeakReference(dVar);
        }
    }

    public final void w1(d dVar, z.i iVar) {
        this.R0.h(iVar, this.R0.q(dVar), 0, 5);
    }

    public final void x1(d dVar, z.i iVar) {
        this.R0.h(this.R0.q(dVar), iVar, 0, 5);
    }

    public final void y1(e eVar) {
        int i10 = this.X0 + 1;
        c[] cVarArr = this.Y0;
        if (i10 >= cVarArr.length) {
            this.Y0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.Y0[this.X0] = new c(eVar, 1, K1());
        this.X0++;
    }

    public void z1(d dVar) {
        WeakReference weakReference = this.f3528m1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f3528m1.get()).d()) {
            this.f3528m1 = new WeakReference(dVar);
        }
    }
}
