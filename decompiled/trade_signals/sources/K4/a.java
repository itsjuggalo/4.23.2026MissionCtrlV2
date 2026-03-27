package K4;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import u7.C2811d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f4768e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4772d;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f4774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4775c = -1;

        public static String b(String str, int i8, int i9) {
            String strD = a.d(str, i8, i9, false);
            if (!strD.startsWith("[") || !strD.endsWith("]")) {
                return f(strD);
            }
            InetAddress inetAddressE = e(strD, 1, strD.length() - 1);
            if (inetAddressE == null) {
                return null;
            }
            byte[] address = inetAddressE.getAddress();
            if (address.length == 16) {
                return i(address);
            }
            throw new AssertionError();
        }

        public static boolean c(String str) {
            for (int i8 = 0; i8 < str.length(); i8++) {
                char cCharAt = str.charAt(i8);
                if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        public static boolean d(String str, int i8, int i9, byte[] bArr, int i10) {
            int i11 = i10;
            while (i8 < i9) {
                if (i11 == bArr.length) {
                    return false;
                }
                if (i11 != i10) {
                    if (str.charAt(i8) != '.') {
                        return false;
                    }
                    i8++;
                }
                int i12 = i8;
                int i13 = 0;
                while (i12 < i9) {
                    char cCharAt = str.charAt(i12);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    if ((i13 == 0 && i8 != i12) || (i13 = ((i13 * 10) + cCharAt) - 48) > 255) {
                        return false;
                    }
                    i12++;
                }
                if (i12 - i8 == 0) {
                    return false;
                }
                bArr[i11] = (byte) i13;
                i11++;
                i8 = i12;
            }
            return i11 == i10 + 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
        
            if (r4 == 16) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
        
            if (r5 != (-1)) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
        
            r12 = r4 - r5;
            java.lang.System.arraycopy(r1, r5, r1, 16 - r12, r12);
            java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x008e, code lost:
        
            return java.net.InetAddress.getByAddress(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0094, code lost:
        
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.net.InetAddress e(java.lang.String r12, int r13, int r14) {
            /*
                r0 = 16
                byte[] r1 = new byte[r0]
                r2 = 0
                r3 = -1
                r4 = r2
                r5 = r3
                r6 = r5
            L9:
                r7 = 0
                if (r13 >= r14) goto L79
                if (r4 != r0) goto Lf
                return r7
            Lf:
                int r8 = r13 + 2
                r9 = 2
                if (r8 > r14) goto L27
                java.lang.String r10 = "::"
                boolean r10 = r12.regionMatches(r13, r10, r2, r9)
                if (r10 == 0) goto L27
                if (r5 == r3) goto L1f
                return r7
            L1f:
                int r4 = r4 + 2
                r5 = r4
                if (r8 != r14) goto L25
                goto L79
            L25:
                r6 = r8
                goto L4b
            L27:
                if (r4 == 0) goto L34
                java.lang.String r8 = ":"
                r10 = 1
                boolean r8 = r12.regionMatches(r13, r8, r2, r10)
                if (r8 == 0) goto L36
                int r13 = r13 + 1
            L34:
                r6 = r13
                goto L4b
            L36:
                java.lang.String r8 = "."
                boolean r13 = r12.regionMatches(r13, r8, r2, r10)
                if (r13 == 0) goto L4a
                int r13 = r4 + (-2)
                boolean r12 = d(r12, r6, r14, r1, r13)
                if (r12 != 0) goto L47
                return r7
            L47:
                int r4 = r4 + 2
                goto L79
            L4a:
                return r7
            L4b:
                r8 = r2
                r13 = r6
            L4d:
                if (r13 >= r14) goto L60
                char r10 = r12.charAt(r13)
                int r10 = K4.a.a(r10)
                if (r10 != r3) goto L5a
                goto L60
            L5a:
                int r8 = r8 << 4
                int r8 = r8 + r10
                int r13 = r13 + 1
                goto L4d
            L60:
                int r10 = r13 - r6
                if (r10 == 0) goto L78
                r11 = 4
                if (r10 <= r11) goto L68
                goto L78
            L68:
                int r7 = r4 + 1
                int r10 = r8 >>> 8
                r10 = r10 & 255(0xff, float:3.57E-43)
                byte r10 = (byte) r10
                r1[r4] = r10
                int r4 = r4 + r9
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r1[r7] = r8
                goto L9
            L78:
                return r7
            L79:
                if (r4 == r0) goto L8a
                if (r5 != r3) goto L7e
                return r7
            L7e:
                int r12 = r4 - r5
                int r13 = 16 - r12
                java.lang.System.arraycopy(r1, r5, r1, r13, r12)
                int r0 = r0 - r4
                int r0 = r0 + r5
                java.util.Arrays.fill(r1, r5, r0, r2)
            L8a:
                java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
                return r12
            L8f:
                java.lang.AssertionError r12 = new java.lang.AssertionError
                r12.<init>()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: K4.a.b.e(java.lang.String, int, int):java.net.InetAddress");
        }

        public static String f(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (c(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public static String i(byte[] bArr) {
            int i8 = -1;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i10 < bArr.length) {
                int i12 = i10;
                while (i12 < 16 && bArr[i12] == 0 && bArr[i12 + 1] == 0) {
                    i12 += 2;
                }
                int i13 = i12 - i10;
                if (i13 > i11) {
                    i8 = i10;
                    i11 = i13;
                }
                i10 = i12 + 2;
            }
            C2811d c2811d = new C2811d();
            while (i9 < bArr.length) {
                if (i9 == i8) {
                    c2811d.x(58);
                    i9 += i11;
                    if (i9 == 16) {
                        c2811d.x(58);
                    }
                } else {
                    if (i9 > 0) {
                        c2811d.x(58);
                    }
                    c2811d.D0(((bArr[i9] & 255) << 8) | (bArr[i9 + 1] & 255));
                    i9 += 2;
                }
            }
            return c2811d.b0();
        }

        public a a() {
            if (this.f4773a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f4774b != null) {
                return new a(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int g() {
            int i8 = this.f4775c;
            return i8 != -1 ? i8 : a.b(this.f4773a);
        }

        public b h(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String strB = b(str, 0, str.length());
            if (strB != null) {
                this.f4774b = strB;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public b j(int i8) {
            if (i8 > 0 && i8 <= 65535) {
                this.f4775c = i8;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i8);
        }

        public b k(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            String str2 = "http";
            if (!str.equalsIgnoreCase("http")) {
                str2 = "https";
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.f4773a = str2;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f4773a);
            sb.append("://");
            if (this.f4774b.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f4774b);
                sb.append(']');
            } else {
                sb.append(this.f4774b);
            }
            int iG = g();
            if (iG != a.b(this.f4773a)) {
                sb.append(':');
                sb.append(iG);
            }
            return sb.toString();
        }
    }

    public a(b bVar) {
        this.f4769a = bVar.f4773a;
        this.f4770b = bVar.f4774b;
        this.f4771c = bVar.g();
        this.f4772d = bVar.toString();
    }

    public static int a(char c8) {
        if (c8 >= '0' && c8 <= '9') {
            return c8 - '0';
        }
        if (c8 >= 'a' && c8 <= 'f') {
            return c8 - 'W';
        }
        if (c8 < 'A' || c8 > 'F') {
            return -1;
        }
        return c8 - '7';
    }

    public static int b(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static String d(String str, int i8, int i9, boolean z7) {
        for (int i10 = i8; i10 < i9; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '%' || (cCharAt == '+' && z7)) {
                C2811d c2811d = new C2811d();
                c2811d.I0(str, i8, i10);
                e(c2811d, str, i10, i9, z7);
                return c2811d.b0();
            }
        }
        return str.substring(i8, i9);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(u7.C2811d r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = a(r2)
            char r3 = r6.charAt(r1)
            int r3 = a(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.x(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.x(r1)
            goto L3c
        L39:
            r5.J0(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: K4.a.e(u7.d, java.lang.String, int, int, boolean):void");
    }

    public String c() {
        return this.f4770b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f4772d.equals(this.f4772d);
    }

    public int f() {
        return this.f4771c;
    }

    public int hashCode() {
        return this.f4772d.hashCode();
    }

    public String toString() {
        return this.f4772d;
    }
}
