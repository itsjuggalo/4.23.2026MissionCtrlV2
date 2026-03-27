package com.google.android.gms.internal.auth;

import K1.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;

/* JADX INFO: loaded from: classes.dex */
final class zzbu implements k {
    private final Status zza;
    private c zzb;

    public zzbu(Status status) {
        this.zza = status;
    }

    public final c getResponse() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.zza;
    }

    public zzbu(c cVar) {
        this.zzb = cVar;
        this.zza = Status.f10838f;
    }
}
