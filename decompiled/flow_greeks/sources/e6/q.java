package e6;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q extends n5.a {
    public static final Parcelable.Creator<q> CREATOR = new r0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8445b;

    public q(List list, int i10) {
        this.f8444a = list;
        this.f8445b = i10;
    }

    public int R() {
        return this.f8445b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return com.google.android.gms.common.internal.q.b(this.f8444a, qVar.f8444a) && this.f8445b == qVar.f8445b;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f8444a, Integer.valueOf(this.f8445b));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        com.google.android.gms.common.internal.s.k(parcel);
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, this.f8444a, false);
        n5.c.t(parcel, 2, R());
        n5.c.b(parcel, iA);
    }
}
