package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.h;
import e6.f;
import e6.g;
import e6.h;
import e6.p0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaf implements g {
    public final h addGeofences(com.google.android.gms.common.api.g gVar, e6.h hVar, PendingIntent pendingIntent) {
        return gVar.b(new zzac(this, gVar, hVar, pendingIntent));
    }

    public final h removeGeofences(com.google.android.gms.common.api.g gVar, PendingIntent pendingIntent) {
        return zza(gVar, p0.S(pendingIntent));
    }

    public final h zza(com.google.android.gms.common.api.g gVar, p0 p0Var) {
        return gVar.b(new zzad(this, gVar, p0Var));
    }

    @Deprecated
    public final h addGeofences(com.google.android.gms.common.api.g gVar, List<f> list, PendingIntent pendingIntent) {
        h.a aVar = new h.a();
        aVar.b(list);
        aVar.d(5);
        return gVar.b(new zzac(this, gVar, aVar.c(), pendingIntent));
    }

    public final com.google.android.gms.common.api.h removeGeofences(com.google.android.gms.common.api.g gVar, List<String> list) {
        return zza(gVar, p0.R(list));
    }
}
