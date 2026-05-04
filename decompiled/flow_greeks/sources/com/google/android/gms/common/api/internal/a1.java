package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends h6.d implements g.b, g.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a.AbstractC0094a f5510h = g6.d.f10085c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f5512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.AbstractC0094a f5513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f5514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.common.internal.e f5515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g6.e f5516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z0 f5517g;

    public a1(Context context, Handler handler, com.google.android.gms.common.internal.e eVar) {
        a.AbstractC0094a abstractC0094a = f5510h;
        this.f5511a = context;
        this.f5512b = handler;
        this.f5515e = (com.google.android.gms.common.internal.e) com.google.android.gms.common.internal.s.l(eVar, "ClientSettings must not be null");
        this.f5514d = eVar.h();
        this.f5513c = abstractC0094a;
    }

    public final void H(z0 z0Var) {
        g6.e eVar = this.f5516f;
        if (eVar != null) {
            eVar.disconnect();
        }
        com.google.android.gms.common.internal.e eVar2 = this.f5515e;
        eVar2.l(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0094a abstractC0094a = this.f5513c;
        Context context = this.f5511a;
        Handler handler = this.f5512b;
        this.f5516f = (g6.e) abstractC0094a.buildClient(context, handler.getLooper(), eVar2, (Object) eVar2.j(), (g.b) this, (g.c) this);
        this.f5517g = z0Var;
        Set set = this.f5514d;
        if (set == null || set.isEmpty()) {
            handler.post(new x0(this));
        } else {
            this.f5516f.b();
        }
    }

    public final void I() {
        g6.e eVar = this.f5516f;
        if (eVar != null) {
            eVar.disconnect();
        }
    }

    public final /* synthetic */ void J(h6.l lVar) {
        m5.b bVarR = lVar.R();
        if (bVarR.V()) {
            com.google.android.gms.common.internal.q0 q0Var = (com.google.android.gms.common.internal.q0) com.google.android.gms.common.internal.s.k(lVar.S());
            m5.b bVarS = q0Var.S();
            if (!bVarS.V()) {
                String strValueOf = String.valueOf(bVarS);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                this.f5517g.b(bVarS);
                this.f5516f.disconnect();
                return;
            }
            this.f5517g.c(q0Var.R(), this.f5514d);
        } else {
            this.f5517g.b(bVarR);
        }
        this.f5516f.disconnect();
    }

    public final /* synthetic */ z0 K() {
        return this.f5517g;
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void onConnected(Bundle bundle) {
        this.f5516f.a(this);
    }

    @Override // com.google.android.gms.common.api.internal.n
    public final void onConnectionFailed(m5.b bVar) {
        this.f5517g.b(bVar);
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void onConnectionSuspended(int i10) {
        this.f5517g.a(i10);
    }

    @Override // h6.f
    public final void v(h6.l lVar) {
        this.f5512b.post(new y0(this, lVar));
    }
}
