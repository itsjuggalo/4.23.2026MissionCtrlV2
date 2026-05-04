package com.google.android.gms.internal.p002firebaseauthapi;

import com.amazon.device.simplesignin.a.a.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzamx {
    private static final zzamx zza = new zzamx();
    private final ConcurrentMap<Class<?>, zzanb<?>> zzc = new ConcurrentHashMap();
    private final zzane zzb = new zzama();

    private zzamx() {
    }

    public static zzamx zza() {
        return zza;
    }

    public final <T> zzanb<T> zza(Class<T> cls) {
        zzalh.zza(cls, "messageType");
        zzanb<T> zzanbVarZza = (zzanb) this.zzc.get(cls);
        if (zzanbVarZza == null) {
            zzanbVarZza = this.zzb.zza(cls);
            zzalh.zza(cls, "messageType");
            zzalh.zza(zzanbVarZza, a.E);
            zzanb<T> zzanbVar = (zzanb) this.zzc.putIfAbsent(cls, zzanbVarZza);
            if (zzanbVar != null) {
                return zzanbVar;
            }
        }
        return zzanbVarZza;
    }

    public final <T> zzanb<T> zza(T t10) {
        return zza((Class) t10.getClass());
    }
}
