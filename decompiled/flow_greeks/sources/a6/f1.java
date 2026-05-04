package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends n5.a {
    public static final Parcelable.Creator<f1> CREATOR = new g1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f161a;

    public f1(String str) {
        this.f161a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f1) {
            return com.google.android.gms.common.internal.q.b(this.f161a, ((f1) obj).f161a);
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f161a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.f161a;
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, str, false);
        n5.c.b(parcel, iA);
    }
}
