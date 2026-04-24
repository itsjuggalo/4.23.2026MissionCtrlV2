package com.google.android.play.core.integrity;

import F2.G;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bk extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f11928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final G f11929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f11930e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bn bnVar, TaskCompletionSource taskCompletionSource, long j7) {
        super(bnVar, taskCompletionSource);
        this.f11928c = bnVar;
        this.f11929d = new G("OnRequestIntegrityTokenCallback");
        this.f11930e = j7;
    }

    @Override // com.google.android.play.core.integrity.bi, F2.y
    public final void c(Bundle bundle) {
        super.c(bundle);
        this.f11929d.d("onRequestExpressIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.b bVarA = this.f11928c.f11939f.a(bundle);
        if (bVarA != null) {
            this.f11925a.trySetException(bVarA);
            return;
        }
        bj bjVar = new bj(this, this.f11928c.f11936c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f11925a;
        b bVar = new b();
        bVar.b(bundle.getString("token"));
        bVar.a(bjVar);
        taskCompletionSource.trySetResult(bVar.c());
    }
}
