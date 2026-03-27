package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzbn {
    private final zzce zza;

    private zzbn(zzce zzceVar) {
        this.zza = zzceVar;
    }

    public static zzbn zza(zzce zzceVar) {
        return new zzbn(zzceVar);
    }

    private final zzww zzb() {
        try {
            zzce zzceVar = this.zza;
            return zzceVar instanceof zzoh ? ((zzoh) zzceVar).zzb().zza() : ((zzqd) zzpc.zza().zza(this.zza, zzqd.class)).zza();
        } catch (GeneralSecurityException e7) {
            throw new zzqo("Parsing parameters failed in getProto(). You probably want to call some Tink register function for " + String.valueOf(this.zza), e7);
        }
    }

    public final zzce zza() {
        zzce zzceVar = this.zza;
        return zzceVar != null ? zzceVar : zzcm.zza(zzb().zzk());
    }
}
