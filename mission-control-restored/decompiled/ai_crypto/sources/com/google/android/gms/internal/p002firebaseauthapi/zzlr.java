package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzlr implements zzlq {
    private final zzjh zza;
    private final int zzb;

    public zzlr(zzjh zzjhVar) {
        this.zza = zzjhVar;
        this.zzb = zzjhVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlq
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlq
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i7) throws GeneralSecurityException {
        if (bArr2.length < i7) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return zzyr.zza(zzja.zzc().zza(this.zza).zza(zzaaf.zza(bArr, zzbj.zza())).zza()).zza(Arrays.copyOfRange(bArr2, i7, bArr2.length), zzlm.zza);
    }
}
