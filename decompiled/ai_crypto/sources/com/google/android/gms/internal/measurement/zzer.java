package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import i2.InterfaceC1803e4;

/* JADX INFO: loaded from: classes.dex */
final class zzer extends zzcz {
    private final InterfaceC1803e4 zza;

    public zzer(InterfaceC1803e4 interfaceC1803e4) {
        this.zza = interfaceC1803e4;
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void zze(String str, String str2, Bundle bundle, long j7) {
        this.zza.a(str, str2, bundle, j7);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}
