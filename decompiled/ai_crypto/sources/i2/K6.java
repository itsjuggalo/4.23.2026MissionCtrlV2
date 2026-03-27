package i2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class K6 extends Q1.a {
    public static final Parcelable.Creator<K6> CREATOR = new L6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15238a;

    public K6(List list) {
        this.f15238a = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        List list = this.f15238a;
        int iA = Q1.c.a(parcel);
        Q1.c.I(parcel, 1, list, false);
        Q1.c.b(parcel, iA);
    }
}
