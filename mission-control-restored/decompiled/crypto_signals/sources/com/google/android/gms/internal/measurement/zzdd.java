package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class zzdd extends AbstractC1255a {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final Bundle zzd;
    public final String zze;

    public zzdd(long j4, long j6, boolean z6, Bundle bundle, String str) {
        this.zza = j4;
        this.zzb = j6;
        this.zzc = z6;
        this.zzd = bundle;
        this.zze = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        long j4 = this.zza;
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 8);
        parcel.writeLong(j4);
        long j6 = this.zzb;
        u0.b0(parcel, 2, 8);
        parcel.writeLong(j6);
        boolean z6 = this.zzc;
        u0.b0(parcel, 3, 4);
        parcel.writeInt(z6 ? 1 : 0);
        u0.L(parcel, 7, this.zzd, false);
        u0.T(parcel, 8, this.zze, false);
        u0.a0(iX, parcel);
    }
}
