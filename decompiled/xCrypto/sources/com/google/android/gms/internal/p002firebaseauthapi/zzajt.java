package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzajt extends zzajw {
    private final int zzc;
    private final int zzd;

    public zzajt(byte[] bArr, int i4, int i5) {
        super(bArr);
        zzajp.zza(i4, i4 + i5, bArr.length);
        this.zzc = i4;
        this.zzd = i5;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw, com.google.android.gms.internal.p002firebaseauthapi.zzajp
    public final byte zza(int i4) {
        int iZzb = zzb();
        if (((iZzb - (i4 + 1)) | i4) >= 0) {
            return this.zzb[this.zzc + i4];
        }
        if (i4 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + iZzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw, com.google.android.gms.internal.p002firebaseauthapi.zzajp
    public final byte zzb(int i4) {
        return this.zzb[this.zzc + i4];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw, com.google.android.gms.internal.p002firebaseauthapi.zzajp
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw, com.google.android.gms.internal.p002firebaseauthapi.zzajp
    public final void zza(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zzb, zze(), bArr, 0, i6);
    }
}
