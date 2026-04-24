package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: N1.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0473i0 implements Parcelable {
    USER_VERIFICATION_REQUIRED("required"),
    USER_VERIFICATION_PREFERRED("preferred"),
    USER_VERIFICATION_DISCOURAGED("discouraged");

    public static final Parcelable.Creator<EnumC0473i0> CREATOR = new Parcelable.Creator() { // from class: N1.g0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC0473i0.a(parcel.readString());
            } catch (C0471h0 e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i4) {
            return new EnumC0473i0[i4];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2795a;

    EnumC0473i0(String str) {
        this.f2795a = str;
    }

    public static EnumC0473i0 a(String str) throws C0471h0 {
        for (EnumC0473i0 enumC0473i0 : values()) {
            if (str.equals(enumC0473i0.f2795a)) {
                return enumC0473i0;
            }
        }
        throw new C0471h0(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f2795a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2795a);
    }
}
