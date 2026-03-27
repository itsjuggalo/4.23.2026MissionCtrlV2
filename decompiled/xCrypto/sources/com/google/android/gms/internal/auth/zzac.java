package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC0901e;
import com.google.android.gms.common.api.k;
import o1.InterfaceC1667g;

/* JADX INFO: loaded from: classes.dex */
final class zzac extends AbstractC0901e {
    final /* synthetic */ boolean zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzal zzalVar, a aVar, f fVar, boolean z4) {
        super(aVar, fVar);
        this.zza = z4;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final k createFailedResult(Status status) {
        return new zzaj(status);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((InterfaceC1667g) ((zzam) bVar).getService()).R(this.zza);
        setResult(new zzaj(Status.f9653f));
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0902f
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((k) obj);
    }
}
