package J2;

import H2.m;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3054a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3055b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f3056c = new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3057d = new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3058e = new b("base16()", "0123456789ABCDEF");

    /* JADX INFO: renamed from: J2.a$a, reason: collision with other inner class name */
    public static final class C0040a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char[] f3060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f3062d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f3063e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f3064f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f3065g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean[] f3066h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f3067i;

        public C0040a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        public static byte[] b(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i7 = 0; i7 < cArr.length; i7++) {
                char c7 = cArr[i7];
                boolean z7 = true;
                m.f(c7 < 128, "Non-ASCII character: %s", c7);
                if (bArr[c7] != -1) {
                    z7 = false;
                }
                m.f(z7, "Duplicate character: %s", c7);
                bArr[c7] = (byte) i7;
            }
            return bArr;
        }

        public int c(char c7) throws d {
            if (c7 > 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c7));
            }
            byte b7 = this.f3065g[c7];
            if (b7 != -1) {
                return b7;
            }
            if (c7 <= ' ' || c7 == 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c7));
            }
            throw new d("Unrecognized character: " + c7);
        }

        public char d(int i7) {
            return this.f3060b[i7];
        }

        public boolean e(int i7) {
            return this.f3066h[i7 % this.f3063e];
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0040a)) {
                return false;
            }
            C0040a c0040a = (C0040a) obj;
            return this.f3067i == c0040a.f3067i && Arrays.equals(this.f3060b, c0040a.f3060b);
        }

        public boolean f(char c7) {
            byte[] bArr = this.f3065g;
            return c7 < bArr.length && bArr[c7] != -1;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f3060b) + (this.f3067i ? 1231 : 1237);
        }

        public String toString() {
            return this.f3059a;
        }

        public C0040a(String str, char[] cArr, byte[] bArr, boolean z7) {
            this.f3059a = (String) m.n(str);
            this.f3060b = (char[]) m.n(cArr);
            try {
                int iD = K2.a.d(cArr.length, RoundingMode.UNNECESSARY);
                this.f3062d = iD;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iD);
                int i7 = 1 << (3 - iNumberOfTrailingZeros);
                this.f3063e = i7;
                this.f3064f = iD >> iNumberOfTrailingZeros;
                this.f3061c = cArr.length - 1;
                this.f3065g = bArr;
                boolean[] zArr = new boolean[i7];
                for (int i8 = 0; i8 < this.f3064f; i8++) {
                    zArr[K2.a.a(i8 * 8, this.f3062d, RoundingMode.CEILING)] = true;
                }
                this.f3066h = zArr;
                this.f3067i = z7;
            } catch (ArithmeticException e7) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e7);
            }
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final char[] f3068h;

        public b(String str, String str2) {
            this(new C0040a(str, str2.toCharArray()));
        }

        @Override // J2.a.e, J2.a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            m.n(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new d("Invalid input length " + charSequence.length());
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequence.length()) {
                bArr[i8] = (byte) ((this.f3069f.c(charSequence.charAt(i7)) << 4) | this.f3069f.c(charSequence.charAt(i7 + 1)));
                i7 += 2;
                i8++;
            }
            return i8;
        }

        @Override // J2.a.e, J2.a
        public void g(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            m.n(appendable);
            m.s(i7, i7 + i8, bArr.length);
            for (int i9 = 0; i9 < i8; i9++) {
                int i10 = bArr[i7 + i9] & 255;
                appendable.append(this.f3068h[i10]);
                appendable.append(this.f3068h[i10 | 256]);
            }
        }

        @Override // J2.a.e
        public a n(C0040a c0040a, Character ch) {
            return new b(c0040a);
        }

        public b(C0040a c0040a) {
            super(c0040a, null);
            this.f3068h = new char[512];
            m.d(c0040a.f3060b.length == 16);
            for (int i7 = 0; i7 < 256; i7++) {
                this.f3068h[i7] = c0040a.d(i7 >>> 4);
                this.f3068h[i7 | 256] = c0040a.d(i7 & 15);
            }
        }
    }

    public static final class c extends e {
        public c(String str, String str2, Character ch) {
            this(new C0040a(str, str2.toCharArray()), ch);
        }

        @Override // J2.a.e, J2.a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            m.n(bArr);
            CharSequence charSequenceL = l(charSequence);
            if (!this.f3069f.e(charSequenceL.length())) {
                throw new d("Invalid input length " + charSequenceL.length());
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequenceL.length()) {
                int i9 = i7 + 2;
                int iC = (this.f3069f.c(charSequenceL.charAt(i7)) << 18) | (this.f3069f.c(charSequenceL.charAt(i7 + 1)) << 12);
                int i10 = i8 + 1;
                bArr[i8] = (byte) (iC >>> 16);
                if (i9 < charSequenceL.length()) {
                    int i11 = i7 + 3;
                    int iC2 = iC | (this.f3069f.c(charSequenceL.charAt(i9)) << 6);
                    int i12 = i8 + 2;
                    bArr[i10] = (byte) ((iC2 >>> 8) & 255);
                    if (i11 < charSequenceL.length()) {
                        i7 += 4;
                        i8 += 3;
                        bArr[i12] = (byte) ((iC2 | this.f3069f.c(charSequenceL.charAt(i11))) & 255);
                    } else {
                        i8 = i12;
                        i7 = i11;
                    }
                } else {
                    i8 = i10;
                    i7 = i9;
                }
            }
            return i8;
        }

        @Override // J2.a.e, J2.a
        public void g(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            m.n(appendable);
            int i9 = i7 + i8;
            m.s(i7, i9, bArr.length);
            while (i8 >= 3) {
                int i10 = i7 + 2;
                int i11 = ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7] & 255) << 16);
                i7 += 3;
                int i12 = i11 | (bArr[i10] & 255);
                appendable.append(this.f3069f.d(i12 >>> 18));
                appendable.append(this.f3069f.d((i12 >>> 12) & 63));
                appendable.append(this.f3069f.d((i12 >>> 6) & 63));
                appendable.append(this.f3069f.d(i12 & 63));
                i8 -= 3;
            }
            if (i7 < i9) {
                m(appendable, bArr, i7, i9 - i7);
            }
        }

        @Override // J2.a.e
        public a n(C0040a c0040a, Character ch) {
            return new c(c0040a, ch);
        }

        public c(C0040a c0040a, Character ch) {
            super(c0040a, ch);
            m.d(c0040a.f3060b.length == 64);
        }
    }

    public static final class d extends IOException {
        public d(String str) {
            super(str);
        }
    }

    public static class e extends a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C0040a f3069f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Character f3070g;

        public e(String str, String str2, Character ch) {
            this(new C0040a(str, str2.toCharArray()), ch);
        }

        @Override // J2.a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            C0040a c0040a;
            m.n(bArr);
            CharSequence charSequenceL = l(charSequence);
            if (!this.f3069f.e(charSequenceL.length())) {
                throw new d("Invalid input length " + charSequenceL.length());
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequenceL.length()) {
                long jC = 0;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    c0040a = this.f3069f;
                    if (i9 >= c0040a.f3063e) {
                        break;
                    }
                    jC <<= c0040a.f3062d;
                    if (i7 + i9 < charSequenceL.length()) {
                        jC |= (long) this.f3069f.c(charSequenceL.charAt(i10 + i7));
                        i10++;
                    }
                    i9++;
                }
                int i11 = c0040a.f3064f;
                int i12 = (i11 * 8) - (i10 * c0040a.f3062d);
                int i13 = (i11 - 1) * 8;
                while (i13 >= i12) {
                    bArr[i8] = (byte) ((jC >>> i13) & 255);
                    i13 -= 8;
                    i8++;
                }
                i7 += this.f3069f.f3063e;
            }
            return i8;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f3069f.equals(eVar.f3069f) && Objects.equals(this.f3070g, eVar.f3070g);
        }

        @Override // J2.a
        public void g(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            m.n(appendable);
            m.s(i7, i7 + i8, bArr.length);
            int i9 = 0;
            while (i9 < i8) {
                m(appendable, bArr, i7 + i9, Math.min(this.f3069f.f3064f, i8 - i9));
                i9 += this.f3069f.f3064f;
            }
        }

        public int hashCode() {
            return this.f3069f.hashCode() ^ Objects.hashCode(this.f3070g);
        }

        @Override // J2.a
        public int i(int i7) {
            return (int) (((((long) this.f3069f.f3062d) * ((long) i7)) + 7) / 8);
        }

        @Override // J2.a
        public int j(int i7) {
            C0040a c0040a = this.f3069f;
            return c0040a.f3063e * K2.a.a(i7, c0040a.f3064f, RoundingMode.CEILING);
        }

        @Override // J2.a
        public a k() {
            return this.f3070g == null ? this : n(this.f3069f, null);
        }

        @Override // J2.a
        public CharSequence l(CharSequence charSequence) {
            m.n(charSequence);
            Character ch = this.f3070g;
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

        public void m(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            m.n(appendable);
            m.s(i7, i7 + i8, bArr.length);
            int i9 = 0;
            m.d(i8 <= this.f3069f.f3064f);
            long j7 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                j7 = (j7 | ((long) (bArr[i7 + i10] & 255))) << 8;
            }
            int i11 = ((i8 + 1) * 8) - this.f3069f.f3062d;
            while (i9 < i8 * 8) {
                C0040a c0040a = this.f3069f;
                appendable.append(c0040a.d(((int) (j7 >>> (i11 - i9))) & c0040a.f3061c));
                i9 += this.f3069f.f3062d;
            }
            if (this.f3070g != null) {
                while (i9 < this.f3069f.f3064f * 8) {
                    appendable.append(this.f3070g.charValue());
                    i9 += this.f3069f.f3062d;
                }
            }
        }

        public a n(C0040a c0040a, Character ch) {
            return new e(c0040a, ch);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f3069f);
            if (8 % this.f3069f.f3062d != 0) {
                if (this.f3070g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f3070g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        public e(C0040a c0040a, Character ch) {
            this.f3069f = (C0040a) m.n(c0040a);
            m.j(ch == null || !c0040a.f(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f3070g = ch;
        }
    }

    public static a a() {
        return f3054a;
    }

    public static byte[] h(byte[] bArr, int i7) {
        if (i7 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i7];
        System.arraycopy(bArr, 0, bArr2, 0, i7);
        return bArr2;
    }

    public final byte[] b(CharSequence charSequence) {
        try {
            return c(charSequence);
        } catch (d e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public final byte[] c(CharSequence charSequence) {
        CharSequence charSequenceL = l(charSequence);
        byte[] bArr = new byte[i(charSequenceL.length())];
        return h(bArr, d(bArr, charSequenceL));
    }

    public abstract int d(byte[] bArr, CharSequence charSequence);

    public String e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public final String f(byte[] bArr, int i7, int i8) {
        m.s(i7, i7 + i8, bArr.length);
        StringBuilder sb = new StringBuilder(j(i8));
        try {
            g(sb, bArr, i7, i8);
            return sb.toString();
        } catch (IOException e7) {
            throw new AssertionError(e7);
        }
    }

    public abstract void g(Appendable appendable, byte[] bArr, int i7, int i8);

    public abstract int i(int i7);

    public abstract int j(int i7);

    public abstract a k();

    public abstract CharSequence l(CharSequence charSequence);
}
