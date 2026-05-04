package com.google.android.gms.common.api.internal;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends n1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w.b f5656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f5657f;

    public z(k kVar, g gVar, m5.e eVar) {
        super(kVar, eVar);
        this.f5656e = new w.b();
        this.f5657f = gVar;
        this.mLifecycleFragment.a("ConnectionlessLifecycleHelper", this);
    }

    public static void i(Activity activity, g gVar, b bVar) {
        k fragment = j.getFragment(activity);
        z zVar = (z) fragment.b("ConnectionlessLifecycleHelper", z.class);
        if (zVar == null) {
            zVar = new z(fragment, gVar, m5.e.n());
        }
        com.google.android.gms.common.internal.s.l(bVar, "ApiKey cannot be null");
        zVar.f5656e.add(bVar);
        gVar.q(zVar);
    }

    @Override // com.google.android.gms.common.api.internal.n1
    public final void d(m5.b bVar, int i10) {
        this.f5657f.A(bVar, i10);
    }

    @Override // com.google.android.gms.common.api.internal.n1
    public final void e() {
        this.f5657f.t();
    }

    public final w.b j() {
        return this.f5656e;
    }

    public final void k() {
        if (this.f5656e.isEmpty()) {
            return;
        }
        this.f5657f.q(this);
    }

    @Override // com.google.android.gms.common.api.internal.j
    public final void onResume() {
        super.onResume();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.n1, com.google.android.gms.common.api.internal.j
    public final void onStart() {
        super.onStart();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.n1, com.google.android.gms.common.api.internal.j
    public final void onStop() {
        super.onStop();
        this.f5657f.r(this);
    }
}
