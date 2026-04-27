package com.google.android.gms.location;

import A1.a;
import A1.c;
import P1.D;
import P1.N;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LocationAvailability extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new D();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public N[] f10046e;

    public LocationAvailability(int i4, int i5, int i6, long j4, N[] nArr) {
        this.f10045d = i4;
        this.f10042a = i5;
        this.f10043b = i6;
        this.f10044c = j4;
        this.f10046e = nArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f10042a == locationAvailability.f10042a && this.f10043b == locationAvailability.f10043b && this.f10044c == locationAvailability.f10044c && this.f10045d == locationAvailability.f10045d && Arrays.equals(this.f10046e, locationAvailability.f10046e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f10045d), Integer.valueOf(this.f10042a), Integer.valueOf(this.f10043b), Long.valueOf(this.f10044c), this.f10046e);
    }

    public boolean i() {
        return this.f10045d < 1000;
    }

    public String toString() {
        boolean zI = i();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(zI);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f10042a);
        c.t(parcel, 2, this.f10043b);
        c.x(parcel, 3, this.f10044c);
        c.t(parcel, 4, this.f10045d);
        c.H(parcel, 5, this.f10046e, i4, false);
        c.b(parcel, iA);
    }
}
