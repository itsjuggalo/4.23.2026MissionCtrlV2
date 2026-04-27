package com.google.android.gms.internal.measurement;

import A1.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzdd extends A1.a {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final Bundle zzd;
    public final String zze;

    public zzdd(long j4, long j5, boolean z4, Bundle bundle, String str) {
        this.zza = j4;
        this.zzb = j5;
        this.zzc = z4;
        this.zzd = bundle;
        this.zze = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        long j4 = this.zza;
        int iA = c.a(parcel);
        c.x(parcel, 1, j4);
        c.x(parcel, 2, this.zzb);
        c.g(parcel, 3, this.zzc);
        c.j(parcel, 7, this.zzd, false);
        c.E(parcel, 8, this.zze, false);
        c.b(parcel, iA);
    }
}
