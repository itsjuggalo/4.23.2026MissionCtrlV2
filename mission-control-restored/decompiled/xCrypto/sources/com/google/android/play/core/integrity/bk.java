package com.google.android.play.core.integrity;

import X1.G;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bk extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f10145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final G f10146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f10147e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bn bnVar, TaskCompletionSource taskCompletionSource, long j4) {
        super(bnVar, taskCompletionSource);
        this.f10145c = bnVar;
        this.f10146d = new G("OnRequestIntegrityTokenCallback");
        this.f10147e = j4;
    }

    @Override // com.google.android.play.core.integrity.bi, X1.y
    public final void c(Bundle bundle) {
        super.c(bundle);
        this.f10146d.d("onRequestExpressIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.b bVarA = this.f10145c.f10156f.a(bundle);
        if (bVarA != null) {
            this.f10142a.trySetException(bVarA);
            return;
        }
        bj bjVar = new bj(this, this.f10145c.f10153c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f10142a;
        b bVar = new b();
        bVar.b(bundle.getString("token"));
        bVar.a(bjVar);
        taskCompletionSource.trySetResult(bVar.c());
    }
}
