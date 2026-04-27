package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC0921z;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzv extends zzn {
    final /* synthetic */ TaskCompletionSource zza;

    public zzv(zzaa zzaaVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.auth_blockstore.zzo
    public final void zza(Status status, int i4) {
        AbstractC0921z.b(status, Integer.valueOf(i4), this.zza);
    }
}
