package e6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends n5.a {
    public static final Parcelable.Creator<c> CREATOR = new u0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8403b;

    public c(int i10, int i11) {
        this.f8402a = i10;
        this.f8403b = i11;
    }

    public int R() {
        return this.f8402a;
    }

    public int S() {
        return this.f8403b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f8402a == cVar.f8402a && this.f8403b == cVar.f8403b;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.f8402a), Integer.valueOf(this.f8403b));
    }

    public String toString() {
        int i10 = this.f8402a;
        int i11 = this.f8403b;
        StringBuilder sb2 = new StringBuilder(75);
        sb2.append("ActivityTransition [mActivityType=");
        sb2.append(i10);
        sb2.append(", mTransitionType=");
        sb2.append(i11);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        com.google.android.gms.common.internal.s.k(parcel);
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, R());
        n5.c.t(parcel, 2, S());
        n5.c.b(parcel, iA);
    }
}
