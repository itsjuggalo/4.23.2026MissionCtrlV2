package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bg extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f10132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f10133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f10134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f10135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f10136e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bn bnVar, TaskCompletionSource taskCompletionSource, int i4, String str, long j4, long j5, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f10136e = bnVar;
        this.f10132a = str;
        this.f10133b = j4;
        this.f10134c = j5;
        this.f10135d = taskCompletionSource2;
    }

    @Override // X1.H
    public final void b() {
        if (bn.k(this.f10136e)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f10136e;
            ((X1.w) bnVar.f10151a.e()).J(bn.a(bnVar, this.f10132a, this.f10133b, this.f10134c, 0), new bk(this.f10136e, this.f10135d, this.f10133b));
        } catch (RemoteException e4) {
            this.f10136e.f10152b.c(e4, "requestExpressIntegrityToken(%s, %s)", this.f10132a, Long.valueOf(this.f10133b));
            this.f10135d.trySetException(new StandardIntegrityException(-100, e4));
        }
    }
}
