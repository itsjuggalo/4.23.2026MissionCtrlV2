package E1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public class a extends Q1.a {
    public static final Parcelable.Creator<a> CREATOR = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1581f;

    public a(int i7, long j7, String str, int i8, int i9, String str2) {
        this.f1576a = i7;
        this.f1577b = j7;
        this.f1578c = (String) AbstractC1207s.k(str);
        this.f1579d = i8;
        this.f1580e = i9;
        this.f1581f = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        a aVar = (a) obj;
        return this.f1576a == aVar.f1576a && this.f1577b == aVar.f1577b && AbstractC1206q.b(this.f1578c, aVar.f1578c) && this.f1579d == aVar.f1579d && this.f1580e == aVar.f1580e && AbstractC1206q.b(this.f1581f, aVar.f1581f);
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f1576a), Long.valueOf(this.f1577b), this.f1578c, Integer.valueOf(this.f1579d), Integer.valueOf(this.f1580e), this.f1581f);
    }

    public String toString() {
        int i7 = this.f1579d;
        String str = i7 != 1 ? i7 != 2 ? i7 != 3 ? i7 != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        return "AccountChangeEvent {accountName = " + this.f1578c + ", changeType = " + str + ", changeData = " + this.f1581f + ", eventIndex = " + this.f1580e + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f1576a);
        Q1.c.x(parcel, 2, this.f1577b);
        Q1.c.E(parcel, 3, this.f1578c, false);
        Q1.c.t(parcel, 4, this.f1579d);
        Q1.c.t(parcel, 5, this.f1580e);
        Q1.c.E(parcel, 6, this.f1581f, false);
        Q1.c.b(parcel, iA);
    }
}
