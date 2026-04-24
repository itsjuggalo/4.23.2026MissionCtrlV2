package J1;

import android.os.Parcel;
import android.os.Parcelable;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: J1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0027c implements Parcelable {
    /* JADX INFO: Fake field, exist only in values array */
    PLATFORM("platform"),
    /* JADX INFO: Fake field, exist only in values array */
    CROSS_PLATFORM("cross-platform");

    public static final Parcelable.Creator<EnumC0027c> CREATOR = new H1.b(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f713a;

    EnumC0027c(String str) {
        this.f713a = str;
    }

    public static EnumC0027c a(String str) {
        for (EnumC0027c enumC0027c : values()) {
            if (str.equals(enumC0027c.f713a)) {
                return enumC0027c;
            }
        }
        throw new C0026b(AbstractC1024h.c("Attachment ", str, " not supported"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f713a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f713a);
    }
}
