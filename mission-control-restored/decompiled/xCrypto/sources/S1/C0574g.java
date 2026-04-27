package S1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: S1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0574g extends A1.a {
    public static final Parcelable.Creator<C0574g> CREATOR = new C0582h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4630c;

    public C0574g(long j4, int i4, long j5) {
        this.f4628a = j4;
        this.f4629b = i4;
        this.f4630c = j5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        long j4 = this.f4628a;
        int iA = A1.c.a(parcel);
        A1.c.x(parcel, 1, j4);
        A1.c.t(parcel, 2, this.f4629b);
        A1.c.x(parcel, 3, this.f4630c);
        A1.c.b(parcel, iA);
    }
}
