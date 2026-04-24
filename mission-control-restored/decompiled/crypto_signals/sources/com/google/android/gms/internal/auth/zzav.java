package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class zzav extends AbstractC1255a {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();
    final int zza;
    public final String zzb;
    public final int zzc;

    public zzav(int i, String str, int i6) {
        this.zza = 1;
        I.g(str);
        this.zzb = str;
        this.zzc = i6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        int i6 = this.zza;
        u0.b0(parcel, 1, 4);
        parcel.writeInt(i6);
        u0.T(parcel, 2, this.zzb, false);
        int i7 = this.zzc;
        u0.b0(parcel, 3, 4);
        parcel.writeInt(i7);
        u0.a0(iX, parcel);
    }

    public zzav(String str, int i) {
        this(1, str, i);
    }
}
