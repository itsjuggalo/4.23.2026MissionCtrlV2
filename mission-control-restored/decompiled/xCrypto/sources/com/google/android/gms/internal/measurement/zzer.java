package com.google.android.gms.internal.measurement;

import S1.InterfaceC0563e4;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzer extends zzcz {
    private final InterfaceC0563e4 zza;

    public zzer(InterfaceC0563e4 interfaceC0563e4) {
        this.zza = interfaceC0563e4;
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
