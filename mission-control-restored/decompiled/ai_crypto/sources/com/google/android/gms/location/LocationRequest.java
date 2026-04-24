package com.google.android.gms.location;

import Q1.a;
import Q1.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.ReflectedParcelable;
import f2.C1554E;

/* JADX INFO: loaded from: classes.dex */
public final class LocationRequest extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new C1554E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f11234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f11236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11238i;

    public LocationRequest(int i7, long j7, long j8, boolean z7, long j9, int i8, float f7, long j10, boolean z8) {
        this.f11230a = i7;
        this.f11231b = j7;
        this.f11232c = j8;
        this.f11233d = z7;
        this.f11234e = j9;
        this.f11235f = i8;
        this.f11236g = f7;
        this.f11237h = j10;
        this.f11238i = z8;
    }

    public long A() {
        return this.f11231b;
    }

    public long B() {
        long j7 = this.f11237h;
        long j8 = this.f11231b;
        return j7 < j8 ? j8 : j7;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.f11230a == locationRequest.f11230a && this.f11231b == locationRequest.f11231b && this.f11232c == locationRequest.f11232c && this.f11233d == locationRequest.f11233d && this.f11234e == locationRequest.f11234e && this.f11235f == locationRequest.f11235f && this.f11236g == locationRequest.f11236g && B() == locationRequest.B() && this.f11238i == locationRequest.f11238i) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f11230a), Long.valueOf(this.f11231b), Float.valueOf(this.f11236g), Long.valueOf(this.f11237h));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i7 = this.f11230a;
        sb.append(i7 != 100 ? i7 != 102 ? i7 != 104 ? i7 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f11230a != 105) {
            sb.append(" requested=");
            sb.append(this.f11231b);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.f11232c);
        sb.append("ms");
        if (this.f11237h > this.f11231b) {
            sb.append(" maxWait=");
            sb.append(this.f11237h);
            sb.append("ms");
        }
        if (this.f11236g > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.f11236g);
            sb.append("m");
        }
        long j7 = this.f11234e;
        if (j7 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j7 - jElapsedRealtime);
            sb.append("ms");
        }
        if (this.f11235f != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f11235f);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f11230a);
        c.x(parcel, 2, this.f11231b);
        c.x(parcel, 3, this.f11232c);
        c.g(parcel, 4, this.f11233d);
        c.x(parcel, 5, this.f11234e);
        c.t(parcel, 6, this.f11235f);
        c.p(parcel, 7, this.f11236g);
        c.x(parcel, 8, this.f11237h);
        c.g(parcel, 9, this.f11238i);
        c.b(parcel, iA);
    }
}
