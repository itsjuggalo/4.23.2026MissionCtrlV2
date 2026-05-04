package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import e6.e0;
import n5.a;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class LocationRequest extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f5877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5879i;

    public LocationRequest(int i10, long j10, long j11, boolean z10, long j12, int i11, float f10, long j13, boolean z11) {
        this.f5871a = i10;
        this.f5872b = j10;
        this.f5873c = j11;
        this.f5874d = z10;
        this.f5875e = j12;
        this.f5876f = i11;
        this.f5877g = f10;
        this.f5878h = j13;
        this.f5879i = z11;
    }

    public long R() {
        return this.f5872b;
    }

    public long S() {
        long j10 = this.f5878h;
        long j11 = this.f5872b;
        return j10 < j11 ? j11 : j10;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.f5871a == locationRequest.f5871a && this.f5872b == locationRequest.f5872b && this.f5873c == locationRequest.f5873c && this.f5874d == locationRequest.f5874d && this.f5875e == locationRequest.f5875e && this.f5876f == locationRequest.f5876f && this.f5877g == locationRequest.f5877g && S() == locationRequest.S() && this.f5879i == locationRequest.f5879i) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return q.c(Integer.valueOf(this.f5871a), Long.valueOf(this.f5872b), Float.valueOf(this.f5877g), Long.valueOf(this.f5878h));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request[");
        int i10 = this.f5871a;
        sb2.append(i10 != 100 ? i10 != 102 ? i10 != 104 ? i10 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f5871a != 105) {
            sb2.append(" requested=");
            sb2.append(this.f5872b);
            sb2.append("ms");
        }
        sb2.append(" fastest=");
        sb2.append(this.f5873c);
        sb2.append("ms");
        if (this.f5878h > this.f5872b) {
            sb2.append(" maxWait=");
            sb2.append(this.f5878h);
            sb2.append("ms");
        }
        if (this.f5877g > 0.0f) {
            sb2.append(" smallestDisplacement=");
            sb2.append(this.f5877g);
            sb2.append("m");
        }
        long j10 = this.f5875e;
        if (j10 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb2.append(" expireIn=");
            sb2.append(j10 - jElapsedRealtime);
            sb2.append("ms");
        }
        if (this.f5876f != Integer.MAX_VALUE) {
            sb2.append(" num=");
            sb2.append(this.f5876f);
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f5871a);
        c.x(parcel, 2, this.f5872b);
        c.x(parcel, 3, this.f5873c);
        c.g(parcel, 4, this.f5874d);
        c.x(parcel, 5, this.f5875e);
        c.t(parcel, 6, this.f5876f);
        c.p(parcel, 7, this.f5877g);
        c.x(parcel, 8, this.f5878h);
        c.g(parcel, 9, this.f5879i);
        c.b(parcel, iA);
    }
}
