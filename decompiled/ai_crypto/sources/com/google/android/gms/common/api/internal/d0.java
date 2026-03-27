package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l2.l f10944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10945b;

    public d0(f0 f0Var, l2.l lVar) {
        this.f10945b = f0Var;
        this.f10944a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f0.b0(this.f10945b, this.f10944a);
    }
}
