package android.support.v4.media.session;

import N1.X1;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new X1(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4188d;
    public int e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4185a);
        parcel.writeInt(this.f4187c);
        parcel.writeInt(this.f4188d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f4186b);
    }
}
