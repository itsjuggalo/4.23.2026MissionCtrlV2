package d2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: d2.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1436i0 implements Parcelable {
    USER_VERIFICATION_REQUIRED("required"),
    USER_VERIFICATION_PREFERRED("preferred"),
    USER_VERIFICATION_DISCOURAGED("discouraged");

    public static final Parcelable.Creator<EnumC1436i0> CREATOR = new Parcelable.Creator() { // from class: d2.g0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC1436i0.a(parcel.readString());
            } catch (C1434h0 e7) {
                throw new RuntimeException(e7);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i7) {
            return new EnumC1436i0[i7];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13251a;

    EnumC1436i0(String str) {
        this.f13251a = str;
    }

    public static EnumC1436i0 a(String str) throws C1434h0 {
        for (EnumC1436i0 enumC1436i0 : values()) {
            if (str.equals(enumC1436i0.f13251a)) {
                return enumC1436i0;
            }
        }
        throw new C1434h0(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f13251a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f13251a);
    }
}
