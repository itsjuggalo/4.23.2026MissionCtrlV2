package com.google.firebase.analytics.connector.internal;

import R1.a;
import S1.AbstractC0539b4;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzd implements a.InterfaceC0060a {
    final /* synthetic */ zze zza;

    public zzd(zze zzeVar) {
        Objects.requireNonNull(zzeVar);
        this.zza = zzeVar;
    }

    @Override // S1.InterfaceC0571f4
    public final void onEvent(String str, String str2, Bundle bundle, long j4) {
        zze zzeVar = this.zza;
        if (zzeVar.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            int i4 = zzc.zza;
            String strA = AbstractC0539b4.a(str2);
            if (strA != null) {
                str2 = strA;
            }
            bundle2.putString("events", str2);
            zzeVar.zzd().onMessageTriggered(2, bundle2);
        }
    }
}
