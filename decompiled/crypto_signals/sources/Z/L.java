package Z;

import N1.X1;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class L implements Parcelable {
    public static final Parcelable.Creator<L> CREATOR = new X1(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3718b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3717a);
        parcel.writeInt(this.f3718b);
    }
}
