package N1;

import N1.EnumC0460c;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: N1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0460c implements Parcelable {
    NONE("none"),
    INDIRECT("indirect"),
    DIRECT("direct");

    public static final Parcelable.Creator<EnumC0460c> CREATOR = new Parcelable.Creator() { // from class: N1.k0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC0460c.a(parcel.readString());
            } catch (EnumC0460c.a e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i4) {
            return new EnumC0460c[i4];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2763a;

    /* JADX INFO: renamed from: N1.c$a */
    public static class a extends Exception {
        public a(String str) {
            super(String.format("Attestation conveyance preference %s not supported", str));
        }
    }

    EnumC0460c(String str) {
        this.f2763a = str;
    }

    public static EnumC0460c a(String str) throws a {
        for (EnumC0460c enumC0460c : values()) {
            if (str.equals(enumC0460c.f2763a)) {
                return enumC0460c;
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
        return this.f2763a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f2763a);
    }
}
