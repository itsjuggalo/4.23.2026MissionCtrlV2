package com.google.protobuf;

import com.google.protobuf.B0;
import com.google.protobuf.C0;
import com.google.protobuf.N;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k4.C2105D;

/* JADX INFO: renamed from: com.google.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1244m implements C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1243l f12736a;

    /* JADX INFO: renamed from: com.google.protobuf.m$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12737a;

        static {
            int[] iArr = new int[B0.b.values().length];
            f12737a = iArr;
            try {
                iArr[B0.b.f12520j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12737a[B0.b.f12519i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12737a[B0.b.f12517g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12737a[B0.b.f12527q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12737a[B0.b.f12529s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12737a[B0.b.f12525o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12737a[B0.b.f12518h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12737a[B0.b.f12515e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12737a[B0.b.f12528r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12737a[B0.b.f12530t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12737a[B0.b.f12516f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12737a[B0.b.f12521k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public C1244m(AbstractC1243l abstractC1243l) {
        AbstractC1243l abstractC1243l2 = (AbstractC1243l) C.b(abstractC1243l, "output");
        this.f12736a = abstractC1243l2;
        abstractC1243l2.f12725a = this;
    }

    public static C1244m P(AbstractC1243l abstractC1243l) {
        C1244m c1244m = abstractC1243l.f12725a;
        return c1244m != null ? c1244m : new C1244m(abstractC1243l);
    }

    @Override // com.google.protobuf.C0
    public void A(int i7, float f7) {
        this.f12736a.t0(i7, f7);
    }

    @Override // com.google.protobuf.C0
    public void B(int i7) {
        this.f12736a.R0(i7, 4);
    }

    @Override // com.google.protobuf.C0
    public void C(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.L0(i7, ((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iL = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iL += AbstractC1243l.L(((Integer) list.get(i9)).intValue());
        }
        this.f12736a.T0(iL);
        while (i8 < list.size()) {
            this.f12736a.M0(((Integer) list.get(i8)).intValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void D(int i7, int i8) {
        this.f12736a.n0(i7, i8);
    }

    @Override // com.google.protobuf.C0
    public void E(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.B0(i7, ((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iZ = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iZ += AbstractC1243l.z(((Long) list.get(i9)).longValue());
        }
        this.f12736a.T0(iZ);
        while (i8 < list.size()) {
            this.f12736a.C0(((Long) list.get(i8)).longValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void F(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.n0(i7, ((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iM = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iM += AbstractC1243l.m(((Integer) list.get(i9)).intValue());
        }
        this.f12736a.T0(iM);
        while (i8 < list.size()) {
            this.f12736a.o0(((Integer) list.get(i8)).intValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void G(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.l0(i7, ((Double) list.get(i8)).doubleValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iK = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iK += AbstractC1243l.k(((Double) list.get(i9)).doubleValue());
        }
        this.f12736a.T0(iK);
        while (i8 < list.size()) {
            this.f12736a.m0(((Double) list.get(i8)).doubleValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void H(int i7, int i8) {
        this.f12736a.L0(i7, i8);
    }

    @Override // com.google.protobuf.C0
    public void I(int i7, List list) {
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.f12736a.j0(i7, (AbstractC1240i) list.get(i8));
        }
    }

    @Override // com.google.protobuf.C0
    public void J(int i7, List list, n0 n0Var) {
        for (int i8 = 0; i8 < list.size(); i8++) {
            L(i7, list.get(i8), n0Var);
        }
    }

    @Override // com.google.protobuf.C0
    public void K(int i7, List list, n0 n0Var) {
        for (int i8 = 0; i8 < list.size(); i8++) {
            M(i7, list.get(i8), n0Var);
        }
    }

    @Override // com.google.protobuf.C0
    public void L(int i7, Object obj, n0 n0Var) {
        this.f12736a.D0(i7, (V) obj, n0Var);
    }

    @Override // com.google.protobuf.C0
    public void M(int i7, Object obj, n0 n0Var) {
        this.f12736a.w0(i7, (V) obj, n0Var);
    }

    @Override // com.google.protobuf.C0
    public void N(int i7, AbstractC1240i abstractC1240i) {
        this.f12736a.j0(i7, abstractC1240i);
    }

    @Override // com.google.protobuf.C0
    public void O(int i7, N.a aVar, Map map) {
        if (this.f12736a.Z()) {
            T(i7, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f12736a.R0(i7, 2);
            this.f12736a.T0(N.b(aVar, entry.getKey(), entry.getValue()));
            N.e(this.f12736a, aVar, entry.getKey(), entry.getValue());
        }
    }

    public final void Q(int i7, boolean z7, Object obj, N.a aVar) {
        this.f12736a.R0(i7, 2);
        this.f12736a.T0(N.b(aVar, Boolean.valueOf(z7), obj));
        N.e(this.f12736a, aVar, Boolean.valueOf(z7), obj);
    }

    public final void R(int i7, N.a aVar, Map map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            iArr[i8] = ((Integer) it.next()).intValue();
            i8++;
        }
        Arrays.sort(iArr);
        for (int i9 = 0; i9 < size; i9++) {
            int i10 = iArr[i9];
            Object obj = map.get(Integer.valueOf(i10));
            this.f12736a.R0(i7, 2);
            this.f12736a.T0(N.b(aVar, Integer.valueOf(i10), obj));
            N.e(this.f12736a, aVar, Integer.valueOf(i10), obj);
        }
    }

    public final void S(int i7, N.a aVar, Map map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator it = map.keySet().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            jArr[i8] = ((Long) it.next()).longValue();
            i8++;
        }
        Arrays.sort(jArr);
        for (int i9 = 0; i9 < size; i9++) {
            long j7 = jArr[i9];
            Object obj = map.get(Long.valueOf(j7));
            this.f12736a.R0(i7, 2);
            this.f12736a.T0(N.b(aVar, Long.valueOf(j7), obj));
            N.e(this.f12736a, aVar, Long.valueOf(j7), obj);
        }
    }

    public final void T(int i7, N.a aVar, Map map) {
        switch (a.f12737a[aVar.f12593a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    Q(i7, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    Q(i7, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i7, aVar, map);
                return;
            case 7:
            case 8:
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
                S(i7, aVar, map);
                return;
            case 12:
                U(i7, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f12593a);
        }
    }

    public final void U(int i7, N.a aVar, Map map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator it = map.keySet().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            strArr[i8] = (String) it.next();
            i8++;
        }
        Arrays.sort(strArr);
        for (int i9 = 0; i9 < size; i9++) {
            String str = strArr[i9];
            Object obj = map.get(str);
            this.f12736a.R0(i7, 2);
            this.f12736a.T0(N.b(aVar, str, obj));
            N.e(this.f12736a, aVar, str, obj);
        }
    }

    public final void V(int i7, Object obj) {
        if (obj instanceof String) {
            this.f12736a.P0(i7, (String) obj);
        } else {
            this.f12736a.j0(i7, (AbstractC1240i) obj);
        }
    }

    @Override // com.google.protobuf.C0
    public void a(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.t0(i7, ((Float) list.get(i8)).floatValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iS = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iS += AbstractC1243l.s(((Float) list.get(i9)).floatValue());
        }
        this.f12736a.T0(iS);
        while (i8 < list.size()) {
            this.f12736a.u0(((Float) list.get(i8)).floatValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void b(int i7, int i8) {
        this.f12736a.S0(i7, i8);
    }

    @Override // com.google.protobuf.C0
    public final void c(int i7, Object obj) {
        if (obj instanceof AbstractC1240i) {
            this.f12736a.G0(i7, (AbstractC1240i) obj);
        } else {
            this.f12736a.F0(i7, (V) obj);
        }
    }

    @Override // com.google.protobuf.C0
    public void d(int i7, int i8) {
        this.f12736a.p0(i7, i8);
    }

    @Override // com.google.protobuf.C0
    public void e(int i7, double d7) {
        this.f12736a.l0(i7, d7);
    }

    @Override // com.google.protobuf.C0
    public void f(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.J0(i7, ((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iJ = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iJ += AbstractC1243l.J(((Long) list.get(i9)).longValue());
        }
        this.f12736a.T0(iJ);
        while (i8 < list.size()) {
            this.f12736a.K0(((Long) list.get(i8)).longValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void g(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.U0(i7, ((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iU = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iU += AbstractC1243l.U(((Long) list.get(i9)).longValue());
        }
        this.f12736a.T0(iU);
        while (i8 < list.size()) {
            this.f12736a.V0(((Long) list.get(i8)).longValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void h(int i7, long j7) {
        this.f12736a.r0(i7, j7);
    }

    @Override // com.google.protobuf.C0
    public C0.a i() {
        return C0.a.ASCENDING;
    }

    @Override // com.google.protobuf.C0
    public void j(int i7, List list) {
        int i8 = 0;
        if (!(list instanceof J)) {
            while (i8 < list.size()) {
                this.f12736a.P0(i7, (String) list.get(i8));
                i8++;
            }
        } else {
            J j7 = (J) list;
            while (i8 < list.size()) {
                V(i7, j7.z(i8));
                i8++;
            }
        }
    }

    @Override // com.google.protobuf.C0
    public void k(int i7, String str) {
        this.f12736a.P0(i7, str);
    }

    @Override // com.google.protobuf.C0
    public void l(int i7, long j7) {
        this.f12736a.U0(i7, j7);
    }

    @Override // com.google.protobuf.C0
    public void m(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.z0(i7, ((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iX = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iX += AbstractC1243l.x(((Integer) list.get(i9)).intValue());
        }
        this.f12736a.T0(iX);
        while (i8 < list.size()) {
            this.f12736a.A0(((Integer) list.get(i8)).intValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void n(int i7, long j7) {
        this.f12736a.B0(i7, j7);
    }

    @Override // com.google.protobuf.C0
    public void o(int i7, boolean z7) {
        this.f12736a.f0(i7, z7);
    }

    @Override // com.google.protobuf.C0
    public void p(int i7, int i8) {
        this.f12736a.H0(i7, i8);
    }

    @Override // com.google.protobuf.C0
    public void q(int i7) {
        this.f12736a.R0(i7, 3);
    }

    @Override // com.google.protobuf.C0
    public void r(int i7, int i8) {
        this.f12736a.z0(i7, i8);
    }

    @Override // com.google.protobuf.C0
    public void s(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.r0(i7, ((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iQ = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iQ += AbstractC1243l.q(((Long) list.get(i9)).longValue());
        }
        this.f12736a.T0(iQ);
        while (i8 < list.size()) {
            this.f12736a.s0(((Long) list.get(i8)).longValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void t(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.H0(i7, ((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iH = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iH += AbstractC1243l.H(((Integer) list.get(i9)).intValue());
        }
        this.f12736a.T0(iH);
        while (i8 < list.size()) {
            this.f12736a.I0(((Integer) list.get(i8)).intValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void u(int i7, long j7) {
        this.f12736a.J0(i7, j7);
    }

    @Override // com.google.protobuf.C0
    public void v(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.p0(i7, ((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iO = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iO += AbstractC1243l.o(((Integer) list.get(i9)).intValue());
        }
        this.f12736a.T0(iO);
        while (i8 < list.size()) {
            this.f12736a.q0(((Integer) list.get(i8)).intValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void w(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.f0(i7, ((Boolean) list.get(i8)).booleanValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iF = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iF += AbstractC1243l.f(((Boolean) list.get(i9)).booleanValue());
        }
        this.f12736a.T0(iF);
        while (i8 < list.size()) {
            this.f12736a.g0(((Boolean) list.get(i8)).booleanValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void x(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.S0(i7, ((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iS = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iS += AbstractC1243l.S(((Integer) list.get(i9)).intValue());
        }
        this.f12736a.T0(iS);
        while (i8 < list.size()) {
            this.f12736a.T0(((Integer) list.get(i8)).intValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void y(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!z7) {
            while (i8 < list.size()) {
                this.f12736a.N0(i7, ((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        this.f12736a.R0(i7, 2);
        int iN = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            iN += AbstractC1243l.N(((Long) list.get(i9)).longValue());
        }
        this.f12736a.T0(iN);
        while (i8 < list.size()) {
            this.f12736a.O0(((Long) list.get(i8)).longValue());
            i8++;
        }
    }

    @Override // com.google.protobuf.C0
    public void z(int i7, long j7) {
        this.f12736a.N0(i7, j7);
    }
}
