package com.google.android.play.core.integrity;

import F2.C0468f;
import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bh extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f11920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f11921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f11922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f11923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f11924e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(bn bnVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i7) {
        super(bnVar, taskCompletionSource);
        this.f11924e = bnVar;
        this.f11920a = bundle;
        this.f11921b = activity;
        this.f11922c = taskCompletionSource2;
        this.f11923d = i7;
    }

    @Override // F2.H
    public final void b() {
        if (bn.k(this.f11924e)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f11924e;
            C0468f c0468f = bnVar.f11934a;
            ((F2.w) c0468f.e()).a(this.f11920a, bnVar.f11938e.a(this.f11921b, this.f11922c, c0468f));
        } catch (RemoteException e7) {
            this.f11924e.f11935b.c(e7, "requestAndShowDialog(%s)", Integer.valueOf(this.f11923d));
            this.f11922c.trySetException(new StandardIntegrityException(-100, e7));
        }
    }
}
