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
    public final int f6235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f6238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f6241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f6242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f6243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f6244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f6245k;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f6247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f6249d;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i4) {
                return new CustomAction[i4];
            }
        }

        public CustomAction(Parcel parcel) {
            this.f6246a = parcel.readString();
            this.f6247b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f6248c = parcel.readInt();
            this.f6249d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f6247b) + ", mIcon=" + this.f6248c + ", mExtras=" + this.f6249d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f6246a);
            TextUtils.writeToParcel(this.f6247b, parcel, i4);
            parcel.writeInt(this.f6248c);
            parcel.writeBundle(this.f6249d);
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
        public PlaybackStateCompat[] newArray(int i4) {
            return new PlaybackStateCompat[i4];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f6235a = parcel.readInt();
        this.f6236b = parcel.readLong();
        this.f6238d = parcel.readFloat();
        this.f6242h = parcel.readLong();
        this.f6237c = parcel.readLong();
        this.f6239e = parcel.readLong();
        this.f6241g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f6243i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f6244j = parcel.readLong();
        this.f6245k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f6240f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f6235a + ", position=" + this.f6236b + ", buffered position=" + this.f6237c + ", speed=" + this.f6238d + ", updated=" + this.f6242h + ", actions=" + this.f6239e + ", error code=" + this.f6240f + ", error message=" + this.f6241g + ", custom actions=" + this.f6243i + ", active item id=" + this.f6244j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f6235a);
        parcel.writeLong(this.f6236b);
        parcel.writeFloat(this.f6238d);
        parcel.writeLong(this.f6242h);
        parcel.writeLong(this.f6237c);
        parcel.writeLong(this.f6239e);
        TextUtils.writeToParcel(this.f6241g, parcel, i4);
        parcel.writeTypedList(this.f6243i);
        parcel.writeLong(this.f6244j);
        parcel.writeBundle(this.f6245k);
        parcel.writeInt(this.f6240f);
    }
}
