package com.google.android.gms.internal.location;

import P1.C0501l;
import P1.C0502m;
import P1.H;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.k;

/* JADX INFO: loaded from: classes.dex */
final class zzbh extends H {
    final /* synthetic */ C0501l zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbh(zzbi zzbiVar, f fVar, C0501l c0501l, String str) {
        super(fVar);
        this.zza = c0501l;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ k createFailedResult(Status status) {
        return new C0502m(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((zzaz) bVar).zzL(this.zza, this, null);
    }
}
