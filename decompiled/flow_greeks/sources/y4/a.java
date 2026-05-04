package y4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends n5.a {
    public static final Parcelable.Creator<a> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f25263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f25264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f25265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f25266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f25267f;

    public a(int i10, long j10, String str, int i11, int i12, String str2) {
        this.f25262a = i10;
        this.f25263b = j10;
        this.f25264c = (String) s.k(str);
        this.f25265d = i11;
        this.f25266e = i12;
        this.f25267f = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        a aVar = (a) obj;
        return this.f25262a == aVar.f25262a && this.f25263b == aVar.f25263b && q.b(this.f25264c, aVar.f25264c) && this.f25265d == aVar.f25265d && this.f25266e == aVar.f25266e && q.b(this.f25267f, aVar.f25267f);
    }

    public int hashCode() {
        return q.c(Integer.valueOf(this.f25262a), Long.valueOf(this.f25263b), this.f25264c, Integer.valueOf(this.f25265d), Integer.valueOf(this.f25266e), this.f25267f);
    }

    public String toString() {
        int i10 = this.f25265d;
        String str = i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        return "AccountChangeEvent {accountName = " + this.f25264c + ", changeType = " + str + ", changeData = " + this.f25267f + ", eventIndex = " + this.f25266e + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f25262a);
        n5.c.x(parcel, 2, this.f25263b);
        n5.c.E(parcel, 3, this.f25264c, false);
        n5.c.t(parcel, 4, this.f25265d);
        n5.c.t(parcel, 5, this.f25266e);
        n5.c.E(parcel, 6, this.f25267f, false);
        n5.c.b(parcel, iA);
    }
}
