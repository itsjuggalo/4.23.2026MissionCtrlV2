package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import gd.e;
import ng.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcq {
    private static zzcv zza;

    public static final zzcv zza(Application application) {
        zzcv zzcvVar = zza;
        if (zzcvVar == null) {
            zzcvVar = new zzcv(application);
        }
        if (zza == null) {
            zza = zzcvVar;
        }
        return zzcvVar;
    }

    public static final Object zzb(Application application, String str, long j10, e eVar) {
        return zzcv.zzh(zza(application), str, j10, null, null, null, eVar, 28, null);
    }

    public static final Task zzc(Application application, String str, long j10) {
        return zzas.zza(k.b(zza(application).zzd().zza(), null, null, new zzco(application, str, j10, null), 3, null));
    }

    public static final Object zzd(Application application, String str, e eVar) {
        zzcv zzcvVarZza = zza(application);
        return zzcv.zzh(zzcvVarZza, str, 0L, null, zzcvVarZza.zzf, zzch.zzb, eVar, 2, null);
    }

    public static final Task zze(Application application, String str) {
        return zzas.zza(k.b(zza(application).zzd().zza(), null, null, new zzcp(application, str, null), 3, null));
    }
}
