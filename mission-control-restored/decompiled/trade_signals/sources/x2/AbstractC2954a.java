package x2;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import v2.AbstractC2836b;
import v2.AbstractC2848n;
import y2.AbstractC2976a;

/* JADX INFO: renamed from: x2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2954a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC2954a f24168a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC2954a f24169b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC2954a f24170c = new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC2954a f24171d = new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC2954a f24172e = new b("base16()", "0123456789ABCDEF");

    /* JADX INFO: renamed from: x2.a$a, reason: collision with other inner class name */
    public static final class C0428a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char[] f24174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f24175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f24176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f24177e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f24178f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f24179g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean[] f24180h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f24181i;

        public C0428a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        public static byte[] b(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i8 = 0; i8 < cArr.length; i8++) {
                char c8 = cArr[i8];
                boolean z7 = true;
                AbstractC2848n.f(c8 < 128, "Non-ASCII character: %s", c8);
                if (bArr[c8] != -1) {
                    z7 = false;
                }
                AbstractC2848n.f(z7, "Duplicate character: %s", c8);
                bArr[c8] = (byte) i8;
            }
            return bArr;
        }

        public int c(char c8) throws d {
            if (c8 > 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c8));
            }
            byte b8 = this.f24179g[c8];
            if (b8 != -1) {
                return b8;
            }
            if (c8 <= ' ' || c8 == 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c8));
            }
            throw new d("Unrecognized character: " + c8);
        }

        public char d(int i8) {
            return this.f24174b[i8];
        }

        public final boolean e() {
            for (char c8 : this.f24174b) {
                if (AbstractC2836b.a(c8)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0428a)) {
                return false;
            }
            C0428a c0428a = (C0428a) obj;
            return this.f24181i == c0428a.f24181i && Arrays.equals(this.f24174b, c0428a.f24174b);
        }

        public final boolean f() {
            for (char c8 : this.f24174b) {
                if (AbstractC2836b.b(c8)) {
                    return true;
                }
            }
            return false;
        }

        public C0428a g() {
            if (this.f24181i) {
                return this;
            }
            byte[] bArr = this.f24179g;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            int i8 = 65;
            while (true) {
                if (i8 > 90) {
                    return new C0428a(this.f24173a + ".ignoreCase()", this.f24174b, bArrCopyOf, true);
                }
                int i9 = i8 | 32;
                byte[] bArr2 = this.f24179g;
                byte b8 = bArr2[i8];
                byte b9 = bArr2[i9];
                if (b8 == -1) {
                    bArrCopyOf[i8] = b9;
                } else {
                    AbstractC2848n.v(b9 == -1, "Can't ignoreCase() since '%s' and '%s' encode different values", (char) i8, (char) i9);
                    bArrCopyOf[i9] = b8;
                }
                i8++;
            }
        }

        public boolean h(int i8) {
            return this.f24180h[i8 % this.f24177e];
        }

        public int hashCode() {
            return Arrays.hashCode(this.f24174b) + (this.f24181i ? 1231 : 1237);
        }

        public boolean i(char c8) {
            byte[] bArr = this.f24179g;
            return c8 < bArr.length && bArr[c8] != -1;
        }

        public C0428a j() {
            if (!e()) {
                return this;
            }
            AbstractC2848n.u(!f(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f24174b.length];
            int i8 = 0;
            while (true) {
                char[] cArr2 = this.f24174b;
                if (i8 >= cArr2.length) {
                    break;
                }
                cArr[i8] = AbstractC2836b.c(cArr2[i8]);
                i8++;
            }
            C0428a c0428a = new C0428a(this.f24173a + ".upperCase()", cArr);
            return this.f24181i ? c0428a.g() : c0428a;
        }

        public String toString() {
            return this.f24173a;
        }

        public C0428a(String str, char[] cArr, byte[] bArr, boolean z7) {
            this.f24173a = (String) AbstractC2848n.n(str);
            this.f24174b = (char[]) AbstractC2848n.n(cArr);
            try {
                int iD = AbstractC2976a.d(cArr.length, RoundingMode.UNNECESSARY);
                this.f24176d = iD;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iD);
                int i8 = 1 << (3 - iNumberOfTrailingZeros);
                this.f24177e = i8;
                this.f24178f = iD >> iNumberOfTrailingZeros;
                this.f24175c = cArr.length - 1;
                this.f24179g = bArr;
                boolean[] zArr = new boolean[i8];
                for (int i9 = 0; i9 < this.f24178f; i9++) {
                    zArr[AbstractC2976a.a(i9 * 8, this.f24176d, RoundingMode.CEILING)] = true;
                }
                this.f24180h = zArr;
                this.f24181i = z7;
            } catch (ArithmeticException e8) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e8);
            }
        }
    }

    /* JADX INFO: renamed from: x2.a$b */
    public static final class b extends e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final char[] f24182i;

        public b(String str, String str2) {
            this(new C0428a(str, str2.toCharArray()));
        }

        @Override // x2.AbstractC2954a.e, x2.AbstractC2954a
        public int e(byte[] bArr, CharSequence charSequence) throws d {
            AbstractC2848n.n(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new d("Invalid input length " + charSequence.length());
            }
            int i8 = 0;
            int i9 = 0;
            while (i8 < charSequence.length()) {
                bArr[i9] = (byte) ((this.f24183f.c(charSequence.charAt(i8)) << 4) | this.f24183f.c(charSequence.charAt(i8 + 1)));
                i8 += 2;
                i9++;
            }
            return i9;
        }

        @Override // x2.AbstractC2954a.e, x2.AbstractC2954a
        public void h(Appendable appendable, byte[] bArr, int i8, int i9) throws IOException {
            AbstractC2848n.n(appendable);
            AbstractC2848n.s(i8, i8 + i9, bArr.length);
            for (int i10 = 0; i10 < i9; i10++) {
                int i11 = bArr[i8 + i10] & 255;
                appendable.append(this.f24182i[i11]);
                appendable.append(this.f24182i[i11 | 256]);
            }
        }

        @Override // x2.AbstractC2954a.e
        public AbstractC2954a p(C0428a c0428a, Character ch) {
            return new b(c0428a);
        }

        public b(C0428a c0428a) {
            super(c0428a, null);
            this.f24182i = new char[512];
            AbstractC2848n.d(c0428a.f24174b.length == 16);
            for (int i8 = 0; i8 < 256; i8++) {
                this.f24182i[i8] = c0428a.d(i8 >>> 4);
                this.f24182i[i8 | 256] = c0428a.d(i8 & 15);
            }
        }
    }

    /* JADX INFO: renamed from: x2.a$c */
    public static final class c extends e {
        public c(String str, String str2, Character ch) {
            this(new C0428a(str, str2.toCharArray()), ch);
        }

        @Override // x2.AbstractC2954a.e, x2.AbstractC2954a
        public int e(byte[] bArr, CharSequence charSequence) throws d {
            AbstractC2848n.n(bArr);
            CharSequence charSequenceM = m(charSequence);
            if (!this.f24183f.h(charSequenceM.length())) {
                throw new d("Invalid input length " + charSequenceM.length());
            }
            int i8 = 0;
            int i9 = 0;
            while (i8 < charSequenceM.length()) {
                int i10 = i8 + 2;
                int iC = (this.f24183f.c(charSequenceM.charAt(i8)) << 18) | (this.f24183f.c(charSequenceM.charAt(i8 + 1)) << 12);
                int i11 = i9 + 1;
                bArr[i9] = (byte) (iC >>> 16);
                if (i10 < charSequenceM.length()) {
                    int i12 = i8 + 3;
                    int iC2 = iC | (this.f24183f.c(charSequenceM.charAt(i10)) << 6);
                    int i13 = i9 + 2;
                    bArr[i11] = (byte) ((iC2 >>> 8) & 255);
                    if (i12 < charSequenceM.length()) {
                        i8 += 4;
                        i9 += 3;
                        bArr[i13] = (byte) ((iC2 | this.f24183f.c(charSequenceM.charAt(i12))) & 255);
                    } else {
                        i9 = i13;
                        i8 = i12;
                    }
                } else {
                    i9 = i11;
                    i8 = i10;
                }
            }
            return i9;
        }

        @Override // x2.AbstractC2954a.e, x2.AbstractC2954a
        public void h(Appendable appendable, byte[] bArr, int i8, int i9) throws IOException {
            AbstractC2848n.n(appendable);
            int i10 = i8 + i9;
            AbstractC2848n.s(i8, i10, bArr.length);
            while (i9 >= 3) {
                int i11 = i8 + 2;
                int i12 = ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8] & 255) << 16);
                i8 += 3;
                int i13 = i12 | (bArr[i11] & 255);
                appendable.append(this.f24183f.d(i13 >>> 18));
                appendable.append(this.f24183f.d((i13 >>> 12) & 63));
                appendable.append(this.f24183f.d((i13 >>> 6) & 63));
                appendable.append(this.f24183f.d(i13 & 63));
                i9 -= 3;
            }
            if (i8 < i10) {
                o(appendable, bArr, i8, i10 - i8);
            }
        }

        @Override // x2.AbstractC2954a.e
        public AbstractC2954a p(C0428a c0428a, Character ch) {
            return new c(c0428a, ch);
        }

        public c(C0428a c0428a, Character ch) {
            super(c0428a, ch);
            AbstractC2848n.d(c0428a.f24174b.length == 64);
        }
    }

    /* JADX INFO: renamed from: x2.a$d */
    public static final class d extends IOException {
        public d(String str) {
            super(str);
        }
    }

    /* JADX INFO: renamed from: x2.a$e */
    public static class e extends AbstractC2954a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C0428a f24183f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Character f24184g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile AbstractC2954a f24185h;

        public e(String str, String str2, Character ch) {
            this(new C0428a(str, str2.toCharArray()), ch);
        }

        @Override // x2.AbstractC2954a
        public int e(byte[] bArr, CharSequence charSequence) throws d {
            C0428a c0428a;
            AbstractC2848n.n(bArr);
            CharSequence charSequenceM = m(charSequence);
            if (!this.f24183f.h(charSequenceM.length())) {
                throw new d("Invalid input length " + charSequenceM.length());
            }
            int i8 = 0;
            int i9 = 0;
            while (i8 < charSequenceM.length()) {
                long jC = 0;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    c0428a = this.f24183f;
                    if (i10 >= c0428a.f24177e) {
                        break;
                    }
                    jC <<= c0428a.f24176d;
                    if (i8 + i10 < charSequenceM.length()) {
                        jC |= (long) this.f24183f.c(charSequenceM.charAt(i11 + i8));
                        i11++;
                    }
                    i10++;
                }
                int i12 = c0428a.f24178f;
                int i13 = (i12 * 8) - (i11 * c0428a.f24176d);
                int i14 = (i12 - 1) * 8;
                while (i14 >= i13) {
                    bArr[i9] = (byte) ((jC >>> i14) & 255);
                    i14 -= 8;
                    i9++;
                }
                i8 += this.f24183f.f24177e;
            }
            return i9;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f24183f.equals(eVar.f24183f) && Objects.equals(this.f24184g, eVar.f24184g);
        }

        @Override // x2.AbstractC2954a
        public void h(Appendable appendable, byte[] bArr, int i8, int i9) throws IOException {
            AbstractC2848n.n(appendable);
            AbstractC2848n.s(i8, i8 + i9, bArr.length);
            int i10 = 0;
            while (i10 < i9) {
                o(appendable, bArr, i8 + i10, Math.min(this.f24183f.f24178f, i9 - i10));
                i10 += this.f24183f.f24178f;
            }
        }

        public int hashCode() {
            return this.f24183f.hashCode() ^ Objects.hashCode(this.f24184g);
        }

        @Override // x2.AbstractC2954a
        public int j(int i8) {
            return (int) (((((long) this.f24183f.f24176d) * ((long) i8)) + 7) / 8);
        }

        @Override // x2.AbstractC2954a
        public int k(int i8) {
            C0428a c0428a = this.f24183f;
            return c0428a.f24177e * AbstractC2976a.a(i8, c0428a.f24178f, RoundingMode.CEILING);
        }

        @Override // x2.AbstractC2954a
        public AbstractC2954a l() {
            return this.f24184g == null ? this : p(this.f24183f, null);
        }

        @Override // x2.AbstractC2954a
        public CharSequence m(CharSequence charSequence) {
            AbstractC2848n.n(charSequence);
            Character ch = this.f24184g;
            if (ch == null) {
                return charSequence;
            }
            char cCharValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // x2.AbstractC2954a
        public AbstractC2954a n() {
            AbstractC2954a abstractC2954aP = this.f24185h;
            if (abstractC2954aP == null) {
                C0428a c0428aJ = this.f24183f.j();
                abstractC2954aP = c0428aJ == this.f24183f ? this : p(c0428aJ, this.f24184g);
                this.f24185h = abstractC2954aP;
            }
            return abstractC2954aP;
        }

        public void o(Appendable appendable, byte[] bArr, int i8, int i9) throws IOException {
            AbstractC2848n.n(appendable);
            AbstractC2848n.s(i8, i8 + i9, bArr.length);
            int i10 = 0;
            AbstractC2848n.d(i9 <= this.f24183f.f24178f);
            long j8 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                j8 = (j8 | ((long) (bArr[i8 + i11] & 255))) << 8;
            }
            int i12 = ((i9 + 1) * 8) - this.f24183f.f24176d;
            while (i10 < i9 * 8) {
                C0428a c0428a = this.f24183f;
                appendable.append(c0428a.d(((int) (j8 >>> (i12 - i10))) & c0428a.f24175c));
                i10 += this.f24183f.f24176d;
            }
            if (this.f24184g != null) {
                while (i10 < this.f24183f.f24178f * 8) {
                    appendable.append(this.f24184g.charValue());
                    i10 += this.f24183f.f24176d;
                }
            }
        }

        public AbstractC2954a p(C0428a c0428a, Character ch) {
            return new e(c0428a, ch);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f24183f);
            if (8 % this.f24183f.f24176d != 0) {
                if (this.f24184g == null) {
                    str = ".omitPadding()";
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f24184g);
                    str = "')";
                }
                sb.append(str);
            }
            return sb.toString();
        }

        public e(C0428a c0428a, Character ch) {
            this.f24183f = (C0428a) AbstractC2848n.n(c0428a);
            AbstractC2848n.j(ch == null || !c0428a.i(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f24184g = ch;
        }
    }

    public static AbstractC2954a a() {
        return f24172e;
    }

    public static AbstractC2954a b() {
        return f24168a;
    }

    public static byte[] i(byte[] bArr, int i8) {
        if (i8 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, 0, bArr2, 0, i8);
        return bArr2;
    }

    public final byte[] c(CharSequence charSequence) {
        try {
            return d(charSequence);
        } catch (d e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    public final byte[] d(CharSequence charSequence) {
        CharSequence charSequenceM = m(charSequence);
        byte[] bArr = new byte[j(charSequenceM.length())];
        return i(bArr, e(bArr, charSequenceM));
    }

    public abstract int e(byte[] bArr, CharSequence charSequence);

    public String f(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public final String g(byte[] bArr, int i8, int i9) {
        AbstractC2848n.s(i8, i8 + i9, bArr.length);
        StringBuilder sb = new StringBuilder(k(i9));
        try {
            h(sb, bArr, i8, i9);
            return sb.toString();
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }

    public abstract void h(Appendable appendable, byte[] bArr, int i8, int i9);

    public abstract int j(int i8);

    public abstract int k(int i8);

    public abstract AbstractC2954a l();

    public abstract CharSequence m(CharSequence charSequence);

    public abstract AbstractC2954a n();
}
