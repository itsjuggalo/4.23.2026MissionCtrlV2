package com.google.android.gms.common.api.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f5531a;

    public d0(h0 h0Var) {
        Objects.requireNonNull(h0Var);
        this.f5531a = h0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5531a.E();
    }
}
