package com.google.android.gms.internal.location;

import Q1.a;
import Q1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.C1193d;
import f2.C1573Y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzj extends a {
    final C1573Y zzc;
    final List<C1193d> zzd;
    final String zze;
    static final List<C1193d> zza = Collections.emptyList();
    static final C1573Y zzb = new C1573Y();
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    public zzj(C1573Y c1573y, List<C1193d> list, String str) {
        this.zzc = c1573y;
        this.zzd = list;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return AbstractC1206q.b(this.zzc, zzjVar.zzc) && AbstractC1206q.b(this.zzd, zzjVar.zzd) && AbstractC1206q.b(this.zze, zzjVar.zze);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(this.zzd);
        String str = this.zze;
        int length = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 77 + strValueOf2.length() + String.valueOf(str).length());
        sb.append("DeviceOrientationRequestInternal{deviceOrientationRequest=");
        sb.append(strValueOf);
        sb.append(", clients=");
        sb.append(strValueOf2);
        sb.append(", tag='");
        sb.append(str);
        sb.append("'}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.C(parcel, 1, this.zzc, i7, false);
        c.I(parcel, 2, this.zzd, false);
        c.E(parcel, 3, this.zze, false);
        c.b(parcel, iA);
    }
}
