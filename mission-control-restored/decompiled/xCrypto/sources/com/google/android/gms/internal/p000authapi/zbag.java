package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import r1.InterfaceC1747d;
import r1.h;
import r1.i;
import r1.j;
import r1.t;

/* JADX INFO: loaded from: classes.dex */
public final class zbag extends e implements InterfaceC1747d {
    private static final a.g zba;
    private static final a.AbstractC0145a zbb;
    private static final a zbc;
    private final String zbd;

    static {
        a.g gVar = new a.g();
        zba = gVar;
        zbad zbadVar = new zbad();
        zbb = zbadVar;
        zbc = new a("Auth.Api.Identity.CredentialSaving.API", zbadVar, gVar);
    }

    public zbag(Activity activity, t tVar) {
        super(activity, zbc, (a.d) tVar, e.a.f9668c);
        this.zbd = zbat.zba();
    }

    public final Status getStatusFromIntent(Intent intent) {
        if (intent == null) {
            return Status.f9655h;
        }
        Status status = (Status) A1.e.b(intent, "status", Status.CREATOR);
        return status == null ? Status.f9655h : status;
    }

    public final Task<h> saveAccountLinkingToken(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        AbstractC0940s.k(saveAccountLinkingTokenRequest);
        SaveAccountLinkingTokenRequest.a aVarO = SaveAccountLinkingTokenRequest.o(saveAccountLinkingTokenRequest);
        aVarO.f(this.zbd);
        final SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequestA = aVarO.a();
        return doRead(AbstractC0920y.a().d(zbas.zbg).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api.zbab
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zbn) ((zbh) obj).getService()).zbc(new zbae(this.zba, (TaskCompletionSource) obj2), (SaveAccountLinkingTokenRequest) AbstractC0940s.k(saveAccountLinkingTokenRequestA));
            }
        }).c(false).e(1535).a());
    }

    @Override // r1.InterfaceC1747d
    public final Task<j> savePassword(i iVar) {
        AbstractC0940s.k(iVar);
        i.a aVarL = i.l(iVar);
        aVarL.c(this.zbd);
        final i iVarA = aVarL.a();
        return doRead(AbstractC0920y.a().d(zbas.zbe).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api.zbac
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zbn) ((zbh) obj).getService()).zbd(new zbaf(this.zba, (TaskCompletionSource) obj2), (i) AbstractC0940s.k(iVarA));
            }
        }).c(false).e(1536).a());
    }

    public zbag(Context context, t tVar) {
        super(context, zbc, tVar, e.a.f9668c);
        this.zbd = zbat.zba();
    }
}
