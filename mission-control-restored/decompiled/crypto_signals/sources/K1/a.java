package K1;

import J1.Y;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public enum a implements Parcelable {
    /* JADX INFO: Fake field, exist only in values array */
    ABSENT(0),
    STRING(1),
    /* JADX INFO: Fake field, exist only in values array */
    OBJECT(2);

    public static final Parcelable.Creator<a> CREATOR = new Y(13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f802a;

    a(int i) {
        this.f802a = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f802a);
    }
}
