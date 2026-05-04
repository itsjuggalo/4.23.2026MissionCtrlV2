package a6;

import a6.z;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public enum z implements Parcelable {
    PUBLIC_KEY("public-key");

    public static final Parcelable.Creator<z> CREATOR = new Parcelable.Creator() { // from class: a6.c1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return z.a(parcel.readString());
            } catch (z.a e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i10) {
            return new z[i10];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f302a = "public-key";

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    z(String str) {
    }

    public static z a(String str) throws a {
        for (z zVar : values()) {
            if (str.equals(zVar.f302a)) {
                return zVar;
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
        return this.f302a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f302a);
    }
}
