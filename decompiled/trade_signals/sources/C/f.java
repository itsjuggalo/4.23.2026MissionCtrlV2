package C;

import C.e;
import D.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class f extends k {

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    public int f384O0;

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    public int f388S0;

    /* JADX INFO: renamed from: T0, reason: collision with root package name */
    public int f389T0;

    /* JADX INFO: renamed from: U0, reason: collision with root package name */
    public int f390U0;

    /* JADX INFO: renamed from: V0, reason: collision with root package name */
    public int f391V0;

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    public D.b f382M0 = new D.b(this);

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    public D.e f383N0 = new D.e(this);

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    public b.InterfaceC0012b f385P0 = null;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    public boolean f386Q0 = false;

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    public z.d f387R0 = new z.d();

    /* JADX INFO: renamed from: W0, reason: collision with root package name */
    public int f392W0 = 0;

    /* JADX INFO: renamed from: X0, reason: collision with root package name */
    public int f393X0 = 0;

    /* JADX INFO: renamed from: Y0, reason: collision with root package name */
    public c[] f394Y0 = new c[4];

    /* JADX INFO: renamed from: Z0, reason: collision with root package name */
    public c[] f395Z0 = new c[4];

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public boolean f396a1 = false;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f397b1 = false;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public boolean f398c1 = false;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int f399d1 = 0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public int f400e1 = 0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public int f401f1 = 257;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f402g1 = false;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f403h1 = false;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public boolean f404i1 = false;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public int f405j1 = 0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public WeakReference f406k1 = null;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public WeakReference f407l1 = null;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public WeakReference f408m1 = null;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public WeakReference f409n1 = null;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public HashSet f410o1 = new HashSet();

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public b.a f411p1 = new b.a();

    public static boolean N1(int i8, e eVar, b.InterfaceC0012b interfaceC0012b, b.a aVar, int i9) {
        int i10;
        int i11;
        if (interfaceC0012b == null) {
            return false;
        }
        if (eVar.T() == 8 || (eVar instanceof g) || (eVar instanceof a)) {
            aVar.f653e = 0;
            aVar.f654f = 0;
            return false;
        }
        aVar.f649a = eVar.y();
        aVar.f650b = eVar.R();
        aVar.f651c = eVar.U();
        aVar.f652d = eVar.v();
        aVar.f657i = false;
        aVar.f658j = i9;
        e.b bVar = aVar.f649a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z7 = bVar == bVar2;
        boolean z8 = aVar.f650b == bVar2;
        boolean z9 = z7 && eVar.f330d0 > 0.0f;
        boolean z10 = z8 && eVar.f330d0 > 0.0f;
        if (z7 && eVar.Y(0) && eVar.f367w == 0 && !z9) {
            aVar.f649a = e.b.WRAP_CONTENT;
            if (z8 && eVar.f369x == 0) {
                aVar.f649a = e.b.FIXED;
            }
            z7 = false;
        }
        if (z8 && eVar.Y(1) && eVar.f369x == 0 && !z10) {
            aVar.f650b = e.b.WRAP_CONTENT;
            if (z7 && eVar.f367w == 0) {
                aVar.f650b = e.b.FIXED;
            }
            z8 = false;
        }
        if (eVar.l0()) {
            aVar.f649a = e.b.FIXED;
            z7 = false;
        }
        if (eVar.m0()) {
            aVar.f650b = e.b.FIXED;
            z8 = false;
        }
        if (z9) {
            if (eVar.f371y[0] == 4) {
                aVar.f649a = e.b.FIXED;
            } else if (!z8) {
                e.b bVar3 = aVar.f650b;
                e.b bVar4 = e.b.FIXED;
                if (bVar3 == bVar4) {
                    i11 = aVar.f652d;
                } else {
                    aVar.f649a = e.b.WRAP_CONTENT;
                    interfaceC0012b.b(eVar, aVar);
                    i11 = aVar.f654f;
                }
                aVar.f649a = bVar4;
                aVar.f651c = (int) (eVar.t() * i11);
            }
        }
        if (z10) {
            if (eVar.f371y[1] == 4) {
                aVar.f650b = e.b.FIXED;
            } else if (!z7) {
                e.b bVar5 = aVar.f649a;
                e.b bVar6 = e.b.FIXED;
                if (bVar5 == bVar6) {
                    i10 = aVar.f651c;
                } else {
                    aVar.f650b = e.b.WRAP_CONTENT;
                    interfaceC0012b.b(eVar, aVar);
                    i10 = aVar.f653e;
                }
                aVar.f650b = bVar6;
                aVar.f652d = eVar.u() == -1 ? (int) (i10 / eVar.t()) : (int) (eVar.t() * i10);
            }
        }
        interfaceC0012b.b(eVar, aVar);
        eVar.g1(aVar.f653e);
        eVar.I0(aVar.f654f);
        eVar.H0(aVar.f656h);
        eVar.x0(aVar.f655g);
        aVar.f658j = b.a.f646k;
        return aVar.f657i;
    }

    public void A1(d dVar) {
        WeakReference weakReference = this.f406k1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f406k1.get()).d()) {
            this.f406k1 = new WeakReference(dVar);
        }
    }

    public boolean B1(boolean z7) {
        return this.f383N0.f(z7);
    }

    public boolean C1(boolean z7) {
        return this.f383N0.g(z7);
    }

    public boolean D1(boolean z7, int i8) {
        return this.f383N0.h(z7, i8);
    }

    public b.InterfaceC0012b E1() {
        return this.f385P0;
    }

    public int F1() {
        return this.f401f1;
    }

    public z.d G1() {
        return this.f387R0;
    }

    public void H1() {
        this.f383N0.j();
    }

    public void I1() {
        this.f383N0.k();
    }

    public boolean J1() {
        return this.f404i1;
    }

    public boolean K1() {
        return this.f386Q0;
    }

    public boolean L1() {
        return this.f403h1;
    }

    @Override // C.e
    public void M(StringBuilder sb) {
        sb.append(this.f351o + ":{\n");
        sb.append("  actualWidth:" + this.f326b0);
        sb.append("\n");
        sb.append("  actualHeight:" + this.f328c0);
        sb.append("\n");
        Iterator it = n1().iterator();
        while (it.hasNext()) {
            ((e) it.next()).M(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public long M1(int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f388S0 = i15;
        this.f389T0 = i16;
        return this.f382M0.d(this, i8, i15, i16, i9, i10, i11, i12, i13, i14);
    }

    public boolean O1(int i8) {
        return (this.f401f1 & i8) == i8;
    }

    public final void P1() {
        this.f392W0 = 0;
        this.f393X0 = 0;
    }

    public void Q1(b.InterfaceC0012b interfaceC0012b) {
        this.f385P0 = interfaceC0012b;
        this.f383N0.n(interfaceC0012b);
    }

    public void R1(int i8) {
        this.f401f1 = i8;
        z.d.f24543r = O1(512);
    }

    public void S1(int i8) {
        this.f384O0 = i8;
    }

    public void T1(boolean z7) {
        this.f386Q0 = z7;
    }

    public boolean U1(z.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zO1 = O1(64);
        m1(dVar, zO1);
        int size = this.f424L0.size();
        boolean z7 = false;
        for (int i8 = 0; i8 < size; i8++) {
            e eVar = (e) this.f424L0.get(i8);
            eVar.m1(dVar, zO1);
            if (eVar.a0()) {
                z7 = true;
            }
        }
        return z7;
    }

    public void V1() {
        this.f382M0.e(this);
    }

    @Override // C.e
    public void l1(boolean z7, boolean z8) {
        super.l1(z7, z8);
        int size = this.f424L0.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((e) this.f424L0.get(i8)).l1(z7, z8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0301 A[PHI: r2 r16
      0x0301: PHI (r2v15 ??) = (r2v14 ??), (r2v19 ??), (r2v19 ??), (r2v19 ??) binds: [B:137:0x02c2, B:145:0x02e7, B:146:0x02e9, B:148:0x02ef] A[DONT_GENERATE, DONT_INLINE]
      0x0301: PHI (r16v4 boolean) = (r16v3 boolean), (r16v5 boolean), (r16v5 boolean), (r16v5 boolean) binds: [B:137:0x02c2, B:145:0x02e7, B:146:0x02e9, B:148:0x02ef] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // C.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o1() {
        /*
            Method dump skipped, instruction units count: 807
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C.f.o1():void");
    }

    @Override // C.k, C.e
    public void r0() {
        this.f387R0.D();
        this.f388S0 = 0;
        this.f390U0 = 0;
        this.f389T0 = 0;
        this.f391V0 = 0;
        this.f402g1 = false;
        super.r0();
    }

    public void r1(e eVar, int i8) {
        if (i8 == 0) {
            t1(eVar);
        } else if (i8 == 1) {
            y1(eVar);
        }
    }

    public boolean s1(z.d dVar) {
        boolean zO1 = O1(64);
        g(dVar, zO1);
        int size = this.f424L0.size();
        boolean z7 = false;
        for (int i8 = 0; i8 < size; i8++) {
            e eVar = (e) this.f424L0.get(i8);
            eVar.P0(0, false);
            eVar.P0(1, false);
            if (eVar instanceof a) {
                z7 = true;
            }
        }
        if (z7) {
            for (int i9 = 0; i9 < size; i9++) {
                e eVar2 = (e) this.f424L0.get(i9);
                if (eVar2 instanceof a) {
                    ((a) eVar2).u1();
                }
            }
        }
        this.f410o1.clear();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar3 = (e) this.f424L0.get(i10);
            if (eVar3.f()) {
                eVar3.g(dVar, zO1);
            }
        }
        while (this.f410o1.size() > 0) {
            int size2 = this.f410o1.size();
            Iterator it = this.f410o1.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.b.a((e) it.next());
                throw null;
            }
            if (size2 == this.f410o1.size()) {
                Iterator it2 = this.f410o1.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).g(dVar, zO1);
                }
                this.f410o1.clear();
            }
        }
        if (z.d.f24543r) {
            HashSet<e> hashSet = new HashSet();
            for (int i11 = 0; i11 < size; i11++) {
                e eVar4 = (e) this.f424L0.get(i11);
                if (!eVar4.f()) {
                    hashSet.add(eVar4);
                }
            }
            e(this, dVar, hashSet, y() == e.b.WRAP_CONTENT ? 0 : 1, false);
            for (e eVar5 : hashSet) {
                j.a(this, dVar, eVar5);
                eVar5.g(dVar, zO1);
            }
        } else {
            for (int i12 = 0; i12 < size; i12++) {
                e eVar6 = (e) this.f424L0.get(i12);
                if (eVar6 instanceof f) {
                    e.b[] bVarArr = eVar6.f322Z;
                    e.b bVar = bVarArr[0];
                    e.b bVar2 = bVarArr[1];
                    e.b bVar3 = e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        eVar6.M0(e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.c1(e.b.FIXED);
                    }
                    eVar6.g(dVar, zO1);
                    if (bVar == bVar3) {
                        eVar6.M0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.c1(bVar2);
                    }
                } else {
                    j.a(this, dVar, eVar6);
                    if (!eVar6.f()) {
                        eVar6.g(dVar, zO1);
                    }
                }
            }
        }
        if (this.f392W0 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.f393X0 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    public final void t1(e eVar) {
        int i8 = this.f392W0 + 1;
        c[] cVarArr = this.f395Z0;
        if (i8 >= cVarArr.length) {
            this.f395Z0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f395Z0[this.f392W0] = new c(eVar, 0, K1());
        this.f392W0++;
    }

    public void u1(d dVar) {
        WeakReference weakReference = this.f409n1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f409n1.get()).d()) {
            this.f409n1 = new WeakReference(dVar);
        }
    }

    public void v1(d dVar) {
        WeakReference weakReference = this.f407l1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f407l1.get()).d()) {
            this.f407l1 = new WeakReference(dVar);
        }
    }

    public final void w1(d dVar, z.i iVar) {
        this.f387R0.h(iVar, this.f387R0.q(dVar), 0, 5);
    }

    public final void x1(d dVar, z.i iVar) {
        this.f387R0.h(this.f387R0.q(dVar), iVar, 0, 5);
    }

    public final void y1(e eVar) {
        int i8 = this.f393X0 + 1;
        c[] cVarArr = this.f394Y0;
        if (i8 >= cVarArr.length) {
            this.f394Y0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f394Y0[this.f393X0] = new c(eVar, 1, K1());
        this.f393X0++;
    }

    public void z1(d dVar) {
        WeakReference weakReference = this.f408m1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f408m1.get()).d()) {
            this.f408m1 = new WeakReference(dVar);
        }
    }
}
