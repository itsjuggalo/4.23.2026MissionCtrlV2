package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public abstract class V extends h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f9868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC0925c f9869f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(AbstractC0925c abstractC0925c, int i4, Bundle bundle) {
        super(abstractC0925c, Boolean.TRUE);
        this.f9869f = abstractC0925c;
        this.f9867d = i4;
        this.f9868e = bundle;
    }

    @Override // com.google.android.gms.common.internal.h0
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f9867d != 0) {
            this.f9869f.c(1, null);
            Bundle bundle = this.f9868e;
            f(new C1984b(this.f9867d, bundle != null ? (PendingIntent) bundle.getParcelable(AbstractC0925c.KEY_PENDING_INTENT) : null));
        } else {
            if (g()) {
                return;
            }
            this.f9869f.c(1, null);
            f(new C1984b(8, null));
        }
    }

    @Override // com.google.android.gms.common.internal.h0
    public final void b() {
    }

    public abstract void f(C1984b c1984b);

    public abstract boolean g();
}
