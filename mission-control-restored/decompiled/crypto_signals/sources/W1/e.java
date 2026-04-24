package W1;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import s3.D;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f3348c = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Character f3350b;

    static {
        new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
        new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");
        new b(new a("base16()", "0123456789ABCDEF".toCharArray()));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(W1.a r3, java.lang.Character r4) {
        /*
            r2 = this;
            r2.<init>()
            r3.getClass()
            r2.f3349a = r3
            if (r4 == 0) goto L1a
            char r0 = r4.charValue()
            byte[] r3 = r3.f3345g
            int r1 = r3.length
            if (r0 >= r1) goto L1a
            r3 = r3[r0]
            r0 = -1
            if (r3 == r0) goto L1a
            r3 = 0
            goto L1b
        L1a:
            r3 = 1
        L1b:
            java.lang.String r0 = "Padding character %s was already in alphabet"
            s3.D.e(r4, r0, r3)
            r2.f3350b = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.e.<init>(W1.a, java.lang.Character):void");
    }

    public final byte[] a(String str) {
        try {
            CharSequence charSequenceF = f(str);
            int length = (int) (((((long) this.f3349a.f3343d) * ((long) charSequenceF.length())) + 7) / 8);
            byte[] bArr = new byte[length];
            int iB = b(bArr, charSequenceF);
            if (iB == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[iB];
            System.arraycopy(bArr, 0, bArr2, 0, iB);
            return bArr2;
        } catch (d e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int b(byte[] bArr, CharSequence charSequence) throws d {
        int i;
        int i6;
        CharSequence charSequenceF = f(charSequence);
        int length = charSequenceF.length();
        a aVar = this.f3349a;
        if (!aVar.f3346h[length % aVar.e]) {
            throw new d("Invalid input length " + charSequenceF.length());
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequenceF.length()) {
            long jA = 0;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                i = aVar.f3343d;
                i6 = aVar.e;
                if (i9 >= i6) {
                    break;
                }
                jA <<= i;
                if (i7 + i9 < charSequenceF.length()) {
                    jA |= (long) aVar.a(charSequenceF.charAt(i10 + i7));
                    i10++;
                }
                i9++;
            }
            int i11 = aVar.f3344f;
            int i12 = (i11 * 8) - (i10 * i);
            int i13 = (i11 - 1) * 8;
            while (i13 >= i12) {
                bArr[i8] = (byte) ((jA >>> i13) & 255);
                i13 -= 8;
                i8++;
            }
            i7 += i6;
        }
        return i8;
    }

    public final String c(byte[] bArr) {
        int length = bArr.length;
        D.m(0, length, bArr.length);
        a aVar = this.f3349a;
        int i = aVar.e;
        RoundingMode roundingMode = RoundingMode.CEILING;
        StringBuilder sb = new StringBuilder(u0.k(length, aVar.f3344f) * i);
        try {
            e(sb, bArr, length);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final void d(StringBuilder sb, byte[] bArr, int i, int i6) {
        D.m(i, i + i6, bArr.length);
        a aVar = this.f3349a;
        int i7 = 0;
        D.h(i6 <= aVar.f3344f);
        long j4 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            j4 = (j4 | ((long) (bArr[i + i8] & 255))) << 8;
        }
        int i9 = aVar.f3343d;
        int i10 = ((i6 + 1) * 8) - i9;
        while (i7 < i6 * 8) {
            sb.append(aVar.f3341b[((int) (j4 >>> (i10 - i7))) & aVar.f3342c]);
            i7 += i9;
        }
        Character ch = this.f3350b;
        if (ch != null) {
            while (i7 < aVar.f3344f * 8) {
                sb.append(ch.charValue());
                i7 += i9;
            }
        }
    }

    public void e(StringBuilder sb, byte[] bArr, int i) {
        int i6 = 0;
        D.m(0, i, bArr.length);
        while (i6 < i) {
            a aVar = this.f3349a;
            d(sb, bArr, i6, Math.min(aVar.f3344f, i - i6));
            i6 += aVar.f3344f;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f3349a.equals(eVar.f3349a) && Objects.equals(this.f3350b, eVar.f3350b)) {
                return true;
            }
        }
        return false;
    }

    public final CharSequence f(CharSequence charSequence) {
        Character ch = this.f3350b;
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

    public final int hashCode() {
        return this.f3349a.hashCode() ^ Objects.hashCode(this.f3350b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        a aVar = this.f3349a;
        sb.append(aVar);
        if (8 % aVar.f3343d != 0) {
            Character ch = this.f3350b;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    public e(String str, String str2) {
        this(new a(str, str2.toCharArray()), (Character) '=');
    }
}
