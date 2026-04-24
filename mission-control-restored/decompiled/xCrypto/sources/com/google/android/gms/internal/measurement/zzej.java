package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzej extends zzeq {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzfb zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzej(zzfb zzfbVar, boolean z4) {
        super(zzfbVar, true);
        this.zza = z4;
        Objects.requireNonNull(zzfbVar);
        this.zzb = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr) AbstractC0940s.k(this.zzb.zzQ())).setDataCollectionEnabled(this.zza);
    }
}
