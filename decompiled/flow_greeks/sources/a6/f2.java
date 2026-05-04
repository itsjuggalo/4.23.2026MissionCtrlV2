package a6;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f2 extends n5.a {
    public static final Parcelable.Creator<f2> CREATOR = new g2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f162a;

    public f2(List list) {
        this.f162a = (List) com.google.android.gms.common.internal.s.k(list);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f2)) {
            return false;
        }
        f2 f2Var = (f2) obj;
        return this.f162a.containsAll(f2Var.f162a) && f2Var.f162a.containsAll(this.f162a);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(new HashSet(this.f162a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        List list = this.f162a;
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, list, false);
        n5.c.b(parcel, iA);
    }
}
