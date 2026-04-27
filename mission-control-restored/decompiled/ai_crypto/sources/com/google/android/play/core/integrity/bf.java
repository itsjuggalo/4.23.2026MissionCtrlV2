package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bf extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f11912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f11913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f11914c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(bn bnVar, TaskCompletionSource taskCompletionSource, int i7, long j7, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f11914c = bnVar;
        this.f11912a = j7;
        this.f11913b = taskCompletionSource2;
    }

    @Override // F2.H
    public final void b() {
        if (bn.k(this.f11914c)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f11914c;
            ((F2.w) bnVar.f11934a.e()).K(bn.b(bnVar, this.f11912a, 0), new bl(this.f11914c, this.f11913b));
        } catch (RemoteException e7) {
            this.f11914c.f11935b.c(e7, "warmUpIntegrityToken(%s)", Long.valueOf(this.f11912a));
            this.f11913b.trySetException(new StandardIntegrityException(-100, e7));
        }
    }
}
