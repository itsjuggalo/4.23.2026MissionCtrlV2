package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;

/* JADX INFO: loaded from: classes.dex */
final class zzak implements k {
    private final Status zza;

    public zzak(Status status) {
        this.zza = status;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.zza;
    }
}
