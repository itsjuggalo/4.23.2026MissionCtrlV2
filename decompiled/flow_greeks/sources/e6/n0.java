package e6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends n5.a {
    public static final Parcelable.Creator<n0> CREATOR = new o0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8440d;

    public n0(int i10, int i11, long j10, long j11) {
        this.f8437a = i10;
        this.f8438b = i11;
        this.f8439c = j10;
        this.f8440d = j11;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n0) {
            n0 n0Var = (n0) obj;
            if (this.f8437a == n0Var.f8437a && this.f8438b == n0Var.f8438b && this.f8439c == n0Var.f8439c && this.f8440d == n0Var.f8440d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.f8438b), Integer.valueOf(this.f8437a), Long.valueOf(this.f8440d), Long.valueOf(this.f8439c));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f8437a + " Cell status: " + this.f8438b + " elapsed time NS: " + this.f8440d + " system time ms: " + this.f8439c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f8437a);
        n5.c.t(parcel, 2, this.f8438b);
        n5.c.x(parcel, 3, this.f8439c);
        n5.c.x(parcel, 4, this.f8440d);
        n5.c.b(parcel, iA);
    }
}
