package S1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class I6 extends A1.a {
    public static final Parcelable.Creator<I6> CREATOR = new J6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4004a;

    public I6(List list) {
        this.f4004a = list;
    }

    public static I6 i(EnumC0612k5... enumC0612k5Arr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(enumC0612k5Arr[0].zza()));
        return new I6(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        List list = this.f4004a;
        int iA = A1.c.a(parcel);
        A1.c.v(parcel, 1, list, false);
        A1.c.b(parcel, iA);
    }
}
