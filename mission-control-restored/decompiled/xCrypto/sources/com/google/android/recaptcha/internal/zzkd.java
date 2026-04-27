package com.google.android.recaptcha.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzkd {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean[] zzh;
    private final boolean zzi;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzkd(String str, char[] cArr) {
        byte[] bArr = new byte[UserMetadata.MAX_ROLLOUT_ASSIGNMENTS];
        Arrays.fill(bArr, (byte) -1);
        for (int i4 = 0; i4 < cArr.length; i4++) {
            char c4 = cArr[i4];
            boolean z4 = true;
            zzjf.zzc(c4 < 128, "Non-ASCII character: %s", c4);
            if (bArr[c4] != -1) {
                z4 = false;
            }
            zzjf.zzc(z4, "Duplicate character: %s", c4);
            bArr[c4] = (byte) i4;
        }
        this(str, cArr, bArr, false);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzkd) {
            zzkd zzkdVar = (zzkd) obj;
            boolean z4 = zzkdVar.zzi;
            if (Arrays.equals(this.zzf, zzkdVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + 1237;
    }

    public final String toString() {
        return this.zze;
    }

    public final char zza(int i4) {
        return this.zzf[i4];
    }

    public final int zzb(char c4) throws zzkf {
        if (c4 > 127) {
            throw new zzkf("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c4))));
        }
        byte b4 = this.zzg[c4];
        if (b4 != -1) {
            return b4;
        }
        if (c4 <= ' ' || c4 == 127) {
            throw new zzkf("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c4))));
        }
        throw new zzkf("Unrecognized character: " + c4);
    }

    public final boolean zzc(int i4) {
        return this.zzh[i4 % this.zzc];
    }

    public final boolean zzd(char c4) {
        return this.zzg[61] != -1;
    }

    private zzkd(String str, char[] cArr, byte[] bArr, boolean z4) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int iZzb = zzkj.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = iZzb;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iZzb);
            int i4 = 1 << (3 - iNumberOfTrailingZeros);
            this.zzc = i4;
            this.zzd = iZzb >> iNumberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i4];
            for (int i5 = 0; i5 < this.zzd; i5++) {
                zArr[zzkj.zza(i5 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = zArr;
            this.zzi = false;
        } catch (ArithmeticException e4) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e4);
        }
    }
}
