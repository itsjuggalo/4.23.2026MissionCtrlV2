package com.google.android.gms.internal.location;

import P1.InterfaceC0499j;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC0910n;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: loaded from: classes.dex */
final class zzr extends zzx {
    final /* synthetic */ LocationRequest zza;
    final /* synthetic */ InterfaceC0499j zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzr(zzz zzzVar, f fVar, LocationRequest locationRequest, InterfaceC0499j interfaceC0499j) {
        super(fVar);
        this.zza = locationRequest;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((zzaz) bVar).zzC(this.zza, AbstractC0910n.a(null, zzbj.zzb(), InterfaceC0499j.class.getSimpleName()), new zzy(this));
    }
}
