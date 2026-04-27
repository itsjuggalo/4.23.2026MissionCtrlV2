package p0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class I implements Parcelable {
    public static final Parcelable.Creator<I> CREATOR = new o1.r(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f8974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8975d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f8972a + ", mGapDir=" + this.f8973b + ", mHasUnwantedGapAfter=" + this.f8975d + ", mGapPerSpan=" + Arrays.toString(this.f8974c) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8972a);
        parcel.writeInt(this.f8973b);
        parcel.writeInt(this.f8975d ? 1 : 0);
        int[] iArr = this.f8974c;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f8974c);
        }
    }
}
