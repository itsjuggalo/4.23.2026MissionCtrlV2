package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.InterfaceC1168e;

/* JADX INFO: loaded from: classes.dex */
final class zzy extends zzah {
    private final InterfaceC1168e zza;

    public zzy(InterfaceC1168e interfaceC1168e) {
        this.zza = interfaceC1168e;
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zzb(zzaa zzaaVar) {
        this.zza.setResult(zzaaVar.getStatus());
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zzc() {
    }
}
