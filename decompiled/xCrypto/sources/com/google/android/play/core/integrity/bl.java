package com.google.android.play.core.integrity;

import X1.G;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class bl extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f10148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final G f10149d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(bnVar, taskCompletionSource);
        this.f10148c = bnVar;
        this.f10149d = new G("OnWarmUpIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.bi, X1.y
    public final void e(Bundle bundle) {
        super.e(bundle);
        this.f10149d.d("onWarmUpExpressIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.b bVarA = this.f10148c.f10156f.a(bundle);
        if (bVarA != null) {
            this.f10142a.trySetException(bVarA);
        } else {
            this.f10142a.trySetResult(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
