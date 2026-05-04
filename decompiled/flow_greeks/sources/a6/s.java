package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s extends n5.a {
    public static final Parcelable.Creator<s> CREATOR = new p0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f223a;

    public s(boolean z10) {
        this.f223a = z10;
    }

    public boolean R() {
        return this.f223a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && this.f223a == ((s) obj).R();
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f223a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, R());
        n5.c.b(parcel, iA);
    }
}
