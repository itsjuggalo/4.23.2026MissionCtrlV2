package E1;

import E1.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g extends A1.a {
    public static final Parcelable.Creator<g> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.C0016a f404c;

    public g(int i4, String str, a.C0016a c0016a) {
        this.f402a = i4;
        this.f403b = str;
        this.f404c = c0016a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f402a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.E(parcel, 2, this.f403b, false);
        A1.c.C(parcel, 3, this.f404c, i4, false);
        A1.c.b(parcel, iA);
    }

    public g(String str, a.C0016a c0016a) {
        this.f402a = 1;
        this.f403b = str;
        this.f404c = c0016a;
    }
}
