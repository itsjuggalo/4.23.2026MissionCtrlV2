package com.google.android.gms.internal.p000authapi;

import I1.C0576a;
import I1.n;
import I1.o;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC1186x;
import com.google.android.gms.common.api.internal.InterfaceC1181s;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zbaa extends e {
    private static final a.g zba;
    private static final a.AbstractC0178a zbb;
    private static final a zbc;

    static {
        a.g gVar = new a.g();
        zba = gVar;
        zby zbyVar = new zby();
        zbb = zbyVar;
        zbc = new a("Auth.Api.Identity.Authorization.API", zbyVar, gVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zbaa(Activity activity, o oVar) {
        a aVar = zbc;
        n nVarC = n.c(oVar);
        nVarC.a(zbat.zba());
        super(activity, aVar, (a.d) nVarC.b(), e.a.f10853c);
    }

    public final Task<C0576a> authorize(AuthorizationRequest authorizationRequest) {
        AbstractC1207s.k(authorizationRequest);
        AuthorizationRequest.a aVarH = AuthorizationRequest.H(authorizationRequest);
        aVarH.g(((o) getApiOptions()).b());
        final AuthorizationRequest authorizationRequestA = aVarH.a();
        return doRead(AbstractC1186x.a().d(zbas.zbc).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api.zbx
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                ((zbk) ((zbg) obj).getService()).zbc(new zbz(this.zba, (TaskCompletionSource) obj2), (AuthorizationRequest) AbstractC1207s.k(authorizationRequestA));
            }
        }).c(false).e(1534).a());
    }

    public final C0576a getAuthorizationResultFromIntent(Intent intent) throws b {
        if (intent == null) {
            throw new b(Status.f10840h);
        }
        Status status = (Status) Q1.e.b(intent, "status", Status.CREATOR);
        if (status == null) {
            throw new b(Status.f10842j);
        }
        if (!status.F()) {
            throw new b(status);
        }
        C0576a c0576a = (C0576a) Q1.e.b(intent, "authorization_result", C0576a.CREATOR);
        if (c0576a != null) {
            return c0576a;
        }
        throw new b(Status.f10840h);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zbaa(Context context, o oVar) {
        a aVar = zbc;
        n nVarC = n.c(oVar);
        nVarC.a(zbat.zba());
        super(context, aVar, nVarC.b(), e.a.f10853c);
    }
}
