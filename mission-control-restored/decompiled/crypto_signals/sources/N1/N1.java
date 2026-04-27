package N1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class N1 extends AbstractC1255a {
    public static final Parcelable.Creator<N1> CREATOR = new J1.Y(28);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1310a;

    public N1(ArrayList arrayList) {
        this.f1310a = arrayList;
    }

    public static N1 m(EnumC0101i1... enumC0101i1Arr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(enumC0101i1Arr[0].f1661a));
        return new N1(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = t2.u0.X(20293, parcel);
        ArrayList arrayList = this.f1310a;
        if (arrayList != null) {
            int iX2 = t2.u0.X(1, parcel);
            int size = arrayList.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                parcel.writeInt(((Integer) arrayList.get(i6)).intValue());
            }
            t2.u0.a0(iX2, parcel);
        }
        t2.u0.a0(iX, parcel);
    }
}
