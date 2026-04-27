package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: renamed from: P1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0650d extends Q1.a {
    public static final Parcelable.Creator<C0650d> CREATOR = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4294c;

    public C0650d(String str, int i7, long j7) {
        this.f4292a = str;
        this.f4293b = i7;
        this.f4294c = j7;
    }

    public long A() {
        long j7 = this.f4294c;
        return j7 == -1 ? this.f4293b : j7;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0650d) {
            C0650d c0650d = (C0650d) obj;
            if (((getName() != null && getName().equals(c0650d.getName())) || (getName() == null && c0650d.getName() == null)) && A() == c0650d.A()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.f4292a;
    }

    public final int hashCode() {
        return AbstractC1206q.c(getName(), Long.valueOf(A()));
    }

    public final String toString() {
        AbstractC1206q.a aVarD = AbstractC1206q.d(this);
        aVarD.a("name", getName());
        aVarD.a(DiagnosticsEntry.VERSION_KEY, Long.valueOf(A()));
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, getName(), false);
        Q1.c.t(parcel, 2, this.f4293b);
        Q1.c.x(parcel, 3, A());
        Q1.c.b(parcel, iA);
    }

    public C0650d(String str, long j7) {
        this.f4292a = str;
        this.f4294c = j7;
        this.f4293b = -1;
    }
}
