package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzoy implements zzox {
    public static final zzkm zza;

    static {
        zzkg zzkgVarZzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzkgVarZzb.zzd("measurement.service.ad_impression.convert_value_to_double", true);
        zzkgVarZzb.zzd("measurement.service.separate_public_internal_event_blacklisting", true);
        zzkgVarZzb.zzd("measurement.service.ad_impression", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
