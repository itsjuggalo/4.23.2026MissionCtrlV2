package I3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new H1.b(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f644c;

    public a(String str, float f6, float f7) {
        this.f642a = str;
        this.f643b = f6;
        this.f644c = f7;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f642a);
        parcel.writeFloat(this.f643b);
        parcel.writeFloat(this.f644c);
    }

    public a(Parcel parcel) {
        this.f642a = parcel.readString();
        this.f643b = parcel.readFloat();
        this.f644c = parcel.readFloat();
    }
}
