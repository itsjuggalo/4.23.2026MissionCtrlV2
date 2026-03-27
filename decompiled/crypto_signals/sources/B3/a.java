package B3;

import a3.d;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import s3.B0;
import s3.I0;

/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f147a;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f153l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f154m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f155n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f156o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String[] f158q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f159r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f160s = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f148b = new char[1024];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f149c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f150d = 0;
    public int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f151f = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f152k = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f157p = 1;

    static {
        E4.c.f467b = new E4.c(1);
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f156o = iArr;
        iArr[0] = 6;
        this.f158q = new String[32];
        this.f159r = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f147a = reader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        g();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String A() throws B3.c {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r7.f149c
            int r4 = r3 + r2
            int r5 = r7.f150d
            char[] r6 = r7.f148b
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.g()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.k(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.f149c
            r0.append(r6, r3, r2)
            int r3 = r7.f149c
            int r3 = r3 + r2
            r7.f149c = r3
            r2 = 1
            boolean r2 = r7.k(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f149c
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.f149c
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.f149c
            int r2 = r2 + r1
            r7.f149c = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.a.A():java.lang.String");
    }

    public int B() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        switch (iH) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
                return 6;
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void C(int i) throws c {
        int i6 = this.f157p;
        if (i6 - 1 >= 255) {
            throw new c("Nesting limit 255 reached" + q());
        }
        int[] iArr = this.f156o;
        if (i6 == iArr.length) {
            int i7 = i6 * 2;
            this.f156o = Arrays.copyOf(iArr, i7);
            this.f159r = Arrays.copyOf(this.f159r, i7);
            this.f158q = (String[]) Arrays.copyOf(this.f158q, i7);
        }
        int[] iArr2 = this.f156o;
        int i8 = this.f157p;
        this.f157p = i8 + 1;
        iArr2[i8] = i;
    }

    public final char D() throws c {
        int i;
        if (this.f149c == this.f150d && !k(1)) {
            I("Unterminated escape sequence");
            throw null;
        }
        int i6 = this.f149c;
        int i7 = i6 + 1;
        this.f149c = i7;
        char[] cArr = this.f148b;
        char c6 = cArr[i6];
        if (c6 != '\n') {
            if (c6 != '\"') {
                if (c6 != '\'') {
                    if (c6 != '/' && c6 != '\\') {
                        if (c6 == 'b') {
                            return '\b';
                        }
                        if (c6 == 'f') {
                            return '\f';
                        }
                        if (c6 == 'n') {
                            return '\n';
                        }
                        if (c6 == 'r') {
                            return '\r';
                        }
                        if (c6 == 't') {
                            return '\t';
                        }
                        if (c6 != 'u') {
                            I("Invalid escape sequence");
                            throw null;
                        }
                        if (i6 + 5 > this.f150d && !k(4)) {
                            I("Unterminated escape sequence");
                            throw null;
                        }
                        int i8 = this.f149c;
                        int i9 = i8 + 4;
                        int i10 = 0;
                        while (i8 < i9) {
                            char c7 = cArr[i8];
                            int i11 = i10 << 4;
                            if (c7 >= '0' && c7 <= '9') {
                                i = c7 - '0';
                            } else if (c7 >= 'a' && c7 <= 'f') {
                                i = c7 - 'W';
                            } else {
                                if (c7 < 'A' || c7 > 'F') {
                                    I("Malformed Unicode escape \\u".concat(new String(cArr, this.f149c, 4)));
                                    throw null;
                                }
                                i = c7 - '7';
                            }
                            i10 = i + i11;
                            i8++;
                        }
                        this.f149c += 4;
                        return (char) i10;
                    }
                }
            }
            return c6;
        }
        if (this.f160s == 3) {
            I("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.e++;
        this.f151f = i7;
        if (this.f160s == 3) {
            I("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c6;
    }

    public final void E(char c6) throws c {
        do {
            int i = this.f149c;
            int i6 = this.f150d;
            while (i < i6) {
                int i7 = i + 1;
                char c7 = this.f148b[i];
                if (c7 == c6) {
                    this.f149c = i7;
                    return;
                }
                if (c7 == '\\') {
                    this.f149c = i7;
                    D();
                    i = this.f149c;
                    i6 = this.f150d;
                } else {
                    if (c7 == '\n') {
                        this.e++;
                        this.f151f = i7;
                    }
                    i = i7;
                }
            }
            this.f149c = i;
        } while (k(1));
        I("Unterminated string");
        throw null;
    }

    public final void F() {
        char c6;
        do {
            if (this.f149c >= this.f150d && !k(1)) {
                return;
            }
            int i = this.f149c;
            int i6 = i + 1;
            this.f149c = i6;
            c6 = this.f148b[i];
            if (c6 == '\n') {
                this.e++;
                this.f151f = i6;
                return;
            }
        } while (c6 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G() throws B3.c {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f149c
            int r2 = r1 + r0
            int r3 = r4.f150d
            if (r2 >= r3) goto L51
            char[] r2 = r4.f148b
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.g()
        L4b:
            int r1 = r4.f149c
            int r1 = r1 + r0
            r4.f149c = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f149c = r1
            r0 = 1
            boolean r0 = r4.k(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.a.G():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void H() throws IOException {
        int i = 0;
        do {
            int iH = this.f152k;
            if (iH == 0) {
                iH = h();
            }
            switch (iH) {
                case 1:
                    C(3);
                    i++;
                    this.f152k = 0;
                    break;
                case 2:
                    if (i == 0) {
                        this.f158q[this.f157p - 1] = null;
                    }
                    this.f157p--;
                    i--;
                    this.f152k = 0;
                    break;
                case 3:
                    C(1);
                    i++;
                    this.f152k = 0;
                    break;
                case 4:
                    this.f157p--;
                    i--;
                    this.f152k = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f152k = 0;
                    break;
                case 8:
                    E('\'');
                    this.f152k = 0;
                    break;
                case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    E('\"');
                    this.f152k = 0;
                    break;
                case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    G();
                    this.f152k = 0;
                    break;
                case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    E('\'');
                    if (i == 0) {
                        this.f158q[this.f157p - 1] = "<skipped>";
                    }
                    this.f152k = 0;
                    break;
                case 13:
                    E('\"');
                    if (i == 0) {
                        this.f158q[this.f157p - 1] = "<skipped>";
                    }
                    this.f152k = 0;
                    break;
                case 14:
                    G();
                    if (i == 0) {
                        this.f158q[this.f157p - 1] = "<skipped>";
                    }
                    this.f152k = 0;
                    break;
                case 16:
                    this.f149c += this.f154m;
                    this.f152k = 0;
                    break;
                case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    break;
            }
            return;
        } while (i > 0);
        int[] iArr = this.f159r;
        int i6 = this.f157p - 1;
        iArr[i6] = iArr[i6] + 1;
    }

    public final void I(String str) throws c {
        StringBuilder sbN = d.n(str);
        sbN.append(q());
        sbN.append("\nSee ");
        sbN.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
        throw new c(sbN.toString());
    }

    public final IllegalStateException J(String str) {
        String str2 = B() == 9 ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbP = d.p("Expected ", str, " but was ");
        sbP.append(k0.a.j(B()));
        sbP.append(q());
        sbP.append("\nSee ");
        sbP.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(sbP.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f152k = 0;
        this.f156o[0] = 8;
        this.f157p = 1;
        this.f147a.close();
    }

    public void d() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH != 3) {
            throw J("BEGIN_ARRAY");
        }
        C(1);
        this.f159r[this.f157p - 1] = 0;
        this.f152k = 0;
    }

    public void f() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH != 1) {
            throw J("BEGIN_OBJECT");
        }
        C(3);
        this.f152k = 0;
    }

    public final void g() throws c {
        if (this.f160s == 1) {
            return;
        }
        I("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:169:0x0218, code lost:
    
        if (p(r7) != false) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0188 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0270 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.a.h():int");
    }

    public void i() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH != 4) {
            throw J("END_ARRAY");
        }
        int i = this.f157p;
        this.f157p = i - 1;
        int[] iArr = this.f159r;
        int i6 = i - 2;
        iArr[i6] = iArr[i6] + 1;
        this.f152k = 0;
    }

    public void j() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH != 2) {
            throw J("END_OBJECT");
        }
        int i = this.f157p;
        int i6 = i - 1;
        this.f157p = i6;
        this.f158q[i6] = null;
        int[] iArr = this.f159r;
        int i7 = i - 2;
        iArr[i7] = iArr[i7] + 1;
        this.f152k = 0;
    }

    public final boolean k(int i) throws IOException {
        int i6;
        int i7;
        int i8 = this.f151f;
        int i9 = this.f149c;
        this.f151f = i8 - i9;
        int i10 = this.f150d;
        char[] cArr = this.f148b;
        if (i10 != i9) {
            int i11 = i10 - i9;
            this.f150d = i11;
            System.arraycopy(cArr, i9, cArr, 0, i11);
        } else {
            this.f150d = 0;
        }
        this.f149c = 0;
        do {
            int i12 = this.f150d;
            int i13 = this.f147a.read(cArr, i12, cArr.length - i12);
            if (i13 == -1) {
                return false;
            }
            i6 = this.f150d + i13;
            this.f150d = i6;
            if (this.e == 0 && (i7 = this.f151f) == 0 && i6 > 0 && cArr[0] == 65279) {
                this.f149c++;
                this.f151f = i7 + 1;
                i++;
            }
        } while (i6 < i);
        return true;
    }

    public String l() {
        return m(false);
    }

    public final String m(boolean z6) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i6 = this.f157p;
            if (i >= i6) {
                return sb.toString();
            }
            int i7 = this.f156o[i];
            switch (i7) {
                case 1:
                case 2:
                    int i8 = this.f159r[i];
                    if (z6 && i8 > 0 && i == i6 - 1) {
                        i8--;
                    }
                    sb.append('[');
                    sb.append(i8);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.f158q[i];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(d.f(i7, "Unknown scope value: "));
            }
            i++;
        }
    }

    public String n() {
        return m(true);
    }

    public boolean o() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        return (iH == 2 || iH == 4 || iH == 17) ? false : true;
    }

    public final boolean p(char c6) throws c {
        if (c6 == '\t' || c6 == '\n' || c6 == '\f' || c6 == '\r' || c6 == ' ') {
            return false;
        }
        if (c6 != '#') {
            if (c6 == ',') {
                return false;
            }
            if (c6 != '/' && c6 != '=') {
                if (c6 == '{' || c6 == '}' || c6 == ':') {
                    return false;
                }
                if (c6 != ';') {
                    switch (c6) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        g();
        return false;
    }

    final String q() {
        return " at line " + (this.e + 1) + " column " + ((this.f149c - this.f151f) + 1) + " path " + l();
    }

    public boolean r() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH == 5) {
            this.f152k = 0;
            int[] iArr = this.f159r;
            int i = this.f157p - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iH != 6) {
            throw J("a boolean");
        }
        this.f152k = 0;
        int[] iArr2 = this.f159r;
        int i6 = this.f157p - 1;
        iArr2[i6] = iArr2[i6] + 1;
        return false;
    }

    public double s() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH == 15) {
            this.f152k = 0;
            int[] iArr = this.f159r;
            int i = this.f157p - 1;
            iArr[i] = iArr[i] + 1;
            return this.f153l;
        }
        if (iH == 16) {
            this.f155n = new String(this.f148b, this.f149c, this.f154m);
            this.f149c += this.f154m;
        } else if (iH == 8 || iH == 9) {
            this.f155n = y(iH == 8 ? '\'' : '\"');
        } else if (iH == 10) {
            this.f155n = A();
        } else if (iH != 11) {
            throw J("a double");
        }
        this.f152k = 11;
        double d4 = Double.parseDouble(this.f155n);
        if (this.f160s != 1 && (Double.isNaN(d4) || Double.isInfinite(d4))) {
            I("JSON forbids NaN and infinities: " + d4);
            throw null;
        }
        this.f155n = null;
        this.f152k = 0;
        int[] iArr2 = this.f159r;
        int i6 = this.f157p - 1;
        iArr2[i6] = iArr2[i6] + 1;
        return d4;
    }

    public int t() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH == 15) {
            long j4 = this.f153l;
            int i = (int) j4;
            if (j4 != i) {
                throw new NumberFormatException("Expected an int but was " + this.f153l + q());
            }
            this.f152k = 0;
            int[] iArr = this.f159r;
            int i6 = this.f157p - 1;
            iArr[i6] = iArr[i6] + 1;
            return i;
        }
        if (iH == 16) {
            this.f155n = new String(this.f148b, this.f149c, this.f154m);
            this.f149c += this.f154m;
        } else {
            if (iH != 8 && iH != 9 && iH != 10) {
                throw J("an int");
            }
            if (iH == 10) {
                this.f155n = A();
            } else {
                this.f155n = y(iH == 8 ? '\'' : '\"');
            }
            try {
                int i7 = Integer.parseInt(this.f155n);
                this.f152k = 0;
                int[] iArr2 = this.f159r;
                int i8 = this.f157p - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return i7;
            } catch (NumberFormatException unused) {
            }
        }
        this.f152k = 11;
        double d4 = Double.parseDouble(this.f155n);
        int i9 = (int) d4;
        if (i9 != d4) {
            throw new NumberFormatException("Expected an int but was " + this.f155n + q());
        }
        this.f155n = null;
        this.f152k = 0;
        int[] iArr3 = this.f159r;
        int i10 = this.f157p - 1;
        iArr3[i10] = iArr3[i10] + 1;
        return i9;
    }

    public String toString() {
        return getClass().getSimpleName() + q();
    }

    public long u() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH == 15) {
            this.f152k = 0;
            int[] iArr = this.f159r;
            int i = this.f157p - 1;
            iArr[i] = iArr[i] + 1;
            return this.f153l;
        }
        if (iH == 16) {
            this.f155n = new String(this.f148b, this.f149c, this.f154m);
            this.f149c += this.f154m;
        } else {
            if (iH != 8 && iH != 9 && iH != 10) {
                throw J("a long");
            }
            if (iH == 10) {
                this.f155n = A();
            } else {
                this.f155n = y(iH == 8 ? '\'' : '\"');
            }
            try {
                long j4 = Long.parseLong(this.f155n);
                this.f152k = 0;
                int[] iArr2 = this.f159r;
                int i6 = this.f157p - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return j4;
            } catch (NumberFormatException unused) {
            }
        }
        this.f152k = 11;
        double d4 = Double.parseDouble(this.f155n);
        long j6 = (long) d4;
        if (j6 != d4) {
            throw new NumberFormatException("Expected a long but was " + this.f155n + q());
        }
        this.f155n = null;
        this.f152k = 0;
        int[] iArr3 = this.f159r;
        int i7 = this.f157p - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return j6;
    }

    public String v() throws IOException {
        String strY;
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH == 14) {
            strY = A();
        } else if (iH == 12) {
            strY = y('\'');
        } else {
            if (iH != 13) {
                throw J("a name");
            }
            strY = y('\"');
        }
        this.f152k = 0;
        this.f158q[this.f157p - 1] = strY;
        return strY;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int w(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.a.w(boolean):int");
    }

    public void x() throws IOException {
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH != 7) {
            throw J("null");
        }
        this.f152k = 0;
        int[] iArr = this.f159r;
        int i = this.f157p - 1;
        iArr[i] = iArr[i] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r11.f149c = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
    
        r1.append(r5, r3, r2 - r3);
        r11.f149c = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String y(char r12) throws B3.c {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.f149c
            int r3 = r11.f150d
        L6:
            r4 = r3
            r3 = r2
        L8:
            char[] r5 = r11.f148b
            r6 = 1
            r7 = 16
            if (r2 >= r4) goto L6b
            int r8 = r2 + 1
            char r2 = r5[r2]
            int r9 = r11.f160s
            r10 = 3
            if (r9 != r10) goto L23
            r9 = 32
            if (r2 < r9) goto L1d
            goto L23
        L1d:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.I(r12)
            throw r0
        L23:
            if (r2 != r12) goto L39
            r11.f149c = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L31
            java.lang.String r12 = new java.lang.String
            r12.<init>(r5, r3, r8)
            return r12
        L31:
            r1.append(r5, r3, r8)
            java.lang.String r12 = r1.toString()
            return r12
        L39:
            r9 = 92
            if (r2 != r9) goto L5e
            r11.f149c = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L4f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r7)
            r1.<init>(r4)
        L4f:
            r1.append(r5, r3, r2)
            char r2 = r11.D()
            r1.append(r2)
            int r2 = r11.f149c
            int r3 = r11.f150d
            goto L6
        L5e:
            r5 = 10
            if (r2 != r5) goto L69
            int r2 = r11.e
            int r2 = r2 + r6
            r11.e = r2
            r11.f151f = r8
        L69:
            r2 = r8
            goto L8
        L6b:
            if (r1 != 0) goto L7b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r7)
            r4.<init>(r1)
            r1 = r4
        L7b:
            int r4 = r2 - r3
            r1.append(r5, r3, r4)
            r11.f149c = r2
            boolean r2 = r11.k(r6)
            if (r2 == 0) goto L8a
            goto L2
        L8a:
            java.lang.String r12 = "Unterminated string"
            r11.I(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.a.y(char):java.lang.String");
    }

    public String z() throws IOException {
        String str;
        int iH = this.f152k;
        if (iH == 0) {
            iH = h();
        }
        if (iH == 10) {
            str = A();
        } else if (iH == 8) {
            str = y('\'');
        } else if (iH == 9) {
            str = y('\"');
        } else if (iH == 11) {
            str = this.f155n;
            this.f155n = null;
        } else if (iH == 15) {
            str = Long.toString(this.f153l);
        } else {
            if (iH != 16) {
                throw J("a string");
            }
            str = new String(this.f148b, this.f149c, this.f154m);
            this.f149c += this.f154m;
        }
        this.f152k = 0;
        int[] iArr = this.f159r;
        int i = this.f157p - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }
}
