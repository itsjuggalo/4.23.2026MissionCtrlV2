package com.google.android.gms.internal.fido;

import a3.d;

/* JADX INFO: loaded from: classes.dex */
final class zzct extends zzcw {
    private final int zzc;
    private final int zzd;

    public zzct(byte[] bArr, int i, int i6) {
        super(bArr);
        zzcz.zzj(i, i + i6, bArr.length);
        this.zzc = i;
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final byte zza(int i) {
        int i6 = this.zzd;
        if (((i6 - (i + 1)) | i) >= 0) {
            return this.zza[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(d.f(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(d.h("Index > length: ", i, i6, ", "));
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.fido.zzcw
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final void zze(byte[] bArr, int i, int i6, int i7) {
        System.arraycopy(this.zza, this.zzc, bArr, 0, i7);
    }
}
