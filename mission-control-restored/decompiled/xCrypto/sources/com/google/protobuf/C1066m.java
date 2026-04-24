package com.google.protobuf;

import com.google.protobuf.C0;
import com.google.protobuf.D0;
import com.google.protobuf.O;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1066m implements D0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1065l f11117a;

    /* JADX INFO: renamed from: com.google.protobuf.m$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11118a;

        static {
            int[] iArr = new int[C0.b.values().length];
            f11118a = iArr;
            try {
                iArr[C0.b.f10898j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11118a[C0.b.f10897i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11118a[C0.b.f10895g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11118a[C0.b.f10905q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11118a[C0.b.f10907s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11118a[C0.b.f10903o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11118a[C0.b.f10896h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11118a[C0.b.f10893e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11118a[C0.b.f10906r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11118a[C0.b.f10908t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11118a[C0.b.f10894f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11118a[C0.b.f10899k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public C1066m(AbstractC1065l abstractC1065l) {
        AbstractC1065l abstractC1065l2 = (AbstractC1065l) C.b(abstractC1065l, "output");
        this.f11117a = abstractC1065l2;
        abstractC1065l2.f11102a = this;
    }

    public static C1066m P(AbstractC1065l abstractC1065l) {
        C1066m c1066m = abstractC1065l.f11102a;
        return c1066m != null ? c1066m : new C1066m(abstractC1065l);
    }

    @Override // com.google.protobuf.D0
    public void A(int i4, float f4) {
        this.f11117a.v0(i4, f4);
    }

    @Override // com.google.protobuf.D0
    public void B(int i4) {
        this.f11117a.T0(i4, 4);
    }

    @Override // com.google.protobuf.D0
    public void C(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.N0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iN = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iN += AbstractC1065l.N(((Integer) list.get(i6)).intValue());
        }
        this.f11117a.V0(iN);
        while (i5 < list.size()) {
            this.f11117a.O0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void D(int i4, int i5) {
        this.f11117a.p0(i4, i5);
    }

    @Override // com.google.protobuf.D0
    public void E(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.D0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iZ = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iZ += AbstractC1065l.z(((Long) list.get(i6)).longValue());
        }
        this.f11117a.V0(iZ);
        while (i5 < list.size()) {
            this.f11117a.E0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void F(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.p0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iM = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iM += AbstractC1065l.m(((Integer) list.get(i6)).intValue());
        }
        this.f11117a.V0(iM);
        while (i5 < list.size()) {
            this.f11117a.q0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void G(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.n0(i4, ((Double) list.get(i5)).doubleValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iK = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iK += AbstractC1065l.k(((Double) list.get(i6)).doubleValue());
        }
        this.f11117a.V0(iK);
        while (i5 < list.size()) {
            this.f11117a.o0(((Double) list.get(i5)).doubleValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void H(int i4, int i5) {
        this.f11117a.N0(i4, i5);
    }

    @Override // com.google.protobuf.D0
    public void I(int i4, List list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.f11117a.l0(i4, (AbstractC1062i) list.get(i5));
        }
    }

    @Override // com.google.protobuf.D0
    public void J(int i4, List list, o0 o0Var) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            L(i4, list.get(i5), o0Var);
        }
    }

    @Override // com.google.protobuf.D0
    public void K(int i4, List list, o0 o0Var) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            M(i4, list.get(i5), o0Var);
        }
    }

    @Override // com.google.protobuf.D0
    public void L(int i4, Object obj, o0 o0Var) {
        this.f11117a.F0(i4, (W) obj, o0Var);
    }

    @Override // com.google.protobuf.D0
    public void M(int i4, Object obj, o0 o0Var) {
        this.f11117a.y0(i4, (W) obj, o0Var);
    }

    @Override // com.google.protobuf.D0
    public void N(int i4, AbstractC1062i abstractC1062i) {
        this.f11117a.l0(i4, abstractC1062i);
    }

    @Override // com.google.protobuf.D0
    public void O(int i4, O.a aVar, Map map) {
        if (this.f11117a.b0()) {
            T(i4, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f11117a.T0(i4, 2);
            this.f11117a.V0(O.b(aVar, entry.getKey(), entry.getValue()));
            O.e(this.f11117a, aVar, entry.getKey(), entry.getValue());
        }
    }

    public final void Q(int i4, boolean z4, Object obj, O.a aVar) {
        this.f11117a.T0(i4, 2);
        this.f11117a.V0(O.b(aVar, Boolean.valueOf(z4), obj));
        O.e(this.f11117a, aVar, Boolean.valueOf(z4), obj);
    }

    public final void R(int i4, O.a aVar, Map map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            iArr[i5] = ((Integer) it.next()).intValue();
            i5++;
        }
        Arrays.sort(iArr);
        for (int i6 = 0; i6 < size; i6++) {
            int i7 = iArr[i6];
            Object obj = map.get(Integer.valueOf(i7));
            this.f11117a.T0(i4, 2);
            this.f11117a.V0(O.b(aVar, Integer.valueOf(i7), obj));
            O.e(this.f11117a, aVar, Integer.valueOf(i7), obj);
        }
    }

    public final void S(int i4, O.a aVar, Map map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator it = map.keySet().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            jArr[i5] = ((Long) it.next()).longValue();
            i5++;
        }
        Arrays.sort(jArr);
        for (int i6 = 0; i6 < size; i6++) {
            long j4 = jArr[i6];
            Object obj = map.get(Long.valueOf(j4));
            this.f11117a.T0(i4, 2);
            this.f11117a.V0(O.b(aVar, Long.valueOf(j4), obj));
            O.e(this.f11117a, aVar, Long.valueOf(j4), obj);
        }
    }

    public final void T(int i4, O.a aVar, Map map) {
        switch (a.f11118a[aVar.f10968a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    Q(i4, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    Q(i4, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i4, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                S(i4, aVar, map);
                return;
            case 12:
                U(i4, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f10968a);
        }
    }

    public final void U(int i4, O.a aVar, Map map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator it = map.keySet().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            strArr[i5] = (String) it.next();
            i5++;
        }
        Arrays.sort(strArr);
        for (int i6 = 0; i6 < size; i6++) {
            String str = strArr[i6];
            Object obj = map.get(str);
            this.f11117a.T0(i4, 2);
            this.f11117a.V0(O.b(aVar, str, obj));
            O.e(this.f11117a, aVar, str, obj);
        }
    }

    public final void V(int i4, Object obj) {
        if (obj instanceof String) {
            this.f11117a.R0(i4, (String) obj);
        } else {
            this.f11117a.l0(i4, (AbstractC1062i) obj);
        }
    }

    @Override // com.google.protobuf.D0
    public void a(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.v0(i4, ((Float) list.get(i5)).floatValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iS = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iS += AbstractC1065l.s(((Float) list.get(i6)).floatValue());
        }
        this.f11117a.V0(iS);
        while (i5 < list.size()) {
            this.f11117a.w0(((Float) list.get(i5)).floatValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void b(int i4, int i5) {
        this.f11117a.U0(i4, i5);
    }

    @Override // com.google.protobuf.D0
    public final void c(int i4, Object obj) {
        if (obj instanceof AbstractC1062i) {
            this.f11117a.I0(i4, (AbstractC1062i) obj);
        } else {
            this.f11117a.H0(i4, (W) obj);
        }
    }

    @Override // com.google.protobuf.D0
    public void d(int i4, int i5) {
        this.f11117a.r0(i4, i5);
    }

    @Override // com.google.protobuf.D0
    public void e(int i4, double d4) {
        this.f11117a.n0(i4, d4);
    }

    @Override // com.google.protobuf.D0
    public void f(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.L0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iL = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iL += AbstractC1065l.L(((Long) list.get(i6)).longValue());
        }
        this.f11117a.V0(iL);
        while (i5 < list.size()) {
            this.f11117a.M0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void g(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.W0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iW = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iW += AbstractC1065l.W(((Long) list.get(i6)).longValue());
        }
        this.f11117a.V0(iW);
        while (i5 < list.size()) {
            this.f11117a.X0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void h(int i4, long j4) {
        this.f11117a.t0(i4, j4);
    }

    @Override // com.google.protobuf.D0
    public D0.a i() {
        return D0.a.ASCENDING;
    }

    @Override // com.google.protobuf.D0
    public void j(int i4, List list) {
        int i5 = 0;
        if (!(list instanceof K)) {
            while (i5 < list.size()) {
                this.f11117a.R0(i4, (String) list.get(i5));
                i5++;
            }
        } else {
            K k4 = (K) list;
            while (i5 < list.size()) {
                V(i4, k4.j(i5));
                i5++;
            }
        }
    }

    @Override // com.google.protobuf.D0
    public void k(int i4, String str) {
        this.f11117a.R0(i4, str);
    }

    @Override // com.google.protobuf.D0
    public void l(int i4, long j4) {
        this.f11117a.W0(i4, j4);
    }

    @Override // com.google.protobuf.D0
    public void m(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.B0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iX = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iX += AbstractC1065l.x(((Integer) list.get(i6)).intValue());
        }
        this.f11117a.V0(iX);
        while (i5 < list.size()) {
            this.f11117a.C0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void n(int i4, long j4) {
        this.f11117a.D0(i4, j4);
    }

    @Override // com.google.protobuf.D0
    public void o(int i4, boolean z4) {
        this.f11117a.h0(i4, z4);
    }

    @Override // com.google.protobuf.D0
    public void p(int i4, int i5) {
        this.f11117a.J0(i4, i5);
    }

    @Override // com.google.protobuf.D0
    public void q(int i4) {
        this.f11117a.T0(i4, 3);
    }

    @Override // com.google.protobuf.D0
    public void r(int i4, int i5) {
        this.f11117a.B0(i4, i5);
    }

    @Override // com.google.protobuf.D0
    public void s(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.t0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iQ = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iQ += AbstractC1065l.q(((Long) list.get(i6)).longValue());
        }
        this.f11117a.V0(iQ);
        while (i5 < list.size()) {
            this.f11117a.u0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void t(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.J0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iJ = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iJ += AbstractC1065l.J(((Integer) list.get(i6)).intValue());
        }
        this.f11117a.V0(iJ);
        while (i5 < list.size()) {
            this.f11117a.K0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void u(int i4, long j4) {
        this.f11117a.L0(i4, j4);
    }

    @Override // com.google.protobuf.D0
    public void v(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.r0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iO = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iO += AbstractC1065l.o(((Integer) list.get(i6)).intValue());
        }
        this.f11117a.V0(iO);
        while (i5 < list.size()) {
            this.f11117a.s0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void w(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.h0(i4, ((Boolean) list.get(i5)).booleanValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iF = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iF += AbstractC1065l.f(((Boolean) list.get(i6)).booleanValue());
        }
        this.f11117a.V0(iF);
        while (i5 < list.size()) {
            this.f11117a.i0(((Boolean) list.get(i5)).booleanValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void x(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.U0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iU = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iU += AbstractC1065l.U(((Integer) list.get(i6)).intValue());
        }
        this.f11117a.V0(iU);
        while (i5 < list.size()) {
            this.f11117a.V0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void y(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f11117a.P0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f11117a.T0(i4, 2);
        int iP = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iP += AbstractC1065l.P(((Long) list.get(i6)).longValue());
        }
        this.f11117a.V0(iP);
        while (i5 < list.size()) {
            this.f11117a.Q0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.D0
    public void z(int i4, long j4) {
        this.f11117a.P0(i4, j4);
    }
}
