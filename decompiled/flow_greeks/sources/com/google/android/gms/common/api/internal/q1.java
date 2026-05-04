package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f5614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f5615b;

    public q1(y yVar, BasePendingResult basePendingResult) {
        this.f5614a = basePendingResult;
        Objects.requireNonNull(yVar);
        this.f5615b = yVar;
    }

    @Override // com.google.android.gms.common.api.h.a
    public final void a(Status status) {
        this.f5615b.f().remove(this.f5614a);
    }
}
