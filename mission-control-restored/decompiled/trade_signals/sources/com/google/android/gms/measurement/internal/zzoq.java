package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzoq extends T1.a {
    public static final Parcelable.Creator<zzoq> CREATOR = new zzor();
    public final List zza;

    public zzoq(List list) {
        this.zza = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        List list = this.zza;
        int iA = T1.c.a(parcel);
        T1.c.s(parcel, 1, list, false);
        T1.c.b(parcel, iA);
    }
}
