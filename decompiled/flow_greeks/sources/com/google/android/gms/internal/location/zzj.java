package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.VisibleForTesting;
import e6.x0;
import java.util.Collections;
import java.util.List;
import n5.a;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzj extends a {
    final x0 zzc;
    final List<d> zzd;
    final String zze;

    @VisibleForTesting
    static final List<d> zza = Collections.EMPTY_LIST;
    static final x0 zzb = new x0();
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    public zzj(x0 x0Var, List<d> list, String str) {
        this.zzc = x0Var;
        this.zzd = list;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return q.b(this.zzc, zzjVar.zzc) && q.b(this.zzd, zzjVar.zzd) && q.b(this.zze, zzjVar.zze);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(this.zzd);
        String str = this.zze;
        int length = strValueOf.length();
        StringBuilder sb2 = new StringBuilder(length + 77 + strValueOf2.length() + String.valueOf(str).length());
        sb2.append("DeviceOrientationRequestInternal{deviceOrientationRequest=");
        sb2.append(strValueOf);
        sb2.append(", clients=");
        sb2.append(strValueOf2);
        sb2.append(", tag='");
        sb2.append(str);
        sb2.append("'}");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.C(parcel, 1, this.zzc, i10, false);
        c.I(parcel, 2, this.zzd, false);
        c.E(parcel, 3, this.zze, false);
        c.b(parcel, iA);
    }
}
