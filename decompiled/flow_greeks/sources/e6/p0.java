package e6;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbs;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends n5.a {
    public static final Parcelable.Creator<p0> CREATOR = new q0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f8442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8443c;

    public p0(List list, PendingIntent pendingIntent, String str) {
        this.f8441a = list == null ? zzbs.zzi() : zzbs.zzj(list);
        this.f8442b = pendingIntent;
        this.f8443c = str;
    }

    public static p0 R(List list) {
        com.google.android.gms.common.internal.s.l(list, "geofence can't be null.");
        com.google.android.gms.common.internal.s.b(!list.isEmpty(), "Geofences must contains at least one id.");
        return new p0(list, null, "");
    }

    public static p0 S(PendingIntent pendingIntent) {
        com.google.android.gms.common.internal.s.l(pendingIntent, "PendingIntent can not be null.");
        return new p0(null, pendingIntent, "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.G(parcel, 1, this.f8441a, false);
        n5.c.C(parcel, 2, this.f8442b, i10, false);
        n5.c.E(parcel, 3, this.f8443c, false);
        n5.c.b(parcel, iA);
    }
}
