package N1;

import N1.EnumC0481q;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* JADX INFO: renamed from: N1.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0481q implements Parcelable {
    NOT_SUPPORTED_ERR(9),
    INVALID_STATE_ERR(11),
    SECURITY_ERR(18),
    NETWORK_ERR(19),
    ABORT_ERR(20),
    TIMEOUT_ERR(23),
    ENCODING_ERR(27),
    UNKNOWN_ERR(28),
    CONSTRAINT_ERR(29),
    DATA_ERR(30),
    NOT_ALLOWED_ERR(35),
    ATTESTATION_NOT_PRIVATE_ERR(36);

    public static final Parcelable.Creator<EnumC0481q> CREATOR = new Parcelable.Creator() { // from class: N1.G0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC0481q.c(parcel.readInt());
            } catch (EnumC0481q.a e4) {
                throw new IllegalArgumentException(e4);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i4) {
            return new EnumC0481q[i4];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2831a;

    /* JADX INFO: renamed from: N1.q$a */
    public static class a extends Exception {
        public a(int i4) {
            super(String.format(Locale.US, "Error code %d is not supported", Integer.valueOf(i4)));
        }
    }

    EnumC0481q(int i4) {
        this.f2831a = i4;
    }

    public static EnumC0481q c(int i4) throws a {
        for (EnumC0481q enumC0481q : values()) {
            if (i4 == enumC0481q.f2831a) {
                return enumC0481q;
            }
        }
        throw new a(i4);
    }

    public int a() {
        return this.f2831a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2831a);
    }
}
