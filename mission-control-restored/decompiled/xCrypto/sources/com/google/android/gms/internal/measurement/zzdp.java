package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdp extends zzeq {
    final /* synthetic */ zzfb zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdp(zzfb zzfbVar) {
        super(zzfbVar, true);
        Objects.requireNonNull(zzfbVar);
        this.zza = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr) AbstractC0940s.k(this.zza.zzQ())).resetAnalyticsData(this.zzh);
    }
}
