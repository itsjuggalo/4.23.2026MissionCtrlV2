package com.google.android.gms.internal.measurement;

import S1.InterfaceC0571f4;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzes extends zzcz {
    private final InterfaceC0571f4 zza;

    public zzes(InterfaceC0571f4 interfaceC0571f4) {
        this.zza = interfaceC0571f4;
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void zze(String str, String str2, Bundle bundle, long j4) {
        this.zza.onEvent(str, str2, bundle, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}
