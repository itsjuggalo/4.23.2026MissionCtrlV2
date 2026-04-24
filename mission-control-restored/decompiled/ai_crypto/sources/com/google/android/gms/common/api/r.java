package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: loaded from: classes.dex */
public final class r extends BasePendingResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f11025a;

    public r(f fVar, k kVar) {
        super(fVar);
        this.f11025a = kVar;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final k createFailedResult(Status status) {
        return this.f11025a;
    }
}
