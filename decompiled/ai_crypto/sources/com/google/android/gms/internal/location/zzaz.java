package com.google.android.gms.internal.location;

import W1.b;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.BinderC1183u;
import com.google.android.gms.common.api.internal.C1175l;
import com.google.android.gms.common.api.internal.InterfaceC1168e;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.C1194e;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import f2.C1565P;
import f2.C1578d;
import f2.C1582h;
import f2.C1586l;
import f2.a0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz extends zzi {
    private final zzav zzf;

    public zzaz(Context context, Looper looper, f.b bVar, f.c cVar, String str, C1194e c1194e) {
        super(context, looper, bVar, cVar, str, c1194e);
        this.zzf = new zzav(context, this.zze);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c, com.google.android.gms.common.api.a.f
    public final void disconnect() {
        synchronized (this.zzf) {
            if (isConnected()) {
                try {
                    this.zzf.zzn();
                    this.zzf.zzo();
                } catch (Exception e7) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e7);
                }
                super.disconnect();
            } else {
                super.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final LocationAvailability zzA() {
        return this.zzf.zzc();
    }

    public final void zzB(zzba zzbaVar, C1175l c1175l, zzai zzaiVar) {
        synchronized (this.zzf) {
            this.zzf.zze(zzbaVar, c1175l, zzaiVar);
        }
    }

    public final void zzC(LocationRequest locationRequest, C1175l c1175l, zzai zzaiVar) {
        synchronized (this.zzf) {
            this.zzf.zzd(locationRequest, c1175l, zzaiVar);
        }
    }

    public final void zzD(zzba zzbaVar, PendingIntent pendingIntent, zzai zzaiVar) {
        this.zzf.zzf(zzbaVar, pendingIntent, zzaiVar);
    }

    public final void zzE(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzaiVar) {
        this.zzf.zzg(locationRequest, pendingIntent, zzaiVar);
    }

    public final void zzF(C1175l.a aVar, zzai zzaiVar) {
        this.zzf.zzh(aVar, zzaiVar);
    }

    public final void zzG(PendingIntent pendingIntent, zzai zzaiVar) {
        this.zzf.zzj(pendingIntent, zzaiVar);
    }

    public final void zzH(C1175l.a aVar, zzai zzaiVar) {
        this.zzf.zzi(aVar, zzaiVar);
    }

    public final void zzI(boolean z7) {
        this.zzf.zzk(z7);
    }

    public final void zzJ(Location location) {
        this.zzf.zzl(location);
    }

    public final void zzK(zzai zzaiVar) {
        this.zzf.zzm(zzaiVar);
    }

    public final void zzL(C1586l c1586l, InterfaceC1168e interfaceC1168e, String str) {
        checkConnected();
        AbstractC1207s.b(c1586l != null, "locationSettingsRequest can't be null nor empty.");
        AbstractC1207s.b(interfaceC1168e != null, "listener can't be null.");
        ((zzam) getService()).zzt(c1586l, new zzay(interfaceC1168e), null);
    }

    public final void zzq(long j7, PendingIntent pendingIntent) {
        checkConnected();
        AbstractC1207s.k(pendingIntent);
        AbstractC1207s.b(j7 >= 0, "detectionIntervalMillis must be >= 0");
        ((zzam) getService()).zzh(j7, true, pendingIntent);
    }

    public final void zzr(C1578d c1578d, PendingIntent pendingIntent, InterfaceC1168e interfaceC1168e) {
        checkConnected();
        AbstractC1207s.l(c1578d, "activityTransitionRequest must be specified.");
        AbstractC1207s.l(pendingIntent, "PendingIntent must be specified.");
        AbstractC1207s.l(interfaceC1168e, "ResultHolder not provided.");
        ((zzam) getService()).zzi(c1578d, pendingIntent, new BinderC1183u(interfaceC1168e));
    }

    public final void zzs(PendingIntent pendingIntent, InterfaceC1168e interfaceC1168e) {
        checkConnected();
        AbstractC1207s.l(interfaceC1168e, "ResultHolder not provided.");
        ((zzam) getService()).zzj(pendingIntent, new BinderC1183u(interfaceC1168e));
    }

    public final void zzt(PendingIntent pendingIntent) {
        checkConnected();
        AbstractC1207s.k(pendingIntent);
        ((zzam) getService()).zzk(pendingIntent);
    }

    public final void zzu(PendingIntent pendingIntent, InterfaceC1168e interfaceC1168e) {
        checkConnected();
        AbstractC1207s.l(pendingIntent, "PendingIntent must be specified.");
        AbstractC1207s.l(interfaceC1168e, "ResultHolder not provided.");
        ((zzam) getService()).zzl(pendingIntent, new BinderC1183u(interfaceC1168e));
    }

    public final void zzv(C1582h c1582h, PendingIntent pendingIntent, InterfaceC1168e interfaceC1168e) {
        checkConnected();
        AbstractC1207s.l(c1582h, "geofencingRequest can't be null.");
        AbstractC1207s.l(pendingIntent, "PendingIntent must be specified.");
        AbstractC1207s.l(interfaceC1168e, "ResultHolder not provided.");
        ((zzam) getService()).zzd(c1582h, pendingIntent, new zzaw(interfaceC1168e));
    }

    public final void zzw(C1565P c1565p, InterfaceC1168e interfaceC1168e) {
        checkConnected();
        AbstractC1207s.l(c1565p, "removeGeofencingRequest can't be null.");
        AbstractC1207s.l(interfaceC1168e, "ResultHolder not provided.");
        ((zzam) getService()).zzg(c1565p, new zzax(interfaceC1168e));
    }

    public final void zzx(PendingIntent pendingIntent, InterfaceC1168e interfaceC1168e) {
        checkConnected();
        AbstractC1207s.l(pendingIntent, "PendingIntent must be specified.");
        AbstractC1207s.l(interfaceC1168e, "ResultHolder not provided.");
        ((zzam) getService()).zze(pendingIntent, new zzax(interfaceC1168e), getContext().getPackageName());
    }

    public final void zzy(List<String> list, InterfaceC1168e interfaceC1168e) {
        checkConnected();
        AbstractC1207s.b(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        AbstractC1207s.l(interfaceC1168e, "ResultHolder not provided.");
        ((zzam) getService()).zzf((String[]) list.toArray(new String[0]), new zzax(interfaceC1168e), getContext().getPackageName());
    }

    public final Location zzz(String str) {
        return b.b(getAvailableFeatures(), a0.f14073c) ? this.zzf.zza(str) : this.zzf.zzb();
    }
}
