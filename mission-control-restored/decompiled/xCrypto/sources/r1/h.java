package r1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: loaded from: classes.dex */
public class h extends A1.a {
    public static final Parcelable.Creator<h> CREATOR = new B();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f14540a;

    public h(PendingIntent pendingIntent) {
        this.f14540a = pendingIntent;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return AbstractC0939q.b(this.f14540a, ((h) obj).f14540a);
        }
        return false;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f14540a);
    }

    public PendingIntent i() {
        return this.f14540a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 1, i(), i4, false);
        A1.c.b(parcel, iA);
    }
}
