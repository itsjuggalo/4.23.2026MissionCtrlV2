package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import f2.C1565P;
import f2.C1582h;
import f2.InterfaceC1580f;
import f2.InterfaceC1581g;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaf implements InterfaceC1581g {
    public final h addGeofences(f fVar, C1582h c1582h, PendingIntent pendingIntent) {
        return fVar.b(new zzac(this, fVar, c1582h, pendingIntent));
    }

    public final h removeGeofences(f fVar, PendingIntent pendingIntent) {
        return zza(fVar, C1565P.B(pendingIntent));
    }

    public final h zza(f fVar, C1565P c1565p) {
        return fVar.b(new zzad(this, fVar, c1565p));
    }

    @Deprecated
    public final h addGeofences(f fVar, List<InterfaceC1580f> list, PendingIntent pendingIntent) {
        C1582h.a aVar = new C1582h.a();
        aVar.b(list);
        aVar.d(5);
        return fVar.b(new zzac(this, fVar, aVar.c(), pendingIntent));
    }

    public final h removeGeofences(f fVar, List<String> list) {
        return zza(fVar, C1565P.A(list));
    }
}
