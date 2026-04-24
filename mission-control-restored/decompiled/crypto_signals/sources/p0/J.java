package p0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class J implements Parcelable {
    public static final Parcelable.Creator<J> CREATOR = new o1.r(15);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f8979d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f8980f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f8981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8984n;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8976a);
        parcel.writeInt(this.f8977b);
        parcel.writeInt(this.f8978c);
        if (this.f8978c > 0) {
            parcel.writeIntArray(this.f8979d);
        }
        parcel.writeInt(this.e);
        if (this.e > 0) {
            parcel.writeIntArray(this.f8980f);
        }
        parcel.writeInt(this.f8982l ? 1 : 0);
        parcel.writeInt(this.f8983m ? 1 : 0);
        parcel.writeInt(this.f8984n ? 1 : 0);
        parcel.writeList(this.f8981k);
    }
}
