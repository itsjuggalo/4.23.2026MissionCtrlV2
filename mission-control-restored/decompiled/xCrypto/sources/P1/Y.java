package P1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: loaded from: classes.dex */
public final class Y extends A1.a {
    public static final Parcelable.Creator<Y> CREATOR = new Z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3401e;

    public Y() {
        this(true, 50L, 0.0f, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Y)) {
            return false;
        }
        Y y4 = (Y) obj;
        return this.f3397a == y4.f3397a && this.f3398b == y4.f3398b && Float.compare(this.f3399c, y4.f3399c) == 0 && this.f3400d == y4.f3400d && this.f3401e == y4.f3401e;
    }

    public final int hashCode() {
        return AbstractC0939q.c(Boolean.valueOf(this.f3397a), Long.valueOf(this.f3398b), Float.valueOf(this.f3399c), Long.valueOf(this.f3400d), Integer.valueOf(this.f3401e));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f3397a);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.f3398b);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.f3399c);
        long j4 = this.f3400d;
        if (j4 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j4 - jElapsedRealtime);
            sb.append("ms");
        }
        if (this.f3401e != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f3401e);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.g(parcel, 1, this.f3397a);
        A1.c.x(parcel, 2, this.f3398b);
        A1.c.p(parcel, 3, this.f3399c);
        A1.c.x(parcel, 4, this.f3400d);
        A1.c.t(parcel, 5, this.f3401e);
        A1.c.b(parcel, iA);
    }

    public Y(boolean z4, long j4, float f4, long j5, int i4) {
        this.f3397a = z4;
        this.f3398b = j4;
        this.f3399c = f4;
        this.f3400d = j5;
        this.f3401e = i4;
    }
}
