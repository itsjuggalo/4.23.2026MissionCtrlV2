package i2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class I6 extends Q1.a {
    public static final Parcelable.Creator<I6> CREATOR = new J6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15163a;

    public I6(List list) {
        this.f15163a = list;
    }

    public static I6 A(EnumC1852k5... enumC1852k5Arr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(enumC1852k5Arr[0].zza()));
        return new I6(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        List list = this.f15163a;
        int iA = Q1.c.a(parcel);
        Q1.c.v(parcel, 1, list, false);
        Q1.c.b(parcel, iA);
    }
}
