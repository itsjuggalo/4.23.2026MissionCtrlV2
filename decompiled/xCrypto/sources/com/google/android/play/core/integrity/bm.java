package com.google.android.play.core.integrity;

import X1.C0746g;
import X1.H;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
abstract class bm extends H {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ bn f10150f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(taskCompletionSource);
        this.f10150f = bnVar;
    }

    @Override // X1.H
    public final void a(Exception exc) {
        if (!(exc instanceof C0746g)) {
            super.a(exc);
        } else if (bn.k(this.f10150f)) {
            super.a(new StandardIntegrityException(-2, exc));
        } else {
            super.a(new StandardIntegrityException(-9, exc));
        }
    }
}
