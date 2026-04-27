package com.google.android.play.core.integrity;

import F2.C;
import F2.G;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class ai extends C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aj f11868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final G f11869b = new G("OnRequestIntegrityTokenCallback");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f11870c;

    public ai(aj ajVar, TaskCompletionSource taskCompletionSource) {
        this.f11868a = ajVar;
        this.f11870c = taskCompletionSource;
    }

    @Override // F2.D
    public final void b(Bundle bundle) {
        this.f11868a.f11871a.v(this.f11870c);
        this.f11869b.d("onRequestIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.b bVarA = this.f11868a.f11875e.a(bundle);
        if (bVarA != null) {
            this.f11870c.trySetException(bVarA);
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f11870c.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        ah ahVar = new ah(this, this.f11868a.f11873c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f11870c;
        a aVar = new a();
        aVar.b(string);
        aVar.a(ahVar);
        taskCompletionSource.trySetResult(aVar.c());
    }
}
