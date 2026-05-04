package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjv implements zzbe {
    private final zzbe zza;
    private final zzxz zzb;
    private final byte[] zzc;

    private zzjv(zzbe zzbeVar, zzxz zzxzVar, byte[] bArr) {
        this.zza = zzbeVar;
        this.zzb = zzxzVar;
        this.zzc = bArr;
    }

    public static zzbe zza(zzof zzofVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzqb zzqbVarZza = zzofVar.zza(zzbf.zza());
        zzbe zzbeVar = (zzbe) zznq.zza().zza(zzqbVarZza.zzf(), zzbe.class).zzb(zzqbVarZza.zzd());
        zzxz zzxzVarZzb = zzqbVarZza.zzb();
        int i10 = zzjy.zza[zzxzVarZzb.ordinal()];
        if (i10 == 1) {
            bArrZzb = zzpe.zza.zzb();
        } else if (i10 == 2 || i10 == 3) {
            bArrZzb = zzpe.zza(zzofVar.zzb().intValue()).zzb();
        } else {
            if (i10 != 4) {
                throw new GeneralSecurityException("unknown output prefix type " + zzxzVarZzb.zza());
            }
            bArrZzb = zzpe.zzb(zzofVar.zzb().intValue()).zzb();
        }
        return new zzjv(zzbeVar, zzxzVarZzb, bArrZzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (this.zzb == zzxz.RAW) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqn.zza(this.zzc, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
