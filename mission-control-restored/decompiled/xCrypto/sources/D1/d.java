package D1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d extends A1.a {
    public static final Parcelable.Creator<d> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f321c;

    public d(int i4, String str, int i5) {
        this.f319a = i4;
        this.f320b = str;
        this.f321c = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f319a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.E(parcel, 2, this.f320b, false);
        A1.c.t(parcel, 3, this.f321c);
        A1.c.b(parcel, iA);
    }

    public d(String str, int i4) {
        this.f319a = 1;
        this.f320b = str;
        this.f321c = i4;
    }
}
