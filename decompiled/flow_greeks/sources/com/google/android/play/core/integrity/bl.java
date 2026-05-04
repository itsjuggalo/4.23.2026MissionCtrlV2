package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class bl extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f5964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v0 f5965d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(bnVar, taskCompletionSource);
        this.f5964c = bnVar;
        this.f5965d = new v0("OnWarmUpIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.bi, n6.n0
    public final void e(Bundle bundle) {
        super.e(bundle);
        this.f5965d.d("onWarmUpExpressIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.b bVarA = this.f5964c.f5972f.a(bundle);
        if (bVarA != null) {
            this.f5958a.trySetException(bVarA);
        } else {
            this.f5958a.trySetResult(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
