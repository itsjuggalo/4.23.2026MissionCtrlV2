package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzom extends T1.a {
    public static final Parcelable.Creator<zzom> CREATOR = new zzon();
    public final long zza;
    public byte[] zzb;
    public final String zzc;
    public final Bundle zzd;
    public final int zze;
    public final long zzf;
    public String zzg;

    public zzom(long j8, byte[] bArr, String str, Bundle bundle, int i8, long j9, String str2) {
        this.zza = j8;
        this.zzb = bArr;
        this.zzc = str;
        this.zzd = bundle;
        this.zze = i8;
        this.zzf = j9;
        this.zzg = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        long j8 = this.zza;
        int iA = T1.c.a(parcel);
        T1.c.m(parcel, 1, j8);
        T1.c.f(parcel, 2, this.zzb, false);
        T1.c.p(parcel, 3, this.zzc, false);
        T1.c.e(parcel, 4, this.zzd, false);
        T1.c.j(parcel, 5, this.zze);
        T1.c.m(parcel, 6, this.zzf);
        T1.c.p(parcel, 7, this.zzg, false);
        T1.c.b(parcel, iA);
    }
}
