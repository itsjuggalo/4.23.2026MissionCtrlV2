package com.google.android.gms.common.api.internal;

import android.util.Log;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m5.b f5585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f5586b;

    public j0(k0 k0Var, m5.b bVar) {
        this.f5585a = bVar;
        Objects.requireNonNull(k0Var);
        this.f5586b = k0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k0 k0Var = this.f5586b;
        h0 h0Var = (h0) k0Var.f5593f.d().get(k0Var.g());
        if (h0Var == null) {
            return;
        }
        if (!this.f5585a.V()) {
            h0Var.q(this.f5585a, null);
            return;
        }
        k0Var.h(true);
        if (k0Var.f().requiresSignIn()) {
            k0Var.e();
            return;
        }
        try {
            k0Var.f().getRemoteService(null, k0Var.f().getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e10) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e10);
            this.f5586b.f().disconnect("Failed to get service from broker.");
            h0Var.q(new m5.b(10), null);
        }
    }
}
