package com.google.android.gms.internal.p000authapi;

import I1.C0576a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1191b;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zbz extends zbi {
    final /* synthetic */ TaskCompletionSource zba;

    public zbz(zbaa zbaaVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbj
    public final void zbb(Status status, C0576a c0576a) {
        if (status.F()) {
            this.zba.setResult(c0576a);
        } else {
            this.zba.setException(AbstractC1191b.a(status));
        }
    }
}
