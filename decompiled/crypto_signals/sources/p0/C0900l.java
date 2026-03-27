package p0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: p0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0900l implements Parcelable {
    public static final Parcelable.Creator<C0900l> CREATOR = new o1.r(13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9043c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9041a);
        parcel.writeInt(this.f9042b);
        parcel.writeInt(this.f9043c ? 1 : 0);
    }
}
