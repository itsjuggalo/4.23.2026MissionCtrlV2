package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class zzbw extends AbstractC1255a {
    public static final Parcelable.Creator<zzbw> CREATOR = new zzbx();
    final int zza;
    String zzb;

    public zzbw() {
        this.zza = 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        int i6 = this.zza;
        u0.b0(parcel, 1, 4);
        parcel.writeInt(i6);
        u0.T(parcel, 2, this.zzb, false);
        u0.a0(iX, parcel);
    }

    public final zzbw zza(String str) {
        this.zzb = str;
        return this;
    }

    public zzbw(int i, String str) {
        this.zza = i;
        this.zzb = str;
    }
}
