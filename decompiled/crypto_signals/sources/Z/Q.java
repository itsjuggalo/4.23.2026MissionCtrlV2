package Z;

import N1.X1;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Q implements Parcelable {
    public static final Parcelable.Creator<Q> CREATOR = new X1(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f3759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f3760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0260b[] f3761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3762d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f3763f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f3764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f3765l;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f3759a);
        parcel.writeStringList(this.f3760b);
        parcel.writeTypedArray(this.f3761c, i);
        parcel.writeInt(this.f3762d);
        parcel.writeString(this.e);
        parcel.writeStringList(this.f3763f);
        parcel.writeTypedList(this.f3764k);
        parcel.writeTypedList(this.f3765l);
    }
}
