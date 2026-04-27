package d2;

import android.os.Parcel;
import android.os.Parcelable;
import d2.EnumC1421b;

/* JADX INFO: renamed from: d2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1421b implements Parcelable {
    PLATFORM("platform"),
    CROSS_PLATFORM("cross-platform");

    public static final Parcelable.Creator<EnumC1421b> CREATOR = new Parcelable.Creator() { // from class: d2.I
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC1421b.a(parcel.readString());
            } catch (EnumC1421b.a e7) {
                throw new RuntimeException(e7);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i7) {
            return new EnumC1421b[i7];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13214a;

    /* JADX INFO: renamed from: d2.b$a */
    public static class a extends Exception {
        public a(String str) {
            super(String.format("Attachment %s not supported", str));
        }
    }

    EnumC1421b(String str) {
        this.f13214a = str;
    }

    public static EnumC1421b a(String str) throws a {
        for (EnumC1421b enumC1421b : values()) {
            if (str.equals(enumC1421b.f13214a)) {
                return enumC1421b;
            }
        }
        throw new a(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f13214a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f13214a);
    }
}
