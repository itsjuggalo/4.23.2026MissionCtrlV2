package com.google.firebase.appcheck.internal;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultTokenRefresher f10218a;

    public /* synthetic */ i(DefaultTokenRefresher defaultTokenRefresher) {
        this.f10218a = defaultTokenRefresher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10218a.onRefresh();
    }
}
