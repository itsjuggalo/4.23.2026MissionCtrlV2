package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class A0 extends A1.a {
    public static final Parcelable.Creator<A0> CREATOR = new B0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f2718d;

    public A0(long j4, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f2715a = j4;
        this.f2716b = (byte[]) AbstractC0940s.k(bArr);
        this.f2717c = (byte[]) AbstractC0940s.k(bArr2);
        this.f2718d = (byte[]) AbstractC0940s.k(bArr3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof A0)) {
            return false;
        }
        A0 a02 = (A0) obj;
        return this.f2715a == a02.f2715a && Arrays.equals(this.f2716b, a02.f2716b) && Arrays.equals(this.f2717c, a02.f2717c) && Arrays.equals(this.f2718d, a02.f2718d);
    }

    public final int hashCode() {
        return AbstractC0939q.c(Long.valueOf(this.f2715a), this.f2716b, this.f2717c, this.f2718d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.x(parcel, 1, this.f2715a);
        A1.c.k(parcel, 2, this.f2716b, false);
        A1.c.k(parcel, 3, this.f2717c, false);
        A1.c.k(parcel, 4, this.f2718d, false);
        A1.c.b(parcel, iA);
    }
}
