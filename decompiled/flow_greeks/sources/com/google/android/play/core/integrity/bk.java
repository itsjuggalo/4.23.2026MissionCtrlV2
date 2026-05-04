package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class bk extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f5961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v0 f5962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f5963e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bn bnVar, TaskCompletionSource taskCompletionSource, long j10) {
        super(bnVar, taskCompletionSource);
        this.f5961c = bnVar;
        this.f5962d = new v0("OnRequestIntegrityTokenCallback");
        this.f5963e = j10;
    }

    @Override // com.google.android.play.core.integrity.bi, n6.n0
    public final void c(Bundle bundle) {
        super.c(bundle);
        this.f5962d.d("onRequestExpressIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.b bVarA = this.f5961c.f5972f.a(bundle);
        if (bVarA != null) {
            this.f5958a.trySetException(bVarA);
            return;
        }
        bj bjVar = new bj(this, this.f5961c.f5969c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f5958a;
        b bVar = new b();
        bVar.b(bundle.getString("token"));
        bVar.a(bjVar);
        taskCompletionSource.trySetResult(bVar.c());
    }
}
