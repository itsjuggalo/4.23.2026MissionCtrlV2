package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6442b;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i7) {
            return new RatingCompat[i7];
        }
    }

    public RatingCompat(int i7, float f7) {
        this.f6441a = i7;
        this.f6442b = f7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f6441a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f6441a);
        sb.append(" rating=");
        float f7 = this.f6442b;
        sb.append(f7 < 0.0f ? "unrated" : String.valueOf(f7));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f6441a);
        parcel.writeFloat(this.f6442b);
    }
}
