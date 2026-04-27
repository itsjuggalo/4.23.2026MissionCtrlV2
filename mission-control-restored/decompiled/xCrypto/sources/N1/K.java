package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class K extends A1.a {
    public static final Parcelable.Creator<K> CREATOR = new L();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2751a;

    public K(long j4) {
        this.f2751a = ((Long) AbstractC0940s.k(Long.valueOf(j4))).longValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof K) && this.f2751a == ((K) obj).f2751a;
    }

    public final int hashCode() {
        return AbstractC0939q.c(Long.valueOf(this.f2751a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.x(parcel, 1, this.f2751a);
        A1.c.b(parcel, iA);
    }
}
