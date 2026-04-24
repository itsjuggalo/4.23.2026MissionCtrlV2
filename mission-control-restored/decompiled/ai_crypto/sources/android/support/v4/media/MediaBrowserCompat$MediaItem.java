package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDescriptionCompat f6418b;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
            return new MediaBrowserCompat$MediaItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaBrowserCompat$MediaItem[] newArray(int i7) {
            return new MediaBrowserCompat$MediaItem[i7];
        }
    }

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f6417a = parcel.readInt();
        this.f6418b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MediaItem{mFlags=" + this.f6417a + ", mDescription=" + this.f6418b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f6417a);
        this.f6418b.writeToParcel(parcel, i7);
    }
}
