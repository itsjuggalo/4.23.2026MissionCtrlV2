package com.google.android.gms.internal.location;

import P1.AbstractC0504o;
import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.internal.InterfaceC0902f;

/* JADX INFO: loaded from: classes.dex */
final class zzax extends zzaj {
    private InterfaceC0902f zza;

    public zzax(InterfaceC0902f interfaceC0902f) {
        this.zza = interfaceC0902f;
    }

    private final void zze(int i4) {
        if (this.zza == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times", new Exception());
            return;
        }
        this.zza.setResult(AbstractC0504o.b(AbstractC0504o.a(i4)));
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzb(int i4, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult", new Exception());
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzc(int i4, String[] strArr) {
        zze(i4);
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzd(int i4, PendingIntent pendingIntent) {
        zze(i4);
    }
}
