package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import e6.d;
import e6.h;
import e6.p0;
import e6.z0;
import java.util.List;
import t5.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaz extends zzi {
    private final zzav zzf;

    public zzaz(Context context, Looper looper, g.b bVar, g.c cVar, String str, e eVar) {
        super(context, looper, bVar, cVar, str, eVar);
        this.zzf = new zzav(context, this.zze);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final void disconnect() {
        synchronized (this.zzf) {
            if (isConnected()) {
                try {
                    this.zzf.zzn();
                    this.zzf.zzo();
                } catch (Exception e10) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e10);
                }
                super.disconnect();
            } else {
                super.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.c
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final LocationAvailability zzA() {
        return this.zzf.zzc();
    }

    public final void zzB(zzba zzbaVar, l lVar, zzai zzaiVar) {
        synchronized (this.zzf) {
            this.zzf.zze(zzbaVar, lVar, zzaiVar);
        }
    }

    public final void zzC(LocationRequest locationRequest, l lVar, zzai zzaiVar) {
        synchronized (this.zzf) {
            this.zzf.zzd(locationRequest, lVar, zzaiVar);
        }
    }

    public final void zzD(zzba zzbaVar, PendingIntent pendingIntent, zzai zzaiVar) {
        this.zzf.zzf(zzbaVar, pendingIntent, zzaiVar);
    }

    public final void zzE(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzaiVar) {
        this.zzf.zzg(locationRequest, pendingIntent, zzaiVar);
    }

    public final void zzF(l.a aVar, zzai zzaiVar) {
        this.zzf.zzh(aVar, zzaiVar);
    }

    public final void zzG(PendingIntent pendingIntent, zzai zzaiVar) {
        this.zzf.zzj(pendingIntent, zzaiVar);
    }

    public final void zzH(l.a aVar, zzai zzaiVar) {
        this.zzf.zzi(aVar, zzaiVar);
    }

    public final void zzI(boolean z10) {
        this.zzf.zzk(z10);
    }

    public final void zzJ(Location location) {
        this.zzf.zzl(location);
    }

    public final void zzK(zzai zzaiVar) {
        this.zzf.zzm(zzaiVar);
    }

    public final void zzL(e6.l lVar, com.google.android.gms.common.api.internal.e eVar, String str) {
        checkConnected();
        s.b(lVar != null, "locationSettingsRequest can't be null nor empty.");
        s.b(eVar != null, "listener can't be null.");
        ((zzam) getService()).zzt(lVar, new zzay(eVar), null);
    }

    public final void zzq(long j10, PendingIntent pendingIntent) {
        checkConnected();
        s.k(pendingIntent);
        s.b(j10 >= 0, "detectionIntervalMillis must be >= 0");
        ((zzam) getService()).zzh(j10, true, pendingIntent);
    }

    public final void zzr(d dVar, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) {
        checkConnected();
        s.l(dVar, "activityTransitionRequest must be specified.");
        s.l(pendingIntent, "PendingIntent must be specified.");
        s.l(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzi(dVar, pendingIntent, new com.google.android.gms.common.api.internal.s(eVar));
    }

    public final void zzs(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) {
        checkConnected();
        s.l(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzj(pendingIntent, new com.google.android.gms.common.api.internal.s(eVar));
    }

    public final void zzt(PendingIntent pendingIntent) {
        checkConnected();
        s.k(pendingIntent);
        ((zzam) getService()).zzk(pendingIntent);
    }

    public final void zzu(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) {
        checkConnected();
        s.l(pendingIntent, "PendingIntent must be specified.");
        s.l(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzl(pendingIntent, new com.google.android.gms.common.api.internal.s(eVar));
    }

    public final void zzv(h hVar, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) {
        checkConnected();
        s.l(hVar, "geofencingRequest can't be null.");
        s.l(pendingIntent, "PendingIntent must be specified.");
        s.l(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzd(hVar, pendingIntent, new zzaw(eVar));
    }

    public final void zzw(p0 p0Var, com.google.android.gms.common.api.internal.e eVar) {
        checkConnected();
        s.l(p0Var, "removeGeofencingRequest can't be null.");
        s.l(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzg(p0Var, new zzax(eVar));
    }

    public final void zzx(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) {
        checkConnected();
        s.l(pendingIntent, "PendingIntent must be specified.");
        s.l(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zze(pendingIntent, new zzax(eVar), getContext().getPackageName());
    }

    public final void zzy(List<String> list, com.google.android.gms.common.api.internal.e eVar) {
        checkConnected();
        s.b(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        s.l(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzf((String[]) list.toArray(new String[0]), new zzax(eVar), getContext().getPackageName());
    }

    public final Location zzz(String str) {
        return b.b(getAvailableFeatures(), z0.f8457c) ? this.zzf.zza(str) : this.zzf.zzb();
    }
}
