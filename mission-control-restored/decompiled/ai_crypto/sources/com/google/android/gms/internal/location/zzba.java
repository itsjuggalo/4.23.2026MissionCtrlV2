package com.google.android.gms.internal.location;

import Q1.a;
import Q1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.C1193d;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzba extends a {
    final LocationRequest zzb;
    final List<C1193d> zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final String zzh;
    final boolean zzi;
    boolean zzj;
    String zzk;
    long zzl;
    static final List<C1193d> zza = Collections.emptyList();
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();

    public zzba(LocationRequest locationRequest, List<C1193d> list, String str, boolean z7, boolean z8, boolean z9, String str2, boolean z10, boolean z11, String str3, long j7) {
        this.zzb = locationRequest;
        this.zzc = list;
        this.zzd = str;
        this.zze = z7;
        this.zzf = z8;
        this.zzg = z9;
        this.zzh = str2;
        this.zzi = z10;
        this.zzj = z11;
        this.zzk = str3;
        this.zzl = j7;
    }

    public static zzba zza(String str, LocationRequest locationRequest) {
        return new zzba(locationRequest, zza, null, false, false, false, null, false, false, null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            if (AbstractC1206q.b(this.zzb, zzbaVar.zzb) && AbstractC1206q.b(this.zzc, zzbaVar.zzc) && AbstractC1206q.b(this.zzd, zzbaVar.zzd) && this.zze == zzbaVar.zze && this.zzf == zzbaVar.zzf && this.zzg == zzbaVar.zzg && AbstractC1206q.b(this.zzh, zzbaVar.zzh) && this.zzi == zzbaVar.zzi && this.zzj == zzbaVar.zzj && AbstractC1206q.b(this.zzk, zzbaVar.zzk)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        if (this.zzd != null) {
            sb.append(" tag=");
            sb.append(this.zzd);
        }
        if (this.zzh != null) {
            sb.append(" moduleId=");
            sb.append(this.zzh);
        }
        if (this.zzk != null) {
            sb.append(" contextAttributionTag=");
            sb.append(this.zzk);
        }
        sb.append(" hideAppOps=");
        sb.append(this.zze);
        sb.append(" clients=");
        sb.append(this.zzc);
        sb.append(" forceCoarseLocation=");
        sb.append(this.zzf);
        if (this.zzg) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        if (this.zzi) {
            sb.append(" locationSettingsIgnored");
        }
        if (this.zzj) {
            sb.append(" inaccurateLocationsDelayed");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.C(parcel, 1, this.zzb, i7, false);
        c.I(parcel, 5, this.zzc, false);
        c.E(parcel, 6, this.zzd, false);
        c.g(parcel, 7, this.zze);
        c.g(parcel, 8, this.zzf);
        c.g(parcel, 9, this.zzg);
        c.E(parcel, 10, this.zzh, false);
        c.g(parcel, 11, this.zzi);
        c.g(parcel, 12, this.zzj);
        c.E(parcel, 13, this.zzk, false);
        c.x(parcel, 14, this.zzl);
        c.b(parcel, iA);
    }

    public final zzba zzb(long j7) {
        if (this.zzb.B() <= this.zzb.A()) {
            this.zzl = 10000L;
            return this;
        }
        long jA = this.zzb.A();
        long jB = this.zzb.B();
        StringBuilder sb = new StringBuilder(120);
        sb.append("could not set max age when location batching is requested, interval=");
        sb.append(jA);
        sb.append("maxWaitTime=");
        sb.append(jB);
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzba zzc(String str) {
        this.zzk = str;
        return this;
    }

    public final zzba zzd(boolean z7) {
        this.zzj = true;
        return this;
    }
}
