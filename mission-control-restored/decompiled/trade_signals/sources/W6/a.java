package W6;

import H5.i;
import V6.C;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0149a f9306b = new C0149a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f9307c = n(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f9308d = c.j(4611686018427387903L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f9309e = c.j(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9310a;

    /* JADX INFO: renamed from: W6.a$a, reason: collision with other inner class name */
    public static final class C0149a {
        public C0149a() {
        }

        public final long a() {
            return a.f9308d;
        }

        public final long b() {
            return a.f9307c;
        }

        public final long c(String value) {
            AbstractC2304t.f(value, "value");
            try {
                return c.p(value, true);
            } catch (IllegalArgumentException e8) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e8);
            }
        }

        public /* synthetic */ C0149a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ a(long j8) {
        this.f9310a = j8;
    }

    public static final long B(long j8) {
        return Z(j8, d.f9318g);
    }

    public static final long H(long j8) {
        return (R(j8) && Q(j8)) ? O(j8) : Z(j8, d.f9315d);
    }

    public static final long I(long j8) {
        return Z(j8, d.f9317f);
    }

    public static final long J(long j8) {
        return Z(j8, d.f9316e);
    }

    public static final int K(long j8) {
        if (T(j8)) {
            return 0;
        }
        return (int) (I(j8) % ((long) 60));
    }

    public static final int L(long j8) {
        if (T(j8)) {
            return 0;
        }
        boolean zR = R(j8);
        long jO = O(j8);
        return (int) (zR ? c.n(jO % ((long) 1000)) : jO % ((long) 1000000000));
    }

    public static final int M(long j8) {
        if (T(j8)) {
            return 0;
        }
        return (int) (J(j8) % ((long) 60));
    }

    public static final d N(long j8) {
        return S(j8) ? d.f9313b : d.f9315d;
    }

    public static final long O(long j8) {
        return j8 >> 1;
    }

    public static int P(long j8) {
        return Long.hashCode(j8);
    }

    public static final boolean Q(long j8) {
        return !T(j8);
    }

    public static final boolean R(long j8) {
        return (((int) j8) & 1) == 1;
    }

    public static final boolean S(long j8) {
        return (((int) j8) & 1) == 0;
    }

    public static final boolean T(long j8) {
        return j8 == f9308d || j8 == f9309e;
    }

    public static final boolean U(long j8) {
        return j8 < 0;
    }

    public static final boolean V(long j8) {
        return j8 > 0;
    }

    public static final long W(long j8, long j9) {
        if (T(j8)) {
            if (Q(j9) || (j9 ^ j8) >= 0) {
                return j8;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (T(j9)) {
            return j9;
        }
        if ((((int) j8) & 1) != (((int) j9) & 1)) {
            return R(j8) ? g(j8, O(j8), O(j9)) : g(j8, O(j9), O(j8));
        }
        long jO = O(j8) + O(j9);
        return S(j8) ? c.m(jO) : c.k(jO);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        if ((D5.b.b(r0) * D5.b.a(r14)) > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
    
        if ((D5.b.b(r0) * D5.b.a(r14)) > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return W6.a.f9308d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return W6.a.f9309e;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long X(long r12, int r14) {
        /*
            boolean r0 = T(r12)
            if (r0 == 0) goto L18
            if (r14 == 0) goto L10
            if (r14 <= 0) goto Lb
            goto Lf
        Lb:
            long r12 = b0(r12)
        Lf:
            return r12
        L10:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Multiplying infinite duration by zero yields an undefined result."
            r12.<init>(r13)
            throw r12
        L18:
            if (r14 != 0) goto L1d
            long r12 = W6.a.f9307c
            return r12
        L1d:
            long r0 = O(r12)
            long r2 = (long) r14
            long r4 = r0 * r2
            boolean r12 = S(r12)
            r6 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            r8 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            if (r12 == 0) goto L93
            r12 = -2147483647(0xffffffff80000001, double:NaN)
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 > 0) goto L49
            r12 = 2147483648(0x80000000, double:1.0609978955E-314)
            int r12 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r12 >= 0) goto L49
            long r12 = W6.c.d(r4)
            goto Lab
        L49:
            long r12 = r4 / r2
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 != 0) goto L54
            long r12 = W6.c.e(r4)
            goto Lab
        L54:
            long r12 = W6.c.g(r0)
            long r4 = W6.c.f(r12)
            long r4 = r0 - r4
            long r10 = r12 * r2
            long r4 = r4 * r2
            long r4 = W6.c.g(r4)
            long r4 = r4 + r10
            long r2 = r10 / r2
            int r12 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r12 != 0) goto L82
            long r12 = r4 ^ r10
            r2 = 0
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 < 0) goto L82
            H5.g r12 = new H5.g
            r12.<init>(r8, r6)
        L79:
            long r12 = H5.i.h(r4, r12)
            long r12 = W6.c.b(r12)
            goto Lab
        L82:
            int r12 = D5.b.b(r0)
            int r13 = D5.b.a(r14)
            int r12 = r12 * r13
            if (r12 <= 0) goto L90
        L8d:
            long r12 = W6.a.f9308d
            goto Lab
        L90:
            long r12 = W6.a.f9309e
            goto Lab
        L93:
            long r12 = r4 / r2
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 != 0) goto L9f
            H5.g r12 = new H5.g
            r12.<init>(r8, r6)
            goto L79
        L9f:
            int r12 = D5.b.b(r0)
            int r13 = D5.b.a(r14)
            int r12 = r12 * r13
            if (r12 <= 0) goto L90
            goto L8d
        Lab:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: W6.a.X(long, int):long");
    }

    public static final String Y(long j8) {
        StringBuilder sb = new StringBuilder();
        if (U(j8)) {
            sb.append('-');
        }
        sb.append("PT");
        long jR = r(j8);
        long jB = B(jR);
        int iK = K(jR);
        int iM = M(jR);
        int iL = L(jR);
        if (T(j8)) {
            jB = 9999999999999L;
        }
        boolean z7 = false;
        boolean z8 = jB != 0;
        boolean z9 = (iM == 0 && iL == 0) ? false : true;
        if (iK != 0 || (z9 && z8)) {
            z7 = true;
        }
        if (z8) {
            sb.append(jB);
            sb.append('H');
        }
        if (z7) {
            sb.append(iK);
            sb.append('M');
        }
        if (z9 || (!z8 && !z7)) {
            i(j8, sb, iM, iL, 9, "S", true);
        }
        return sb.toString();
    }

    public static final long Z(long j8, d unit) {
        AbstractC2304t.f(unit, "unit");
        if (j8 == f9308d) {
            return Long.MAX_VALUE;
        }
        if (j8 == f9309e) {
            return Long.MIN_VALUE;
        }
        return e.b(O(j8), N(j8), unit);
    }

    public static String a0(long j8) {
        int i8;
        long j9;
        StringBuilder sb;
        int i9;
        int i10;
        String str;
        boolean z7;
        if (j8 == 0) {
            return "0s";
        }
        if (j8 == f9308d) {
            return "Infinity";
        }
        if (j8 == f9309e) {
            return "-Infinity";
        }
        boolean zU = U(j8);
        StringBuilder sb2 = new StringBuilder();
        if (zU) {
            sb2.append('-');
        }
        long jR = r(j8);
        long jW = w(jR);
        int iT = t(jR);
        int iK = K(jR);
        int iM = M(jR);
        int iL = L(jR);
        int i11 = 0;
        boolean z8 = jW != 0;
        boolean z9 = iT != 0;
        boolean z10 = iK != 0;
        boolean z11 = (iM == 0 && iL == 0) ? false : true;
        if (z8) {
            sb2.append(jW);
            sb2.append('d');
            i11 = 1;
        }
        if (z9 || (z8 && (z10 || z11))) {
            int i12 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(iT);
            sb2.append('h');
            i11 = i12;
        }
        if (z10 || (z11 && (z9 || z8))) {
            int i13 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(iK);
            sb2.append('m');
            i11 = i13;
        }
        if (z11) {
            int i14 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            if (iM != 0 || z8 || z9 || z10) {
                i8 = 9;
                j9 = j8;
                sb = sb2;
                i9 = iM;
                i10 = iL;
                str = "s";
                z7 = false;
            } else {
                if (iL >= 1000000) {
                    i9 = iL / 1000000;
                    i10 = iL % 1000000;
                    str = "ms";
                    z7 = false;
                    i8 = 6;
                } else if (iL >= 1000) {
                    i9 = iL / 1000;
                    i10 = iL % 1000;
                    str = "us";
                    z7 = false;
                    i8 = 3;
                } else {
                    sb2.append(iL);
                    sb2.append("ns");
                    i11 = i14;
                }
                j9 = j8;
                sb = sb2;
            }
            i(j9, sb, i9, i10, i8, str, z7);
            i11 = i14;
        }
        if (zU && i11 > 1) {
            sb2.insert(1, '(').append(')');
        }
        return sb2.toString();
    }

    public static final long b0(long j8) {
        return c.i(-O(j8), ((int) j8) & 1);
    }

    public static final long g(long j8, long j9, long j10) {
        long jO = c.o(j10);
        long j11 = j9 + jO;
        if (-4611686018426L > j11 || j11 >= 4611686018427L) {
            return c.j(i.g(j11, -4611686018427387903L, 4611686018427387903L));
        }
        return c.l(c.n(j11) + (j10 - c.n(jO)));
    }

    public static final void i(long j8, StringBuilder sb, int i8, int i9, int i10, String str, boolean z7) {
        sb.append(i8);
        if (i9 != 0) {
            sb.append(com.amazon.a.a.o.c.a.b.f14112a);
            String strJ0 = C.j0(String.valueOf(i9), i10, '0');
            int i11 = -1;
            int length = strJ0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i12 = length - 1;
                    if (strJ0.charAt(length) != '0') {
                        i11 = length;
                        break;
                    } else if (i12 < 0) {
                        break;
                    } else {
                        length = i12;
                    }
                }
            }
            int i13 = i11 + 1;
            if (z7 || i13 >= 3) {
                sb.append((CharSequence) strJ0, 0, ((i11 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) strJ0, 0, i13);
            }
            AbstractC2304t.e(sb, "append(...)");
        }
        sb.append(str);
    }

    public static final /* synthetic */ a k(long j8) {
        return new a(j8);
    }

    public static int m(long j8, long j9) {
        long j10 = j8 ^ j9;
        if (j10 < 0 || (((int) j10) & 1) == 0) {
            return AbstractC2304t.h(j8, j9);
        }
        int i8 = (((int) j8) & 1) - (((int) j9) & 1);
        return U(j8) ? -i8 : i8;
    }

    public static long n(long j8) {
        if (b.a()) {
            if (S(j8)) {
                long jO = O(j8);
                if (-4611686018426999999L > jO || jO >= 4611686018427000000L) {
                    throw new AssertionError(O(j8) + " ns is out of nanoseconds range");
                }
            } else {
                long jO2 = O(j8);
                if (-4611686018427387903L > jO2 || jO2 >= 4611686018427387904L) {
                    throw new AssertionError(O(j8) + " ms is out of milliseconds range");
                }
                long jO3 = O(j8);
                if (-4611686018426L <= jO3 && jO3 < 4611686018427L) {
                    throw new AssertionError(O(j8) + " ms is denormalized");
                }
            }
        }
        return j8;
    }

    public static boolean q(long j8, Object obj) {
        return (obj instanceof a) && j8 == ((a) obj).c0();
    }

    public static final long r(long j8) {
        return U(j8) ? b0(j8) : j8;
    }

    public static final int t(long j8) {
        if (T(j8)) {
            return 0;
        }
        return (int) (B(j8) % ((long) 24));
    }

    public static final long w(long j8) {
        return Z(j8, d.f9319h);
    }

    public final /* synthetic */ long c0() {
        return this.f9310a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return l(((a) obj).c0());
    }

    public boolean equals(Object obj) {
        return q(this.f9310a, obj);
    }

    public int hashCode() {
        return P(this.f9310a);
    }

    public int l(long j8) {
        return m(this.f9310a, j8);
    }

    public String toString() {
        return a0(this.f9310a);
    }
}
