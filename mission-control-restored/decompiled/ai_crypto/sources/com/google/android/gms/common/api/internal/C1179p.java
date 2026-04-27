package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.h;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1179p extends com.google.android.gms.common.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BasePendingResult f10994a;

    public C1179p(com.google.android.gms.common.api.h hVar) {
        this.f10994a = (BasePendingResult) hVar;
    }

    @Override // com.google.android.gms.common.api.h
    public final void addStatusListener(h.a aVar) {
        this.f10994a.addStatusListener(aVar);
    }

    @Override // com.google.android.gms.common.api.h
    public final com.google.android.gms.common.api.k await(long j7, TimeUnit timeUnit) {
        return this.f10994a.await(j7, timeUnit);
    }
}
