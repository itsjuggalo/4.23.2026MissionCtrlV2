package com.google.android.gms.internal.p000authapi;

import I1.C0578c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC1187y;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zbam extends zbl {
    final /* synthetic */ TaskCompletionSource zba;

    public zbam(zbaq zbaqVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbm
    public final void zbb(Status status, C0578c c0578c) {
        AbstractC1187y.b(status, c0578c, this.zba);
    }
}
