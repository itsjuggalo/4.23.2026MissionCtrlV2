package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zznt<SerializationT extends zzqf> {
    private final zzaaj zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzqf> zznt<SerializationT> zza(zznv<SerializationT> zznvVar, zzaaj zzaajVar, Class<SerializationT> cls) {
        return new zzns(zzaajVar, cls, zznvVar);
    }

    public abstract zzbi zza(SerializationT serializationt, zzch zzchVar);

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zznt(zzaaj zzaajVar, Class<SerializationT> cls) {
        this.zza = zzaajVar;
        this.zzb = cls;
    }

    public final zzaaj zza() {
        return this.zza;
    }
}
