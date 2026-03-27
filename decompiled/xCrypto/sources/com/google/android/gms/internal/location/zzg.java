package com.google.android.gms.internal.location;

import P1.InterfaceC0491b;
import android.app.PendingIntent;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;

/* JADX INFO: loaded from: classes.dex */
public final class zzg implements InterfaceC0491b {
    public final h removeActivityUpdates(f fVar, PendingIntent pendingIntent) {
        return fVar.b(new zze(this, fVar, pendingIntent));
    }

    public final h requestActivityUpdates(f fVar, long j4, PendingIntent pendingIntent) {
        return fVar.b(new zzd(this, fVar, j4, pendingIntent));
    }
}
