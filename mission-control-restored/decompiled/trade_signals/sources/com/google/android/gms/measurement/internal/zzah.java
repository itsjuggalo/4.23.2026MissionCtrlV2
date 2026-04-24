package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: loaded from: classes.dex */
public final class zzah extends T1.a {
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
        AbstractC1294n.j(zzahVar);
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
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.p(parcel, 2, this.zza, false);
        T1.c.p(parcel, 3, this.zzb, false);
        T1.c.o(parcel, 4, this.zzc, i8, false);
        T1.c.m(parcel, 5, this.zzd);
        T1.c.c(parcel, 6, this.zze);
        T1.c.p(parcel, 7, this.zzf, false);
        T1.c.o(parcel, 8, this.zzg, i8, false);
        T1.c.m(parcel, 9, this.zzh);
        T1.c.o(parcel, 10, this.zzi, i8, false);
        T1.c.m(parcel, 11, this.zzj);
        T1.c.o(parcel, 12, this.zzk, i8, false);
        T1.c.b(parcel, iA);
    }

    public zzah(String str, String str2, zzpl zzplVar, long j8, boolean z7, String str3, zzbg zzbgVar, long j9, zzbg zzbgVar2, long j10, zzbg zzbgVar3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzplVar;
        this.zzd = j8;
        this.zze = z7;
        this.zzf = str3;
        this.zzg = zzbgVar;
        this.zzh = j9;
        this.zzi = zzbgVar2;
        this.zzj = j10;
        this.zzk = zzbgVar3;
    }
}
