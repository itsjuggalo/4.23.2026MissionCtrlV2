package P1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class I extends A1.a {
    public static final Parcelable.Creator<I> CREATOR = new J();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3385c;

    public I(String str, String str2, String str3) {
        this.f3385c = str;
        this.f3383a = str2;
        this.f3384b = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, this.f3383a, false);
        A1.c.E(parcel, 2, this.f3384b, false);
        A1.c.E(parcel, 5, this.f3385c, false);
        A1.c.b(parcel, iA);
    }
}
