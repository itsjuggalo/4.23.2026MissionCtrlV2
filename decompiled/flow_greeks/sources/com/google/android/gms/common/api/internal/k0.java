package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements c.InterfaceC0097c, z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.f f5588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f5589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.android.gms.common.internal.k f5590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set f5591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g f5593f;

    public k0(g gVar, a.f fVar, b bVar) {
        Objects.requireNonNull(gVar);
        this.f5593f = gVar;
        this.f5590c = null;
        this.f5591d = null;
        this.f5592e = false;
        this.f5588a = fVar;
        this.f5589b = bVar;
    }

    @Override // com.google.android.gms.common.api.internal.z0
    public final void a(int i10) {
        h0 h0Var = (h0) this.f5593f.d().get(this.f5589b);
        if (h0Var != null) {
            if (h0Var.b()) {
                h0Var.p(new m5.b(17));
            } else {
                h0Var.onConnectionSuspended(i10);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.z0
    public final void b(m5.b bVar) {
        h0 h0Var = (h0) this.f5593f.d().get(this.f5589b);
        if (h0Var != null) {
            h0Var.p(bVar);
        }
    }

    @Override // com.google.android.gms.common.api.internal.z0
    public final void c(com.google.android.gms.common.internal.k kVar, Set set) {
        if (kVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new m5.b(4));
        } else {
            this.f5590c = kVar;
            this.f5591d = set;
            e();
        }
    }

    @Override // com.google.android.gms.common.internal.c.InterfaceC0097c
    public final void d(m5.b bVar) {
        this.f5593f.g().post(new j0(this, bVar));
    }

    public final /* synthetic */ a.f f() {
        return this.f5588a;
    }

    public final /* synthetic */ b g() {
        return this.f5589b;
    }

    public final /* synthetic */ void h(boolean z10) {
        this.f5592e = true;
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void e() {
        com.google.android.gms.common.internal.k kVar;
        if (!this.f5592e || (kVar = this.f5590c) == null) {
            return;
        }
        this.f5588a.getRemoteService(kVar, this.f5591d);
    }
}
