package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6234e;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i4) {
            return new ParcelableVolumeInfo[i4];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f6230a = parcel.readInt();
        this.f6232c = parcel.readInt();
        this.f6233d = parcel.readInt();
        this.f6234e = parcel.readInt();
        this.f6231b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f6230a);
        parcel.writeInt(this.f6232c);
        parcel.writeInt(this.f6233d);
        parcel.writeInt(this.f6234e);
        parcel.writeInt(this.f6231b);
    }
}
