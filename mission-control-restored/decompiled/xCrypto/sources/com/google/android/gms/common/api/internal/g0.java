package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
public final class g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ V1.l f9769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f9770b;

    public g0(i0 i0Var, V1.l lVar) {
        this.f9770b = i0Var;
        this.f9769a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0.b0(this.f9770b, this.f9769a);
    }
}
