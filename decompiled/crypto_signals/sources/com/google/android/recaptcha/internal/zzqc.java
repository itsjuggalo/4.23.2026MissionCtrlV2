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

    public static int zza(int i, int i6) {
        if (i % 2 != 0) {
            return (i | i6) - (i & i6);
        }
        return ((~i) & i6) | ((~i6) & i);
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

    private static final int zzg(byte[] bArr, int i) {
        int i6 = bArr[i] & 255;
        int i7 = bArr[i + 1] & 255;
        int i8 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i7 << 8) | i6 | (i8 << 16);
    }

    public final void zzb(int i, int i6, int i7, int i8) {
        zzc(i, i6, i8, 16);
        zzc(i7, i8, i6, 12);
        zzc(i, i6, i8, 8);
        zzc(i7, i8, i6, 7);
    }

    public final void zzc(int i, int i6, int i7, int i8) {
        int[] iArr = this.zzb;
        int i9 = iArr[i] + iArr[i6];
        iArr[i] = i9;
        int iZza = zza(iArr[i7], i9);
        iArr[i7] = iZza;
        iArr[i7] = (iZza << i8) | (iZza >>> (32 - i8));
    }

    public final byte[] zzd(byte[] bArr) {
        if (this.zzg != 1) {
            throw new IllegalStateException();
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int i = 0;
        while (length > 0) {
            int[] iArr = this.zzc;
            int[] iArr2 = this.zzb;
            int length2 = iArr.length;
            System.arraycopy(iArr, 0, iArr2, 0, 16);
            this.zzb[12] = this.zzg;
            for (int i6 = 0; i6 < 10; i6++) {
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
            for (int i7 = 0; i7 < 16; i7++) {
                int i8 = this.zzb[i7];
                int i9 = i7 * 4;
                bArr3[i9] = (byte) (i8 & 255);
                bArr3[i9 + 1] = (byte) ((i8 >> 8) & 255);
                bArr3[i9 + 2] = (byte) ((i8 >> 16) & 255);
                bArr3[i9 + 3] = (byte) ((i8 >> 24) & 255);
            }
            for (int i10 = 0; i10 < Math.min(64, length); i10++) {
                int i11 = i + i10;
                bArr2[i11] = (byte) zza(bArr3[i10], bArr[i11]);
            }
            this.zzg++;
            length -= 64;
            i += 64;
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
        for (int i = 0; i < 4; i++) {
            this.zzb[i] = zza(this.zzd[i], 2131181306);
        }
        for (int i6 = 4; i6 < 12; i6++) {
            this.zzb[i6] = zzg(this.zze, (i6 - 4) * 4);
        }
        this.zzb[12] = this.zzg;
        for (int i7 = 13; i7 < 16; i7++) {
            this.zzb[i7] = zzg(this.zzf, (i7 - 13) * 4);
        }
        int[] iArr = new int[16];
        this.zzc = iArr;
        int[] iArr2 = this.zzb;
        int length = iArr2.length;
        System.arraycopy(iArr2, 0, iArr, 0, 16);
    }
}
