package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bl extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f5396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final S1.z f5397d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(bnVar, taskCompletionSource);
        this.f5396c = bnVar;
        this.f5397d = new S1.z("OnWarmUpIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.bi, S1.r
    public final void e(Bundle bundle) {
        super.e(bundle);
        this.f5397d.b("onWarmUpExpressIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.j jVarA = this.f5396c.f5403f.a(bundle);
        if (jVarA != null) {
            this.f5391a.trySetException(jVarA);
        } else {
            this.f5391a.trySetResult(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
