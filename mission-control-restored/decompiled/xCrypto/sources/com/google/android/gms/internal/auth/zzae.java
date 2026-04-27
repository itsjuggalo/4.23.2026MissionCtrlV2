package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC0901e;
import com.google.android.gms.common.api.k;
import o1.InterfaceC1667g;

/* JADX INFO: loaded from: classes.dex */
final class zzae extends AbstractC0901e {
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

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((InterfaceC1667g) ((zzam) bVar).getService()).O(new zzad(this), this.zza);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0902f
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((k) obj);
    }
}
