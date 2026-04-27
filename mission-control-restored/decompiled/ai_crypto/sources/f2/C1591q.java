package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.List;

/* JADX INFO: renamed from: f2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1591q extends Q1.a {
    public static final Parcelable.Creator<C1591q> CREATOR = new C1567S();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14110b;

    public C1591q(List list, int i7) {
        this.f14109a = list;
        this.f14110b = i7;
    }

    public int A() {
        return this.f14110b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1591q)) {
            return false;
        }
        C1591q c1591q = (C1591q) obj;
        return AbstractC1206q.b(this.f14109a, c1591q.f14109a) && this.f14110b == c1591q.f14110b;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f14109a, Integer.valueOf(this.f14110b));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        AbstractC1207s.k(parcel);
        int iA = Q1.c.a(parcel);
        Q1.c.I(parcel, 1, this.f14109a, false);
        Q1.c.t(parcel, 2, A());
        Q1.c.b(parcel, iA);
    }
}
