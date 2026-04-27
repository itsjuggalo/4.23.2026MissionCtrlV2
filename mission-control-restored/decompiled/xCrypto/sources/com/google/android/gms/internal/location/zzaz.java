package com.google.android.gms.internal.location;

import G1.b;
import P1.C0493d;
import P1.C0497h;
import P1.C0501l;
import P1.P;
import P1.a0;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.BinderC0917v;
import com.google.android.gms.common.api.internal.C0909m;
import com.google.android.gms.common.api.internal.InterfaceC0902f;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.C0927e;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz extends zzi {
    private final zzav zzf;

    public zzaz(Context context, Looper looper, f.b bVar, f.c cVar, String str, C0927e c0927e) {
        super(context, looper, bVar, cVar, str, c0927e);
        this.zzf = new zzav(context, this.zze);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final void disconnect() {
        synchronized (this.zzf) {
            if (isConnected()) {
                try {
                    this.zzf.zzn();
                    this.zzf.zzo();
                } catch (Exception e4) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e4);
                }
                super.disconnect();
            } else {
                super.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final LocationAvailability zzA() {
        return this.zzf.zzc();
    }

    public final void zzB(zzba zzbaVar, C0909m c0909m, zzai zzaiVar) {
        synchronized (this.zzf) {
            this.zzf.zze(zzbaVar, c0909m, zzaiVar);
        }
    }

    public final void zzC(LocationRequest locationRequest, C0909m c0909m, zzai zzaiVar) {
        synchronized (this.zzf) {
            this.zzf.zzd(locationRequest, c0909m, zzaiVar);
        }
    }

    public final void zzD(zzba zzbaVar, PendingIntent pendingIntent, zzai zzaiVar) {
        this.zzf.zzf(zzbaVar, pendingIntent, zzaiVar);
    }

    public final void zzE(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzaiVar) {
        this.zzf.zzg(locationRequest, pendingIntent, zzaiVar);
    }

    public final void zzF(C0909m.a aVar, zzai zzaiVar) {
        this.zzf.zzh(aVar, zzaiVar);
    }

    public final void zzG(PendingIntent pendingIntent, zzai zzaiVar) {
        this.zzf.zzj(pendingIntent, zzaiVar);
    }

    public final void zzH(C0909m.a aVar, zzai zzaiVar) {
        this.zzf.zzi(aVar, zzaiVar);
    }

    public final void zzI(boolean z4) {
        this.zzf.zzk(z4);
    }

    public final void zzJ(Location location) {
        this.zzf.zzl(location);
    }

    public final void zzK(zzai zzaiVar) {
        this.zzf.zzm(zzaiVar);
    }

    public final void zzL(C0501l c0501l, InterfaceC0902f interfaceC0902f, String str) {
        checkConnected();
        AbstractC0940s.b(c0501l != null, "locationSettingsRequest can't be null nor empty.");
        AbstractC0940s.b(interfaceC0902f != null, "listener can't be null.");
        ((zzam) getService()).zzt(c0501l, new zzay(interfaceC0902f), null);
    }

    public final void zzq(long j4, PendingIntent pendingIntent) {
        checkConnected();
        AbstractC0940s.k(pendingIntent);
        AbstractC0940s.b(j4 >= 0, "detectionIntervalMillis must be >= 0");
        ((zzam) getService()).zzh(j4, true, pendingIntent);
    }

    public final void zzr(C0493d c0493d, PendingIntent pendingIntent, InterfaceC0902f interfaceC0902f) {
        checkConnected();
        AbstractC0940s.l(c0493d, "activityTransitionRequest must be specified.");
        AbstractC0940s.l(pendingIntent, "PendingIntent must be specified.");
        AbstractC0940s.l(interfaceC0902f, "ResultHolder not provided.");
        ((zzam) getService()).zzi(c0493d, pendingIntent, new BinderC0917v(interfaceC0902f));
    }

    public final void zzs(PendingIntent pendingIntent, InterfaceC0902f interfaceC0902f) {
        checkConnected();
        AbstractC0940s.l(interfaceC0902f, "ResultHolder not provided.");
        ((zzam) getService()).zzj(pendingIntent, new BinderC0917v(interfaceC0902f));
    }

    public final void zzt(PendingIntent pendingIntent) {
        checkConnected();
        AbstractC0940s.k(pendingIntent);
        ((zzam) getService()).zzk(pendingIntent);
    }

    public final void zzu(PendingIntent pendingIntent, InterfaceC0902f interfaceC0902f) {
        checkConnected();
        AbstractC0940s.l(pendingIntent, "PendingIntent must be specified.");
        AbstractC0940s.l(interfaceC0902f, "ResultHolder not provided.");
        ((zzam) getService()).zzl(pendingIntent, new BinderC0917v(interfaceC0902f));
    }

    public final void zzv(C0497h c0497h, PendingIntent pendingIntent, InterfaceC0902f interfaceC0902f) {
        checkConnected();
        AbstractC0940s.l(c0497h, "geofencingRequest can't be null.");
        AbstractC0940s.l(pendingIntent, "PendingIntent must be specified.");
        AbstractC0940s.l(interfaceC0902f, "ResultHolder not provided.");
        ((zzam) getService()).zzd(c0497h, pendingIntent, new zzaw(interfaceC0902f));
    }

    public final void zzw(P p4, InterfaceC0902f interfaceC0902f) {
        checkConnected();
        AbstractC0940s.l(p4, "removeGeofencingRequest can't be null.");
        AbstractC0940s.l(interfaceC0902f, "ResultHolder not provided.");
        ((zzam) getService()).zzg(p4, new zzax(interfaceC0902f));
    }

    public final void zzx(PendingIntent pendingIntent, InterfaceC0902f interfaceC0902f) {
        checkConnected();
        AbstractC0940s.l(pendingIntent, "PendingIntent must be specified.");
        AbstractC0940s.l(interfaceC0902f, "ResultHolder not provided.");
        ((zzam) getService()).zze(pendingIntent, new zzax(interfaceC0902f), getContext().getPackageName());
    }

    public final void zzy(List<String> list, InterfaceC0902f interfaceC0902f) {
        checkConnected();
        AbstractC0940s.b(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        AbstractC0940s.l(interfaceC0902f, "ResultHolder not provided.");
        ((zzam) getService()).zzf((String[]) list.toArray(new String[0]), new zzax(interfaceC0902f), getContext().getPackageName());
    }

    public final Location zzz(String str) {
        return b.b(getAvailableFeatures(), a0.f3408c) ? this.zzf.zza(str) : this.zzf.zzb();
    }
}
