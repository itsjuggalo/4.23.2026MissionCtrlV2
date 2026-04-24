package S1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class K6 extends A1.a {
    public static final Parcelable.Creator<K6> CREATOR = new L6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4079a;

    public K6(List list) {
        this.f4079a = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        List list = this.f4079a;
        int iA = A1.c.a(parcel);
        A1.c.I(parcel, 1, list, false);
        A1.c.b(parcel, iA);
    }
}
