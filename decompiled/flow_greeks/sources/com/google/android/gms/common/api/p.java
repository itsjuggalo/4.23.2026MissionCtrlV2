package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends BasePendingResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f5659a;

    public p(g gVar, k kVar) {
        super(gVar);
        this.f5659a = kVar;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final k createFailedResult(Status status) {
        return this.f5659a;
    }
}
