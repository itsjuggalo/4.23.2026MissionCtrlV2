package com.google.android.play.core.integrity;

import S1.A;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
abstract class bm extends A {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ bn f5398f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(taskCompletionSource);
        this.f5398f = bnVar;
    }

    @Override // S1.A
    public final void a(Exception exc) {
        if (!(exc instanceof S1.f)) {
            super.a(exc);
        } else if (bn.k(this.f5398f)) {
            super.a(new StandardIntegrityException(-2, exc));
        } else {
            super.a(new StandardIntegrityException(-9, exc));
        }
    }
}
