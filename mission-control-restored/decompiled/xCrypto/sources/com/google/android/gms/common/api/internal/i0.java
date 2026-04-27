package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.C0927e;
import java.util.Set;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends V1.d implements f.b, f.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a.AbstractC0145a f9790h = U1.d.f5261c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f9792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.AbstractC0145a f9793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f9794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0927e f9795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public U1.e f9796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h0 f9797g;

    public i0(Context context, Handler handler, C0927e c0927e) {
        a.AbstractC0145a abstractC0145a = f9790h;
        this.f9791a = context;
        this.f9792b = handler;
        this.f9795e = (C0927e) AbstractC0940s.l(c0927e, "ClientSettings must not be null");
        this.f9794d = c0927e.h();
        this.f9793c = abstractC0145a;
    }

    public static /* bridge */ /* synthetic */ void b0(i0 i0Var, V1.l lVar) {
        C1984b c1984bI = lVar.i();
        if (c1984bI.n()) {
            com.google.android.gms.common.internal.T t4 = (com.google.android.gms.common.internal.T) AbstractC0940s.k(lVar.k());
            C1984b c1984bI2 = t4.i();
            if (!c1984bI2.n()) {
                String strValueOf = String.valueOf(c1984bI2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                i0Var.f9797g.a(c1984bI2);
                i0Var.f9796f.disconnect();
                return;
            }
            i0Var.f9797g.c(t4.k(), i0Var.f9794d);
        } else {
            i0Var.f9797g.a(c1984bI);
        }
        i0Var.f9796f.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0912p
    public final void b(C1984b c1984b) {
        this.f9797g.a(c1984b);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0903g
    public final void c(int i4) {
        this.f9797g.d(i4);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [U1.e, com.google.android.gms.common.api.a$f] */
    public final void c0(h0 h0Var) {
        U1.e eVar = this.f9796f;
        if (eVar != null) {
            eVar.disconnect();
        }
        this.f9795e.l(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0145a abstractC0145a = this.f9793c;
        Context context = this.f9791a;
        Handler handler = this.f9792b;
        C0927e c0927e = this.f9795e;
        this.f9796f = abstractC0145a.buildClient(context, handler.getLooper(), c0927e, (Object) c0927e.i(), (f.b) this, (f.c) this);
        this.f9797g = h0Var;
        Set set = this.f9794d;
        if (set == null || set.isEmpty()) {
            this.f9792b.post(new f0(this));
        } else {
            this.f9796f.a();
        }
    }

    public final void d0() {
        U1.e eVar = this.f9796f;
        if (eVar != null) {
            eVar.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0903g
    public final void f(Bundle bundle) {
        this.f9796f.b(this);
    }

    @Override // V1.f
    public final void z(V1.l lVar) {
        this.f9792b.post(new g0(this, lVar));
    }
}
