package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f862e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i10) {
            return new ParcelableVolumeInfo[i10];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f858a = parcel.readInt();
        this.f860c = parcel.readInt();
        this.f861d = parcel.readInt();
        this.f862e = parcel.readInt();
        this.f859b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f858a);
        parcel.writeInt(this.f860c);
        parcel.writeInt(this.f861d);
        parcel.writeInt(this.f862e);
        parcel.writeInt(this.f859b);
    }
}
