package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class ai extends S1.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aj f5338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S1.z f5339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f5340c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(aj ajVar, TaskCompletionSource taskCompletionSource) {
        super("com.google.android.play.core.integrity.protocol.IIntegrityServiceCallback");
        this.f5338a = ajVar;
        this.f5339b = new S1.z("OnRequestIntegrityTokenCallback");
        this.f5340c = taskCompletionSource;
    }

    @Override // S1.w
    public final void b(Bundle bundle) {
        this.f5338a.f5341a.d(this.f5340c);
        this.f5339b.b("onRequestIntegrityToken", new Object[0]);
        com.google.android.gms.common.api.j jVarA = this.f5338a.e.a(bundle);
        if (jVarA != null) {
            this.f5340c.trySetException(jVarA);
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f5340c.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        ah ahVar = new ah(this, this.f5338a.f5343c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f5340c;
        a aVar = new a();
        aVar.b(string);
        aVar.a(ahVar);
        taskCompletionSource.trySetResult(aVar.c());
    }
}
