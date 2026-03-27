package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends T1.a {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    public final long zzA;
    public final String zzB;
    public final String zzC;
    public final long zzD;
    public final int zzE;
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final long zze;
    public final long zzf;
    public final String zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final long zzj;
    public final String zzk;
    public final long zzl;
    public final int zzm;
    public final boolean zzn;
    public final boolean zzo;
    public final Boolean zzp;
    public final long zzq;
    public final List zzr;
    public final String zzs;
    public final String zzt;
    public final String zzu;
    public final boolean zzv;
    public final long zzw;
    public final int zzx;
    public final String zzy;
    public final int zzz;

    public zzr(String str, String str2, String str3, long j8, String str4, long j9, long j10, String str5, boolean z7, boolean z8, String str6, long j11, int i8, boolean z9, boolean z10, Boolean bool, long j12, List list, String str7, String str8, String str9, boolean z11, long j13, int i9, String str10, int i10, long j14, String str11, String str12, long j15, int i11) {
        AbstractC1294n.d(str);
        this.zza = str;
        this.zzb = true == TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j8;
        this.zzd = str4;
        this.zze = j9;
        this.zzf = j10;
        this.zzg = str5;
        this.zzh = z7;
        this.zzi = z8;
        this.zzk = str6;
        this.zzl = j11;
        this.zzm = i8;
        this.zzn = z9;
        this.zzo = z10;
        this.zzp = bool;
        this.zzq = j12;
        this.zzr = list;
        this.zzs = str7;
        this.zzt = str8;
        this.zzu = str9;
        this.zzv = z11;
        this.zzw = j13;
        this.zzx = i9;
        this.zzy = str10;
        this.zzz = i10;
        this.zzA = j14;
        this.zzB = str11;
        this.zzC = str12;
        this.zzD = j15;
        this.zzE = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        String str = this.zza;
        int iA = T1.c.a(parcel);
        T1.c.p(parcel, 2, str, false);
        T1.c.p(parcel, 3, this.zzb, false);
        T1.c.p(parcel, 4, this.zzc, false);
        T1.c.p(parcel, 5, this.zzd, false);
        T1.c.m(parcel, 6, this.zze);
        T1.c.m(parcel, 7, this.zzf);
        T1.c.p(parcel, 8, this.zzg, false);
        T1.c.c(parcel, 9, this.zzh);
        T1.c.c(parcel, 10, this.zzi);
        T1.c.m(parcel, 11, this.zzj);
        T1.c.p(parcel, 12, this.zzk, false);
        T1.c.m(parcel, 14, this.zzl);
        T1.c.j(parcel, 15, this.zzm);
        T1.c.c(parcel, 16, this.zzn);
        T1.c.c(parcel, 18, this.zzo);
        T1.c.d(parcel, 21, this.zzp, false);
        T1.c.m(parcel, 22, this.zzq);
        T1.c.q(parcel, 23, this.zzr, false);
        T1.c.p(parcel, 25, this.zzs, false);
        T1.c.p(parcel, 26, this.zzt, false);
        T1.c.p(parcel, 27, this.zzu, false);
        T1.c.c(parcel, 28, this.zzv);
        T1.c.m(parcel, 29, this.zzw);
        T1.c.j(parcel, 30, this.zzx);
        T1.c.p(parcel, 31, this.zzy, false);
        T1.c.j(parcel, 32, this.zzz);
        T1.c.m(parcel, 34, this.zzA);
        T1.c.p(parcel, 35, this.zzB, false);
        T1.c.p(parcel, 36, this.zzC, false);
        T1.c.m(parcel, 37, this.zzD);
        T1.c.j(parcel, 38, this.zzE);
        T1.c.b(parcel, iA);
    }

    public zzr(String str, String str2, String str3, String str4, long j8, long j9, String str5, boolean z7, boolean z8, long j10, String str6, long j11, int i8, boolean z9, boolean z10, Boolean bool, long j12, List list, String str7, String str8, String str9, boolean z11, long j13, int i9, String str10, int i10, long j14, String str11, String str12, long j15, int i11) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j10;
        this.zzd = str4;
        this.zze = j8;
        this.zzf = j9;
        this.zzg = str5;
        this.zzh = z7;
        this.zzi = z8;
        this.zzk = str6;
        this.zzl = j11;
        this.zzm = i8;
        this.zzn = z9;
        this.zzo = z10;
        this.zzp = bool;
        this.zzq = j12;
        this.zzr = list;
        this.zzs = str7;
        this.zzt = str8;
        this.zzu = str9;
        this.zzv = z11;
        this.zzw = j13;
        this.zzx = i9;
        this.zzy = str10;
        this.zzz = i10;
        this.zzA = j14;
        this.zzB = str11;
        this.zzC = str12;
        this.zzD = j15;
        this.zzE = i11;
    }
}
