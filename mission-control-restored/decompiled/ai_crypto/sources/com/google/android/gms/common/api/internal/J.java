package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
public final class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ M f10890b;

    public J(M m7, int i7) {
        this.f10890b = m7;
        this.f10889a = i7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10890b.l(this.f10889a);
    }
}
