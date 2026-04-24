package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10265b;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i8) {
            return new RatingCompat[i8];
        }
    }

    public RatingCompat(int i8, float f8) {
        this.f10264a = i8;
        this.f10265b = f8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f10264a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f10264a);
        sb.append(" rating=");
        float f8 = this.f10265b;
        sb.append(f8 < 0.0f ? "unrated" : String.valueOf(f8));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f10264a);
        parcel.writeFloat(this.f10265b);
    }
}
