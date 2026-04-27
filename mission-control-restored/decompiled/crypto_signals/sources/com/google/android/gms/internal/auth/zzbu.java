package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.s;
import q1.C0921b;

/* JADX INFO: loaded from: classes.dex */
final class zzbu implements s {
    private final Status zza;
    private C0921b zzb;

    public zzbu(Status status) {
        this.zza = status;
    }

    public final C0921b getResponse() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.s
    public final Status getStatus() {
        return this.zza;
    }

    public zzbu(C0921b c0921b) {
        this.zzb = c0921b;
        this.zza = Status.e;
    }
}
