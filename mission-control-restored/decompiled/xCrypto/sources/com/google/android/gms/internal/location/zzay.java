package com.google.android.gms.internal.location;

import P1.C0502m;
import com.google.android.gms.common.api.internal.InterfaceC0902f;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
final class zzay extends zzan {
    private InterfaceC0902f zza;

    public zzay(InterfaceC0902f interfaceC0902f) {
        AbstractC0940s.b(interfaceC0902f != null, "listener can't be null.");
        this.zza = interfaceC0902f;
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void zzb(C0502m c0502m) {
        this.zza.setResult(c0502m);
        this.zza = null;
    }
}
