package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.k;
import f2.AbstractC1599y;

/* JADX INFO: loaded from: classes.dex */
abstract class zzf extends AbstractC1599y {
    public zzf(f fVar) {
        super(fVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ k createFailedResult(Status status) {
        return status;
    }
}
