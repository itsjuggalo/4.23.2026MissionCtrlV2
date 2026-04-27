package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bf extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f10130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f10131c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(bn bnVar, TaskCompletionSource taskCompletionSource, int i4, long j4, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f10131c = bnVar;
        this.f10129a = j4;
        this.f10130b = taskCompletionSource2;
    }

    @Override // X1.H
    public final void b() {
        if (bn.k(this.f10131c)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f10131c;
            ((X1.w) bnVar.f10151a.e()).N(bn.b(bnVar, this.f10129a, 0), new bl(this.f10131c, this.f10130b));
        } catch (RemoteException e4) {
            this.f10131c.f10152b.c(e4, "warmUpIntegrityToken(%s)", Long.valueOf(this.f10129a));
            this.f10130b.trySetException(new StandardIntegrityException(-100, e4));
        }
    }
}
