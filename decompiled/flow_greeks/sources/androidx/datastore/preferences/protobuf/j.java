package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.c0;
import androidx.datastore.preferences.protobuf.j1;
import androidx.datastore.preferences.protobuf.k1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f1762a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1763a;

        static {
            int[] iArr = new int[j1.b.values().length];
            f1763a = iArr;
            try {
                iArr[j1.b.f1775j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1763a[j1.b.f1774i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1763a[j1.b.f1772g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1763a[j1.b.f1782q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1763a[j1.b.f1784s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1763a[j1.b.f1780o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1763a[j1.b.f1773h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1763a[j1.b.f1770e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1763a[j1.b.f1783r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1763a[j1.b.f1785t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1763a[j1.b.f1771f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1763a[j1.b.f1776k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public j(i iVar) {
        i iVar2 = (i) u.b(iVar, "output");
        this.f1762a = iVar2;
        iVar2.f1754a = this;
    }

    public static j P(i iVar) {
        j jVar = iVar.f1754a;
        return jVar != null ? jVar : new j(iVar);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void A(int i10, float f10) {
        this.f1762a.o0(i10, f10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void B(int i10) {
        this.f1762a.M0(i10, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void C(int i10, List list, boolean z10) {
        f0(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void D(int i10, int i11) {
        this.f1762a.i0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void E(int i10, List list, boolean z10) {
        c0(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void F(int i10, List list, boolean z10) {
        X(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void G(int i10, List list, boolean z10) {
        W(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void H(int i10, int i11) {
        this.f1762a.G0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void I(int i10, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f1762a.e0(i10, (f) list.get(i11));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void J(int i10, List list, x0 x0Var) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            M(i10, list.get(i11), x0Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void K(int i10, List list, x0 x0Var) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            O(i10, list.get(i11), x0Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void L(int i10, f fVar) {
        this.f1762a.e0(i10, fVar);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void M(int i10, Object obj, x0 x0Var) {
        this.f1762a.y0(i10, (j0) obj, x0Var);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void N(int i10, c0.a aVar, Map map) {
        if (this.f1762a.X()) {
            U(i10, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f1762a.M0(i10, 2);
            this.f1762a.O0(c0.b(aVar, entry.getKey(), entry.getValue()));
            c0.e(this.f1762a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void O(int i10, Object obj, x0 x0Var) {
        this.f1762a.r0(i10, (j0) obj, x0Var);
    }

    public final void Q(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.a0(i10, ((Boolean) list.get(i11)).booleanValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iD = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iD += i.d(((Boolean) list.get(i12)).booleanValue());
        }
        this.f1762a.O0(iD);
        while (i11 < list.size()) {
            this.f1762a.b0(((Boolean) list.get(i11)).booleanValue());
            i11++;
        }
    }

    public final void R(int i10, boolean z10, Object obj, c0.a aVar) {
        this.f1762a.M0(i10, 2);
        this.f1762a.O0(c0.b(aVar, Boolean.valueOf(z10), obj));
        c0.e(this.f1762a, aVar, Boolean.valueOf(z10), obj);
    }

    public final void S(int i10, c0.a aVar, Map map) {
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
            this.f1762a.M0(i10, 2);
            this.f1762a.O0(c0.b(aVar, Integer.valueOf(i13), obj));
            c0.e(this.f1762a, aVar, Integer.valueOf(i13), obj);
        }
    }

    public final void T(int i10, c0.a aVar, Map map) {
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
            this.f1762a.M0(i10, 2);
            this.f1762a.O0(c0.b(aVar, Long.valueOf(j10), obj));
            c0.e(this.f1762a, aVar, Long.valueOf(j10), obj);
        }
    }

    public final void U(int i10, c0.a aVar, Map map) {
        switch (a.f1763a[aVar.f1670a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    R(i10, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    R(i10, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                S(i10, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                T(i10, aVar, map);
                return;
            case 12:
                V(i10, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f1670a);
        }
    }

    public final void V(int i10, c0.a aVar, Map map) {
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
            this.f1762a.M0(i10, 2);
            this.f1762a.O0(c0.b(aVar, str, obj));
            c0.e(this.f1762a, aVar, str, obj);
        }
    }

    public final void W(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.g0(i10, ((Double) list.get(i11)).doubleValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += i.i(((Double) list.get(i13)).doubleValue());
        }
        this.f1762a.O0(i12);
        while (i11 < list.size()) {
            this.f1762a.h0(((Double) list.get(i11)).doubleValue());
            i11++;
        }
    }

    public final void X(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.i0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iK = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iK += i.k(((Integer) list.get(i12)).intValue());
        }
        this.f1762a.O0(iK);
        while (i11 < list.size()) {
            this.f1762a.j0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public final void Y(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.k0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iM = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM += i.m(((Integer) list.get(i12)).intValue());
        }
        this.f1762a.O0(iM);
        while (i11 < list.size()) {
            this.f1762a.l0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public final void Z(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.m0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iO = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iO += i.o(((Long) list.get(i12)).longValue());
        }
        this.f1762a.O0(iO);
        while (i11 < list.size()) {
            this.f1762a.n0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void a(int i10, List list, boolean z10) {
        a0(i10, list, z10);
    }

    public final void a0(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.o0(i10, ((Float) list.get(i11)).floatValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iQ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iQ += i.q(((Float) list.get(i12)).floatValue());
        }
        this.f1762a.O0(iQ);
        while (i11 < list.size()) {
            this.f1762a.p0(((Float) list.get(i11)).floatValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void b(int i10, int i11) {
        this.f1762a.N0(i10, i11);
    }

    public final void b0(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.u0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iV = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iV += i.v(((Integer) list.get(i12)).intValue());
        }
        this.f1762a.O0(iV);
        while (i11 < list.size()) {
            this.f1762a.v0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public final void c(int i10, Object obj) {
        if (obj instanceof f) {
            this.f1762a.B0(i10, (f) obj);
        } else {
            this.f1762a.A0(i10, (j0) obj);
        }
    }

    public final void c0(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.w0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iX = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iX += i.x(((Long) list.get(i12)).longValue());
        }
        this.f1762a.O0(iX);
        while (i11 < list.size()) {
            this.f1762a.x0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void d(int i10, int i11) {
        this.f1762a.k0(i10, i11);
    }

    public final void d0(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.C0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iF = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iF += i.F(((Integer) list.get(i12)).intValue());
        }
        this.f1762a.O0(iF);
        while (i11 < list.size()) {
            this.f1762a.D0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void e(int i10, double d10) {
        this.f1762a.g0(i10, d10);
    }

    public final void e0(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.E0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iH = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iH += i.H(((Long) list.get(i12)).longValue());
        }
        this.f1762a.O0(iH);
        while (i11 < list.size()) {
            this.f1762a.F0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void f(int i10, List list, boolean z10) {
        e0(i10, list, z10);
    }

    public void f0(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.G0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iJ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iJ += i.J(((Integer) list.get(i12)).intValue());
        }
        this.f1762a.O0(iJ);
        while (i11 < list.size()) {
            this.f1762a.H0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void g(int i10, List list, boolean z10) {
        i0(i10, list, z10);
    }

    public final void g0(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.I0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iL = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iL += i.L(((Long) list.get(i12)).longValue());
        }
        this.f1762a.O0(iL);
        while (i11 < list.size()) {
            this.f1762a.J0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void h(int i10, long j10) {
        this.f1762a.m0(i10, j10);
    }

    public void h0(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.N0(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iQ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iQ += i.Q(((Integer) list.get(i12)).intValue());
        }
        this.f1762a.O0(iQ);
        while (i11 < list.size()) {
            this.f1762a.O0(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public k1.a i() {
        return k1.a.ASCENDING;
    }

    public final void i0(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f1762a.P0(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f1762a.M0(i10, 2);
        int iS = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iS += i.S(((Long) list.get(i12)).longValue());
        }
        this.f1762a.O0(iS);
        while (i11 < list.size()) {
            this.f1762a.Q0(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void j(int i10, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f1762a.K0(i10, (String) list.get(i11));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void k(int i10, String str) {
        this.f1762a.K0(i10, str);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void l(int i10, long j10) {
        this.f1762a.P0(i10, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void m(int i10, List list, boolean z10) {
        b0(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void n(int i10, long j10) {
        this.f1762a.w0(i10, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void o(int i10, boolean z10) {
        this.f1762a.a0(i10, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void p(int i10, int i11) {
        this.f1762a.C0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void q(int i10) {
        this.f1762a.M0(i10, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void r(int i10, int i11) {
        this.f1762a.u0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void s(int i10, List list, boolean z10) {
        Z(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void t(int i10, List list, boolean z10) {
        d0(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void u(int i10, long j10) {
        this.f1762a.E0(i10, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void v(int i10, List list, boolean z10) {
        Y(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void w(int i10, List list, boolean z10) {
        Q(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void x(int i10, List list, boolean z10) {
        h0(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void y(int i10, List list, boolean z10) {
        g0(i10, list, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.k1
    public void z(int i10, long j10) {
        this.f1762a.I0(i10, j10);
    }
}
