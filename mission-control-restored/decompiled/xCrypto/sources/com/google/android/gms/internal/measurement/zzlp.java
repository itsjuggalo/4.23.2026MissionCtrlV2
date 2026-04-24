package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzlp {
    private final Object zza;
    private final int zzb;

    public zzlp(Object obj, int i4) {
        this.zza = obj;
        this.zzb = i4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlp)) {
            return false;
        }
        zzlp zzlpVar = (zzlp) obj;
        return this.zza == zzlpVar.zza && this.zzb == zzlpVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
