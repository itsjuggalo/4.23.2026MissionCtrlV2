package com.google.android.recaptcha.internal;

import a3.d;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class zzkg extends zzkh {
    final zzkd zza;
    final Character zzb;

    public zzkg(zzkd zzkdVar, Character ch) {
        this.zza = zzkdVar;
        if (ch != null && zzkdVar.zzd('=')) {
            throw new IllegalArgumentException(zzji.zza("Padding character %s was already in alphabet", ch));
        }
        this.zzb = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzkg) {
            zzkg zzkgVar = (zzkg) obj;
            if (this.zza.equals(zzkgVar.zza) && Objects.equals(this.zzb, zzkgVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzb;
        return Objects.hashCode(ch) ^ this.zza.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zza);
        if (8 % this.zza.zzb != 0) {
            if (this.zzb == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzb);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public int zza(byte[] bArr, CharSequence charSequence) throws zzkf {
        zzkd zzkdVar;
        CharSequence charSequenceZze = zze(charSequence);
        if (!this.zza.zzc(charSequenceZze.length())) {
            throw new zzkf(d.f(charSequenceZze.length(), "Invalid input length "));
        }
        int i = 0;
        int i6 = 0;
        while (i < charSequenceZze.length()) {
            long jZzb = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                zzkdVar = this.zza;
                if (i7 >= zzkdVar.zzc) {
                    break;
                }
                jZzb <<= zzkdVar.zzb;
                if (i + i7 < charSequenceZze.length()) {
                    jZzb |= (long) this.zza.zzb(charSequenceZze.charAt(i8 + i));
                    i8++;
                }
                i7++;
            }
            int i9 = zzkdVar.zzd;
            int i10 = i8 * zzkdVar.zzb;
            int i11 = (i9 - 1) * 8;
            while (i11 >= (i9 * 8) - i10) {
                bArr[i6] = (byte) ((jZzb >>> i11) & 255);
                i11 -= 8;
                i6++;
            }
            i += this.zza.zzc;
        }
        return i6;
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public void zzb(Appendable appendable, byte[] bArr, int i, int i6) {
        int i7 = 0;
        zzjf.zzd(0, i6, bArr.length);
        while (i7 < i6) {
            zzf(appendable, bArr, i7, Math.min(this.zza.zzd, i6 - i7));
            i7 += this.zza.zzd;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public final int zzc(int i) {
        return (int) (((((long) this.zza.zzb) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public final int zzd(int i) {
        zzkd zzkdVar = this.zza;
        return zzkdVar.zzc * zzkj.zza(i, zzkdVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public final CharSequence zze(CharSequence charSequence) {
        charSequence.getClass();
        if (this.zzb == null) {
            return charSequence;
        }
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    public final void zzf(Appendable appendable, byte[] bArr, int i, int i6) {
        zzjf.zzd(i, i + i6, bArr.length);
        int i7 = 0;
        zzjf.zza(i6 <= this.zza.zzd);
        long j4 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            j4 = (j4 | ((long) (bArr[i + i8] & 255))) << 8;
        }
        int i9 = (i6 + 1) * 8;
        zzkd zzkdVar = this.zza;
        while (i7 < i6 * 8) {
            long j6 = j4 >>> ((i9 - zzkdVar.zzb) - i7);
            zzkd zzkdVar2 = this.zza;
            appendable.append(zzkdVar2.zza(((int) j6) & zzkdVar2.zza));
            i7 += this.zza.zzb;
        }
        if (this.zzb != null) {
            while (i7 < this.zza.zzd * 8) {
                this.zzb.getClass();
                appendable.append('=');
                i7 += this.zza.zzb;
            }
        }
    }

    public zzkg(String str, String str2, Character ch) {
        this(new zzkd(str, str2.toCharArray()), ch);
    }
}
