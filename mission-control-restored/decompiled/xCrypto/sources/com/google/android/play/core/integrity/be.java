package com.google.android.play.core.integrity;

import X1.AbstractC0749j;
import X1.H;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class be extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f10128b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bn bnVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.f10128b = bnVar;
        this.f10127a = context;
    }

    @Override // X1.H
    public final void b() {
        this.f10128b.f10154d.trySetResult(Integer.valueOf(AbstractC0749j.a(this.f10127a)));
    }
}
