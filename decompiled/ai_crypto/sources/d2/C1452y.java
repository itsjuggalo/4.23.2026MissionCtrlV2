package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: d2.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1452y extends Q1.a {
    public static final Parcelable.Creator<C1452y> CREATOR = new C1418Z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13328c;

    public C1452y(String str, String str2, String str3) {
        this.f13326a = (String) AbstractC1207s.k(str);
        this.f13327b = (String) AbstractC1207s.k(str2);
        this.f13328c = str3;
    }

    public String A() {
        return this.f13328c;
    }

    public String B() {
        return this.f13326a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1452y)) {
            return false;
        }
        C1452y c1452y = (C1452y) obj;
        return AbstractC1206q.b(this.f13326a, c1452y.f13326a) && AbstractC1206q.b(this.f13327b, c1452y.f13327b) && AbstractC1206q.b(this.f13328c, c1452y.f13328c);
    }

    public String getName() {
        return this.f13327b;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13326a, this.f13327b, this.f13328c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, B(), false);
        Q1.c.E(parcel, 3, getName(), false);
        Q1.c.E(parcel, 4, A(), false);
        Q1.c.b(parcel, iA);
    }
}
