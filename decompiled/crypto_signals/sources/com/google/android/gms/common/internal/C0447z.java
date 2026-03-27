package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0447z implements com.google.android.gms.common.api.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.api.q f5295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0440s f5297c;

    public C0447z(com.google.android.gms.common.api.q qVar, TaskCompletionSource taskCompletionSource, InterfaceC0440s interfaceC0440s) {
        this.f5295a = qVar;
        this.f5296b = taskCompletionSource;
        this.f5297c = interfaceC0440s;
    }

    @Override // com.google.android.gms.common.api.p
    public final void a(Status status) {
        boolean zM = status.m();
        TaskCompletionSource taskCompletionSource = this.f5296b;
        if (!zM) {
            taskCompletionSource.setException(I.k(status));
            return;
        }
        taskCompletionSource.setResult(this.f5297c.b(this.f5295a.await(0L, TimeUnit.MILLISECONDS)));
    }
}
