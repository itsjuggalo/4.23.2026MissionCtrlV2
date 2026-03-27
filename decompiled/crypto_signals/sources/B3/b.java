package B3;

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
import t3.C1179a;

/* JADX INFO: loaded from: classes.dex */
public class b implements Closeable, Flushable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f161p = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f162q = new String[128];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f163r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1179a f167d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f168f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f172n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f173o;

    static {
        for (int i = 0; i <= 31; i++) {
            f162q[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f162q;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f163r = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        int[] iArr = new int[32];
        this.f165b = iArr;
        this.f166c = 0;
        if (iArr.length == 0) {
            this.f165b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f165b;
        int i = this.f166c;
        this.f166c = i + 1;
        iArr2[i] = 6;
        this.f170l = 2;
        this.f173o = true;
        Objects.requireNonNull(writer, "out == null");
        this.f164a = writer;
        o(C1179a.f10230d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f164a.close();
        int i = this.f166c;
        if (i > 1 || (i == 1 && this.f165b[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f166c = 0;
    }

    public final void d() throws IOException {
        int iN = n();
        if (iN == 1) {
            this.f165b[this.f166c - 1] = 2;
            l();
            return;
        }
        Writer writer = this.f164a;
        if (iN == 2) {
            writer.append((CharSequence) this.f168f);
            l();
        } else {
            if (iN == 4) {
                writer.append((CharSequence) this.e);
                this.f165b[this.f166c - 1] = 5;
                return;
            }
            if (iN != 6) {
                if (iN != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f170l != 1) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f165b[this.f166c - 1] = 7;
        }
    }

    public void f() throws IOException {
        x();
        d();
        int i = this.f166c;
        int[] iArr = this.f165b;
        if (i == iArr.length) {
            this.f165b = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.f165b;
        int i6 = this.f166c;
        this.f166c = i6 + 1;
        iArr2[i6] = 1;
        this.f164a.write(91);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f166c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f164a.flush();
    }

    public void g() throws IOException {
        x();
        d();
        int i = this.f166c;
        int[] iArr = this.f165b;
        if (i == iArr.length) {
            this.f165b = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.f165b;
        int i6 = this.f166c;
        this.f166c = i6 + 1;
        iArr2[i6] = 3;
        this.f164a.write(123);
    }

    public final void h(int i, int i6, char c6) throws IOException {
        int iN = n();
        if (iN != i6 && iN != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f172n != null) {
            throw new IllegalStateException("Dangling name: " + this.f172n);
        }
        this.f166c--;
        if (iN == i6) {
            l();
        }
        this.f164a.write(c6);
    }

    public void i() throws IOException {
        h(1, 2, ']');
    }

    public void j() throws IOException {
        h(3, 5, '}');
    }

    public void k(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f172n != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iN = n();
        if (iN != 3 && iN != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f172n = str;
    }

    public final void l() throws IOException {
        if (this.f169k) {
            return;
        }
        String str = this.f167d.f10231a;
        Writer writer = this.f164a;
        writer.write(str);
        int i = this.f166c;
        for (int i6 = 1; i6 < i; i6++) {
            writer.write(this.f167d.f10232b);
        }
    }

    public b m() throws IOException {
        if (this.f172n != null) {
            if (!this.f173o) {
                this.f172n = null;
                return this;
            }
            x();
        }
        d();
        this.f164a.write("null");
        return this;
    }

    public final int n() {
        int i = this.f166c;
        if (i != 0) {
            return this.f165b[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void o(C1179a c1179a) {
        Objects.requireNonNull(c1179a);
        this.f167d = c1179a;
        this.f168f = ",";
        if (c1179a.f10233c) {
            this.e = ": ";
            if (c1179a.f10231a.isEmpty()) {
                this.f168f = ", ";
            }
        } else {
            this.e = ":";
        }
        this.f169k = this.f167d.f10231a.isEmpty() && this.f167d.f10232b.isEmpty();
    }

    public final void p(int i) {
        if (i == 0) {
            throw null;
        }
        this.f170l = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f171m
            if (r0 == 0) goto L7
            java.lang.String[] r0 = B3.b.f163r
            goto L9
        L7:
            java.lang.String[] r0 = B3.b.f162q
        L9:
            java.io.Writer r1 = r8.f164a
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = r4
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.794E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.b.q(java.lang.String):void");
    }

    public void r(double d4) throws IOException {
        x();
        if (this.f170l == 1 || !(Double.isNaN(d4) || Double.isInfinite(d4))) {
            d();
            this.f164a.append((CharSequence) Double.toString(d4));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d4);
        }
    }

    public void s(long j4) throws IOException {
        x();
        d();
        this.f164a.write(Long.toString(j4));
    }

    public void t(Boolean bool) throws IOException {
        if (bool == null) {
            m();
            return;
        }
        x();
        d();
        this.f164a.write(bool.booleanValue() ? "true" : "false");
    }

    public void u(Number number) throws IOException {
        if (number == null) {
            m();
            return;
        }
        x();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.f170l != 1) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
                }
            } else if (cls != Float.class && cls != Double.class && !f161p.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        }
        d();
        this.f164a.append((CharSequence) string);
    }

    public void v(String str) throws IOException {
        if (str == null) {
            m();
            return;
        }
        x();
        d();
        q(str);
    }

    public void w(boolean z6) throws IOException {
        x();
        d();
        this.f164a.write(z6 ? "true" : "false");
    }

    public final void x() throws IOException {
        if (this.f172n != null) {
            int iN = n();
            if (iN == 5) {
                this.f164a.write(this.f168f);
            } else if (iN != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            l();
            this.f165b[this.f166c - 1] = 4;
            q(this.f172n);
            this.f172n = null;
        }
    }
}
