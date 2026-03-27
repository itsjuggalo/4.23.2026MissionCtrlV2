package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzmm implements zzbh {
    private final zzbh zza;
    private final byte[] zzb;

    private zzmm(zzbh zzbhVar, byte[] bArr) {
        this.zza = zzbhVar;
        this.zzb = bArr;
    }

    public static zzbh zza(zzoe zzoeVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzqe zzqeVarZza = zzoeVar.zza(zzbj.zza());
        zzbh zzbhVar = (zzbh) zznt.zza().zza(zzqeVarZza.zzf(), zzbh.class).zzb(zzqeVarZza.zzd());
        zzxu zzxuVarZzc = zzqeVarZza.zzc();
        int i7 = zzmp.zza[zzxuVarZzc.ordinal()];
        if (i7 == 1) {
            bArrZzb = zzpd.zza.zzb();
        } else if (i7 == 2 || i7 == 3) {
            bArrZzb = zzpd.zza(zzoeVar.zzb().intValue()).zzb();
        } else {
            if (i7 != 4) {
                throw new GeneralSecurityException("unknown output prefix type " + String.valueOf(zzxuVarZzc));
            }
            bArrZzb = zzpd.zzb(zzoeVar.zzb().intValue()).zzb();
        }
        return new zzmm(zzbhVar, bArrZzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbh
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqq.zza(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }
}
