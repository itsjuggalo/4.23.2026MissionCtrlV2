package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.internal.s;
import e6.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzay extends zzan {
    private e zza;

    public zzay(e eVar) {
        s.b(eVar != null, "listener can't be null.");
        this.zza = eVar;
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void zzb(m mVar) {
        this.zza.setResult(mVar);
        this.zza = null;
    }
}
