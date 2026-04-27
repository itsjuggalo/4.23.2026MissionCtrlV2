package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import r1.C1744a;
import r1.n;
import r1.o;

/* JADX INFO: loaded from: classes.dex */
public final class zbaa extends e {
    private static final a.g zba;
    private static final a.AbstractC0145a zbb;
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
        super(activity, aVar, (a.d) nVarC.b(), e.a.f9668c);
    }

    public final Task<C1744a> authorize(AuthorizationRequest authorizationRequest) {
        AbstractC0940s.k(authorizationRequest);
        AuthorizationRequest.a aVarQ = AuthorizationRequest.q(authorizationRequest);
        aVarQ.g(((o) getApiOptions()).b());
        final AuthorizationRequest authorizationRequestA = aVarQ.a();
        return doRead(AbstractC0920y.a().d(zbas.zbc).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api.zbx
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zbk) ((zbg) obj).getService()).zbc(new zbz(this.zba, (TaskCompletionSource) obj2), (AuthorizationRequest) AbstractC0940s.k(authorizationRequestA));
            }
        }).c(false).e(1534).a());
    }

    public final C1744a getAuthorizationResultFromIntent(Intent intent) throws b {
        if (intent == null) {
            throw new b(Status.f9655h);
        }
        Status status = (Status) A1.e.b(intent, "status", Status.CREATOR);
        if (status == null) {
            throw new b(Status.f9657j);
        }
        if (!status.o()) {
            throw new b(status);
        }
        C1744a c1744a = (C1744a) A1.e.b(intent, "authorization_result", C1744a.CREATOR);
        if (c1744a != null) {
            return c1744a;
        }
        throw new b(Status.f9655h);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zbaa(Context context, o oVar) {
        a aVar = zbc;
        n nVarC = n.c(oVar);
        nVarC.a(zbat.zba());
        super(context, aVar, nVarC.b(), e.a.f9668c);
    }
}
