package p4;

import D3.m;
import com.google.gson.internal.F;
import com.google.gson.internal.w;
import com.google.gson.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: p4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2568a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f22320a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f22329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f22331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f22332m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String[] f22334o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f22335p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f22321b = s.LEGACY_STRICT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22322c = 255;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char[] f22323d = new char[1024];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22324e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f22325f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22326g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22327h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22328i = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f22333n = 1;

    /* JADX INFO: renamed from: p4.a$a, reason: collision with other inner class name */
    public class C0377a extends w {
        @Override // com.google.gson.internal.w
        public void a(C2568a c2568a) throws IOException {
            int i8;
            if (c2568a instanceof com.google.gson.internal.bind.a) {
                ((com.google.gson.internal.bind.a) c2568a).P0();
                return;
            }
            int iR = c2568a.f22328i;
            if (iR == 0) {
                iR = c2568a.r();
            }
            if (iR == 13) {
                i8 = 9;
            } else if (iR == 12) {
                i8 = 8;
            } else {
                if (iR != 14) {
                    throw c2568a.J0("a name");
                }
                i8 = 10;
            }
            c2568a.f22328i = i8;
        }
    }

    static {
        w.f16224a = new C0377a();
    }

    public C2568a(Reader reader) {
        int[] iArr = new int[32];
        this.f22332m = iArr;
        iArr[0] = 6;
        this.f22334o = new String[32];
        this.f22335p = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f22320a = reader;
    }

    private String M(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i8 = 0;
        while (true) {
            int i9 = this.f22333n;
            if (i8 >= i9) {
                return sb.toString();
            }
            int i10 = this.f22332m[i8];
            switch (i10) {
                case 1:
                case 2:
                    int i11 = this.f22335p[i8];
                    if (z7 && i11 > 0 && i8 == i9 - 1) {
                        i11--;
                    }
                    sb.append('[');
                    sb.append(i11);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append(com.amazon.a.a.o.c.a.b.f14112a);
                    String str = this.f22334o[i8];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i10);
            }
            i8++;
        }
    }

    public final void A0(int i8) throws C2571d {
        int i9 = this.f22333n;
        if (i9 - 1 >= this.f22322c) {
            throw new C2571d("Nesting limit " + this.f22322c + " reached" + T());
        }
        int[] iArr = this.f22332m;
        if (i9 == iArr.length) {
            int i10 = i9 * 2;
            this.f22332m = Arrays.copyOf(iArr, i10);
            this.f22335p = Arrays.copyOf(this.f22335p, i10);
            this.f22334o = (String[]) Arrays.copyOf(this.f22334o, i10);
        }
        int[] iArr2 = this.f22332m;
        int i11 = this.f22333n;
        this.f22333n = i11 + 1;
        iArr2[i11] = i8;
    }

    public void B() throws IOException {
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR != 4) {
            throw J0("END_ARRAY");
        }
        int i8 = this.f22333n;
        this.f22333n = i8 - 1;
        int[] iArr = this.f22335p;
        int i9 = i8 - 2;
        iArr[i9] = iArr[i9] + 1;
        this.f22328i = 0;
    }

    public final char B0() throws C2571d {
        int i8;
        if (this.f22324e == this.f22325f && !E(1)) {
            throw I0("Unterminated escape sequence");
        }
        char[] cArr = this.f22323d;
        int i9 = this.f22324e;
        int i10 = i9 + 1;
        this.f22324e = i10;
        char c8 = cArr[i9];
        if (c8 != '\n') {
            if (c8 != '\"') {
                if (c8 != '\'') {
                    if (c8 != '/' && c8 != '\\') {
                        if (c8 == 'b') {
                            return '\b';
                        }
                        if (c8 == 'f') {
                            return '\f';
                        }
                        if (c8 == 'n') {
                            return '\n';
                        }
                        if (c8 == 'r') {
                            return '\r';
                        }
                        if (c8 == 't') {
                            return '\t';
                        }
                        if (c8 != 'u') {
                            throw I0("Invalid escape sequence");
                        }
                        if (i9 + 5 > this.f22325f && !E(4)) {
                            throw I0("Unterminated escape sequence");
                        }
                        int i11 = this.f22324e;
                        int i12 = i11 + 4;
                        int i13 = 0;
                        while (i11 < i12) {
                            char c9 = this.f22323d[i11];
                            int i14 = i13 << 4;
                            if (c9 >= '0' && c9 <= '9') {
                                i8 = c9 - '0';
                            } else if (c9 >= 'a' && c9 <= 'f') {
                                i8 = c9 - 'W';
                            } else {
                                if (c9 < 'A' || c9 > 'F') {
                                    throw I0("Malformed Unicode escape \\u" + new String(this.f22323d, this.f22324e, 4));
                                }
                                i8 = c9 - '7';
                            }
                            i13 = i14 + i8;
                            i11++;
                        }
                        this.f22324e += 4;
                        return (char) i13;
                    }
                }
            }
            return c8;
        }
        if (this.f22321b == s.STRICT) {
            throw I0("Cannot escape a newline character in strict mode");
        }
        this.f22326g++;
        this.f22327h = i10;
        if (this.f22321b == s.STRICT) {
            throw I0("Invalid escaped character \"'\" in strict mode");
        }
        return c8;
    }

    public final void C0(s sVar) {
        Objects.requireNonNull(sVar);
        this.f22321b = sVar;
    }

    public void D() throws IOException {
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR != 2) {
            throw J0("END_OBJECT");
        }
        int i8 = this.f22333n;
        int i9 = i8 - 1;
        this.f22333n = i9;
        this.f22334o[i9] = null;
        int[] iArr = this.f22335p;
        int i10 = i8 - 2;
        iArr[i10] = iArr[i10] + 1;
        this.f22328i = 0;
    }

    public final void D0(char c8) throws C2571d {
        char[] cArr = this.f22323d;
        while (true) {
            int i8 = this.f22324e;
            int i9 = this.f22325f;
            while (true) {
                if (i8 < i9) {
                    int i10 = i8 + 1;
                    char c9 = cArr[i8];
                    if (c9 == c8) {
                        this.f22324e = i10;
                        return;
                    }
                    if (c9 == '\\') {
                        this.f22324e = i10;
                        B0();
                        break;
                    } else {
                        if (c9 == '\n') {
                            this.f22326g++;
                            this.f22327h = i10;
                        }
                        i8 = i10;
                    }
                } else {
                    this.f22324e = i8;
                    if (!E(1)) {
                        throw I0("Unterminated string");
                    }
                }
            }
        }
    }

    public final boolean E(int i8) throws IOException {
        int i9;
        int i10;
        char[] cArr = this.f22323d;
        int i11 = this.f22327h;
        int i12 = this.f22324e;
        this.f22327h = i11 - i12;
        int i13 = this.f22325f;
        if (i13 != i12) {
            int i14 = i13 - i12;
            this.f22325f = i14;
            System.arraycopy(cArr, i12, cArr, 0, i14);
        } else {
            this.f22325f = 0;
        }
        this.f22324e = 0;
        do {
            Reader reader = this.f22320a;
            int i15 = this.f22325f;
            int i16 = reader.read(cArr, i15, cArr.length - i15);
            if (i16 == -1) {
                return false;
            }
            i9 = this.f22325f + i16;
            this.f22325f = i9;
            if (this.f22326g == 0 && (i10 = this.f22327h) == 0 && i9 > 0 && cArr[0] == 65279) {
                this.f22324e++;
                this.f22327h = i10 + 1;
                i8++;
            }
        } while (i9 < i8);
        return true;
    }

    public final boolean E0(String str) {
        int length = str.length();
        while (true) {
            if (this.f22324e + length > this.f22325f && !E(length)) {
                return false;
            }
            char[] cArr = this.f22323d;
            int i8 = this.f22324e;
            if (cArr[i8] != '\n') {
                for (int i9 = 0; i9 < length; i9++) {
                    if (this.f22323d[this.f22324e + i9] != str.charAt(i9)) {
                        break;
                    }
                }
                return true;
            }
            this.f22326g++;
            this.f22327h = i8 + 1;
            this.f22324e++;
        }
    }

    public final void F0() {
        char c8;
        do {
            if (this.f22324e >= this.f22325f && !E(1)) {
                return;
            }
            char[] cArr = this.f22323d;
            int i8 = this.f22324e;
            int i9 = i8 + 1;
            this.f22324e = i9;
            c8 = cArr[i8];
            if (c8 == '\n') {
                this.f22326g++;
                this.f22327h = i9;
                return;
            }
        } while (c8 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G0() throws p4.C2571d {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f22324e
            int r2 = r1 + r0
            int r3 = r4.f22325f
            if (r2 >= r3) goto L51
            char[] r2 = r4.f22323d
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
            r4.f()
        L4b:
            int r1 = r4.f22324e
            int r1 = r1 + r0
            r4.f22324e = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f22324e = r1
            r0 = 1
            boolean r0 = r4.E(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.C2568a.G0():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void H0() throws IOException {
        int i8 = 0;
        do {
            int iR = this.f22328i;
            if (iR == 0) {
                iR = r();
            }
            switch (iR) {
                case 1:
                    A0(3);
                    i8++;
                    this.f22328i = 0;
                    break;
                case 2:
                    if (i8 == 0) {
                        this.f22334o[this.f22333n - 1] = null;
                    }
                    this.f22333n--;
                    i8--;
                    this.f22328i = 0;
                    break;
                case 3:
                    A0(1);
                    i8++;
                    this.f22328i = 0;
                    break;
                case 4:
                    this.f22333n--;
                    i8--;
                    this.f22328i = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                case 15:
                default:
                    this.f22328i = 0;
                    break;
                case 8:
                    D0('\'');
                    this.f22328i = 0;
                    break;
                case 9:
                    D0('\"');
                    this.f22328i = 0;
                    break;
                case 10:
                    G0();
                    this.f22328i = 0;
                    break;
                case 12:
                    D0('\'');
                    if (i8 == 0) {
                        this.f22334o[this.f22333n - 1] = "<skipped>";
                    }
                    this.f22328i = 0;
                    break;
                case 13:
                    D0('\"');
                    if (i8 == 0) {
                        this.f22334o[this.f22333n - 1] = "<skipped>";
                    }
                    this.f22328i = 0;
                    break;
                case 14:
                    G0();
                    if (i8 == 0) {
                        this.f22334o[this.f22333n - 1] = "<skipped>";
                    }
                    this.f22328i = 0;
                    break;
                case com.amazon.c.a.a.c.f14230g /* 16 */:
                    this.f22324e += this.f22330k;
                    this.f22328i = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i8 > 0);
        int[] iArr = this.f22335p;
        int i9 = this.f22333n - 1;
        iArr[i9] = iArr[i9] + 1;
    }

    public final C2571d I0(String str) throws C2571d {
        throw new C2571d(str + T() + "\nSee " + F.a("malformed-json"));
    }

    public final IllegalStateException J0(String str) {
        return new IllegalStateException("Expected " + str + " but was " + x0() + T() + "\nSee " + F.a(x0() == EnumC2569b.NULL ? "adapter-not-null-safe" : "unexpected-json-structure"));
    }

    public String K() {
        return M(false);
    }

    public String N() {
        return M(true);
    }

    public final s O() {
        return this.f22321b;
    }

    public boolean Q() throws IOException {
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        return (iR == 2 || iR == 4 || iR == 17) ? false : true;
    }

    public final boolean R() {
        return this.f22321b == s.LENIENT;
    }

    public final boolean S(char c8) throws C2571d {
        if (c8 == '\t' || c8 == '\n' || c8 == '\f' || c8 == '\r' || c8 == ' ') {
            return false;
        }
        if (c8 != '#') {
            if (c8 == ',') {
                return false;
            }
            if (c8 != '/' && c8 != '=') {
                if (c8 == '{' || c8 == '}' || c8 == ':') {
                    return false;
                }
                if (c8 != ';') {
                    switch (c8) {
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
        f();
        return false;
    }

    public String T() {
        return " at line " + (this.f22326g + 1) + " column " + ((this.f22324e - this.f22327h) + 1) + " path " + K();
    }

    public boolean U() throws IOException {
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 5) {
            this.f22328i = 0;
            int[] iArr = this.f22335p;
            int i8 = this.f22333n - 1;
            iArr[i8] = iArr[i8] + 1;
            return true;
        }
        if (iR != 6) {
            throw J0("a boolean");
        }
        this.f22328i = 0;
        int[] iArr2 = this.f22335p;
        int i9 = this.f22333n - 1;
        iArr2[i9] = iArr2[i9] + 1;
        return false;
    }

    public double W() throws IOException {
        String strS0;
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 15) {
            this.f22328i = 0;
            int[] iArr = this.f22335p;
            int i8 = this.f22333n - 1;
            iArr[i8] = iArr[i8] + 1;
            return this.f22329j;
        }
        if (iR == 16) {
            this.f22331l = new String(this.f22323d, this.f22324e, this.f22330k);
            this.f22324e += this.f22330k;
        } else {
            if (iR == 8 || iR == 9) {
                strS0 = s0(iR == 8 ? '\'' : '\"');
            } else if (iR == 10) {
                strS0 = w0();
            } else if (iR != 11) {
                throw J0("a double");
            }
            this.f22331l = strS0;
        }
        this.f22328i = 11;
        double d8 = Double.parseDouble(this.f22331l);
        if (this.f22321b != s.LENIENT && (Double.isNaN(d8) || Double.isInfinite(d8))) {
            throw I0("JSON forbids NaN and infinities: " + d8);
        }
        this.f22331l = null;
        this.f22328i = 0;
        int[] iArr2 = this.f22335p;
        int i9 = this.f22333n - 1;
        iArr2[i9] = iArr2[i9] + 1;
        return d8;
    }

    public int X() throws IOException {
        String strS0;
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 15) {
            long j8 = this.f22329j;
            int i8 = (int) j8;
            if (j8 == i8) {
                this.f22328i = 0;
                int[] iArr = this.f22335p;
                int i9 = this.f22333n - 1;
                iArr[i9] = iArr[i9] + 1;
                return i8;
            }
            throw new NumberFormatException("Expected an int but was " + this.f22329j + T());
        }
        if (iR == 16) {
            this.f22331l = new String(this.f22323d, this.f22324e, this.f22330k);
            this.f22324e += this.f22330k;
        } else {
            if (iR != 8 && iR != 9 && iR != 10) {
                throw J0("an int");
            }
            if (iR == 10) {
                strS0 = w0();
            } else {
                strS0 = s0(iR == 8 ? '\'' : '\"');
            }
            this.f22331l = strS0;
            try {
                int i10 = Integer.parseInt(this.f22331l);
                this.f22328i = 0;
                int[] iArr2 = this.f22335p;
                int i11 = this.f22333n - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return i10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f22328i = 11;
        double d8 = Double.parseDouble(this.f22331l);
        int i12 = (int) d8;
        if (i12 != d8) {
            throw new NumberFormatException("Expected an int but was " + this.f22331l + T());
        }
        this.f22331l = null;
        this.f22328i = 0;
        int[] iArr3 = this.f22335p;
        int i13 = this.f22333n - 1;
        iArr3[i13] = iArr3[i13] + 1;
        return i12;
    }

    public long b0() throws IOException {
        String strS0;
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 15) {
            this.f22328i = 0;
            int[] iArr = this.f22335p;
            int i8 = this.f22333n - 1;
            iArr[i8] = iArr[i8] + 1;
            return this.f22329j;
        }
        if (iR == 16) {
            this.f22331l = new String(this.f22323d, this.f22324e, this.f22330k);
            this.f22324e += this.f22330k;
        } else {
            if (iR != 8 && iR != 9 && iR != 10) {
                throw J0("a long");
            }
            if (iR == 10) {
                strS0 = w0();
            } else {
                strS0 = s0(iR == 8 ? '\'' : '\"');
            }
            this.f22331l = strS0;
            try {
                long j8 = Long.parseLong(this.f22331l);
                this.f22328i = 0;
                int[] iArr2 = this.f22335p;
                int i9 = this.f22333n - 1;
                iArr2[i9] = iArr2[i9] + 1;
                return j8;
            } catch (NumberFormatException unused) {
            }
        }
        this.f22328i = 11;
        double d8 = Double.parseDouble(this.f22331l);
        long j9 = (long) d8;
        if (j9 != d8) {
            throw new NumberFormatException("Expected a long but was " + this.f22331l + T());
        }
        this.f22331l = null;
        this.f22328i = 0;
        int[] iArr3 = this.f22335p;
        int i10 = this.f22333n - 1;
        iArr3[i10] = iArr3[i10] + 1;
        return j9;
    }

    public void c() throws IOException {
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR != 3) {
            throw J0("BEGIN_ARRAY");
        }
        A0(1);
        this.f22335p[this.f22333n - 1] = 0;
        this.f22328i = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22328i = 0;
        this.f22332m[0] = 8;
        this.f22333n = 1;
        this.f22320a.close();
    }

    public void e() throws IOException {
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR != 1) {
            throw J0("BEGIN_OBJECT");
        }
        A0(3);
        this.f22328i = 0;
    }

    public final void f() throws C2571d {
        if (this.f22321b != s.LENIENT) {
            throw I0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    public String i0() throws IOException {
        char c8;
        String strS0;
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 14) {
            strS0 = w0();
        } else {
            if (iR == 12) {
                c8 = '\'';
            } else {
                if (iR != 13) {
                    throw J0("a name");
                }
                c8 = '\"';
            }
            strS0 = s0(c8);
        }
        this.f22328i = 0;
        this.f22334o[this.f22333n - 1] = strS0;
        return strS0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
    
        if (r5 != '/') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        r8.f22324e = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        if (r4 != r2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        r8.f22324e = r1;
        r1 = E(2);
        r8.f22324e++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
    
        if (r1 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0067, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        f();
        r1 = r8.f22324e;
        r2 = r0[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
    
        if (r2 == '*') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
    
        if (r2 == '/') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0076, code lost:
    
        r8.f22324e = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007e, code lost:
    
        r8.f22324e = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        if (E0("*\/") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:
    
        throw I0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
    
        r8.f22324e = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
    
        if (r5 != '#') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009c, code lost:
    
        f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a0, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m0(boolean r9) throws java.io.IOException {
        /*
            r8 = this;
            char[] r0 = r8.f22323d
        L2:
            int r1 = r8.f22324e
        L4:
            int r2 = r8.f22325f
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r8.f22324e = r1
            boolean r1 = r8.E(r3)
            if (r1 != 0) goto L30
            if (r9 != 0) goto L15
            r9 = -1
            return r9
        L15:
            java.io.EOFException r9 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r1 = r8.T()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L30:
            int r1 = r8.f22324e
            int r2 = r8.f22325f
        L34:
            int r4 = r1 + 1
            char r5 = r0[r1]
            r6 = 10
            if (r5 != r6) goto L44
            int r1 = r8.f22326g
            int r1 = r1 + r3
            r8.f22326g = r1
            r8.f22327h = r4
            goto La1
        L44:
            r6 = 32
            if (r5 == r6) goto La1
            r6 = 13
            if (r5 == r6) goto La1
            r6 = 9
            if (r5 != r6) goto L51
            goto La1
        L51:
            r6 = 47
            if (r5 != r6) goto L96
            r8.f22324e = r4
            r7 = 2
            if (r4 != r2) goto L68
            r8.f22324e = r1
            boolean r1 = r8.E(r7)
            int r2 = r8.f22324e
            int r2 = r2 + r3
            r8.f22324e = r2
            if (r1 != 0) goto L68
            return r5
        L68:
            r8.f()
            int r1 = r8.f22324e
            char r2 = r0[r1]
            r3 = 42
            if (r2 == r3) goto L7e
            if (r2 == r6) goto L76
            return r5
        L76:
            int r1 = r1 + 1
            r8.f22324e = r1
        L7a:
            r8.F0()
            goto L2
        L7e:
            int r1 = r1 + 1
            r8.f22324e = r1
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r8.E0(r1)
            if (r1 == 0) goto L8f
            int r1 = r8.f22324e
            int r1 = r1 + r7
            goto L4
        L8f:
            java.lang.String r9 = "Unterminated comment"
            p4.d r9 = r8.I0(r9)
            throw r9
        L96:
            r1 = 35
            r8.f22324e = r4
            if (r5 != r1) goto La0
            r8.f()
            goto L7a
        La0:
            return r5
        La1:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.C2568a.m0(boolean):int");
    }

    public final void n() throws IOException {
        m0(true);
        int i8 = this.f22324e;
        this.f22324e = i8 - 1;
        if (i8 + 4 <= this.f22325f || E(5)) {
            int i9 = this.f22324e;
            char[] cArr = this.f22323d;
            if (cArr[i9] == ')' && cArr[i9 + 1] == ']' && cArr[i9 + 2] == '}' && cArr[i9 + 3] == '\'' && cArr[i9 + 4] == '\n') {
                this.f22324e = i9 + 5;
            }
        }
    }

    public int r() throws IOException {
        int i8;
        int iM0;
        int[] iArr = this.f22332m;
        int i9 = this.f22333n;
        int i10 = iArr[i9 - 1];
        if (i10 == 1) {
            iArr[i9 - 1] = 2;
        } else {
            if (i10 != 2) {
                if (i10 == 3 || i10 == 5) {
                    iArr[i9 - 1] = 4;
                    if (i10 == 5 && (iM0 = m0(true)) != 44) {
                        if (iM0 != 59) {
                            if (iM0 != 125) {
                                throw I0("Unterminated object");
                            }
                            this.f22328i = 2;
                            return 2;
                        }
                        f();
                    }
                    int iM02 = m0(true);
                    if (iM02 == 34) {
                        i8 = 13;
                    } else if (iM02 == 39) {
                        f();
                        i8 = 12;
                    } else {
                        if (iM02 == 125) {
                            if (i10 == 5) {
                                throw I0("Expected name");
                            }
                            this.f22328i = 2;
                            return 2;
                        }
                        f();
                        this.f22324e--;
                        if (!S((char) iM02)) {
                            throw I0("Expected name");
                        }
                        i8 = 14;
                    }
                } else if (i10 == 4) {
                    iArr[i9 - 1] = 5;
                    int iM03 = m0(true);
                    if (iM03 != 58) {
                        if (iM03 != 61) {
                            throw I0("Expected ':'");
                        }
                        f();
                        if (this.f22324e < this.f22325f || E(1)) {
                            char[] cArr = this.f22323d;
                            int i11 = this.f22324e;
                            if (cArr[i11] == '>') {
                                this.f22324e = i11 + 1;
                            }
                        }
                    }
                } else if (i10 == 6) {
                    if (this.f22321b == s.LENIENT) {
                        n();
                    }
                    this.f22332m[this.f22333n - 1] = 7;
                } else if (i10 == 7) {
                    if (m0(false) == -1) {
                        i8 = 17;
                    } else {
                        f();
                        this.f22324e--;
                    }
                } else if (i10 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                this.f22328i = i8;
                return i8;
            }
            int iM04 = m0(true);
            if (iM04 != 44) {
                if (iM04 != 59) {
                    if (iM04 != 93) {
                        throw I0("Unterminated array");
                    }
                    this.f22328i = 4;
                    return 4;
                }
                f();
            }
        }
        int iM05 = m0(true);
        if (iM05 != 34) {
            if (iM05 == 39) {
                f();
                this.f22328i = 8;
                return 8;
            }
            if (iM05 != 44 && iM05 != 59) {
                if (iM05 == 91) {
                    this.f22328i = 3;
                    return 3;
                }
                if (iM05 != 93) {
                    if (iM05 == 123) {
                        this.f22328i = 1;
                        return 1;
                    }
                    this.f22324e--;
                    int iY0 = y0();
                    if (iY0 != 0) {
                        return iY0;
                    }
                    int iZ0 = z0();
                    if (iZ0 != 0) {
                        return iZ0;
                    }
                    if (!S(this.f22323d[this.f22324e])) {
                        throw I0("Expected value");
                    }
                    f();
                    i8 = 10;
                } else if (i10 == 1) {
                    this.f22328i = 4;
                    return 4;
                }
            }
            if (i10 != 1 && i10 != 2) {
                throw I0("Unexpected value");
            }
            f();
            this.f22324e--;
            this.f22328i = 7;
            return 7;
        }
        i8 = 9;
        this.f22328i = i8;
        return i8;
    }

    public void r0() throws IOException {
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR != 7) {
            throw J0("null");
        }
        this.f22328i = 0;
        int[] iArr = this.f22335p;
        int i8 = this.f22333n - 1;
        iArr[i8] = iArr[i8] + 1;
    }

    public final String s0(char c8) throws C2571d {
        char[] cArr = this.f22323d;
        StringBuilder sb = null;
        while (true) {
            int i8 = this.f22324e;
            int i9 = this.f22325f;
            while (true) {
                if (i8 < i9) {
                    int i10 = i8 + 1;
                    char c9 = cArr[i8];
                    if (this.f22321b == s.STRICT && c9 < ' ') {
                        throw I0("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                    }
                    if (c9 == c8) {
                        this.f22324e = i10;
                        int i11 = (i10 - i8) - 1;
                        if (sb == null) {
                            return new String(cArr, i8, i11);
                        }
                        sb.append(cArr, i8, i11);
                        return sb.toString();
                    }
                    if (c9 == '\\') {
                        this.f22324e = i10;
                        int i12 = i10 - i8;
                        int i13 = i12 - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max(i12 * 2, 16));
                        }
                        sb.append(cArr, i8, i13);
                        sb.append(B0());
                    } else {
                        if (c9 == '\n') {
                            this.f22326g++;
                            this.f22327h = i10;
                        }
                        i8 = i10;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i8 - i8) * 2, 16));
                    }
                    sb.append(cArr, i8, i8 - i8);
                    this.f22324e = i8;
                    if (!E(1)) {
                        throw I0("Unterminated string");
                    }
                }
            }
        }
    }

    public String toString() {
        return getClass().getSimpleName() + T();
    }

    public String v0() throws IOException {
        String str;
        char c8;
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 10) {
            str = w0();
        } else {
            if (iR == 8) {
                c8 = '\'';
            } else if (iR == 9) {
                c8 = '\"';
            } else if (iR == 11) {
                str = this.f22331l;
                this.f22331l = null;
            } else if (iR == 15) {
                str = Long.toString(this.f22329j);
            } else {
                if (iR != 16) {
                    throw J0("a string");
                }
                str = new String(this.f22323d, this.f22324e, this.f22330k);
                this.f22324e += this.f22330k;
            }
            str = s0(c8);
        }
        this.f22328i = 0;
        int[] iArr = this.f22335p;
        int i8 = this.f22333n - 1;
        iArr[i8] = iArr[i8] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        f();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String w0() throws p4.C2571d {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f22324e
            int r4 = r3 + r2
            int r5 = r6.f22325f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f22323d
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.f()
            goto L5c
        L4e:
            char[] r3 = r6.f22323d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.E(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f22323d
            int r4 = r6.f22324e
            r0.append(r3, r4, r2)
            int r3 = r6.f22324e
            int r3 = r3 + r2
            r6.f22324e = r3
            r2 = 1
            boolean r2 = r6.E(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f22323d
            int r3 = r6.f22324e
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f22323d
            int r3 = r6.f22324e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f22324e
            int r2 = r2 + r1
            r6.f22324e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.C2568a.w0():java.lang.String");
    }

    public EnumC2569b x0() throws IOException {
        int iR = this.f22328i;
        if (iR == 0) {
            iR = r();
        }
        switch (iR) {
            case 1:
                return EnumC2569b.BEGIN_OBJECT;
            case 2:
                return EnumC2569b.END_OBJECT;
            case 3:
                return EnumC2569b.BEGIN_ARRAY;
            case 4:
                return EnumC2569b.END_ARRAY;
            case 5:
            case 6:
                return EnumC2569b.BOOLEAN;
            case 7:
                return EnumC2569b.NULL;
            case 8:
            case 9:
            case 10:
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return EnumC2569b.STRING;
            case 12:
            case 13:
            case 14:
                return EnumC2569b.NAME;
            case 15:
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                return EnumC2569b.NUMBER;
            case 17:
                return EnumC2569b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final int y0() {
        String str;
        String str2;
        int i8;
        char c8 = this.f22323d[this.f22324e];
        if (c8 == 't' || c8 == 'T') {
            str = com.amazon.a.a.o.b.af;
            str2 = "TRUE";
            i8 = 5;
        } else if (c8 == 'f' || c8 == 'F') {
            str = com.amazon.a.a.o.b.ag;
            str2 = "FALSE";
            i8 = 6;
        } else {
            if (c8 != 'n' && c8 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i8 = 7;
        }
        boolean z7 = this.f22321b != s.STRICT;
        int length = str.length();
        for (int i9 = 0; i9 < length; i9++) {
            if (this.f22324e + i9 >= this.f22325f && !E(i9 + 1)) {
                return 0;
            }
            char c9 = this.f22323d[this.f22324e + i9];
            if (c9 != str.charAt(i9) && (!z7 || c9 != str2.charAt(i9))) {
                return 0;
            }
        }
        if ((this.f22324e + length < this.f22325f || E(length + 1)) && S(this.f22323d[this.f22324e + length])) {
            return 0;
        }
        this.f22324e += length;
        this.f22328i = i8;
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
    
        if (S(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
    
        if (r9 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
    
        if (r10 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
    
        if (r13 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        if (r13 != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ab, code lost:
    
        r18.f22329j = r11;
        r18.f22324e += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b4, code lost:
    
        r18.f22328i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b6, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b7, code lost:
    
        if (r9 == 2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ba, code lost:
    
        if (r9 == 4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00bd, code lost:
    
        if (r9 != 7) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c2, code lost:
    
        r18.f22330k = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c7, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int z0() {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.C2568a.z0():int");
    }
}
