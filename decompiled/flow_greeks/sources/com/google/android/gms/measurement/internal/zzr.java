package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.s;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzr extends n5.a {
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

    public zzr(String str, String str2, String str3, long j10, String str4, long j11, long j12, String str5, boolean z10, boolean z11, String str6, long j13, int i10, boolean z12, boolean z13, Boolean bool, long j14, List list, String str7, String str8, String str9, boolean z14, long j15, int i11, String str10, int i12, long j16, String str11, String str12, long j17, int i13) {
        s.e(str);
        this.zza = str;
        this.zzb = true == TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j10;
        this.zzd = str4;
        this.zze = j11;
        this.zzf = j12;
        this.zzg = str5;
        this.zzh = z10;
        this.zzi = z11;
        this.zzk = str6;
        this.zzl = j13;
        this.zzm = i10;
        this.zzn = z12;
        this.zzo = z13;
        this.zzp = bool;
        this.zzq = j14;
        this.zzr = list;
        this.zzs = str7;
        this.zzt = str8;
        this.zzu = str9;
        this.zzv = z14;
        this.zzw = j15;
        this.zzx = i11;
        this.zzy = str10;
        this.zzz = i12;
        this.zzA = j16;
        this.zzB = str11;
        this.zzC = str12;
        this.zzD = j17;
        this.zzE = i13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.zza;
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, str, false);
        n5.c.E(parcel, 3, this.zzb, false);
        n5.c.E(parcel, 4, this.zzc, false);
        n5.c.E(parcel, 5, this.zzd, false);
        n5.c.x(parcel, 6, this.zze);
        n5.c.x(parcel, 7, this.zzf);
        n5.c.E(parcel, 8, this.zzg, false);
        n5.c.g(parcel, 9, this.zzh);
        n5.c.g(parcel, 10, this.zzi);
        n5.c.x(parcel, 11, this.zzj);
        n5.c.E(parcel, 12, this.zzk, false);
        n5.c.x(parcel, 14, this.zzl);
        n5.c.t(parcel, 15, this.zzm);
        n5.c.g(parcel, 16, this.zzn);
        n5.c.g(parcel, 18, this.zzo);
        n5.c.i(parcel, 21, this.zzp, false);
        n5.c.x(parcel, 22, this.zzq);
        n5.c.G(parcel, 23, this.zzr, false);
        n5.c.E(parcel, 25, this.zzs, false);
        n5.c.E(parcel, 26, this.zzt, false);
        n5.c.E(parcel, 27, this.zzu, false);
        n5.c.g(parcel, 28, this.zzv);
        n5.c.x(parcel, 29, this.zzw);
        n5.c.t(parcel, 30, this.zzx);
        n5.c.E(parcel, 31, this.zzy, false);
        n5.c.t(parcel, 32, this.zzz);
        n5.c.x(parcel, 34, this.zzA);
        n5.c.E(parcel, 35, this.zzB, false);
        n5.c.E(parcel, 36, this.zzC, false);
        n5.c.x(parcel, 37, this.zzD);
        n5.c.t(parcel, 38, this.zzE);
        n5.c.b(parcel, iA);
    }

    public zzr(String str, String str2, String str3, String str4, long j10, long j11, String str5, boolean z10, boolean z11, long j12, String str6, long j13, int i10, boolean z12, boolean z13, Boolean bool, long j14, List list, String str7, String str8, String str9, boolean z14, long j15, int i11, String str10, int i12, long j16, String str11, String str12, long j17, int i13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j12;
        this.zzd = str4;
        this.zze = j10;
        this.zzf = j11;
        this.zzg = str5;
        this.zzh = z10;
        this.zzi = z11;
        this.zzk = str6;
        this.zzl = j13;
        this.zzm = i10;
        this.zzn = z12;
        this.zzo = z13;
        this.zzp = bool;
        this.zzq = j14;
        this.zzr = list;
        this.zzs = str7;
        this.zzt = str8;
        this.zzu = str9;
        this.zzv = z14;
        this.zzw = j15;
        this.zzx = i11;
        this.zzy = str10;
        this.zzz = i12;
        this.zzA = j16;
        this.zzB = str11;
        this.zzC = str12;
        this.zzD = j17;
        this.zzE = i13;
    }
}
