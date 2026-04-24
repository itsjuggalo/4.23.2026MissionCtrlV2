package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
final class zzlk implements zzmb {
    private final int zza;

    public zzlk(int i4) throws InvalidAlgorithmParameterException {
        if (i4 == 16 || i4 == 32) {
            this.zza = i4;
        } else {
            throw new InvalidAlgorithmParameterException("Unsupported key length: " + i4);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmb
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmb
    public final int zzb() {
        return 12;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmb
    public final byte[] zzc() throws GeneralSecurityException {
        int i4 = this.zza;
        if (i4 == 16) {
            return zzmn.zzi;
        }
        if (i4 == 32) {
            return zzmn.zzj;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmb
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i4, byte[] bArr4) throws InvalidAlgorithmParameterException {
        if (bArr.length == this.zza) {
            return new zzhr(bArr).zza(bArr2, bArr3, i4, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + bArr.length);
    }
}
