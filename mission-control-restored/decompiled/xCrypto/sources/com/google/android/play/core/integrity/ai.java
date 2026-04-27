package com.google.android.play.core.integrity;

import X1.C;
import X1.G;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class ai extends C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aj f10085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final G f10086b = new G("OnRequestIntegrityTokenCallback");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f10087c;

    public ai(aj ajVar, TaskCompletionSource taskCompletionSource) {
        this.f10085a = ajVar;
        this.f10087c = taskCompletionSource;
    }

    @Override // X1.D
    public final void b(Bundle bundle) {
        this.f10085a.f10088a.v(this.f10087c);
        this.f10086b.d("onRequestIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.b bVarA = this.f10085a.f10092e.a(bundle);
        if (bVarA != null) {
            this.f10087c.trySetException(bVarA);
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f10087c.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        ah ahVar = new ah(this, this.f10085a.f10090c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f10087c;
        a aVar = new a();
        aVar.b(string);
        aVar.a(ahVar);
        taskCompletionSource.trySetResult(aVar.c());
    }
}
