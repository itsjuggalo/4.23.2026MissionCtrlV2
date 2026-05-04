package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzajz extends zzakg {
    private final int zzc;
    private final int zzd;

    public zzajz(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzajv.zza(i10, i10 + i11, bArr.length);
        this.zzc = i10;
        this.zzd = i11;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg, com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final byte zza(int i10) {
        int iZzb = zzb();
        if (((iZzb - (i10 + 1)) | i10) >= 0) {
            return this.zzb[this.zzc + i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + iZzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg, com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final byte zzb(int i10) {
        return this.zzb[this.zzc + i10];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg, com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg, com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final void zza(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.zzb, zze(), bArr, 0, i12);
    }
}
