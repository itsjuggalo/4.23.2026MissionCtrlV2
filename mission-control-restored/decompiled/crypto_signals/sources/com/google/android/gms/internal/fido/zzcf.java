package com.google.android.gms.internal.fido;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzcf extends zzcg {
    private zzcf(zzcd zzcdVar, Character ch) {
        super(zzcdVar, ch);
        zzap.zzc(zzcdVar.zzf.length == 64);
    }

    @Override // com.google.android.gms.internal.fido.zzcg
    public final zzch zza(zzcd zzcdVar, Character ch) {
        return new zzcf(zzcdVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzcg, com.google.android.gms.internal.fido.zzch
    public final void zzb(Appendable appendable, byte[] bArr, int i, int i6) throws IOException {
        int i7 = 0;
        zzap.zze(0, i6, bArr.length);
        for (int i8 = i6; i8 >= 3; i8 -= 3) {
            int i9 = bArr[i7] & 255;
            int i10 = ((bArr[i7 + 1] & 255) << 8) | (i9 << 16) | (bArr[i7 + 2] & 255);
            appendable.append(this.zzb.zza(i10 >>> 18));
            appendable.append(this.zzb.zza((i10 >>> 12) & 63));
            appendable.append(this.zzb.zza((i10 >>> 6) & 63));
            appendable.append(this.zzb.zza(i10 & 63));
            i7 += 3;
        }
        if (i7 < i6) {
            zze(appendable, bArr, i7, i6 - i7);
        }
    }

    public zzcf(String str, String str2, Character ch) {
        this(new zzcd(str, str2.toCharArray()), ch);
    }
}
