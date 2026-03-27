package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class zzbb extends AbstractC1255a {
    public static final Parcelable.Creator<zzbb> CREATOR = new zzbc();
    final int zza;
    public final String zzb;
    public final PendingIntent zzc;

    public zzbb(int i, String str, PendingIntent pendingIntent) {
        this.zza = 1;
        I.g(str);
        this.zzb = str;
        I.g(pendingIntent);
        this.zzc = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        int i6 = this.zza;
        u0.b0(parcel, 1, 4);
        parcel.writeInt(i6);
        u0.T(parcel, 2, this.zzb, false);
        u0.S(parcel, 3, this.zzc, i, false);
        u0.a0(iX, parcel);
    }

    public zzbb(String str, PendingIntent pendingIntent) {
        this(1, str, pendingIntent);
    }
}
