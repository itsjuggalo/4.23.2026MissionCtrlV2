package com.google.android.gms.common.api.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0414q extends com.google.android.gms.common.api.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BasePendingResult f5167a;

    public C0414q(BasePendingResult basePendingResult) {
        this.f5167a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.q
    public final com.google.android.gms.common.api.s await(long j4, TimeUnit timeUnit) {
        return this.f5167a.await(0L, TimeUnit.MILLISECONDS);
    }
}
