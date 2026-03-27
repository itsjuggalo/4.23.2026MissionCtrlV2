package o1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import java.util.Arrays;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC1255a {
    public static final Parcelable.Creator<i> CREATOR = new r(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8651a;

    public i(int i) {
        this.f8651a = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return I.j(Integer.valueOf(this.f8651a), Integer.valueOf(((i) obj).f8651a));
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8651a)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f8651a);
        u0.a0(iX, parcel);
    }
}
