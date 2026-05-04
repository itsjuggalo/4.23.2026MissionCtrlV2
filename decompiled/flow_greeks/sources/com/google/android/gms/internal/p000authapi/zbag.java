package com.google.android.gms.internal.p000authapi;

import c5.l;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zbag extends zbt {
    final /* synthetic */ TaskCompletionSource zba;

    public zbag(zbaj zbajVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
        Objects.requireNonNull(zbajVar);
    }

    @Override // com.google.android.gms.internal.p000authapi.zbu
    public final void zbb(Status status, l lVar) {
        w.b(status, lVar, this.zba);
    }
}
