package N1;

import N1.EnumC0458b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: N1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0458b implements Parcelable {
    PLATFORM("platform"),
    CROSS_PLATFORM("cross-platform");

    public static final Parcelable.Creator<EnumC0458b> CREATOR = new Parcelable.Creator() { // from class: N1.I
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC0458b.a(parcel.readString());
            } catch (EnumC0458b.a e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i4) {
            return new EnumC0458b[i4];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2758a;

    /* JADX INFO: renamed from: N1.b$a */
    public static class a extends Exception {
        public a(String str) {
            super(String.format("Attachment %s not supported", str));
        }
    }

    EnumC0458b(String str) {
        this.f2758a = str;
    }

    public static EnumC0458b a(String str) throws a {
        for (EnumC0458b enumC0458b : values()) {
            if (str.equals(enumC0458b.f2758a)) {
                return enumC0458b;
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
        return this.f2758a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2758a);
    }
}
