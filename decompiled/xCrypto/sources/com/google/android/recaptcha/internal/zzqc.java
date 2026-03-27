package com.google.android.recaptcha.internal;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public final class zzqc {
    protected static final Charset zza = StandardCharsets.UTF_16;
    protected int[] zzb;
    protected int[] zzc;
    private final int[] zzd = {511133343, 1277647508, 107287496, 338123662};
    private byte[] zze;
    private byte[] zzf;
    private int zzg;

    public zzqc() {
    }

    public static int zza(int i4, int i5) {
        if (i4 % 2 != 0) {
            return (i4 | i5) - (i4 & i5);
        }
        return ((~i4) & i5) | ((~i5) & i4);
    }

    public static String zze(String str, byte[] bArr, zzqd zzqdVar) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr2 = new byte[12];
        int length = bArrDecode.length - 12;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArrDecode, 0, bArr2, 0, 12);
        System.arraycopy(bArrDecode, 12, bArr3, 0, length);
        return new String(new zzqc(bArr, bArr2).zzd(bArr3), zza);
    }

    public static String zzf(String str, byte[] bArr, zzqd zzqdVar) {
        byte[] bArr2 = new byte[12];
        new SecureRandom().nextBytes(bArr2);
        byte[] bArrZzd = new zzqc(bArr, bArr2).zzd(str.getBytes(zza));
        int length = bArrZzd.length;
        byte[] bArr3 = new byte[length + 12];
        System.arraycopy(bArr2, 0, bArr3, 0, 12);
        System.arraycopy(bArrZzd, 0, bArr3, 12, length);
        return Base64.encodeToString(bArr3, 2);
    }

    private static final int zzg(byte[] bArr, int i4) {
        int i5 = bArr[i4] & 255;
        int i6 = bArr[i4 + 1] & 255;
        int i7 = bArr[i4 + 2] & 255;
        return ((bArr[i4 + 3] & 255) << 24) | (i6 << 8) | i5 | (i7 << 16);
    }

    public final void zzb(int i4, int i5, int i6, int i7) {
        zzc(i4, i5, i7, 16);
        zzc(i6, i7, i5, 12);
        zzc(i4, i5, i7, 8);
        zzc(i6, i7, i5, 7);
    }

    public final void zzc(int i4, int i5, int i6, int i7) {
        int[] iArr = this.zzb;
        int i8 = iArr[i4] + iArr[i5];
        iArr[i4] = i8;
        int iZza = zza(iArr[i6], i8);
        iArr[i6] = iZza;
        iArr[i6] = (iZza << i7) | (iZza >>> (32 - i7));
    }

    public final byte[] zzd(byte[] bArr) {
        if (this.zzg != 1) {
            throw new IllegalStateException();
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int i4 = 0;
        while (length > 0) {
            int[] iArr = this.zzc;
            int[] iArr2 = this.zzb;
            int length2 = iArr.length;
            System.arraycopy(iArr, 0, iArr2, 0, 16);
            this.zzb[12] = this.zzg;
            for (int i5 = 0; i5 < 10; i5++) {
                zzb(0, 4, 8, 12);
                zzb(1, 5, 9, 13);
                zzb(2, 6, 10, 14);
                zzb(3, 7, 11, 15);
                zzb(0, 5, 10, 15);
                zzb(1, 6, 11, 12);
                zzb(2, 7, 8, 13);
                zzb(3, 4, 9, 14);
            }
            byte[] bArr3 = new byte[64];
            for (int i6 = 0; i6 < 16; i6++) {
                int i7 = this.zzb[i6];
                int i8 = i6 * 4;
                bArr3[i8] = (byte) (i7 & 255);
                bArr3[i8 + 1] = (byte) ((i7 >> 8) & 255);
                bArr3[i8 + 2] = (byte) ((i7 >> 16) & 255);
                bArr3[i8 + 3] = (byte) ((i7 >> 24) & 255);
            }
            for (int i9 = 0; i9 < Math.min(64, length); i9++) {
                int i10 = i4 + i9;
                bArr2[i10] = (byte) zza(bArr3[i9], bArr[i10]);
            }
            this.zzg++;
            length -= 64;
            i4 += 64;
        }
        return bArr2;
    }

    public zzqc(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException();
        }
        this.zze = bArr;
        this.zzg = 1;
        this.zzf = bArr2;
        this.zzb = new int[16];
        for (int i4 = 0; i4 < 4; i4++) {
            this.zzb[i4] = zza(this.zzd[i4], 2131181306);
        }
        for (int i5 = 4; i5 < 12; i5++) {
            this.zzb[i5] = zzg(this.zze, (i5 - 4) * 4);
        }
        this.zzb[12] = this.zzg;
        for (int i6 = 13; i6 < 16; i6++) {
            this.zzb[i6] = zzg(this.zzf, (i6 - 13) * 4);
        }
        int[] iArr = new int[16];
        this.zzc = iArr;
        int[] iArr2 = this.zzb;
        int length = iArr2.length;
        System.arraycopy(iArr2, 0, iArr, 0, 16);
    }
}
