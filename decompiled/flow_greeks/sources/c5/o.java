package c5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o extends n5.a {
    public static final Parcelable.Creator<o> CREATOR = new k0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3687b;

    public o(String str, String str2) {
        this.f3686a = com.google.android.gms.common.internal.s.f(((String) com.google.android.gms.common.internal.s.l(str, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.f3687b = com.google.android.gms.common.internal.s.e(str2);
    }

    public String R() {
        return this.f3686a;
    }

    public String S() {
        return this.f3687b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return com.google.android.gms.common.internal.q.b(this.f3686a, oVar.f3686a) && com.google.android.gms.common.internal.q.b(this.f3687b, oVar.f3687b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f3686a, this.f3687b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, R(), false);
        n5.c.E(parcel, 2, S(), false);
        n5.c.b(parcel, iA);
    }
}
