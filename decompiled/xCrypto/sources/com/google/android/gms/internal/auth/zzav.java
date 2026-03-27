package com.google.android.gms.internal.auth;

import A1.a;
import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class zzav extends a {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();
    final int zza;
    public final String zzb;
    public final int zzc;

    public zzav(int i4, String str, int i5) {
        this.zza = 1;
        this.zzb = (String) AbstractC0940s.k(str);
        this.zzc = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.zza);
        c.E(parcel, 2, this.zzb, false);
        c.t(parcel, 3, this.zzc);
        c.b(parcel, iA);
    }

    public zzav(String str, int i4) {
        this(1, str, i4);
    }
}
