package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import f2.C1582h;

/* JADX INFO: loaded from: classes.dex */
final class zzac extends zzae {
    final /* synthetic */ C1582h zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzaf zzafVar, f fVar, C1582h c1582h, PendingIntent pendingIntent) {
        super(fVar);
        this.zza = c1582h;
        this.zzb = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1167d
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((zzaz) bVar).zzv(this.zza, this.zzb, this);
    }
}
