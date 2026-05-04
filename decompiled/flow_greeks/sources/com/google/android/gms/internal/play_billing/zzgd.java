package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzgd implements zzgw {
    private static final zzgj zza = new zzgb();
    private final zzgj zzb;

    public zzgd() {
        zzfd zzfdVarZza = zzfd.zza();
        int i10 = zzgs.zza;
        zzgc zzgcVar = new zzgc(zzfdVarZza, zza);
        byte[] bArr = zzfo.zzb;
        this.zzb = zzgcVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgw
    public final zzgv zza(Class cls) {
        int i10 = zzgx.zza;
        if (!zzfi.class.isAssignableFrom(cls)) {
            int i11 = zzgs.zza;
        }
        zzgi zzgiVarZzb = this.zzb.zzb(cls);
        if (zzgiVarZzb.zzb()) {
            int i12 = zzgs.zza;
            return zzgp.zzc(zzgx.zzm(), zzex.zza(), zzgiVarZzb.zza());
        }
        int i13 = zzgs.zza;
        return zzgo.zzl(cls, zzgiVarZzb, zzgr.zza(), zzfz.zza(), zzgx.zzm(), zzgiVarZzb.zzc() + (-1) != 1 ? zzex.zza() : null, zzgh.zza());
    }
}
