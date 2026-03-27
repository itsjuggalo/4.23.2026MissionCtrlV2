package N1;

import N1.EnumC0489z;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: N1.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0489z implements Parcelable {
    PUBLIC_KEY("public-key");

    public static final Parcelable.Creator<EnumC0489z> CREATOR = new Parcelable.Creator() { // from class: N1.a0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC0489z.a(parcel.readString());
            } catch (EnumC0489z.a e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i4) {
            return new EnumC0489z[i4];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2875a = "public-key";

    /* JADX INFO: renamed from: N1.z$a */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    EnumC0489z(String str) {
    }

    public static EnumC0489z a(String str) throws a {
        for (EnumC0489z enumC0489z : values()) {
            if (str.equals(enumC0489z.f2875a)) {
                return enumC0489z;
            }
        }
        throw new a(String.format("PublicKeyCredentialType %s not supported", str));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f2875a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2875a);
    }
}
