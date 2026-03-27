package f2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: f2.Y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1573Y extends Q1.a {
    public static final Parcelable.Creator<C1573Y> CREATOR = new C1574Z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14066e;

    public C1573Y() {
        this(true, 50L, 0.0f, Long.MAX_VALUE, a.e.API_PRIORITY_OTHER);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1573Y)) {
            return false;
        }
        C1573Y c1573y = (C1573Y) obj;
        return this.f14062a == c1573y.f14062a && this.f14063b == c1573y.f14063b && Float.compare(this.f14064c, c1573y.f14064c) == 0 && this.f14065d == c1573y.f14065d && this.f14066e == c1573y.f14066e;
    }

    public final int hashCode() {
        return AbstractC1206q.c(Boolean.valueOf(this.f14062a), Long.valueOf(this.f14063b), Float.valueOf(this.f14064c), Long.valueOf(this.f14065d), Integer.valueOf(this.f14066e));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f14062a);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.f14063b);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.f14064c);
        long j7 = this.f14065d;
        if (j7 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j7 - jElapsedRealtime);
            sb.append("ms");
        }
        if (this.f14066e != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f14066e);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.g(parcel, 1, this.f14062a);
        Q1.c.x(parcel, 2, this.f14063b);
        Q1.c.p(parcel, 3, this.f14064c);
        Q1.c.x(parcel, 4, this.f14065d);
        Q1.c.t(parcel, 5, this.f14066e);
        Q1.c.b(parcel, iA);
    }

    public C1573Y(boolean z7, long j7, float f7, long j8, int i7) {
        this.f14062a = z7;
        this.f14063b = j7;
        this.f14064c = f7;
        this.f14065d = j8;
        this.f14066e = i7;
    }
}
