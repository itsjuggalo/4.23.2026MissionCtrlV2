package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdd extends n5.a {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final Bundle zzd;
    public final String zze;

    public zzdd(long j10, long j11, boolean z10, Bundle bundle, String str) {
        this.zza = j10;
        this.zzb = j11;
        this.zzc = z10;
        this.zzd = bundle;
        this.zze = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        long j10 = this.zza;
        int iA = c.a(parcel);
        c.x(parcel, 1, j10);
        c.x(parcel, 2, this.zzb);
        c.g(parcel, 3, this.zzc);
        c.j(parcel, 7, this.zzd, false);
        c.E(parcel, 8, this.zze, false);
        c.b(parcel, iA);
    }
}
