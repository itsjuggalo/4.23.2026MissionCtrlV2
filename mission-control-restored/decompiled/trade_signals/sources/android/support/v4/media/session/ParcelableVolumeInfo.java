package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10277e;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i8) {
            return new ParcelableVolumeInfo[i8];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f10273a = parcel.readInt();
        this.f10275c = parcel.readInt();
        this.f10276d = parcel.readInt();
        this.f10277e = parcel.readInt();
        this.f10274b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f10273a);
        parcel.writeInt(this.f10275c);
        parcel.writeInt(this.f10276d);
        parcel.writeInt(this.f10277e);
        parcel.writeInt(this.f10274b);
    }
}
