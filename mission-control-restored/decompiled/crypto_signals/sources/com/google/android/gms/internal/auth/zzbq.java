package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.common.api.o;
import q1.C0920a;

/* JADX INFO: loaded from: classes.dex */
final class zzbq extends zzbi {
    final /* synthetic */ C0920a zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbq(zzbt zzbtVar, o oVar, C0920a c0920a) {
        super(oVar);
        this.zza = c0920a;
    }

    @Override // com.google.android.gms.internal.auth.zzbi
    public final void zza(Context context, zzbh zzbhVar) {
        zzbhVar.zze(new zzbp(this), this.zza);
    }
}
