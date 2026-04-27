package y2;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import p2.C1698D;
import q2.t;
import s2.G;
import s2.x;
import t2.C1790g;

/* JADX INFO: renamed from: y2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1946a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f15912a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f15921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15922k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f15923l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f15924m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String[] f15926o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f15927p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f15913b = t.LEGACY_STRICT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15914c = 255;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char[] f15915d = new char[UserMetadata.MAX_ATTRIBUTE_SIZE];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15916e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15917f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15918g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15919h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15920i = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15925n = 1;

    /* JADX INFO: renamed from: y2.a$a, reason: collision with other inner class name */
    public class C0260a extends x {
        @Override // s2.x
        public void a(C1946a c1946a) throws IOException {
            if (c1946a instanceof C1790g) {
                ((C1790g) c1946a).J0();
                return;
            }
            int iA = c1946a.f15920i;
            if (iA == 0) {
                iA = c1946a.A();
            }
            if (iA == 13) {
                c1946a.f15920i = 9;
            } else if (iA == 12) {
                c1946a.f15920i = 8;
            } else {
                if (iA != 14) {
                    throw c1946a.D0("a name");
                }
                c1946a.f15920i = 10;
            }
        }
    }

    static {
        x.f14651a = new C0260a();
    }

    public C1946a(Reader reader) {
        int[] iArr = new int[32];
        this.f15924m = iArr;
        iArr[0] = 6;
        this.f15926o = new String[32];
        this.f15927p = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f15912a = reader;
    }

    private String P(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i4 = 0;
        while (true) {
            int i5 = this.f15925n;
            if (i4 >= i5) {
                return sb.toString();
            }
            int i6 = this.f15924m[i4];
            switch (i6) {
                case 1:
                case 2:
                    int i7 = this.f15927p[i4];
                    if (z4 && i7 > 0 && i4 == i5 - 1) {
                        i7--;
                    }
                    sb.append('[');
                    sb.append(i7);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append(com.amazon.a.a.o.c.a.b.f8816a);
                    String str = this.f15926o[i4];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i6);
            }
            i4++;
        }
    }

    public int A() throws IOException {
        int iM0;
        int[] iArr = this.f15924m;
        int i4 = this.f15925n;
        int i5 = iArr[i4 - 1];
        if (i5 == 1) {
            iArr[i4 - 1] = 2;
        } else if (i5 == 2) {
            int iM02 = m0(true);
            if (iM02 != 44) {
                if (iM02 != 59) {
                    if (iM02 != 93) {
                        throw C0("Unterminated array");
                    }
                    this.f15920i = 4;
                    return 4;
                }
                p();
            }
        } else {
            if (i5 == 3 || i5 == 5) {
                iArr[i4 - 1] = 4;
                if (i5 == 5 && (iM0 = m0(true)) != 44) {
                    if (iM0 != 59) {
                        if (iM0 != 125) {
                            throw C0("Unterminated object");
                        }
                        this.f15920i = 2;
                        return 2;
                    }
                    p();
                }
                int iM03 = m0(true);
                if (iM03 == 34) {
                    this.f15920i = 13;
                    return 13;
                }
                if (iM03 == 39) {
                    p();
                    this.f15920i = 12;
                    return 12;
                }
                if (iM03 == 125) {
                    if (i5 == 5) {
                        throw C0("Expected name");
                    }
                    this.f15920i = 2;
                    return 2;
                }
                p();
                this.f15916e--;
                if (!f0((char) iM03)) {
                    throw C0("Expected name");
                }
                this.f15920i = 14;
                return 14;
            }
            if (i5 == 4) {
                iArr[i4 - 1] = 5;
                int iM04 = m0(true);
                if (iM04 != 58) {
                    if (iM04 != 61) {
                        throw C0("Expected ':'");
                    }
                    p();
                    if (this.f15916e < this.f15917f || J(1)) {
                        char[] cArr = this.f15915d;
                        int i6 = this.f15916e;
                        if (cArr[i6] == '>') {
                            this.f15916e = i6 + 1;
                        }
                    }
                }
            } else if (i5 == 6) {
                if (this.f15913b == t.LENIENT) {
                    x();
                }
                this.f15924m[this.f15925n - 1] = 7;
            } else if (i5 == 7) {
                if (m0(false) == -1) {
                    this.f15920i = 17;
                    return 17;
                }
                p();
                this.f15916e--;
            } else if (i5 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iM05 = m0(true);
        if (iM05 == 34) {
            this.f15920i = 9;
            return 9;
        }
        if (iM05 == 39) {
            p();
            this.f15920i = 8;
            return 8;
        }
        if (iM05 != 44 && iM05 != 59) {
            if (iM05 == 91) {
                this.f15920i = 3;
                return 3;
            }
            if (iM05 != 93) {
                if (iM05 == 123) {
                    this.f15920i = 1;
                    return 1;
                }
                this.f15916e--;
                int iS0 = s0();
                if (iS0 != 0) {
                    return iS0;
                }
                int iT0 = t0();
                if (iT0 != 0) {
                    return iT0;
                }
                if (!f0(this.f15915d[this.f15916e])) {
                    throw C0("Expected value");
                }
                p();
                this.f15920i = 10;
                return 10;
            }
            if (i5 == 1) {
                this.f15920i = 4;
                return 4;
            }
        }
        if (i5 != 1 && i5 != 2) {
            throw C0("Unexpected value");
        }
        p();
        this.f15916e--;
        this.f15920i = 7;
        return 7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        p();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0() throws y2.d {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f15916e
            int r2 = r1 + r0
            int r3 = r4.f15917f
            if (r2 >= r3) goto L51
            char[] r2 = r4.f15915d
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
            r4.p()
        L4b:
            int r1 = r4.f15916e
            int r1 = r1 + r0
            r4.f15916e = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f15916e = r1
            r0 = 1
            boolean r0 = r4.J(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.C1946a.A0():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void B0() throws IOException {
        int i4 = 0;
        do {
            int iA = this.f15920i;
            if (iA == 0) {
                iA = A();
            }
            switch (iA) {
                case 1:
                    u0(3);
                    i4++;
                    this.f15920i = 0;
                    break;
                case 2:
                    if (i4 == 0) {
                        this.f15926o[this.f15925n - 1] = null;
                    }
                    this.f15925n--;
                    i4--;
                    this.f15920i = 0;
                    break;
                case 3:
                    u0(1);
                    i4++;
                    this.f15920i = 0;
                    break;
                case 4:
                    this.f15925n--;
                    i4--;
                    this.f15920i = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                default:
                    this.f15920i = 0;
                    break;
                case 8:
                    x0('\'');
                    this.f15920i = 0;
                    break;
                case 9:
                    x0('\"');
                    this.f15920i = 0;
                    break;
                case 10:
                    A0();
                    this.f15920i = 0;
                    break;
                case 12:
                    x0('\'');
                    if (i4 == 0) {
                        this.f15926o[this.f15925n - 1] = "<skipped>";
                    }
                    this.f15920i = 0;
                    break;
                case 13:
                    x0('\"');
                    if (i4 == 0) {
                        this.f15926o[this.f15925n - 1] = "<skipped>";
                    }
                    this.f15920i = 0;
                    break;
                case 14:
                    A0();
                    if (i4 == 0) {
                        this.f15926o[this.f15925n - 1] = "<skipped>";
                    }
                    this.f15920i = 0;
                    break;
                case 16:
                    this.f15916e += this.f15922k;
                    this.f15920i = 0;
                    break;
                case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    break;
            }
            return;
        } while (i4 > 0);
        int[] iArr = this.f15927p;
        int i5 = this.f15925n - 1;
        iArr[i5] = iArr[i5] + 1;
    }

    public final d C0(String str) throws d {
        throw new d(str + g0() + "\nSee " + G.a("malformed-json"));
    }

    public final IllegalStateException D0(String str) {
        return new IllegalStateException("Expected " + str + " but was " + r0() + g0() + "\nSee " + G.a(r0() == b.NULL ? "adapter-not-null-safe" : "unexpected-json-structure"));
    }

    public void E() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA != 4) {
            throw D0("END_ARRAY");
        }
        int i4 = this.f15925n;
        this.f15925n = i4 - 1;
        int[] iArr = this.f15927p;
        int i5 = i4 - 2;
        iArr[i5] = iArr[i5] + 1;
        this.f15920i = 0;
    }

    public void G() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA != 2) {
            throw D0("END_OBJECT");
        }
        int i4 = this.f15925n;
        int i5 = i4 - 1;
        this.f15925n = i5;
        this.f15926o[i5] = null;
        int[] iArr = this.f15927p;
        int i6 = i4 - 2;
        iArr[i6] = iArr[i6] + 1;
        this.f15920i = 0;
    }

    public final boolean J(int i4) throws IOException {
        int i5;
        int i6;
        char[] cArr = this.f15915d;
        int i7 = this.f15919h;
        int i8 = this.f15916e;
        this.f15919h = i7 - i8;
        int i9 = this.f15917f;
        if (i9 != i8) {
            int i10 = i9 - i8;
            this.f15917f = i10;
            System.arraycopy(cArr, i8, cArr, 0, i10);
        } else {
            this.f15917f = 0;
        }
        this.f15916e = 0;
        do {
            Reader reader = this.f15912a;
            int i11 = this.f15917f;
            int i12 = reader.read(cArr, i11, cArr.length - i11);
            if (i12 == -1) {
                return false;
            }
            i5 = this.f15917f + i12;
            this.f15917f = i5;
            if (this.f15918g == 0 && (i6 = this.f15919h) == 0 && i5 > 0 && cArr[0] == 65279) {
                this.f15916e++;
                this.f15919h = i6 + 1;
                i4++;
            }
        } while (i5 < i4);
        return true;
    }

    public String K() {
        return P(false);
    }

    public String S() {
        return P(true);
    }

    public final t a0() {
        return this.f15913b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15920i = 0;
        this.f15924m[0] = 8;
        this.f15925n = 1;
        this.f15912a.close();
    }

    public boolean d0() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        return (iA == 2 || iA == 4 || iA == 17) ? false : true;
    }

    public final boolean e0() {
        return this.f15913b == t.LENIENT;
    }

    public void f() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA != 3) {
            throw D0("BEGIN_ARRAY");
        }
        u0(1);
        this.f15927p[this.f15925n - 1] = 0;
        this.f15920i = 0;
    }

    public final boolean f0(char c4) throws d {
        if (c4 == '\t' || c4 == '\n' || c4 == '\f' || c4 == '\r' || c4 == ' ') {
            return false;
        }
        if (c4 != '#') {
            if (c4 == ',') {
                return false;
            }
            if (c4 != '/' && c4 != '=') {
                if (c4 == '{' || c4 == '}' || c4 == ':') {
                    return false;
                }
                if (c4 != ';') {
                    switch (c4) {
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
        p();
        return false;
    }

    public void g() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA != 1) {
            throw D0("BEGIN_OBJECT");
        }
        u0(3);
        this.f15920i = 0;
    }

    public String g0() {
        return " at line " + (this.f15918g + 1) + " column " + ((this.f15916e - this.f15919h) + 1) + " path " + K();
    }

    public boolean h0() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA == 5) {
            this.f15920i = 0;
            int[] iArr = this.f15927p;
            int i4 = this.f15925n - 1;
            iArr[i4] = iArr[i4] + 1;
            return true;
        }
        if (iA != 6) {
            throw D0("a boolean");
        }
        this.f15920i = 0;
        int[] iArr2 = this.f15927p;
        int i5 = this.f15925n - 1;
        iArr2[i5] = iArr2[i5] + 1;
        return false;
    }

    public double i0() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA == 15) {
            this.f15920i = 0;
            int[] iArr = this.f15927p;
            int i4 = this.f15925n - 1;
            iArr[i4] = iArr[i4] + 1;
            return this.f15921j;
        }
        if (iA == 16) {
            this.f15923l = new String(this.f15915d, this.f15916e, this.f15922k);
            this.f15916e += this.f15922k;
        } else if (iA == 8 || iA == 9) {
            this.f15923l = o0(iA == 8 ? '\'' : '\"');
        } else if (iA == 10) {
            this.f15923l = q0();
        } else if (iA != 11) {
            throw D0("a double");
        }
        this.f15920i = 11;
        double d4 = Double.parseDouble(this.f15923l);
        if (this.f15913b != t.LENIENT && (Double.isNaN(d4) || Double.isInfinite(d4))) {
            throw C0("JSON forbids NaN and infinities: " + d4);
        }
        this.f15923l = null;
        this.f15920i = 0;
        int[] iArr2 = this.f15927p;
        int i5 = this.f15925n - 1;
        iArr2[i5] = iArr2[i5] + 1;
        return d4;
    }

    public int j0() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA == 15) {
            long j4 = this.f15921j;
            int i4 = (int) j4;
            if (j4 == i4) {
                this.f15920i = 0;
                int[] iArr = this.f15927p;
                int i5 = this.f15925n - 1;
                iArr[i5] = iArr[i5] + 1;
                return i4;
            }
            throw new NumberFormatException("Expected an int but was " + this.f15921j + g0());
        }
        if (iA == 16) {
            this.f15923l = new String(this.f15915d, this.f15916e, this.f15922k);
            this.f15916e += this.f15922k;
        } else {
            if (iA != 8 && iA != 9 && iA != 10) {
                throw D0("an int");
            }
            if (iA == 10) {
                this.f15923l = q0();
            } else {
                this.f15923l = o0(iA == 8 ? '\'' : '\"');
            }
            try {
                int i6 = Integer.parseInt(this.f15923l);
                this.f15920i = 0;
                int[] iArr2 = this.f15927p;
                int i7 = this.f15925n - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return i6;
            } catch (NumberFormatException unused) {
            }
        }
        this.f15920i = 11;
        double d4 = Double.parseDouble(this.f15923l);
        int i8 = (int) d4;
        if (i8 != d4) {
            throw new NumberFormatException("Expected an int but was " + this.f15923l + g0());
        }
        this.f15923l = null;
        this.f15920i = 0;
        int[] iArr3 = this.f15927p;
        int i9 = this.f15925n - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return i8;
    }

    public long k0() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA == 15) {
            this.f15920i = 0;
            int[] iArr = this.f15927p;
            int i4 = this.f15925n - 1;
            iArr[i4] = iArr[i4] + 1;
            return this.f15921j;
        }
        if (iA == 16) {
            this.f15923l = new String(this.f15915d, this.f15916e, this.f15922k);
            this.f15916e += this.f15922k;
        } else {
            if (iA != 8 && iA != 9 && iA != 10) {
                throw D0("a long");
            }
            if (iA == 10) {
                this.f15923l = q0();
            } else {
                this.f15923l = o0(iA == 8 ? '\'' : '\"');
            }
            try {
                long j4 = Long.parseLong(this.f15923l);
                this.f15920i = 0;
                int[] iArr2 = this.f15927p;
                int i5 = this.f15925n - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return j4;
            } catch (NumberFormatException unused) {
            }
        }
        this.f15920i = 11;
        double d4 = Double.parseDouble(this.f15923l);
        long j5 = (long) d4;
        if (j5 != d4) {
            throw new NumberFormatException("Expected a long but was " + this.f15923l + g0());
        }
        this.f15923l = null;
        this.f15920i = 0;
        int[] iArr3 = this.f15927p;
        int i6 = this.f15925n - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return j5;
    }

    public String l0() throws IOException {
        String strO0;
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA == 14) {
            strO0 = q0();
        } else if (iA == 12) {
            strO0 = o0('\'');
        } else {
            if (iA != 13) {
                throw D0("a name");
            }
            strO0 = o0('\"');
        }
        this.f15920i = 0;
        this.f15926o[this.f15925n - 1] = strO0;
        return strO0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m0(boolean r9) throws java.io.IOException {
        /*
            r8 = this;
            char[] r0 = r8.f15915d
            int r1 = r8.f15916e
            int r2 = r8.f15917f
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r8.f15916e = r1
            boolean r1 = r8.J(r3)
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
            java.lang.String r1 = r8.g0()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L30:
            int r1 = r8.f15916e
            int r2 = r8.f15917f
        L34:
            int r4 = r1 + 1
            char r5 = r0[r1]
            r6 = 10
            if (r5 != r6) goto L45
            int r1 = r8.f15918g
            int r1 = r1 + r3
            r8.f15918g = r1
            r8.f15919h = r4
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
            r8.f15916e = r4
            r7 = 2
            if (r4 != r2) goto L69
            r8.f15916e = r1
            boolean r1 = r8.J(r7)
            int r2 = r8.f15916e
            int r2 = r2 + r3
            r8.f15916e = r2
            if (r1 != 0) goto L69
            goto L76
        L69:
            r8.p()
            int r1 = r8.f15916e
            char r2 = r0[r1]
            r3 = 42
            if (r2 == r3) goto L83
            if (r2 == r6) goto L77
        L76:
            return r5
        L77:
            int r1 = r1 + 1
            r8.f15916e = r1
            r8.z0()
            int r1 = r8.f15916e
            int r2 = r8.f15917f
            goto L6
        L83:
            int r1 = r1 + 1
            r8.f15916e = r1
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r8.y0(r1)
            if (r1 == 0) goto L96
            int r1 = r8.f15916e
            int r1 = r1 + r7
            int r2 = r8.f15917f
            goto L6
        L96:
            java.lang.String r9 = "Unterminated comment"
            y2.d r9 = r8.C0(r9)
            throw r9
        L9d:
            r1 = 35
            if (r5 != r1) goto Laf
            r8.f15916e = r4
            r8.p()
            r8.z0()
            int r1 = r8.f15916e
            int r2 = r8.f15917f
            goto L6
        Laf:
            r8.f15916e = r4
            return r5
        Lb2:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.C1946a.m0(boolean):int");
    }

    public void n0() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA != 7) {
            throw D0("null");
        }
        this.f15920i = 0;
        int[] iArr = this.f15927p;
        int i4 = this.f15925n - 1;
        iArr[i4] = iArr[i4] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r10.f15916e = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String o0(char r11) throws y2.d {
        /*
            r10 = this;
            char[] r0 = r10.f15915d
            r1 = 0
        L3:
            int r2 = r10.f15916e
            int r3 = r10.f15917f
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L6c
            int r7 = r2 + 1
            char r2 = r0[r2]
            q2.t r8 = r10.f15913b
            q2.t r9 = q2.t.STRICT
            if (r8 != r9) goto L24
            r8 = 32
            if (r2 < r8) goto L1d
            goto L24
        L1d:
            java.lang.String r11 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            y2.d r11 = r10.C0(r11)
            throw r11
        L24:
            if (r2 != r11) goto L3a
            r10.f15916e = r7
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
            r10.f15916e = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L50
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L50:
            r1.append(r0, r3, r2)
            char r2 = r10.v0()
            r1.append(r2)
            int r2 = r10.f15916e
            int r3 = r10.f15917f
            goto L7
        L5f:
            r5 = 10
            if (r2 != r5) goto L6a
            int r2 = r10.f15918g
            int r2 = r2 + r6
            r10.f15918g = r2
            r10.f15919h = r7
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
            r10.f15916e = r2
            boolean r2 = r10.J(r6)
            if (r2 == 0) goto L8b
            goto L3
        L8b:
            java.lang.String r11 = "Unterminated string"
            y2.d r11 = r10.C0(r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.C1946a.o0(char):java.lang.String");
    }

    public final void p() throws d {
        if (this.f15913b != t.LENIENT) {
            throw C0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    public String p0() throws IOException {
        String str;
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        if (iA == 10) {
            str = q0();
        } else if (iA == 8) {
            str = o0('\'');
        } else if (iA == 9) {
            str = o0('\"');
        } else if (iA == 11) {
            str = this.f15923l;
            this.f15923l = null;
        } else if (iA == 15) {
            str = Long.toString(this.f15921j);
        } else {
            if (iA != 16) {
                throw D0("a string");
            }
            str = new String(this.f15915d, this.f15916e, this.f15922k);
            this.f15916e += this.f15922k;
        }
        this.f15920i = 0;
        int[] iArr = this.f15927p;
        int i4 = this.f15925n - 1;
        iArr[i4] = iArr[i4] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        p();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String q0() throws y2.d {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f15916e
            int r4 = r3 + r2
            int r5 = r6.f15917f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f15915d
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
            r6.p()
            goto L5c
        L4e:
            char[] r3 = r6.f15915d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.J(r3)
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
            char[] r3 = r6.f15915d
            int r4 = r6.f15916e
            r0.append(r3, r4, r2)
            int r3 = r6.f15916e
            int r3 = r3 + r2
            r6.f15916e = r3
            r2 = 1
            boolean r2 = r6.J(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f15915d
            int r3 = r6.f15916e
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f15915d
            int r3 = r6.f15916e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f15916e
            int r2 = r2 + r1
            r6.f15916e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.C1946a.q0():java.lang.String");
    }

    public b r0() throws IOException {
        int iA = this.f15920i;
        if (iA == 0) {
            iA = A();
        }
        switch (iA) {
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
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
            case 16:
                return b.NUMBER;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final int s0() {
        String str;
        String str2;
        int i4;
        char c4 = this.f15915d[this.f15916e];
        if (c4 == 't' || c4 == 'T') {
            str = com.amazon.a.a.o.b.af;
            str2 = "TRUE";
            i4 = 5;
        } else if (c4 == 'f' || c4 == 'F') {
            str = com.amazon.a.a.o.b.ag;
            str2 = "FALSE";
            i4 = 6;
        } else {
            if (c4 != 'n' && c4 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i4 = 7;
        }
        boolean z4 = this.f15913b != t.STRICT;
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (this.f15916e + i5 >= this.f15917f && !J(i5 + 1)) {
                return 0;
            }
            char c5 = this.f15915d[this.f15916e + i5];
            if (c5 != str.charAt(i5) && (!z4 || c5 != str2.charAt(i5))) {
                return 0;
            }
        }
        if ((this.f15916e + length < this.f15917f || J(length + 1)) && f0(this.f15915d[this.f15916e + length])) {
            return 0;
        }
        this.f15916e += length;
        this.f15920i = i4;
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        if (f0(r14) != false) goto L75;
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
    
        r19.f15921j = r11;
        r19.f15916e += r8;
        r19.f15920i = 15;
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
    
        r19.f15922k = r8;
        r19.f15920i = 16;
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
    public final int t0() {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.C1946a.t0():int");
    }

    public String toString() {
        return getClass().getSimpleName() + g0();
    }

    public final void u0(int i4) throws d {
        int i5 = this.f15925n;
        if (i5 - 1 >= this.f15914c) {
            throw new d("Nesting limit " + this.f15914c + " reached" + g0());
        }
        int[] iArr = this.f15924m;
        if (i5 == iArr.length) {
            int i6 = i5 * 2;
            this.f15924m = Arrays.copyOf(iArr, i6);
            this.f15927p = Arrays.copyOf(this.f15927p, i6);
            this.f15926o = (String[]) Arrays.copyOf(this.f15926o, i6);
        }
        int[] iArr2 = this.f15924m;
        int i7 = this.f15925n;
        this.f15925n = i7 + 1;
        iArr2[i7] = i4;
    }

    public final char v0() throws d {
        int i4;
        if (this.f15916e == this.f15917f && !J(1)) {
            throw C0("Unterminated escape sequence");
        }
        char[] cArr = this.f15915d;
        int i5 = this.f15916e;
        int i6 = i5 + 1;
        this.f15916e = i6;
        char c4 = cArr[i5];
        if (c4 != '\n') {
            if (c4 != '\"') {
                if (c4 != '\'') {
                    if (c4 != '/' && c4 != '\\') {
                        if (c4 == 'b') {
                            return '\b';
                        }
                        if (c4 == 'f') {
                            return '\f';
                        }
                        if (c4 == 'n') {
                            return '\n';
                        }
                        if (c4 == 'r') {
                            return '\r';
                        }
                        if (c4 == 't') {
                            return '\t';
                        }
                        if (c4 != 'u') {
                            throw C0("Invalid escape sequence");
                        }
                        if (i5 + 5 > this.f15917f && !J(4)) {
                            throw C0("Unterminated escape sequence");
                        }
                        int i7 = this.f15916e;
                        int i8 = i7 + 4;
                        int i9 = 0;
                        while (i7 < i8) {
                            char c5 = this.f15915d[i7];
                            int i10 = i9 << 4;
                            if (c5 >= '0' && c5 <= '9') {
                                i4 = c5 - '0';
                            } else if (c5 >= 'a' && c5 <= 'f') {
                                i4 = c5 - 'W';
                            } else {
                                if (c5 < 'A' || c5 > 'F') {
                                    throw C0("Malformed Unicode escape \\u" + new String(this.f15915d, this.f15916e, 4));
                                }
                                i4 = c5 - '7';
                            }
                            i9 = i10 + i4;
                            i7++;
                        }
                        this.f15916e += 4;
                        return (char) i9;
                    }
                }
            }
            return c4;
        }
        if (this.f15913b == t.STRICT) {
            throw C0("Cannot escape a newline character in strict mode");
        }
        this.f15918g++;
        this.f15919h = i6;
        if (this.f15913b == t.STRICT) {
            throw C0("Invalid escaped character \"'\" in strict mode");
        }
        return c4;
    }

    public final void w0(t tVar) {
        Objects.requireNonNull(tVar);
        this.f15913b = tVar;
    }

    public final void x() throws IOException {
        m0(true);
        int i4 = this.f15916e;
        this.f15916e = i4 - 1;
        if (i4 + 4 <= this.f15917f || J(5)) {
            int i5 = this.f15916e;
            char[] cArr = this.f15915d;
            if (cArr[i5] == ')' && cArr[i5 + 1] == ']' && cArr[i5 + 2] == '}' && cArr[i5 + 3] == '\'' && cArr[i5 + 4] == '\n') {
                this.f15916e = i5 + 5;
            }
        }
    }

    public final void x0(char c4) throws d {
        char[] cArr = this.f15915d;
        do {
            int i4 = this.f15916e;
            int i5 = this.f15917f;
            while (i4 < i5) {
                int i6 = i4 + 1;
                char c5 = cArr[i4];
                if (c5 == c4) {
                    this.f15916e = i6;
                    return;
                }
                if (c5 == '\\') {
                    this.f15916e = i6;
                    v0();
                    i4 = this.f15916e;
                    i5 = this.f15917f;
                } else {
                    if (c5 == '\n') {
                        this.f15918g++;
                        this.f15919h = i6;
                    }
                    i4 = i6;
                }
            }
            this.f15916e = i4;
        } while (J(1));
        throw C0("Unterminated string");
    }

    public final boolean y0(String str) {
        int length = str.length();
        while (true) {
            if (this.f15916e + length > this.f15917f && !J(length)) {
                return false;
            }
            char[] cArr = this.f15915d;
            int i4 = this.f15916e;
            if (cArr[i4] != '\n') {
                for (int i5 = 0; i5 < length; i5++) {
                    if (this.f15915d[this.f15916e + i5] != str.charAt(i5)) {
                        break;
                    }
                }
                return true;
            }
            this.f15918g++;
            this.f15919h = i4 + 1;
            this.f15916e++;
        }
    }

    public final void z0() {
        char c4;
        do {
            if (this.f15916e >= this.f15917f && !J(1)) {
                return;
            }
            char[] cArr = this.f15915d;
            int i4 = this.f15916e;
            int i5 = i4 + 1;
            this.f15916e = i5;
            c4 = cArr[i4];
            if (c4 == '\n') {
                this.f15918g++;
                this.f15919h = i5;
                return;
            }
        } while (c4 != '\r');
    }
}
