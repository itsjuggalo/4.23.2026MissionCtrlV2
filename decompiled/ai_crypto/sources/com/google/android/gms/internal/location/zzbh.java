package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.k;
import f2.AbstractC1557H;
import f2.C1586l;
import f2.C1587m;

/* JADX INFO: loaded from: classes.dex */
final class zzbh extends AbstractC1557H {
    final /* synthetic */ C1586l zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbh(zzbi zzbiVar, f fVar, C1586l c1586l, String str) {
        super(fVar);
        this.zza = c1586l;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ k createFailedResult(Status status) {
        return new C1587m(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1167d
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((zzaz) bVar).zzL(this.zza, this, null);
    }
}
