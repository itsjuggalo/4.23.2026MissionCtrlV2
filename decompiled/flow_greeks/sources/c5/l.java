package c5;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l extends n5.a {
    public static final Parcelable.Creator<l> CREATOR = new h0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f3676a;

    public l(PendingIntent pendingIntent) {
        this.f3676a = (PendingIntent) com.google.android.gms.common.internal.s.k(pendingIntent);
    }

    public PendingIntent R() {
        return this.f3676a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return com.google.android.gms.common.internal.q.b(this.f3676a, ((l) obj).f3676a);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f3676a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, R(), i10, false);
        n5.c.b(parcel, iA);
    }
}
