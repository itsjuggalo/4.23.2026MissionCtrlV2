package i2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: i2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1814g extends Q1.a {
    public static final Parcelable.Creator<C1814g> CREATOR = new C1822h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15789c;

    public C1814g(long j7, int i7, long j8) {
        this.f15787a = j7;
        this.f15788b = i7;
        this.f15789c = j8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        long j7 = this.f15787a;
        int iA = Q1.c.a(parcel);
        Q1.c.x(parcel, 1, j7);
        Q1.c.t(parcel, 2, this.f15788b);
        Q1.c.x(parcel, 3, this.f15789c);
        Q1.c.b(parcel, iA);
    }
}
