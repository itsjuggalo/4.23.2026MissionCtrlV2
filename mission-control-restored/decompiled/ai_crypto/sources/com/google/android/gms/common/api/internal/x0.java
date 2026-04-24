package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class x0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC1173j f11016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y0 f11018c;

    public x0(y0 y0Var, AbstractC1173j abstractC1173j, String str) {
        this.f11016a = abstractC1173j;
        this.f11017b = str;
        this.f11018c = y0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        y0 y0Var = this.f11018c;
        if (y0Var.f11020b > 0) {
            AbstractC1173j abstractC1173j = this.f11016a;
            if (y0Var.f11021c != null) {
                bundle = y0Var.f11021c.getBundle(this.f11017b);
            } else {
                bundle = null;
            }
            abstractC1173j.onCreate(bundle);
        }
        if (this.f11018c.f11020b >= 2) {
            this.f11016a.onStart();
        }
        if (this.f11018c.f11020b >= 3) {
            this.f11016a.onResume();
        }
        if (this.f11018c.f11020b >= 4) {
            this.f11016a.onStop();
        }
        if (this.f11018c.f11020b >= 5) {
            this.f11016a.onDestroy();
        }
    }
}
