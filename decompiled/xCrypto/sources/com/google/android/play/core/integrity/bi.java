package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
class bi extends X1.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f10142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f10143b;

    public bi(bn bnVar, TaskCompletionSource taskCompletionSource) {
        this.f10143b = bnVar;
        this.f10142a = taskCompletionSource;
    }

    @Override // X1.y
    public final void b(Bundle bundle) {
        this.f10143b.f10151a.v(this.f10142a);
    }

    @Override // X1.y
    public void c(Bundle bundle) {
        this.f10143b.f10151a.v(this.f10142a);
    }

    @Override // X1.y
    public final void d(Bundle bundle) {
        this.f10143b.f10151a.v(this.f10142a);
    }

    @Override // X1.y
    public void e(Bundle bundle) {
        this.f10143b.f10151a.v(this.f10142a);
    }
}
