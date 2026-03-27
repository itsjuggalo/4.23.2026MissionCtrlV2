package com.google.android.gms.internal.p000authapi;

import I1.h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1191b;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zbae extends zbs {
    final /* synthetic */ TaskCompletionSource zba;

    public zbae(zbag zbagVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbt
    public final void zbb(Status status, h hVar) {
        if (status.F()) {
            this.zba.setResult(hVar);
        } else {
            this.zba.setException(AbstractC1191b.a(status));
        }
    }
}
