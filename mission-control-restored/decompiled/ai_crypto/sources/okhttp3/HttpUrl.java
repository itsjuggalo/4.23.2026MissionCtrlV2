package okhttp3;

import java.io.EOFException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.Util;
import w6.C2792e;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpUrl {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f20491j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f20496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f20497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f20498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f20499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f20500i;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20501a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f20504d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f20506f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f20507g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f20508h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f20502b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f20503c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f20505e = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f20506f = arrayList;
            arrayList.add("");
        }

        public static String b(String str, int i7, int i8) {
            return Util.d(HttpUrl.r(str, i7, i8, false));
        }

        public static int i(String str, int i7, int i8) {
            int i9;
            try {
                i9 = Integer.parseInt(HttpUrl.a(str, i7, i8, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i9 <= 0 || i9 > 65535) {
                return -1;
            }
            return i9;
        }

        public static int m(String str, int i7, int i8) {
            while (i7 < i8) {
                char cCharAt = str.charAt(i7);
                if (cCharAt == ':') {
                    return i7;
                }
                if (cCharAt == '[') {
                    do {
                        i7++;
                        if (i7 < i8) {
                        }
                    } while (str.charAt(i7) != ']');
                }
                i7++;
            }
            return i8;
        }

        public static int r(String str, int i7, int i8) {
            if (i8 - i7 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i7);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i7++;
                    if (i7 >= i8) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i7);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i7;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static int s(String str, int i7, int i8) {
            int i9 = 0;
            while (i7 < i8) {
                char cCharAt = str.charAt(i7);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i9++;
                i7++;
            }
            return i9;
        }

        public HttpUrl a() {
            if (this.f20501a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f20504d != null) {
                return new HttpUrl(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int c() {
            int i7 = this.f20505e;
            return i7 != -1 ? i7 : HttpUrl.d(this.f20501a);
        }

        public Builder d(String str) {
            this.f20507g = str != null ? HttpUrl.y(HttpUrl.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strB = b(str, 0, str.length());
            if (strB != null) {
                this.f20504d = strB;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public final boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public Builder h(HttpUrl httpUrl, String str) throws EOFException {
            int iN;
            int i7;
            int iD = Util.D(str, 0, str.length());
            int iE = Util.E(str, iD, str.length());
            int iR = r(str, iD, iE);
            if (iR != -1) {
                if (str.regionMatches(true, iD, "https:", 0, 6)) {
                    this.f20501a = "https";
                    iD += 6;
                } else {
                    if (!str.regionMatches(true, iD, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iR) + "'");
                    }
                    this.f20501a = "http";
                    iD += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f20501a = httpUrl.f20492a;
            }
            int iS = s(str, iD, iE);
            char c7 = '?';
            char c8 = '#';
            if (iS >= 2 || httpUrl == null || !httpUrl.f20492a.equals(this.f20501a)) {
                boolean z7 = false;
                boolean z8 = false;
                int i8 = iD + iS;
                while (true) {
                    iN = Util.n(str, i8, iE, "@/\\?#");
                    byte bCharAt = iN != iE ? str.charAt(iN) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c8 || bCharAt == 47 || bCharAt == 92 || bCharAt == c7) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z7) {
                            i7 = iN;
                            this.f20503c += "%40" + HttpUrl.a(str, i8, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iM = Util.m(str, i8, iN, ':');
                            i7 = iN;
                            String strA = HttpUrl.a(str, i8, iM, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z8) {
                                strA = this.f20502b + "%40" + strA;
                            }
                            this.f20502b = strA;
                            if (iM != i7) {
                                this.f20503c = HttpUrl.a(str, iM + 1, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z7 = true;
                            }
                            z8 = true;
                        }
                        i8 = i7 + 1;
                    }
                    c7 = '?';
                    c8 = '#';
                }
                int iM2 = m(str, i8, iN);
                int i9 = iM2 + 1;
                if (i9 < iN) {
                    this.f20504d = b(str, i8, iM2);
                    int i10 = i(str, i9, iN);
                    this.f20505e = i10;
                    if (i10 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i9, iN) + '\"');
                    }
                } else {
                    this.f20504d = b(str, i8, iM2);
                    this.f20505e = HttpUrl.d(this.f20501a);
                }
                if (this.f20504d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i8, iM2) + '\"');
                }
                iD = iN;
            } else {
                this.f20502b = httpUrl.j();
                this.f20503c = httpUrl.f();
                this.f20504d = httpUrl.f20495d;
                this.f20505e = httpUrl.f20496e;
                this.f20506f.clear();
                this.f20506f.addAll(httpUrl.h());
                if (iD == iE || str.charAt(iD) == '#') {
                    d(httpUrl.i());
                }
            }
            int iN2 = Util.n(str, iD, iE, "?#");
            p(str, iD, iN2);
            if (iN2 < iE && str.charAt(iN2) == '?') {
                int iM3 = Util.m(str, iN2, iE, '#');
                this.f20507g = HttpUrl.y(HttpUrl.a(str, iN2 + 1, iM3, " \"'<>#", true, false, true, true, null));
                iN2 = iM3;
            }
            if (iN2 < iE && str.charAt(iN2) == '#') {
                this.f20508h = HttpUrl.a(str, 1 + iN2, iE, "", true, false, false, false, null);
            }
            return this;
        }

        public Builder j(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f20503c = HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public final void k() {
            if (!((String) this.f20506f.remove(r0.size() - 1)).isEmpty() || this.f20506f.isEmpty()) {
                this.f20506f.add("");
            } else {
                this.f20506f.set(r0.size() - 1, "");
            }
        }

        public Builder l(int i7) {
            if (i7 > 0 && i7 <= 65535) {
                this.f20505e = i7;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i7);
        }

        public final void n(String str, int i7, int i8, boolean z7, boolean z8) throws EOFException {
            String strA = HttpUrl.a(str, i7, i8, " \"<>^`{}|/\\?#", z8, false, false, true, null);
            if (f(strA)) {
                return;
            }
            if (g(strA)) {
                k();
                return;
            }
            if (((String) this.f20506f.get(r11.size() - 1)).isEmpty()) {
                this.f20506f.set(r11.size() - 1, strA);
            } else {
                this.f20506f.add(strA);
            }
            if (z7) {
                this.f20506f.add("");
            }
        }

        public Builder o() {
            int size = this.f20506f.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f20506f.set(i7, HttpUrl.b((String) this.f20506f.get(i7), "[]", true, true, false, true));
            }
            List list = this.f20507g;
            if (list != null) {
                int size2 = list.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    String str = (String) this.f20507g.get(i8);
                    if (str != null) {
                        this.f20507g.set(i8, HttpUrl.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f20508h;
            if (str2 != null) {
                this.f20508h = HttpUrl.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public final void p(String str, int i7, int i8) throws EOFException {
            if (i7 == i8) {
                return;
            }
            char cCharAt = str.charAt(i7);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f20506f.clear();
                this.f20506f.add("");
                i7++;
            } else {
                List list = this.f20506f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i9 = i7;
                if (i9 >= i8) {
                    return;
                }
                i7 = Util.n(str, i9, i8, "/\\");
                boolean z7 = i7 < i8;
                n(str, i9, i7, z7, true);
                if (z7) {
                    i7++;
                }
            }
        }

        public Builder q(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f20501a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f20501a = "https";
            }
            return this;
        }

        public Builder t(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f20502b = HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f20501a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f20502b.isEmpty() || !this.f20503c.isEmpty()) {
                sb.append(this.f20502b);
                if (!this.f20503c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f20503c);
                }
                sb.append('@');
            }
            String str2 = this.f20504d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f20504d);
                    sb.append(']');
                } else {
                    sb.append(this.f20504d);
                }
            }
            if (this.f20505e != -1 || this.f20501a != null) {
                int iC = c();
                String str3 = this.f20501a;
                if (str3 == null || iC != HttpUrl.d(str3)) {
                    sb.append(':');
                    sb.append(iC);
                }
            }
            HttpUrl.q(sb, this.f20506f);
            if (this.f20507g != null) {
                sb.append('?');
                HttpUrl.n(sb, this.f20507g);
            }
            if (this.f20508h != null) {
                sb.append('#');
                sb.append(this.f20508h);
            }
            return sb.toString();
        }
    }

    public HttpUrl(Builder builder) {
        this.f20492a = builder.f20501a;
        this.f20493b = s(builder.f20502b, false);
        this.f20494c = s(builder.f20503c, false);
        this.f20495d = builder.f20504d;
        this.f20496e = builder.c();
        this.f20497f = t(builder.f20506f, false);
        List list = builder.f20507g;
        this.f20498g = list != null ? t(list, true) : null;
        String str = builder.f20508h;
        this.f20499h = str != null ? s(str, false) : null;
        this.f20500i = builder.toString();
    }

    public static String a(String str, int i7, int i8, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset) throws EOFException {
        int iCharCount = i7;
        while (iCharCount < i8) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && z10)) {
                C2792e c2792e = new C2792e();
                c2792e.U0(str, i7, iCharCount);
                c(c2792e, str, iCharCount, i8, str2, z7, z8, z9, z10, charset);
                return c2792e.C0();
            }
            if (str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z7 || (z8 && !v(str, iCharCount, i8)))) || (iCodePointAt == 43 && z9))) {
                C2792e c2792e2 = new C2792e();
                c2792e2.U0(str, i7, iCharCount);
                c(c2792e2, str, iCharCount, i8, str2, z7, z8, z9, z10, charset);
                return c2792e2.C0();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i7, i8);
    }

    public static String b(String str, String str2, boolean z7, boolean z8, boolean z9, boolean z10) {
        return a(str, 0, str.length(), str2, z7, z8, z9, z10, null);
    }

    public static void c(C2792e c2792e, String str, int i7, int i8, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset) throws EOFException {
        C2792e c2792e2 = null;
        while (i7 < i8) {
            int iCodePointAt = str.codePointAt(i7);
            if (!z7 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z9) {
                    c2792e.I(z7 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z10) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z7 || (z8 && !v(str, i7, i8)))))) {
                    if (c2792e2 == null) {
                        c2792e2 = new C2792e();
                    }
                    if (charset == null || charset.equals(Util.f20679j)) {
                        c2792e2.V0(iCodePointAt);
                    } else {
                        c2792e2.R0(str, i7, Character.charCount(iCodePointAt) + i7, charset);
                    }
                    while (!c2792e2.u()) {
                        byte b7 = c2792e2.readByte();
                        c2792e.v(37);
                        char[] cArr = f20491j;
                        c2792e.v(cArr[((b7 & 255) >> 4) & 15]);
                        c2792e.v(cArr[b7 & 15]);
                    }
                } else {
                    c2792e.V0(iCodePointAt);
                }
            }
            i7 += Character.charCount(iCodePointAt);
        }
    }

    public static int d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static HttpUrl k(String str) {
        return new Builder().h(null, str).a();
    }

    public static void n(StringBuilder sb, List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7 += 2) {
            String str = (String) list.get(i7);
            String str2 = (String) list.get(i7 + 1);
            if (i7 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static void q(StringBuilder sb, List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            sb.append('/');
            sb.append((String) list.get(i7));
        }
    }

    public static String r(String str, int i7, int i8, boolean z7) {
        for (int i9 = i7; i9 < i8; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt == '%' || (cCharAt == '+' && z7)) {
                C2792e c2792e = new C2792e();
                c2792e.U0(str, i7, i9);
                u(c2792e, str, i9, i8, z7);
                return c2792e.C0();
            }
        }
        return str.substring(i7, i8);
    }

    public static String s(String str, boolean z7) {
        return r(str, 0, str.length(), z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void u(w6.C2792e r5, java.lang.String r6, int r7, int r8, boolean r9) {
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
            int r2 = okhttp3.internal.Util.j(r2)
            char r3 = r6.charAt(r1)
            int r3 = okhttp3.internal.Util.j(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.v(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.v(r1)
            goto L3c
        L39:
            r5.V0(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.u(w6.e, java.lang.String, int, int, boolean):void");
    }

    public static boolean v(String str, int i7, int i8) {
        int i9 = i7 + 2;
        return i9 < i8 && str.charAt(i7) == '%' && Util.j(str.charAt(i7 + 1)) != -1 && Util.j(str.charAt(i9)) != -1;
    }

    public static List y(String str) {
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 <= str.length()) {
            int iIndexOf = str.indexOf(38, i7);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i7);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i7, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i7, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i7 = iIndexOf + 1;
        }
        return arrayList;
    }

    public HttpUrl A(String str) {
        Builder builderP = p(str);
        if (builderP != null) {
            return builderP.a();
        }
        return null;
    }

    public String B() {
        return this.f20492a;
    }

    public URI C() {
        String string = o().o().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e7) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e7);
            }
        }
    }

    public String e() {
        if (this.f20499h == null) {
            return null;
        }
        return this.f20500i.substring(this.f20500i.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f20500i.equals(this.f20500i);
    }

    public String f() {
        if (this.f20494c.isEmpty()) {
            return "";
        }
        return this.f20500i.substring(this.f20500i.indexOf(58, this.f20492a.length() + 3) + 1, this.f20500i.indexOf(64));
    }

    public String g() {
        int iIndexOf = this.f20500i.indexOf(47, this.f20492a.length() + 3);
        String str = this.f20500i;
        return this.f20500i.substring(iIndexOf, Util.n(str, iIndexOf, str.length(), "?#"));
    }

    public List h() {
        int iIndexOf = this.f20500i.indexOf(47, this.f20492a.length() + 3);
        String str = this.f20500i;
        int iN = Util.n(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iN) {
            int i7 = iIndexOf + 1;
            int iM = Util.m(this.f20500i, i7, iN, '/');
            arrayList.add(this.f20500i.substring(i7, iM));
            iIndexOf = iM;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f20500i.hashCode();
    }

    public String i() {
        if (this.f20498g == null) {
            return null;
        }
        int iIndexOf = this.f20500i.indexOf(63) + 1;
        String str = this.f20500i;
        return this.f20500i.substring(iIndexOf, Util.m(str, iIndexOf, str.length(), '#'));
    }

    public String j() {
        if (this.f20493b.isEmpty()) {
            return "";
        }
        int length = this.f20492a.length() + 3;
        String str = this.f20500i;
        return this.f20500i.substring(length, Util.n(str, length, str.length(), ":@"));
    }

    public String l() {
        return this.f20495d;
    }

    public boolean m() {
        return this.f20492a.equals("https");
    }

    public Builder o() {
        Builder builder = new Builder();
        builder.f20501a = this.f20492a;
        builder.f20502b = j();
        builder.f20503c = f();
        builder.f20504d = this.f20495d;
        builder.f20505e = this.f20496e != d(this.f20492a) ? this.f20496e : -1;
        builder.f20506f.clear();
        builder.f20506f.addAll(h());
        builder.d(i());
        builder.f20508h = e();
        return builder;
    }

    public Builder p(String str) {
        try {
            return new Builder().h(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final List t(List list, boolean z7) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i7 = 0; i7 < size; i7++) {
            String str = (String) list.get(i7);
            arrayList.add(str != null ? s(str, z7) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String toString() {
        return this.f20500i;
    }

    public int w() {
        return this.f20496e;
    }

    public String x() {
        if (this.f20498g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        n(sb, this.f20498g);
        return sb.toString();
    }

    public String z() {
        return p("/...").t("").j("").a().toString();
    }
}
