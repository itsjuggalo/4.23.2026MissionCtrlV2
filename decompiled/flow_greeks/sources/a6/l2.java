package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l2 extends n5.a {
    public static final Parcelable.Creator<l2> CREATOR = new k0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f192a;

    public l2(boolean z10) {
        this.f192a = ((Boolean) com.google.android.gms.common.internal.s.k(Boolean.valueOf(z10))).booleanValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof l2) && this.f192a == ((l2) obj).f192a;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f192a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        boolean z10 = this.f192a;
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, z10);
        n5.c.b(parcel, iA);
    }
}
