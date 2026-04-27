package com.google.android.gms.internal.fido;

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
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i7 = 0; i7 < cArr.length; i7++) {
            char c7 = cArr[i7];
            boolean z7 = true;
            zzap.zzd(c7 < 128, "Non-ASCII character: %s", c7);
            if (bArr[c7] != -1) {
                z7 = false;
            }
            zzap.zzd(z7, "Duplicate character: %s", c7);
            bArr[c7] = (byte) i7;
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

    public final char zza(int i7) {
        return this.zzf[i7];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    public final zzcd zzb() {
        int i7;
        boolean z7;
        int i8 = 0;
        for (char c7 : this.zzf) {
            if (zzad.zza(c7)) {
                char[] cArr = this.zzf;
                int length = cArr.length;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        z7 = false;
                        break;
                    }
                    char c8 = cArr[i9];
                    if (c8 >= 'A' && c8 <= 'Z') {
                        z7 = true;
                        break;
                    }
                    i9++;
                }
                if (z7) {
                    throw new IllegalStateException("Cannot call upperCase() on a mixed-case alphabet");
                }
                char[] cArr2 = new char[this.zzf.length];
                while (true) {
                    char[] cArr3 = this.zzf;
                    if (i8 >= cArr3.length) {
                        break;
                    }
                    char c9 = cArr3[i8];
                    if (zzad.zza(c9)) {
                        c9 ^= 32;
                    }
                    cArr2[i8] = (char) c9;
                    i8++;
                }
                zzcd zzcdVar = new zzcd(this.zze.concat(".upperCase()"), cArr2);
                if (!this.zzh || zzcdVar.zzh) {
                    return zzcdVar;
                }
                byte[] bArr = zzcdVar.zzg;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                for (i7 = 65; i7 <= 90; i7++) {
                    int i10 = i7 | 32;
                    byte[] bArr2 = zzcdVar.zzg;
                    byte b7 = bArr2[i7];
                    byte b8 = bArr2[i10];
                    if (b7 == -1) {
                        bArrCopyOf[i7] = b8;
                    } else {
                        char c10 = (char) i7;
                        char c11 = (char) i10;
                        if (b8 != -1) {
                            throw new IllegalStateException(zzaq.zza("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c10), Character.valueOf(c11)));
                        }
                        bArrCopyOf[i10] = b7;
                    }
                }
                return new zzcd(zzcdVar.zze.concat(".ignoreCase()"), zzcdVar.zzf, bArrCopyOf, true);
            }
        }
        return this;
    }

    public final boolean zzc(char c7) {
        byte[] bArr = this.zzg;
        return bArr.length > 61 && bArr[61] != -1;
    }

    private zzcd(String str, char[] cArr, byte[] bArr, boolean z7) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int iZzb = zzcj.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = iZzb;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iZzb);
            int i7 = 1 << (3 - iNumberOfTrailingZeros);
            this.zzc = i7;
            this.zzd = iZzb >> iNumberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i7];
            for (int i8 = 0; i8 < this.zzd; i8++) {
                zArr[zzcj.zza(i8 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = z7;
        } catch (ArithmeticException e7) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e7);
        }
    }
}
