package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
public final class K implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ L f10891a;

    public K(L l7) {
        this.f10891a = l7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        M m7 = this.f10891a.f10892a;
        m7.f10894b.disconnect(m7.f10894b.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
