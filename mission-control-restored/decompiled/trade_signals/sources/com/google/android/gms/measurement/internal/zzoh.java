package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzoh extends T1.a {
    public static final Parcelable.Creator<zzoh> CREATOR = new zzoi();
    public final String zza;
    public final long zzb;
    public final int zzc;

    public zzoh(String str, long j8, int i8) {
        this.zza = str;
        this.zzb = j8;
        this.zzc = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        String str = this.zza;
        int iA = T1.c.a(parcel);
        T1.c.p(parcel, 1, str, false);
        T1.c.m(parcel, 2, this.zzb);
        T1.c.j(parcel, 3, this.zzc);
        T1.c.b(parcel, iA);
    }
}
