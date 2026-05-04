package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i0 extends n5.a {
    public static final Parcelable.Creator<i0> CREATOR = new o1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final short f182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f183c;

    public i0(int i10, short s10, short s11) {
        this.f181a = i10;
        this.f182b = s10;
        this.f183c = s11;
    }

    public short R() {
        return this.f182b;
    }

    public short S() {
        return this.f183c;
    }

    public int T() {
        return this.f181a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.f181a == i0Var.f181a && this.f182b == i0Var.f182b && this.f183c == i0Var.f183c;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.f181a), Short.valueOf(this.f182b), Short.valueOf(this.f183c));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, T());
        n5.c.D(parcel, 2, R());
        n5.c.D(parcel, 3, S());
        n5.c.b(parcel, iA);
    }
}
