package com.google.android.play.core.integrity;

import F2.G;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bl extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f11931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final G f11932d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(bnVar, taskCompletionSource);
        this.f11931c = bnVar;
        this.f11932d = new G("OnWarmUpIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.bi, F2.y
    public final void e(Bundle bundle) {
        super.e(bundle);
        this.f11932d.d("onWarmUpExpressIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.b bVarA = this.f11931c.f11939f.a(bundle);
        if (bVarA != null) {
            this.f11925a.trySetException(bVarA);
        } else {
            this.f11925a.trySetResult(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
