package com.google.android.gms.internal.auth;

import Q1.a;
import Q1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class zzaq extends a {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzar();
    final int zza;
    public final String zzb;

    public zzaq(int i7, String str) {
        this.zza = 1;
        this.zzb = (String) AbstractC1207s.k(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.zza);
        c.E(parcel, 2, this.zzb, false);
        c.b(parcel, iA);
    }

    public zzaq(String str) {
        this(1, str);
    }
}
