package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaal {
    private final zzaaj zza;

    private zzaal(zzaaj zzaajVar) {
        this.zza = zzaajVar;
    }

    public final int zza() {
        return this.zza.zza();
    }

    public static zzaal zza(byte[] bArr, zzch zzchVar) {
        if (zzchVar != null) {
            return new zzaal(zzaaj.zza(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public static zzaal zza(int i10) {
        return new zzaal(zzaaj.zza(zzqd.zza(i10)));
    }

    public final byte[] zza(zzch zzchVar) {
        if (zzchVar != null) {
            return this.zza.zzb();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
