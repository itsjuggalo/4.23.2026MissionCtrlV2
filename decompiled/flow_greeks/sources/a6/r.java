package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r extends n5.a {
    public static final Parcelable.Creator<r> CREATOR = new k2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f222a;

    public r(String str) {
        this.f222a = (String) com.google.android.gms.common.internal.s.k(str);
    }

    public String R() {
        return this.f222a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f222a.equals(((r) obj).f222a);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f222a);
    }

    public final String toString() {
        return "FidoAppIdExtension{appid='" + this.f222a + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, R(), false);
        n5.c.b(parcel, iA);
    }
}
