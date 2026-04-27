package android.support.v4.media.session;

import N1.X1;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new X1(19);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f4192d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4193f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CharSequence f4194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f4195l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f4196m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f4197n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Bundle f4198o;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f4200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f4202d;

        public CustomAction(Parcel parcel) {
            this.f4199a = parcel.readString();
            this.f4200b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f4201c = parcel.readInt();
            this.f4202d = parcel.readBundle(a.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f4200b) + ", mIcon=" + this.f4201c + ", mExtras=" + this.f4202d;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f4199a);
            TextUtils.writeToParcel(this.f4200b, parcel, i);
            parcel.writeInt(this.f4201c);
            parcel.writeBundle(this.f4202d);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f4189a = parcel.readInt();
        this.f4190b = parcel.readLong();
        this.f4192d = parcel.readFloat();
        this.f4195l = parcel.readLong();
        this.f4191c = parcel.readLong();
        this.e = parcel.readLong();
        this.f4194k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f4196m = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f4197n = parcel.readLong();
        this.f4198o = parcel.readBundle(a.class.getClassLoader());
        this.f4193f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.f4189a + ", position=" + this.f4190b + ", buffered position=" + this.f4191c + ", speed=" + this.f4192d + ", updated=" + this.f4195l + ", actions=" + this.e + ", error code=" + this.f4193f + ", error message=" + this.f4194k + ", custom actions=" + this.f4196m + ", active item id=" + this.f4197n + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4189a);
        parcel.writeLong(this.f4190b);
        parcel.writeFloat(this.f4192d);
        parcel.writeLong(this.f4195l);
        parcel.writeLong(this.f4191c);
        parcel.writeLong(this.e);
        TextUtils.writeToParcel(this.f4194k, parcel, i);
        parcel.writeTypedList(this.f4196m);
        parcel.writeLong(this.f4197n);
        parcel.writeBundle(this.f4198o);
        parcel.writeInt(this.f4193f);
    }
}
