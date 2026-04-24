package T1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Q1.a {
    public static final Parcelable.Creator<d> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4723c;

    public d(int i7, String str, int i8) {
        this.f4721a = i7;
        this.f4722b = str;
        this.f4723c = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f4721a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.E(parcel, 2, this.f4722b, false);
        Q1.c.t(parcel, 3, this.f4723c);
        Q1.c.b(parcel, iA);
    }

    public d(String str, int i7) {
        this.f4721a = 1;
        this.f4722b = str;
        this.f4723c = i7;
    }
}
