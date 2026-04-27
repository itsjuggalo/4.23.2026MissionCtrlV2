package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class C0 extends Q1.a {
    public static final Parcelable.Creator<C0> CREATOR = new D0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f13185a;

    public C0(List list) {
        this.f13185a = (List) AbstractC1207s.k(list);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0)) {
            return false;
        }
        C0 c02 = (C0) obj;
        return this.f13185a.containsAll(c02.f13185a) && c02.f13185a.containsAll(this.f13185a);
    }

    public final int hashCode() {
        return AbstractC1206q.c(new HashSet(this.f13185a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.I(parcel, 1, this.f13185a, false);
        Q1.c.b(parcel, iA);
    }
}
