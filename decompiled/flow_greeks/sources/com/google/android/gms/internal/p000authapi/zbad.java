package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import c5.a;
import c5.b;
import c5.p;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.ClearTokenRequest;
import com.google.android.gms.auth.api.identity.RevokeAccessRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import n5.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zbad extends f implements a {
    private static final a.g zba;
    private static final a.AbstractC0094a zbb;
    private static final com.google.android.gms.common.api.a zbc;
    private final String zbd;

    static {
        a.g gVar = new a.g();
        zba = gVar;
        zbw zbwVar = new zbw();
        zbb = zbwVar;
        zbc = new com.google.android.gms.common.api.a("Auth.Api.Identity.Authorization.API", zbwVar, gVar);
    }

    public zbad(Activity activity, p pVar) {
        super(activity, zbc, (a.d) pVar, f.a.f5486c);
        this.zbd = zbaw.zba();
    }

    @Override // c5.a
    public final Task<b> authorize(AuthorizationRequest authorizationRequest) {
        s.k(authorizationRequest);
        AuthorizationRequest.a aVarA0 = AuthorizationRequest.a0(authorizationRequest);
        aVarA0.i(this.zbd);
        final AuthorizationRequest authorizationRequestB = aVarA0.b();
        return doRead(v.a().d(zbav.zbc).b(new q() { // from class: com.google.android.gms.internal.auth-api.zbac
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                zbf zbfVar = (zbf) obj;
                ((zbj) zbfVar.getService()).zbc(new zbx(this.zba, (TaskCompletionSource) obj2), (AuthorizationRequest) s.k(authorizationRequestB), zbaz.zba(zbfVar.getContext()));
            }
        }).c(false).e(1534).a());
    }

    @Override // c5.a
    public final Task<Void> clearToken(ClearTokenRequest clearTokenRequest) {
        s.k(clearTokenRequest);
        ClearTokenRequest.a aVarU = clearTokenRequest.U();
        aVarU.c(this.zbd);
        final ClearTokenRequest clearTokenRequestA = aVarU.a();
        return doWrite(v.a().d(zbav.zbe).b(new q() { // from class: com.google.android.gms.internal.auth-api.zbab
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                zbf zbfVar = (zbf) obj;
                ((zbj) zbfVar.getService()).zbe(new zbz(this.zba, (TaskCompletionSource) obj2), (ClearTokenRequest) s.k(clearTokenRequestA), zbaz.zba(zbfVar.getContext()));
            }
        }).c(true).e(1721).a());
    }

    @Override // c5.a
    public final b getAuthorizationResultFromIntent(Intent intent) throws com.google.android.gms.common.api.b {
        if (intent == null) {
            throw new com.google.android.gms.common.api.b(Status.f5457h);
        }
        Status status = (Status) e.b(intent, "status", Status.CREATOR);
        if (status == null) {
            throw new com.google.android.gms.common.api.b(Status.f5459j);
        }
        if (!status.V()) {
            throw new com.google.android.gms.common.api.b(status);
        }
        b bVar = (b) e.b(intent, "authorization_result", b.CREATOR);
        if (bVar != null) {
            return bVar;
        }
        throw new com.google.android.gms.common.api.b(Status.f5457h);
    }

    @Override // c5.a
    public final Task<Void> revokeAccess(RevokeAccessRequest revokeAccessRequest) {
        s.k(revokeAccessRequest);
        RevokeAccessRequest.a aVarV = revokeAccessRequest.V();
        aVarV.d(this.zbd);
        final RevokeAccessRequest revokeAccessRequestA = aVarV.a();
        return doWrite(v.a().d(zbav.zbd).b(new q() { // from class: com.google.android.gms.internal.auth-api.zbaa
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                zbf zbfVar = (zbf) obj;
                ((zbj) zbfVar.getService()).zbd(new zby(this.zba, (TaskCompletionSource) obj2), (RevokeAccessRequest) s.k(revokeAccessRequestA), zbaz.zba(zbfVar.getContext()));
            }
        }).c(true).e(1721).a());
    }

    public zbad(Context context, p pVar) {
        super(context, zbc, pVar, f.a.f5486c);
        this.zbd = zbaw.zba();
    }
}
