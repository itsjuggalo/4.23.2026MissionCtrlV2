package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class C0 extends A1.a {
    public static final Parcelable.Creator<C0> CREATOR = new D0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2729a;

    public C0(List list) {
        this.f2729a = (List) AbstractC0940s.k(list);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0)) {
            return false;
        }
        C0 c02 = (C0) obj;
        return this.f2729a.containsAll(c02.f2729a) && c02.f2729a.containsAll(this.f2729a);
    }

    public final int hashCode() {
        return AbstractC0939q.c(new HashSet(this.f2729a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.I(parcel, 1, this.f2729a, false);
        A1.c.b(parcel, iA);
    }
}
