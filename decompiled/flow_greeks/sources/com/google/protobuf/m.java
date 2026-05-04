package com.google.protobuf;

import com.google.protobuf.a2;
import com.google.protobuf.b2;
import com.google.protobuf.n0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f7101a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7102a;

        static {
            int[] iArr = new int[a2.b.values().length];
            f7102a = iArr;
            try {
                iArr[a2.b.f6908j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7102a[a2.b.f6907i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7102a[a2.b.f6905g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7102a[a2.b.f6915q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7102a[a2.b.f6917s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7102a[a2.b.f6913o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7102a[a2.b.f6906h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7102a[a2.b.f6903e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7102a[a2.b.f6916r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7102a[a2.b.f6918t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7102a[a2.b.f6904f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7102a[a2.b.f6909k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public m(l lVar) {
        l lVar2 = (l) c0.b(lVar, "output");
        this.f7101a = lVar2;
        lVar2.f7078a = this;
    }

    public static m P(l lVar) {
        m mVar = lVar.f7078a;
        return mVar != null ? mVar : new m(lVar);
    }

    @Override // com.google.protobuf.b2
    public void A(int i10, float f10) {
        this.f7101a.t0(i10, f10);
    }

    @Override // com.google.protobuf.b2
    public void B(int i10) {
        this.f7101a.R0(i10, 4);
    }

    @Override // com.google.protobuf.b2
    public void C(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.L0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iL = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iL += l.L(((Integer) list.get(i12)).intValue());
        }
        this.f7101a.T0(iL);
        while (i11 < list.size()) {
            this.f7101a.M0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void D(int i10, int i11) {
        this.f7101a.n0(i10, i11);
    }

    @Override // com.google.protobuf.b2
    public void E(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.B0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iZ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZ += l.z(((Long) list.get(i12)).longValue());
        }
        this.f7101a.T0(iZ);
        while (i11 < list.size()) {
            this.f7101a.C0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void F(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.n0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iM = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM += l.m(((Integer) list.get(i12)).intValue());
        }
        this.f7101a.T0(iM);
        while (i11 < list.size()) {
            this.f7101a.o0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void G(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.l0(i10, ((Double) list.get(i11)).doubleValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iK = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iK += l.k(((Double) list.get(i12)).doubleValue());
        }
        this.f7101a.T0(iK);
        while (i11 < list.size()) {
            this.f7101a.m0(((Double) list.get(i11)).doubleValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void H(int i10, int i11) {
        this.f7101a.L0(i10, i11);
    }

    @Override // com.google.protobuf.b2
    public void I(int i10, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f7101a.j0(i10, (i) list.get(i11));
        }
    }

    @Override // com.google.protobuf.b2
    public void J(int i10, List list, m1 m1Var) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            L(i10, list.get(i11), m1Var);
        }
    }

    @Override // com.google.protobuf.b2
    public void K(int i10, List list, m1 m1Var) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            M(i10, list.get(i11), m1Var);
        }
    }

    @Override // com.google.protobuf.b2
    public void L(int i10, Object obj, m1 m1Var) {
        this.f7101a.D0(i10, (u0) obj, m1Var);
    }

    @Override // com.google.protobuf.b2
    public void M(int i10, Object obj, m1 m1Var) {
        this.f7101a.w0(i10, (u0) obj, m1Var);
    }

    @Override // com.google.protobuf.b2
    public void N(int i10, i iVar) {
        this.f7101a.j0(i10, iVar);
    }

    @Override // com.google.protobuf.b2
    public void O(int i10, n0.a aVar, Map map) {
        if (this.f7101a.Z()) {
            T(i10, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f7101a.R0(i10, 2);
            this.f7101a.T0(n0.b(aVar, entry.getKey(), entry.getValue()));
            n0.e(this.f7101a, aVar, entry.getKey(), entry.getValue());
        }
    }

    public final void Q(int i10, boolean z10, Object obj, n0.a aVar) {
        this.f7101a.R0(i10, 2);
        this.f7101a.T0(n0.b(aVar, Boolean.valueOf(z10), obj));
        n0.e(this.f7101a, aVar, Boolean.valueOf(z10), obj);
    }

    public final void R(int i10, n0.a aVar, Map map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            iArr[i11] = ((Integer) it.next()).intValue();
            i11++;
        }
        Arrays.sort(iArr);
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = iArr[i12];
            Object obj = map.get(Integer.valueOf(i13));
            this.f7101a.R0(i10, 2);
            this.f7101a.T0(n0.b(aVar, Integer.valueOf(i13), obj));
            n0.e(this.f7101a, aVar, Integer.valueOf(i13), obj);
        }
    }

    public final void S(int i10, n0.a aVar, Map map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator it = map.keySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            jArr[i11] = ((Long) it.next()).longValue();
            i11++;
        }
        Arrays.sort(jArr);
        for (int i12 = 0; i12 < size; i12++) {
            long j10 = jArr[i12];
            Object obj = map.get(Long.valueOf(j10));
            this.f7101a.R0(i10, 2);
            this.f7101a.T0(n0.b(aVar, Long.valueOf(j10), obj));
            n0.e(this.f7101a, aVar, Long.valueOf(j10), obj);
        }
    }

    public final void T(int i10, n0.a aVar, Map map) {
        switch (a.f7102a[aVar.f7110a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    Q(i10, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    Q(i10, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i10, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                S(i10, aVar, map);
                return;
            case 12:
                U(i10, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f7110a);
        }
    }

    public final void U(int i10, n0.a aVar, Map map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator it = map.keySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            strArr[i11] = (String) it.next();
            i11++;
        }
        Arrays.sort(strArr);
        for (int i12 = 0; i12 < size; i12++) {
            String str = strArr[i12];
            Object obj = map.get(str);
            this.f7101a.R0(i10, 2);
            this.f7101a.T0(n0.b(aVar, str, obj));
            n0.e(this.f7101a, aVar, str, obj);
        }
    }

    public final void V(int i10, Object obj) {
        if (obj instanceof String) {
            this.f7101a.P0(i10, (String) obj);
        } else {
            this.f7101a.j0(i10, (i) obj);
        }
    }

    @Override // com.google.protobuf.b2
    public void a(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.t0(i10, ((Float) list.get(i11)).floatValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iS = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iS += l.s(((Float) list.get(i12)).floatValue());
        }
        this.f7101a.T0(iS);
        while (i11 < list.size()) {
            this.f7101a.u0(((Float) list.get(i11)).floatValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void b(int i10, int i11) {
        this.f7101a.S0(i10, i11);
    }

    @Override // com.google.protobuf.b2
    public final void c(int i10, Object obj) {
        if (obj instanceof i) {
            this.f7101a.G0(i10, (i) obj);
        } else {
            this.f7101a.F0(i10, (u0) obj);
        }
    }

    @Override // com.google.protobuf.b2
    public void d(int i10, int i11) {
        this.f7101a.p0(i10, i11);
    }

    @Override // com.google.protobuf.b2
    public void e(int i10, double d10) {
        this.f7101a.l0(i10, d10);
    }

    @Override // com.google.protobuf.b2
    public void f(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.J0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iJ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iJ += l.J(((Long) list.get(i12)).longValue());
        }
        this.f7101a.T0(iJ);
        while (i11 < list.size()) {
            this.f7101a.K0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void g(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.U0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iU = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iU += l.U(((Long) list.get(i12)).longValue());
        }
        this.f7101a.T0(iU);
        while (i11 < list.size()) {
            this.f7101a.V0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void h(int i10, long j10) {
        this.f7101a.r0(i10, j10);
    }

    @Override // com.google.protobuf.b2
    public b2.a i() {
        return b2.a.ASCENDING;
    }

    @Override // com.google.protobuf.b2
    public void j(int i10, List list) {
        int i11 = 0;
        if (!(list instanceof j0)) {
            while (i11 < list.size()) {
                this.f7101a.P0(i10, (String) list.get(i11));
                i11++;
            }
        } else {
            j0 j0Var = (j0) list;
            while (i11 < list.size()) {
                V(i10, j0Var.M(i11));
                i11++;
            }
        }
    }

    @Override // com.google.protobuf.b2
    public void k(int i10, String str) {
        this.f7101a.P0(i10, str);
    }

    @Override // com.google.protobuf.b2
    public void l(int i10, long j10) {
        this.f7101a.U0(i10, j10);
    }

    @Override // com.google.protobuf.b2
    public void m(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.z0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iX = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iX += l.x(((Integer) list.get(i12)).intValue());
        }
        this.f7101a.T0(iX);
        while (i11 < list.size()) {
            this.f7101a.A0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void n(int i10, long j10) {
        this.f7101a.B0(i10, j10);
    }

    @Override // com.google.protobuf.b2
    public void o(int i10, boolean z10) {
        this.f7101a.f0(i10, z10);
    }

    @Override // com.google.protobuf.b2
    public void p(int i10, int i11) {
        this.f7101a.H0(i10, i11);
    }

    @Override // com.google.protobuf.b2
    public void q(int i10) {
        this.f7101a.R0(i10, 3);
    }

    @Override // com.google.protobuf.b2
    public void r(int i10, int i11) {
        this.f7101a.z0(i10, i11);
    }

    @Override // com.google.protobuf.b2
    public void s(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.r0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iQ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iQ += l.q(((Long) list.get(i12)).longValue());
        }
        this.f7101a.T0(iQ);
        while (i11 < list.size()) {
            this.f7101a.s0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void t(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.H0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iH = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iH += l.H(((Integer) list.get(i12)).intValue());
        }
        this.f7101a.T0(iH);
        while (i11 < list.size()) {
            this.f7101a.I0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void u(int i10, long j10) {
        this.f7101a.J0(i10, j10);
    }

    @Override // com.google.protobuf.b2
    public void v(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.p0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iO = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iO += l.o(((Integer) list.get(i12)).intValue());
        }
        this.f7101a.T0(iO);
        while (i11 < list.size()) {
            this.f7101a.q0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void w(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.f0(i10, ((Boolean) list.get(i11)).booleanValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iF = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iF += l.f(((Boolean) list.get(i12)).booleanValue());
        }
        this.f7101a.T0(iF);
        while (i11 < list.size()) {
            this.f7101a.g0(((Boolean) list.get(i11)).booleanValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void x(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.S0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iS = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iS += l.S(((Integer) list.get(i12)).intValue());
        }
        this.f7101a.T0(iS);
        while (i11 < list.size()) {
            this.f7101a.T0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void y(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f7101a.N0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f7101a.R0(i10, 2);
        int iN = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iN += l.N(((Long) list.get(i12)).longValue());
        }
        this.f7101a.T0(iN);
        while (i11 < list.size()) {
            this.f7101a.O0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.protobuf.b2
    public void z(int i10, long j10) {
        this.f7101a.N0(i10, j10);
    }
}
