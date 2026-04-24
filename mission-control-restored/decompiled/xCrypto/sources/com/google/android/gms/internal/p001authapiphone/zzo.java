package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC0921z;
import com.google.android.gms.common.api.internal.InterfaceC0905i;
import com.google.android.gms.common.internal.AbstractC0924b;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzo extends InterfaceC0905i.a {
    final /* synthetic */ TaskCompletionSource zza;

    public zzo(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0905i
    public final void onResult(Status status) {
        if (status.k() == 6) {
            this.zza.trySetException(AbstractC0924b.a(status));
        } else {
            AbstractC0921z.a(status, this.zza);
        }
    }
}
