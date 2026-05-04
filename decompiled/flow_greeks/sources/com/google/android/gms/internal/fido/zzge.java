package com.google.android.gms.internal.fido;

import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
class zzge extends zzgf {
    private volatile zzgf zza;
    final zzgb zzb;
    final Character zzc;

    public zzge(zzgb zzgbVar, Character ch2) {
        this.zzb = zzgbVar;
        if (ch2 != null && zzgbVar.zzc('=')) {
            throw new IllegalArgumentException(zzbo.zza("Padding character %s was already in alphabet", ch2));
        }
        this.zzc = ch2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzge) {
            zzge zzgeVar = (zzge) obj;
            if (this.zzb.equals(zzgeVar.zzb) && Objects.equals(this.zzc, zzgeVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch2 = this.zzc;
        return Objects.hashCode(ch2) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BaseEncoding.");
        sb2.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb2.append(".omitPadding()");
            } else {
                sb2.append(".withPadChar('");
                sb2.append(this.zzc);
                sb2.append("')");
            }
        }
        return sb2.toString();
    }

    public zzgf zza(zzgb zzgbVar, Character ch2) {
        return new zzge(zzgbVar, ch2);
    }

    @Override // com.google.android.gms.internal.fido.zzgf
    public void zzb(Appendable appendable, byte[] bArr, int i10, int i11) {
        int i12 = 0;
        zzbm.zze(0, i11, bArr.length);
        while (i12 < i11) {
            zze(appendable, bArr, i12, Math.min(this.zzb.zzd, i11 - i12));
            i12 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzgf
    public final int zzc(int i10) {
        zzgb zzgbVar = this.zzb;
        return zzgbVar.zzc * zzgh.zza(i10, zzgbVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.fido.zzgf
    public final zzgf zzd() {
        zzgf zzgfVarZza = this.zza;
        if (zzgfVarZza == null) {
            zzgb zzgbVar = this.zzb;
            zzgb zzgbVarZzb = zzgbVar.zzb();
            zzgfVarZza = zzgbVarZzb == zzgbVar ? this : zza(zzgbVarZzb, this.zzc);
            this.zza = zzgfVarZza;
        }
        return zzgfVarZza;
    }

    public final void zze(Appendable appendable, byte[] bArr, int i10, int i11) {
        zzbm.zze(i10, i10 + i11, bArr.length);
        int i12 = 0;
        zzbm.zzc(i11 <= this.zzb.zzd);
        long j10 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            j10 = (j10 | ((long) (bArr[i10 + i13] & 255))) << 8;
        }
        int i14 = (i11 + 1) * 8;
        zzgb zzgbVar = this.zzb;
        while (i12 < i11 * 8) {
            long j11 = j10 >>> ((i14 - zzgbVar.zzb) - i12);
            zzgb zzgbVar2 = this.zzb;
            appendable.append(zzgbVar2.zza(((int) j11) & zzgbVar2.zza));
            i12 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i12 < this.zzb.zzd * 8) {
                this.zzc.getClass();
                appendable.append('=');
                i12 += this.zzb.zzb;
            }
        }
    }

    public zzge(String str, String str2, Character ch2) {
        this(new zzgb(str, str2.toCharArray()), ch2);
    }
}
