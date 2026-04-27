package com.google.firebase.analytics.connector.internal;

import R1.a;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzf implements a.InterfaceC0060a {
    final /* synthetic */ zzg zza;

    public zzf(zzg zzgVar) {
        Objects.requireNonNull(zzgVar);
        this.zza = zzgVar;
    }

    @Override // S1.InterfaceC0571f4
    public final void onEvent(String str, String str2, Bundle bundle, long j4) {
        if (str == null || !zzc.zzc(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j4);
        bundle2.putBundle("params", bundle);
        this.zza.zzd().onMessageTriggered(3, bundle2);
    }
}
