package com.google.android.recaptcha.internal;

import Y4.d;

/* JADX INFO: loaded from: classes.dex */
public final class zzbj implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    public final String toString() {
        return "avgExecutionTime: " + d.b0(10, String.valueOf(this.zzb / ((long) this.zza))) + " us| maxExecutionTime: " + d.b0(10, String.valueOf(this.zzc)) + " us| totalTime: " + d.b0(10, String.valueOf(this.zzb)) + " us| #Usages: " + d.b0(5, String.valueOf(this.zza));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzbj zzbjVar) {
        Long lValueOf = Long.valueOf(this.zzb);
        Long lValueOf2 = Long.valueOf(zzbjVar.zzb);
        if (lValueOf == lValueOf2) {
            return 0;
        }
        return lValueOf.compareTo(lValueOf2);
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j4) {
        this.zzc = j4;
    }

    public final void zzf(long j4) {
        this.zzb = j4;
    }

    public final void zzg(int i) {
        this.zza = i;
    }
}
