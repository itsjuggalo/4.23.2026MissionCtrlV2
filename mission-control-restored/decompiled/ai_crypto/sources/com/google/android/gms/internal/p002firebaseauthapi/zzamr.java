package com.google.android.gms.internal.p002firebaseauthapi;

import com.amazon.device.simplesignin.a.a.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
final class zzamr {
    private static final zzamr zza = new zzamr();
    private final ConcurrentMap<Class<?>, zzamv<?>> zzc = new ConcurrentHashMap();
    private final zzamu zzb = new zzalq();

    private zzamr() {
    }

    public static zzamr zza() {
        return zza;
    }

    public final <T> zzamv<T> zza(Class<T> cls) {
        zzalb.zza(cls, "messageType");
        zzamv<T> zzamvVar = (zzamv) this.zzc.get(cls);
        if (zzamvVar != null) {
            return zzamvVar;
        }
        zzamv<T> zzamvVarZza = this.zzb.zza(cls);
        zzalb.zza(cls, "messageType");
        zzalb.zza(zzamvVarZza, a.f10445E);
        zzamv<T> zzamvVar2 = (zzamv) this.zzc.putIfAbsent(cls, zzamvVarZza);
        return zzamvVar2 != null ? zzamvVar2 : zzamvVarZza;
    }

    public final <T> zzamv<T> zza(T t7) {
        return zza((Class) t7.getClass());
    }
}
