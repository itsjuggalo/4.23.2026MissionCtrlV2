package com.google.android.gms.common.api.internal;

import P1.C0648b;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.C1194e;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends l2.d implements f.b, f.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a.AbstractC0178a f10946h = k2.d.f17568c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f10948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.AbstractC0178a f10949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f10950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1194e f10951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k2.e f10952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e0 f10953g;

    public f0(Context context, Handler handler, C1194e c1194e) {
        a.AbstractC0178a abstractC0178a = f10946h;
        this.f10947a = context;
        this.f10948b = handler;
        this.f10951e = (C1194e) AbstractC1207s.l(c1194e, "ClientSettings must not be null");
        this.f10950d = c1194e.h();
        this.f10949c = abstractC0178a;
    }

    public static /* bridge */ /* synthetic */ void b0(f0 f0Var, l2.l lVar) {
        C0648b c0648bA = lVar.A();
        if (c0648bA.E()) {
            com.google.android.gms.common.internal.T t7 = (com.google.android.gms.common.internal.T) AbstractC1207s.k(lVar.B());
            C0648b c0648bA2 = t7.A();
            if (!c0648bA2.E()) {
                String strValueOf = String.valueOf(c0648bA2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                f0Var.f10953g.a(c0648bA2);
                f0Var.f10952f.disconnect();
                return;
            }
            f0Var.f10953g.c(t7.B(), f0Var.f10950d);
        } else {
            f0Var.f10953g.a(c0648bA);
        }
        f0Var.f10952f.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1169f
    public final void b(int i7) {
        this.f10953g.d(i7);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1178o
    public final void c(C0648b c0648b) {
        this.f10953g.a(c0648b);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.common.api.a$f, k2.e] */
    public final void c0(e0 e0Var) {
        k2.e eVar = this.f10952f;
        if (eVar != null) {
            eVar.disconnect();
        }
        this.f10951e.l(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0178a abstractC0178a = this.f10949c;
        Context context = this.f10947a;
        Handler handler = this.f10948b;
        C1194e c1194e = this.f10951e;
        this.f10952f = abstractC0178a.buildClient(context, handler.getLooper(), c1194e, (Object) c1194e.i(), (f.b) this, (f.c) this);
        this.f10953g = e0Var;
        Set set = this.f10950d;
        if (set == null || set.isEmpty()) {
            this.f10948b.post(new c0(this));
        } else {
            this.f10952f.b();
        }
    }

    public final void d0() {
        k2.e eVar = this.f10952f;
        if (eVar != null) {
            eVar.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1169f
    public final void f(Bundle bundle) {
        this.f10952f.a(this);
    }

    @Override // l2.f
    public final void q(l2.l lVar) {
        this.f10948b.post(new d0(this, lVar));
    }
}
