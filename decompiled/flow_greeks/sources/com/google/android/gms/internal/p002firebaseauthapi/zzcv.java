package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcv {
    public static final zzxb zza = zza(16);
    public static final zzxb zzb = zza(32);
    public static final zzxb zzc;

    static {
        zza(16, 16);
        zza(32, 16);
        zzvy zzvyVar = zzvy.SHA256;
        zzc = zza(16, 16, 32, 16, zzvyVar);
        zza(32, 16, 32, 32, zzvyVar);
        zzxb.zza zzaVarZza = zzxb.zza().zza(zzei.zza());
        zzxz zzxzVar = zzxz.TINK;
    }

    private static zzxb zza(int i10, int i11, int i12, int i13, zzvy zzvyVar) {
        zzto zztoVar = (zzto) ((zzalf) zzto.zzb().zza((zztr) ((zzalf) zztr.zzb().zza(16).zze())).zza(i10).zze());
        return (zzxb) ((zzalf) zzxb.zza().zza(((zzti) ((zzalf) zzti.zza().zza(zztoVar).zza((zzwe) ((zzalf) zzwe.zzc().zza((zzwh) ((zzalf) zzwh.zzc().zza(zzvyVar).zza(i13).zze())).zza(32).zze())).zze())).zzj()).zza(zzde.zza()).zza(zzxz.TINK).zze());
    }

    private static zzxb zza(int i10, int i11) {
        return (zzxb) ((zzalf) zzxb.zza().zza(((zztx) ((zzalf) zztx.zzb().zza(i10).zza((zzua) ((zzalf) zzua.zzb().zza(16).zze())).zze())).zzj()).zza(zzdm.zza()).zza(zzxz.TINK).zze());
    }

    private static zzxb zza(int i10) {
        return (zzxb) ((zzalf) zzxb.zza().zza(((zzug) ((zzalf) zzug.zzc().zza(i10).zze())).zzj()).zza(zzdt.zza()).zza(zzxz.TINK).zze());
    }
}
