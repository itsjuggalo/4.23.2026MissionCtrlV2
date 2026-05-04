package r6;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import p6.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19345a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f19346b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19347c = new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f19348d = new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f19349e = new b("base16()", "0123456789ABCDEF");

    /* JADX INFO: renamed from: r6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0337a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char[] f19351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f19354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f19355f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f19356g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean[] f19357h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f19358i;

        public C0337a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        public static byte[] b(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i10 = 0; i10 < cArr.length; i10++) {
                char c10 = cArr[i10];
                boolean z10 = true;
                n.f(c10 < 128, "Non-ASCII character: %s", c10);
                if (bArr[c10] != -1) {
                    z10 = false;
                }
                n.f(z10, "Duplicate character: %s", c10);
                bArr[c10] = (byte) i10;
            }
            return bArr;
        }

        public int c(char c10) throws d {
            if (c10 > 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c10));
            }
            byte b10 = this.f19356g[c10];
            if (b10 != -1) {
                return b10;
            }
            if (c10 <= ' ' || c10 == 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c10));
            }
            throw new d("Unrecognized character: " + c10);
        }

        public char d(int i10) {
            return this.f19351b[i10];
        }

        public final boolean e() {
            for (char c10 : this.f19351b) {
                if (p6.b.a(c10)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0337a) {
                C0337a c0337a = (C0337a) obj;
                if (this.f19358i == c0337a.f19358i && Arrays.equals(this.f19351b, c0337a.f19351b)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean f() {
            for (char c10 : this.f19351b) {
                if (p6.b.b(c10)) {
                    return true;
                }
            }
            return false;
        }

        public C0337a g() {
            if (this.f19358i) {
                return this;
            }
            byte[] bArr = this.f19356g;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            int i10 = 65;
            while (true) {
                if (i10 > 90) {
                    return new C0337a(this.f19350a + ".ignoreCase()", this.f19351b, bArrCopyOf, true);
                }
                int i11 = i10 | 32;
                byte[] bArr2 = this.f19356g;
                byte b10 = bArr2[i10];
                byte b11 = bArr2[i11];
                if (b10 == -1) {
                    bArrCopyOf[i10] = b11;
                } else {
                    n.v(b11 == -1, "Can't ignoreCase() since '%s' and '%s' encode different values", (char) i10, (char) i11);
                    bArrCopyOf[i11] = b10;
                }
                i10++;
            }
        }

        public boolean h(int i10) {
            return this.f19357h[i10 % this.f19354e];
        }

        public int hashCode() {
            return Arrays.hashCode(this.f19351b) + (this.f19358i ? 1231 : 1237);
        }

        public boolean i(char c10) {
            byte[] bArr = this.f19356g;
            return c10 < bArr.length && bArr[c10] != -1;
        }

        public C0337a j() {
            if (!e()) {
                return this;
            }
            n.u(!f(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f19351b.length];
            int i10 = 0;
            while (true) {
                char[] cArr2 = this.f19351b;
                if (i10 >= cArr2.length) {
                    break;
                }
                cArr[i10] = p6.b.c(cArr2[i10]);
                i10++;
            }
            C0337a c0337a = new C0337a(this.f19350a + ".upperCase()", cArr);
            return this.f19358i ? c0337a.g() : c0337a;
        }

        public String toString() {
            return this.f19350a;
        }

        public C0337a(String str, char[] cArr, byte[] bArr, boolean z10) {
            this.f19350a = (String) n.n(str);
            this.f19351b = (char[]) n.n(cArr);
            try {
                int iD = s6.a.d(cArr.length, RoundingMode.UNNECESSARY);
                this.f19353d = iD;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iD);
                int i10 = 1 << (3 - iNumberOfTrailingZeros);
                this.f19354e = i10;
                this.f19355f = iD >> iNumberOfTrailingZeros;
                this.f19352c = cArr.length - 1;
                this.f19356g = bArr;
                boolean[] zArr = new boolean[i10];
                for (int i11 = 0; i11 < this.f19355f; i11++) {
                    zArr[s6.a.a(i11 * 8, this.f19353d, RoundingMode.CEILING)] = true;
                }
                this.f19357h = zArr;
                this.f19358i = z10;
            } catch (ArithmeticException e10) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final char[] f19359i;

        public b(String str, String str2) {
            this(new C0337a(str, str2.toCharArray()));
        }

        @Override // r6.a.e, r6.a
        public int e(byte[] bArr, CharSequence charSequence) throws d {
            n.n(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new d("Invalid input length " + charSequence.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequence.length()) {
                bArr[i11] = (byte) ((this.f19360f.c(charSequence.charAt(i10)) << 4) | this.f19360f.c(charSequence.charAt(i10 + 1)));
                i10 += 2;
                i11++;
            }
            return i11;
        }

        @Override // r6.a.e, r6.a
        public void h(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            n.n(appendable);
            n.s(i10, i10 + i11, bArr.length);
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = bArr[i10 + i12] & 255;
                appendable.append(this.f19359i[i13]);
                appendable.append(this.f19359i[i13 | 256]);
            }
        }

        @Override // r6.a.e
        public a p(C0337a c0337a, Character ch2) {
            return new b(c0337a);
        }

        public b(C0337a c0337a) {
            super(c0337a, null);
            this.f19359i = new char[512];
            n.d(c0337a.f19351b.length == 16);
            for (int i10 = 0; i10 < 256; i10++) {
                this.f19359i[i10] = c0337a.d(i10 >>> 4);
                this.f19359i[i10 | 256] = c0337a.d(i10 & 15);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends e {
        public c(String str, String str2, Character ch2) {
            this(new C0337a(str, str2.toCharArray()), ch2);
        }

        @Override // r6.a.e, r6.a
        public int e(byte[] bArr, CharSequence charSequence) throws d {
            n.n(bArr);
            CharSequence charSequenceM = m(charSequence);
            if (!this.f19360f.h(charSequenceM.length())) {
                throw new d("Invalid input length " + charSequenceM.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequenceM.length()) {
                int i12 = i10 + 2;
                int iC = (this.f19360f.c(charSequenceM.charAt(i10)) << 18) | (this.f19360f.c(charSequenceM.charAt(i10 + 1)) << 12);
                int i13 = i11 + 1;
                bArr[i11] = (byte) (iC >>> 16);
                if (i12 < charSequenceM.length()) {
                    int i14 = i10 + 3;
                    int iC2 = iC | (this.f19360f.c(charSequenceM.charAt(i12)) << 6);
                    int i15 = i11 + 2;
                    bArr[i13] = (byte) ((iC2 >>> 8) & 255);
                    if (i14 < charSequenceM.length()) {
                        i10 += 4;
                        i11 += 3;
                        bArr[i15] = (byte) ((iC2 | this.f19360f.c(charSequenceM.charAt(i14))) & 255);
                    } else {
                        i11 = i15;
                        i10 = i14;
                    }
                } else {
                    i11 = i13;
                    i10 = i12;
                }
            }
            return i11;
        }

        @Override // r6.a.e, r6.a
        public void h(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            n.n(appendable);
            int i12 = i10 + i11;
            n.s(i10, i12, bArr.length);
            while (i11 >= 3) {
                int i13 = i10 + 2;
                int i14 = ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10] & 255) << 16);
                i10 += 3;
                int i15 = i14 | (bArr[i13] & 255);
                appendable.append(this.f19360f.d(i15 >>> 18));
                appendable.append(this.f19360f.d((i15 >>> 12) & 63));
                appendable.append(this.f19360f.d((i15 >>> 6) & 63));
                appendable.append(this.f19360f.d(i15 & 63));
                i11 -= 3;
            }
            if (i10 < i12) {
                o(appendable, bArr, i10, i12 - i10);
            }
        }

        @Override // r6.a.e
        public a p(C0337a c0337a, Character ch2) {
            return new c(c0337a, ch2);
        }

        public c(C0337a c0337a, Character ch2) {
            super(c0337a, ch2);
            n.d(c0337a.f19351b.length == 64);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends IOException {
        public d(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C0337a f19360f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Character f19361g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile a f19362h;

        public e(String str, String str2, Character ch2) {
            this(new C0337a(str, str2.toCharArray()), ch2);
        }

        @Override // r6.a
        public int e(byte[] bArr, CharSequence charSequence) throws d {
            C0337a c0337a;
            n.n(bArr);
            CharSequence charSequenceM = m(charSequence);
            if (!this.f19360f.h(charSequenceM.length())) {
                throw new d("Invalid input length " + charSequenceM.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequenceM.length()) {
                long jC = 0;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    c0337a = this.f19360f;
                    if (i12 >= c0337a.f19354e) {
                        break;
                    }
                    jC <<= c0337a.f19353d;
                    if (i10 + i12 < charSequenceM.length()) {
                        jC |= (long) this.f19360f.c(charSequenceM.charAt(i13 + i10));
                        i13++;
                    }
                    i12++;
                }
                int i14 = c0337a.f19355f;
                int i15 = (i14 * 8) - (i13 * c0337a.f19353d);
                int i16 = (i14 - 1) * 8;
                while (i16 >= i15) {
                    bArr[i11] = (byte) ((jC >>> i16) & 255);
                    i16 -= 8;
                    i11++;
                }
                i10 += this.f19360f.f19354e;
            }
            return i11;
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.f19360f.equals(eVar.f19360f) && Objects.equals(this.f19361g, eVar.f19361g)) {
                    return true;
                }
            }
            return false;
        }

        @Override // r6.a
        public void h(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            n.n(appendable);
            n.s(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (i12 < i11) {
                o(appendable, bArr, i10 + i12, Math.min(this.f19360f.f19355f, i11 - i12));
                i12 += this.f19360f.f19355f;
            }
        }

        public int hashCode() {
            return this.f19360f.hashCode() ^ Objects.hashCode(this.f19361g);
        }

        @Override // r6.a
        public int j(int i10) {
            return (int) (((((long) this.f19360f.f19353d) * ((long) i10)) + 7) / 8);
        }

        @Override // r6.a
        public int k(int i10) {
            C0337a c0337a = this.f19360f;
            return c0337a.f19354e * s6.a.a(i10, c0337a.f19355f, RoundingMode.CEILING);
        }

        @Override // r6.a
        public a l() {
            return this.f19361g == null ? this : p(this.f19360f, null);
        }

        @Override // r6.a
        public CharSequence m(CharSequence charSequence) {
            n.n(charSequence);
            Character ch2 = this.f19361g;
            if (ch2 == null) {
                return charSequence;
            }
            char cCharValue = ch2.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // r6.a
        public a n() {
            a aVarP = this.f19362h;
            if (aVarP == null) {
                C0337a c0337aJ = this.f19360f.j();
                aVarP = c0337aJ == this.f19360f ? this : p(c0337aJ, this.f19361g);
                this.f19362h = aVarP;
            }
            return aVarP;
        }

        public void o(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            n.n(appendable);
            n.s(i10, i10 + i11, bArr.length);
            int i12 = 0;
            n.d(i11 <= this.f19360f.f19355f);
            long j10 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                j10 = (j10 | ((long) (bArr[i10 + i13] & 255))) << 8;
            }
            int i14 = ((i11 + 1) * 8) - this.f19360f.f19353d;
            while (i12 < i11 * 8) {
                C0337a c0337a = this.f19360f;
                appendable.append(c0337a.d(((int) (j10 >>> (i14 - i12))) & c0337a.f19352c));
                i12 += this.f19360f.f19353d;
            }
            if (this.f19361g != null) {
                while (i12 < this.f19360f.f19355f * 8) {
                    appendable.append(this.f19361g.charValue());
                    i12 += this.f19360f.f19353d;
                }
            }
        }

        public a p(C0337a c0337a, Character ch2) {
            return new e(c0337a, ch2);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("BaseEncoding.");
            sb2.append(this.f19360f);
            if (8 % this.f19360f.f19353d != 0) {
                if (this.f19361g == null) {
                    sb2.append(".omitPadding()");
                } else {
                    sb2.append(".withPadChar('");
                    sb2.append(this.f19361g);
                    sb2.append("')");
                }
            }
            return sb2.toString();
        }

        public e(C0337a c0337a, Character ch2) {
            this.f19360f = (C0337a) n.n(c0337a);
            n.j(ch2 == null || !c0337a.i(ch2.charValue()), "Padding character %s was already in alphabet", ch2);
            this.f19361g = ch2;
        }
    }

    public static a a() {
        return f19349e;
    }

    public static a b() {
        return f19345a;
    }

    public static byte[] i(byte[] bArr, int i10) {
        if (i10 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        return bArr2;
    }

    public final byte[] c(CharSequence charSequence) {
        try {
            return d(charSequence);
        } catch (d e10) {
            throw new IllegalArgumentException(e10);
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

    public final String g(byte[] bArr, int i10, int i11) {
        n.s(i10, i10 + i11, bArr.length);
        StringBuilder sb2 = new StringBuilder(k(i11));
        try {
            h(sb2, bArr, i10, i11);
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public abstract void h(Appendable appendable, byte[] bArr, int i10, int i11);

    public abstract int j(int i10);

    public abstract int k(int i10);

    public abstract a l();

    public abstract CharSequence m(CharSequence charSequence);

    public abstract a n();
}
