package com.google.protobuf;

import com.google.protobuf.C;
import com.google.protobuf.l0;
import com.google.protobuf.m0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1471j implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1470i f16427a;

    /* JADX INFO: renamed from: com.google.protobuf.j$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16428a;

        static {
            int[] iArr = new int[l0.b.values().length];
            f16428a = iArr;
            try {
                iArr[l0.b.f16466j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16428a[l0.b.f16465i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16428a[l0.b.f16463g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16428a[l0.b.f16473q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16428a[l0.b.f16475s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16428a[l0.b.f16471o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16428a[l0.b.f16464h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16428a[l0.b.f16461e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16428a[l0.b.f16474r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16428a[l0.b.f16476t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16428a[l0.b.f16462f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16428a[l0.b.f16467k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public C1471j(AbstractC1470i abstractC1470i) {
        AbstractC1470i abstractC1470i2 = (AbstractC1470i) AbstractC1481u.b(abstractC1470i, "output");
        this.f16427a = abstractC1470i2;
        abstractC1470i2.f16410a = this;
    }

    public static C1471j P(AbstractC1470i abstractC1470i) {
        C1471j c1471j = abstractC1470i.f16410a;
        return c1471j != null ? c1471j : new C1471j(abstractC1470i);
    }

    @Override // com.google.protobuf.m0
    public void A(int i8, float f8) {
        this.f16427a.s0(i8, f8);
    }

    @Override // com.google.protobuf.m0
    public void B(int i8) {
        this.f16427a.Q0(i8, 4);
    }

    @Override // com.google.protobuf.m0
    public void C(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.K0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iK = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iK += AbstractC1470i.K(((Integer) list.get(i10)).intValue());
        }
        this.f16427a.S0(iK);
        while (i9 < list.size()) {
            this.f16427a.L0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void D(int i8, int i9) {
        this.f16427a.m0(i8, i9);
    }

    @Override // com.google.protobuf.m0
    public void E(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.A0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iY = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iY += AbstractC1470i.y(((Long) list.get(i10)).longValue());
        }
        this.f16427a.S0(iY);
        while (i9 < list.size()) {
            this.f16427a.B0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void F(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.m0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iL = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iL += AbstractC1470i.l(((Integer) list.get(i10)).intValue());
        }
        this.f16427a.S0(iL);
        while (i9 < list.size()) {
            this.f16427a.n0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void G(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.k0(i8, ((Double) list.get(i9)).doubleValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iJ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iJ += AbstractC1470i.j(((Double) list.get(i10)).doubleValue());
        }
        this.f16427a.S0(iJ);
        while (i9 < list.size()) {
            this.f16427a.l0(((Double) list.get(i9)).doubleValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void H(int i8, int i9) {
        this.f16427a.K0(i8, i9);
    }

    @Override // com.google.protobuf.m0
    public void I(int i8, List list) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.f16427a.i0(i8, (AbstractC1467f) list.get(i9));
        }
    }

    @Override // com.google.protobuf.m0
    public void J(int i8, List list, Y y7) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            L(i8, list.get(i9), y7);
        }
    }

    @Override // com.google.protobuf.m0
    public void K(int i8, List list, Y y7) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            M(i8, list.get(i9), y7);
        }
    }

    @Override // com.google.protobuf.m0
    public void L(int i8, Object obj, Y y7) {
        this.f16427a.C0(i8, (J) obj, y7);
    }

    @Override // com.google.protobuf.m0
    public void M(int i8, Object obj, Y y7) {
        this.f16427a.v0(i8, (J) obj, y7);
    }

    @Override // com.google.protobuf.m0
    public void N(int i8, AbstractC1467f abstractC1467f) {
        this.f16427a.i0(i8, abstractC1467f);
    }

    @Override // com.google.protobuf.m0
    public void O(int i8, C.a aVar, Map map) {
        if (this.f16427a.Y()) {
            T(i8, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f16427a.Q0(i8, 2);
            this.f16427a.S0(C.b(aVar, entry.getKey(), entry.getValue()));
            C.e(this.f16427a, aVar, entry.getKey(), entry.getValue());
        }
    }

    public final void Q(int i8, boolean z7, Object obj, C.a aVar) {
        this.f16427a.Q0(i8, 2);
        this.f16427a.S0(C.b(aVar, Boolean.valueOf(z7), obj));
        C.e(this.f16427a, aVar, Boolean.valueOf(z7), obj);
    }

    public final void R(int i8, C.a aVar, Map map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i9 = 0;
        while (it.hasNext()) {
            iArr[i9] = ((Integer) it.next()).intValue();
            i9++;
        }
        Arrays.sort(iArr);
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = iArr[i10];
            Object obj = map.get(Integer.valueOf(i11));
            this.f16427a.Q0(i8, 2);
            this.f16427a.S0(C.b(aVar, Integer.valueOf(i11), obj));
            C.e(this.f16427a, aVar, Integer.valueOf(i11), obj);
        }
    }

    public final void S(int i8, C.a aVar, Map map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator it = map.keySet().iterator();
        int i9 = 0;
        while (it.hasNext()) {
            jArr[i9] = ((Long) it.next()).longValue();
            i9++;
        }
        Arrays.sort(jArr);
        for (int i10 = 0; i10 < size; i10++) {
            long j8 = jArr[i10];
            Object obj = map.get(Long.valueOf(j8));
            this.f16427a.Q0(i8, 2);
            this.f16427a.S0(C.b(aVar, Long.valueOf(j8), obj));
            C.e(this.f16427a, aVar, Long.valueOf(j8), obj);
        }
    }

    public final void T(int i8, C.a aVar, Map map) {
        switch (a.f16428a[aVar.f16282a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    Q(i8, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    Q(i8, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i8, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                S(i8, aVar, map);
                return;
            case 12:
                U(i8, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f16282a);
        }
    }

    public final void U(int i8, C.a aVar, Map map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator it = map.keySet().iterator();
        int i9 = 0;
        while (it.hasNext()) {
            strArr[i9] = (String) it.next();
            i9++;
        }
        Arrays.sort(strArr);
        for (int i10 = 0; i10 < size; i10++) {
            String str = strArr[i10];
            Object obj = map.get(str);
            this.f16427a.Q0(i8, 2);
            this.f16427a.S0(C.b(aVar, str, obj));
            C.e(this.f16427a, aVar, str, obj);
        }
    }

    public final void V(int i8, Object obj) {
        if (obj instanceof String) {
            this.f16427a.O0(i8, (String) obj);
        } else {
            this.f16427a.i0(i8, (AbstractC1467f) obj);
        }
    }

    @Override // com.google.protobuf.m0
    public void a(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.s0(i8, ((Float) list.get(i9)).floatValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iR = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iR += AbstractC1470i.r(((Float) list.get(i10)).floatValue());
        }
        this.f16427a.S0(iR);
        while (i9 < list.size()) {
            this.f16427a.t0(((Float) list.get(i9)).floatValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void b(int i8, int i9) {
        this.f16427a.R0(i8, i9);
    }

    @Override // com.google.protobuf.m0
    public final void c(int i8, Object obj) {
        if (obj instanceof AbstractC1467f) {
            this.f16427a.F0(i8, (AbstractC1467f) obj);
        } else {
            this.f16427a.E0(i8, (J) obj);
        }
    }

    @Override // com.google.protobuf.m0
    public void d(int i8, int i9) {
        this.f16427a.o0(i8, i9);
    }

    @Override // com.google.protobuf.m0
    public void e(int i8, double d8) {
        this.f16427a.k0(i8, d8);
    }

    @Override // com.google.protobuf.m0
    public void f(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.I0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int I7 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            I7 += AbstractC1470i.I(((Long) list.get(i10)).longValue());
        }
        this.f16427a.S0(I7);
        while (i9 < list.size()) {
            this.f16427a.J0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void g(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.T0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iT = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iT += AbstractC1470i.T(((Long) list.get(i10)).longValue());
        }
        this.f16427a.S0(iT);
        while (i9 < list.size()) {
            this.f16427a.U0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void h(int i8, long j8) {
        this.f16427a.q0(i8, j8);
    }

    @Override // com.google.protobuf.m0
    public m0.a i() {
        return m0.a.ASCENDING;
    }

    @Override // com.google.protobuf.m0
    public void j(int i8, List list) {
        int i9 = 0;
        if (!(list instanceof InterfaceC1486z)) {
            while (i9 < list.size()) {
                this.f16427a.O0(i8, (String) list.get(i9));
                i9++;
            }
        } else {
            InterfaceC1486z interfaceC1486z = (InterfaceC1486z) list;
            while (i9 < list.size()) {
                V(i8, interfaceC1486z.B(i9));
                i9++;
            }
        }
    }

    @Override // com.google.protobuf.m0
    public void k(int i8, String str) {
        this.f16427a.O0(i8, str);
    }

    @Override // com.google.protobuf.m0
    public void l(int i8, long j8) {
        this.f16427a.T0(i8, j8);
    }

    @Override // com.google.protobuf.m0
    public void m(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.y0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iW = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iW += AbstractC1470i.w(((Integer) list.get(i10)).intValue());
        }
        this.f16427a.S0(iW);
        while (i9 < list.size()) {
            this.f16427a.z0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void n(int i8, long j8) {
        this.f16427a.A0(i8, j8);
    }

    @Override // com.google.protobuf.m0
    public void o(int i8, boolean z7) {
        this.f16427a.e0(i8, z7);
    }

    @Override // com.google.protobuf.m0
    public void p(int i8, int i9) {
        this.f16427a.G0(i8, i9);
    }

    @Override // com.google.protobuf.m0
    public void q(int i8) {
        this.f16427a.Q0(i8, 3);
    }

    @Override // com.google.protobuf.m0
    public void r(int i8, int i9) {
        this.f16427a.y0(i8, i9);
    }

    @Override // com.google.protobuf.m0
    public void s(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.q0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iP = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iP += AbstractC1470i.p(((Long) list.get(i10)).longValue());
        }
        this.f16427a.S0(iP);
        while (i9 < list.size()) {
            this.f16427a.r0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void t(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.G0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iG = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iG += AbstractC1470i.G(((Integer) list.get(i10)).intValue());
        }
        this.f16427a.S0(iG);
        while (i9 < list.size()) {
            this.f16427a.H0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void u(int i8, long j8) {
        this.f16427a.I0(i8, j8);
    }

    @Override // com.google.protobuf.m0
    public void v(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.o0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iN = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iN += AbstractC1470i.n(((Integer) list.get(i10)).intValue());
        }
        this.f16427a.S0(iN);
        while (i9 < list.size()) {
            this.f16427a.p0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void w(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.e0(i8, ((Boolean) list.get(i9)).booleanValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iE = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iE += AbstractC1470i.e(((Boolean) list.get(i10)).booleanValue());
        }
        this.f16427a.S0(iE);
        while (i9 < list.size()) {
            this.f16427a.f0(((Boolean) list.get(i9)).booleanValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void x(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.R0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iR = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iR += AbstractC1470i.R(((Integer) list.get(i10)).intValue());
        }
        this.f16427a.S0(iR);
        while (i9 < list.size()) {
            this.f16427a.S0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void y(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f16427a.M0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f16427a.Q0(i8, 2);
        int iM = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iM += AbstractC1470i.M(((Long) list.get(i10)).longValue());
        }
        this.f16427a.S0(iM);
        while (i9 < list.size()) {
            this.f16427a.N0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.m0
    public void z(int i8, long j8) {
        this.f16427a.M0(i8, j8);
    }
}
