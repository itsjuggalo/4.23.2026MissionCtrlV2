package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC0901e;
import com.google.android.gms.common.api.k;
import o1.InterfaceC1667g;

/* JADX INFO: loaded from: classes.dex */
final class zzag extends AbstractC0901e {
    final /* synthetic */ Account zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzag(zzal zzalVar, a aVar, f fVar, Account account) {
        super(aVar, fVar);
        this.zza = account;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final k createFailedResult(Status status) {
        return new zzak(status);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((InterfaceC1667g) ((zzam) bVar).getService()).q(new zzaf(this), this.zza);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0902f
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((k) obj);
    }
}
