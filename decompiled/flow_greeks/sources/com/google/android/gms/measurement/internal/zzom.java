package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzom extends n5.a {
    public static final Parcelable.Creator<zzom> CREATOR = new zzon();
    public final long zza;
    public byte[] zzb;
    public final String zzc;
    public final Bundle zzd;
    public final int zze;
    public final long zzf;
    public String zzg;

    public zzom(long j10, byte[] bArr, String str, Bundle bundle, int i10, long j11, String str2) {
        this.zza = j10;
        this.zzb = bArr;
        this.zzc = str;
        this.zzd = bundle;
        this.zze = i10;
        this.zzf = j11;
        this.zzg = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        long j10 = this.zza;
        int iA = n5.c.a(parcel);
        n5.c.x(parcel, 1, j10);
        n5.c.k(parcel, 2, this.zzb, false);
        n5.c.E(parcel, 3, this.zzc, false);
        n5.c.j(parcel, 4, this.zzd, false);
        n5.c.t(parcel, 5, this.zze);
        n5.c.x(parcel, 6, this.zzf);
        n5.c.E(parcel, 7, this.zzg, false);
        n5.c.b(parcel, iA);
    }
}
