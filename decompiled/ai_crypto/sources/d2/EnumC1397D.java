package d2;

import android.os.Parcel;
import android.os.Parcelable;
import d2.EnumC1397D;

/* JADX INFO: renamed from: d2.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1397D implements Parcelable {
    RESIDENT_KEY_DISCOURAGED("discouraged"),
    RESIDENT_KEY_PREFERRED("preferred"),
    RESIDENT_KEY_REQUIRED("required");

    public static final Parcelable.Creator<EnumC1397D> CREATOR = new Parcelable.Creator() { // from class: d2.c0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            String string = parcel.readString();
            if (string == null) {
                string = "";
            }
            try {
                return EnumC1397D.a(string);
            } catch (EnumC1397D.a e7) {
                throw new RuntimeException(e7);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i7) {
            return new EnumC1397D[i7];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13190a;

    /* JADX INFO: renamed from: d2.D$a */
    public static class a extends Exception {
        public a(String str) {
            super(String.format("Resident key requirement %s not supported", str));
        }
    }

    EnumC1397D(String str) {
        this.f13190a = str;
    }

    public static EnumC1397D a(String str) throws a {
        for (EnumC1397D enumC1397D : values()) {
            if (str.equals(enumC1397D.f13190a)) {
                return enumC1397D;
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
        return this.f13190a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f13190a);
    }
}
