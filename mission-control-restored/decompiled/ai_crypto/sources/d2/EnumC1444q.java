package d2;

import android.os.Parcel;
import android.os.Parcelable;
import d2.EnumC1444q;
import java.util.Locale;

/* JADX INFO: renamed from: d2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1444q implements Parcelable {
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

    public static final Parcelable.Creator<EnumC1444q> CREATOR = new Parcelable.Creator() { // from class: d2.G0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return EnumC1444q.c(parcel.readInt());
            } catch (EnumC1444q.a e7) {
                throw new IllegalArgumentException(e7);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i7) {
            return new EnumC1444q[i7];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13287a;

    /* JADX INFO: renamed from: d2.q$a */
    public static class a extends Exception {
        public a(int i7) {
            super(String.format(Locale.US, "Error code %d is not supported", Integer.valueOf(i7)));
        }
    }

    EnumC1444q(int i7) {
        this.f13287a = i7;
    }

    public static EnumC1444q c(int i7) throws a {
        for (EnumC1444q enumC1444q : values()) {
            if (i7 == enumC1444q.f13287a) {
                return enumC1444q;
            }
        }
        throw new a(i7);
    }

    public int a() {
        return this.f13287a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f13287a);
    }
}
