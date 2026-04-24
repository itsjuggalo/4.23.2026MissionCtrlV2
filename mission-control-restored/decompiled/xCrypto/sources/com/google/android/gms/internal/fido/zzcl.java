package com.google.android.gms.internal.fido;

/* JADX INFO: loaded from: classes.dex */
public final class zzcl {
    public static byte[] zza(byte[]... bArr) {
        int i4 = 0;
        int length = 0;
        while (true) {
            if (i4 >= bArr.length) {
                break;
            }
            length += bArr[i4].length;
            i4++;
        }
        byte[] bArr2 = new byte[length];
        int i5 = 0;
        for (byte[] bArr3 : bArr) {
            int length2 = bArr3.length;
            System.arraycopy(bArr3, 0, bArr2, i5, length2);
            i5 += length2;
        }
        return bArr2;
    }
}
