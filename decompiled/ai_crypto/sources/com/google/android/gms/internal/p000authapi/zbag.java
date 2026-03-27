package com.google.android.gms.internal.p000authapi;

import I1.InterfaceC0579d;
import I1.h;
import I1.i;
import I1.j;
import I1.t;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC1186x;
import com.google.android.gms.common.api.internal.InterfaceC1181s;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zbag extends e implements InterfaceC0579d {
    private static final a.g zba;
    private static final a.AbstractC0178a zbb;
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
        super(activity, zbc, (a.d) tVar, e.a.f10853c);
        this.zbd = zbat.zba();
    }

    public final Status getStatusFromIntent(Intent intent) {
        if (intent == null) {
            return Status.f10840h;
        }
        Status status = (Status) Q1.e.b(intent, "status", Status.CREATOR);
        return status == null ? Status.f10840h : status;
    }

    public final Task<h> saveAccountLinkingToken(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        AbstractC1207s.k(saveAccountLinkingTokenRequest);
        SaveAccountLinkingTokenRequest.a aVarF = SaveAccountLinkingTokenRequest.F(saveAccountLinkingTokenRequest);
        aVarF.f(this.zbd);
        final SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequestA = aVarF.a();
        return doRead(AbstractC1186x.a().d(zbas.zbg).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api.zbab
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                ((zbn) ((zbh) obj).getService()).zbc(new zbae(this.zba, (TaskCompletionSource) obj2), (SaveAccountLinkingTokenRequest) AbstractC1207s.k(saveAccountLinkingTokenRequestA));
            }
        }).c(false).e(1535).a());
    }

    @Override // I1.InterfaceC0579d
    public final Task<j> savePassword(i iVar) {
        AbstractC1207s.k(iVar);
        i.a aVarC = i.C(iVar);
        aVarC.c(this.zbd);
        final i iVarA = aVarC.a();
        return doRead(AbstractC1186x.a().d(zbas.zbe).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api.zbac
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                ((zbn) ((zbh) obj).getService()).zbd(new zbaf(this.zba, (TaskCompletionSource) obj2), (i) AbstractC1207s.k(iVarA));
            }
        }).c(false).e(1536).a());
    }

    public zbag(Context context, t tVar) {
        super(context, zbc, tVar, e.a.f10853c);
        this.zbd = zbat.zba();
    }
}
