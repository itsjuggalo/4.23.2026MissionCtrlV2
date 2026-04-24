package com.google.android.gms.internal.p000authapi;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC1187y;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zbao extends zbq {
    final /* synthetic */ TaskCompletionSource zba;

    public zbao(zbaq zbaqVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbr
    public final void zbb(Status status, PendingIntent pendingIntent) {
        AbstractC1187y.b(status, pendingIntent, this.zba);
    }
}
