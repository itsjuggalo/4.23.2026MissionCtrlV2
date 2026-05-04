package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class be extends w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f5943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f5944b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bn bnVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.f5943a = context;
        this.f5944b = bnVar;
    }

    @Override // n6.w0
    public final void b() {
        this.f5944b.f5970d.trySetResult(Integer.valueOf(n6.j.a(this.f5943a)));
    }
}
