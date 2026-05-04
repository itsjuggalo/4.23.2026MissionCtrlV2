package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.l0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class bf extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f5945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f5946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f5947c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(bn bnVar, TaskCompletionSource taskCompletionSource, int i10, long j10, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f5945a = j10;
        this.f5946b = taskCompletionSource2;
        this.f5947c = bnVar;
    }

    @Override // n6.w0
    public final void b() {
        if (bn.l(this.f5947c)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        if (bn.k(this.f5947c, 0)) {
            super.a(new StandardIntegrityException(-14, null));
            return;
        }
        try {
            bn bnVar = this.f5947c;
            ((l0) bnVar.f5967a.e()).m(bn.b(bnVar, this.f5945a, 0), new bl(this.f5947c, this.f5946b));
        } catch (RemoteException e10) {
            this.f5947c.f5968b.c(e10, "warmUpIntegrityToken(%s)", Long.valueOf(this.f5945a));
            this.f5946b.trySetException(new StandardIntegrityException(-100, e10));
        }
    }
}
