package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.m0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
class bi extends m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f5958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f5959b;

    public bi(bn bnVar, TaskCompletionSource taskCompletionSource) {
        this.f5959b = bnVar;
        this.f5958a = taskCompletionSource;
    }

    @Override // n6.n0
    public final void b(Bundle bundle) {
        this.f5959b.f5967a.v(this.f5958a);
    }

    @Override // n6.n0
    public void c(Bundle bundle) {
        this.f5959b.f5967a.v(this.f5958a);
    }

    @Override // n6.n0
    public final void d(Bundle bundle) {
        this.f5959b.f5967a.v(this.f5958a);
    }

    @Override // n6.n0
    public void e(Bundle bundle) {
        this.f5959b.f5967a.v(this.f5958a);
    }
}
