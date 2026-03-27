package com.google.android.recaptcha.internal;

import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes.dex */
public final class zzbj implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    public final String toString() {
        return "avgExecutionTime: " + AbstractC1753A.e0(String.valueOf(this.zzb / ((long) this.zza)), 10, (char) 0, 2, null) + " us| maxExecutionTime: " + AbstractC1753A.e0(String.valueOf(this.zzc), 10, (char) 0, 2, null) + " us| totalTime: " + AbstractC1753A.e0(String.valueOf(this.zzb), 10, (char) 0, 2, null) + " us| #Usages: " + AbstractC1753A.e0(String.valueOf(this.zza), 5, (char) 0, 2, null);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzbj zzbjVar) {
        return Y2.a.a(Long.valueOf(this.zzb), Long.valueOf(zzbjVar.zzb));
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

    public final void zzg(int i4) {
        this.zza = i4;
    }
}
