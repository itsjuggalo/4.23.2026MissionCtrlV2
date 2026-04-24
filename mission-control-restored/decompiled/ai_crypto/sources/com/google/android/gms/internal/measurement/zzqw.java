package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzqw implements zzqv {
    public static final zzkl zza;

    static {
        zzkf zzkfVarZzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzkfVarZzb.zzd("measurement.session_stitching_token_enabled", false);
        zzkfVarZzb.zzd("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqv
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzqv
    public final boolean zzb() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
