package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.AbstractC1187y;
import com.google.android.gms.common.api.internal.InterfaceC1171h;
import com.google.android.gms.common.internal.AbstractC1191b;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zzu extends InterfaceC1171h.a {
    final /* synthetic */ TaskCompletionSource zza;

    public zzu(zzv zzvVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1171h
    public final void onResult(Status status) {
        if (status.B() == 6) {
            this.zza.trySetException(AbstractC1191b.a(status));
        } else {
            AbstractC1187y.a(status, this.zza);
        }
    }
}
