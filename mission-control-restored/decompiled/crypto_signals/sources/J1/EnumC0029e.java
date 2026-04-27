package J1;

import android.os.Parcel;
import android.os.Parcelable;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: J1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0029e implements Parcelable {
    /* JADX INFO: Fake field, exist only in values array */
    NONE("none"),
    /* JADX INFO: Fake field, exist only in values array */
    INDIRECT("indirect"),
    /* JADX INFO: Fake field, exist only in values array */
    DIRECT("direct");

    public static final Parcelable.Creator<EnumC0029e> CREATOR = new H1.b(24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f716a;

    EnumC0029e(String str) {
        this.f716a = str;
    }

    public static EnumC0029e a(String str) throws C0028d {
        for (EnumC0029e enumC0029e : values()) {
            if (str.equals(enumC0029e.f716a)) {
                return enumC0029e;
            }
        }
        throw new C0028d(AbstractC1024h.c("Attestation conveyance preference ", str, " not supported"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f716a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f716a);
    }
}
