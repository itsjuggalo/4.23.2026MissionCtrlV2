package com.google.android.gms.internal.measurement;

import T1.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzdd extends T1.a {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final Bundle zzd;
    public final String zze;

    public zzdd(long j8, long j9, boolean z7, Bundle bundle, String str) {
        this.zza = j8;
        this.zzb = j9;
        this.zzc = z7;
        this.zzd = bundle;
        this.zze = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        long j8 = this.zza;
        int iA = c.a(parcel);
        c.m(parcel, 1, j8);
        c.m(parcel, 2, this.zzb);
        c.c(parcel, 3, this.zzc);
        c.e(parcel, 7, this.zzd, false);
        c.p(parcel, 8, this.zze, false);
        c.b(parcel, iA);
    }
}
