package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C;
import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.l0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0797j implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0796i f7072a;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.j$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7073a;

        static {
            int[] iArr = new int[k0.b.values().length];
            f7073a = iArr;
            try {
                iArr[k0.b.f7086j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7073a[k0.b.f7085i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7073a[k0.b.f7083g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7073a[k0.b.f7093q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7073a[k0.b.f7095s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7073a[k0.b.f7091o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7073a[k0.b.f7084h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7073a[k0.b.f7081e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7073a[k0.b.f7094r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7073a[k0.b.f7096t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7073a[k0.b.f7082f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7073a[k0.b.f7087k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public C0797j(AbstractC0796i abstractC0796i) {
        AbstractC0796i abstractC0796i2 = (AbstractC0796i) AbstractC0807u.b(abstractC0796i, "output");
        this.f7072a = abstractC0796i2;
        abstractC0796i2.f7041a = this;
    }

    public static C0797j P(AbstractC0796i abstractC0796i) {
        C0797j c0797j = abstractC0796i.f7041a;
        return c0797j != null ? c0797j : new C0797j(abstractC0796i);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void A(int i4, float f4) {
        this.f7072a.o0(i4, f4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void B(int i4) {
        this.f7072a.M0(i4, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void C(int i4, List list, boolean z4) {
        f0(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void D(int i4, int i5) {
        this.f7072a.i0(i4, i5);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void E(int i4, List list, boolean z4) {
        c0(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void F(int i4, List list, boolean z4) {
        X(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void G(int i4, List list, boolean z4) {
        W(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void H(int i4, int i5) {
        this.f7072a.G0(i4, i5);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void I(int i4, List list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.f7072a.e0(i4, (AbstractC0793f) list.get(i5));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void J(int i4, List list, Y y4) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            M(i4, list.get(i5), y4);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void K(int i4, List list, Y y4) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            O(i4, list.get(i5), y4);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void L(int i4, AbstractC0793f abstractC0793f) {
        this.f7072a.e0(i4, abstractC0793f);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void M(int i4, Object obj, Y y4) {
        this.f7072a.y0(i4, (J) obj, y4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void N(int i4, C.a aVar, Map map) {
        if (this.f7072a.X()) {
            U(i4, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f7072a.M0(i4, 2);
            this.f7072a.O0(C.b(aVar, entry.getKey(), entry.getValue()));
            C.e(this.f7072a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void O(int i4, Object obj, Y y4) {
        this.f7072a.r0(i4, (J) obj, y4);
    }

    public final void Q(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.a0(i4, ((Boolean) list.get(i5)).booleanValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iD = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iD += AbstractC0796i.d(((Boolean) list.get(i6)).booleanValue());
        }
        this.f7072a.O0(iD);
        while (i5 < list.size()) {
            this.f7072a.b0(((Boolean) list.get(i5)).booleanValue());
            i5++;
        }
    }

    public final void R(int i4, boolean z4, Object obj, C.a aVar) {
        this.f7072a.M0(i4, 2);
        this.f7072a.O0(C.b(aVar, Boolean.valueOf(z4), obj));
        C.e(this.f7072a, aVar, Boolean.valueOf(z4), obj);
    }

    public final void S(int i4, C.a aVar, Map map) {
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
            this.f7072a.M0(i4, 2);
            this.f7072a.O0(C.b(aVar, Integer.valueOf(i7), obj));
            C.e(this.f7072a, aVar, Integer.valueOf(i7), obj);
        }
    }

    public final void T(int i4, C.a aVar, Map map) {
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
            this.f7072a.M0(i4, 2);
            this.f7072a.O0(C.b(aVar, Long.valueOf(j4), obj));
            C.e(this.f7072a, aVar, Long.valueOf(j4), obj);
        }
    }

    public final void U(int i4, C.a aVar, Map map) {
        switch (a.f7073a[aVar.f6917a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    R(i4, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    R(i4, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                S(i4, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                T(i4, aVar, map);
                return;
            case 12:
                V(i4, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f6917a);
        }
    }

    public final void V(int i4, C.a aVar, Map map) {
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
            this.f7072a.M0(i4, 2);
            this.f7072a.O0(C.b(aVar, str, obj));
            C.e(this.f7072a, aVar, str, obj);
        }
    }

    public final void W(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.g0(i4, ((Double) list.get(i5)).doubleValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            i6 += AbstractC0796i.i(((Double) list.get(i7)).doubleValue());
        }
        this.f7072a.O0(i6);
        while (i5 < list.size()) {
            this.f7072a.h0(((Double) list.get(i5)).doubleValue());
            i5++;
        }
    }

    public final void X(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.i0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iK = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iK += AbstractC0796i.k(((Integer) list.get(i6)).intValue());
        }
        this.f7072a.O0(iK);
        while (i5 < list.size()) {
            this.f7072a.j0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public final void Y(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.k0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iM = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iM += AbstractC0796i.m(((Integer) list.get(i6)).intValue());
        }
        this.f7072a.O0(iM);
        while (i5 < list.size()) {
            this.f7072a.l0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    public final void Z(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.m0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iO = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iO += AbstractC0796i.o(((Long) list.get(i6)).longValue());
        }
        this.f7072a.O0(iO);
        while (i5 < list.size()) {
            this.f7072a.n0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void a(int i4, List list, boolean z4) {
        a0(i4, list, z4);
    }

    public final void a0(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.o0(i4, ((Float) list.get(i5)).floatValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iQ = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iQ += AbstractC0796i.q(((Float) list.get(i6)).floatValue());
        }
        this.f7072a.O0(iQ);
        while (i5 < list.size()) {
            this.f7072a.p0(((Float) list.get(i5)).floatValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void b(int i4, int i5) {
        this.f7072a.N0(i4, i5);
    }

    public final void b0(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.u0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iV = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iV += AbstractC0796i.v(((Integer) list.get(i6)).intValue());
        }
        this.f7072a.O0(iV);
        while (i5 < list.size()) {
            this.f7072a.v0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public final void c(int i4, Object obj) {
        if (obj instanceof AbstractC0793f) {
            this.f7072a.B0(i4, (AbstractC0793f) obj);
        } else {
            this.f7072a.A0(i4, (J) obj);
        }
    }

    public final void c0(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.w0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iX = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iX += AbstractC0796i.x(((Long) list.get(i6)).longValue());
        }
        this.f7072a.O0(iX);
        while (i5 < list.size()) {
            this.f7072a.x0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void d(int i4, int i5) {
        this.f7072a.k0(i4, i5);
    }

    public final void d0(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.C0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iF = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iF += AbstractC0796i.F(((Integer) list.get(i6)).intValue());
        }
        this.f7072a.O0(iF);
        while (i5 < list.size()) {
            this.f7072a.D0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void e(int i4, double d4) {
        this.f7072a.g0(i4, d4);
    }

    public final void e0(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.E0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iH = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iH += AbstractC0796i.H(((Long) list.get(i6)).longValue());
        }
        this.f7072a.O0(iH);
        while (i5 < list.size()) {
            this.f7072a.F0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void f(int i4, List list, boolean z4) {
        e0(i4, list, z4);
    }

    public void f0(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.G0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iJ = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iJ += AbstractC0796i.J(((Integer) list.get(i6)).intValue());
        }
        this.f7072a.O0(iJ);
        while (i5 < list.size()) {
            this.f7072a.H0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void g(int i4, List list, boolean z4) {
        i0(i4, list, z4);
    }

    public final void g0(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.I0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iL = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iL += AbstractC0796i.L(((Long) list.get(i6)).longValue());
        }
        this.f7072a.O0(iL);
        while (i5 < list.size()) {
            this.f7072a.J0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void h(int i4, long j4) {
        this.f7072a.m0(i4, j4);
    }

    public void h0(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.N0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iQ = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iQ += AbstractC0796i.Q(((Integer) list.get(i6)).intValue());
        }
        this.f7072a.O0(iQ);
        while (i5 < list.size()) {
            this.f7072a.O0(((Integer) list.get(i5)).intValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public l0.a i() {
        return l0.a.ASCENDING;
    }

    public final void i0(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!z4) {
            while (i5 < list.size()) {
                this.f7072a.P0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        this.f7072a.M0(i4, 2);
        int iS = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iS += AbstractC0796i.S(((Long) list.get(i6)).longValue());
        }
        this.f7072a.O0(iS);
        while (i5 < list.size()) {
            this.f7072a.Q0(((Long) list.get(i5)).longValue());
            i5++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void j(int i4, List list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.f7072a.K0(i4, (String) list.get(i5));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void k(int i4, String str) {
        this.f7072a.K0(i4, str);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void l(int i4, long j4) {
        this.f7072a.P0(i4, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void m(int i4, List list, boolean z4) {
        b0(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void n(int i4, long j4) {
        this.f7072a.w0(i4, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void o(int i4, boolean z4) {
        this.f7072a.a0(i4, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void p(int i4, int i5) {
        this.f7072a.C0(i4, i5);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void q(int i4) {
        this.f7072a.M0(i4, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void r(int i4, int i5) {
        this.f7072a.u0(i4, i5);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void s(int i4, List list, boolean z4) {
        Z(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void t(int i4, List list, boolean z4) {
        d0(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void u(int i4, long j4) {
        this.f7072a.E0(i4, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void v(int i4, List list, boolean z4) {
        Y(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void w(int i4, List list, boolean z4) {
        Q(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void x(int i4, List list, boolean z4) {
        h0(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void y(int i4, List list, boolean z4) {
        g0(i4, list, z4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void z(int i4, long j4) {
        this.f7072a.I0(i4, j4);
    }
}
