package com.google.android.gms.internal.location;

import P1.H;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.k;

/* JADX INFO: loaded from: classes.dex */
abstract class zzae extends H {
    public zzae(f fVar) {
        super(fVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ k createFailedResult(Status status) {
        return status;
    }
}
