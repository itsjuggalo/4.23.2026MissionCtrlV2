package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzaf extends T1.a {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
    public final long zza;
    public final int zzb;
    public final long zzc;

    public zzaf(long j8, int i8, long j9) {
        this.zza = j8;
        this.zzb = i8;
        this.zzc = j9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        long j8 = this.zza;
        int iA = T1.c.a(parcel);
        T1.c.m(parcel, 1, j8);
        T1.c.j(parcel, 2, this.zzb);
        T1.c.m(parcel, 3, this.zzc);
        T1.c.b(parcel, iA);
    }
}
