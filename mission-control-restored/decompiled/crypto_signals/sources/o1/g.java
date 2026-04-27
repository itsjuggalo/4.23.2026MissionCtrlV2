package o1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AbstractC1255a {
    public static final Parcelable.Creator<g> CREATOR = new r(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f8650a;

    public g(PendingIntent pendingIntent) {
        I.g(pendingIntent);
        this.f8650a = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.S(parcel, 1, this.f8650a, i, false);
        u0.a0(iX, parcel);
    }
}
