package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.firebase.auth.b;
import java.util.Map;
import java.util.concurrent.Executor;
import t5.h;
import w.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagb {
    private static final Map<String, zzagd> zza = new a();

    public static b.AbstractC0100b zza(String str, b.AbstractC0100b abstractC0100b, zzaff zzaffVar) {
        zza(str, zzaffVar);
        return new zzaga(abstractC0100b, str);
    }

    public static void zza() {
        zza.clear();
    }

    private static void zza(String str, zzaff zzaffVar) {
        zza.put(str, new zzagd(zzaffVar, h.d().a()));
    }

    public static boolean zza(String str, b.AbstractC0100b abstractC0100b, Activity activity, Executor executor) {
        Map<String, zzagd> map = zza;
        if (map.containsKey(str)) {
            zzagd zzagdVar = map.get(str);
            if (h.d().a() - zzagdVar.zzb < 120000) {
                zzaff zzaffVar = zzagdVar.zza;
                if (zzaffVar == null) {
                    return true;
                }
                zzaffVar.zza(abstractC0100b, activity, executor, str);
                return true;
            }
            zza(str, null);
            return false;
        }
        zza(str, null);
        return false;
    }
}
