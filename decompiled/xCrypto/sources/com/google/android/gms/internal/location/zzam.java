package com.google.android.gms.internal.location;

import P1.C0493d;
import P1.C0497h;
import P1.C0501l;
import P1.C0506q;
import P1.P;
import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.InterfaceC0905i;
import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: loaded from: classes.dex */
public interface zzam extends IInterface {
    void zzd(C0497h c0497h, PendingIntent pendingIntent, zzak zzakVar);

    void zze(PendingIntent pendingIntent, zzak zzakVar, String str);

    void zzf(String[] strArr, zzak zzakVar, String str);

    void zzg(P p4, zzak zzakVar);

    void zzh(long j4, boolean z4, PendingIntent pendingIntent);

    void zzi(C0493d c0493d, PendingIntent pendingIntent, InterfaceC0905i interfaceC0905i);

    void zzj(PendingIntent pendingIntent, InterfaceC0905i interfaceC0905i);

    void zzk(PendingIntent pendingIntent);

    void zzl(PendingIntent pendingIntent, InterfaceC0905i interfaceC0905i);

    @Deprecated
    Location zzm();

    Location zzn(String str);

    void zzo(zzbc zzbcVar);

    void zzp(boolean z4);

    void zzq(Location location);

    void zzr(zzai zzaiVar);

    LocationAvailability zzs(String str);

    void zzt(C0501l c0501l, zzao zzaoVar, String str);

    void zzu(zzl zzlVar);

    void zzv(PendingIntent pendingIntent, C0506q c0506q, InterfaceC0905i interfaceC0905i);
}
