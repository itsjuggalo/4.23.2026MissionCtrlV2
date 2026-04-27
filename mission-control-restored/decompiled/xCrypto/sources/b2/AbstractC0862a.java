package b2;

import Z1.m;
import c2.AbstractC0874a;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0862a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0862a f8266a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0862a f8267b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC0862a f8268c = new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC0862a f8269d = new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC0862a f8270e = new b("base16()", "0123456789ABCDEF");

    /* JADX INFO: renamed from: b2.a$a, reason: collision with other inner class name */
    public static final class C0124a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char[] f8272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f8274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f8275e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f8276f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f8277g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean[] f8278h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f8279i;

        public C0124a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        public static byte[] b(char[] cArr) {
            byte[] bArr = new byte[UserMetadata.MAX_ROLLOUT_ASSIGNMENTS];
            Arrays.fill(bArr, (byte) -1);
            for (int i4 = 0; i4 < cArr.length; i4++) {
                char c4 = cArr[i4];
                boolean z4 = true;
                m.f(c4 < 128, "Non-ASCII character: %s", c4);
                if (bArr[c4] != -1) {
                    z4 = false;
                }
                m.f(z4, "Duplicate character: %s", c4);
                bArr[c4] = (byte) i4;
            }
            return bArr;
        }

        public int c(char c4) throws d {
            if (c4 > 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c4));
            }
            byte b4 = this.f8277g[c4];
            if (b4 != -1) {
                return b4;
            }
            if (c4 <= ' ' || c4 == 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c4));
            }
            throw new d("Unrecognized character: " + c4);
        }

        public char d(int i4) {
            return this.f8272b[i4];
        }

        public boolean e(int i4) {
            return this.f8278h[i4 % this.f8275e];
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0124a) {
                C0124a c0124a = (C0124a) obj;
                if (this.f8279i == c0124a.f8279i && Arrays.equals(this.f8272b, c0124a.f8272b)) {
                    return true;
                }
            }
            return false;
        }

        public boolean f(char c4) {
            byte[] bArr = this.f8277g;
            return c4 < bArr.length && bArr[c4] != -1;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f8272b) + (this.f8279i ? 1231 : 1237);
        }

        public String toString() {
            return this.f8271a;
        }

        public C0124a(String str, char[] cArr, byte[] bArr, boolean z4) {
            this.f8271a = (String) m.n(str);
            this.f8272b = (char[]) m.n(cArr);
            try {
                int iD = AbstractC0874a.d(cArr.length, RoundingMode.UNNECESSARY);
                this.f8274d = iD;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iD);
                int i4 = 1 << (3 - iNumberOfTrailingZeros);
                this.f8275e = i4;
                this.f8276f = iD >> iNumberOfTrailingZeros;
                this.f8273c = cArr.length - 1;
                this.f8277g = bArr;
                boolean[] zArr = new boolean[i4];
                for (int i5 = 0; i5 < this.f8276f; i5++) {
                    zArr[AbstractC0874a.a(i5 * 8, this.f8274d, RoundingMode.CEILING)] = true;
                }
                this.f8278h = zArr;
                this.f8279i = z4;
            } catch (ArithmeticException e4) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e4);
            }
        }
    }

    /* JADX INFO: renamed from: b2.a$b */
    public static final class b extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final char[] f8280h;

        public b(String str, String str2) {
            this(new C0124a(str, str2.toCharArray()));
        }

        @Override // b2.AbstractC0862a.e, b2.AbstractC0862a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            m.n(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new d("Invalid input length " + charSequence.length());
            }
            int i4 = 0;
            int i5 = 0;
            while (i4 < charSequence.length()) {
                bArr[i5] = (byte) ((this.f8281f.c(charSequence.charAt(i4)) << 4) | this.f8281f.c(charSequence.charAt(i4 + 1)));
                i4 += 2;
                i5++;
            }
            return i5;
        }

        @Override // b2.AbstractC0862a.e, b2.AbstractC0862a
        public void g(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
            m.n(appendable);
            m.s(i4, i4 + i5, bArr.length);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = bArr[i4 + i6] & 255;
                appendable.append(this.f8280h[i7]);
                appendable.append(this.f8280h[i7 | 256]);
            }
        }

        @Override // b2.AbstractC0862a.e
        public AbstractC0862a n(C0124a c0124a, Character ch) {
            return new b(c0124a);
        }

        public b(C0124a c0124a) {
            super(c0124a, null);
            this.f8280h = new char[512];
            m.d(c0124a.f8272b.length == 16);
            for (int i4 = 0; i4 < 256; i4++) {
                this.f8280h[i4] = c0124a.d(i4 >>> 4);
                this.f8280h[i4 | 256] = c0124a.d(i4 & 15);
            }
        }
    }

    /* JADX INFO: renamed from: b2.a$c */
    public static final class c extends e {
        public c(String str, String str2, Character ch) {
            this(new C0124a(str, str2.toCharArray()), ch);
        }

        @Override // b2.AbstractC0862a.e, b2.AbstractC0862a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            m.n(bArr);
            CharSequence charSequenceL = l(charSequence);
            if (!this.f8281f.e(charSequenceL.length())) {
                throw new d("Invalid input length " + charSequenceL.length());
            }
            int i4 = 0;
            int i5 = 0;
            while (i4 < charSequenceL.length()) {
                int i6 = i4 + 2;
                int iC = (this.f8281f.c(charSequenceL.charAt(i4)) << 18) | (this.f8281f.c(charSequenceL.charAt(i4 + 1)) << 12);
                int i7 = i5 + 1;
                bArr[i5] = (byte) (iC >>> 16);
                if (i6 < charSequenceL.length()) {
                    int i8 = i4 + 3;
                    int iC2 = iC | (this.f8281f.c(charSequenceL.charAt(i6)) << 6);
                    int i9 = i5 + 2;
                    bArr[i7] = (byte) ((iC2 >>> 8) & 255);
                    if (i8 < charSequenceL.length()) {
                        i4 += 4;
                        i5 += 3;
                        bArr[i9] = (byte) ((iC2 | this.f8281f.c(charSequenceL.charAt(i8))) & 255);
                    } else {
                        i5 = i9;
                        i4 = i8;
                    }
                } else {
                    i5 = i7;
                    i4 = i6;
                }
            }
            return i5;
        }

        @Override // b2.AbstractC0862a.e, b2.AbstractC0862a
        public void g(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
            m.n(appendable);
            int i6 = i4 + i5;
            m.s(i4, i6, bArr.length);
            while (i5 >= 3) {
                int i7 = i4 + 2;
                int i8 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16);
                i4 += 3;
                int i9 = i8 | (bArr[i7] & 255);
                appendable.append(this.f8281f.d(i9 >>> 18));
                appendable.append(this.f8281f.d((i9 >>> 12) & 63));
                appendable.append(this.f8281f.d((i9 >>> 6) & 63));
                appendable.append(this.f8281f.d(i9 & 63));
                i5 -= 3;
            }
            if (i4 < i6) {
                m(appendable, bArr, i4, i6 - i4);
            }
        }

        @Override // b2.AbstractC0862a.e
        public AbstractC0862a n(C0124a c0124a, Character ch) {
            return new c(c0124a, ch);
        }

        public c(C0124a c0124a, Character ch) {
            super(c0124a, ch);
            m.d(c0124a.f8272b.length == 64);
        }
    }

    /* JADX INFO: renamed from: b2.a$d */
    public static final class d extends IOException {
        public d(String str) {
            super(str);
        }
    }

    /* JADX INFO: renamed from: b2.a$e */
    public static class e extends AbstractC0862a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C0124a f8281f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Character f8282g;

        public e(String str, String str2, Character ch) {
            this(new C0124a(str, str2.toCharArray()), ch);
        }

        @Override // b2.AbstractC0862a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            C0124a c0124a;
            m.n(bArr);
            CharSequence charSequenceL = l(charSequence);
            if (!this.f8281f.e(charSequenceL.length())) {
                throw new d("Invalid input length " + charSequenceL.length());
            }
            int i4 = 0;
            int i5 = 0;
            while (i4 < charSequenceL.length()) {
                long jC = 0;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    c0124a = this.f8281f;
                    if (i6 >= c0124a.f8275e) {
                        break;
                    }
                    jC <<= c0124a.f8274d;
                    if (i4 + i6 < charSequenceL.length()) {
                        jC |= (long) this.f8281f.c(charSequenceL.charAt(i7 + i4));
                        i7++;
                    }
                    i6++;
                }
                int i8 = c0124a.f8276f;
                int i9 = (i8 * 8) - (i7 * c0124a.f8274d);
                int i10 = (i8 - 1) * 8;
                while (i10 >= i9) {
                    bArr[i5] = (byte) ((jC >>> i10) & 255);
                    i10 -= 8;
                    i5++;
                }
                i4 += this.f8281f.f8275e;
            }
            return i5;
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.f8281f.equals(eVar.f8281f) && Objects.equals(this.f8282g, eVar.f8282g)) {
                    return true;
                }
            }
            return false;
        }

        @Override // b2.AbstractC0862a
        public void g(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
            m.n(appendable);
            m.s(i4, i4 + i5, bArr.length);
            int i6 = 0;
            while (i6 < i5) {
                m(appendable, bArr, i4 + i6, Math.min(this.f8281f.f8276f, i5 - i6));
                i6 += this.f8281f.f8276f;
            }
        }

        public int hashCode() {
            return this.f8281f.hashCode() ^ Objects.hashCode(this.f8282g);
        }

        @Override // b2.AbstractC0862a
        public int i(int i4) {
            return (int) (((((long) this.f8281f.f8274d) * ((long) i4)) + 7) / 8);
        }

        @Override // b2.AbstractC0862a
        public int j(int i4) {
            C0124a c0124a = this.f8281f;
            return c0124a.f8275e * AbstractC0874a.a(i4, c0124a.f8276f, RoundingMode.CEILING);
        }

        @Override // b2.AbstractC0862a
        public AbstractC0862a k() {
            return this.f8282g == null ? this : n(this.f8281f, null);
        }

        @Override // b2.AbstractC0862a
        public CharSequence l(CharSequence charSequence) {
            m.n(charSequence);
            Character ch = this.f8282g;
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

        public void m(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
            m.n(appendable);
            m.s(i4, i4 + i5, bArr.length);
            int i6 = 0;
            m.d(i5 <= this.f8281f.f8276f);
            long j4 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                j4 = (j4 | ((long) (bArr[i4 + i7] & 255))) << 8;
            }
            int i8 = ((i5 + 1) * 8) - this.f8281f.f8274d;
            while (i6 < i5 * 8) {
                C0124a c0124a = this.f8281f;
                appendable.append(c0124a.d(((int) (j4 >>> (i8 - i6))) & c0124a.f8273c));
                i6 += this.f8281f.f8274d;
            }
            if (this.f8282g != null) {
                while (i6 < this.f8281f.f8276f * 8) {
                    appendable.append(this.f8282g.charValue());
                    i6 += this.f8281f.f8274d;
                }
            }
        }

        public AbstractC0862a n(C0124a c0124a, Character ch) {
            return new e(c0124a, ch);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f8281f);
            if (8 % this.f8281f.f8274d != 0) {
                if (this.f8282g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f8282g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        public e(C0124a c0124a, Character ch) {
            this.f8281f = (C0124a) m.n(c0124a);
            m.j(ch == null || !c0124a.f(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f8282g = ch;
        }
    }

    public static AbstractC0862a a() {
        return f8266a;
    }

    public static byte[] h(byte[] bArr, int i4) {
        if (i4 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        return bArr2;
    }

    public final byte[] b(CharSequence charSequence) {
        try {
            return c(charSequence);
        } catch (d e4) {
            throw new IllegalArgumentException(e4);
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

    public final String f(byte[] bArr, int i4, int i5) {
        m.s(i4, i4 + i5, bArr.length);
        StringBuilder sb = new StringBuilder(j(i5));
        try {
            g(sb, bArr, i4, i5);
            return sb.toString();
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    public abstract void g(Appendable appendable, byte[] bArr, int i4, int i5);

    public abstract int i(int i4);

    public abstract int j(int i4);

    public abstract AbstractC0862a k();

    public abstract CharSequence l(CharSequence charSequence);
}
