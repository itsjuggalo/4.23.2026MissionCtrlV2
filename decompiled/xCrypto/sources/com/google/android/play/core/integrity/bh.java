package com.google.android.play.core.integrity;

import X1.C0745f;
import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bh extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f10137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f10138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f10139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f10140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f10141e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(bn bnVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i4) {
        super(bnVar, taskCompletionSource);
        this.f10141e = bnVar;
        this.f10137a = bundle;
        this.f10138b = activity;
        this.f10139c = taskCompletionSource2;
        this.f10140d = i4;
    }

    @Override // X1.H
    public final void b() {
        if (bn.k(this.f10141e)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f10141e;
            C0745f c0745f = bnVar.f10151a;
            ((X1.w) c0745f.e()).a(this.f10137a, bnVar.f10155e.a(this.f10138b, this.f10139c, c0745f));
        } catch (RemoteException e4) {
            this.f10141e.f10152b.c(e4, "requestAndShowDialog(%s)", Integer.valueOf(this.f10140d));
            this.f10139c.trySetException(new StandardIntegrityException(-100, e4));
        }
    }
}
