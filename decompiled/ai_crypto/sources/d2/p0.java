package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class p0 extends Q1.a {
    public static final Parcelable.Creator<p0> CREATOR = new q0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13273b;

    public p0(byte[] bArr, byte[] bArr2) {
        this.f13272a = bArr;
        this.f13273b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return Arrays.equals(this.f13272a, p0Var.f13272a) && Arrays.equals(this.f13273b, p0Var.f13273b);
    }

    public final int hashCode() {
        return AbstractC1206q.c(this.f13272a, this.f13273b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.k(parcel, 1, this.f13272a, false);
        Q1.c.k(parcel, 2, this.f13273b, false);
        Q1.c.b(parcel, iA);
    }
}
