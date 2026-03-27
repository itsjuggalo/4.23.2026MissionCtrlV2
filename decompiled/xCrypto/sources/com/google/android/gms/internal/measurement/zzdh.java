package com.google.android.gms.internal.measurement;

import J1.b;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdh extends zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzfb zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdh(zzfb zzfbVar, String str, String str2, Object obj, boolean z4) {
        super(zzfbVar, true);
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = z4;
        Objects.requireNonNull(zzfbVar);
        this.zze = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr) AbstractC0940s.k(this.zze.zzQ())).setUserProperty(this.zza, this.zzb, b.f(this.zzc), this.zzd, this.zzh);
    }
}
