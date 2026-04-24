package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class p0 extends A1.a {
    public static final Parcelable.Creator<p0> CREATOR = new q0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2817b;

    public p0(byte[] bArr, byte[] bArr2) {
        this.f2816a = bArr;
        this.f2817b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return Arrays.equals(this.f2816a, p0Var.f2816a) && Arrays.equals(this.f2817b, p0Var.f2817b);
    }

    public final int hashCode() {
        return AbstractC0939q.c(this.f2816a, this.f2817b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.k(parcel, 1, this.f2816a, false);
        A1.c.k(parcel, 2, this.f2817b, false);
        A1.c.b(parcel, iA);
    }
}
