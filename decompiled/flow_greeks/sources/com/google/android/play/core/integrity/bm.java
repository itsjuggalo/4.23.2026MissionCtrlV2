package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.TaskCompletionSource;
import n6.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
abstract class bm extends w0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ bn f5966f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(taskCompletionSource);
        this.f5966f = bnVar;
    }

    @Override // n6.w0
    public final void a(Exception exc) {
        if (!(exc instanceof n6.g)) {
            super.a(exc);
        } else if (bn.l(this.f5966f)) {
            super.a(new StandardIntegrityException(-2, exc));
        } else {
            super.a(new StandardIntegrityException(-9, exc));
        }
    }
}
