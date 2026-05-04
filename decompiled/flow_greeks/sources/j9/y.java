package j9;

import bb.d0;
import com.google.android.gms.common.api.a;
import com.google.protobuf.d1;
import com.google.protobuf.s1;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import n9.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f14284a = (d0) d0.y0().C(Double.NaN).n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f14285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d0 f14286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f14287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d0 f14288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d0 f14289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d0 f14290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static d0 f14291h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static d0 f14292i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static d0 f14293j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static d0 f14294k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static d0 f14295l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static d0 f14296m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static d0 f14297n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static d0 f14298o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static d0 f14299p;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14300a;

        static {
            int[] iArr = new int[d0.c.values().length];
            f14300a = iArr;
            try {
                iArr[d0.c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14300a[d0.c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14300a[d0.c.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14300a[d0.c.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14300a[d0.c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14300a[d0.c.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14300a[d0.c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14300a[d0.c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14300a[d0.c.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14300a[d0.c.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f14300a[d0.c.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        d0 d0Var = (d0) d0.y0().H(d1.NULL_VALUE).n();
        f14285b = d0Var;
        f14286c = d0Var;
        d0 d0Var2 = (d0) d0.y0().J("__max__").n();
        f14287d = d0Var2;
        f14288e = (d0) d0.y0().F(bb.u.j0().z("__type__", d0Var2)).n();
        d0 d0Var3 = (d0) d0.y0().J("__vector__").n();
        f14289f = d0Var3;
        f14290g = (d0) d0.y0().F(bb.u.j0().z("__type__", d0Var3).z("value", (d0) d0.y0().y(bb.b.j0()).n())).n();
        f14291h = (d0) d0.y0().A(false).n();
        f14292i = (d0) d0.y0().C(Double.NaN).n();
        f14293j = (d0) d0.y0().K(s1.f0().y(Long.MIN_VALUE)).n();
        f14294k = (d0) d0.y0().J("").n();
        f14295l = (d0) d0.y0().B(com.google.protobuf.i.f6998b).n();
        f14296m = H(f.f14237c, k.c());
        f14297n = (d0) d0.y0().D(kb.a.f0().x(-90.0d).y(-180.0d)).n();
        f14298o = (d0) d0.y0().z(bb.b.g0()).n();
        f14299p = (d0) d0.y0().G(bb.u.b0()).n();
    }

    public static boolean A(d0 d0Var) {
        return d0Var != null && d0Var.w0() == d0.c.NULL_VALUE;
    }

    public static boolean B(d0 d0Var) {
        return w(d0Var) || v(d0Var);
    }

    public static boolean C(d0 d0Var) {
        return d0Var != null && d0Var.w0() == d0.c.REFERENCE_VALUE;
    }

    public static boolean D(d0 d0Var) {
        return f14289f.equals(d0Var.s0().d0().get("__type__"));
    }

    public static int E(d0 d0Var, boolean z10, d0 d0Var2, boolean z11) {
        int i10 = i(d0Var, d0Var2);
        if (i10 != 0) {
            return i10;
        }
        if (!z10 || z11) {
            return (z10 || !z11) ? 0 : 1;
        }
        return -1;
    }

    public static boolean F(d0 d0Var, d0 d0Var2) {
        d0.c cVarW0 = d0Var.w0();
        d0.c cVar = d0.c.INTEGER_VALUE;
        if (cVarW0 == cVar && d0Var2.w0() == cVar) {
            return d0Var.r0() == d0Var2.r0();
        }
        d0.c cVarW02 = d0Var.w0();
        d0.c cVar2 = d0.c.DOUBLE_VALUE;
        return cVarW02 == cVar2 && d0Var2.w0() == cVar2 && Double.doubleToLongBits(d0Var.p0()) == Double.doubleToLongBits(d0Var2.p0());
    }

    public static boolean G(d0 d0Var, d0 d0Var2) {
        bb.u uVarS0 = d0Var.s0();
        bb.u uVarS02 = d0Var2.s0();
        if (uVarS0.c0() != uVarS02.c0()) {
            return false;
        }
        for (Map.Entry entry : uVarS0.d0().entrySet()) {
            if (!r((d0) entry.getValue(), (d0) uVarS02.d0().get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static d0 H(f fVar, k kVar) {
        return (d0) d0.y0().I(String.format("projects/%s/databases/%s/documents/%s", fVar.i(), fVar.h(), kVar.toString())).n();
    }

    public static int I(d0 d0Var) {
        switch (a.f14300a[d0Var.w0().ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                if (u.c(d0Var)) {
                    return 4;
                }
                return y(d0Var) ? a.e.API_PRIORITY_OTHER : D(d0Var) ? 10 : 11;
            default:
                throw n9.b.a("Invalid value type: " + d0Var.w0(), new Object[0]);
        }
    }

    public static int J(d0 d0Var, boolean z10, d0 d0Var2, boolean z11) {
        int i10 = i(d0Var, d0Var2);
        if (i10 != 0) {
            return i10;
        }
        if (!z10 || z11) {
            return (z10 || !z11) ? 0 : -1;
        }
        return 1;
    }

    public static boolean a(d0 d0Var, d0 d0Var2) {
        bb.b bVarL0 = d0Var.l0();
        bb.b bVarL02 = d0Var2.l0();
        if (bVarL0.i0() != bVarL02.i0()) {
            return false;
        }
        for (int i10 = 0; i10 < bVarL0.i0(); i10++) {
            if (!r(bVarL0.h0(i10), bVarL02.h0(i10))) {
                return false;
            }
        }
        return true;
    }

    public static String b(d0 d0Var) {
        StringBuilder sb2 = new StringBuilder();
        h(sb2, d0Var);
        return sb2.toString();
    }

    public static void c(StringBuilder sb2, bb.b bVar) {
        sb2.append("[");
        for (int i10 = 0; i10 < bVar.i0(); i10++) {
            h(sb2, bVar.h0(i10));
            if (i10 != bVar.i0() - 1) {
                sb2.append(com.amazon.a.a.o.b.f.f4598a);
            }
        }
        sb2.append("]");
    }

    public static void d(StringBuilder sb2, kb.a aVar) {
        sb2.append(String.format("geo(%s,%s)", Double.valueOf(aVar.d0()), Double.valueOf(aVar.e0())));
    }

    public static void e(StringBuilder sb2, bb.u uVar) {
        ArrayList<String> arrayList = new ArrayList(uVar.d0().keySet());
        Collections.sort(arrayList);
        sb2.append("{");
        boolean z10 = true;
        for (String str : arrayList) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(com.amazon.a.a.o.b.f.f4598a);
            }
            sb2.append(str);
            sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            h(sb2, uVar.f0(str));
        }
        sb2.append("}");
    }

    public static void f(StringBuilder sb2, d0 d0Var) {
        n9.b.d(C(d0Var), "Value should be a ReferenceValue", new Object[0]);
        sb2.append(k.i(d0Var.t0()));
    }

    public static void g(StringBuilder sb2, s1 s1Var) {
        sb2.append(String.format("time(%s,%s)", Long.valueOf(s1Var.e0()), Integer.valueOf(s1Var.d0())));
    }

    public static void h(StringBuilder sb2, d0 d0Var) {
        switch (a.f14300a[d0Var.w0().ordinal()]) {
            case 1:
                sb2.append("null");
                return;
            case 2:
                sb2.append(d0Var.m0());
                return;
            case 3:
                sb2.append(d0Var.r0());
                return;
            case 4:
                sb2.append(d0Var.p0());
                return;
            case 5:
                g(sb2, d0Var.v0());
                return;
            case 6:
                sb2.append(d0Var.u0());
                return;
            case 7:
                sb2.append(g0.v(d0Var.n0()));
                return;
            case 8:
                f(sb2, d0Var);
                return;
            case 9:
                d(sb2, d0Var.q0());
                return;
            case 10:
                c(sb2, d0Var.l0());
                return;
            case 11:
                e(sb2, d0Var.s0());
                return;
            default:
                throw n9.b.a("Invalid value type: " + d0Var.w0(), new Object[0]);
        }
    }

    public static int i(d0 d0Var, d0 d0Var2) {
        int I = I(d0Var);
        int I2 = I(d0Var2);
        if (I != I2) {
            return Integer.compare(I, I2);
        }
        if (I != Integer.MAX_VALUE) {
            switch (I) {
                case 0:
                    break;
                case 1:
                    return g0.h(d0Var.m0(), d0Var2.m0());
                case 2:
                    return m(d0Var, d0Var2);
                case 3:
                    return o(d0Var.v0(), d0Var2.v0());
                case 4:
                    return o(u.a(d0Var), u.a(d0Var2));
                case 5:
                    return g0.m(d0Var.u0(), d0Var2.u0());
                case 6:
                    return g0.j(d0Var.n0(), d0Var2.n0());
                case 7:
                    return n(d0Var.t0(), d0Var2.t0());
                case 8:
                    return k(d0Var.q0(), d0Var2.q0());
                case 9:
                    return j(d0Var.l0(), d0Var2.l0());
                case 10:
                    return p(d0Var.s0(), d0Var2.s0());
                case 11:
                    return l(d0Var.s0(), d0Var2.s0());
                default:
                    throw n9.b.a("Invalid value type: " + I, new Object[0]);
            }
        }
        return 0;
    }

    public static int j(bb.b bVar, bb.b bVar2) {
        int iMin = Math.min(bVar.i0(), bVar2.i0());
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = i(bVar.h0(i10), bVar2.h0(i10));
            if (i11 != 0) {
                return i11;
            }
        }
        return Integer.compare(bVar.i0(), bVar2.i0());
    }

    public static int k(kb.a aVar, kb.a aVar2) {
        int iK = g0.k(aVar.d0(), aVar2.d0());
        return iK == 0 ? g0.k(aVar.e0(), aVar2.e0()) : iK;
    }

    public static int l(bb.u uVar, bb.u uVar2) {
        Iterator it = new TreeMap(uVar.d0()).entrySet().iterator();
        Iterator it2 = new TreeMap(uVar2.d0()).entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int iM = g0.m((String) entry.getKey(), (String) entry2.getKey());
            if (iM != 0) {
                return iM;
            }
            int i10 = i((d0) entry.getValue(), (d0) entry2.getValue());
            if (i10 != 0) {
                return i10;
            }
        }
        return g0.h(it.hasNext(), it2.hasNext());
    }

    public static int m(d0 d0Var, d0 d0Var2) {
        d0.c cVarW0 = d0Var.w0();
        d0.c cVar = d0.c.DOUBLE_VALUE;
        if (cVarW0 == cVar) {
            double dP0 = d0Var.p0();
            if (d0Var2.w0() == cVar) {
                return g0.k(dP0, d0Var2.p0());
            }
            if (d0Var2.w0() == d0.c.INTEGER_VALUE) {
                return g0.l(dP0, d0Var2.r0());
            }
        } else {
            d0.c cVarW02 = d0Var.w0();
            d0.c cVar2 = d0.c.INTEGER_VALUE;
            if (cVarW02 == cVar2) {
                long jR0 = d0Var.r0();
                if (d0Var2.w0() == cVar2) {
                    return Long.compare(jR0, d0Var2.r0());
                }
                if (d0Var2.w0() == cVar) {
                    return g0.l(d0Var2.p0(), jR0) * (-1);
                }
            }
        }
        throw n9.b.a("Unexpected values: %s vs %s", d0Var, d0Var2);
    }

    public static int n(String str, String str2) {
        String[] strArrSplit = str.split("/", -1);
        String[] strArrSplit2 = str2.split("/", -1);
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iCompareTo = strArrSplit[i10].compareTo(strArrSplit2[i10]);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.compare(strArrSplit.length, strArrSplit2.length);
    }

    public static int o(s1 s1Var, s1 s1Var2) {
        int iCompare = Long.compare(s1Var.e0(), s1Var2.e0());
        return iCompare != 0 ? iCompare : Integer.compare(s1Var.d0(), s1Var2.d0());
    }

    public static int p(bb.u uVar, bb.u uVar2) {
        Map mapD0 = uVar.d0();
        Map mapD02 = uVar2.d0();
        bb.b bVarL0 = ((d0) mapD0.get("value")).l0();
        bb.b bVarL02 = ((d0) mapD02.get("value")).l0();
        int iCompare = Integer.compare(bVarL0.i0(), bVarL02.i0());
        return iCompare != 0 ? iCompare : j(bVarL0, bVarL02);
    }

    public static boolean q(bb.c cVar, d0 d0Var) {
        Iterator it = cVar.h().iterator();
        while (it.hasNext()) {
            if (r((d0) it.next(), d0Var)) {
                return true;
            }
        }
        return false;
    }

    public static boolean r(d0 d0Var, d0 d0Var2) {
        int I;
        if (d0Var == d0Var2) {
            return true;
        }
        if (d0Var == null || d0Var2 == null || (I = I(d0Var)) != I(d0Var2)) {
            return false;
        }
        if (I == 2) {
            return F(d0Var, d0Var2);
        }
        if (I == 4) {
            return u.a(d0Var).equals(u.a(d0Var2));
        }
        if (I == Integer.MAX_VALUE) {
            return true;
        }
        switch (I) {
            case 9:
                return a(d0Var, d0Var2);
            case 10:
            case 11:
                return G(d0Var, d0Var2);
            default:
                return d0Var.equals(d0Var2);
        }
    }

    public static d0 s(d0 d0Var) {
        switch (a.f14300a[d0Var.w0().ordinal()]) {
            case 1:
                return f14285b;
            case 2:
                return f14291h;
            case 3:
            case 4:
                return f14292i;
            case 5:
                return f14293j;
            case 6:
                return f14294k;
            case 7:
                return f14295l;
            case 8:
                return f14296m;
            case 9:
                return f14297n;
            case 10:
                return f14298o;
            case 11:
                return D(d0Var) ? f14290g : f14299p;
            default:
                throw new IllegalArgumentException("Unknown value type: " + d0Var.w0());
        }
    }

    public static d0 t(d0 d0Var) {
        switch (a.f14300a[d0Var.w0().ordinal()]) {
            case 1:
                return f14291h;
            case 2:
                return f14292i;
            case 3:
            case 4:
                return f14293j;
            case 5:
                return f14294k;
            case 6:
                return f14295l;
            case 7:
                return f14296m;
            case 8:
                return f14297n;
            case 9:
                return f14298o;
            case 10:
                return f14290g;
            case 11:
                return D(d0Var) ? f14299p : f14288e;
            default:
                throw new IllegalArgumentException("Unknown value type: " + d0Var.w0());
        }
    }

    public static boolean u(d0 d0Var) {
        return d0Var != null && d0Var.w0() == d0.c.ARRAY_VALUE;
    }

    public static boolean v(d0 d0Var) {
        return d0Var != null && d0Var.w0() == d0.c.DOUBLE_VALUE;
    }

    public static boolean w(d0 d0Var) {
        return d0Var != null && d0Var.w0() == d0.c.INTEGER_VALUE;
    }

    public static boolean x(d0 d0Var) {
        return d0Var != null && d0Var.w0() == d0.c.MAP_VALUE;
    }

    public static boolean y(d0 d0Var) {
        return f14287d.equals(d0Var.s0().d0().get("__type__"));
    }

    public static boolean z(d0 d0Var) {
        return d0Var != null && Double.isNaN(d0Var.p0());
    }
}
