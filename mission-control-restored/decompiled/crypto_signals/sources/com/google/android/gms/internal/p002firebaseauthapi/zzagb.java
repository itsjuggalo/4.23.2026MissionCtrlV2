package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import i2.x;
import java.util.Map;
import java.util.concurrent.Executor;
import q.C0910b;

/* JADX INFO: loaded from: classes.dex */
public final class zzagb {
    private static final Map<String, zzagd> zza = new C0910b();

    public static x zza(String str, x xVar, zzaff zzaffVar) {
        zza(str, zzaffVar);
        return new zzaga(xVar, str);
    }

    public static void zza() {
        zza.clear();
    }

    private static void zza(String str, zzaff zzaffVar) {
        zza.put(str, new zzagd(zzaffVar, System.currentTimeMillis()));
    }

    public static boolean zza(String str, x xVar, Activity activity, Executor executor) {
        Map<String, zzagd> map = zza;
        if (map.containsKey(str)) {
            zzagd zzagdVar = map.get(str);
            if (System.currentTimeMillis() - zzagdVar.zzb < 120000) {
                zzaff zzaffVar = zzagdVar.zza;
                if (zzaffVar == null) {
                    return true;
                }
                zzaffVar.zza(xVar, activity, executor, str);
                return true;
            }
            zza(str, null);
            return false;
        }
        zza(str, null);
        return false;
    }
}
