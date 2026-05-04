package e6;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends n5.a {
    public static final Parcelable.Creator<x0> CREATOR = new y0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8454e;

    public x0() {
        this(true, 50L, 0.0f, Long.MAX_VALUE, a.e.API_PRIORITY_OTHER);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return this.f8450a == x0Var.f8450a && this.f8451b == x0Var.f8451b && Float.compare(this.f8452c, x0Var.f8452c) == 0 && this.f8453d == x0Var.f8453d && this.f8454e == x0Var.f8454e;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f8450a), Long.valueOf(this.f8451b), Float.valueOf(this.f8452c), Long.valueOf(this.f8453d), Integer.valueOf(this.f8454e));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DeviceOrientationRequest[mShouldUseMag=");
        sb2.append(this.f8450a);
        sb2.append(" mMinimumSamplingPeriodMs=");
        sb2.append(this.f8451b);
        sb2.append(" mSmallestAngleChangeRadians=");
        sb2.append(this.f8452c);
        long j10 = this.f8453d;
        if (j10 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb2.append(" expireIn=");
            sb2.append(j10 - jElapsedRealtime);
            sb2.append("ms");
        }
        if (this.f8454e != Integer.MAX_VALUE) {
            sb2.append(" num=");
            sb2.append(this.f8454e);
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, this.f8450a);
        n5.c.x(parcel, 2, this.f8451b);
        n5.c.p(parcel, 3, this.f8452c);
        n5.c.x(parcel, 4, this.f8453d);
        n5.c.t(parcel, 5, this.f8454e);
        n5.c.b(parcel, iA);
    }

    public x0(boolean z10, long j10, float f10, long j11, int i10) {
        this.f8450a = z10;
        this.f8451b = j10;
        this.f8452c = f10;
        this.f8453d = j11;
        this.f8454e = i10;
    }
}
