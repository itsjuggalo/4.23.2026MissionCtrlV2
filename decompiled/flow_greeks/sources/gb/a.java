package gb;

import bb.d0;
import com.google.gson.internal.f0;
import com.google.gson.internal.w;
import com.google.gson.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f10479a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f10488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f10490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f10491m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String[] f10493o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f10494p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f10480b = s.LEGACY_STRICT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10481c = 255;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char[] f10482d = new char[1024];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10483e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10484f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10485g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10486h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10487i = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10492n = 1;

    /* JADX INFO: renamed from: gb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0188a extends w {
        @Override // com.google.gson.internal.w
        public void a(a aVar) throws IOException {
            if (aVar instanceof com.google.gson.internal.bind.a) {
                ((com.google.gson.internal.bind.a) aVar).F0();
                return;
            }
            int iC = aVar.f10487i;
            if (iC == 0) {
                iC = aVar.C();
            }
            if (iC == 13) {
                aVar.f10487i = 9;
            } else if (iC == 12) {
                aVar.f10487i = 8;
            } else {
                if (iC != 14) {
                    throw aVar.z0("a name");
                }
                aVar.f10487i = 10;
            }
        }
    }

    static {
        w.f6848a = new C0188a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f10491m = iArr;
        iArr[0] = 6;
        this.f10493o = new String[32];
        this.f10494p = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f10479a = reader;
    }

    private String N(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f10492n;
            if (i10 >= i11) {
                return sb2.toString();
            }
            int i12 = this.f10491m[i10];
            switch (i12) {
                case 1:
                case 2:
                    int i13 = this.f10494p[i10];
                    if (z10 && i13 > 0 && i10 == i11 - 1) {
                        i13--;
                    }
                    sb2.append('[');
                    sb2.append(i13);
                    sb2.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
                    String str = this.f10493o[i10];
                    if (str != null) {
                        sb2.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i12);
            }
            i10++;
        }
    }

    public int C() throws IOException {
        int iI0;
        int[] iArr = this.f10491m;
        int i10 = this.f10492n;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int iI02 = i0(true);
            if (iI02 != 44) {
                if (iI02 != 59) {
                    if (iI02 != 93) {
                        throw y0("Unterminated array");
                    }
                    this.f10487i = 4;
                    return 4;
                }
                o();
            }
        } else {
            if (i11 == 3 || i11 == 5) {
                iArr[i10 - 1] = 4;
                if (i11 == 5 && (iI0 = i0(true)) != 44) {
                    if (iI0 != 59) {
                        if (iI0 != 125) {
                            throw y0("Unterminated object");
                        }
                        this.f10487i = 2;
                        return 2;
                    }
                    o();
                }
                int iI03 = i0(true);
                if (iI03 == 34) {
                    this.f10487i = 13;
                    return 13;
                }
                if (iI03 == 39) {
                    o();
                    this.f10487i = 12;
                    return 12;
                }
                if (iI03 == 125) {
                    if (i11 == 5) {
                        throw y0("Expected name");
                    }
                    this.f10487i = 2;
                    return 2;
                }
                o();
                this.f10483e--;
                if (!b0((char) iI03)) {
                    throw y0("Expected name");
                }
                this.f10487i = 14;
                return 14;
            }
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int iI04 = i0(true);
                if (iI04 != 58) {
                    if (iI04 != 61) {
                        throw y0("Expected ':'");
                    }
                    o();
                    if (this.f10483e < this.f10484f || H(1)) {
                        char[] cArr = this.f10482d;
                        int i12 = this.f10483e;
                        if (cArr[i12] == '>') {
                            this.f10483e = i12 + 1;
                        }
                    }
                }
            } else if (i11 == 6) {
                if (this.f10480b == s.LENIENT) {
                    u();
                }
                this.f10491m[this.f10492n - 1] = 7;
            } else if (i11 == 7) {
                if (i0(false) == -1) {
                    this.f10487i = 17;
                    return 17;
                }
                o();
                this.f10483e--;
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iI05 = i0(true);
        if (iI05 == 34) {
            this.f10487i = 9;
            return 9;
        }
        if (iI05 == 39) {
            o();
            this.f10487i = 8;
            return 8;
        }
        if (iI05 != 44 && iI05 != 59) {
            if (iI05 == 91) {
                this.f10487i = 3;
                return 3;
            }
            if (iI05 != 93) {
                if (iI05 == 123) {
                    this.f10487i = 1;
                    return 1;
                }
                this.f10483e--;
                int iO0 = o0();
                if (iO0 != 0) {
                    return iO0;
                }
                int iP0 = p0();
                if (iP0 != 0) {
                    return iP0;
                }
                if (!b0(this.f10482d[this.f10483e])) {
                    throw y0("Expected value");
                }
                o();
                this.f10487i = 10;
                return 10;
            }
            if (i11 == 1) {
                this.f10487i = 4;
                return 4;
            }
        }
        if (i11 != 1 && i11 != 2) {
            throw y0("Unexpected value");
        }
        o();
        this.f10483e--;
        this.f10487i = 7;
        return 7;
    }

    public void E() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 4) {
            throw z0("END_ARRAY");
        }
        int i10 = this.f10492n;
        this.f10492n = i10 - 1;
        int[] iArr = this.f10494p;
        int i11 = i10 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f10487i = 0;
    }

    public void G() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 2) {
            throw z0("END_OBJECT");
        }
        int i10 = this.f10492n;
        int i11 = i10 - 1;
        this.f10492n = i11;
        this.f10493o[i11] = null;
        int[] iArr = this.f10494p;
        int i12 = i10 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.f10487i = 0;
    }

    public final boolean H(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.f10482d;
        int i13 = this.f10486h;
        int i14 = this.f10483e;
        this.f10486h = i13 - i14;
        int i15 = this.f10484f;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f10484f = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f10484f = 0;
        }
        this.f10483e = 0;
        do {
            Reader reader = this.f10479a;
            int i17 = this.f10484f;
            int i18 = reader.read(cArr, i17, cArr.length - i17);
            if (i18 == -1) {
                return false;
            }
            i11 = this.f10484f + i18;
            this.f10484f = i11;
            if (this.f10485g == 0 && (i12 = this.f10486h) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f10483e++;
                this.f10486h = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    public String K() {
        return N(false);
    }

    public String O() {
        return N(true);
    }

    public final s R() {
        return this.f10480b;
    }

    public boolean Z() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        return (iC == 2 || iC == 4 || iC == 17) ? false : true;
    }

    public final boolean a0() {
        return this.f10480b == s.LENIENT;
    }

    public final boolean b0(char c10) throws d {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (c10 != '/' && c10 != '=') {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
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
        o();
        return false;
    }

    public void c() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 3) {
            throw z0("BEGIN_ARRAY");
        }
        q0(1);
        this.f10494p[this.f10492n - 1] = 0;
        this.f10487i = 0;
    }

    public String c0() {
        return " at line " + (this.f10485g + 1) + " column " + ((this.f10483e - this.f10486h) + 1) + " path " + K();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10487i = 0;
        this.f10491m[0] = 8;
        this.f10492n = 1;
        this.f10479a.close();
    }

    public boolean d0() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 5) {
            this.f10487i = 0;
            int[] iArr = this.f10494p;
            int i10 = this.f10492n - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iC != 6) {
            throw z0("a boolean");
        }
        this.f10487i = 0;
        int[] iArr2 = this.f10494p;
        int i11 = this.f10492n - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return false;
    }

    public void e() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 1) {
            throw z0("BEGIN_OBJECT");
        }
        q0(3);
        this.f10487i = 0;
    }

    public double e0() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 15) {
            this.f10487i = 0;
            int[] iArr = this.f10494p;
            int i10 = this.f10492n - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f10488j;
        }
        if (iC == 16) {
            this.f10490l = new String(this.f10482d, this.f10483e, this.f10489k);
            this.f10483e += this.f10489k;
        } else if (iC == 8 || iC == 9) {
            this.f10490l = k0(iC == 8 ? '\'' : '\"');
        } else if (iC == 10) {
            this.f10490l = m0();
        } else if (iC != 11) {
            throw z0("a double");
        }
        this.f10487i = 11;
        double d10 = Double.parseDouble(this.f10490l);
        if (this.f10480b != s.LENIENT && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw y0("JSON forbids NaN and infinities: " + d10);
        }
        this.f10490l = null;
        this.f10487i = 0;
        int[] iArr2 = this.f10494p;
        int i11 = this.f10492n - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return d10;
    }

    public int f0() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 15) {
            long j10 = this.f10488j;
            int i10 = (int) j10;
            if (j10 == i10) {
                this.f10487i = 0;
                int[] iArr = this.f10494p;
                int i11 = this.f10492n - 1;
                iArr[i11] = iArr[i11] + 1;
                return i10;
            }
            throw new NumberFormatException("Expected an int but was " + this.f10488j + c0());
        }
        if (iC == 16) {
            this.f10490l = new String(this.f10482d, this.f10483e, this.f10489k);
            this.f10483e += this.f10489k;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw z0("an int");
            }
            if (iC == 10) {
                this.f10490l = m0();
            } else {
                this.f10490l = k0(iC == 8 ? '\'' : '\"');
            }
            try {
                int i12 = Integer.parseInt(this.f10490l);
                this.f10487i = 0;
                int[] iArr2 = this.f10494p;
                int i13 = this.f10492n - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        }
        this.f10487i = 11;
        double d10 = Double.parseDouble(this.f10490l);
        int i14 = (int) d10;
        if (i14 != d10) {
            throw new NumberFormatException("Expected an int but was " + this.f10490l + c0());
        }
        this.f10490l = null;
        this.f10487i = 0;
        int[] iArr3 = this.f10494p;
        int i15 = this.f10492n - 1;
        iArr3[i15] = iArr3[i15] + 1;
        return i14;
    }

    public long g0() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 15) {
            this.f10487i = 0;
            int[] iArr = this.f10494p;
            int i10 = this.f10492n - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f10488j;
        }
        if (iC == 16) {
            this.f10490l = new String(this.f10482d, this.f10483e, this.f10489k);
            this.f10483e += this.f10489k;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw z0("a long");
            }
            if (iC == 10) {
                this.f10490l = m0();
            } else {
                this.f10490l = k0(iC == 8 ? '\'' : '\"');
            }
            try {
                long j10 = Long.parseLong(this.f10490l);
                this.f10487i = 0;
                int[] iArr2 = this.f10494p;
                int i11 = this.f10492n - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f10487i = 11;
        double d10 = Double.parseDouble(this.f10490l);
        long j11 = (long) d10;
        if (j11 != d10) {
            throw new NumberFormatException("Expected a long but was " + this.f10490l + c0());
        }
        this.f10490l = null;
        this.f10487i = 0;
        int[] iArr3 = this.f10494p;
        int i12 = this.f10492n - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return j11;
    }

    public String h0() throws IOException {
        String strK0;
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 14) {
            strK0 = m0();
        } else if (iC == 12) {
            strK0 = k0('\'');
        } else {
            if (iC != 13) {
                throw z0("a name");
            }
            strK0 = k0('\"');
        }
        this.f10487i = 0;
        this.f10493o[this.f10492n - 1] = strK0;
        return strK0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i0(boolean r9) throws java.io.IOException {
        /*
            r8 = this;
            char[] r0 = r8.f10482d
            int r1 = r8.f10483e
            int r2 = r8.f10484f
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r8.f10483e = r1
            boolean r1 = r8.H(r3)
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
            java.lang.String r1 = r8.c0()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L30:
            int r1 = r8.f10483e
            int r2 = r8.f10484f
        L34:
            int r4 = r1 + 1
            char r5 = r0[r1]
            r6 = 10
            if (r5 != r6) goto L45
            int r1 = r8.f10485g
            int r1 = r1 + r3
            r8.f10485g = r1
            r8.f10486h = r4
            goto Lb2
        L45:
            r6 = 32
            if (r5 == r6) goto Lb2
            r6 = 13
            if (r5 == r6) goto Lb2
            r6 = 9
            if (r5 != r6) goto L52
            goto Lb2
        L52:
            r6 = 47
            if (r5 != r6) goto L9d
            r8.f10483e = r4
            r7 = 2
            if (r4 != r2) goto L69
            r8.f10483e = r1
            boolean r1 = r8.H(r7)
            int r2 = r8.f10483e
            int r2 = r2 + r3
            r8.f10483e = r2
            if (r1 != 0) goto L69
            goto L76
        L69:
            r8.o()
            int r1 = r8.f10483e
            char r2 = r0[r1]
            r3 = 42
            if (r2 == r3) goto L83
            if (r2 == r6) goto L77
        L76:
            return r5
        L77:
            int r1 = r1 + 1
            r8.f10483e = r1
            r8.v0()
            int r1 = r8.f10483e
            int r2 = r8.f10484f
            goto L6
        L83:
            int r1 = r1 + 1
            r8.f10483e = r1
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r8.u0(r1)
            if (r1 == 0) goto L96
            int r1 = r8.f10483e
            int r1 = r1 + r7
            int r2 = r8.f10484f
            goto L6
        L96:
            java.lang.String r9 = "Unterminated comment"
            gb.d r9 = r8.y0(r9)
            throw r9
        L9d:
            r1 = 35
            if (r5 != r1) goto Laf
            r8.f10483e = r4
            r8.o()
            r8.v0()
            int r1 = r8.f10483e
            int r2 = r8.f10484f
            goto L6
        Laf:
            r8.f10483e = r4
            return r5
        Lb2:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.a.i0(boolean):int");
    }

    public void j0() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 7) {
            throw z0("null");
        }
        this.f10487i = 0;
        int[] iArr = this.f10494p;
        int i10 = this.f10492n - 1;
        iArr[i10] = iArr[i10] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r10.f10483e = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k0(char r11) throws gb.d {
        /*
            r10 = this;
            char[] r0 = r10.f10482d
            r1 = 0
        L3:
            int r2 = r10.f10483e
            int r3 = r10.f10484f
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L6c
            int r7 = r2 + 1
            char r2 = r0[r2]
            com.google.gson.s r8 = r10.f10480b
            com.google.gson.s r9 = com.google.gson.s.STRICT
            if (r8 != r9) goto L24
            r8 = 32
            if (r2 < r8) goto L1d
            goto L24
        L1d:
            java.lang.String r11 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            gb.d r11 = r10.y0(r11)
            throw r11
        L24:
            if (r2 != r11) goto L3a
            r10.f10483e = r7
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
            r10.f10483e = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L50
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L50:
            r1.append(r0, r3, r2)
            char r2 = r10.r0()
            r1.append(r2)
            int r2 = r10.f10483e
            int r3 = r10.f10484f
            goto L7
        L5f:
            r5 = 10
            if (r2 != r5) goto L6a
            int r2 = r10.f10485g
            int r2 = r2 + r6
            r10.f10485g = r2
            r10.f10486h = r7
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
            r10.f10483e = r2
            boolean r2 = r10.H(r6)
            if (r2 == 0) goto L8b
            goto L3
        L8b:
            java.lang.String r11 = "Unterminated string"
            gb.d r11 = r10.y0(r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.a.k0(char):java.lang.String");
    }

    public String l0() throws IOException {
        String str;
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 10) {
            str = m0();
        } else if (iC == 8) {
            str = k0('\'');
        } else if (iC == 9) {
            str = k0('\"');
        } else if (iC == 11) {
            str = this.f10490l;
            this.f10490l = null;
        } else if (iC == 15) {
            str = Long.toString(this.f10488j);
        } else {
            if (iC != 16) {
                throw z0("a string");
            }
            str = new String(this.f10482d, this.f10483e, this.f10489k);
            this.f10483e += this.f10489k;
        }
        this.f10487i = 0;
        int[] iArr = this.f10494p;
        int i10 = this.f10492n - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        o();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m0() throws gb.d {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f10483e
            int r4 = r3 + r2
            int r5 = r6.f10484f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f10482d
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
            r6.o()
            goto L5c
        L4e:
            char[] r3 = r6.f10482d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.H(r3)
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
            char[] r3 = r6.f10482d
            int r4 = r6.f10483e
            r0.append(r3, r4, r2)
            int r3 = r6.f10483e
            int r3 = r3 + r2
            r6.f10483e = r3
            r2 = 1
            boolean r2 = r6.H(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f10482d
            int r3 = r6.f10483e
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f10482d
            int r3 = r6.f10483e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f10483e
            int r2 = r2 + r1
            r6.f10483e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.a.m0():java.lang.String");
    }

    public b n0() throws IOException {
        int iC = this.f10487i;
        if (iC == 0) {
            iC = C();
        }
        switch (iC) {
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
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void o() throws d {
        if (this.f10480b != s.LENIENT) {
            throw y0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    public final int o0() {
        String str;
        String str2;
        int i10;
        char c10 = this.f10482d[this.f10483e];
        if (c10 == 't' || c10 == 'T') {
            str = com.amazon.a.a.o.b.f4545af;
            str2 = "TRUE";
            i10 = 5;
        } else if (c10 == 'f' || c10 == 'F') {
            str = com.amazon.a.a.o.b.f4546ag;
            str2 = "FALSE";
            i10 = 6;
        } else {
            if (c10 != 'n' && c10 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i10 = 7;
        }
        boolean z10 = this.f10480b != s.STRICT;
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (this.f10483e + i11 >= this.f10484f && !H(i11 + 1)) {
                return 0;
            }
            char c11 = this.f10482d[this.f10483e + i11];
            if (c11 != str.charAt(i11) && (!z10 || c11 != str2.charAt(i11))) {
                return 0;
            }
        }
        if ((this.f10483e + length < this.f10484f || H(length + 1)) && b0(this.f10482d[this.f10483e + length])) {
            return 0;
        }
        this.f10483e += length;
        this.f10487i = i10;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        if (b0(r14) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
    
        if (r9 != 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0097, code lost:
    
        if (r10 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009d, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009f, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
    
        if (r11 != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
    
        if (r13 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
    
        if (r13 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
    
        r19.f10488j = r11;
        r19.f10483e += r8;
        r19.f10487i = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b7, code lost:
    
        if (r9 == 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ba, code lost:
    
        if (r9 == 4) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bd, code lost:
    
        if (r9 != 7) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
    
        r19.f10489k = r8;
        r19.f10487i = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c7, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c8, code lost:
    
        return r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int p0() {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.a.p0():int");
    }

    public final void q0(int i10) throws d {
        int i11 = this.f10492n;
        if (i11 - 1 >= this.f10481c) {
            throw new d("Nesting limit " + this.f10481c + " reached" + c0());
        }
        int[] iArr = this.f10491m;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f10491m = Arrays.copyOf(iArr, i12);
            this.f10494p = Arrays.copyOf(this.f10494p, i12);
            this.f10493o = (String[]) Arrays.copyOf(this.f10493o, i12);
        }
        int[] iArr2 = this.f10491m;
        int i13 = this.f10492n;
        this.f10492n = i13 + 1;
        iArr2[i13] = i10;
    }

    public final char r0() throws d {
        int i10;
        if (this.f10483e == this.f10484f && !H(1)) {
            throw y0("Unterminated escape sequence");
        }
        char[] cArr = this.f10482d;
        int i11 = this.f10483e;
        int i12 = i11 + 1;
        this.f10483e = i12;
        char c10 = cArr[i11];
        if (c10 != '\n') {
            if (c10 != '\"') {
                if (c10 != '\'') {
                    if (c10 != '/' && c10 != '\\') {
                        if (c10 == 'b') {
                            return '\b';
                        }
                        if (c10 == 'f') {
                            return '\f';
                        }
                        if (c10 == 'n') {
                            return '\n';
                        }
                        if (c10 == 'r') {
                            return '\r';
                        }
                        if (c10 == 't') {
                            return '\t';
                        }
                        if (c10 != 'u') {
                            throw y0("Invalid escape sequence");
                        }
                        if (i11 + 5 > this.f10484f && !H(4)) {
                            throw y0("Unterminated escape sequence");
                        }
                        int i13 = this.f10483e;
                        int i14 = i13 + 4;
                        int i15 = 0;
                        while (i13 < i14) {
                            char c11 = this.f10482d[i13];
                            int i16 = i15 << 4;
                            if (c11 >= '0' && c11 <= '9') {
                                i10 = c11 - '0';
                            } else if (c11 >= 'a' && c11 <= 'f') {
                                i10 = c11 - 'W';
                            } else {
                                if (c11 < 'A' || c11 > 'F') {
                                    throw y0("Malformed Unicode escape \\u" + new String(this.f10482d, this.f10483e, 4));
                                }
                                i10 = c11 - '7';
                            }
                            i15 = i16 + i10;
                            i13++;
                        }
                        this.f10483e += 4;
                        return (char) i15;
                    }
                }
            }
            return c10;
        }
        if (this.f10480b == s.STRICT) {
            throw y0("Cannot escape a newline character in strict mode");
        }
        this.f10485g++;
        this.f10486h = i12;
        if (this.f10480b == s.STRICT) {
            throw y0("Invalid escaped character \"'\" in strict mode");
        }
        return c10;
    }

    public final void s0(s sVar) {
        Objects.requireNonNull(sVar);
        this.f10480b = sVar;
    }

    public final void t0(char c10) throws d {
        char[] cArr = this.f10482d;
        do {
            int i10 = this.f10483e;
            int i11 = this.f10484f;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f10483e = i12;
                    return;
                }
                if (c11 == '\\') {
                    this.f10483e = i12;
                    r0();
                    i10 = this.f10483e;
                    i11 = this.f10484f;
                } else {
                    if (c11 == '\n') {
                        this.f10485g++;
                        this.f10486h = i12;
                    }
                    i10 = i12;
                }
            }
            this.f10483e = i10;
        } while (H(1));
        throw y0("Unterminated string");
    }

    public String toString() {
        return getClass().getSimpleName() + c0();
    }

    public final void u() throws IOException {
        i0(true);
        int i10 = this.f10483e;
        this.f10483e = i10 - 1;
        if (i10 + 4 <= this.f10484f || H(5)) {
            int i11 = this.f10483e;
            char[] cArr = this.f10482d;
            if (cArr[i11] == ')' && cArr[i11 + 1] == ']' && cArr[i11 + 2] == '}' && cArr[i11 + 3] == '\'' && cArr[i11 + 4] == '\n') {
                this.f10483e = i11 + 5;
            }
        }
    }

    public final boolean u0(String str) {
        int length = str.length();
        while (true) {
            if (this.f10483e + length > this.f10484f && !H(length)) {
                return false;
            }
            char[] cArr = this.f10482d;
            int i10 = this.f10483e;
            if (cArr[i10] != '\n') {
                for (int i11 = 0; i11 < length; i11++) {
                    if (this.f10482d[this.f10483e + i11] != str.charAt(i11)) {
                        break;
                    }
                }
                return true;
            }
            this.f10485g++;
            this.f10486h = i10 + 1;
            this.f10483e++;
        }
    }

    public final void v0() {
        char c10;
        do {
            if (this.f10483e >= this.f10484f && !H(1)) {
                return;
            }
            char[] cArr = this.f10482d;
            int i10 = this.f10483e;
            int i11 = i10 + 1;
            this.f10483e = i11;
            c10 = cArr[i10];
            if (c10 == '\n') {
                this.f10485g++;
                this.f10486h = i11;
                return;
            }
        } while (c10 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        o();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w0() throws gb.d {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f10483e
            int r2 = r1 + r0
            int r3 = r4.f10484f
            if (r2 >= r3) goto L51
            char[] r2 = r4.f10482d
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
            r4.o()
        L4b:
            int r1 = r4.f10483e
            int r1 = r1 + r0
            r4.f10483e = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f10483e = r1
            r0 = 1
            boolean r0 = r4.H(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.a.w0():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void x0() throws IOException {
        int i10 = 0;
        do {
            int iC = this.f10487i;
            if (iC == 0) {
                iC = C();
            }
            switch (iC) {
                case 1:
                    q0(3);
                    i10++;
                    this.f10487i = 0;
                    break;
                case 2:
                    if (i10 == 0) {
                        this.f10493o[this.f10492n - 1] = null;
                    }
                    this.f10492n--;
                    i10--;
                    this.f10487i = 0;
                    break;
                case 3:
                    q0(1);
                    i10++;
                    this.f10487i = 0;
                    break;
                case 4:
                    this.f10492n--;
                    i10--;
                    this.f10487i = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f10487i = 0;
                    break;
                case 8:
                    t0('\'');
                    this.f10487i = 0;
                    break;
                case 9:
                    t0('\"');
                    this.f10487i = 0;
                    break;
                case 10:
                    w0();
                    this.f10487i = 0;
                    break;
                case 12:
                    t0('\'');
                    if (i10 == 0) {
                        this.f10493o[this.f10492n - 1] = "<skipped>";
                    }
                    this.f10487i = 0;
                    break;
                case 13:
                    t0('\"');
                    if (i10 == 0) {
                        this.f10493o[this.f10492n - 1] = "<skipped>";
                    }
                    this.f10487i = 0;
                    break;
                case 14:
                    w0();
                    if (i10 == 0) {
                        this.f10493o[this.f10492n - 1] = "<skipped>";
                    }
                    this.f10487i = 0;
                    break;
                case 16:
                    this.f10483e += this.f10489k;
                    this.f10487i = 0;
                    break;
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    break;
            }
            return;
        } while (i10 > 0);
        int[] iArr = this.f10494p;
        int i11 = this.f10492n - 1;
        iArr[i11] = iArr[i11] + 1;
    }

    public final d y0(String str) throws d {
        throw new d(str + c0() + "\nSee " + f0.a("malformed-json"));
    }

    public final IllegalStateException z0(String str) {
        return new IllegalStateException("Expected " + str + " but was " + n0() + c0() + "\nSee " + f0.a(n0() == b.NULL ? "adapter-not-null-safe" : "unexpected-json-structure"));
    }
}
