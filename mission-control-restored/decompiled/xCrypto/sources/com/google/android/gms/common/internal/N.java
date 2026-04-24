package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class N implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.api.h f9854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f9855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r.a f9856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f9857d;

    public N(com.google.android.gms.common.api.h hVar, TaskCompletionSource taskCompletionSource, r.a aVar, P p4) {
        this.f9854a = hVar;
        this.f9855b = taskCompletionSource;
        this.f9856c = aVar;
        this.f9857d = p4;
    }

    @Override // com.google.android.gms.common.api.h.a
    public final void a(Status status) {
        if (!status.o()) {
            this.f9855b.setException(AbstractC0924b.a(status));
        } else {
            this.f9855b.setResult(this.f9856c.a(this.f9854a.await(0L, TimeUnit.MILLISECONDS)));
        }
    }
}
