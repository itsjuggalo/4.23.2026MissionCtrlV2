package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends n5.a {
    public static final Parcelable.Creator<l0> CREATOR = new m0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f191a;

    public l0(long j10) {
        this.f191a = ((Long) com.google.android.gms.common.internal.s.k(Long.valueOf(j10))).longValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof l0) && this.f191a == ((l0) obj).f191a;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Long.valueOf(this.f191a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        long j10 = this.f191a;
        int iA = n5.c.a(parcel);
        n5.c.x(parcel, 1, j10);
        n5.c.b(parcel, iA);
    }
}
