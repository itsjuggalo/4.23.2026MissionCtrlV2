package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.location.LocationAvailability;
import e6.d;
import e6.h;
import e6.l;
import e6.p0;
import e6.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface zzam extends IInterface {
    void zzd(h hVar, PendingIntent pendingIntent, zzak zzakVar);

    void zze(PendingIntent pendingIntent, zzak zzakVar, String str);

    void zzf(String[] strArr, zzak zzakVar, String str);

    void zzg(p0 p0Var, zzak zzakVar);

    void zzh(long j10, boolean z10, PendingIntent pendingIntent);

    void zzi(d dVar, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.h hVar);

    void zzj(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.h hVar);

    void zzk(PendingIntent pendingIntent);

    void zzl(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.h hVar);

    @Deprecated
    Location zzm();

    Location zzn(String str);

    void zzo(zzbc zzbcVar);

    void zzp(boolean z10);

    void zzq(Location location);

    void zzr(zzai zzaiVar);

    LocationAvailability zzs(String str);

    void zzt(l lVar, zzao zzaoVar, String str);

    void zzu(zzl zzlVar);

    void zzv(PendingIntent pendingIntent, q qVar, com.google.android.gms.common.api.internal.h hVar);
}
