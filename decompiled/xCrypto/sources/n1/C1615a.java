package n1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: n1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1615a extends A1.a {
    public static final Parcelable.Creator<C1615a> CREATOR = new C1621g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13594f;

    public C1615a(int i4, long j4, String str, int i5, int i6, String str2) {
        this.f13589a = i4;
        this.f13590b = j4;
        this.f13591c = (String) AbstractC0940s.k(str);
        this.f13592d = i5;
        this.f13593e = i6;
        this.f13594f = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1615a)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C1615a c1615a = (C1615a) obj;
        return this.f13589a == c1615a.f13589a && this.f13590b == c1615a.f13590b && AbstractC0939q.b(this.f13591c, c1615a.f13591c) && this.f13592d == c1615a.f13592d && this.f13593e == c1615a.f13593e && AbstractC0939q.b(this.f13594f, c1615a.f13594f);
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f13589a), Long.valueOf(this.f13590b), this.f13591c, Integer.valueOf(this.f13592d), Integer.valueOf(this.f13593e), this.f13594f);
    }

    public String toString() {
        int i4 = this.f13592d;
        String str = i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        return "AccountChangeEvent {accountName = " + this.f13591c + ", changeType = " + str + ", changeData = " + this.f13594f + ", eventIndex = " + this.f13593e + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f13589a);
        A1.c.x(parcel, 2, this.f13590b);
        A1.c.E(parcel, 3, this.f13591c, false);
        A1.c.t(parcel, 4, this.f13592d);
        A1.c.t(parcel, 5, this.f13593e);
        A1.c.E(parcel, 6, this.f13594f, false);
        A1.c.b(parcel, iA);
    }
}
