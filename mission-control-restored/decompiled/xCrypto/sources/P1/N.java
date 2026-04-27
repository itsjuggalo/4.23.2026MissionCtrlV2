package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: loaded from: classes.dex */
public final class N extends A1.a {
    public static final Parcelable.Creator<N> CREATOR = new O();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3389d;

    public N(int i4, int i5, long j4, long j5) {
        this.f3386a = i4;
        this.f3387b = i5;
        this.f3388c = j4;
        this.f3389d = j5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof N) {
            N n4 = (N) obj;
            if (this.f3386a == n4.f3386a && this.f3387b == n4.f3387b && this.f3388c == n4.f3388c && this.f3389d == n4.f3389d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f3387b), Integer.valueOf(this.f3386a), Long.valueOf(this.f3389d), Long.valueOf(this.f3388c));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f3386a + " Cell status: " + this.f3387b + " elapsed time NS: " + this.f3389d + " system time ms: " + this.f3388c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f3386a);
        A1.c.t(parcel, 2, this.f3387b);
        A1.c.x(parcel, 3, this.f3388c);
        A1.c.x(parcel, 4, this.f3389d);
        A1.c.b(parcel, iA);
    }
}
