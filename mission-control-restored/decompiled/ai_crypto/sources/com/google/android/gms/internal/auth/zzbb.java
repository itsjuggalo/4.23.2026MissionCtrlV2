package com.google.android.gms.internal.auth;

import Q1.a;
import Q1.c;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class zzbb extends a {
    public static final Parcelable.Creator<zzbb> CREATOR = new zzbc();
    final int zza;
    public final String zzb;
    public final PendingIntent zzc;

    public zzbb(int i7, String str, PendingIntent pendingIntent) {
        this.zza = 1;
        this.zzb = (String) AbstractC1207s.k(str);
        this.zzc = (PendingIntent) AbstractC1207s.k(pendingIntent);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.zza);
        c.E(parcel, 2, this.zzb, false);
        c.C(parcel, 3, this.zzc, i7, false);
        c.b(parcel, iA);
    }

    public zzbb(String str, PendingIntent pendingIntent) {
        this(1, str, pendingIntent);
    }
}
