package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrg implements zzrf {
    public static final zzkm zza;

    static {
        zzkg zzkgVarZzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzkgVarZzb.zzd("measurement.client.sessions.enable_fix_background_engagement", false);
        zzkgVarZzb.zzd("measurement.client.sessions.enable_pause_engagement_in_background", true);
        zzkgVarZzb.zzc("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzrf
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
