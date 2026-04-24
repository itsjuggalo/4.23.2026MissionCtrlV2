package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.internal.AbstractC0940s;
import u.C1854b;
import z1.C1984b;
import z1.C1988f;

/* JADX INFO: loaded from: classes.dex */
public final class F extends w0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1854b f9705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0904h f9706g;

    public F(InterfaceC0908l interfaceC0908l, C0904h c0904h, C1988f c1988f) {
        super(interfaceC0908l, c1988f);
        this.f9705f = new C1854b();
        this.f9706g = c0904h;
        this.mLifecycleFragment.a("ConnectionlessLifecycleHelper", this);
    }

    public static void j(Activity activity, C0904h c0904h, C0898c c0898c) {
        InterfaceC0908l fragment = AbstractC0907k.getFragment(activity);
        F f4 = (F) fragment.b("ConnectionlessLifecycleHelper", F.class);
        if (f4 == null) {
            f4 = new F(fragment, c0904h, C1988f.n());
        }
        AbstractC0940s.l(c0898c, "ApiKey cannot be null");
        f4.f9705f.add(c0898c);
        c0904h.b(f4);
    }

    @Override // com.google.android.gms.common.api.internal.w0
    public final void b(C1984b c1984b, int i4) {
        this.f9706g.F(c1984b, i4);
    }

    @Override // com.google.android.gms.common.api.internal.w0
    public final void c() {
        this.f9706g.G();
    }

    public final C1854b i() {
        return this.f9705f;
    }

    public final void k() {
        if (this.f9705f.isEmpty()) {
            return;
        }
        this.f9706g.b(this);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0907k
    public final void onResume() {
        super.onResume();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.w0, com.google.android.gms.common.api.internal.AbstractC0907k
    public final void onStart() {
        super.onStart();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.w0, com.google.android.gms.common.api.internal.AbstractC0907k
    public final void onStop() {
        super.onStop();
        this.f9706g.c(this);
    }
}
