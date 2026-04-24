package f2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: f2.I, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1558I extends Q1.a {
    public static final Parcelable.Creator<C1558I> CREATOR = new C1559J();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14050c;

    public C1558I(String str, String str2, String str3) {
        this.f14050c = str;
        this.f14048a = str2;
        this.f14049b = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f14048a, false);
        Q1.c.E(parcel, 2, this.f14049b, false);
        Q1.c.E(parcel, 5, this.f14050c, false);
        Q1.c.b(parcel, iA);
    }
}
