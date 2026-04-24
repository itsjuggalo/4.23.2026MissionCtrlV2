package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.C1175l;
import f2.AbstractBinderC1551B;

/* JADX INFO: loaded from: classes.dex */
final class zzau extends AbstractBinderC1551B {
    private final C1175l zza;

    public zzau(C1175l c1175l) {
        this.zza = c1175l;
    }

    public final synchronized void zzc() {
        this.zza.a();
    }

    @Override // f2.InterfaceC1552C
    public final synchronized void zzd(Location location) {
        this.zza.c(new zzat(this, location));
    }
}
