package J1;

import android.os.Parcel;
import android.os.Parcelable;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public enum V implements Parcelable {
    /* JADX INFO: Fake field, exist only in values array */
    USER_VERIFICATION_REQUIRED("required"),
    /* JADX INFO: Fake field, exist only in values array */
    USER_VERIFICATION_PREFERRED("preferred"),
    /* JADX INFO: Fake field, exist only in values array */
    USER_VERIFICATION_DISCOURAGED("discouraged");

    public static final Parcelable.Creator<V> CREATOR = new H1.b(22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f700a;

    V(String str) {
        this.f700a = str;
    }

    public static V a(String str) throws U {
        for (V v2 : values()) {
            if (str.equals(v2.f700a)) {
                return v2;
            }
        }
        throw new U(AbstractC1024h.c("User verification requirement ", str, " not supported"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f700a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f700a);
    }
}
