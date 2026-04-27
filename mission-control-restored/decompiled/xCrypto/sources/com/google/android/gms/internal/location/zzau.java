package com.google.android.gms.internal.location;

import P1.B;
import android.location.Location;
import com.google.android.gms.common.api.internal.C0909m;

/* JADX INFO: loaded from: classes.dex */
final class zzau extends B {
    private final C0909m zza;

    public zzau(C0909m c0909m) {
        this.zza = c0909m;
    }

    public final synchronized void zzc() {
        this.zza.a();
    }

    @Override // P1.C
    public final synchronized void zzd(Location location) {
        this.zza.c(new zzat(this, location));
    }
}
