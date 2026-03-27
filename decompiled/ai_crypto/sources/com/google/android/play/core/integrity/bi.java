package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
class bi extends F2.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f11925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f11926b;

    public bi(bn bnVar, TaskCompletionSource taskCompletionSource) {
        this.f11926b = bnVar;
        this.f11925a = taskCompletionSource;
    }

    @Override // F2.y
    public final void b(Bundle bundle) {
        this.f11926b.f11934a.v(this.f11925a);
    }

    @Override // F2.y
    public void c(Bundle bundle) {
        this.f11926b.f11934a.v(this.f11925a);
    }

    @Override // F2.y
    public final void d(Bundle bundle) {
        this.f11926b.f11934a.v(this.f11925a);
    }

    @Override // F2.y
    public void e(Bundle bundle) {
        this.f11926b.f11934a.v(this.f11925a);
    }
}
