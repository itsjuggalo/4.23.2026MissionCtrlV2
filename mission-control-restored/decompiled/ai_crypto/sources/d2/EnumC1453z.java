package d2;

import android.os.Parcel;
import android.os.Parcelable;
import d2.EnumC1453z;

/* JADX INFO: renamed from: d2.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1453z implements Parcelable {
    PUBLIC_KEY("public-key");

    public static final Parcelable.Creator<EnumC1453z> CREATOR = new Parcelable.Creator() { // from class: d2.a0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC1453z.a(parcel.readString());
            } catch (EnumC1453z.a e7) {
                throw new RuntimeException(e7);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i7) {
            return new EnumC1453z[i7];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13331a = "public-key";

    /* JADX INFO: renamed from: d2.z$a */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    EnumC1453z(String str) {
    }

    public static EnumC1453z a(String str) throws a {
        for (EnumC1453z enumC1453z : values()) {
            if (str.equals(enumC1453z.f13331a)) {
                return enumC1453z;
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
        return this.f13331a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f13331a);
    }
}
