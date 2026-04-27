package com.google.android.gms.internal.p002firebaseauthapi;

import Q2.g;
import com.revenuecat.purchases.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public final class zzagd {
    private static final Map<String, zzagc> zza = new C2736a();
    private static final Map<String, List<WeakReference<zzagf>>> zzb = new C2736a();

    private static String zza(String str, int i7, boolean z7) {
        if (z7) {
            return "http://[" + str + "]:" + i7 + "/";
        }
        return "http://" + str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i7 + "/";
    }

    public static String zzb(String str) {
        zzagc zzagcVar;
        String str2;
        Map<String, zzagc> map = zza;
        synchronized (map) {
            zzagcVar = map.get(str);
        }
        if (zzagcVar != null) {
            str2 = "" + zza(zzagcVar.zzb(), zzagcVar.zza(), zzagcVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
        } else {
            str2 = "https://";
        }
        return str2 + "www.googleapis.com/identitytoolkit/v3/relyingparty";
    }

    public static String zzc(String str) {
        zzagc zzagcVar;
        String str2;
        Map<String, zzagc> map = zza;
        synchronized (map) {
            zzagcVar = map.get(str);
        }
        if (zzagcVar != null) {
            str2 = "" + zza(zzagcVar.zzb(), zzagcVar.zza(), zzagcVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
        } else {
            str2 = "https://";
        }
        return str2 + "identitytoolkit.googleapis.com/v2";
    }

    public static String zzd(String str) {
        zzagc zzagcVar;
        String str2;
        Map<String, zzagc> map = zza;
        synchronized (map) {
            zzagcVar = map.get(str);
        }
        if (zzagcVar != null) {
            str2 = "" + zza(zzagcVar.zzb(), zzagcVar.zza(), zzagcVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
        } else {
            str2 = "https://";
        }
        return str2 + "securetoken.googleapis.com/v1";
    }

    public static String zza(String str) {
        zzagc zzagcVar;
        Map<String, zzagc> map = zza;
        synchronized (map) {
            zzagcVar = map.get(str);
        }
        if (zzagcVar != null) {
            return zza(zzagcVar.zzb(), zzagcVar.zza(), zzagcVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) + "emulator/auth/handler";
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    public static void zza(String str, zzagf zzagfVar) {
        Map<String, List<WeakReference<zzagf>>> map = zzb;
        synchronized (map) {
            try {
                if (map.containsKey(str)) {
                    map.get(str).add(new WeakReference<>(zzagfVar));
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new WeakReference<>(zzagfVar));
                    map.put(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zza(g gVar, String str, int i7) {
        String strB = gVar.r().b();
        Map<String, zzagc> map = zza;
        synchronized (map) {
            map.put(strB, new zzagc(str, i7));
        }
        Map<String, List<WeakReference<zzagf>>> map2 = zzb;
        synchronized (map2) {
            try {
                if (map2.containsKey(strB)) {
                    Iterator<WeakReference<zzagf>> it = map2.get(strB).iterator();
                    boolean z7 = false;
                    while (it.hasNext()) {
                        zzagf zzagfVar = it.next().get();
                        if (zzagfVar != null) {
                            zzagfVar.zza();
                            z7 = true;
                        }
                    }
                    if (!z7) {
                        zza.remove(strB);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean zza(g gVar) {
        return zza.containsKey(gVar.r().b());
    }
}
