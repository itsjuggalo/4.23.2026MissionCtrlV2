package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0418v extends BasePendingResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5168a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0418v(com.google.android.gms.common.api.o oVar, int i) {
        super(oVar);
        this.f5168a = i;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final com.google.android.gms.common.api.s createFailedResult(Status status) {
        switch (this.f5168a) {
            case 0:
                return status;
            default:
                throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }
}
