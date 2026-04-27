package com.google.android.gms.internal.location;

import A1.a;
import A1.c;
import P1.Y;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.C0926d;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzj extends a {
    final Y zzc;
    final List<C0926d> zzd;
    final String zze;
    static final List<C0926d> zza = Collections.EMPTY_LIST;
    static final Y zzb = new Y();
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    public zzj(Y y4, List<C0926d> list, String str) {
        this.zzc = y4;
        this.zzd = list;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return AbstractC0939q.b(this.zzc, zzjVar.zzc) && AbstractC0939q.b(this.zzd, zzjVar.zzd) && AbstractC0939q.b(this.zze, zzjVar.zze);
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
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.C(parcel, 1, this.zzc, i4, false);
        c.I(parcel, 2, this.zzd, false);
        c.E(parcel, 3, this.zze, false);
        c.b(parcel, iA);
    }
}
