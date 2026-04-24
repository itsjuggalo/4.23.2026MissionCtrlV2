package com.google.android.gms.internal.location;

import P1.AbstractC0498i;
import P1.AbstractC0500k;
import P1.InterfaceC0494e;
import P1.InterfaceC0499j;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzz implements InterfaceC0494e {
    public final h flushLocations(f fVar) {
        return fVar.b(new zzq(this, fVar));
    }

    public final Location getLastLocation(f fVar) {
        String str;
        zzaz zzazVarA = AbstractC0500k.a(fVar);
        Context contextE = fVar.e();
        if (Build.VERSION.SDK_INT < 30 || contextE == null) {
            str = null;
        } else {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(contextE, new Object[0]);
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

    public final LocationAvailability getLocationAvailability(f fVar) {
        try {
            return AbstractC0500k.a(fVar).zzA();
        } catch (Exception unused) {
            return null;
        }
    }

    public final h removeLocationUpdates(f fVar, PendingIntent pendingIntent) {
        return fVar.b(new zzw(this, fVar, pendingIntent));
    }

    public final h requestLocationUpdates(f fVar, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return fVar.b(new zzu(this, fVar, locationRequest, pendingIntent));
    }

    public final h setMockLocation(f fVar, Location location) {
        return fVar.b(new zzp(this, fVar, location));
    }

    public final h setMockMode(f fVar, boolean z4) {
        return fVar.b(new zzo(this, fVar, z4));
    }

    public final h removeLocationUpdates(f fVar, AbstractC0498i abstractC0498i) {
        return fVar.b(new zzn(this, fVar, abstractC0498i));
    }

    public final h requestLocationUpdates(f fVar, LocationRequest locationRequest, AbstractC0498i abstractC0498i, Looper looper) {
        return fVar.b(new zzt(this, fVar, locationRequest, abstractC0498i, looper));
    }

    public final h removeLocationUpdates(f fVar, InterfaceC0499j interfaceC0499j) {
        return fVar.b(new zzv(this, fVar, interfaceC0499j));
    }

    public final h requestLocationUpdates(f fVar, LocationRequest locationRequest, InterfaceC0499j interfaceC0499j) {
        AbstractC0940s.l(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return fVar.b(new zzr(this, fVar, locationRequest, interfaceC0499j));
    }

    public final h requestLocationUpdates(f fVar, LocationRequest locationRequest, InterfaceC0499j interfaceC0499j, Looper looper) {
        return fVar.b(new zzs(this, fVar, locationRequest, interfaceC0499j, looper));
    }
}
