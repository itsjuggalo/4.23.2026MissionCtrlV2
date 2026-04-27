package com.google.android.gms.internal.fido;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzcd {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzcd(String str, char[] cArr) {
        byte[] bArr = new byte[UserMetadata.MAX_ROLLOUT_ASSIGNMENTS];
        Arrays.fill(bArr, (byte) -1);
        for (int i4 = 0; i4 < cArr.length; i4++) {
            char c4 = cArr[i4];
            boolean z4 = true;
            zzap.zzd(c4 < 128, "Non-ASCII character: %s", c4);
            if (bArr[c4] != -1) {
                z4 = false;
            }
            zzap.zzd(z4, "Duplicate character: %s", c4);
            bArr[c4] = (byte) i4;
        }
        this(str, cArr, bArr, false);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzcd) {
            zzcd zzcdVar = (zzcd) obj;
            if (this.zzh == zzcdVar.zzh && Arrays.equals(this.zzf, zzcdVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + (true != this.zzh ? 1237 : 1231);
    }

    public final String toString() {
        return this.zze;
    }

    public final char zza(int i4) {
        return this.zzf[i4];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    public final zzcd zzb() {
        int i4;
        boolean z4;
        int i5 = 0;
        for (char c4 : this.zzf) {
            if (zzad.zza(c4)) {
                char[] cArr = this.zzf;
                int length = cArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        z4 = false;
                        break;
                    }
                    char c5 = cArr[i6];
                    if (c5 >= 'A' && c5 <= 'Z') {
                        z4 = true;
                        break;
                    }
                    i6++;
                }
                if (z4) {
                    throw new IllegalStateException("Cannot call upperCase() on a mixed-case alphabet");
                }
                char[] cArr2 = new char[this.zzf.length];
                while (true) {
                    char[] cArr3 = this.zzf;
                    if (i5 >= cArr3.length) {
                        break;
                    }
                    char c6 = cArr3[i5];
                    if (zzad.zza(c6)) {
                        c6 ^= 32;
                    }
                    cArr2[i5] = (char) c6;
                    i5++;
                }
                zzcd zzcdVar = new zzcd(this.zze.concat(".upperCase()"), cArr2);
                if (!this.zzh || zzcdVar.zzh) {
                    return zzcdVar;
                }
                byte[] bArr = zzcdVar.zzg;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                for (i4 = 65; i4 <= 90; i4++) {
                    int i7 = i4 | 32;
                    byte[] bArr2 = zzcdVar.zzg;
                    byte b4 = bArr2[i4];
                    byte b5 = bArr2[i7];
                    if (b4 == -1) {
                        bArrCopyOf[i4] = b5;
                    } else {
                        char c7 = (char) i4;
                        char c8 = (char) i7;
                        if (b5 != -1) {
                            throw new IllegalStateException(zzaq.zza("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c7), Character.valueOf(c8)));
                        }
                        bArrCopyOf[i7] = b4;
                    }
                }
                return new zzcd(zzcdVar.zze.concat(".ignoreCase()"), zzcdVar.zzf, bArrCopyOf, true);
            }
        }
        return this;
    }

    public final boolean zzc(char c4) {
        byte[] bArr = this.zzg;
        return bArr.length > 61 && bArr[61] != -1;
    }

    private zzcd(String str, char[] cArr, byte[] bArr, boolean z4) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int iZzb = zzcj.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = iZzb;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iZzb);
            int i4 = 1 << (3 - iNumberOfTrailingZeros);
            this.zzc = i4;
            this.zzd = iZzb >> iNumberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i4];
            for (int i5 = 0; i5 < this.zzd; i5++) {
                zArr[zzcj.zza(i5 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = z4;
        } catch (ArithmeticException e4) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e4);
        }
    }
}
