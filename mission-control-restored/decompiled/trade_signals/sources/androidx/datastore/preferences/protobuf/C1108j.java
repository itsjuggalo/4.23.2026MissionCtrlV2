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
public final class C1108j implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1107i f11292a;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.j$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11293a;

        static {
            int[] iArr = new int[k0.b.values().length];
            f11293a = iArr;
            try {
                iArr[k0.b.f11306j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11293a[k0.b.f11305i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11293a[k0.b.f11303g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11293a[k0.b.f11313q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11293a[k0.b.f11315s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11293a[k0.b.f11311o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11293a[k0.b.f11304h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11293a[k0.b.f11301e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11293a[k0.b.f11314r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11293a[k0.b.f11316t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11293a[k0.b.f11302f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11293a[k0.b.f11307k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public C1108j(AbstractC1107i abstractC1107i) {
        AbstractC1107i abstractC1107i2 = (AbstractC1107i) AbstractC1118u.b(abstractC1107i, "output");
        this.f11292a = abstractC1107i2;
        abstractC1107i2.f11261a = this;
    }

    public static C1108j P(AbstractC1107i abstractC1107i) {
        C1108j c1108j = abstractC1107i.f11261a;
        return c1108j != null ? c1108j : new C1108j(abstractC1107i);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void A(int i8, float f8) {
        this.f11292a.o0(i8, f8);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void B(int i8) {
        this.f11292a.M0(i8, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void C(int i8, List list, boolean z7) {
        f0(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void D(int i8, int i9) {
        this.f11292a.i0(i8, i9);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void E(int i8, List list, boolean z7) {
        c0(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void F(int i8, List list, boolean z7) {
        X(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void G(int i8, List list, boolean z7) {
        W(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void H(int i8, int i9) {
        this.f11292a.G0(i8, i9);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void I(int i8, List list) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.f11292a.e0(i8, (AbstractC1104f) list.get(i9));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void J(int i8, List list, Y y7) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            M(i8, list.get(i9), y7);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void K(int i8, List list, Y y7) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            O(i8, list.get(i9), y7);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void L(int i8, AbstractC1104f abstractC1104f) {
        this.f11292a.e0(i8, abstractC1104f);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void M(int i8, Object obj, Y y7) {
        this.f11292a.y0(i8, (J) obj, y7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void N(int i8, C.a aVar, Map map) {
        if (this.f11292a.X()) {
            U(i8, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f11292a.M0(i8, 2);
            this.f11292a.O0(C.b(aVar, entry.getKey(), entry.getValue()));
            C.e(this.f11292a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void O(int i8, Object obj, Y y7) {
        this.f11292a.r0(i8, (J) obj, y7);
    }

    public final void Q(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.a0(i8, ((Boolean) list.get(i9)).booleanValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iD = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iD += AbstractC1107i.d(((Boolean) list.get(i10)).booleanValue());
        }
        this.f11292a.O0(iD);
        while (i9 < list.size()) {
            this.f11292a.b0(((Boolean) list.get(i9)).booleanValue());
            i9++;
        }
    }

    public final void R(int i8, boolean z7, Object obj, C.a aVar) {
        this.f11292a.M0(i8, 2);
        this.f11292a.O0(C.b(aVar, Boolean.valueOf(z7), obj));
        C.e(this.f11292a, aVar, Boolean.valueOf(z7), obj);
    }

    public final void S(int i8, C.a aVar, Map map) {
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
            this.f11292a.M0(i8, 2);
            this.f11292a.O0(C.b(aVar, Integer.valueOf(i11), obj));
            C.e(this.f11292a, aVar, Integer.valueOf(i11), obj);
        }
    }

    public final void T(int i8, C.a aVar, Map map) {
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
            this.f11292a.M0(i8, 2);
            this.f11292a.O0(C.b(aVar, Long.valueOf(j8), obj));
            C.e(this.f11292a, aVar, Long.valueOf(j8), obj);
        }
    }

    public final void U(int i8, C.a aVar, Map map) {
        switch (a.f11293a[aVar.f11137a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    R(i8, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    R(i8, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                S(i8, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                T(i8, aVar, map);
                return;
            case 12:
                V(i8, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f11137a);
        }
    }

    public final void V(int i8, C.a aVar, Map map) {
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
            this.f11292a.M0(i8, 2);
            this.f11292a.O0(C.b(aVar, str, obj));
            C.e(this.f11292a, aVar, str, obj);
        }
    }

    public final void W(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.g0(i8, ((Double) list.get(i9)).doubleValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            i10 += AbstractC1107i.i(((Double) list.get(i11)).doubleValue());
        }
        this.f11292a.O0(i10);
        while (i9 < list.size()) {
            this.f11292a.h0(((Double) list.get(i9)).doubleValue());
            i9++;
        }
    }

    public final void X(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.i0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iK = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iK += AbstractC1107i.k(((Integer) list.get(i10)).intValue());
        }
        this.f11292a.O0(iK);
        while (i9 < list.size()) {
            this.f11292a.j0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public final void Y(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.k0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iM = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iM += AbstractC1107i.m(((Integer) list.get(i10)).intValue());
        }
        this.f11292a.O0(iM);
        while (i9 < list.size()) {
            this.f11292a.l0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    public final void Z(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.m0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iO = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iO += AbstractC1107i.o(((Long) list.get(i10)).longValue());
        }
        this.f11292a.O0(iO);
        while (i9 < list.size()) {
            this.f11292a.n0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void a(int i8, List list, boolean z7) {
        a0(i8, list, z7);
    }

    public final void a0(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.o0(i8, ((Float) list.get(i9)).floatValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iQ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iQ += AbstractC1107i.q(((Float) list.get(i10)).floatValue());
        }
        this.f11292a.O0(iQ);
        while (i9 < list.size()) {
            this.f11292a.p0(((Float) list.get(i9)).floatValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void b(int i8, int i9) {
        this.f11292a.N0(i8, i9);
    }

    public final void b0(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.u0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iV = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iV += AbstractC1107i.v(((Integer) list.get(i10)).intValue());
        }
        this.f11292a.O0(iV);
        while (i9 < list.size()) {
            this.f11292a.v0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public final void c(int i8, Object obj) {
        if (obj instanceof AbstractC1104f) {
            this.f11292a.B0(i8, (AbstractC1104f) obj);
        } else {
            this.f11292a.A0(i8, (J) obj);
        }
    }

    public final void c0(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.w0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iX = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iX += AbstractC1107i.x(((Long) list.get(i10)).longValue());
        }
        this.f11292a.O0(iX);
        while (i9 < list.size()) {
            this.f11292a.x0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void d(int i8, int i9) {
        this.f11292a.k0(i8, i9);
    }

    public final void d0(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.C0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iF = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iF += AbstractC1107i.F(((Integer) list.get(i10)).intValue());
        }
        this.f11292a.O0(iF);
        while (i9 < list.size()) {
            this.f11292a.D0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void e(int i8, double d8) {
        this.f11292a.g0(i8, d8);
    }

    public final void e0(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.E0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iH = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iH += AbstractC1107i.H(((Long) list.get(i10)).longValue());
        }
        this.f11292a.O0(iH);
        while (i9 < list.size()) {
            this.f11292a.F0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void f(int i8, List list, boolean z7) {
        e0(i8, list, z7);
    }

    public void f0(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.G0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iJ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iJ += AbstractC1107i.J(((Integer) list.get(i10)).intValue());
        }
        this.f11292a.O0(iJ);
        while (i9 < list.size()) {
            this.f11292a.H0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void g(int i8, List list, boolean z7) {
        i0(i8, list, z7);
    }

    public final void g0(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.I0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iL = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iL += AbstractC1107i.L(((Long) list.get(i10)).longValue());
        }
        this.f11292a.O0(iL);
        while (i9 < list.size()) {
            this.f11292a.J0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void h(int i8, long j8) {
        this.f11292a.m0(i8, j8);
    }

    public void h0(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.N0(i8, ((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iQ = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iQ += AbstractC1107i.Q(((Integer) list.get(i10)).intValue());
        }
        this.f11292a.O0(iQ);
        while (i9 < list.size()) {
            this.f11292a.O0(((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public l0.a i() {
        return l0.a.ASCENDING;
    }

    public final void i0(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f11292a.P0(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        this.f11292a.M0(i8, 2);
        int iS = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iS += AbstractC1107i.S(((Long) list.get(i10)).longValue());
        }
        this.f11292a.O0(iS);
        while (i9 < list.size()) {
            this.f11292a.Q0(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void j(int i8, List list) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.f11292a.K0(i8, (String) list.get(i9));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void k(int i8, String str) {
        this.f11292a.K0(i8, str);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void l(int i8, long j8) {
        this.f11292a.P0(i8, j8);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void m(int i8, List list, boolean z7) {
        b0(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void n(int i8, long j8) {
        this.f11292a.w0(i8, j8);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void o(int i8, boolean z7) {
        this.f11292a.a0(i8, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void p(int i8, int i9) {
        this.f11292a.C0(i8, i9);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void q(int i8) {
        this.f11292a.M0(i8, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void r(int i8, int i9) {
        this.f11292a.u0(i8, i9);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void s(int i8, List list, boolean z7) {
        Z(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void t(int i8, List list, boolean z7) {
        d0(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void u(int i8, long j8) {
        this.f11292a.E0(i8, j8);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void v(int i8, List list, boolean z7) {
        Y(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void w(int i8, List list, boolean z7) {
        Q(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void x(int i8, List list, boolean z7) {
        h0(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void y(int i8, List list, boolean z7) {
        g0(i8, list, z7);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public void z(int i8, long j8) {
        this.f11292a.I0(i8, j8);
    }
}
