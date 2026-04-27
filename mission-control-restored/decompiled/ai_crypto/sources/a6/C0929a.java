package a6;

import W5.j;
import W5.l;
import Z5.u;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: a6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0929a implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0116a f6400b = new C0116a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f6401c = l(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f6402d = c.j(4611686018427387903L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f6403e = c.j(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6404a;

    /* JADX INFO: renamed from: a6.a$a, reason: collision with other inner class name */
    public static final class C0116a {
        public /* synthetic */ C0116a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final long a() {
            return C0929a.f6402d;
        }

        public final long b() {
            return C0929a.f6401c;
        }

        public final long c(String value) {
            r.f(value, "value");
            try {
                return c.p(value, true);
            } catch (IllegalArgumentException e7) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e7);
            }
        }

        public C0116a() {
        }
    }

    public /* synthetic */ C0929a(long j7) {
        this.f6404a = j7;
    }

    public static final boolean A(long j7) {
        return !D(j7);
    }

    public static final boolean B(long j7) {
        return (((int) j7) & 1) == 1;
    }

    public static final boolean C(long j7) {
        return (((int) j7) & 1) == 0;
    }

    public static final boolean D(long j7) {
        return j7 == f6402d || j7 == f6403e;
    }

    public static final boolean E(long j7) {
        return j7 < 0;
    }

    public static final boolean F(long j7) {
        return j7 > 0;
    }

    public static final long G(long j7, long j8) {
        if (D(j7)) {
            if (A(j8) || (j8 ^ j7) >= 0) {
                return j7;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (D(j8)) {
            return j8;
        }
        if ((((int) j7) & 1) != (((int) j8) & 1)) {
            return B(j7) ? c(j7, y(j7), y(j8)) : c(j7, y(j8), y(j7));
        }
        long jY = y(j7) + y(j8);
        return C(j7) ? c.m(jY) : c.k(jY);
    }

    public static final long H(long j7, int i7) {
        if (D(j7)) {
            if (i7 != 0) {
                return i7 > 0 ? j7 : L(j7);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i7 == 0) {
            return f6401c;
        }
        long jY = y(j7);
        long j8 = i7;
        long j9 = jY * j8;
        if (!C(j7)) {
            return j9 / j8 == jY ? c.j(l.h(j9, new j(-4611686018427387903L, 4611686018427387903L))) : S5.b.b(jY) * S5.b.a(i7) > 0 ? f6402d : f6403e;
        }
        if (-2147483647L <= jY && jY < 2147483648L) {
            return c.l(j9);
        }
        if (j9 / j8 == jY) {
            return c.m(j9);
        }
        long jO = c.o(jY);
        long j10 = jO * j8;
        long jO2 = c.o((jY - c.n(jO)) * j8) + j10;
        return (j10 / j8 != jO || (jO2 ^ j10) < 0) ? S5.b.b(jY) * S5.b.a(i7) > 0 ? f6402d : f6403e : c.j(l.h(jO2, new j(-4611686018427387903L, 4611686018427387903L)));
    }

    public static final String I(long j7) {
        StringBuilder sb = new StringBuilder();
        if (E(j7)) {
            sb.append('-');
        }
        sb.append("PT");
        long jN = n(j7);
        long jQ = q(jN);
        int iU = u(jN);
        int iW = w(jN);
        int iV = v(jN);
        if (D(j7)) {
            jQ = 9999999999999L;
        }
        boolean z7 = false;
        boolean z8 = jQ != 0;
        boolean z9 = (iW == 0 && iV == 0) ? false : true;
        if (iU != 0 || (z9 && z8)) {
            z7 = true;
        }
        if (z8) {
            sb.append(jQ);
            sb.append('H');
        }
        if (z7) {
            sb.append(iU);
            sb.append('M');
        }
        if (z9 || (!z8 && !z7)) {
            h(j7, sb, iW, iV, 9, "S", true);
        }
        String string = sb.toString();
        r.e(string, "toString(...)");
        return string;
    }

    public static final long J(long j7, d unit) {
        r.f(unit, "unit");
        if (j7 == f6402d) {
            return Long.MAX_VALUE;
        }
        if (j7 == f6403e) {
            return Long.MIN_VALUE;
        }
        return e.b(y(j7), x(j7), unit);
    }

    public static String K(long j7) {
        if (j7 == 0) {
            return "0s";
        }
        if (j7 == f6402d) {
            return "Infinity";
        }
        if (j7 == f6403e) {
            return "-Infinity";
        }
        boolean zE = E(j7);
        StringBuilder sb = new StringBuilder();
        if (zE) {
            sb.append('-');
        }
        long jN = n(j7);
        long jP = p(jN);
        int iO = o(jN);
        int iU = u(jN);
        int iW = w(jN);
        int iV = v(jN);
        int i7 = 0;
        boolean z7 = jP != 0;
        boolean z8 = iO != 0;
        boolean z9 = iU != 0;
        boolean z10 = (iW == 0 && iV == 0) ? false : true;
        if (z7) {
            sb.append(jP);
            sb.append('d');
            i7 = 1;
        }
        if (z8 || (z7 && (z9 || z10))) {
            int i8 = i7 + 1;
            if (i7 > 0) {
                sb.append(' ');
            }
            sb.append(iO);
            sb.append('h');
            i7 = i8;
        }
        if (z9 || (z10 && (z8 || z7))) {
            int i9 = i7 + 1;
            if (i7 > 0) {
                sb.append(' ');
            }
            sb.append(iU);
            sb.append('m');
            i7 = i9;
        }
        if (z10) {
            int i10 = i7 + 1;
            if (i7 > 0) {
                sb.append(' ');
            }
            if (iW != 0 || z7 || z8 || z9) {
                h(j7, sb, iW, iV, 9, "s", false);
            } else if (iV >= 1000000) {
                h(j7, sb, iV / 1000000, iV % 1000000, 6, "ms", false);
            } else if (iV >= 1000) {
                h(j7, sb, iV / 1000, iV % 1000, 3, "us", false);
            } else {
                sb.append(iV);
                sb.append("ns");
            }
            i7 = i10;
        }
        if (zE && i7 > 1) {
            sb.insert(1, '(').append(')');
        }
        String string = sb.toString();
        r.e(string, "toString(...)");
        return string;
    }

    public static final long L(long j7) {
        return c.i(-y(j7), ((int) j7) & 1);
    }

    public static final long c(long j7, long j8, long j9) {
        long jO = c.o(j9);
        long j10 = j8 + jO;
        if (-4611686018426L > j10 || j10 >= 4611686018427L) {
            return c.j(l.g(j10, -4611686018427387903L, 4611686018427387903L));
        }
        return c.l(c.n(j10) + (j9 - c.n(jO)));
    }

    public static final void h(long j7, StringBuilder sb, int i7, int i8, int i9, String str, boolean z7) {
        sb.append(i7);
        if (i8 != 0) {
            sb.append(com.amazon.a.a.o.c.a.b.f10001a);
            String strB0 = u.b0(String.valueOf(i8), i9, '0');
            int i10 = -1;
            int length = strB0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i11 = length - 1;
                    if (strB0.charAt(length) != '0') {
                        i10 = length;
                        break;
                    } else if (i11 < 0) {
                        break;
                    } else {
                        length = i11;
                    }
                }
            }
            int i12 = i10 + 1;
            if (z7 || i12 >= 3) {
                sb.append((CharSequence) strB0, 0, ((i10 + 3) / 3) * 3);
                r.e(sb, "append(...)");
            } else {
                sb.append((CharSequence) strB0, 0, i12);
                r.e(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ C0929a i(long j7) {
        return new C0929a(j7);
    }

    public static int k(long j7, long j8) {
        long j9 = j7 ^ j8;
        if (j9 < 0 || (((int) j9) & 1) == 0) {
            return r.h(j7, j8);
        }
        int i7 = (((int) j7) & 1) - (((int) j8) & 1);
        return E(j7) ? -i7 : i7;
    }

    public static long l(long j7) {
        if (b.a()) {
            if (C(j7)) {
                long jY = y(j7);
                if (-4611686018426999999L > jY || jY >= 4611686018427000000L) {
                    throw new AssertionError(y(j7) + " ns is out of nanoseconds range");
                }
            } else {
                long jY2 = y(j7);
                if (-4611686018427387903L > jY2 || jY2 >= 4611686018427387904L) {
                    throw new AssertionError(y(j7) + " ms is out of milliseconds range");
                }
                long jY3 = y(j7);
                if (-4611686018426L <= jY3 && jY3 < 4611686018427L) {
                    throw new AssertionError(y(j7) + " ms is denormalized");
                }
            }
        }
        return j7;
    }

    public static boolean m(long j7, Object obj) {
        return (obj instanceof C0929a) && j7 == ((C0929a) obj).M();
    }

    public static final long n(long j7) {
        return E(j7) ? L(j7) : j7;
    }

    public static final int o(long j7) {
        if (D(j7)) {
            return 0;
        }
        return (int) (q(j7) % ((long) 24));
    }

    public static final long p(long j7) {
        return J(j7, d.f6413h);
    }

    public static final long q(long j7) {
        return J(j7, d.f6412g);
    }

    public static final long r(long j7) {
        return (B(j7) && A(j7)) ? y(j7) : J(j7, d.f6409d);
    }

    public static final long s(long j7) {
        return J(j7, d.f6411f);
    }

    public static final long t(long j7) {
        return J(j7, d.f6410e);
    }

    public static final int u(long j7) {
        if (D(j7)) {
            return 0;
        }
        return (int) (s(j7) % ((long) 60));
    }

    public static final int v(long j7) {
        if (D(j7)) {
            return 0;
        }
        return (int) (B(j7) ? c.n(y(j7) % ((long) 1000)) : y(j7) % ((long) 1000000000));
    }

    public static final int w(long j7) {
        if (D(j7)) {
            return 0;
        }
        return (int) (t(j7) % ((long) 60));
    }

    public static final d x(long j7) {
        return C(j7) ? d.f6407b : d.f6409d;
    }

    public static final long y(long j7) {
        return j7 >> 1;
    }

    public static int z(long j7) {
        return Long.hashCode(j7);
    }

    public final /* synthetic */ long M() {
        return this.f6404a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return j(((C0929a) obj).M());
    }

    public boolean equals(Object obj) {
        return m(this.f6404a, obj);
    }

    public int hashCode() {
        return z(this.f6404a);
    }

    public int j(long j7) {
        return k(this.f6404a, j7);
    }

    public String toString() {
        return K(this.f6404a);
    }
}
