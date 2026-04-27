package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class zzbv implements k {
    private final Status zza;
    private final String zzb;

    public zzbv(Status status) {
        this.zza = (Status) AbstractC0940s.k(status);
        this.zzb = "";
    }

    public final String getSpatulaHeader() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.zza;
    }

    public zzbv(String str) {
        this.zzb = (String) AbstractC0940s.k(str);
        this.zza = Status.f9653f;
    }
}
