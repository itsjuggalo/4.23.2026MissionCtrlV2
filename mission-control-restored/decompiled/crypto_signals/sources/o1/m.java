package o1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import java.util.Arrays;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class m extends AbstractC1255a {
    public static final Parcelable.Creator<m> CREATOR = new r(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f8661a;

    public m(PendingIntent pendingIntent) {
        I.g(pendingIntent);
        this.f8661a = pendingIntent;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return I.j(this.f8661a, ((m) obj).f8661a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8661a});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.S(parcel, 1, this.f8661a, i, false);
        u0.a0(iX, parcel);
    }
}
