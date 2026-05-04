package c5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g extends n5.a {
    public static final Parcelable.Creator<g> CREATOR = new x();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3654a;

    public g(int i10) {
        this.f3654a = i10;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return com.google.android.gms.common.internal.q.b(Integer.valueOf(this.f3654a), Integer.valueOf(((g) obj).f3654a));
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.f3654a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f3654a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.b(parcel, iA);
    }
}
