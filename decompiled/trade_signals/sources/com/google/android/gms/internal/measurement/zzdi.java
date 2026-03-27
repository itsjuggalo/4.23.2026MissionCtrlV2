package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdi extends zzeq {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzfb zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdi(zzfb zzfbVar, Bundle bundle) {
        super(zzfbVar, true);
        this.zza = bundle;
        Objects.requireNonNull(zzfbVar);
        this.zzb = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr) AbstractC1294n.j(this.zzb.zzQ())).setConditionalUserProperty(this.zza, this.zzh);
    }
}
