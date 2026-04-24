package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bk extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f5394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final S1.z f5395d;
    private final long e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bn bnVar, TaskCompletionSource taskCompletionSource, long j4) {
        super(bnVar, taskCompletionSource);
        this.f5394c = bnVar;
        this.f5395d = new S1.z("OnRequestIntegrityTokenCallback");
        this.e = j4;
    }

    @Override // com.google.android.play.core.integrity.bi, S1.r
    public final void c(Bundle bundle) {
        super.c(bundle);
        this.f5395d.b("onRequestExpressIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.j jVarA = this.f5394c.f5403f.a(bundle);
        if (jVarA != null) {
            this.f5391a.trySetException(jVarA);
            return;
        }
        bj bjVar = new bj(this, this.f5394c.f5401c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f5391a;
        b bVar = new b();
        bVar.b(bundle.getString("token"));
        bVar.a(bjVar);
        taskCompletionSource.trySetResult(bVar.c());
    }
}
