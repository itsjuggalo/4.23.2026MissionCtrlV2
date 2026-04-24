package com.google.android.gms.internal.location;

import P1.C0497h;
import android.app.PendingIntent;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;

/* JADX INFO: loaded from: classes.dex */
final class zzac extends zzae {
    final /* synthetic */ C0497h zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzaf zzafVar, f fVar, C0497h c0497h, PendingIntent pendingIntent) {
        super(fVar);
        this.zza = c0497h;
        this.zzb = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((zzaz) bVar).zzv(this.zza, this.zzb, this);
    }
}
