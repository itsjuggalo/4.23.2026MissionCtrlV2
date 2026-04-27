package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.InterfaceC0902f;

/* JADX INFO: loaded from: classes.dex */
final class zzy extends zzah {
    private final InterfaceC0902f zza;

    public zzy(InterfaceC0902f interfaceC0902f) {
        this.zza = interfaceC0902f;
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zzb(zzaa zzaaVar) {
        this.zza.setResult(zzaaVar.getStatus());
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zzc() {
    }
}
