package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrp implements zzro {
    public static final zzkm zza = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb().zzd("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzro
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzro
    public final boolean zzb() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
