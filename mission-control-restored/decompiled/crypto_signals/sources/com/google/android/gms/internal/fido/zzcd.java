package com.google.android.gms.internal.fido;

import a3.d;
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
        for (int i = 0; i < cArr.length; i++) {
            char c6 = cArr[i];
            boolean z6 = true;
            zzap.zzd(c6 < 128, "Non-ASCII character: %s", c6);
            if (bArr[c6] != -1) {
                z6 = false;
            }
            zzap.zzd(z6, "Duplicate character: %s", c6);
            bArr[c6] = (byte) i;
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

    public final char zza(int i) {
        return this.zzf[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    public final zzcd zzb() {
        int i;
        boolean z6;
        int i6 = 0;
        for (char c6 : this.zzf) {
            if (zzad.zza(c6)) {
                char[] cArr = this.zzf;
                int length = cArr.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        z6 = false;
                        break;
                    }
                    char c7 = cArr[i7];
                    if (c7 >= 'A' && c7 <= 'Z') {
                        z6 = true;
                        break;
                    }
                    i7++;
                }
                if (z6) {
                    throw new IllegalStateException("Cannot call upperCase() on a mixed-case alphabet");
                }
                char[] cArr2 = new char[this.zzf.length];
                while (true) {
                    char[] cArr3 = this.zzf;
                    if (i6 >= cArr3.length) {
                        break;
                    }
                    char c8 = cArr3[i6];
                    if (zzad.zza(c8)) {
                        c8 ^= 32;
                    }
                    cArr2[i6] = (char) c8;
                    i6++;
                }
                zzcd zzcdVar = new zzcd(this.zze.concat(".upperCase()"), cArr2);
                if (!this.zzh || zzcdVar.zzh) {
                    return zzcdVar;
                }
                byte[] bArr = zzcdVar.zzg;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                for (i = 65; i <= 90; i++) {
                    int i8 = i | 32;
                    byte[] bArr2 = zzcdVar.zzg;
                    byte b3 = bArr2[i];
                    byte b6 = bArr2[i8];
                    if (b3 == -1) {
                        bArrCopyOf[i] = b6;
                    } else {
                        char c9 = (char) i;
                        char c10 = (char) i8;
                        if (b6 != -1) {
                            throw new IllegalStateException(zzaq.zza("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c9), Character.valueOf(c10)));
                        }
                        bArrCopyOf[i8] = b3;
                    }
                }
                return new zzcd(zzcdVar.zze.concat(".ignoreCase()"), zzcdVar.zzf, bArrCopyOf, true);
            }
        }
        return this;
    }

    public final boolean zzc(char c6) {
        byte[] bArr = this.zzg;
        return bArr.length > 61 && bArr[61] != -1;
    }

    private zzcd(String str, char[] cArr, byte[] bArr, boolean z6) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int iZzb = zzcj.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = iZzb;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iZzb);
            int i = 1 << (3 - iNumberOfTrailingZeros);
            this.zzc = i;
            this.zzd = iZzb >> iNumberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i];
            for (int i6 = 0; i6 < this.zzd; i6++) {
                zArr[zzcj.zza(i6 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = z6;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(d.f(cArr.length, "Illegal alphabet length "), e);
        }
    }
}
