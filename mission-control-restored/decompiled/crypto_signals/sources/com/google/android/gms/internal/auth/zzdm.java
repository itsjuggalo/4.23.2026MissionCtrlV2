package com.google.android.gms.internal.auth;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
final class zzdm implements zzdj {
    private static final zzdj zza = new zzdj() { // from class: com.google.android.gms.internal.auth.zzdl
        @Override // com.google.android.gms.internal.auth.zzdj
        public final Object zza() {
            throw new IllegalStateException();
        }
    };
    private volatile zzdj zzb;
    private Object zzc;

    public zzdm(zzdj zzdjVar) {
        this.zzb = zzdjVar;
    }

    public final String toString() {
        Object objC = this.zzb;
        if (objC == zza) {
            objC = AbstractC1024h.c("<supplier that returned ", String.valueOf(this.zzc), ">");
        }
        return AbstractC1024h.c("Suppliers.memoize(", String.valueOf(objC), ")");
    }

    @Override // com.google.android.gms.internal.auth.zzdj
    public final Object zza() {
        zzdj zzdjVar = this.zzb;
        zzdj zzdjVar2 = zza;
        if (zzdjVar != zzdjVar2) {
            synchronized (this) {
                try {
                    if (this.zzb != zzdjVar2) {
                        Object objZza = this.zzb.zza();
                        this.zzc = objZza;
                        this.zzb = zzdjVar2;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzc;
    }
}
