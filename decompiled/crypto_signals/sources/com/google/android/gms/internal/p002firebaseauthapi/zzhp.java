package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzhp {
    private static final int[] zza = zza(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    private static int zza(int i, int i6) {
        return (i >>> (-i6)) | (i << i6);
    }

    public static int[] zzb(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        zza(iArr3, iArr);
        iArr3[12] = iArr2[0];
        iArr3[13] = iArr2[1];
        iArr3[14] = iArr2[2];
        iArr3[15] = iArr2[3];
        zza(iArr3);
        iArr3[4] = iArr3[12];
        iArr3[5] = iArr3[13];
        iArr3[6] = iArr3[14];
        iArr3[7] = iArr3[15];
        return Arrays.copyOf(iArr3, 8);
    }

    private static void zza(int[] iArr, int i, int i6, int i7, int i8) {
        int i9 = iArr[i] + iArr[i6];
        iArr[i] = i9;
        int iZza = zza(i9 ^ iArr[i8], 16);
        iArr[i8] = iZza;
        int i10 = iArr[i7] + iZza;
        iArr[i7] = i10;
        int iZza2 = zza(iArr[i6] ^ i10, 12);
        iArr[i6] = iZza2;
        int i11 = iArr[i] + iZza2;
        iArr[i] = i11;
        int iZza3 = zza(iArr[i8] ^ i11, 8);
        iArr[i8] = iZza3;
        int i12 = iArr[i7] + iZza3;
        iArr[i7] = i12;
        iArr[i6] = zza(iArr[i6] ^ i12, 7);
    }

    public static void zza(int[] iArr, int[] iArr2) {
        int[] iArr3 = zza;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    public static void zza(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            zza(iArr, 0, 4, 8, 12);
            zza(iArr, 1, 5, 9, 13);
            zza(iArr, 2, 6, 10, 14);
            zza(iArr, 3, 7, 11, 15);
            zza(iArr, 0, 5, 10, 15);
            zza(iArr, 1, 6, 11, 12);
            zza(iArr, 2, 7, 8, 13);
            zza(iArr, 3, 4, 9, 14);
        }
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        int[] iArrZzb = zzb(zza(bArr), zza(bArr2));
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(iArrZzb.length << 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZzb);
        return byteBufferOrder.array();
    }

    public static int[] zza(byte[] bArr) {
        if (bArr.length % 4 == 0) {
            IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
            int[] iArr = new int[intBufferAsIntBuffer.remaining()];
            intBufferAsIntBuffer.get(iArr);
            return iArr;
        }
        throw new IllegalArgumentException("invalid input length");
    }
}
