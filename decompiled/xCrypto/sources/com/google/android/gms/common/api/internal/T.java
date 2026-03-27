package com.google.android.gms.common.api.internal;

import android.util.Log;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class T implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1984b f9733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ U f9734b;

    public T(U u4, C1984b c1984b) {
        this.f9734b = u4;
        this.f9733a = c1984b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        U u4 = this.f9734b;
        P p4 = (P) u4.f9740f.f9784j.get(u4.f9736b);
        if (p4 == null) {
            return;
        }
        if (!this.f9733a.n()) {
            p4.H(this.f9733a, null);
            return;
        }
        this.f9734b.f9739e = true;
        if (this.f9734b.f9735a.requiresSignIn()) {
            this.f9734b.i();
            return;
        }
        try {
            U u5 = this.f9734b;
            u5.f9735a.getRemoteService(null, u5.f9735a.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e4) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e4);
            this.f9734b.f9735a.disconnect("Failed to get service from broker.");
            p4.H(new C1984b(10), null);
        }
    }
}
