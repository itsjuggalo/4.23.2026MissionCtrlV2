package com.google.android.gms.internal.measurement;

import android.net.Uri;
import v2.InterfaceC2840f;

/* JADX INFO: loaded from: classes.dex */
public final class zzkg {
    final Uri zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final boolean zze;

    public zzkg(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final zzkg zza() {
        String str = this.zzb;
        if (str.isEmpty()) {
            return new zzkg(null, this.zza, str, this.zzc, true, false, this.zze, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzkg zzb() {
        return new zzkg(null, this.zza, this.zzb, this.zzc, this.zzd, false, true, false, null);
    }

    public final zzkm zzc(String str, long j8) {
        Long lValueOf = Long.valueOf(j8);
        int i8 = zzkm.zzc;
        return new zzkc(this, str, lValueOf, true);
    }

    public final zzkm zzd(String str, boolean z7) {
        Boolean boolValueOf = Boolean.valueOf(z7);
        int i8 = zzkm.zzc;
        return new zzkd(this, str, boolValueOf, true);
    }

    public final zzkm zze(String str, double d8) {
        Double dValueOf = Double.valueOf(-3.0d);
        int i8 = zzkm.zzc;
        return new zzke(this, "measurement.test.double_flag", dValueOf, true);
    }

    public final zzkm zzf(String str, String str2) {
        int i8 = zzkm.zzc;
        return new zzkf(this, str, str2, true);
    }

    private zzkg(String str, Uri uri, String str2, String str3, boolean z7, boolean z8, boolean z9, boolean z10, InterfaceC2840f interfaceC2840f) {
        this.zza = uri;
        this.zzb = "";
        this.zzc = "";
        this.zzd = z7;
        this.zze = z9;
    }
}
