package android.support.v4.media;

import N1.X1;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new X1(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4180b;

    public RatingCompat(int i, float f6) {
        this.f4179a = i;
        this.f4180b = f6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f4179a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f4179a);
        sb.append(" rating=");
        float f6 = this.f4180b;
        sb.append(f6 < 0.0f ? "unrated" : String.valueOf(f6));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4179a);
        parcel.writeFloat(this.f4180b);
    }
}
