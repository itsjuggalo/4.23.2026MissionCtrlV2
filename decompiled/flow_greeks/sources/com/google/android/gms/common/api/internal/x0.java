package com.google.android.gms.common.api.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f5651a;

    public x0(a1 a1Var) {
        Objects.requireNonNull(a1Var);
        this.f5651a = a1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5651a.K().b(new m5.b(4));
    }
}
