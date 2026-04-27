package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class A extends A1.a {
    public static final Parcelable.Creator<A> CREATOR = new C0459b0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2714d;

    public A(byte[] bArr, String str, String str2, String str3) {
        this.f2711a = (byte[]) AbstractC0940s.k(bArr);
        this.f2712b = (String) AbstractC0940s.k(str);
        this.f2713c = str2;
        this.f2714d = (String) AbstractC0940s.k(str3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof A)) {
            return false;
        }
        A a4 = (A) obj;
        return Arrays.equals(this.f2711a, a4.f2711a) && AbstractC0939q.b(this.f2712b, a4.f2712b) && AbstractC0939q.b(this.f2713c, a4.f2713c) && AbstractC0939q.b(this.f2714d, a4.f2714d);
    }

    public String getDisplayName() {
        return this.f2714d;
    }

    public String getName() {
        return this.f2712b;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2711a, this.f2712b, this.f2713c, this.f2714d);
    }

    public String i() {
        return this.f2713c;
    }

    public byte[] k() {
        return this.f2711a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.k(parcel, 2, k(), false);
        A1.c.E(parcel, 3, getName(), false);
        A1.c.E(parcel, 4, i(), false);
        A1.c.E(parcel, 5, getDisplayName(), false);
        A1.c.b(parcel, iA);
    }
}
