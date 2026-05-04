package q5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends n5.a {
    public static final Parcelable.Creator<d> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18792c;

    public d(int i10, String str, int i11) {
        this.f18790a = i10;
        this.f18791b = str;
        this.f18792c = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f18790a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.E(parcel, 2, this.f18791b, false);
        n5.c.t(parcel, 3, this.f18792c);
        n5.c.b(parcel, iA);
    }

    public d(String str, int i10) {
        this.f18790a = 1;
        this.f18791b = str;
        this.f18792c = i10;
    }
}
