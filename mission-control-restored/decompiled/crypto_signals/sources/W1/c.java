package W1;

import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e {
    public c(String str, String str2) {
        this(new a(str, str2.toCharArray()), (Character) '=');
    }

    @Override // W1.e
    public final int b(byte[] bArr, CharSequence charSequence) throws d {
        CharSequence charSequenceF = f(charSequence);
        int length = charSequenceF.length();
        a aVar = this.f3349a;
        if (!aVar.f3346h[length % aVar.e]) {
            throw new d("Invalid input length " + charSequenceF.length());
        }
        int i = 0;
        int i6 = 0;
        while (i < charSequenceF.length()) {
            int i7 = i + 2;
            int iA = (aVar.a(charSequenceF.charAt(i + 1)) << 12) | (aVar.a(charSequenceF.charAt(i)) << 18);
            int i8 = i6 + 1;
            bArr[i6] = (byte) (iA >>> 16);
            if (i7 < charSequenceF.length()) {
                int i9 = i + 3;
                int iA2 = iA | (aVar.a(charSequenceF.charAt(i7)) << 6);
                int i10 = i6 + 2;
                bArr[i8] = (byte) ((iA2 >>> 8) & 255);
                if (i9 < charSequenceF.length()) {
                    i += 4;
                    i6 += 3;
                    bArr[i10] = (byte) ((iA2 | aVar.a(charSequenceF.charAt(i9))) & 255);
                } else {
                    i6 = i10;
                    i = i9;
                }
            } else {
                i6 = i8;
                i = i7;
            }
        }
        return i6;
    }

    @Override // W1.e
    public final void e(StringBuilder sb, byte[] bArr, int i) {
        int i6 = 0;
        D.m(0, i, bArr.length);
        for (int i7 = i; i7 >= 3; i7 -= 3) {
            int i8 = i6 + 2;
            int i9 = ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6] & 255) << 16);
            i6 += 3;
            int i10 = i9 | (bArr[i8] & 255);
            a aVar = this.f3349a;
            sb.append(aVar.f3341b[i10 >>> 18]);
            char[] cArr = aVar.f3341b;
            sb.append(cArr[(i10 >>> 12) & 63]);
            sb.append(cArr[(i10 >>> 6) & 63]);
            sb.append(cArr[i10 & 63]);
        }
        if (i6 < i) {
            d(sb, bArr, i6, i - i6);
        }
    }

    public c(a aVar, Character ch) {
        super(aVar, ch);
        D.h(aVar.f3341b.length == 64);
    }
}
