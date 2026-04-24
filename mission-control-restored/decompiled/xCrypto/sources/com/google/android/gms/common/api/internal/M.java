package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
public final class M implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ P f9715b;

    public M(P p4, int i4) {
        this.f9715b = p4;
        this.f9714a = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9715b.l(this.f9714a);
    }
}
