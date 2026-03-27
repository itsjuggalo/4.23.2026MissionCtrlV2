package I1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: loaded from: classes.dex */
public class h extends Q1.a {
    public static final Parcelable.Creator<h> CREATOR = new B();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f2924a;

    public h(PendingIntent pendingIntent) {
        this.f2924a = pendingIntent;
    }

    public PendingIntent A() {
        return this.f2924a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return AbstractC1206q.b(this.f2924a, ((h) obj).f2924a);
        }
        return false;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f2924a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, A(), i7, false);
        Q1.c.b(parcel, iA);
    }
}
