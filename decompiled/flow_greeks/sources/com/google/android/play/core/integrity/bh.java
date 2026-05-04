package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.l0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class bh extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f5953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f5954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f5955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f5956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f5957e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(bn bnVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i10) {
        super(bnVar, taskCompletionSource);
        this.f5953a = bundle;
        this.f5954b = activity;
        this.f5955c = taskCompletionSource2;
        this.f5956d = i10;
        this.f5957e = bnVar;
    }

    @Override // n6.w0
    public final void b() {
        if (bn.l(this.f5957e)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f5957e;
            n6.f fVar = bnVar.f5967a;
            ((l0) fVar.e()).a(this.f5953a, bnVar.f5971e.a(this.f5954b, this.f5955c, fVar));
        } catch (RemoteException e10) {
            this.f5957e.f5968b.c(e10, "requestAndShowDialog(%s)", Integer.valueOf(this.f5956d));
            this.f5955c.trySetException(new StandardIntegrityException(-100, e10));
        }
    }
}
