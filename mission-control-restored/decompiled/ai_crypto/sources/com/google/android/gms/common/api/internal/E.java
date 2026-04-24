package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1165b f10883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f10884b = new TaskCompletionSource();

    public E(C1165b c1165b) {
        this.f10883a = c1165b;
    }

    public final C1165b a() {
        return this.f10883a;
    }

    public final TaskCompletionSource b() {
        return this.f10884b;
    }
}
