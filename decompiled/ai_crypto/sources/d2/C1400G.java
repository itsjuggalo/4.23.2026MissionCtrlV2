package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: renamed from: d2.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1400G extends Q1.a {
    public static final Parcelable.Creator<C1400G> CREATOR = new j0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f13202a;

    public C1400G(List list) {
        this.f13202a = list;
    }

    public List A() {
        return this.f13202a;
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof C1400G)) {
            return false;
        }
        C1400G c1400g = (C1400G) obj;
        List list2 = this.f13202a;
        return (list2 == null && c1400g.f13202a == null) || (list2 != null && (list = c1400g.f13202a) != null && list2.containsAll(list) && c1400g.f13202a.containsAll(this.f13202a));
    }

    public int hashCode() {
        return AbstractC1206q.c(new HashSet(this.f13202a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.I(parcel, 1, A(), false);
        Q1.c.b(parcel, iA);
    }
}
