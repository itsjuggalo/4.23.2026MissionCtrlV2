package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0924b;
import com.google.android.gms.tasks.TaskCompletionSource;
import r1.h;

/* JADX INFO: loaded from: classes.dex */
final class zbae extends zbs {
    final /* synthetic */ TaskCompletionSource zba;

    public zbae(zbag zbagVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbt
    public final void zbb(Status status, h hVar) {
        if (status.o()) {
            this.zba.setResult(hVar);
        } else {
            this.zba.setException(AbstractC0924b.a(status));
        }
    }
}
