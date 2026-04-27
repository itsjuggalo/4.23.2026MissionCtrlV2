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
    public final int f10278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f10281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f10284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f10285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f10286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f10287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f10288k;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f10290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f10292d;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i8) {
                return new CustomAction[i8];
            }
        }

        public CustomAction(Parcel parcel) {
            this.f10289a = parcel.readString();
            this.f10290b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f10291c = parcel.readInt();
            this.f10292d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f10290b) + ", mIcon=" + this.f10291c + ", mExtras=" + this.f10292d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeString(this.f10289a);
            TextUtils.writeToParcel(this.f10290b, parcel, i8);
            parcel.writeInt(this.f10291c);
            parcel.writeBundle(this.f10292d);
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
        public PlaybackStateCompat[] newArray(int i8) {
            return new PlaybackStateCompat[i8];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f10278a = parcel.readInt();
        this.f10279b = parcel.readLong();
        this.f10281d = parcel.readFloat();
        this.f10285h = parcel.readLong();
        this.f10280c = parcel.readLong();
        this.f10282e = parcel.readLong();
        this.f10284g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f10286i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f10287j = parcel.readLong();
        this.f10288k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f10283f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f10278a + ", position=" + this.f10279b + ", buffered position=" + this.f10280c + ", speed=" + this.f10281d + ", updated=" + this.f10285h + ", actions=" + this.f10282e + ", error code=" + this.f10283f + ", error message=" + this.f10284g + ", custom actions=" + this.f10286i + ", active item id=" + this.f10287j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f10278a);
        parcel.writeLong(this.f10279b);
        parcel.writeFloat(this.f10281d);
        parcel.writeLong(this.f10285h);
        parcel.writeLong(this.f10280c);
        parcel.writeLong(this.f10282e);
        TextUtils.writeToParcel(this.f10284g, parcel, i8);
        parcel.writeTypedList(this.f10286i);
        parcel.writeLong(this.f10287j);
        parcel.writeBundle(this.f10288k);
        parcel.writeInt(this.f10283f);
    }
}
