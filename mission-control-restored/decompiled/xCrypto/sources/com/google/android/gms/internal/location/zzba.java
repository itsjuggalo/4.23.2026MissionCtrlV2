package com.google.android.gms.internal.location;

import A1.a;
import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.C0926d;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzba extends a {
    final LocationRequest zzb;
    final List<C0926d> zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final String zzh;
    final boolean zzi;
    boolean zzj;
    String zzk;
    long zzl;
    static final List<C0926d> zza = Collections.EMPTY_LIST;
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();

    public zzba(LocationRequest locationRequest, List<C0926d> list, String str, boolean z4, boolean z5, boolean z6, String str2, boolean z7, boolean z8, String str3, long j4) {
        this.zzb = locationRequest;
        this.zzc = list;
        this.zzd = str;
        this.zze = z4;
        this.zzf = z5;
        this.zzg = z6;
        this.zzh = str2;
        this.zzi = z7;
        this.zzj = z8;
        this.zzk = str3;
        this.zzl = j4;
    }

    public static zzba zza(String str, LocationRequest locationRequest) {
        return new zzba(locationRequest, zza, null, false, false, false, null, false, false, null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            if (AbstractC0939q.b(this.zzb, zzbaVar.zzb) && AbstractC0939q.b(this.zzc, zzbaVar.zzc) && AbstractC0939q.b(this.zzd, zzbaVar.zzd) && this.zze == zzbaVar.zze && this.zzf == zzbaVar.zzf && this.zzg == zzbaVar.zzg && AbstractC0939q.b(this.zzh, zzbaVar.zzh) && this.zzi == zzbaVar.zzi && this.zzj == zzbaVar.zzj && AbstractC0939q.b(this.zzk, zzbaVar.zzk)) {
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
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.C(parcel, 1, this.zzb, i4, false);
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

    public final zzba zzb(long j4) {
        if (this.zzb.k() <= this.zzb.i()) {
            this.zzl = 10000L;
            return this;
        }
        long jI = this.zzb.i();
        long jK = this.zzb.k();
        StringBuilder sb = new StringBuilder(120);
        sb.append("could not set max age when location batching is requested, interval=");
        sb.append(jI);
        sb.append("maxWaitTime=");
        sb.append(jK);
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzba zzc(String str) {
        this.zzk = str;
        return this;
    }

    public final zzba zzd(boolean z4) {
        this.zzj = true;
        return this;
    }
}
