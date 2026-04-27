package f2;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.location.zzbs;
import java.util.List;

/* JADX INFO: renamed from: f2.P, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1565P extends Q1.a {
    public static final Parcelable.Creator<C1565P> CREATOR = new C1566Q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f14056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14057c;

    public C1565P(List list, PendingIntent pendingIntent, String str) {
        this.f14055a = list == null ? zzbs.zzi() : zzbs.zzj(list);
        this.f14056b = pendingIntent;
        this.f14057c = str;
    }

    public static C1565P A(List list) {
        AbstractC1207s.l(list, "geofence can't be null.");
        AbstractC1207s.b(!list.isEmpty(), "Geofences must contains at least one id.");
        return new C1565P(list, null, "");
    }

    public static C1565P B(PendingIntent pendingIntent) {
        AbstractC1207s.l(pendingIntent, "PendingIntent can not be null.");
        return new C1565P(null, pendingIntent, "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.G(parcel, 1, this.f14055a, false);
        Q1.c.C(parcel, 2, this.f14056b, i7, false);
        Q1.c.E(parcel, 3, this.f14057c, false);
        Q1.c.b(parcel, iA);
    }
}
