package com.google.android.play.core.integrity;

import F2.C0469g;
import F2.H;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
abstract class bm extends H {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ bn f11933f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(taskCompletionSource);
        this.f11933f = bnVar;
    }

    @Override // F2.H
    public final void a(Exception exc) {
        if (!(exc instanceof C0469g)) {
            super.a(exc);
        } else if (bn.k(this.f11933f)) {
            super.a(new StandardIntegrityException(-2, exc));
        } else {
            super.a(new StandardIntegrityException(-9, exc));
        }
    }
}
