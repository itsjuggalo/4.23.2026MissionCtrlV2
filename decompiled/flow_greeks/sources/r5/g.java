package r5;

import android.os.Parcel;
import android.os.Parcelable;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends n5.a {
    public static final Parcelable.Creator<g> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.C0336a f19341c;

    public g(int i10, String str, a.C0336a c0336a) {
        this.f19339a = i10;
        this.f19340b = str;
        this.f19341c = c0336a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f19339a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.E(parcel, 2, this.f19340b, false);
        n5.c.C(parcel, 3, this.f19341c, i10, false);
        n5.c.b(parcel, iA);
    }

    public g(String str, a.C0336a c0336a) {
        this.f19339a = 1;
        this.f19340b = str;
        this.f19341c = c0336a;
    }
}
