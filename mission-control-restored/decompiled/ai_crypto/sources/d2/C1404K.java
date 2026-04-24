package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: d2.K, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1404K extends Q1.a {
    public static final Parcelable.Creator<C1404K> CREATOR = new C1405L();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13207a;

    public C1404K(long j7) {
        this.f13207a = ((Long) AbstractC1207s.k(Long.valueOf(j7))).longValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1404K) && this.f13207a == ((C1404K) obj).f13207a;
    }

    public final int hashCode() {
        return AbstractC1206q.c(Long.valueOf(this.f13207a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.x(parcel, 1, this.f13207a);
        Q1.c.b(parcel, iA);
    }
}
