package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f0 extends n5.a {
    public static final Parcelable.Creator<f0> CREATOR = new k1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f160a;

    public f0(boolean z10) {
        this.f160a = z10;
    }

    public boolean R() {
        return this.f160a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f0) && this.f160a == ((f0) obj).f160a;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f160a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, R());
        n5.c.b(parcel, iA);
    }
}
