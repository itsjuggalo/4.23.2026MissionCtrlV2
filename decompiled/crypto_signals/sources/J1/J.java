package J1;

import android.os.Parcel;
import android.os.Parcelable;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public enum J implements Parcelable {
    /* JADX INFO: Fake field, exist only in values array */
    PRESENT("present"),
    /* JADX INFO: Fake field, exist only in values array */
    SUPPORTED("supported"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_SUPPORTED("not-supported");

    public static final Parcelable.Creator<J> CREATOR = new H1.b(19);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f687a;

    J(String str) {
        this.f687a = str;
    }

    public static J a(String str) throws K {
        for (J j4 : values()) {
            if (str.equals(j4.f687a)) {
                return j4;
            }
        }
        throw new K(AbstractC1024h.c("TokenBindingStatus ", str, " not supported"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f687a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f687a);
    }
}
