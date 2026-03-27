package Z;

import N1.X1;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: Z.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0261c implements Parcelable {
    public static final Parcelable.Creator<C0261c> CREATOR = new X1(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3831b;

    public C0261c(Parcel parcel) {
        this.f3830a = parcel.createStringArrayList();
        this.f3831b = parcel.createTypedArrayList(C0260b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f3830a);
        parcel.writeTypedList(this.f3831b);
    }
}
