package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1347i0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1347i0 f15426d = new C1347i0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f15427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f15428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C1347i0 f15429c;

    public C1347i0() {
        this.f15427a = null;
        this.f15428b = null;
    }

    public C1347i0(Runnable runnable, Executor executor) {
        this.f15427a = runnable;
        this.f15428b = executor;
    }
}
