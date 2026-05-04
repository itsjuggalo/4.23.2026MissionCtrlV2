package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzoh extends n5.a {
    public static final Parcelable.Creator<zzoh> CREATOR = new zzoi();
    public final String zza;
    public final long zzb;
    public final int zzc;

    public zzoh(String str, long j10, int i10) {
        this.zza = str;
        this.zzb = j10;
        this.zzc = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.zza;
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, str, false);
        n5.c.x(parcel, 2, this.zzb);
        n5.c.t(parcel, 3, this.zzc);
        n5.c.b(parcel, iA);
    }
}
