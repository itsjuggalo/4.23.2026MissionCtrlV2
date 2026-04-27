package com.google.android.gms.internal.location;

import P1.C0497h;
import P1.InterfaceC0495f;
import P1.InterfaceC0496g;
import P1.P;
import android.app.PendingIntent;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaf implements InterfaceC0496g {
    public final h addGeofences(f fVar, C0497h c0497h, PendingIntent pendingIntent) {
        return fVar.b(new zzac(this, fVar, c0497h, pendingIntent));
    }

    public final h removeGeofences(f fVar, PendingIntent pendingIntent) {
        return zza(fVar, P.k(pendingIntent));
    }

    public final h zza(f fVar, P p4) {
        return fVar.b(new zzad(this, fVar, p4));
    }

    @Deprecated
    public final h addGeofences(f fVar, List<InterfaceC0495f> list, PendingIntent pendingIntent) {
        C0497h.a aVar = new C0497h.a();
        aVar.b(list);
        aVar.d(5);
        return fVar.b(new zzac(this, fVar, aVar.c(), pendingIntent));
    }

    public final h removeGeofences(f fVar, List<String> list) {
        return zza(fVar, P.i(list));
    }
}
