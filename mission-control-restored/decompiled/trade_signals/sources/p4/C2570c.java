package p4;

import com.amazon.a.a.o.b.f;
import com.google.gson.s;
import com.revenuecat.purchases.common.Constants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: p4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2570c implements Closeable, Flushable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f22347l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f22348m = new String[128];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f22349n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f22350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f22351b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22352c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.gson.d f22353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f22355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f22357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f22359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f22360k;

    static {
        for (int i8 = 0; i8 <= 31; i8++) {
            f22348m[i8] = String.format("\\u%04x", Integer.valueOf(i8));
        }
        String[] strArr = f22348m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f22349n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public C2570c(Writer writer) {
        U(6);
        this.f22357h = s.LEGACY_STRICT;
        this.f22360k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f22350a = writer;
        X(com.google.gson.d.f15988d);
    }

    public static boolean a(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    public final void A0() throws IOException {
        if (this.f22359j != null) {
            c();
            r0(this.f22359j);
            this.f22359j = null;
        }
    }

    public C2570c B() {
        return r(1, 2, ']');
    }

    public C2570c D() {
        return r(3, 5, '}');
    }

    public final boolean E() {
        return this.f22360k;
    }

    public final s K() {
        return this.f22357h;
    }

    public final boolean M() {
        return this.f22358i;
    }

    public boolean N() {
        return this.f22357h == s.LENIENT;
    }

    public C2570c O(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f22359j != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iT = T();
        if (iT != 3 && iT != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f22359j = str;
        return this;
    }

    public final void Q() throws IOException {
        if (this.f22356g) {
            return;
        }
        this.f22350a.write(this.f22353d.b());
        int i8 = this.f22352c;
        for (int i9 = 1; i9 < i8; i9++) {
            this.f22350a.write(this.f22353d.a());
        }
    }

    public C2570c R() throws IOException {
        if (this.f22359j != null) {
            if (!this.f22360k) {
                this.f22359j = null;
                return this;
            }
            A0();
        }
        e();
        this.f22350a.write("null");
        return this;
    }

    public final C2570c S(int i8, char c8) throws IOException {
        e();
        U(i8);
        this.f22350a.write(c8);
        return this;
    }

    public final int T() {
        int i8 = this.f22352c;
        if (i8 != 0) {
            return this.f22351b[i8 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void U(int i8) {
        int i9 = this.f22352c;
        int[] iArr = this.f22351b;
        if (i9 == iArr.length) {
            this.f22351b = Arrays.copyOf(iArr, i9 * 2);
        }
        int[] iArr2 = this.f22351b;
        int i10 = this.f22352c;
        this.f22352c = i10 + 1;
        iArr2[i10] = i8;
    }

    public final void W(int i8) {
        this.f22351b[this.f22352c - 1] = i8;
    }

    public final void X(com.google.gson.d dVar) {
        Objects.requireNonNull(dVar);
        this.f22353d = dVar;
        this.f22355f = f.f14100a;
        if (dVar.c()) {
            this.f22354e = ": ";
            if (this.f22353d.b().isEmpty()) {
                this.f22355f = ", ";
            }
        } else {
            this.f22354e = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        }
        this.f22356g = this.f22353d.b().isEmpty() && this.f22353d.a().isEmpty();
    }

    public final void b0(boolean z7) {
        this.f22358i = z7;
    }

    public final void c() throws IOException {
        int iT = T();
        if (iT == 5) {
            this.f22350a.write(this.f22355f);
        } else if (iT != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        Q();
        W(4);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22350a.close();
        int i8 = this.f22352c;
        if (i8 > 1 || (i8 == 1 && this.f22351b[i8 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f22352c = 0;
    }

    public final void e() throws IOException {
        int iT = T();
        if (iT == 1) {
            W(2);
        } else {
            if (iT != 2) {
                if (iT == 4) {
                    this.f22350a.append((CharSequence) this.f22354e);
                    W(5);
                    return;
                }
                if (iT != 6) {
                    if (iT != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    }
                    if (this.f22357h != s.LENIENT) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                W(7);
                return;
            }
            this.f22350a.append((CharSequence) this.f22355f);
        }
        Q();
    }

    public C2570c f() throws IOException {
        A0();
        return S(1, '[');
    }

    public void flush() throws IOException {
        if (this.f22352c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f22350a.flush();
    }

    public final void i0(boolean z7) {
        this.f22360k = z7;
    }

    public final void m0(s sVar) {
        Objects.requireNonNull(sVar);
        this.f22357h = sVar;
    }

    public C2570c n() throws IOException {
        A0();
        return S(3, '{');
    }

    public final C2570c r(int i8, int i9, char c8) throws IOException {
        int iT = T();
        if (iT != i9 && iT != i8) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f22359j != null) {
            throw new IllegalStateException("Dangling name: " + this.f22359j);
        }
        this.f22352c--;
        if (iT == i9) {
            Q();
        }
        this.f22350a.write(c8);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r0(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f22358i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = p4.C2570c.f22349n
            goto L9
        L7:
            java.lang.String[] r0 = p4.C2570c.f22348m
        L9:
            java.io.Writer r1 = r8.f22350a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f22350a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f22350a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f22350a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f22350a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.C2570c.r0(java.lang.String):void");
    }

    public C2570c s0(double d8) throws IOException {
        A0();
        if (this.f22357h == s.LENIENT || !(Double.isNaN(d8) || Double.isInfinite(d8))) {
            e();
            this.f22350a.append((CharSequence) Double.toString(d8));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d8);
    }

    public C2570c v0(long j8) throws IOException {
        A0();
        e();
        this.f22350a.write(Long.toString(j8));
        return this;
    }

    public C2570c w0(Boolean bool) throws IOException {
        if (bool == null) {
            return R();
        }
        A0();
        e();
        this.f22350a.write(bool.booleanValue() ? com.amazon.a.a.o.b.af : com.amazon.a.a.o.b.ag);
        return this;
    }

    public C2570c x0(Number number) throws IOException {
        if (number == null) {
            return R();
        }
        A0();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (!a(cls)) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.f22357h != s.LENIENT) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
                }
            } else if (cls != Float.class && cls != Double.class && !f22347l.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        }
        e();
        this.f22350a.append((CharSequence) string);
        return this;
    }

    public C2570c y0(String str) throws IOException {
        if (str == null) {
            return R();
        }
        A0();
        e();
        r0(str);
        return this;
    }

    public C2570c z0(boolean z7) throws IOException {
        A0();
        e();
        this.f22350a.write(z7 ? com.amazon.a.a.o.b.af : com.amazon.a.a.o.b.ag);
        return this;
    }
}
