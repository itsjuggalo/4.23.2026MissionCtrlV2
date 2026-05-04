package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import n6.r0;
import n6.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class ai extends r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aj f5902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v0 f5903b = new v0("OnRequestIntegrityTokenCallback");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f5904c;

    public ai(aj ajVar, TaskCompletionSource taskCompletionSource) {
        this.f5902a = ajVar;
        this.f5904c = taskCompletionSource;
    }

    @Override // n6.s0
    public final void b(Bundle bundle) {
        this.f5902a.f5905a.v(this.f5904c);
        this.f5903b.d("onRequestIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.b bVarA = this.f5902a.f5910f.a(bundle);
        if (bVarA != null) {
            this.f5904c.trySetException(bVarA);
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f5904c.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        ah ahVar = new ah(this, this.f5902a.f5907c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f5904c;
        a aVar = new a();
        aVar.b(string);
        aVar.a(ahVar);
        taskCompletionSource.trySetResult(aVar.c());
    }
}
