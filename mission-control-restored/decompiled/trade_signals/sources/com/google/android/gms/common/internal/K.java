package com.google.android.gms.common.internal;

import Q1.C0790b;
import android.app.PendingIntent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class K extends X {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f14935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC1283c f14936f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(AbstractC1283c abstractC1283c, int i8, Bundle bundle) {
        super(abstractC1283c, Boolean.TRUE);
        this.f14936f = abstractC1283c;
        this.f14934d = i8;
        this.f14935e = bundle;
    }

    @Override // com.google.android.gms.common.internal.X
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f14934d != 0) {
            this.f14936f.d(1, null);
            Bundle bundle = this.f14935e;
            f(new C0790b(this.f14934d, bundle != null ? (PendingIntent) bundle.getParcelable(AbstractC1283c.KEY_PENDING_INTENT) : null));
        } else {
            if (g()) {
                return;
            }
            this.f14936f.d(1, null);
            f(new C0790b(8, null));
        }
    }

    @Override // com.google.android.gms.common.internal.X
    public final void b() {
    }

    public abstract void f(C0790b c0790b);

    public abstract boolean g();
}
