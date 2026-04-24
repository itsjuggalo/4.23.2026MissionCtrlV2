package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzalq implements zzamu {
    private static final zzamd zza = new zzalt();
    private final zzamd zzb;

    public zzalq() {
        this(new zzalv(zzakw.zza(), zza));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamu
    public final <T> zzamv<T> zza(Class<T> cls) {
        zzamx.zza((Class<?>) cls);
        zzama zzamaVarZza = this.zzb.zza(cls);
        if (zzamaVarZza.zzc()) {
            return zzami.zza(zzamx.zza(), zzako.zza(), zzamaVarZza.zza());
        }
        return zzamg.zza(cls, zzamaVarZza, zzamm.zza(), zzalo.zza(), zzamx.zza(), zzals.zza[zzamaVarZza.zzb().ordinal()] != 1 ? zzako.zza() : null, zzamb.zza());
    }

    private zzalq(zzamd zzamdVar) {
        this.zzb = (zzamd) zzalb.zza(zzamdVar, "messageInfoFactory");
    }
}
