package G3;

import K3.AbstractC0612b;
import K3.I;
import com.google.android.gms.common.api.a;
import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.e0;
import com.google.protobuf.t0;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import k4.C2105D;
import k4.C2111b;
import k4.C2130u;
import k4.InterfaceC2112c;
import v4.C2767a;

/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2105D f2481a = (C2105D) C2105D.y0().B(Double.NaN).n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2105D f2482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2105D f2483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2105D f2484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2105D f2485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2105D f2486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C2105D f2487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static C2105D f2488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static C2105D f2489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static C2105D f2490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static C2105D f2491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static C2105D f2492l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static C2105D f2493m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static C2105D f2494n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static C2105D f2495o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static C2105D f2496p;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2497a;

        static {
            int[] iArr = new int[C2105D.c.values().length];
            f2497a = iArr;
            try {
                iArr[C2105D.c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2497a[C2105D.c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2497a[C2105D.c.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2497a[C2105D.c.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2497a[C2105D.c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2497a[C2105D.c.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2497a[C2105D.c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2497a[C2105D.c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2497a[C2105D.c.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2497a[C2105D.c.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2497a[C2105D.c.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        C2105D c2105d = (C2105D) C2105D.y0().G(e0.NULL_VALUE).n();
        f2482b = c2105d;
        f2483c = c2105d;
        C2105D c2105d2 = (C2105D) C2105D.y0().I("__max__").n();
        f2484d = c2105d2;
        f2485e = (C2105D) C2105D.y0().E(C2130u.j0().y("__type__", c2105d2)).n();
        C2105D c2105d3 = (C2105D) C2105D.y0().I("__vector__").n();
        f2486f = c2105d3;
        f2487g = (C2105D) C2105D.y0().E(C2130u.j0().y("__type__", c2105d3).y("value", (C2105D) C2105D.y0().x(C2111b.j0()).n())).n();
        f2488h = (C2105D) C2105D.y0().z(false).n();
        f2489i = (C2105D) C2105D.y0().B(Double.NaN).n();
        f2490j = (C2105D) C2105D.y0().J(t0.f0().x(Long.MIN_VALUE)).n();
        f2491k = (C2105D) C2105D.y0().I("").n();
        f2492l = (C2105D) C2105D.y0().A(AbstractC1240i.f12650b).n();
        f2493m = H(f.f2436c, k.c());
        f2494n = (C2105D) C2105D.y0().C(C2767a.f0().w(-90.0d).x(-180.0d)).n();
        f2495o = (C2105D) C2105D.y0().y(C2111b.g0()).n();
        f2496p = (C2105D) C2105D.y0().F(C2130u.b0()).n();
    }

    public static boolean A(C2105D c2105d) {
        return c2105d != null && c2105d.w0() == C2105D.c.NULL_VALUE;
    }

    public static boolean B(C2105D c2105d) {
        return w(c2105d) || v(c2105d);
    }

    public static boolean C(C2105D c2105d) {
        return c2105d != null && c2105d.w0() == C2105D.c.REFERENCE_VALUE;
    }

    public static boolean D(C2105D c2105d) {
        return f2486f.equals(c2105d.s0().d0().get("__type__"));
    }

    public static int E(C2105D c2105d, boolean z7, C2105D c2105d2, boolean z8) {
        int i7 = i(c2105d, c2105d2);
        if (i7 != 0) {
            return i7;
        }
        if (!z7 || z8) {
            return (z7 || !z8) ? 0 : 1;
        }
        return -1;
    }

    public static boolean F(C2105D c2105d, C2105D c2105d2) {
        C2105D.c cVarW0 = c2105d.w0();
        C2105D.c cVar = C2105D.c.INTEGER_VALUE;
        if (cVarW0 == cVar && c2105d2.w0() == cVar) {
            return c2105d.r0() == c2105d2.r0();
        }
        C2105D.c cVarW02 = c2105d.w0();
        C2105D.c cVar2 = C2105D.c.DOUBLE_VALUE;
        return cVarW02 == cVar2 && c2105d2.w0() == cVar2 && Double.doubleToLongBits(c2105d.p0()) == Double.doubleToLongBits(c2105d2.p0());
    }

    public static boolean G(C2105D c2105d, C2105D c2105d2) {
        C2130u c2130uS0 = c2105d.s0();
        C2130u c2130uS02 = c2105d2.s0();
        if (c2130uS0.c0() != c2130uS02.c0()) {
            return false;
        }
        for (Map.Entry entry : c2130uS0.d0().entrySet()) {
            if (!r((C2105D) entry.getValue(), (C2105D) c2130uS02.d0().get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static C2105D H(f fVar, k kVar) {
        return (C2105D) C2105D.y0().H(String.format("projects/%s/databases/%s/documents/%s", fVar.i(), fVar.h(), kVar.toString())).n();
    }

    public static int I(C2105D c2105d) {
        switch (a.f2497a[c2105d.w0().ordinal()]) {
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
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return 8;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return 9;
            case 11:
                if (u.c(c2105d)) {
                    return 4;
                }
                return y(c2105d) ? a.e.API_PRIORITY_OTHER : D(c2105d) ? 10 : 11;
            default:
                throw AbstractC0612b.a("Invalid value type: " + c2105d.w0(), new Object[0]);
        }
    }

    public static int J(C2105D c2105d, boolean z7, C2105D c2105d2, boolean z8) {
        int i7 = i(c2105d, c2105d2);
        if (i7 != 0) {
            return i7;
        }
        if (!z7 || z8) {
            return (z7 || !z8) ? 0 : -1;
        }
        return 1;
    }

    public static boolean a(C2105D c2105d, C2105D c2105d2) {
        C2111b c2111bL0 = c2105d.l0();
        C2111b c2111bL02 = c2105d2.l0();
        if (c2111bL0.i0() != c2111bL02.i0()) {
            return false;
        }
        for (int i7 = 0; i7 < c2111bL0.i0(); i7++) {
            if (!r(c2111bL0.h0(i7), c2111bL02.h0(i7))) {
                return false;
            }
        }
        return true;
    }

    public static String b(C2105D c2105d) {
        StringBuilder sb = new StringBuilder();
        h(sb, c2105d);
        return sb.toString();
    }

    public static void c(StringBuilder sb, C2111b c2111b) {
        sb.append("[");
        for (int i7 = 0; i7 < c2111b.i0(); i7++) {
            h(sb, c2111b.h0(i7));
            if (i7 != c2111b.i0() - 1) {
                sb.append(com.amazon.a.a.o.b.f.f9989a);
            }
        }
        sb.append("]");
    }

    public static void d(StringBuilder sb, C2767a c2767a) {
        sb.append(String.format("geo(%s,%s)", Double.valueOf(c2767a.d0()), Double.valueOf(c2767a.e0())));
    }

    public static void e(StringBuilder sb, C2130u c2130u) {
        ArrayList<String> arrayList = new ArrayList(c2130u.d0().keySet());
        Collections.sort(arrayList);
        sb.append("{");
        boolean z7 = true;
        for (String str : arrayList) {
            if (z7) {
                z7 = false;
            } else {
                sb.append(com.amazon.a.a.o.b.f.f9989a);
            }
            sb.append(str);
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            h(sb, c2130u.f0(str));
        }
        sb.append("}");
    }

    public static void f(StringBuilder sb, C2105D c2105d) {
        AbstractC0612b.d(C(c2105d), "Value should be a ReferenceValue", new Object[0]);
        sb.append(k.i(c2105d.t0()));
    }

    public static void g(StringBuilder sb, t0 t0Var) {
        sb.append(String.format("time(%s,%s)", Long.valueOf(t0Var.e0()), Integer.valueOf(t0Var.d0())));
    }

    public static void h(StringBuilder sb, C2105D c2105d) {
        switch (a.f2497a[c2105d.w0().ordinal()]) {
            case 1:
                sb.append("null");
                return;
            case 2:
                sb.append(c2105d.m0());
                return;
            case 3:
                sb.append(c2105d.r0());
                return;
            case 4:
                sb.append(c2105d.p0());
                return;
            case 5:
                g(sb, c2105d.v0());
                return;
            case 6:
                sb.append(c2105d.u0());
                return;
            case 7:
                sb.append(I.C(c2105d.n0()));
                return;
            case 8:
                f(sb, c2105d);
                return;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                d(sb, c2105d.q0());
                return;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                c(sb, c2105d.l0());
                return;
            case 11:
                e(sb, c2105d.s0());
                return;
            default:
                throw AbstractC0612b.a("Invalid value type: " + c2105d.w0(), new Object[0]);
        }
    }

    public static int i(C2105D c2105d, C2105D c2105d2) {
        int I6 = I(c2105d);
        int I7 = I(c2105d2);
        if (I6 != I7) {
            return I.l(I6, I7);
        }
        if (I6 != Integer.MAX_VALUE) {
            switch (I6) {
                case 0:
                    break;
                case 1:
                    return I.h(c2105d.m0(), c2105d2.m0());
                case 2:
                    return m(c2105d, c2105d2);
                case 3:
                    return o(c2105d.v0(), c2105d2.v0());
                case 4:
                    return o(u.a(c2105d), u.a(c2105d2));
                case 5:
                    return I.o(c2105d.u0(), c2105d2.u0());
                case 6:
                    return I.j(c2105d.n0(), c2105d2.n0());
                case 7:
                    return n(c2105d.t0(), c2105d2.t0());
                case 8:
                    return k(c2105d.q0(), c2105d2.q0());
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    return j(c2105d.l0(), c2105d2.l0());
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    return p(c2105d.s0(), c2105d2.s0());
                case 11:
                    return l(c2105d.s0(), c2105d2.s0());
                default:
                    throw AbstractC0612b.a("Invalid value type: " + I6, new Object[0]);
            }
        }
        return 0;
    }

    public static int j(C2111b c2111b, C2111b c2111b2) {
        int iMin = Math.min(c2111b.i0(), c2111b2.i0());
        for (int i7 = 0; i7 < iMin; i7++) {
            int i8 = i(c2111b.h0(i7), c2111b2.h0(i7));
            if (i8 != 0) {
                return i8;
            }
        }
        return I.l(c2111b.i0(), c2111b2.i0());
    }

    public static int k(C2767a c2767a, C2767a c2767a2) {
        int iK = I.k(c2767a.d0(), c2767a2.d0());
        return iK == 0 ? I.k(c2767a.e0(), c2767a2.e0()) : iK;
    }

    public static int l(C2130u c2130u, C2130u c2130u2) {
        Iterator it = new TreeMap(c2130u.d0()).entrySet().iterator();
        Iterator it2 = new TreeMap(c2130u2.d0()).entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int iO = I.o((String) entry.getKey(), (String) entry2.getKey());
            if (iO != 0) {
                return iO;
            }
            int i7 = i((C2105D) entry.getValue(), (C2105D) entry2.getValue());
            if (i7 != 0) {
                return i7;
            }
        }
        return I.h(it.hasNext(), it2.hasNext());
    }

    public static int m(C2105D c2105d, C2105D c2105d2) {
        C2105D.c cVarW0 = c2105d.w0();
        C2105D.c cVar = C2105D.c.DOUBLE_VALUE;
        if (cVarW0 == cVar) {
            double dP0 = c2105d.p0();
            if (c2105d2.w0() == cVar) {
                return I.k(dP0, c2105d2.p0());
            }
            if (c2105d2.w0() == C2105D.c.INTEGER_VALUE) {
                return I.n(dP0, c2105d2.r0());
            }
        } else {
            C2105D.c cVarW02 = c2105d.w0();
            C2105D.c cVar2 = C2105D.c.INTEGER_VALUE;
            if (cVarW02 == cVar2) {
                long jR0 = c2105d.r0();
                if (c2105d2.w0() == cVar2) {
                    return I.m(jR0, c2105d2.r0());
                }
                if (c2105d2.w0() == cVar) {
                    return I.n(c2105d2.p0(), jR0) * (-1);
                }
            }
        }
        throw AbstractC0612b.a("Unexpected values: %s vs %s", c2105d, c2105d2);
    }

    public static int n(String str, String str2) {
        String[] strArrSplit = str.split("/", -1);
        String[] strArrSplit2 = str2.split("/", -1);
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i7 = 0; i7 < iMin; i7++) {
            int iCompareTo = strArrSplit[i7].compareTo(strArrSplit2[i7]);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return I.l(strArrSplit.length, strArrSplit2.length);
    }

    public static int o(t0 t0Var, t0 t0Var2) {
        int iM = I.m(t0Var.e0(), t0Var2.e0());
        return iM != 0 ? iM : I.l(t0Var.d0(), t0Var2.d0());
    }

    public static int p(C2130u c2130u, C2130u c2130u2) {
        Map mapD0 = c2130u.d0();
        Map mapD02 = c2130u2.d0();
        C2111b c2111bL0 = ((C2105D) mapD0.get("value")).l0();
        C2111b c2111bL02 = ((C2105D) mapD02.get("value")).l0();
        int iL = I.l(c2111bL0.i0(), c2111bL02.i0());
        return iL != 0 ? iL : j(c2111bL0, c2111bL02);
    }

    public static boolean q(InterfaceC2112c interfaceC2112c, C2105D c2105d) {
        Iterator it = interfaceC2112c.g().iterator();
        while (it.hasNext()) {
            if (r((C2105D) it.next(), c2105d)) {
                return true;
            }
        }
        return false;
    }

    public static boolean r(C2105D c2105d, C2105D c2105d2) {
        int I6;
        if (c2105d == c2105d2) {
            return true;
        }
        if (c2105d == null || c2105d2 == null || (I6 = I(c2105d)) != I(c2105d2)) {
            return false;
        }
        if (I6 == 2) {
            return F(c2105d, c2105d2);
        }
        if (I6 == 4) {
            return u.a(c2105d).equals(u.a(c2105d2));
        }
        if (I6 == Integer.MAX_VALUE) {
            return true;
        }
        switch (I6) {
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return a(c2105d, c2105d2);
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
                return G(c2105d, c2105d2);
            default:
                return c2105d.equals(c2105d2);
        }
    }

    public static C2105D s(C2105D c2105d) {
        switch (a.f2497a[c2105d.w0().ordinal()]) {
            case 1:
                return f2482b;
            case 2:
                return f2488h;
            case 3:
            case 4:
                return f2489i;
            case 5:
                return f2490j;
            case 6:
                return f2491k;
            case 7:
                return f2492l;
            case 8:
                return f2493m;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return f2494n;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return f2495o;
            case 11:
                return D(c2105d) ? f2487g : f2496p;
            default:
                throw new IllegalArgumentException("Unknown value type: " + c2105d.w0());
        }
    }

    public static C2105D t(C2105D c2105d) {
        switch (a.f2497a[c2105d.w0().ordinal()]) {
            case 1:
                return f2488h;
            case 2:
                return f2489i;
            case 3:
            case 4:
                return f2490j;
            case 5:
                return f2491k;
            case 6:
                return f2492l;
            case 7:
                return f2493m;
            case 8:
                return f2494n;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return f2495o;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return f2487g;
            case 11:
                return D(c2105d) ? f2496p : f2485e;
            default:
                throw new IllegalArgumentException("Unknown value type: " + c2105d.w0());
        }
    }

    public static boolean u(C2105D c2105d) {
        return c2105d != null && c2105d.w0() == C2105D.c.ARRAY_VALUE;
    }

    public static boolean v(C2105D c2105d) {
        return c2105d != null && c2105d.w0() == C2105D.c.DOUBLE_VALUE;
    }

    public static boolean w(C2105D c2105d) {
        return c2105d != null && c2105d.w0() == C2105D.c.INTEGER_VALUE;
    }

    public static boolean x(C2105D c2105d) {
        return c2105d != null && c2105d.w0() == C2105D.c.MAP_VALUE;
    }

    public static boolean y(C2105D c2105d) {
        return f2484d.equals(c2105d.s0().d0().get("__type__"));
    }

    public static boolean z(C2105D c2105d) {
        return c2105d != null && Double.isNaN(c2105d.p0());
    }
}
