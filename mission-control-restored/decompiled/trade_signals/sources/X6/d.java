package X6;

import V6.AbstractC0979e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends c {
    public static final void c(String str, int i8) {
        if (str.charAt(i8) == '-') {
            return;
        }
        throw new IllegalArgumentException(("Expected '-' (hyphen) at index " + i8 + ", but was '" + str.charAt(i8) + '\'').toString());
    }

    public static final void d(long j8, byte[] bArr, int i8, int i9) {
        int i10 = i8 + (i9 * 2);
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = AbstractC0979e.d()[(int) (255 & j8)];
            bArr[i10 - 1] = (byte) i12;
            i10 -= 2;
            bArr[i10] = (byte) (i12 >> 8);
            j8 >>= 8;
        }
    }
}
