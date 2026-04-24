package N1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class O1 extends AbstractC1255a {
    public static final Parcelable.Creator<O1> CREATOR = new J1.Y(29);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1314a;

    public O1(ArrayList arrayList) {
        this.f1314a = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = t2.u0.X(20293, parcel);
        t2.u0.W(parcel, 1, this.f1314a, false);
        t2.u0.a0(iX, parcel);
    }
}
