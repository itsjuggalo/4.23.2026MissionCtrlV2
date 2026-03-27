package com.google.android.gms.internal.fido;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzce extends zzcg {
    final char[] zza;

    private zzce(zzcd zzcdVar) {
        super(zzcdVar, null);
        this.zza = new char[512];
        zzap.zzc(zzcdVar.zzf.length == 16);
        for (int i4 = 0; i4 < 256; i4++) {
            this.zza[i4] = zzcdVar.zza(i4 >>> 4);
            this.zza[i4 | 256] = zzcdVar.zza(i4 & 15);
        }
    }

    @Override // com.google.android.gms.internal.fido.zzcg
    public final zzch zza(zzcd zzcdVar, Character ch) {
        return new zzce(zzcdVar);
    }

    @Override // com.google.android.gms.internal.fido.zzcg, com.google.android.gms.internal.fido.zzch
    public final void zzb(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
        zzap.zze(0, i5, bArr.length);
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = bArr[i6] & 255;
            appendable.append(this.zza[i7]);
            appendable.append(this.zza[i7 | 256]);
        }
    }

    public zzce(String str, String str2) {
        this(new zzcd("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
