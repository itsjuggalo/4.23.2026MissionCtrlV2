package e6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends n5.a {
    public static final Parcelable.Creator<n> CREATOR = new m0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8436f;

    public n(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f8431a = z10;
        this.f8432b = z11;
        this.f8433c = z12;
        this.f8434d = z13;
        this.f8435e = z14;
        this.f8436f = z15;
    }

    public boolean R() {
        return this.f8436f;
    }

    public boolean S() {
        return this.f8433c;
    }

    public boolean T() {
        return this.f8434d;
    }

    public boolean U() {
        return this.f8431a;
    }

    public boolean V() {
        return this.f8435e;
    }

    public boolean W() {
        return this.f8432b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, U());
        n5.c.g(parcel, 2, W());
        n5.c.g(parcel, 3, S());
        n5.c.g(parcel, 4, T());
        n5.c.g(parcel, 5, V());
        n5.c.g(parcel, 6, R());
        n5.c.b(parcel, iA);
    }
}
