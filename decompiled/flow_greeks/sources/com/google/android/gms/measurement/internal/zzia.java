package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzia implements Runnable {
    final /* synthetic */ zzjs zza;
    final /* synthetic */ zzic zzb;

    public zzia(zzic zzicVar, zzjs zzjsVar) {
        this.zza = zzjsVar;
        Objects.requireNonNull(zzicVar);
        this.zzb = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzic zzicVar = this.zzb;
        zzjs zzjsVar = this.zza;
        zzicVar.zzK(zzjsVar);
        zzicVar.zza(zzjsVar.zzd);
    }
}
