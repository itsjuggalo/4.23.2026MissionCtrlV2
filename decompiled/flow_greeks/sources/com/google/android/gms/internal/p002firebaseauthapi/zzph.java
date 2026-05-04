package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzcb;
import com.google.android.gms.internal.p002firebaseauthapi.zzqf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzph<ParametersT extends zzcb, SerializationT extends zzqf> {
    private final Class<ParametersT> zza;
    private final Class<SerializationT> zzb;

    public static <ParametersT extends zzcb, SerializationT extends zzqf> zzph<ParametersT, SerializationT> zza(zzpj<ParametersT, SerializationT> zzpjVar, Class<ParametersT> cls, Class<SerializationT> cls2) {
        return new zzpk(cls, cls2, zzpjVar);
    }

    public abstract SerializationT zza(ParametersT parameterst);

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzph(Class<ParametersT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final Class<ParametersT> zza() {
        return this.zza;
    }
}
