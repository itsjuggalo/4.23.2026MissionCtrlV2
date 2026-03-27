package com.google.android.gms.internal.fido;

/* JADX INFO: loaded from: classes.dex */
final class zzct extends zzcw {
    private final int zzc;
    private final int zzd;

    public zzct(byte[] bArr, int i4, int i5) {
        super(bArr);
        zzcz.zzj(i4, i4 + i5, bArr.length);
        this.zzc = i4;
        this.zzd = i5;
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final byte zza(int i4) {
        int i5 = this.zzd;
        if (((i5 - (i4 + 1)) | i4) >= 0) {
            return this.zza[this.zzc + i4];
        }
        if (i4 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + i5);
    }

    @Override // com.google.android.gms.internal.fido.zzcw, com.google.android.gms.internal.fido.zzcz
    public final byte zzb(int i4) {
        return this.zza[this.zzc + i4];
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
    public final void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zza, this.zzc, bArr, 0, i6);
    }
}
