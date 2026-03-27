package S1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class B6 extends A1.a {
    public static final Parcelable.Creator<B6> CREATOR = new C6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3873c;

    public B6(String str, long j4, int i4) {
        this.f3871a = str;
        this.f3872b = j4;
        this.f3873c = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f3871a;
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, str, false);
        A1.c.x(parcel, 2, this.f3872b);
        A1.c.t(parcel, 3, this.f3873c);
        A1.c.b(parcel, iA);
    }
}
