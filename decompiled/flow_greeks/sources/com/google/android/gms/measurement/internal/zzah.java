package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzah extends n5.a {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();
    public String zza;
    public String zzb;
    public zzpl zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public final zzbg zzg;
    public long zzh;
    public zzbg zzi;
    public final long zzj;
    public final zzbg zzk;

    public zzah(zzah zzahVar) {
        s.k(zzahVar);
        this.zza = zzahVar.zza;
        this.zzb = zzahVar.zzb;
        this.zzc = zzahVar.zzc;
        this.zzd = zzahVar.zzd;
        this.zze = zzahVar.zze;
        this.zzf = zzahVar.zzf;
        this.zzg = zzahVar.zzg;
        this.zzh = zzahVar.zzh;
        this.zzi = zzahVar.zzi;
        this.zzj = zzahVar.zzj;
        this.zzk = zzahVar.zzk;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, this.zza, false);
        n5.c.E(parcel, 3, this.zzb, false);
        n5.c.C(parcel, 4, this.zzc, i10, false);
        n5.c.x(parcel, 5, this.zzd);
        n5.c.g(parcel, 6, this.zze);
        n5.c.E(parcel, 7, this.zzf, false);
        n5.c.C(parcel, 8, this.zzg, i10, false);
        n5.c.x(parcel, 9, this.zzh);
        n5.c.C(parcel, 10, this.zzi, i10, false);
        n5.c.x(parcel, 11, this.zzj);
        n5.c.C(parcel, 12, this.zzk, i10, false);
        n5.c.b(parcel, iA);
    }

    public zzah(String str, String str2, zzpl zzplVar, long j10, boolean z10, String str3, zzbg zzbgVar, long j11, zzbg zzbgVar2, long j12, zzbg zzbgVar3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzplVar;
        this.zzd = j10;
        this.zze = z10;
        this.zzf = str3;
        this.zzg = zzbgVar;
        this.zzh = j11;
        this.zzi = zzbgVar2;
        this.zzj = j12;
        this.zzk = zzbgVar3;
    }
}
