package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: loaded from: classes.dex */
public final class x extends BasePendingResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f5181a;

    public x(Status status) {
        super(null);
        this.f5181a = status;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final s createFailedResult(Status status) {
        return this.f5181a;
    }
}
