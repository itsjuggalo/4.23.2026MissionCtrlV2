package com.google.android.gms.internal.p000authapi;

import c5.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zbx extends zbh {
    final /* synthetic */ TaskCompletionSource zba;

    public zbx(zbad zbadVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
        Objects.requireNonNull(zbadVar);
    }

    @Override // com.google.android.gms.internal.p000authapi.zbi
    public final void zbb(Status status, b bVar) {
        if (status.V()) {
            this.zba.setResult(bVar);
        } else {
            this.zba.setException(com.google.android.gms.common.internal.b.a(status));
        }
    }
}
