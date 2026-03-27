package com.google.android.recaptcha.internal;

import H5.d;
import android.app.Application;
import b6.AbstractC1077k;
import com.google.android.gms.tasks.Task;

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

    public static final Object zzb(Application application, String str, long j7, d dVar) {
        return zzcv.zzh(zza(application), str, j7, null, null, null, dVar, 28, null);
    }

    public static final Task zzc(Application application, String str, long j7) {
        return zzas.zza(AbstractC1077k.b(zza(application).zzd().zza(), null, null, new zzco(application, str, j7, null), 3, null));
    }

    public static final Object zzd(Application application, String str, d dVar) {
        zzcv zzcvVarZza = zza(application);
        return zzcv.zzh(zzcvVarZza, str, 0L, null, zzcvVarZza.zzf, zzch.zzb, dVar, 2, null);
    }

    public static final Task zze(Application application, String str) {
        return zzas.zza(AbstractC1077k.b(zza(application).zzd().zza(), null, null, new zzcp(application, str, null), 3, null));
    }
}
