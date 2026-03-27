package com.google.android.gms.internal.measurement;

import J1.b;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzec extends zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzec(zzfb zzfbVar, boolean z4, int i4, String str, Object obj, Object obj2, Object obj3) {
        super(zzfbVar, false);
        this.zza = str;
        this.zzb = obj;
        Objects.requireNonNull(zzfbVar);
        this.zzc = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr) AbstractC0940s.k(this.zzc.zzQ())).logHealthData(5, this.zza, b.f(this.zzb), b.f(null), b.f(null));
    }
}
