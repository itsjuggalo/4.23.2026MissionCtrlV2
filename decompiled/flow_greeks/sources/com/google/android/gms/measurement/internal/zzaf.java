package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaf extends n5.a {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
    public final long zza;
    public final int zzb;
    public final long zzc;

    public zzaf(long j10, int i10, long j11) {
        this.zza = j10;
        this.zzb = i10;
        this.zzc = j11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        long j10 = this.zza;
        int iA = n5.c.a(parcel);
        n5.c.x(parcel, 1, j10);
        n5.c.t(parcel, 2, this.zzb);
        n5.c.x(parcel, 3, this.zzc);
        n5.c.b(parcel, iA);
    }
}
