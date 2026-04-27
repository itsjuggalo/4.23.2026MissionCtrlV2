package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzel extends zzeq {
    final /* synthetic */ zzer zza;
    final /* synthetic */ zzfb zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzel(zzfb zzfbVar, zzer zzerVar) {
        super(zzfbVar, true);
        this.zza = zzerVar;
        Objects.requireNonNull(zzfbVar);
        this.zzb = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr) AbstractC0940s.k(this.zzb.zzQ())).setEventInterceptor(this.zza);
    }
}
