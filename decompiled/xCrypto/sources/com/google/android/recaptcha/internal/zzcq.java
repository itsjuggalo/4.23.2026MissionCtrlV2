package com.google.android.recaptcha.internal;

import Z2.e;
import android.app.Application;
import com.google.android.gms.tasks.Task;
import t3.AbstractC1822k;

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

    public static final Object zzb(Application application, String str, long j4, e eVar) {
        return zzcv.zzh(zza(application), str, j4, null, null, null, eVar, 28, null);
    }

    public static final Task zzc(Application application, String str, long j4) {
        return zzas.zza(AbstractC1822k.b(zza(application).zzd().zza(), null, null, new zzco(application, str, j4, null), 3, null));
    }

    public static final Object zzd(Application application, String str, e eVar) {
        zzcv zzcvVarZza = zza(application);
        return zzcv.zzh(zzcvVarZza, str, 0L, null, zzcvVarZza.zzf, zzch.zzb, eVar, 2, null);
    }

    public static final Task zze(Application application, String str) {
        return zzas.zza(AbstractC1822k.b(zza(application).zzd().zza(), null, null, new zzcp(application, str, null), 3, null));
    }
}
