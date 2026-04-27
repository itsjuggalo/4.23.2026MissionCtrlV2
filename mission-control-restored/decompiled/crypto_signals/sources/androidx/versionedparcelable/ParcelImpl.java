package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import o1.r;
import u0.b;
import u0.c;

/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new r(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4800a;

    public ParcelImpl(Parcel parcel) {
        this.f4800a = new b(parcel).h();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new b(parcel).l(this.f4800a);
    }
}
