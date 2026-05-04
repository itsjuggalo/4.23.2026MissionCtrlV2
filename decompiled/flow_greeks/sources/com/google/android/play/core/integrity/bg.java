package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.integrity.StandardIntegrityManager;
import n6.l0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class bg extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StandardIntegrityManager.StandardIntegrityTokenRequest f5948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f5949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f5950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f5951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f5952e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bn bnVar, TaskCompletionSource taskCompletionSource, int i10, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest, long j10, long j11, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f5948a = standardIntegrityTokenRequest;
        this.f5949b = j10;
        this.f5950c = j11;
        this.f5951d = taskCompletionSource2;
        this.f5952e = bnVar;
    }

    @Override // n6.w0
    public final void b() {
        if (bn.l(this.f5952e)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        if (bn.k(this.f5952e, 0)) {
            super.a(new StandardIntegrityException(-14, null));
            return;
        }
        try {
            bn bnVar = this.f5952e;
            ((l0) bnVar.f5967a.e()).b(bn.a(bnVar, this.f5948a, this.f5949b, this.f5950c, 0), new bk(this.f5952e, this.f5951d, this.f5949b));
        } catch (RemoteException e10) {
            this.f5952e.f5968b.c(e10, "requestExpressIntegrityToken(%s, %s, %s)", this.f5948a.requestHash(), this.f5948a.verdictOptOut(), Long.valueOf(this.f5949b));
            this.f5951d.trySetException(new StandardIntegrityException(-100, e10));
        }
    }
}
