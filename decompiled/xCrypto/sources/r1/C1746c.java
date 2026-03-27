package r1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: r1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1746c extends A1.a {
    public static final Parcelable.Creator<C1746c> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f14526a;

    public C1746c(PendingIntent pendingIntent) {
        this.f14526a = (PendingIntent) AbstractC0940s.k(pendingIntent);
    }

    public PendingIntent i() {
        return this.f14526a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 1, i(), i4, false);
        A1.c.b(parcel, iA);
    }
}
