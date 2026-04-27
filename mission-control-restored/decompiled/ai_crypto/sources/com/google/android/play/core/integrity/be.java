package com.google.android.play.core.integrity;

import F2.AbstractC0472j;
import F2.H;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class be extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f11911b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bn bnVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.f11911b = bnVar;
        this.f11910a = context;
    }

    @Override // F2.H
    public final void b() {
        this.f11911b.f11937d.trySetResult(Integer.valueOf(AbstractC0472j.a(this.f11910a)));
    }
}
