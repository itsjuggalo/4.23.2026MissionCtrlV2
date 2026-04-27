package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f6458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f6461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f6462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f6463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f6464j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f6465k;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f6467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6468c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f6469d;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i7) {
                return new CustomAction[i7];
            }
        }

        public CustomAction(Parcel parcel) {
            this.f6466a = parcel.readString();
            this.f6467b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f6468c = parcel.readInt();
            this.f6469d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f6467b) + ", mIcon=" + this.f6468c + ", mExtras=" + this.f6469d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeString(this.f6466a);
            TextUtils.writeToParcel(this.f6467b, parcel, i7);
            parcel.writeInt(this.f6468c);
            parcel.writeBundle(this.f6469d);
        }
    }

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i7) {
            return new PlaybackStateCompat[i7];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f6455a = parcel.readInt();
        this.f6456b = parcel.readLong();
        this.f6458d = parcel.readFloat();
        this.f6462h = parcel.readLong();
        this.f6457c = parcel.readLong();
        this.f6459e = parcel.readLong();
        this.f6461g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f6463i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f6464j = parcel.readLong();
        this.f6465k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f6460f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f6455a + ", position=" + this.f6456b + ", buffered position=" + this.f6457c + ", speed=" + this.f6458d + ", updated=" + this.f6462h + ", actions=" + this.f6459e + ", error code=" + this.f6460f + ", error message=" + this.f6461g + ", custom actions=" + this.f6463i + ", active item id=" + this.f6464j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f6455a);
        parcel.writeLong(this.f6456b);
        parcel.writeFloat(this.f6458d);
        parcel.writeLong(this.f6462h);
        parcel.writeLong(this.f6457c);
        parcel.writeLong(this.f6459e);
        TextUtils.writeToParcel(this.f6461g, parcel, i7);
        parcel.writeTypedList(this.f6463i);
        parcel.writeLong(this.f6464j);
        parcel.writeBundle(this.f6465k);
        parcel.writeInt(this.f6460f);
    }
}
