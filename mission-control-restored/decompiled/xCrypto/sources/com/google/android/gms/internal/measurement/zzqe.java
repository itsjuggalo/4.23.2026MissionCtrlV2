package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzqe implements zzqd {
    public static final zzkl zza;

    static {
        zzkf zzkfVarZzb = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkfVarZzb.zzd("measurement.gmscore_feature_tracking", true);
        zza = zzkfVarZzb.zzd("measurement.gmscore_client_telemetry", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqd
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
