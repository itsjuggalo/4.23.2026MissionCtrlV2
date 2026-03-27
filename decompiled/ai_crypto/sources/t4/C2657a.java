package t4;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import k4.C2105D;
import l4.t;
import n4.G;
import n4.x;
import o4.C2315g;

/* JADX INFO: renamed from: t4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2657a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f23123a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f23132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f23133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f23134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f23135m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String[] f23137o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f23138p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f23124b = t.LEGACY_STRICT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23125c = 255;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char[] f23126d = new char[1024];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23127e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f23128f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f23129g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f23130h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f23131i = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f23136n = 1;

    /* JADX INFO: renamed from: t4.a$a, reason: collision with other inner class name */
    public class C0366a extends x {
        @Override // n4.x
        public void a(C2657a c2657a) throws IOException {
            if (c2657a instanceof C2315g) {
                ((C2315g) c2657a).e1();
                return;
            }
            int iK = c2657a.f23131i;
            if (iK == 0) {
                iK = c2657a.K();
            }
            if (iK == 13) {
                c2657a.f23131i = 9;
            } else if (iK == 12) {
                c2657a.f23131i = 8;
            } else {
                if (iK != 14) {
                    throw c2657a.Y0("a name");
                }
                c2657a.f23131i = 10;
            }
        }
    }

    static {
        x.f19680a = new C0366a();
    }

    public C2657a(Reader reader) {
        int[] iArr = new int[32];
        this.f23135m = iArr;
        iArr[0] = 6;
        this.f23137o = new String[32];
        this.f23138p = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f23123a = reader;
    }

    private String X(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i7 = 0;
        while (true) {
            int i8 = this.f23136n;
            if (i7 >= i8) {
                return sb.toString();
            }
            int i9 = this.f23135m[i7];
            switch (i9) {
                case 1:
                case 2:
                    int i10 = this.f23138p[i7];
                    if (z7 && i10 > 0 && i7 == i8 - 1) {
                        i10--;
                    }
                    sb.append('[');
                    sb.append(i10);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append(com.amazon.a.a.o.c.a.b.f10001a);
                    String str = this.f23137o[i7];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i9);
            }
            i7++;
        }
    }

    public void A() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK != 1) {
            throw Y0("BEGIN_OBJECT");
        }
        P0(3);
        this.f23131i = 0;
    }

    public final boolean A0(char c7) throws d {
        if (c7 == '\t' || c7 == '\n' || c7 == '\f' || c7 == '\r' || c7 == ' ') {
            return false;
        }
        if (c7 != '#') {
            if (c7 == ',') {
                return false;
            }
            if (c7 != '/' && c7 != '=') {
                if (c7 == '{' || c7 == '}' || c7 == ':') {
                    return false;
                }
                if (c7 != ';') {
                    switch (c7) {
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
        G();
        return false;
    }

    public String B0() {
        return " at line " + (this.f23129g + 1) + " column " + ((this.f23127e - this.f23130h) + 1) + " path " + V();
    }

    public boolean C0() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK == 5) {
            this.f23131i = 0;
            int[] iArr = this.f23138p;
            int i7 = this.f23136n - 1;
            iArr[i7] = iArr[i7] + 1;
            return true;
        }
        if (iK != 6) {
            throw Y0("a boolean");
        }
        this.f23131i = 0;
        int[] iArr2 = this.f23138p;
        int i8 = this.f23136n - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return false;
    }

    public double D0() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK == 15) {
            this.f23131i = 0;
            int[] iArr = this.f23138p;
            int i7 = this.f23136n - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.f23132j;
        }
        if (iK == 16) {
            this.f23134l = new String(this.f23126d, this.f23127e, this.f23133k);
            this.f23127e += this.f23133k;
        } else if (iK == 8 || iK == 9) {
            this.f23134l = J0(iK == 8 ? '\'' : '\"');
        } else if (iK == 10) {
            this.f23134l = L0();
        } else if (iK != 11) {
            throw Y0("a double");
        }
        this.f23131i = 11;
        double d7 = Double.parseDouble(this.f23134l);
        if (this.f23124b != t.LENIENT && (Double.isNaN(d7) || Double.isInfinite(d7))) {
            throw X0("JSON forbids NaN and infinities: " + d7);
        }
        this.f23134l = null;
        this.f23131i = 0;
        int[] iArr2 = this.f23138p;
        int i8 = this.f23136n - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return d7;
    }

    public int E0() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK == 15) {
            long j7 = this.f23132j;
            int i7 = (int) j7;
            if (j7 == i7) {
                this.f23131i = 0;
                int[] iArr = this.f23138p;
                int i8 = this.f23136n - 1;
                iArr[i8] = iArr[i8] + 1;
                return i7;
            }
            throw new NumberFormatException("Expected an int but was " + this.f23132j + B0());
        }
        if (iK == 16) {
            this.f23134l = new String(this.f23126d, this.f23127e, this.f23133k);
            this.f23127e += this.f23133k;
        } else {
            if (iK != 8 && iK != 9 && iK != 10) {
                throw Y0("an int");
            }
            if (iK == 10) {
                this.f23134l = L0();
            } else {
                this.f23134l = J0(iK == 8 ? '\'' : '\"');
            }
            try {
                int i9 = Integer.parseInt(this.f23134l);
                this.f23131i = 0;
                int[] iArr2 = this.f23138p;
                int i10 = this.f23136n - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return i9;
            } catch (NumberFormatException unused) {
            }
        }
        this.f23131i = 11;
        double d7 = Double.parseDouble(this.f23134l);
        int i11 = (int) d7;
        if (i11 != d7) {
            throw new NumberFormatException("Expected an int but was " + this.f23134l + B0());
        }
        this.f23134l = null;
        this.f23131i = 0;
        int[] iArr3 = this.f23138p;
        int i12 = this.f23136n - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return i11;
    }

    public long F0() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK == 15) {
            this.f23131i = 0;
            int[] iArr = this.f23138p;
            int i7 = this.f23136n - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.f23132j;
        }
        if (iK == 16) {
            this.f23134l = new String(this.f23126d, this.f23127e, this.f23133k);
            this.f23127e += this.f23133k;
        } else {
            if (iK != 8 && iK != 9 && iK != 10) {
                throw Y0("a long");
            }
            if (iK == 10) {
                this.f23134l = L0();
            } else {
                this.f23134l = J0(iK == 8 ? '\'' : '\"');
            }
            try {
                long j7 = Long.parseLong(this.f23134l);
                this.f23131i = 0;
                int[] iArr2 = this.f23138p;
                int i8 = this.f23136n - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return j7;
            } catch (NumberFormatException unused) {
            }
        }
        this.f23131i = 11;
        double d7 = Double.parseDouble(this.f23134l);
        long j8 = (long) d7;
        if (j8 != d7) {
            throw new NumberFormatException("Expected a long but was " + this.f23134l + B0());
        }
        this.f23134l = null;
        this.f23131i = 0;
        int[] iArr3 = this.f23138p;
        int i9 = this.f23136n - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return j8;
    }

    public final void G() throws d {
        if (this.f23124b != t.LENIENT) {
            throw X0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    public String G0() throws IOException {
        String strJ0;
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK == 14) {
            strJ0 = L0();
        } else if (iK == 12) {
            strJ0 = J0('\'');
        } else {
            if (iK != 13) {
                throw Y0("a name");
            }
            strJ0 = J0('\"');
        }
        this.f23131i = 0;
        this.f23137o[this.f23136n - 1] = strJ0;
        return strJ0;
    }

    public final void H() throws IOException {
        H0(true);
        int i7 = this.f23127e;
        this.f23127e = i7 - 1;
        if (i7 + 4 <= this.f23128f || T(5)) {
            int i8 = this.f23127e;
            char[] cArr = this.f23126d;
            if (cArr[i8] == ')' && cArr[i8 + 1] == ']' && cArr[i8 + 2] == '}' && cArr[i8 + 3] == '\'' && cArr[i8 + 4] == '\n') {
                this.f23127e = i8 + 5;
            }
        }
    }

    public final int H0(boolean z7) throws IOException {
        char[] cArr = this.f23126d;
        int i7 = this.f23127e;
        int i8 = this.f23128f;
        while (true) {
            if (i7 == i8) {
                this.f23127e = i7;
                if (!T(1)) {
                    if (!z7) {
                        return -1;
                    }
                    throw new EOFException("End of input" + B0());
                }
                i7 = this.f23127e;
                i8 = this.f23128f;
            }
            int i9 = i7 + 1;
            char c7 = cArr[i7];
            if (c7 == '\n') {
                this.f23129g++;
                this.f23130h = i9;
            } else if (c7 != ' ' && c7 != '\r' && c7 != '\t') {
                if (c7 == '/') {
                    this.f23127e = i9;
                    if (i9 == i8) {
                        this.f23127e = i7;
                        boolean zT = T(2);
                        this.f23127e++;
                        if (!zT) {
                            return c7;
                        }
                    }
                    G();
                    int i10 = this.f23127e;
                    char c8 = cArr[i10];
                    if (c8 == '*') {
                        this.f23127e = i10 + 1;
                        if (!T0("*/")) {
                            throw X0("Unterminated comment");
                        }
                        i7 = this.f23127e + 2;
                        i8 = this.f23128f;
                    } else {
                        if (c8 != '/') {
                            return c7;
                        }
                        this.f23127e = i10 + 1;
                        U0();
                        i7 = this.f23127e;
                        i8 = this.f23128f;
                    }
                } else {
                    if (c7 != '#') {
                        this.f23127e = i9;
                        return c7;
                    }
                    this.f23127e = i9;
                    G();
                    U0();
                    i7 = this.f23127e;
                    i8 = this.f23128f;
                }
            }
            i7 = i9;
        }
    }

    public void I0() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK != 7) {
            throw Y0("null");
        }
        this.f23131i = 0;
        int[] iArr = this.f23138p;
        int i7 = this.f23136n - 1;
        iArr[i7] = iArr[i7] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r10.f23127e = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String J0(char r11) throws t4.d {
        /*
            r10 = this;
            char[] r0 = r10.f23126d
            r1 = 0
        L3:
            int r2 = r10.f23127e
            int r3 = r10.f23128f
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L6c
            int r7 = r2 + 1
            char r2 = r0[r2]
            l4.t r8 = r10.f23124b
            l4.t r9 = l4.t.STRICT
            if (r8 != r9) goto L24
            r8 = 32
            if (r2 < r8) goto L1d
            goto L24
        L1d:
            java.lang.String r11 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            t4.d r11 = r10.X0(r11)
            throw r11
        L24:
            if (r2 != r11) goto L3a
            r10.f23127e = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L32
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r3, r7)
            return r11
        L32:
            r1.append(r0, r3, r7)
            java.lang.String r11 = r1.toString()
            return r11
        L3a:
            r8 = 92
            if (r2 != r8) goto L5f
            r10.f23127e = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L50
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L50:
            r1.append(r0, r3, r2)
            char r2 = r10.Q0()
            r1.append(r2)
            int r2 = r10.f23127e
            int r3 = r10.f23128f
            goto L7
        L5f:
            r5 = 10
            if (r2 != r5) goto L6a
            int r2 = r10.f23129g
            int r2 = r2 + r6
            r10.f23129g = r2
            r10.f23130h = r7
        L6a:
            r2 = r7
            goto L9
        L6c:
            if (r1 != 0) goto L7c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r10.f23127e = r2
            boolean r2 = r10.T(r6)
            if (r2 == 0) goto L8b
            goto L3
        L8b:
            java.lang.String r11 = "Unterminated string"
            t4.d r11 = r10.X0(r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.C2657a.J0(char):java.lang.String");
    }

    public int K() throws IOException {
        int iH0;
        int[] iArr = this.f23135m;
        int i7 = this.f23136n;
        int i8 = iArr[i7 - 1];
        if (i8 == 1) {
            iArr[i7 - 1] = 2;
        } else if (i8 == 2) {
            int iH02 = H0(true);
            if (iH02 != 44) {
                if (iH02 != 59) {
                    if (iH02 != 93) {
                        throw X0("Unterminated array");
                    }
                    this.f23131i = 4;
                    return 4;
                }
                G();
            }
        } else {
            if (i8 == 3 || i8 == 5) {
                iArr[i7 - 1] = 4;
                if (i8 == 5 && (iH0 = H0(true)) != 44) {
                    if (iH0 != 59) {
                        if (iH0 != 125) {
                            throw X0("Unterminated object");
                        }
                        this.f23131i = 2;
                        return 2;
                    }
                    G();
                }
                int iH03 = H0(true);
                if (iH03 == 34) {
                    this.f23131i = 13;
                    return 13;
                }
                if (iH03 == 39) {
                    G();
                    this.f23131i = 12;
                    return 12;
                }
                if (iH03 == 125) {
                    if (i8 == 5) {
                        throw X0("Expected name");
                    }
                    this.f23131i = 2;
                    return 2;
                }
                G();
                this.f23127e--;
                if (!A0((char) iH03)) {
                    throw X0("Expected name");
                }
                this.f23131i = 14;
                return 14;
            }
            if (i8 == 4) {
                iArr[i7 - 1] = 5;
                int iH04 = H0(true);
                if (iH04 != 58) {
                    if (iH04 != 61) {
                        throw X0("Expected ':'");
                    }
                    G();
                    if (this.f23127e < this.f23128f || T(1)) {
                        char[] cArr = this.f23126d;
                        int i9 = this.f23127e;
                        if (cArr[i9] == '>') {
                            this.f23127e = i9 + 1;
                        }
                    }
                }
            } else if (i8 == 6) {
                if (this.f23124b == t.LENIENT) {
                    H();
                }
                this.f23135m[this.f23136n - 1] = 7;
            } else if (i8 == 7) {
                if (H0(false) == -1) {
                    this.f23131i = 17;
                    return 17;
                }
                G();
                this.f23127e--;
            } else if (i8 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iH05 = H0(true);
        if (iH05 == 34) {
            this.f23131i = 9;
            return 9;
        }
        if (iH05 == 39) {
            G();
            this.f23131i = 8;
            return 8;
        }
        if (iH05 != 44 && iH05 != 59) {
            if (iH05 == 91) {
                this.f23131i = 3;
                return 3;
            }
            if (iH05 != 93) {
                if (iH05 == 123) {
                    this.f23131i = 1;
                    return 1;
                }
                this.f23127e--;
                int iN0 = N0();
                if (iN0 != 0) {
                    return iN0;
                }
                int iO0 = O0();
                if (iO0 != 0) {
                    return iO0;
                }
                if (!A0(this.f23126d[this.f23127e])) {
                    throw X0("Expected value");
                }
                G();
                this.f23131i = 10;
                return 10;
            }
            if (i8 == 1) {
                this.f23131i = 4;
                return 4;
            }
        }
        if (i8 != 1 && i8 != 2) {
            throw X0("Unexpected value");
        }
        G();
        this.f23127e--;
        this.f23131i = 7;
        return 7;
    }

    public String K0() throws IOException {
        String str;
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK == 10) {
            str = L0();
        } else if (iK == 8) {
            str = J0('\'');
        } else if (iK == 9) {
            str = J0('\"');
        } else if (iK == 11) {
            str = this.f23134l;
            this.f23134l = null;
        } else if (iK == 15) {
            str = Long.toString(this.f23132j);
        } else {
            if (iK != 16) {
                throw Y0("a string");
            }
            str = new String(this.f23126d, this.f23127e, this.f23133k);
            this.f23127e += this.f23133k;
        }
        this.f23131i = 0;
        int[] iArr = this.f23138p;
        int i7 = this.f23136n - 1;
        iArr[i7] = iArr[i7] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        G();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String L0() throws t4.d {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f23127e
            int r4 = r3 + r2
            int r5 = r6.f23128f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f23126d
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
            r6.G()
            goto L5c
        L4e:
            char[] r3 = r6.f23126d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.T(r3)
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
            char[] r3 = r6.f23126d
            int r4 = r6.f23127e
            r0.append(r3, r4, r2)
            int r3 = r6.f23127e
            int r3 = r3 + r2
            r6.f23127e = r3
            r2 = 1
            boolean r2 = r6.T(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f23126d
            int r3 = r6.f23127e
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f23126d
            int r3 = r6.f23127e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f23127e
            int r2 = r2 + r1
            r6.f23127e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.C2657a.L0():java.lang.String");
    }

    public void M() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK != 4) {
            throw Y0("END_ARRAY");
        }
        int i7 = this.f23136n;
        this.f23136n = i7 - 1;
        int[] iArr = this.f23138p;
        int i8 = i7 - 2;
        iArr[i8] = iArr[i8] + 1;
        this.f23131i = 0;
    }

    public b M0() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        switch (iK) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                return b.NUMBER;
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final int N0() {
        String str;
        String str2;
        int i7;
        char c7 = this.f23126d[this.f23127e];
        if (c7 == 't' || c7 == 'T') {
            str = com.amazon.a.a.o.b.af;
            str2 = "TRUE";
            i7 = 5;
        } else if (c7 == 'f' || c7 == 'F') {
            str = com.amazon.a.a.o.b.ag;
            str2 = "FALSE";
            i7 = 6;
        } else {
            if (c7 != 'n' && c7 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i7 = 7;
        }
        boolean z7 = this.f23124b != t.STRICT;
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            if (this.f23127e + i8 >= this.f23128f && !T(i8 + 1)) {
                return 0;
            }
            char c8 = this.f23126d[this.f23127e + i8];
            if (c8 != str.charAt(i8) && (!z7 || c8 != str2.charAt(i8))) {
                return 0;
            }
        }
        if ((this.f23127e + length < this.f23128f || T(length + 1)) && A0(this.f23126d[this.f23127e + length])) {
            return 0;
        }
        this.f23127e += length;
        this.f23131i = i7;
        return i7;
    }

    public void O() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK != 2) {
            throw Y0("END_OBJECT");
        }
        int i7 = this.f23136n;
        int i8 = i7 - 1;
        this.f23136n = i8;
        this.f23137o[i8] = null;
        int[] iArr = this.f23138p;
        int i9 = i7 - 2;
        iArr[i9] = iArr[i9] + 1;
        this.f23131i = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
    
        if (A0(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
    
        if (r9 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
    
        if (r13 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        if (r13 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ab, code lost:
    
        r18.f23132j = r11;
        r18.f23127e += r8;
        r18.f23131i = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
    
        if (r9 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
    
        if (r9 == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bd, code lost:
    
        if (r9 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c2, code lost:
    
        r18.f23133k = r8;
        r18.f23131i = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c9, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int O0() {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.C2657a.O0():int");
    }

    public final void P0(int i7) throws d {
        int i8 = this.f23136n;
        if (i8 - 1 >= this.f23125c) {
            throw new d("Nesting limit " + this.f23125c + " reached" + B0());
        }
        int[] iArr = this.f23135m;
        if (i8 == iArr.length) {
            int i9 = i8 * 2;
            this.f23135m = Arrays.copyOf(iArr, i9);
            this.f23138p = Arrays.copyOf(this.f23138p, i9);
            this.f23137o = (String[]) Arrays.copyOf(this.f23137o, i9);
        }
        int[] iArr2 = this.f23135m;
        int i10 = this.f23136n;
        this.f23136n = i10 + 1;
        iArr2[i10] = i7;
    }

    public final char Q0() throws d {
        int i7;
        if (this.f23127e == this.f23128f && !T(1)) {
            throw X0("Unterminated escape sequence");
        }
        char[] cArr = this.f23126d;
        int i8 = this.f23127e;
        int i9 = i8 + 1;
        this.f23127e = i9;
        char c7 = cArr[i8];
        if (c7 != '\n') {
            if (c7 != '\"') {
                if (c7 != '\'') {
                    if (c7 != '/' && c7 != '\\') {
                        if (c7 == 'b') {
                            return '\b';
                        }
                        if (c7 == 'f') {
                            return '\f';
                        }
                        if (c7 == 'n') {
                            return '\n';
                        }
                        if (c7 == 'r') {
                            return '\r';
                        }
                        if (c7 == 't') {
                            return '\t';
                        }
                        if (c7 != 'u') {
                            throw X0("Invalid escape sequence");
                        }
                        if (i8 + 5 > this.f23128f && !T(4)) {
                            throw X0("Unterminated escape sequence");
                        }
                        int i10 = this.f23127e;
                        int i11 = i10 + 4;
                        int i12 = 0;
                        while (i10 < i11) {
                            char c8 = this.f23126d[i10];
                            int i13 = i12 << 4;
                            if (c8 >= '0' && c8 <= '9') {
                                i7 = c8 - '0';
                            } else if (c8 >= 'a' && c8 <= 'f') {
                                i7 = c8 - 'W';
                            } else {
                                if (c8 < 'A' || c8 > 'F') {
                                    throw X0("Malformed Unicode escape \\u" + new String(this.f23126d, this.f23127e, 4));
                                }
                                i7 = c8 - '7';
                            }
                            i12 = i13 + i7;
                            i10++;
                        }
                        this.f23127e += 4;
                        return (char) i12;
                    }
                }
            }
            return c7;
        }
        if (this.f23124b == t.STRICT) {
            throw X0("Cannot escape a newline character in strict mode");
        }
        this.f23129g++;
        this.f23130h = i9;
        if (this.f23124b == t.STRICT) {
            throw X0("Invalid escaped character \"'\" in strict mode");
        }
        return c7;
    }

    public final void R0(t tVar) {
        Objects.requireNonNull(tVar);
        this.f23124b = tVar;
    }

    public final void S0(char c7) throws d {
        char[] cArr = this.f23126d;
        do {
            int i7 = this.f23127e;
            int i8 = this.f23128f;
            while (i7 < i8) {
                int i9 = i7 + 1;
                char c8 = cArr[i7];
                if (c8 == c7) {
                    this.f23127e = i9;
                    return;
                }
                if (c8 == '\\') {
                    this.f23127e = i9;
                    Q0();
                    i7 = this.f23127e;
                    i8 = this.f23128f;
                } else {
                    if (c8 == '\n') {
                        this.f23129g++;
                        this.f23130h = i9;
                    }
                    i7 = i9;
                }
            }
            this.f23127e = i7;
        } while (T(1));
        throw X0("Unterminated string");
    }

    public final boolean T(int i7) throws IOException {
        int i8;
        int i9;
        char[] cArr = this.f23126d;
        int i10 = this.f23130h;
        int i11 = this.f23127e;
        this.f23130h = i10 - i11;
        int i12 = this.f23128f;
        if (i12 != i11) {
            int i13 = i12 - i11;
            this.f23128f = i13;
            System.arraycopy(cArr, i11, cArr, 0, i13);
        } else {
            this.f23128f = 0;
        }
        this.f23127e = 0;
        do {
            Reader reader = this.f23123a;
            int i14 = this.f23128f;
            int i15 = reader.read(cArr, i14, cArr.length - i14);
            if (i15 == -1) {
                return false;
            }
            i8 = this.f23128f + i15;
            this.f23128f = i8;
            if (this.f23129g == 0 && (i9 = this.f23130h) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.f23127e++;
                this.f23130h = i9 + 1;
                i7++;
            }
        } while (i8 < i7);
        return true;
    }

    public final boolean T0(String str) {
        int length = str.length();
        while (true) {
            if (this.f23127e + length > this.f23128f && !T(length)) {
                return false;
            }
            char[] cArr = this.f23126d;
            int i7 = this.f23127e;
            if (cArr[i7] != '\n') {
                for (int i8 = 0; i8 < length; i8++) {
                    if (this.f23126d[this.f23127e + i8] != str.charAt(i8)) {
                        break;
                    }
                }
                return true;
            }
            this.f23129g++;
            this.f23130h = i7 + 1;
            this.f23127e++;
        }
    }

    public final void U0() {
        char c7;
        do {
            if (this.f23127e >= this.f23128f && !T(1)) {
                return;
            }
            char[] cArr = this.f23126d;
            int i7 = this.f23127e;
            int i8 = i7 + 1;
            this.f23127e = i8;
            c7 = cArr[i7];
            if (c7 == '\n') {
                this.f23129g++;
                this.f23130h = i8;
                return;
            }
        } while (c7 != '\r');
    }

    public String V() {
        return X(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        G();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V0() throws t4.d {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f23127e
            int r2 = r1 + r0
            int r3 = r4.f23128f
            if (r2 >= r3) goto L51
            char[] r2 = r4.f23126d
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
            r4.G()
        L4b:
            int r1 = r4.f23127e
            int r1 = r1 + r0
            r4.f23127e = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f23127e = r1
            r0 = 1
            boolean r0 = r4.T(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.C2657a.V0():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void W0() throws IOException {
        int i7 = 0;
        do {
            int iK = this.f23131i;
            if (iK == 0) {
                iK = K();
            }
            switch (iK) {
                case 1:
                    P0(3);
                    i7++;
                    this.f23131i = 0;
                    break;
                case 2:
                    if (i7 == 0) {
                        this.f23137o[this.f23136n - 1] = null;
                    }
                    this.f23136n--;
                    i7--;
                    this.f23131i = 0;
                    break;
                case 3:
                    P0(1);
                    i7++;
                    this.f23131i = 0;
                    break;
                case 4:
                    this.f23136n--;
                    i7--;
                    this.f23131i = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f23131i = 0;
                    break;
                case 8:
                    S0('\'');
                    this.f23131i = 0;
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    S0('\"');
                    this.f23131i = 0;
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    V0();
                    this.f23131i = 0;
                    break;
                case 12:
                    S0('\'');
                    if (i7 == 0) {
                        this.f23137o[this.f23136n - 1] = "<skipped>";
                    }
                    this.f23131i = 0;
                    break;
                case 13:
                    S0('\"');
                    if (i7 == 0) {
                        this.f23137o[this.f23136n - 1] = "<skipped>";
                    }
                    this.f23131i = 0;
                    break;
                case 14:
                    V0();
                    if (i7 == 0) {
                        this.f23137o[this.f23136n - 1] = "<skipped>";
                    }
                    this.f23131i = 0;
                    break;
                case com.amazon.c.a.a.c.f10119g /* 16 */:
                    this.f23127e += this.f23133k;
                    this.f23131i = 0;
                    break;
                case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    break;
            }
            return;
        } while (i7 > 0);
        int[] iArr = this.f23138p;
        int i8 = this.f23136n - 1;
        iArr[i8] = iArr[i8] + 1;
    }

    public final d X0(String str) throws d {
        throw new d(str + B0() + "\nSee " + G.a("malformed-json"));
    }

    public final IllegalStateException Y0(String str) {
        return new IllegalStateException("Expected " + str + " but was " + M0() + B0() + "\nSee " + G.a(M0() == b.NULL ? "adapter-not-null-safe" : "unexpected-json-structure"));
    }

    public String c0() {
        return X(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23131i = 0;
        this.f23135m[0] = 8;
        this.f23136n = 1;
        this.f23123a.close();
    }

    public void i() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        if (iK != 3) {
            throw Y0("BEGIN_ARRAY");
        }
        P0(1);
        this.f23138p[this.f23136n - 1] = 0;
        this.f23131i = 0;
    }

    public final t i0() {
        return this.f23124b;
    }

    public String toString() {
        return getClass().getSimpleName() + B0();
    }

    public boolean y0() throws IOException {
        int iK = this.f23131i;
        if (iK == 0) {
            iK = K();
        }
        return (iK == 2 || iK == 4 || iK == 17) ? false : true;
    }

    public final boolean z0() {
        return this.f23124b == t.LENIENT;
    }
}
