package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.InterfaceC1168e;
import com.google.android.gms.common.internal.AbstractC1207s;
import f2.C1587m;

/* JADX INFO: loaded from: classes.dex */
final class zzay extends zzan {
    private InterfaceC1168e zza;

    public zzay(InterfaceC1168e interfaceC1168e) {
        AbstractC1207s.b(interfaceC1168e != null, "listener can't be null.");
        this.zza = interfaceC1168e;
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void zzb(C1587m c1587m) {
        this.zza.setResult(c1587m);
        this.zza = null;
    }
}
