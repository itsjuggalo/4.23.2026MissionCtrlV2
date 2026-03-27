package com.google.android.gms.location;

import Q1.a;
import Q1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.ReflectedParcelable;
import f2.C1553D;
import f2.C1563N;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LocationAvailability extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new C1553D();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C1563N[] f11229e;

    public LocationAvailability(int i7, int i8, int i9, long j7, C1563N[] c1563nArr) {
        this.f11228d = i7;
        this.f11225a = i8;
        this.f11226b = i9;
        this.f11227c = j7;
        this.f11229e = c1563nArr;
    }

    public boolean A() {
        return this.f11228d < 1000;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f11225a == locationAvailability.f11225a && this.f11226b == locationAvailability.f11226b && this.f11227c == locationAvailability.f11227c && this.f11228d == locationAvailability.f11228d && Arrays.equals(this.f11229e, locationAvailability.f11229e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f11228d), Integer.valueOf(this.f11225a), Integer.valueOf(this.f11226b), Long.valueOf(this.f11227c), this.f11229e);
    }

    public String toString() {
        boolean zA = A();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(zA);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f11225a);
        c.t(parcel, 2, this.f11226b);
        c.x(parcel, 3, this.f11227c);
        c.t(parcel, 4, this.f11228d);
        c.H(parcel, 5, this.f11229e, i7, false);
        c.b(parcel, iA);
    }
}
