package h5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends n5.a {
    public static final Parcelable.Creator<f> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f11019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11021c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f11022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11024c = "com.google.android.gms.auth.blockstore.DEFAULT_BYTES_DATA_KEY";

        public f a() {
            return new f(this.f11022a, this.f11023b, this.f11024c);
        }

        public a b(byte[] bArr) {
            this.f11022a = bArr;
            return this;
        }

        public a c(String str) {
            s.f(str, "key cannot be null or empty");
            this.f11024c = str;
            return this;
        }

        public a d(boolean z10) {
            this.f11023b = z10;
            return this;
        }
    }

    public f(byte[] bArr, boolean z10, String str) {
        this.f11019a = bArr;
        this.f11020b = z10;
        this.f11021c = str;
    }

    public byte[] R() {
        return this.f11019a;
    }

    public String S() {
        return this.f11021c;
    }

    public boolean T() {
        return this.f11020b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.k(parcel, 1, R(), false);
        n5.c.g(parcel, 2, T());
        n5.c.E(parcel, 3, S(), false);
        n5.c.b(parcel, iA);
    }
}
