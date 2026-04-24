package com.google.android.gms.internal.location;

import P1.AbstractC0498i;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC0910n;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: loaded from: classes.dex */
final class zzt extends zzx {
    final /* synthetic */ LocationRequest zza;
    final /* synthetic */ AbstractC0498i zzb;
    final /* synthetic */ Looper zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzt(zzz zzzVar, f fVar, LocationRequest locationRequest, AbstractC0498i abstractC0498i, Looper looper) {
        super(fVar);
        this.zza = locationRequest;
        this.zzc = looper;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((zzaz) bVar).zzB(zzba.zza(null, this.zza), AbstractC0910n.a(null, zzbj.zza(this.zzc), AbstractC0498i.class.getSimpleName()), new zzy(this));
    }
}
