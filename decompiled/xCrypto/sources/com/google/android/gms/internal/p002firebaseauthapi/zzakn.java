package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzakn {
    private final Object zza;
    private final int zzb;

    public zzakn(Object obj, int i4) {
        this.zza = obj;
        this.zzb = i4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzakn)) {
            return false;
        }
        zzakn zzaknVar = (zzakn) obj;
        return this.zza == zzaknVar.zza && this.zzb == zzaknVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
