package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.InterfaceC1171h;
import com.google.android.gms.location.LocationAvailability;
import f2.C1565P;
import f2.C1578d;
import f2.C1582h;
import f2.C1586l;
import f2.C1591q;

/* JADX INFO: loaded from: classes.dex */
public interface zzam extends IInterface {
    void zzd(C1582h c1582h, PendingIntent pendingIntent, zzak zzakVar);

    void zze(PendingIntent pendingIntent, zzak zzakVar, String str);

    void zzf(String[] strArr, zzak zzakVar, String str);

    void zzg(C1565P c1565p, zzak zzakVar);

    void zzh(long j7, boolean z7, PendingIntent pendingIntent);

    void zzi(C1578d c1578d, PendingIntent pendingIntent, InterfaceC1171h interfaceC1171h);

    void zzj(PendingIntent pendingIntent, InterfaceC1171h interfaceC1171h);

    void zzk(PendingIntent pendingIntent);

    void zzl(PendingIntent pendingIntent, InterfaceC1171h interfaceC1171h);

    @Deprecated
    Location zzm();

    Location zzn(String str);

    void zzo(zzbc zzbcVar);

    void zzp(boolean z7);

    void zzq(Location location);

    void zzr(zzai zzaiVar);

    LocationAvailability zzs(String str);

    void zzt(C1586l c1586l, zzao zzaoVar, String str);

    void zzu(zzl zzlVar);

    void zzv(PendingIntent pendingIntent, C1591q c1591q, InterfaceC1171h interfaceC1171h);
}
