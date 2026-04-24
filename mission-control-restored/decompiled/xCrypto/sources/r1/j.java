package r1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public class j extends A1.a {
    public static final Parcelable.Creator<j> CREATOR = new D();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f14547a;

    public j(PendingIntent pendingIntent) {
        this.f14547a = (PendingIntent) AbstractC0940s.k(pendingIntent);
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return AbstractC0939q.b(this.f14547a, ((j) obj).f14547a);
        }
        return false;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f14547a);
    }

    public PendingIntent i() {
        return this.f14547a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 1, i(), i4, false);
        A1.c.b(parcel, iA);
    }
}
