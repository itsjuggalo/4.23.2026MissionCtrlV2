package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzln implements zzmb {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmb
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmb
    public final int zzb() {
        return 12;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmb
    public final byte[] zzc() {
        return zzmn.zzk;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmb
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i7, byte[] bArr4) throws InvalidAlgorithmParameterException {
        if (bArr.length != 32) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: 32");
        }
        if (zzhy.zza()) {
            return zzhy.zza(bArr).zza(bArr2, bArr3, i7, bArr4);
        }
        return new zzhw(bArr).zza(bArr2, Arrays.copyOfRange(bArr3, i7, bArr3.length), bArr4);
    }
}
