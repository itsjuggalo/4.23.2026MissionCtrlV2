package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: f2.N, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1563N extends Q1.a {
    public static final Parcelable.Creator<C1563N> CREATOR = new C1564O();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f14054d;

    public C1563N(int i7, int i8, long j7, long j8) {
        this.f14051a = i7;
        this.f14052b = i8;
        this.f14053c = j7;
        this.f14054d = j8;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1563N) {
            C1563N c1563n = (C1563N) obj;
            if (this.f14051a == c1563n.f14051a && this.f14052b == c1563n.f14052b && this.f14053c == c1563n.f14053c && this.f14054d == c1563n.f14054d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f14052b), Integer.valueOf(this.f14051a), Long.valueOf(this.f14054d), Long.valueOf(this.f14053c));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f14051a + " Cell status: " + this.f14052b + " elapsed time NS: " + this.f14054d + " system time ms: " + this.f14053c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f14051a);
        Q1.c.t(parcel, 2, this.f14052b);
        Q1.c.x(parcel, 3, this.f14053c);
        Q1.c.x(parcel, 4, this.f14054d);
        Q1.c.b(parcel, iA);
    }
}
