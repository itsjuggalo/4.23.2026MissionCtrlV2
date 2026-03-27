package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC0925c;
import com.google.android.gms.common.internal.InterfaceC0933k;
import java.util.Set;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class U implements AbstractC0925c.InterfaceC0148c, h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.f f9735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0898c f9736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0933k f9737c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set f9738d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9739e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0904h f9740f;

    public U(C0904h c0904h, a.f fVar, C0898c c0898c) {
        this.f9740f = c0904h;
        this.f9735a = fVar;
        this.f9736b = c0898c;
    }

    @Override // com.google.android.gms.common.api.internal.h0
    public final void a(C1984b c1984b) {
        P p4 = (P) this.f9740f.f9784j.get(this.f9736b);
        if (p4 != null) {
            p4.I(c1984b);
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c.InterfaceC0148c
    public final void b(C1984b c1984b) {
        this.f9740f.f9788n.post(new T(this, c1984b));
    }

    @Override // com.google.android.gms.common.api.internal.h0
    public final void c(InterfaceC0933k interfaceC0933k, Set set) {
        if (interfaceC0933k == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            a(new C1984b(4));
        } else {
            this.f9737c = interfaceC0933k;
            this.f9738d = set;
            i();
        }
    }

    @Override // com.google.android.gms.common.api.internal.h0
    public final void d(int i4) {
        P p4 = (P) this.f9740f.f9784j.get(this.f9736b);
        if (p4 != null) {
            if (p4.f9726i) {
                p4.I(new C1984b(17));
            } else {
                p4.c(i4);
            }
        }
    }

    public final void i() {
        InterfaceC0933k interfaceC0933k;
        if (!this.f9739e || (interfaceC0933k = this.f9737c) == null) {
            return;
        }
        this.f9735a.getRemoteService(interfaceC0933k, this.f9738d);
    }
}
