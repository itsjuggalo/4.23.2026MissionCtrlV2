package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC1187y;
import com.google.android.gms.common.api.internal.InterfaceC1171h;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zban extends InterfaceC1171h.a {
    final /* synthetic */ TaskCompletionSource zba;

    public zban(zbaq zbaqVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1171h
    public final void onResult(Status status) {
        AbstractC1187y.a(status, this.zba);
    }
}
