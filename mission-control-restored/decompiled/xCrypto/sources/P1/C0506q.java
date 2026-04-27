package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.List;

/* JADX INFO: renamed from: P1.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0506q extends A1.a {
    public static final Parcelable.Creator<C0506q> CREATOR = new S();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3445b;

    public C0506q(List list, int i4) {
        this.f3444a = list;
        this.f3445b = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0506q)) {
            return false;
        }
        C0506q c0506q = (C0506q) obj;
        return AbstractC0939q.b(this.f3444a, c0506q.f3444a) && this.f3445b == c0506q.f3445b;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f3444a, Integer.valueOf(this.f3445b));
    }

    public int i() {
        return this.f3445b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        AbstractC0940s.k(parcel);
        int iA = A1.c.a(parcel);
        A1.c.I(parcel, 1, this.f3444a, false);
        A1.c.t(parcel, 2, i());
        A1.c.b(parcel, iA);
    }
}
