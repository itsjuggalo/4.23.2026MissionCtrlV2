package I1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public class j extends Q1.a {
    public static final Parcelable.Creator<j> CREATOR = new D();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f2931a;

    public j(PendingIntent pendingIntent) {
        this.f2931a = (PendingIntent) AbstractC1207s.k(pendingIntent);
    }

    public PendingIntent A() {
        return this.f2931a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return AbstractC1206q.b(this.f2931a, ((j) obj).f2931a);
        }
        return false;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f2931a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, A(), i7, false);
        Q1.c.b(parcel, iA);
    }
}
