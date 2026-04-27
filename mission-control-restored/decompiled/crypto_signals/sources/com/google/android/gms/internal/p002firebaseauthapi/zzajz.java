package com.google.android.gms.internal.p002firebaseauthapi;

import a3.d;

/* JADX INFO: loaded from: classes.dex */
final class zzajz extends zzakg {
    private final int zzc;
    private final int zzd;

    public zzajz(byte[] bArr, int i, int i6) {
        super(bArr);
        zzajv.zza(i, i + i6, bArr.length);
        this.zzc = i;
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg, com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final byte zza(int i) {
        int iZzb = zzb();
        if (((iZzb - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(d.f(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(d.h("Index > length: ", i, iZzb, ", "));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg, com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
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
    public final void zza(byte[] bArr, int i, int i6, int i7) {
        System.arraycopy(this.zzb, zze(), bArr, 0, i7);
    }
}
