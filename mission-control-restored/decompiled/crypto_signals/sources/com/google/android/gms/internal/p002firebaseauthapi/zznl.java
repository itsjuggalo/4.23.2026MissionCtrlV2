package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Enum;
import java.security.GeneralSecurityException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zznl<E extends Enum<E>, O> {
    private final Map<E, O> zza;
    private final Map<O, E> zzb;

    public static <E extends Enum<E>, O> zznk<E, O> zza() {
        return new zznk<>();
    }

    private zznl(Map<E, O> map, Map<O, E> map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final E zza(O o3) throws GeneralSecurityException {
        E e = this.zzb.get(o3);
        if (e != null) {
            return e;
        }
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(o3)));
    }

    public final O zza(E e) throws GeneralSecurityException {
        O o3 = this.zza.get(e);
        if (o3 != null) {
            return o3;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(e)));
    }
}
