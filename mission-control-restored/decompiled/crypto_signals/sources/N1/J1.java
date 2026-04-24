package N1;

import android.os.Parcel;
import android.os.Parcelable;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class J1 extends AbstractC1255a {
    public static final Parcelable.Creator<J1> CREATOR = new J1.Y(26);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1272c;

    public J1(String str, long j4, int i) {
        this.f1270a = str;
        this.f1271b = j4;
        this.f1272c = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = t2.u0.X(20293, parcel);
        t2.u0.T(parcel, 1, this.f1270a, false);
        t2.u0.b0(parcel, 2, 8);
        parcel.writeLong(this.f1271b);
        t2.u0.b0(parcel, 3, 4);
        parcel.writeInt(this.f1272c);
        t2.u0.a0(iX, parcel);
    }
}
