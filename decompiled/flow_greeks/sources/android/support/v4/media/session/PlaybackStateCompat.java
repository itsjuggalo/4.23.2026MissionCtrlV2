package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f873k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f877d;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i10) {
                return new CustomAction[i10];
            }
        }

        public CustomAction(Parcel parcel) {
            this.f874a = parcel.readString();
            this.f875b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f876c = parcel.readInt();
            this.f877d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f875b) + ", mIcon=" + this.f876c + ", mExtras=" + this.f877d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f874a);
            TextUtils.writeToParcel(this.f875b, parcel, i10);
            parcel.writeInt(this.f876c);
            parcel.writeBundle(this.f877d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i10) {
            return new PlaybackStateCompat[i10];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f863a = parcel.readInt();
        this.f864b = parcel.readLong();
        this.f866d = parcel.readFloat();
        this.f870h = parcel.readLong();
        this.f865c = parcel.readLong();
        this.f867e = parcel.readLong();
        this.f869g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f871i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f872j = parcel.readLong();
        this.f873k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f868f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f863a + ", position=" + this.f864b + ", buffered position=" + this.f865c + ", speed=" + this.f866d + ", updated=" + this.f870h + ", actions=" + this.f867e + ", error code=" + this.f868f + ", error message=" + this.f869g + ", custom actions=" + this.f871i + ", active item id=" + this.f872j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f863a);
        parcel.writeLong(this.f864b);
        parcel.writeFloat(this.f866d);
        parcel.writeLong(this.f870h);
        parcel.writeLong(this.f865c);
        parcel.writeLong(this.f867e);
        TextUtils.writeToParcel(this.f869g, parcel, i10);
        parcel.writeTypedList(this.f871i);
        parcel.writeLong(this.f872j);
        parcel.writeBundle(this.f873k);
        parcel.writeInt(this.f868f);
    }
}
