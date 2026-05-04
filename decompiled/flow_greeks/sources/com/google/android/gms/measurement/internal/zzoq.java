package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzoq extends n5.a {
    public static final Parcelable.Creator<zzoq> CREATOR = new zzor();
    public final List zza;

    public zzoq(List list) {
        this.zza = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        List list = this.zza;
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, list, false);
        n5.c.b(parcel, iA);
    }
}
