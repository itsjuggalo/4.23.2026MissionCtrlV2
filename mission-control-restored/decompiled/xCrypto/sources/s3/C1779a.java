package s3;

import k3.AbstractC1575b;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import o3.AbstractC1681l;
import o3.C1679j;
import r3.AbstractC1753A;

/* JADX INFO: renamed from: s3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1779a implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0237a f14679b = new C0237a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f14680c = m(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f14681d = c.j(4611686018427387903L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f14682e = c.j(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14683a;

    /* JADX INFO: renamed from: s3.a$a, reason: collision with other inner class name */
    public static final class C0237a {
        public /* synthetic */ C0237a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final long a() {
            return C1779a.f14681d;
        }

        public final long b() {
            return C1779a.f14680c;
        }

        public final long c(String value) {
            r.f(value, "value");
            try {
                return c.p(value, true);
            } catch (IllegalArgumentException e4) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e4);
            }
        }

        public C0237a() {
        }
    }

    public /* synthetic */ C1779a(long j4) {
        this.f14683a = j4;
    }

    public static int A(long j4) {
        return Long.hashCode(j4);
    }

    public static final boolean B(long j4) {
        return !E(j4);
    }

    public static final boolean C(long j4) {
        return (((int) j4) & 1) == 1;
    }

    public static final boolean D(long j4) {
        return (((int) j4) & 1) == 0;
    }

    public static final boolean E(long j4) {
        return j4 == f14681d || j4 == f14682e;
    }

    public static final boolean F(long j4) {
        return j4 < 0;
    }

    public static final boolean G(long j4) {
        return j4 > 0;
    }

    public static final long H(long j4, long j5) {
        if (E(j4)) {
            if (B(j5) || (j5 ^ j4) >= 0) {
                return j4;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (E(j5)) {
            return j5;
        }
        if ((((int) j4) & 1) != (((int) j5) & 1)) {
            return C(j4) ? g(j4, z(j4), z(j5)) : g(j4, z(j5), z(j4));
        }
        long jZ = z(j4) + z(j5);
        return D(j4) ? c.m(jZ) : c.k(jZ);
    }

    public static final long I(long j4, int i4) {
        if (E(j4)) {
            if (i4 != 0) {
                return i4 > 0 ? j4 : M(j4);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i4 == 0) {
            return f14680c;
        }
        long jZ = z(j4);
        long j5 = i4;
        long j6 = jZ * j5;
        if (!D(j4)) {
            return j6 / j5 == jZ ? c.j(AbstractC1681l.h(j6, new C1679j(-4611686018427387903L, 4611686018427387903L))) : AbstractC1575b.b(jZ) * AbstractC1575b.a(i4) > 0 ? f14681d : f14682e;
        }
        if (-2147483647L <= jZ && jZ < 2147483648L) {
            return c.l(j6);
        }
        if (j6 / j5 == jZ) {
            return c.m(j6);
        }
        long jO = c.o(jZ);
        long j7 = jO * j5;
        long jO2 = c.o((jZ - c.n(jO)) * j5) + j7;
        return (j7 / j5 != jO || (jO2 ^ j7) < 0) ? AbstractC1575b.b(jZ) * AbstractC1575b.a(i4) > 0 ? f14681d : f14682e : c.j(AbstractC1681l.h(jO2, new C1679j(-4611686018427387903L, 4611686018427387903L)));
    }

    public static final String J(long j4) {
        StringBuilder sb = new StringBuilder();
        if (F(j4)) {
            sb.append('-');
        }
        sb.append("PT");
        long jO = o(j4);
        long jR = r(jO);
        int iV = v(jO);
        int iX = x(jO);
        int iW = w(jO);
        long j5 = E(j4) ? 9999999999999L : jR;
        boolean z4 = false;
        boolean z5 = j5 != 0;
        boolean z6 = (iX == 0 && iW == 0) ? false : true;
        if (iV != 0 || (z6 && z5)) {
            z4 = true;
        }
        if (z5) {
            sb.append(j5);
            sb.append('H');
        }
        if (z4) {
            sb.append(iV);
            sb.append('M');
        }
        if (z6 || (!z5 && !z4)) {
            h(j4, sb, iX, iW, 9, "S", true);
        }
        return sb.toString();
    }

    public static final long K(long j4, d unit) {
        r.f(unit, "unit");
        if (j4 == f14681d) {
            return Long.MAX_VALUE;
        }
        if (j4 == f14682e) {
            return Long.MIN_VALUE;
        }
        return e.b(z(j4), y(j4), unit);
    }

    public static String L(long j4) {
        if (j4 == 0) {
            return "0s";
        }
        if (j4 == f14681d) {
            return "Infinity";
        }
        if (j4 == f14682e) {
            return "-Infinity";
        }
        boolean zF = F(j4);
        StringBuilder sb = new StringBuilder();
        if (zF) {
            sb.append('-');
        }
        long jO = o(j4);
        long jQ = q(jO);
        int iP = p(jO);
        int iV = v(jO);
        int iX = x(jO);
        int iW = w(jO);
        int i4 = 0;
        boolean z4 = jQ != 0;
        boolean z5 = iP != 0;
        boolean z6 = iV != 0;
        boolean z7 = (iX == 0 && iW == 0) ? false : true;
        if (z4) {
            sb.append(jQ);
            sb.append('d');
            i4 = 1;
        }
        if (z5 || (z4 && (z6 || z7))) {
            int i5 = i4 + 1;
            if (i4 > 0) {
                sb.append(' ');
            }
            sb.append(iP);
            sb.append('h');
            i4 = i5;
        }
        if (z6 || (z7 && (z5 || z4))) {
            int i6 = i4 + 1;
            if (i4 > 0) {
                sb.append(' ');
            }
            sb.append(iV);
            sb.append('m');
            i4 = i6;
        }
        if (z7) {
            int i7 = i4 + 1;
            if (i4 > 0) {
                sb.append(' ');
            }
            if (iX != 0 || z4 || z5 || z6) {
                h(j4, sb, iX, iW, 9, "s", false);
            } else if (iW >= 1000000) {
                h(j4, sb, iW / 1000000, iW % 1000000, 6, "ms", false);
            } else if (iW >= 1000) {
                h(j4, sb, iW / 1000, iW % 1000, 3, "us", false);
            } else {
                sb.append(iW);
                sb.append("ns");
            }
            i4 = i7;
        }
        if (zF && i4 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    public static final long M(long j4) {
        return c.i(-z(j4), ((int) j4) & 1);
    }

    public static final long g(long j4, long j5, long j6) {
        long jO = c.o(j6);
        long j7 = j5 + jO;
        if (-4611686018426L > j7 || j7 >= 4611686018427L) {
            return c.j(AbstractC1681l.g(j7, -4611686018427387903L, 4611686018427387903L));
        }
        return c.l(c.n(j7) + (j6 - c.n(jO)));
    }

    public static final void h(long j4, StringBuilder sb, int i4, int i5, int i6, String str, boolean z4) {
        sb.append(i4);
        if (i5 != 0) {
            sb.append(com.amazon.a.a.o.c.a.b.f8816a);
            String strG0 = AbstractC1753A.g0(String.valueOf(i5), i6, '0');
            int i7 = -1;
            int length = strG0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i8 = length - 1;
                    if (strG0.charAt(length) != '0') {
                        i7 = length;
                        break;
                    } else if (i8 < 0) {
                        break;
                    } else {
                        length = i8;
                    }
                }
            }
            int i9 = i7 + 1;
            if (z4 || i9 >= 3) {
                sb.append((CharSequence) strG0, 0, ((i7 + 3) / 3) * 3);
                r.e(sb, "append(...)");
            } else {
                sb.append((CharSequence) strG0, 0, i9);
                r.e(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ C1779a i(long j4) {
        return new C1779a(j4);
    }

    public static int l(long j4, long j5) {
        long j6 = j4 ^ j5;
        if (j6 < 0 || (((int) j6) & 1) == 0) {
            return r.h(j4, j5);
        }
        int i4 = (((int) j4) & 1) - (((int) j5) & 1);
        return F(j4) ? -i4 : i4;
    }

    public static long m(long j4) {
        if (!b.a()) {
            return j4;
        }
        if (D(j4)) {
            long jZ = z(j4);
            if (-4611686018426999999L <= jZ && jZ < 4611686018427000000L) {
                return j4;
            }
            throw new AssertionError(z(j4) + " ns is out of nanoseconds range");
        }
        long jZ2 = z(j4);
        if (-4611686018427387903L > jZ2 || jZ2 >= 4611686018427387904L) {
            throw new AssertionError(z(j4) + " ms is out of milliseconds range");
        }
        long jZ3 = z(j4);
        if (-4611686018426L > jZ3 || jZ3 >= 4611686018427L) {
            return j4;
        }
        throw new AssertionError(z(j4) + " ms is denormalized");
    }

    public static boolean n(long j4, Object obj) {
        return (obj instanceof C1779a) && j4 == ((C1779a) obj).N();
    }

    public static final long o(long j4) {
        return F(j4) ? M(j4) : j4;
    }

    public static final int p(long j4) {
        if (E(j4)) {
            return 0;
        }
        return (int) (r(j4) % ((long) 24));
    }

    public static final long q(long j4) {
        return K(j4, d.f14692h);
    }

    public static final long r(long j4) {
        return K(j4, d.f14691g);
    }

    public static final long s(long j4) {
        return (C(j4) && B(j4)) ? z(j4) : K(j4, d.f14688d);
    }

    public static final long t(long j4) {
        return K(j4, d.f14690f);
    }

    public static final long u(long j4) {
        return K(j4, d.f14689e);
    }

    public static final int v(long j4) {
        if (E(j4)) {
            return 0;
        }
        return (int) (t(j4) % ((long) 60));
    }

    public static final int w(long j4) {
        if (E(j4)) {
            return 0;
        }
        return (int) (C(j4) ? c.n(z(j4) % ((long) 1000)) : z(j4) % ((long) 1000000000));
    }

    public static final int x(long j4) {
        if (E(j4)) {
            return 0;
        }
        return (int) (u(j4) % ((long) 60));
    }

    public static final d y(long j4) {
        return D(j4) ? d.f14686b : d.f14688d;
    }

    public static final long z(long j4) {
        return j4 >> 1;
    }

    public final /* synthetic */ long N() {
        return this.f14683a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return k(((C1779a) obj).N());
    }

    public boolean equals(Object obj) {
        return n(this.f14683a, obj);
    }

    public int hashCode() {
        return A(this.f14683a);
    }

    public int k(long j4) {
        return l(this.f14683a, j4);
    }

    public String toString() {
        return L(this.f14683a);
    }
}
