package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.q0;
import n6.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class ag extends w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f5896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f5897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f5898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f5899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ aj f5900e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(aj ajVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i10) {
        super(taskCompletionSource);
        this.f5896a = bundle;
        this.f5897b = activity;
        this.f5898c = taskCompletionSource2;
        this.f5899d = i10;
        this.f5900e = ajVar;
    }

    @Override // n6.w0
    public final void b() {
        try {
            q0 q0Var = (q0) this.f5900e.f5905a.e();
            Bundle bundle = this.f5896a;
            aj ajVar = this.f5900e;
            q0Var.a(bundle, ajVar.f5909e.a(this.f5897b, this.f5898c, ajVar.f5905a));
        } catch (RemoteException e10) {
            this.f5900e.f5906b.c(e10, "requestAndShowDialog(%s)", Integer.valueOf(this.f5899d));
            this.f5898c.trySetException(new IntegrityServiceException(-100, e10));
        }
    }
}
