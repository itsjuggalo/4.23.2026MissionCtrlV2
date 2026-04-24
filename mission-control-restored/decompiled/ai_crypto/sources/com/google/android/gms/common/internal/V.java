package com.google.android.gms.common.internal;

import P1.C0648b;
import android.app.PendingIntent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class V extends h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f11051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC1192c f11052f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(AbstractC1192c abstractC1192c, int i7, Bundle bundle) {
        super(abstractC1192c, Boolean.TRUE);
        this.f11052f = abstractC1192c;
        this.f11050d = i7;
        this.f11051e = bundle;
    }

    @Override // com.google.android.gms.common.internal.h0
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f11050d != 0) {
            this.f11052f.c(1, null);
            Bundle bundle = this.f11051e;
            f(new C0648b(this.f11050d, bundle != null ? (PendingIntent) bundle.getParcelable(AbstractC1192c.KEY_PENDING_INTENT) : null));
        } else {
            if (g()) {
                return;
            }
            this.f11052f.c(1, null);
            f(new C0648b(8, null));
        }
    }

    @Override // com.google.android.gms.common.internal.h0
    public final void b() {
    }

    public abstract void f(C0648b c0648b);

    public abstract boolean g();
}
