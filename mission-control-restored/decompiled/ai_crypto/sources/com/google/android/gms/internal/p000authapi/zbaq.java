package com.google.android.gms.internal.p000authapi;

import I1.C0577b;
import I1.C0578c;
import I1.C0580e;
import I1.C0581f;
import I1.F;
import I1.k;
import I1.l;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC1186x;
import com.google.android.gms.common.api.internal.C1170g;
import com.google.android.gms.common.api.internal.InterfaceC1181s;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zbaq extends e implements k {
    private static final a.g zba;
    private static final a.AbstractC0178a zbb;
    private static final a zbc;
    private final String zbd;

    static {
        a.g gVar = new a.g();
        zba = gVar;
        zbal zbalVar = new zbal();
        zbb = zbalVar;
        zbc = new a("Auth.Api.Identity.SignIn.API", zbalVar, gVar);
    }

    public zbaq(Activity activity, F f7) {
        super(activity, zbc, (a.d) f7, e.a.f10853c);
        this.zbd = zbat.zba();
    }

    @Override // I1.k
    public final Task<C0578c> beginSignIn(C0577b c0577b) {
        AbstractC1207s.k(c0577b);
        C0577b.a aVarG = C0577b.G(c0577b);
        aVarG.g(this.zbd);
        final C0577b c0577bA = aVarG.a();
        return doRead(AbstractC1186x.a().d(zbas.zba).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api.zbaj
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                ((zbw) ((zbar) obj).getService()).zbc(new zbam(this.zba, (TaskCompletionSource) obj2), (C0577b) AbstractC1207s.k(c0577bA));
            }
        }).c(false).e(1553).a());
    }

    public final String getPhoneNumberFromIntent(Intent intent) throws b {
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
        String stringExtra = intent.getStringExtra("phone_number_hint_result");
        if (stringExtra != null) {
            return stringExtra;
        }
        throw new b(Status.f10840h);
    }

    public final Task<PendingIntent> getPhoneNumberHintIntent(final C0580e c0580e) {
        AbstractC1207s.k(c0580e);
        return doRead(AbstractC1186x.a().d(zbas.zbh).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api.zbah
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                this.zba.zba(c0580e, (zbar) obj, (TaskCompletionSource) obj2);
            }
        }).e(1653).a());
    }

    public final l getSignInCredentialFromIntent(Intent intent) throws b {
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
        l lVar = (l) Q1.e.b(intent, "sign_in_credential", l.CREATOR);
        if (lVar != null) {
            return lVar;
        }
        throw new b(Status.f10840h);
    }

    @Override // I1.k
    public final Task<PendingIntent> getSignInIntent(C0581f c0581f) {
        AbstractC1207s.k(c0581f);
        C0581f.a aVarF = C0581f.F(c0581f);
        aVarF.f(this.zbd);
        final C0581f c0581fA = aVarF.a();
        return doRead(AbstractC1186x.a().d(zbas.zbf).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api.zbak
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                ((zbw) ((zbar) obj).getService()).zbe(new zbao(this.zba, (TaskCompletionSource) obj2), (C0581f) AbstractC1207s.k(c0581fA));
            }
        }).e(1555).a());
    }

    public final Task<Void> signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        Iterator it = f.c().iterator();
        while (it.hasNext()) {
            ((f) it.next()).h();
        }
        C1170g.a();
        return doWrite(AbstractC1186x.a().d(zbas.zbb).b(new InterfaceC1181s() { // from class: com.google.android.gms.internal.auth-api.zbai
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                this.zba.zbb((zbar) obj, (TaskCompletionSource) obj2);
            }
        }).c(false).e(1554).a());
    }

    public final /* synthetic */ void zba(C0580e c0580e, zbar zbarVar, TaskCompletionSource taskCompletionSource) {
        ((zbw) zbarVar.getService()).zbd(new zbap(this, taskCompletionSource), c0580e, this.zbd);
    }

    public final /* synthetic */ void zbb(zbar zbarVar, TaskCompletionSource taskCompletionSource) {
        ((zbw) zbarVar.getService()).zbf(new zban(this, taskCompletionSource), this.zbd);
    }

    public zbaq(Context context, F f7) {
        super(context, zbc, f7, e.a.f10853c);
        this.zbd = zbat.zba();
    }
}
