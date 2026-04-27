package com.google.android.gms.internal.measurement;

import Q1.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzdd extends Q1.a {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final Bundle zzd;
    public final String zze;

    public zzdd(long j7, long j8, boolean z7, Bundle bundle, String str) {
        this.zza = j7;
        this.zzb = j8;
        this.zzc = z7;
        this.zzd = bundle;
        this.zze = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        long j7 = this.zza;
        int iA = c.a(parcel);
        c.x(parcel, 1, j7);
        c.x(parcel, 2, this.zzb);
        c.g(parcel, 3, this.zzc);
        c.j(parcel, 7, this.zzd, false);
        c.E(parcel, 8, this.zze, false);
        c.b(parcel, iA);
    }
}
