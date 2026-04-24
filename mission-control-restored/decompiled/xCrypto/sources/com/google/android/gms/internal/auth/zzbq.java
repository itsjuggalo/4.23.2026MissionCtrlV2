package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.common.api.f;
import t1.b;

/* JADX INFO: loaded from: classes.dex */
final class zzbq extends zzbi {
    final /* synthetic */ b zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbq(zzbt zzbtVar, f fVar, b bVar) {
        super(fVar);
        this.zza = bVar;
    }

    @Override // com.google.android.gms.internal.auth.zzbi
    public final void zza(Context context, zzbh zzbhVar) {
        zzbhVar.zze(new zzbp(this), this.zza);
    }
}
