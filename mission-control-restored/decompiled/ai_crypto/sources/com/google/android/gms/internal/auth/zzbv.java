package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class zzbv implements k {
    private final Status zza;
    private final String zzb;

    public zzbv(Status status) {
        this.zza = (Status) AbstractC1207s.k(status);
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
        this.zzb = (String) AbstractC1207s.k(str);
        this.zza = Status.f10838f;
    }
}
