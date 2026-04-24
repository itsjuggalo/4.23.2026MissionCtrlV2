package z1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: renamed from: z1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1986d extends A1.a {
    public static final Parcelable.Creator<C1986d> CREATOR = new C2000r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16091c;

    public C1986d(String str, int i4, long j4) {
        this.f16089a = str;
        this.f16090b = i4;
        this.f16091c = j4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1986d) {
            C1986d c1986d = (C1986d) obj;
            if (((getName() != null && getName().equals(c1986d.getName())) || (getName() == null && c1986d.getName() == null)) && i() == c1986d.i()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.f16089a;
    }

    public final int hashCode() {
        return AbstractC0939q.c(getName(), Long.valueOf(i()));
    }

    public long i() {
        long j4 = this.f16091c;
        return j4 == -1 ? this.f16090b : j4;
    }

    public final String toString() {
        AbstractC0939q.a aVarD = AbstractC0939q.d(this);
        aVarD.a("name", getName());
        aVarD.a(DiagnosticsEntry.VERSION_KEY, Long.valueOf(i()));
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, getName(), false);
        A1.c.t(parcel, 2, this.f16090b);
        A1.c.x(parcel, 3, i());
        A1.c.b(parcel, iA);
    }

    public C1986d(String str, long j4) {
        this.f16089a = str;
        this.f16091c = j4;
        this.f16090b = -1;
    }
}
