package P1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.location.zzbs;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class P extends A1.a {
    public static final Parcelable.Creator<P> CREATOR = new Q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f3391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3392c;

    public P(List list, PendingIntent pendingIntent, String str) {
        this.f3390a = list == null ? zzbs.zzi() : zzbs.zzj(list);
        this.f3391b = pendingIntent;
        this.f3392c = str;
    }

    public static P i(List list) {
        AbstractC0940s.l(list, "geofence can't be null.");
        AbstractC0940s.b(!list.isEmpty(), "Geofences must contains at least one id.");
        return new P(list, null, "");
    }

    public static P k(PendingIntent pendingIntent) {
        AbstractC0940s.l(pendingIntent, "PendingIntent can not be null.");
        return new P(null, pendingIntent, "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.G(parcel, 1, this.f3390a, false);
        A1.c.C(parcel, 2, this.f3391b, i4, false);
        A1.c.E(parcel, 3, this.f3392c, false);
        A1.c.b(parcel, iA);
    }
}
