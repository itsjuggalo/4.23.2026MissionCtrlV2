package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: loaded from: classes.dex */
public final class zzbg extends T1.a {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbh();
    public final String zza;
    public final zzbe zzb;
    public final String zzc;
    public final long zzd;

    public zzbg(zzbg zzbgVar, long j8) {
        AbstractC1294n.j(zzbgVar);
        this.zza = zzbgVar.zza;
        this.zzb = zzbgVar.zzb;
        this.zzc = zzbgVar.zzc;
        this.zzd = j8;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        String str = this.zzc;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + strValueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(strValueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        zzbh.zza(this, parcel, i8);
    }

    public zzbg(String str, zzbe zzbeVar, String str2, long j8) {
        this.zza = str;
        this.zzb = zzbeVar;
        this.zzc = str2;
        this.zzd = j8;
    }
}
