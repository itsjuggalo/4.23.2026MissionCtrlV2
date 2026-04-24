package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC0921z;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzy extends zzh {
    final /* synthetic */ TaskCompletionSource zza;

    public zzy(zzaa zzaaVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.auth_blockstore.zzi
    public final void zza(Status status, boolean z4) {
        AbstractC0921z.b(status, Boolean.valueOf(z4), this.zza);
    }
}
