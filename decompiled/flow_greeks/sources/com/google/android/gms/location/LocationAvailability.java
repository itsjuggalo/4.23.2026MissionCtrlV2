package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import e6.d0;
import e6.n0;
import java.util.Arrays;
import n5.a;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class LocationAvailability extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n0[] f5870e;

    public LocationAvailability(int i10, int i11, int i12, long j10, n0[] n0VarArr) {
        this.f5869d = i10;
        this.f5866a = i11;
        this.f5867b = i12;
        this.f5868c = j10;
        this.f5870e = n0VarArr;
    }

    public boolean R() {
        return this.f5869d < 1000;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f5866a == locationAvailability.f5866a && this.f5867b == locationAvailability.f5867b && this.f5868c == locationAvailability.f5868c && this.f5869d == locationAvailability.f5869d && Arrays.equals(this.f5870e, locationAvailability.f5870e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return q.c(Integer.valueOf(this.f5869d), Integer.valueOf(this.f5866a), Integer.valueOf(this.f5867b), Long.valueOf(this.f5868c), this.f5870e);
    }

    public String toString() {
        boolean zR = R();
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("LocationAvailability[isLocationAvailable: ");
        sb2.append(zR);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f5866a);
        c.t(parcel, 2, this.f5867b);
        c.x(parcel, 3, this.f5868c);
        c.t(parcel, 4, this.f5869d);
        c.H(parcel, 5, this.f5870e, i10, false);
        c.b(parcel, iA);
    }
}
