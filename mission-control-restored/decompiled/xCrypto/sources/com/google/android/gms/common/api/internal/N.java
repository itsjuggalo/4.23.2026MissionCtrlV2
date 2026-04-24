package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
public final class N implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ O f9716a;

    public N(O o4) {
        this.f9716a = o4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        P p4 = this.f9716a.f9717a;
        p4.f9719b.disconnect(p4.f9719b.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
