package com.google.android.gms.common.api.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f5541a;

    public f0(g0 g0Var) {
        Objects.requireNonNull(g0Var);
        this.f5541a = g0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h0 h0Var = this.f5541a.f5563a;
        h0Var.K().disconnect(h0Var.K().getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
