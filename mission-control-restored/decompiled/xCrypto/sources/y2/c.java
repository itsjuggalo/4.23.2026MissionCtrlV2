package y2;

import com.amazon.a.a.o.b.f;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
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
import q2.t;

/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f15939l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f15940m = new String[UserMetadata.MAX_ROLLOUT_ASSIGNMENTS];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f15941n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f15942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f15943b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15944c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q2.d f15945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f15946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f15947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t f15949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f15950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f15951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f15952k;

    static {
        for (int i4 = 0; i4 <= 31; i4++) {
            f15940m[i4] = String.format("\\u%04x", Integer.valueOf(i4));
        }
        String[] strArr = f15940m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f15941n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        h0(6);
        this.f15949h = t.LEGACY_STRICT;
        this.f15952k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f15942a = writer;
        j0(q2.d.f14209d);
    }

    public static boolean e(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    public final c A(int i4, int i5, char c4) throws IOException {
        int iG0 = g0();
        if (iG0 != i5 && iG0 != i4) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f15951j != null) {
            throw new IllegalStateException("Dangling name: " + this.f15951j);
        }
        this.f15944c--;
        if (iG0 == i5) {
            d0();
        }
        this.f15942a.write(c4);
        return this;
    }

    public c E() {
        return A(1, 2, ']');
    }

    public c G() {
        return A(3, 5, '}');
    }

    public final boolean J() {
        return this.f15952k;
    }

    public final t K() {
        return this.f15949h;
    }

    public final boolean P() {
        return this.f15950i;
    }

    public boolean S() {
        return this.f15949h == t.LENIENT;
    }

    public c a0(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f15951j != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iG0 = g0();
        if (iG0 != 3 && iG0 != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f15951j = str;
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15942a.close();
        int i4 = this.f15944c;
        if (i4 > 1 || (i4 == 1 && this.f15943b[i4 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f15944c = 0;
    }

    public final void d0() throws IOException {
        if (this.f15948g) {
            return;
        }
        this.f15942a.write(this.f15945d.b());
        int i4 = this.f15944c;
        for (int i5 = 1; i5 < i4; i5++) {
            this.f15942a.write(this.f15945d.a());
        }
    }

    public c e0() throws IOException {
        if (this.f15951j != null) {
            if (!this.f15952k) {
                this.f15951j = null;
                return this;
            }
            u0();
        }
        g();
        this.f15942a.write("null");
        return this;
    }

    public final void f() throws IOException {
        int iG0 = g0();
        if (iG0 == 5) {
            this.f15942a.write(this.f15947f);
        } else if (iG0 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        d0();
        i0(4);
    }

    public final c f0(int i4, char c4) throws IOException {
        g();
        h0(i4);
        this.f15942a.write(c4);
        return this;
    }

    public void flush() throws IOException {
        if (this.f15944c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f15942a.flush();
    }

    public final void g() throws IOException {
        int iG0 = g0();
        if (iG0 == 1) {
            i0(2);
            d0();
            return;
        }
        if (iG0 == 2) {
            this.f15942a.append((CharSequence) this.f15947f);
            d0();
        } else {
            if (iG0 == 4) {
                this.f15942a.append((CharSequence) this.f15946e);
                i0(5);
                return;
            }
            if (iG0 != 6) {
                if (iG0 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f15949h != t.LENIENT) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            i0(7);
        }
    }

    public final int g0() {
        int i4 = this.f15944c;
        if (i4 != 0) {
            return this.f15943b[i4 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void h0(int i4) {
        int i5 = this.f15944c;
        int[] iArr = this.f15943b;
        if (i5 == iArr.length) {
            this.f15943b = Arrays.copyOf(iArr, i5 * 2);
        }
        int[] iArr2 = this.f15943b;
        int i6 = this.f15944c;
        this.f15944c = i6 + 1;
        iArr2[i6] = i4;
    }

    public final void i0(int i4) {
        this.f15943b[this.f15944c - 1] = i4;
    }

    public final void j0(q2.d dVar) {
        Objects.requireNonNull(dVar);
        this.f15945d = dVar;
        this.f15947f = f.f8804a;
        if (dVar.c()) {
            this.f15946e = ": ";
            if (this.f15945d.b().isEmpty()) {
                this.f15947f = ", ";
            }
        } else {
            this.f15946e = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        }
        this.f15948g = this.f15945d.b().isEmpty() && this.f15945d.a().isEmpty();
    }

    public final void k0(boolean z4) {
        this.f15950i = z4;
    }

    public final void l0(boolean z4) {
        this.f15952k = z4;
    }

    public final void m0(t tVar) {
        Objects.requireNonNull(tVar);
        this.f15949h = tVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n0(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f15950i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = y2.c.f15941n
            goto L9
        L7:
            java.lang.String[] r0 = y2.c.f15940m
        L9:
            java.io.Writer r1 = r8.f15942a
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
            java.io.Writer r6 = r8.f15942a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f15942a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f15942a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f15942a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.c.n0(java.lang.String):void");
    }

    public c o0(double d4) throws IOException {
        u0();
        if (this.f15949h == t.LENIENT || !(Double.isNaN(d4) || Double.isInfinite(d4))) {
            g();
            this.f15942a.append((CharSequence) Double.toString(d4));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d4);
    }

    public c p() throws IOException {
        u0();
        return f0(1, '[');
    }

    public c p0(long j4) throws IOException {
        u0();
        g();
        this.f15942a.write(Long.toString(j4));
        return this;
    }

    public c q0(Boolean bool) throws IOException {
        if (bool == null) {
            return e0();
        }
        u0();
        g();
        this.f15942a.write(bool.booleanValue() ? com.amazon.a.a.o.b.af : com.amazon.a.a.o.b.ag);
        return this;
    }

    public c r0(Number number) throws IOException {
        if (number == null) {
            return e0();
        }
        u0();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (!e(cls)) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.f15949h != t.LENIENT) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
                }
            } else if (cls != Float.class && cls != Double.class && !f15939l.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        }
        g();
        this.f15942a.append((CharSequence) string);
        return this;
    }

    public c s0(String str) throws IOException {
        if (str == null) {
            return e0();
        }
        u0();
        g();
        n0(str);
        return this;
    }

    public c t0(boolean z4) throws IOException {
        u0();
        g();
        this.f15942a.write(z4 ? com.amazon.a.a.o.b.af : com.amazon.a.a.o.b.ag);
        return this;
    }

    public final void u0() throws IOException {
        if (this.f15951j != null) {
            f();
            n0(this.f15951j);
            this.f15951j = null;
        }
    }

    public c x() throws IOException {
        u0();
        return f0(3, '{');
    }
}
