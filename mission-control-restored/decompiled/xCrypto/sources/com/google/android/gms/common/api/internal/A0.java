package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class A0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0907k f9690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f9691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ B0 f9692c;

    public A0(B0 b02, AbstractC0907k abstractC0907k, String str) {
        this.f9690a = abstractC0907k;
        this.f9691b = str;
        this.f9692c = b02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        B0 b02 = this.f9692c;
        if (b02.f9695b > 0) {
            AbstractC0907k abstractC0907k = this.f9690a;
            if (b02.f9696c != null) {
                bundle = b02.f9696c.getBundle(this.f9691b);
            } else {
                bundle = null;
            }
            abstractC0907k.onCreate(bundle);
        }
        if (this.f9692c.f9695b >= 2) {
            this.f9690a.onStart();
        }
        if (this.f9692c.f9695b >= 3) {
            this.f9690a.onResume();
        }
        if (this.f9692c.f9695b >= 4) {
            this.f9690a.onStop();
        }
        if (this.f9692c.f9695b >= 5) {
            this.f9690a.onDestroy();
        }
    }
}
