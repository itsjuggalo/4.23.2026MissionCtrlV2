package com.google.android.play.core.integrity;

import X1.B;
import X1.H;
import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class ag extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f10079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f10080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f10081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f10082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ aj f10083e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(aj ajVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i4) {
        super(taskCompletionSource);
        this.f10083e = ajVar;
        this.f10079a = bundle;
        this.f10080b = activity;
        this.f10081c = taskCompletionSource2;
        this.f10082d = i4;
    }

    @Override // X1.H
    public final void b() {
        try {
            B b4 = (B) this.f10083e.f10088a.e();
            Bundle bundle = this.f10079a;
            aj ajVar = this.f10083e;
            b4.a(bundle, ajVar.f10091d.a(this.f10080b, this.f10081c, ajVar.f10088a));
        } catch (RemoteException e4) {
            this.f10083e.f10089b.c(e4, "requestAndShowDialog(%s)", Integer.valueOf(this.f10082d));
            this.f10081c.trySetException(new IntegrityServiceException(-100, e4));
        }
    }
}
