package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.api.h f5737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r.a f5739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n0 f5740d;

    public l0(com.google.android.gms.common.api.h hVar, TaskCompletionSource taskCompletionSource, r.a aVar, n0 n0Var) {
        this.f5737a = hVar;
        this.f5738b = taskCompletionSource;
        this.f5739c = aVar;
        this.f5740d = n0Var;
    }

    @Override // com.google.android.gms.common.api.h.a
    public final void a(Status status) {
        if (!status.V()) {
            this.f5738b.setException(b.a(status));
        } else {
            this.f5738b.setResult(this.f5739c.a(this.f5737a.await(0L, TimeUnit.MILLISECONDS)));
        }
    }
}
