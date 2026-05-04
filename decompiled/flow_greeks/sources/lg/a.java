package lg;

import kg.c0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import vd.j;
import vd.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0282a f15679b = new C0282a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f15680c = m(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f15681d = c.j(4611686018427387903L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f15682e = c.j(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15683a;

    /* JADX INFO: renamed from: lg.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0282a {
        public /* synthetic */ C0282a(k kVar) {
            this();
        }

        public final long a() {
            return a.f15681d;
        }

        public final long b() {
            return a.f15680c;
        }

        public final long c(String value) {
            t.f(value, "value");
            try {
                return c.p(value, true);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e10);
            }
        }

        public C0282a() {
        }
    }

    public /* synthetic */ a(long j10) {
        this.f15683a = j10;
    }

    public static final long A(long j10) {
        return Z(j10, d.f15689e);
    }

    public static final int B(long j10) {
        if (T(j10)) {
            return 0;
        }
        return (int) (y(j10) % ((long) 60));
    }

    public static final int E(long j10) {
        if (T(j10)) {
            return 0;
        }
        return (int) (R(j10) ? c.n(K(j10) % ((long) 1000)) : K(j10) % ((long) 1000000000));
    }

    public static final int G(long j10) {
        if (T(j10)) {
            return 0;
        }
        return (int) (A(j10) % ((long) 60));
    }

    public static final d H(long j10) {
        return S(j10) ? d.f15686b : d.f15688d;
    }

    public static final long K(long j10) {
        return j10 >> 1;
    }

    public static int L(long j10) {
        return Long.hashCode(j10);
    }

    public static final boolean M(long j10) {
        return !T(j10);
    }

    public static final boolean R(long j10) {
        return (((int) j10) & 1) == 1;
    }

    public static final boolean S(long j10) {
        return (((int) j10) & 1) == 0;
    }

    public static final boolean T(long j10) {
        return j10 == f15681d || j10 == f15682e;
    }

    public static final boolean U(long j10) {
        return j10 < 0;
    }

    public static final boolean V(long j10) {
        return j10 > 0;
    }

    public static final long W(long j10, long j11) {
        if (T(j10)) {
            if (M(j11) || (j11 ^ j10) >= 0) {
                return j10;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (T(j11)) {
            return j11;
        }
        if ((((int) j10) & 1) != (((int) j11) & 1)) {
            return R(j10) ? c(j10, K(j10), K(j11)) : c(j10, K(j11), K(j10));
        }
        long jK = K(j10) + K(j11);
        return S(j10) ? c.m(jK) : c.k(jK);
    }

    public static final long X(long j10, int i10) {
        if (T(j10)) {
            if (i10 != 0) {
                return i10 > 0 ? j10 : b0(j10);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i10 == 0) {
            return f15680c;
        }
        long jK = K(j10);
        long j11 = i10;
        long j12 = jK * j11;
        if (!S(j10)) {
            return j12 / j11 == jK ? c.j(l.h(j12, new j(-4611686018427387903L, 4611686018427387903L))) : rd.b.b(jK) * rd.b.a(i10) > 0 ? f15681d : f15682e;
        }
        if (-2147483647L <= jK && jK < 2147483648L) {
            return c.l(j12);
        }
        if (j12 / j11 == jK) {
            return c.m(j12);
        }
        long jO = c.o(jK);
        long j13 = jO * j11;
        long jO2 = c.o((jK - c.n(jO)) * j11) + j13;
        return (j13 / j11 != jO || (jO2 ^ j13) < 0) ? rd.b.b(jK) * rd.b.a(i10) > 0 ? f15681d : f15682e : c.j(l.h(jO2, new j(-4611686018427387903L, 4611686018427387903L)));
    }

    public static final String Y(long j10) {
        StringBuilder sb2 = new StringBuilder();
        if (U(j10)) {
            sb2.append('-');
        }
        sb2.append("PT");
        long jQ = q(j10);
        long jV = v(jQ);
        int iB = B(jQ);
        int iG = G(jQ);
        int iE = E(jQ);
        long j11 = T(j10) ? 9999999999999L : jV;
        boolean z10 = false;
        boolean z11 = j11 != 0;
        boolean z12 = (iG == 0 && iE == 0) ? false : true;
        if (iB != 0 || (z12 && z11)) {
            z10 = true;
        }
        if (z11) {
            sb2.append(j11);
            sb2.append('H');
        }
        if (z10) {
            sb2.append(iB);
            sb2.append('M');
        }
        if (z12 || (!z11 && !z10)) {
            h(j10, sb2, iG, iE, 9, "S", true);
        }
        return sb2.toString();
    }

    public static final long Z(long j10, d unit) {
        t.f(unit, "unit");
        if (j10 == f15681d) {
            return Long.MAX_VALUE;
        }
        if (j10 == f15682e) {
            return Long.MIN_VALUE;
        }
        return e.b(K(j10), H(j10), unit);
    }

    public static String a0(long j10) {
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f15681d) {
            return "Infinity";
        }
        if (j10 == f15682e) {
            return "-Infinity";
        }
        boolean zU = U(j10);
        StringBuilder sb2 = new StringBuilder();
        if (zU) {
            sb2.append('-');
        }
        long jQ = q(j10);
        long jU = u(jQ);
        int iS = s(jQ);
        int iB = B(jQ);
        int iG = G(jQ);
        int iE = E(jQ);
        int i10 = 0;
        boolean z10 = jU != 0;
        boolean z11 = iS != 0;
        boolean z12 = iB != 0;
        boolean z13 = (iG == 0 && iE == 0) ? false : true;
        if (z10) {
            sb2.append(jU);
            sb2.append('d');
            i10 = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(iS);
            sb2.append('h');
            i10 = i11;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(iB);
            sb2.append('m');
            i10 = i12;
        }
        if (z13) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            if (iG != 0 || z10 || z11 || z12) {
                h(j10, sb2, iG, iE, 9, "s", false);
            } else if (iE >= 1000000) {
                h(j10, sb2, iE / 1000000, iE % 1000000, 6, "ms", false);
            } else if (iE >= 1000) {
                h(j10, sb2, iE / 1000, iE % 1000, 3, "us", false);
            } else {
                sb2.append(iE);
                sb2.append("ns");
            }
            i10 = i13;
        }
        if (zU && i10 > 1) {
            sb2.insert(1, '(').append(')');
        }
        return sb2.toString();
    }

    public static final long b0(long j10) {
        return c.i(-K(j10), ((int) j10) & 1);
    }

    public static final long c(long j10, long j11, long j12) {
        long jO = c.o(j12);
        long j13 = j11 + jO;
        if (-4611686018426L > j13 || j13 >= 4611686018427L) {
            return c.j(l.g(j13, -4611686018427387903L, 4611686018427387903L));
        }
        return c.l(c.n(j13) + (j12 - c.n(jO)));
    }

    public static final void h(long j10, StringBuilder sb2, int i10, int i11, int i12, String str, boolean z10) {
        sb2.append(i10);
        if (i11 != 0) {
            sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
            String strQ0 = c0.q0(String.valueOf(i11), i12, '0');
            int i13 = -1;
            int length = strQ0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (strQ0.charAt(length) != '0') {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (z10 || i15 >= 3) {
                sb2.append((CharSequence) strQ0, 0, ((i13 + 3) / 3) * 3);
                t.e(sb2, "append(...)");
            } else {
                sb2.append((CharSequence) strQ0, 0, i15);
                t.e(sb2, "append(...)");
            }
        }
        sb2.append(str);
    }

    public static final /* synthetic */ a i(long j10) {
        return new a(j10);
    }

    public static int l(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return t.h(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        return U(j10) ? -i10 : i10;
    }

    public static long m(long j10) {
        if (!b.a()) {
            return j10;
        }
        if (S(j10)) {
            long jK = K(j10);
            if (-4611686018426999999L <= jK && jK < 4611686018427000000L) {
                return j10;
            }
            throw new AssertionError(K(j10) + " ns is out of nanoseconds range");
        }
        long jK2 = K(j10);
        if (-4611686018427387903L > jK2 || jK2 >= 4611686018427387904L) {
            throw new AssertionError(K(j10) + " ms is out of milliseconds range");
        }
        long jK3 = K(j10);
        if (-4611686018426L > jK3 || jK3 >= 4611686018427L) {
            return j10;
        }
        throw new AssertionError(K(j10) + " ms is denormalized");
    }

    public static boolean o(long j10, Object obj) {
        return (obj instanceof a) && j10 == ((a) obj).c0();
    }

    public static final long q(long j10) {
        return U(j10) ? b0(j10) : j10;
    }

    public static final int s(long j10) {
        if (T(j10)) {
            return 0;
        }
        return (int) (v(j10) % ((long) 24));
    }

    public static final long u(long j10) {
        return Z(j10, d.f15692h);
    }

    public static final long v(long j10) {
        return Z(j10, d.f15691g);
    }

    public static final long w(long j10) {
        return (R(j10) && M(j10)) ? K(j10) : Z(j10, d.f15688d);
    }

    public static final long y(long j10) {
        return Z(j10, d.f15690f);
    }

    public final /* synthetic */ long c0() {
        return this.f15683a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return k(((a) obj).c0());
    }

    public boolean equals(Object obj) {
        return o(this.f15683a, obj);
    }

    public int hashCode() {
        return L(this.f15683a);
    }

    public int k(long j10) {
        return l(this.f15683a, j10);
    }

    public String toString() {
        return a0(this.f15683a);
    }
}
