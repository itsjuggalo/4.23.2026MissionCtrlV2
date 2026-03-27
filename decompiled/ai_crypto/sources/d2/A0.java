package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class A0 extends Q1.a {
    public static final Parcelable.Creator<A0> CREATOR = new B0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f13174d;

    public A0(long j7, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f13171a = j7;
        this.f13172b = (byte[]) AbstractC1207s.k(bArr);
        this.f13173c = (byte[]) AbstractC1207s.k(bArr2);
        this.f13174d = (byte[]) AbstractC1207s.k(bArr3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof A0)) {
            return false;
        }
        A0 a02 = (A0) obj;
        return this.f13171a == a02.f13171a && Arrays.equals(this.f13172b, a02.f13172b) && Arrays.equals(this.f13173c, a02.f13173c) && Arrays.equals(this.f13174d, a02.f13174d);
    }

    public final int hashCode() {
        return AbstractC1206q.c(Long.valueOf(this.f13171a), this.f13172b, this.f13173c, this.f13174d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.x(parcel, 1, this.f13171a);
        Q1.c.k(parcel, 2, this.f13172b, false);
        Q1.c.k(parcel, 3, this.f13173c, false);
        Q1.c.k(parcel, 4, this.f13174d, false);
        Q1.c.b(parcel, iA);
    }
}
