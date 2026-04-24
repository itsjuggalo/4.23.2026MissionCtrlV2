package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: loaded from: classes.dex */
final class zzbc {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final Long zzh;
    final Long zzi;
    final Long zzj;
    final Boolean zzk;

    public zzbc(String str, String str2, long j8, long j9, long j10, long j11, long j12, Long l8, Long l9, Long l10, Boolean bool) {
        AbstractC1294n.d(str);
        AbstractC1294n.d(str2);
        AbstractC1294n.a(j8 >= 0);
        AbstractC1294n.a(j9 >= 0);
        AbstractC1294n.a(j10 >= 0);
        AbstractC1294n.a(j12 >= 0);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j8;
        this.zzd = j9;
        this.zze = j10;
        this.zzf = j11;
        this.zzg = j12;
        this.zzh = l8;
        this.zzi = l9;
        this.zzj = l10;
        this.zzk = bool;
    }

    public final zzbc zza(long j8) {
        return new zzbc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, j8, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }

    public final zzbc zzb(long j8, long j9) {
        return new zzbc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j8, Long.valueOf(j9), this.zzi, this.zzj, this.zzk);
    }

    public final zzbc zzc(Long l8, Long l9, Boolean bool) {
        return new zzbc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l8, l9, bool);
    }
}
