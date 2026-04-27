package com.google.android.gms.internal.p002firebaseauthapi;

import W1.g;
import android.app.Activity;
import com.google.firebase.auth.b;
import java.util.Map;
import java.util.concurrent.Executor;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public final class zzaft {
    private static final Map<String, zzafv> zza = new C2736a();

    public static b.AbstractC0192b zza(String str, b.AbstractC0192b abstractC0192b, zzaex zzaexVar) {
        zza(str, zzaexVar);
        return new zzafs(abstractC0192b, str);
    }

    public static void zza() {
        zza.clear();
    }

    private static void zza(String str, zzaex zzaexVar) {
        zza.put(str, new zzafv(zzaexVar, g.d().a()));
    }

    public static boolean zza(String str, b.AbstractC0192b abstractC0192b, Activity activity, Executor executor) {
        Map<String, zzafv> map = zza;
        if (map.containsKey(str)) {
            zzafv zzafvVar = map.get(str);
            if (g.d().a() - zzafvVar.zzb < 120000) {
                zzaex zzaexVar = zzafvVar.zza;
                if (zzaexVar == null) {
                    return true;
                }
                zzaexVar.zza(abstractC0192b, activity, executor, str);
                return true;
            }
            zza(str, null);
            return false;
        }
        zza(str, null);
        return false;
    }
}
