package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC0901e;
import com.google.android.gms.common.api.k;
import p1.AbstractC1687b;

/* JADX INFO: loaded from: classes.dex */
abstract class zzbj extends AbstractC0901e {
    public zzbj(f fVar) {
        super(AbstractC1687b.f13983a, fVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ k createFailedResult(Status status) {
        return new zzbv(status);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        zzbe zzbeVar = (zzbe) bVar;
        zza(zzbeVar.getContext(), (zzbh) zzbeVar.getService());
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0902f
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((k) obj);
    }

    public abstract void zza(Context context, zzbh zzbhVar);
}
