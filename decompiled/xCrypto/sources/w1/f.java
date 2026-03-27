package w1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public class f extends A1.a {
    public static final Parcelable.Creator<f> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f15565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15567c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f15568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15570c = "com.google.android.gms.auth.blockstore.DEFAULT_BYTES_DATA_KEY";

        public f a() {
            return new f(this.f15568a, this.f15569b, this.f15570c);
        }

        public a b(byte[] bArr) {
            this.f15568a = bArr;
            return this;
        }

        public a c(String str) {
            AbstractC0940s.f(str, "key cannot be null or empty");
            this.f15570c = str;
            return this;
        }

        public a d(boolean z4) {
            this.f15569b = z4;
            return this;
        }
    }

    public f(byte[] bArr, boolean z4, String str) {
        this.f15565a = bArr;
        this.f15566b = z4;
        this.f15567c = str;
    }

    public byte[] i() {
        return this.f15565a;
    }

    public String k() {
        return this.f15567c;
    }

    public boolean l() {
        return this.f15566b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.k(parcel, 1, i(), false);
        A1.c.g(parcel, 2, l());
        A1.c.E(parcel, 3, k(), false);
        A1.c.b(parcel, iA);
    }
}
