package com.google.android.gms.internal.auth;

import F1.g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC1167d;
import com.google.android.gms.common.api.k;

/* JADX INFO: loaded from: classes.dex */
final class zzae extends AbstractC1167d {
    final /* synthetic */ String zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzae(zzal zzalVar, a aVar, f fVar, String str) {
        super(aVar, fVar);
        this.zza = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ k createFailedResult(Status status) {
        return new zzai(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1167d
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((g) ((zzam) bVar).getService()).Z(new zzad(this), this.zza);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1168e
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((k) obj);
    }
}
