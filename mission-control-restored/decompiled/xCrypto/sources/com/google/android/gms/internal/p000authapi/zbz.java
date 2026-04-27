package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0924b;
import com.google.android.gms.tasks.TaskCompletionSource;
import r1.C1744a;

/* JADX INFO: loaded from: classes.dex */
final class zbz extends zbi {
    final /* synthetic */ TaskCompletionSource zba;

    public zbz(zbaa zbaaVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbj
    public final void zbb(Status status, C1744a c1744a) {
        if (status.o()) {
            this.zba.setResult(c1744a);
        } else {
            this.zba.setException(AbstractC0924b.a(status));
        }
    }
}
