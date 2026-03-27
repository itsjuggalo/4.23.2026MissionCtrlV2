package M;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parcelable f1052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1051b = new a();
    public static final Parcelable.Creator<c> CREATOR = new b(0);

    public c() {
        this.f1052a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1052a, i);
    }

    public c(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1052a = parcelable == f1051b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public c(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f1052a = parcelable == null ? f1051b : parcelable;
    }
}
