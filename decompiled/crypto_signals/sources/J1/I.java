package J1;

import android.os.Parcel;
import android.os.Parcelable;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public enum I implements Parcelable {
    /* JADX INFO: Fake field, exist only in values array */
    RESIDENT_KEY_DISCOURAGED("discouraged"),
    /* JADX INFO: Fake field, exist only in values array */
    RESIDENT_KEY_PREFERRED("preferred"),
    RESIDENT_KEY_REQUIRED("required");

    public static final Parcelable.Creator<I> CREATOR = new H1.b(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f685a;

    I(String str) {
        this.f685a = str;
    }

    public static I a(String str) {
        for (I i : values()) {
            if (str.equals(i.f685a)) {
                return i;
            }
        }
        throw new H(AbstractC1024h.c("Resident key requirement ", str, " not supported"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f685a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f685a);
    }
}
