package com.google.android.gms.internal.location;

import android.support.v4.media.session.b;
import com.google.android.gms.common.api.internal.C1175l;
import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: loaded from: classes.dex */
final class zzaq implements C1175l.b {
    final /* synthetic */ LocationAvailability zza;

    public zzaq(zzar zzarVar, LocationAvailability locationAvailability) {
        this.zza = locationAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.C1175l.b
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        b.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.C1175l.b
    public final void onNotifyListenerFailed() {
    }
}
