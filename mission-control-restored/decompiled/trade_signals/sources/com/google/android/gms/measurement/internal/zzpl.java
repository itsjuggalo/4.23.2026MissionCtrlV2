package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: loaded from: classes.dex */
public final class zzpl extends T1.a {
    public static final Parcelable.Creator<zzpl> CREATOR = new zzpm();
    public final int zza;
    public final String zzb;
    public final long zzc;
    public final Long zzd;
    public final String zze;
    public final String zzf;
    public final Double zzg;

    public zzpl(int i8, String str, long j8, Long l8, Float f8, String str2, String str3, Double d8) {
        this.zza = i8;
        this.zzb = str;
        this.zzc = j8;
        this.zzd = l8;
        this.zzg = i8 == 1 ? f8 != null ? Double.valueOf(f8.doubleValue()) : null : d8;
        this.zze = str2;
        this.zzf = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        zzpm.zza(this, parcel, i8);
    }

    public final Object zza() {
        Long l8 = this.zzd;
        if (l8 != null) {
            return l8;
        }
        Double d8 = this.zzg;
        if (d8 != null) {
            return d8;
        }
        String str = this.zze;
        if (str != null) {
            return str;
        }
        return null;
    }

    public zzpl(zzpn zzpnVar) {
        this(zzpnVar.zzc, zzpnVar.zzd, zzpnVar.zze, zzpnVar.zzb);
    }

    public zzpl(String str, long j8, Object obj, String str2) {
        AbstractC1294n.d(str);
        this.zza = 2;
        this.zzb = str;
        this.zzc = j8;
        this.zzf = str2;
        if (obj == null) {
            this.zzd = null;
            this.zzg = null;
            this.zze = null;
            return;
        }
        if (obj instanceof Long) {
            this.zzd = (Long) obj;
            this.zzg = null;
            this.zze = null;
        } else if (obj instanceof String) {
            this.zzd = null;
            this.zzg = null;
            this.zze = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.zzd = null;
            this.zzg = (Double) obj;
            this.zze = null;
        }
    }
}
