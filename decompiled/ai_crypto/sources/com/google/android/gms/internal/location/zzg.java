package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import f2.InterfaceC1576b;

/* JADX INFO: loaded from: classes.dex */
public final class zzg implements InterfaceC1576b {
    public final h removeActivityUpdates(f fVar, PendingIntent pendingIntent) {
        return fVar.b(new zze(this, fVar, pendingIntent));
    }

    public final h requestActivityUpdates(f fVar, long j7, PendingIntent pendingIntent) {
        return fVar.b(new zzd(this, fVar, j7, pendingIntent));
    }
}
