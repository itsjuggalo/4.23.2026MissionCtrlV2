package N1;

import android.os.Parcel;
import android.os.Parcelable;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: N1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0084d extends AbstractC1255a {
    public static final Parcelable.Creator<C0084d> CREATOR = new J1.Y(21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1571c;

    public C0084d(int i, long j4, long j6) {
        this.f1569a = j4;
        this.f1570b = i;
        this.f1571c = j6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = t2.u0.X(20293, parcel);
        t2.u0.b0(parcel, 1, 8);
        parcel.writeLong(this.f1569a);
        t2.u0.b0(parcel, 2, 4);
        parcel.writeInt(this.f1570b);
        t2.u0.b0(parcel, 3, 8);
        parcel.writeLong(this.f1571c);
        t2.u0.a0(iX, parcel);
    }
}
