package com.google.android.play.core.integrity;

import F2.B;
import F2.H;
import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class ag extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f11862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f11863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f11864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f11865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ aj f11866e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(aj ajVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i7) {
        super(taskCompletionSource);
        this.f11866e = ajVar;
        this.f11862a = bundle;
        this.f11863b = activity;
        this.f11864c = taskCompletionSource2;
        this.f11865d = i7;
    }

    @Override // F2.H
    public final void b() {
        try {
            B b7 = (B) this.f11866e.f11871a.e();
            Bundle bundle = this.f11862a;
            aj ajVar = this.f11866e;
            b7.a(bundle, ajVar.f11874d.a(this.f11863b, this.f11864c, ajVar.f11871a));
        } catch (RemoteException e7) {
            this.f11866e.f11872b.c(e7, "requestAndShowDialog(%s)", Integer.valueOf(this.f11865d));
            this.f11864c.trySetException(new IntegrityServiceException(-100, e7));
        }
    }
}
