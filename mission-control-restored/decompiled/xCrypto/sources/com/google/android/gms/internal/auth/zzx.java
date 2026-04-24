package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.InterfaceC0905i;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzx extends InterfaceC0905i.a {
    final /* synthetic */ TaskCompletionSource zza;

    public zzx(zzab zzabVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0905i
    public final void onResult(Status status) {
        zzab.zzf(status, null, this.zza);
    }
}
