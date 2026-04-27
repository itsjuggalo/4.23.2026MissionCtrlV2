package t4;

import com.amazon.a.a.o.b.f;
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
import l4.C2171d;
import l4.t;

/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f23150l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f23151m = new String[128];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f23152n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f23153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f23154b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23155c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C2171d f23156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f23157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f23158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f23159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t f23160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f23161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23162j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f23163k;

    static {
        for (int i7 = 0; i7 <= 31; i7++) {
            f23151m[i7] = String.format("\\u%04x", Integer.valueOf(i7));
        }
        String[] strArr = f23151m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f23152n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        C0(6);
        this.f23160h = t.LEGACY_STRICT;
        this.f23163k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f23153a = writer;
        E0(C2171d.f18317d);
    }

    public static boolean h(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    public final void A() throws IOException {
        int iB0 = B0();
        if (iB0 == 1) {
            D0(2);
            y0();
            return;
        }
        if (iB0 == 2) {
            this.f23153a.append((CharSequence) this.f23158f);
            y0();
        } else {
            if (iB0 == 4) {
                this.f23153a.append((CharSequence) this.f23157e);
                D0(5);
                return;
            }
            if (iB0 != 6) {
                if (iB0 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f23160h != t.LENIENT) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            D0(7);
        }
    }

    public final c A0(int i7, char c7) throws IOException {
        A();
        C0(i7);
        this.f23153a.write(c7);
        return this;
    }

    public final int B0() {
        int i7 = this.f23155c;
        if (i7 != 0) {
            return this.f23154b[i7 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void C0(int i7) {
        int i8 = this.f23155c;
        int[] iArr = this.f23154b;
        if (i8 == iArr.length) {
            this.f23154b = Arrays.copyOf(iArr, i8 * 2);
        }
        int[] iArr2 = this.f23154b;
        int i9 = this.f23155c;
        this.f23155c = i9 + 1;
        iArr2[i9] = i7;
    }

    public final void D0(int i7) {
        this.f23154b[this.f23155c - 1] = i7;
    }

    public final void E0(C2171d c2171d) {
        Objects.requireNonNull(c2171d);
        this.f23156d = c2171d;
        this.f23158f = f.f9989a;
        if (c2171d.c()) {
            this.f23157e = ": ";
            if (this.f23156d.b().isEmpty()) {
                this.f23158f = ", ";
            }
        } else {
            this.f23157e = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        }
        this.f23159g = this.f23156d.b().isEmpty() && this.f23156d.a().isEmpty();
    }

    public final void F0(boolean z7) {
        this.f23161i = z7;
    }

    public c G() throws IOException {
        P0();
        return A0(1, '[');
    }

    public final void G0(boolean z7) {
        this.f23163k = z7;
    }

    public c H() throws IOException {
        P0();
        return A0(3, '{');
    }

    public final void H0(t tVar) {
        Objects.requireNonNull(tVar);
        this.f23160h = tVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I0(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f23161i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = t4.c.f23152n
            goto L9
        L7:
            java.lang.String[] r0 = t4.c.f23151m
        L9:
            java.io.Writer r1 = r8.f23153a
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
            java.io.Writer r6 = r8.f23153a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f23153a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f23153a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f23153a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.c.I0(java.lang.String):void");
    }

    public c J0(double d7) throws IOException {
        P0();
        if (this.f23160h == t.LENIENT || !(Double.isNaN(d7) || Double.isInfinite(d7))) {
            A();
            this.f23153a.append((CharSequence) Double.toString(d7));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d7);
    }

    public final c K(int i7, int i8, char c7) throws IOException {
        int iB0 = B0();
        if (iB0 != i8 && iB0 != i7) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f23162j != null) {
            throw new IllegalStateException("Dangling name: " + this.f23162j);
        }
        this.f23155c--;
        if (iB0 == i8) {
            y0();
        }
        this.f23153a.write(c7);
        return this;
    }

    public c K0(long j7) throws IOException {
        P0();
        A();
        this.f23153a.write(Long.toString(j7));
        return this;
    }

    public c L0(Boolean bool) throws IOException {
        if (bool == null) {
            return z0();
        }
        P0();
        A();
        this.f23153a.write(bool.booleanValue() ? com.amazon.a.a.o.b.af : com.amazon.a.a.o.b.ag);
        return this;
    }

    public c M() {
        return K(1, 2, ']');
    }

    public c M0(Number number) throws IOException {
        if (number == null) {
            return z0();
        }
        P0();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (!h(cls)) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.f23160h != t.LENIENT) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
                }
            } else if (cls != Float.class && cls != Double.class && !f23150l.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        }
        A();
        this.f23153a.append((CharSequence) string);
        return this;
    }

    public c N0(String str) throws IOException {
        if (str == null) {
            return z0();
        }
        P0();
        A();
        I0(str);
        return this;
    }

    public c O() {
        return K(3, 5, '}');
    }

    public c O0(boolean z7) throws IOException {
        P0();
        A();
        this.f23153a.write(z7 ? com.amazon.a.a.o.b.af : com.amazon.a.a.o.b.ag);
        return this;
    }

    public final void P0() throws IOException {
        if (this.f23162j != null) {
            i();
            I0(this.f23162j);
            this.f23162j = null;
        }
    }

    public final boolean T() {
        return this.f23163k;
    }

    public final t V() {
        return this.f23160h;
    }

    public final boolean X() {
        return this.f23161i;
    }

    public boolean c0() {
        return this.f23160h == t.LENIENT;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23153a.close();
        int i7 = this.f23155c;
        if (i7 > 1 || (i7 == 1 && this.f23154b[i7 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f23155c = 0;
    }

    public void flush() throws IOException {
        if (this.f23155c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f23153a.flush();
    }

    public final void i() throws IOException {
        int iB0 = B0();
        if (iB0 == 5) {
            this.f23153a.write(this.f23158f);
        } else if (iB0 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        y0();
        D0(4);
    }

    public c i0(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f23162j != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iB0 = B0();
        if (iB0 != 3 && iB0 != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f23162j = str;
        return this;
    }

    public final void y0() throws IOException {
        if (this.f23159g) {
            return;
        }
        this.f23153a.write(this.f23156d.b());
        int i7 = this.f23155c;
        for (int i8 = 1; i8 < i7; i8++) {
            this.f23153a.write(this.f23156d.a());
        }
    }

    public c z0() throws IOException {
        if (this.f23162j != null) {
            if (!this.f23163k) {
                this.f23162j = null;
                return this;
            }
            P0();
        }
        A();
        this.f23153a.write("null");
        return this;
    }
}
