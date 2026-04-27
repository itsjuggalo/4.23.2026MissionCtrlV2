package K1;

import J1.Y;
import android.os.Parcel;
import android.os.Parcelable;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public enum f implements Parcelable {
    UNKNOWN("UNKNOWN"),
    /* JADX INFO: Fake field, exist only in values array */
    V1("U2F_V1"),
    /* JADX INFO: Fake field, exist only in values array */
    V2("U2F_V2");

    public static final Parcelable.Creator<f> CREATOR = new Y(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f812a;

    f(String str) {
        this.f812a = str;
    }

    public static f a(String str) throws e {
        if (str == null) {
            return UNKNOWN;
        }
        for (f fVar : values()) {
            if (str.equals(fVar.f812a)) {
                return fVar;
            }
        }
        throw new e(AbstractC1024h.c("Protocol version ", str, " not supported"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f812a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f812a);
    }
}
