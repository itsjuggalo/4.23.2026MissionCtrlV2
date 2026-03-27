package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC0921z;
import com.google.android.gms.tasks.TaskCompletionSource;
import w1.C1904e;

/* JADX INFO: loaded from: classes.dex */
final class zzw extends zze {
    final /* synthetic */ TaskCompletionSource zza;

    public zzw(zzaa zzaaVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.auth_blockstore.zze, com.google.android.gms.internal.auth_blockstore.zzm
    public final void zzb(Status status, C1904e c1904e) {
        AbstractC0921z.b(status, c1904e, this.zza);
    }
}
