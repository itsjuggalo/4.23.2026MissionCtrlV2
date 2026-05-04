package com.google.android.gms.internal.p000authapi;

import c5.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zbaf extends zbr {
    final /* synthetic */ TaskCompletionSource zba;

    public zbaf(zbaj zbajVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
        Objects.requireNonNull(zbajVar);
    }

    @Override // com.google.android.gms.internal.p000authapi.zbs
    public final void zbb(Status status, j jVar) {
        if (status.V()) {
            this.zba.setResult(jVar);
        } else {
            this.zba.setException(b.a(status));
        }
    }
}
