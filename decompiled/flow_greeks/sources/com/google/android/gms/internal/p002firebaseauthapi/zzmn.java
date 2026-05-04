package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmn implements zzbd {
    private final zzbd zza;
    private final byte[] zzb;

    private zzmn(zzbd zzbdVar, byte[] bArr) {
        this.zza = zzbdVar;
        this.zzb = bArr;
    }

    public static zzbd zza(zzof zzofVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzqb zzqbVarZza = zzofVar.zza(zzbf.zza());
        zzbd zzbdVar = (zzbd) zznq.zza().zza(zzqbVarZza.zzf(), zzbd.class).zzb(zzqbVarZza.zzd());
        zzxz zzxzVarZzb = zzqbVarZza.zzb();
        int i10 = zzmm.zza[zzxzVarZzb.ordinal()];
        if (i10 == 1) {
            bArrZzb = zzpe.zza.zzb();
        } else if (i10 == 2 || i10 == 3) {
            bArrZzb = zzpe.zza(zzofVar.zzb().intValue()).zzb();
        } else {
            if (i10 != 4) {
                throw new GeneralSecurityException("unknown output prefix type " + String.valueOf(zzxzVarZzb));
            }
            bArrZzb = zzpe.zzb(zzofVar.zzb().intValue()).zzb();
        }
        return new zzmn(zzbdVar, bArrZzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqn.zza(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }
}
