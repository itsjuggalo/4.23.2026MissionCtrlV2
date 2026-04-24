package com.google.android.gms.internal.measurement;

import N1.M0;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzes extends zzcz {
    private final M0 zza;

    public zzes(M0 m02) {
        this.zza = m02;
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void zze(String str, String str2, Bundle bundle, long j4) {
        this.zza.a(str, str2, bundle, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}
