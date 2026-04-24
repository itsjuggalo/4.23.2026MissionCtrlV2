package i2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class B6 extends Q1.a {
    public static final Parcelable.Creator<B6> CREATOR = new C6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15032c;

    public B6(String str, long j7, int i7) {
        this.f15030a = str;
        this.f15031b = j7;
        this.f15032c = i7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        String str = this.f15030a;
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, str, false);
        Q1.c.x(parcel, 2, this.f15031b);
        Q1.c.t(parcel, 3, this.f15032c);
        Q1.c.b(parcel, iA);
    }
}
