package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f5632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u1 f5634c;

    public t1(u1 u1Var, j jVar, String str) {
        this.f5632a = jVar;
        this.f5633b = str;
        Objects.requireNonNull(u1Var);
        this.f5634c = u1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        u1 u1Var = this.f5634c;
        if (u1Var.k() > 0) {
            j jVar = this.f5632a;
            if (u1Var.l() != null) {
                bundle = u1Var.l().getBundle(this.f5633b);
            } else {
                bundle = null;
            }
            jVar.onCreate(bundle);
        }
        if (u1Var.k() >= 2) {
            this.f5632a.onStart();
        }
        if (u1Var.k() >= 3) {
            this.f5632a.onResume();
        }
        if (u1Var.k() >= 4) {
            this.f5632a.onStop();
        }
        if (u1Var.k() >= 5) {
            this.f5632a.onDestroy();
        }
    }
}
