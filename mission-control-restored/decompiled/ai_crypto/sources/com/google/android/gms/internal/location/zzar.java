package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.C1175l;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import f2.AbstractBinderC1598x;

/* JADX INFO: loaded from: classes.dex */
final class zzar extends AbstractBinderC1598x {
    private final C1175l zza;

    public zzar(C1175l c1175l) {
        this.zza = c1175l;
    }

    public final synchronized void zzc() {
        this.zza.a();
    }

    @Override // f2.InterfaceC1600z
    public final void zzd(LocationResult locationResult) {
        this.zza.c(new zzap(this, locationResult));
    }

    @Override // f2.InterfaceC1600z
    public final void zze(LocationAvailability locationAvailability) {
        this.zza.c(new zzaq(this, locationAvailability));
    }
}
