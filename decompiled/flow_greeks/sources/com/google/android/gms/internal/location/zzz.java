package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import e6.e;
import e6.i;
import e6.j;
import e6.k;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public final class zzz implements e {
    public final h flushLocations(g gVar) {
        return gVar.b(new zzq(this, gVar));
    }

    public final Location getLastLocation(g gVar) {
        String str;
        zzaz zzazVarA = k.a(gVar);
        Context contextE = gVar.e();
        if (Build.VERSION.SDK_INT < 30 || contextE == null) {
            str = null;
        } else {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", null).invoke(contextE, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                str = null;
            }
        }
        try {
            return zzazVarA.zzz(str);
        } catch (Exception unused2) {
            return null;
        }
    }

    public final LocationAvailability getLocationAvailability(g gVar) {
        try {
            return k.a(gVar).zzA();
        } catch (Exception unused) {
            return null;
        }
    }

    public final h removeLocationUpdates(g gVar, PendingIntent pendingIntent) {
        return gVar.b(new zzw(this, gVar, pendingIntent));
    }

    public final h requestLocationUpdates(g gVar, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return gVar.b(new zzu(this, gVar, locationRequest, pendingIntent));
    }

    public final h setMockLocation(g gVar, Location location) {
        return gVar.b(new zzp(this, gVar, location));
    }

    public final h setMockMode(g gVar, boolean z10) {
        return gVar.b(new zzo(this, gVar, z10));
    }

    public final h removeLocationUpdates(g gVar, i iVar) {
        return gVar.b(new zzn(this, gVar, iVar));
    }

    public final h requestLocationUpdates(g gVar, LocationRequest locationRequest, i iVar, Looper looper) {
        return gVar.b(new zzt(this, gVar, locationRequest, iVar, looper));
    }

    public final h removeLocationUpdates(g gVar, j jVar) {
        return gVar.b(new zzv(this, gVar, jVar));
    }

    public final h requestLocationUpdates(g gVar, LocationRequest locationRequest, j jVar) {
        s.l(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return gVar.b(new zzr(this, gVar, locationRequest, jVar));
    }

    public final h requestLocationUpdates(g gVar, LocationRequest locationRequest, j jVar, Looper looper) {
        return gVar.b(new zzs(this, gVar, locationRequest, jVar, looper));
    }
}
