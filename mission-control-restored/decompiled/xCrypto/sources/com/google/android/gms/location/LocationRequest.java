package com.google.android.gms.location;

import A1.a;
import A1.c;
import P1.E;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class LocationRequest extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f10053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10055i;

    public LocationRequest(int i4, long j4, long j5, boolean z4, long j6, int i5, float f4, long j7, boolean z5) {
        this.f10047a = i4;
        this.f10048b = j4;
        this.f10049c = j5;
        this.f10050d = z4;
        this.f10051e = j6;
        this.f10052f = i5;
        this.f10053g = f4;
        this.f10054h = j7;
        this.f10055i = z5;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.f10047a == locationRequest.f10047a && this.f10048b == locationRequest.f10048b && this.f10049c == locationRequest.f10049c && this.f10050d == locationRequest.f10050d && this.f10051e == locationRequest.f10051e && this.f10052f == locationRequest.f10052f && this.f10053g == locationRequest.f10053g && k() == locationRequest.k() && this.f10055i == locationRequest.f10055i) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f10047a), Long.valueOf(this.f10048b), Float.valueOf(this.f10053g), Long.valueOf(this.f10054h));
    }

    public long i() {
        return this.f10048b;
    }

    public long k() {
        long j4 = this.f10054h;
        long j5 = this.f10048b;
        return j4 < j5 ? j5 : j4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i4 = this.f10047a;
        sb.append(i4 != 100 ? i4 != 102 ? i4 != 104 ? i4 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f10047a != 105) {
            sb.append(" requested=");
            sb.append(this.f10048b);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.f10049c);
        sb.append("ms");
        if (this.f10054h > this.f10048b) {
            sb.append(" maxWait=");
            sb.append(this.f10054h);
            sb.append("ms");
        }
        if (this.f10053g > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.f10053g);
            sb.append("m");
        }
        long j4 = this.f10051e;
        if (j4 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j4 - jElapsedRealtime);
            sb.append("ms");
        }
        if (this.f10052f != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f10052f);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f10047a);
        c.x(parcel, 2, this.f10048b);
        c.x(parcel, 3, this.f10049c);
        c.g(parcel, 4, this.f10050d);
        c.x(parcel, 5, this.f10051e);
        c.t(parcel, 6, this.f10052f);
        c.p(parcel, 7, this.f10053g);
        c.x(parcel, 8, this.f10054h);
        c.g(parcel, 9, this.f10055i);
        c.b(parcel, iA);
    }
}
