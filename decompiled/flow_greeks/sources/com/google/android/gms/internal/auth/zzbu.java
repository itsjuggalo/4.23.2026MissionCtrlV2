package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;
import e5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
        this.zza = Status.f5455f;
    }
}
