package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public enum zzjj {
    STORAGE(zzjk.AD_STORAGE, zzjk.ANALYTICS_STORAGE),
    DMA(zzjk.AD_USER_DATA);

    private final zzjk[] zzc;

    zzjj(zzjk... zzjkVarArr) {
        this.zzc = zzjkVarArr;
    }

    public final zzjk[] zza() {
        return this.zzc;
    }

    public final /* synthetic */ zzjk[] zzb() {
        return this.zzc;
    }
}
