package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class r0 extends A1.a {
    public static final Parcelable.Creator<r0> CREATOR = new s0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2834b;

    public r0(boolean z4, byte[] bArr) {
        this.f2833a = z4;
        this.f2834b = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return this.f2833a == r0Var.f2833a && Arrays.equals(this.f2834b, r0Var.f2834b);
    }

    public final int hashCode() {
        return AbstractC0939q.c(Boolean.valueOf(this.f2833a), this.f2834b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.g(parcel, 1, this.f2833a);
        A1.c.k(parcel, 2, this.f2834b, false);
        A1.c.b(parcel, iA);
    }
}
