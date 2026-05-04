package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import c5.c;
import c5.d;
import c5.g;
import c5.h;
import c5.j0;
import c5.m;
import c5.n;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import n5.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zbat extends f implements m {
    private static final a.g zba;
    private static final a.AbstractC0094a zbb;
    private static final a zbc;
    private final String zbd;

    static {
        a.g gVar = new a.g();
        zba = gVar;
        zbak zbakVar = new zbak();
        zbb = zbakVar;
        zbc = new a("Auth.Api.Identity.SignIn.API", zbakVar, gVar);
    }

    public zbat(Activity activity, j0 j0Var) {
        super(activity, zbc, (a.d) j0Var, f.a.f5486c);
        this.zbd = zbaw.zba();
    }

    @Override // c5.m
    public final Task<d> beginSignIn(c cVar) {
        s.k(cVar);
        c.a aVarY = c.Y(cVar);
        aVarY.h(this.zbd);
        final c cVarA = aVarY.a();
        return doRead(v.a().d(new m5.d("auth_api_credentials_begin_sign_in", 8L)).b(new q() { // from class: com.google.android.gms.internal.auth-api.zbas
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                zbau zbauVar = (zbau) obj;
                ((zbv) zbauVar.getService()).zbc(new zbal(this.zba, (TaskCompletionSource) obj2), (c) s.k(cVarA), zbaz.zba(zbauVar.getContext()));
            }
        }).c(false).e(1553).a());
    }

    public final String getPhoneNumberFromIntent(Intent intent) throws b {
        if (intent == null) {
            throw new b(Status.f5457h);
        }
        Status status = (Status) e.b(intent, "status", Status.CREATOR);
        if (status == null) {
            throw new b(Status.f5459j);
        }
        if (!status.V()) {
            throw new b(status);
        }
        String stringExtra = intent.getStringExtra("phone_number_hint_result");
        if (stringExtra != null) {
            return stringExtra;
        }
        throw new b(Status.f5457h);
    }

    public final Task<PendingIntent> getPhoneNumberHintIntent(final g gVar) {
        s.k(gVar);
        return doRead(v.a().d(zbav.zbi).b(new q() { // from class: com.google.android.gms.internal.auth-api.zbar
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                this.zba.zbb(gVar, (zbau) obj, (TaskCompletionSource) obj2);
            }
        }).e(1653).a());
    }

    @Override // c5.m
    public final n getSignInCredentialFromIntent(Intent intent) throws b {
        if (intent == null) {
            throw new b(Status.f5457h);
        }
        Status status = (Status) e.b(intent, "status", Status.CREATOR);
        if (status == null) {
            throw new b(Status.f5459j);
        }
        if (!status.V()) {
            throw new b(status);
        }
        n nVar = (n) e.b(intent, "sign_in_credential", n.CREATOR);
        if (nVar != null) {
            return nVar;
        }
        throw new b(Status.f5457h);
    }

    @Override // c5.m
    public final Task<PendingIntent> getSignInIntent(h hVar) {
        s.k(hVar);
        h.a aVarX = h.X(hVar);
        aVarX.g(this.zbd);
        final h hVarA = aVarX.a();
        return doRead(v.a().d(zbav.zbg).b(new q() { // from class: com.google.android.gms.internal.auth-api.zbaq
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                zbau zbauVar = (zbau) obj;
                ((zbv) zbauVar.getService()).zbe(new zban(this.zba, (TaskCompletionSource) obj2), (h) s.k(hVarA), zbaz.zba(zbauVar.getContext()));
            }
        }).e(1555).a());
    }

    @Override // c5.m
    public final Task<Void> signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        Iterator it = com.google.android.gms.common.api.g.c().iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.g) it.next()).h();
        }
        com.google.android.gms.common.api.internal.g.a();
        return doWrite(v.a().d(zbav.zbb).b(new q() { // from class: com.google.android.gms.internal.auth-api.zbap
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                this.zba.zba((zbau) obj, (TaskCompletionSource) obj2);
            }
        }).c(false).e(1554).a());
    }

    public final /* synthetic */ void zba(zbau zbauVar, TaskCompletionSource taskCompletionSource) {
        zbam zbamVar = new zbam(this, taskCompletionSource);
        ((zbv) zbauVar.getService()).zbd(zbamVar, this.zbd, zbaz.zba(zbauVar.getContext()));
    }

    public final /* synthetic */ void zbb(g gVar, zbau zbauVar, TaskCompletionSource taskCompletionSource) {
        zbao zbaoVar = new zbao(this, taskCompletionSource);
        ((zbv) zbauVar.getService()).zbf(zbaoVar, gVar, this.zbd, zbaz.zba(zbauVar.getContext()));
    }

    public zbat(Context context, j0 j0Var) {
        super(context, zbc, j0Var, f.a.f5486c);
        this.zbd = zbaw.zba();
    }
}
