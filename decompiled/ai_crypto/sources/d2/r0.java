package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class r0 extends Q1.a {
    public static final Parcelable.Creator<r0> CREATOR = new s0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13290b;

    public r0(boolean z7, byte[] bArr) {
        this.f13289a = z7;
        this.f13290b = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return this.f13289a == r0Var.f13289a && Arrays.equals(this.f13290b, r0Var.f13290b);
    }

    public final int hashCode() {
        return AbstractC1206q.c(Boolean.valueOf(this.f13289a), this.f13290b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.g(parcel, 1, this.f13289a);
        Q1.c.k(parcel, 2, this.f13290b, false);
        Q1.c.b(parcel, iA);
    }
}
