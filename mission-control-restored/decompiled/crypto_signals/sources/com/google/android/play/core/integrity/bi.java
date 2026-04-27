package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
class bi extends S1.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f5391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f5392b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super("com.google.android.play.core.integrity.protocol.IExpressIntegrityServiceCallback");
        this.f5392b = bnVar;
        this.f5391a = taskCompletionSource;
    }

    @Override // S1.r
    public final void b(Bundle bundle) {
        this.f5392b.f5399a.d(this.f5391a);
    }

    @Override // S1.r
    public void c(Bundle bundle) {
        this.f5392b.f5399a.d(this.f5391a);
    }

    @Override // S1.r
    public final void d(Bundle bundle) {
        this.f5392b.f5399a.d(this.f5391a);
    }

    @Override // S1.r
    public void e(Bundle bundle) {
        this.f5392b.f5399a.d(this.f5391a);
    }
}
