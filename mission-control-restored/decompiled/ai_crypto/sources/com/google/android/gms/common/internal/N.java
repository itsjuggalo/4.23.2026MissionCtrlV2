package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class N implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.api.h f11037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f11038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r.a f11039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f11040d;

    public N(com.google.android.gms.common.api.h hVar, TaskCompletionSource taskCompletionSource, r.a aVar, P p7) {
        this.f11037a = hVar;
        this.f11038b = taskCompletionSource;
        this.f11039c = aVar;
        this.f11040d = p7;
    }

    @Override // com.google.android.gms.common.api.h.a
    public final void a(Status status) {
        if (!status.F()) {
            this.f11038b.setException(AbstractC1191b.a(status));
        } else {
            this.f11038b.setResult(this.f11039c.a(this.f11037a.await(0L, TimeUnit.MILLISECONDS)));
        }
    }
}
