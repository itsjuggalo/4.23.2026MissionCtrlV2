package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.C0904h;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import r1.C1745b;
import r1.C1746c;
import r1.C1748e;
import r1.C1749f;
import r1.F;
import r1.k;
import r1.l;

/* JADX INFO: loaded from: classes.dex */
public final class zbaq extends e implements k {
    private static final a.g zba;
    private static final a.AbstractC0145a zbb;
    private static final a zbc;
    private final String zbd;

    static {
        a.g gVar = new a.g();
        zba = gVar;
        zbal zbalVar = new zbal();
        zbb = zbalVar;
        zbc = new a("Auth.Api.Identity.SignIn.API", zbalVar, gVar);
    }

    public zbaq(Activity activity, F f4) {
        super(activity, zbc, (a.d) f4, e.a.f9668c);
        this.zbd = zbat.zba();
    }

    @Override // r1.k
    public final Task<C1746c> beginSignIn(C1745b c1745b) {
        AbstractC0940s.k(c1745b);
        C1745b.a aVarP = C1745b.p(c1745b);
        aVarP.g(this.zbd);
        final C1745b c1745bA = aVarP.a();
        return doRead(AbstractC0920y.a().d(zbas.zba).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api.zbaj
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zbw) ((zbar) obj).getService()).zbc(new zbam(this.zba, (TaskCompletionSource) obj2), (C1745b) AbstractC0940s.k(c1745bA));
            }
        }).c(false).e(1553).a());
    }

    public final String getPhoneNumberFromIntent(Intent intent) throws b {
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
        String stringExtra = intent.getStringExtra("phone_number_hint_result");
        if (stringExtra != null) {
            return stringExtra;
        }
        throw new b(Status.f9655h);
    }

    public final Task<PendingIntent> getPhoneNumberHintIntent(final C1748e c1748e) {
        AbstractC0940s.k(c1748e);
        return doRead(AbstractC0920y.a().d(zbas.zbh).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api.zbah
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                this.zba.zba(c1748e, (zbar) obj, (TaskCompletionSource) obj2);
            }
        }).e(1653).a());
    }

    public final l getSignInCredentialFromIntent(Intent intent) throws b {
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
        l lVar = (l) A1.e.b(intent, "sign_in_credential", l.CREATOR);
        if (lVar != null) {
            return lVar;
        }
        throw new b(Status.f9655h);
    }

    @Override // r1.k
    public final Task<PendingIntent> getSignInIntent(C1749f c1749f) {
        AbstractC0940s.k(c1749f);
        C1749f.a aVarO = C1749f.o(c1749f);
        aVarO.f(this.zbd);
        final C1749f c1749fA = aVarO.a();
        return doRead(AbstractC0920y.a().d(zbas.zbf).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api.zbak
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zbw) ((zbar) obj).getService()).zbe(new zbao(this.zba, (TaskCompletionSource) obj2), (C1749f) AbstractC0940s.k(c1749fA));
            }
        }).e(1555).a());
    }

    public final Task<Void> signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        Iterator it = f.c().iterator();
        while (it.hasNext()) {
            ((f) it.next()).h();
        }
        C0904h.a();
        return doWrite(AbstractC0920y.a().d(zbas.zbb).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth-api.zbai
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                this.zba.zbb((zbar) obj, (TaskCompletionSource) obj2);
            }
        }).c(false).e(1554).a());
    }

    public final /* synthetic */ void zba(C1748e c1748e, zbar zbarVar, TaskCompletionSource taskCompletionSource) {
        ((zbw) zbarVar.getService()).zbd(new zbap(this, taskCompletionSource), c1748e, this.zbd);
    }

    public final /* synthetic */ void zbb(zbar zbarVar, TaskCompletionSource taskCompletionSource) {
        ((zbw) zbarVar.getService()).zbf(new zban(this, taskCompletionSource), this.zbd);
    }

    public zbaq(Context context, F f4) {
        super(context, zbc, f4, e.a.f9668c);
        this.zbd = zbat.zba();
    }
}
