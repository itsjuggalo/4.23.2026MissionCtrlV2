package d2;

import android.os.Parcel;
import android.os.Parcelable;
import d2.EnumC1423c;

/* JADX INFO: renamed from: d2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1423c implements Parcelable {
    NONE("none"),
    INDIRECT("indirect"),
    DIRECT("direct");

    public static final Parcelable.Creator<EnumC1423c> CREATOR = new Parcelable.Creator() { // from class: d2.k0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC1423c.a(parcel.readString());
            } catch (EnumC1423c.a e7) {
                throw new RuntimeException(e7);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i7) {
            return new EnumC1423c[i7];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13219a;

    /* JADX INFO: renamed from: d2.c$a */
    public static class a extends Exception {
        public a(String str) {
            super(String.format("Attestation conveyance preference %s not supported", str));
        }
    }

    EnumC1423c(String str) {
        this.f13219a = str;
    }

    public static EnumC1423c a(String str) throws a {
        for (EnumC1423c enumC1423c : values()) {
            if (str.equals(enumC1423c.f13219a)) {
                return enumC1423c;
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
        return this.f13219a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f13219a);
    }
}
