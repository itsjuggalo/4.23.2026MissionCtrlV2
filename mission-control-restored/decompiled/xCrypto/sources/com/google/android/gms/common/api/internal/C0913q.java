package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.h;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0913q extends com.google.android.gms.common.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BasePendingResult f9815a;

    public C0913q(com.google.android.gms.common.api.h hVar) {
        this.f9815a = (BasePendingResult) hVar;
    }

    @Override // com.google.android.gms.common.api.h
    public final void addStatusListener(h.a aVar) {
        this.f9815a.addStatusListener(aVar);
    }

    @Override // com.google.android.gms.common.api.h
    public final com.google.android.gms.common.api.k await(long j4, TimeUnit timeUnit) {
        return this.f9815a.await(j4, timeUnit);
    }
}
