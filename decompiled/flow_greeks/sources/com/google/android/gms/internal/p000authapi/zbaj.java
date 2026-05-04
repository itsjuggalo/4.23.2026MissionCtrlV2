package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import c5.j;
import c5.k;
import c5.l;
import c5.w;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
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
public final class zbaj extends f implements c5.f {
    private static final a.g zba;
    private static final a.AbstractC0094a zbb;
    private static final a zbc;
    private final String zbd;

    static {
        a.g gVar = new a.g();
        zba = gVar;
        zbae zbaeVar = new zbae();
        zbb = zbaeVar;
        zbc = new a("Auth.Api.Identity.CredentialSaving.API", zbaeVar, gVar);
    }

    public zbaj(Activity activity, w wVar) {
        super(activity, zbc, (a.d) wVar, f.a.f5486c);
        this.zbd = zbaw.zba();
    }

    public final Status getStatusFromIntent(Intent intent) {
        if (intent == null) {
            return Status.f5457h;
        }
        Status status = (Status) e.b(intent, "status", Status.CREATOR);
        return status == null ? Status.f5457h : status;
    }

    public final Task<j> saveAccountLinkingToken(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        s.k(saveAccountLinkingTokenRequest);
        SaveAccountLinkingTokenRequest.a aVarW = SaveAccountLinkingTokenRequest.W(saveAccountLinkingTokenRequest);
        aVarW.f(this.zbd);
        final SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequestA = aVarW.a();
        return doRead(v.a().d(zbav.zbh).b(new q() { // from class: com.google.android.gms.internal.auth-api.zbai
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                zbg zbgVar = (zbg) obj;
                ((zbm) zbgVar.getService()).zbc(new zbaf(this.zba, (TaskCompletionSource) obj2), (SaveAccountLinkingTokenRequest) s.k(saveAccountLinkingTokenRequestA), zbaz.zba(zbgVar.getContext()));
            }
        }).c(false).e(1535).a());
    }

    @Override // c5.f
    public final Task<l> savePassword(k kVar) {
        s.k(kVar);
        k.a aVarT = k.T(kVar);
        aVarT.d(this.zbd);
        final k kVarA = aVarT.a();
        return doRead(v.a().d(zbav.zbf).b(new q() { // from class: com.google.android.gms.internal.auth-api.zbah
            @Override // com.google.android.gms.common.api.internal.q
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                zbg zbgVar = (zbg) obj;
                ((zbm) zbgVar.getService()).zbd(new zbag(this.zba, (TaskCompletionSource) obj2), (k) s.k(kVarA), zbaz.zba(zbgVar.getContext()));
            }
        }).c(false).e(1536).a());
    }

    public zbaj(Context context, w wVar) {
        super(context, zbc, wVar, f.a.f5486c);
        this.zbd = zbaw.zba();
    }
}
