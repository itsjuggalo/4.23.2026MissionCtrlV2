package gb;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f10506l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f10507m = new String[128];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f10508n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f10509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f10510b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10511c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.gson.d f10512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f10516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10519k;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f10507m[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f10507m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f10508n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        d0(6);
        this.f10516h = s.LEGACY_STRICT;
        this.f10519k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f10509a = writer;
        f0(com.google.gson.d.f6636d);
    }

    public static boolean b(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    public final c C(int i10, int i11, char c10) throws IOException {
        int iC0 = c0();
        if (iC0 != i11 && iC0 != i10) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f10518j != null) {
            throw new IllegalStateException("Dangling name: " + this.f10518j);
        }
        this.f10511c--;
        if (iC0 == i11) {
            Z();
        }
        this.f10509a.write(c10);
        return this;
    }

    public c E() {
        return C(1, 2, ']');
    }

    public c G() {
        return C(3, 5, '}');
    }

    public final boolean H() {
        return this.f10519k;
    }

    public final s K() {
        return this.f10516h;
    }

    public final boolean N() {
        return this.f10517i;
    }

    public boolean O() {
        return this.f10516h == s.LENIENT;
    }

    public c R(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f10518j != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iC0 = c0();
        if (iC0 != 3 && iC0 != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f10518j = str;
        return this;
    }

    public final void Z() throws IOException {
        if (this.f10515g) {
            return;
        }
        this.f10509a.write(this.f10512d.b());
        int i10 = this.f10511c;
        for (int i11 = 1; i11 < i10; i11++) {
            this.f10509a.write(this.f10512d.a());
        }
    }

    public c a0() throws IOException {
        if (this.f10518j != null) {
            if (!this.f10519k) {
                this.f10518j = null;
                return this;
            }
            q0();
        }
        e();
        this.f10509a.write("null");
        return this;
    }

    public final c b0(int i10, char c10) throws IOException {
        e();
        d0(i10);
        this.f10509a.write(c10);
        return this;
    }

    public final void c() throws IOException {
        int iC0 = c0();
        if (iC0 == 5) {
            this.f10509a.write(this.f10514f);
        } else if (iC0 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        Z();
        e0(4);
    }

    public final int c0() {
        int i10 = this.f10511c;
        if (i10 != 0) {
            return this.f10510b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10509a.close();
        int i10 = this.f10511c;
        if (i10 > 1 || (i10 == 1 && this.f10510b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f10511c = 0;
    }

    public final void d0(int i10) {
        int i11 = this.f10511c;
        int[] iArr = this.f10510b;
        if (i11 == iArr.length) {
            this.f10510b = Arrays.copyOf(iArr, i11 * 2);
        }
        int[] iArr2 = this.f10510b;
        int i12 = this.f10511c;
        this.f10511c = i12 + 1;
        iArr2[i12] = i10;
    }

    public final void e() throws IOException {
        int iC0 = c0();
        if (iC0 == 1) {
            e0(2);
            Z();
            return;
        }
        if (iC0 == 2) {
            this.f10509a.append((CharSequence) this.f10514f);
            Z();
        } else {
            if (iC0 == 4) {
                this.f10509a.append((CharSequence) this.f10513e);
                e0(5);
                return;
            }
            if (iC0 != 6) {
                if (iC0 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f10516h != s.LENIENT) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            e0(7);
        }
    }

    public final void e0(int i10) {
        this.f10510b[this.f10511c - 1] = i10;
    }

    public final void f0(com.google.gson.d dVar) {
        Objects.requireNonNull(dVar);
        this.f10512d = dVar;
        this.f10514f = f.f4598a;
        if (dVar.c()) {
            this.f10513e = ": ";
            if (this.f10512d.b().isEmpty()) {
                this.f10514f = ", ";
            }
        } else {
            this.f10513e = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        }
        this.f10515g = this.f10512d.b().isEmpty() && this.f10512d.a().isEmpty();
    }

    public void flush() throws IOException {
        if (this.f10511c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f10509a.flush();
    }

    public final void g0(boolean z10) {
        this.f10517i = z10;
    }

    public final void h0(boolean z10) {
        this.f10519k = z10;
    }

    public final void i0(s sVar) {
        Objects.requireNonNull(sVar);
        this.f10516h = sVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j0(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f10517i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = gb.c.f10508n
            goto L9
        L7:
            java.lang.String[] r0 = gb.c.f10507m
        L9:
            java.io.Writer r1 = r8.f10509a
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
            java.io.Writer r6 = r8.f10509a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f10509a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f10509a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f10509a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.c.j0(java.lang.String):void");
    }

    public c k0(double d10) throws IOException {
        q0();
        if (this.f10516h == s.LENIENT || !(Double.isNaN(d10) || Double.isInfinite(d10))) {
            e();
            this.f10509a.append((CharSequence) Double.toString(d10));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d10);
    }

    public c l0(long j10) throws IOException {
        q0();
        e();
        this.f10509a.write(Long.toString(j10));
        return this;
    }

    public c m0(Boolean bool) throws IOException {
        if (bool == null) {
            return a0();
        }
        q0();
        e();
        this.f10509a.write(bool.booleanValue() ? com.amazon.a.a.o.b.f4545af : com.amazon.a.a.o.b.f4546ag);
        return this;
    }

    public c n0(Number number) throws IOException {
        if (number == null) {
            return a0();
        }
        q0();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (!b(cls)) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.f10516h != s.LENIENT) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
                }
            } else if (cls != Float.class && cls != Double.class && !f10506l.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        }
        e();
        this.f10509a.append((CharSequence) string);
        return this;
    }

    public c o() throws IOException {
        q0();
        return b0(1, '[');
    }

    public c o0(String str) throws IOException {
        if (str == null) {
            return a0();
        }
        q0();
        e();
        j0(str);
        return this;
    }

    public c p0(boolean z10) throws IOException {
        q0();
        e();
        this.f10509a.write(z10 ? com.amazon.a.a.o.b.f4545af : com.amazon.a.a.o.b.f4546ag);
        return this;
    }

    public final void q0() throws IOException {
        if (this.f10518j != null) {
            c();
            j0(this.f10518j);
            this.f10518j = null;
        }
    }

    public c u() throws IOException {
        q0();
        return b0(3, '{');
    }
}
