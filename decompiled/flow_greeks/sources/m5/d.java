package m5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends n5.a {
    public static final Parcelable.Creator<d> CREATOR = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15898c;

    public d(String str, int i10, long j10) {
        this.f15896a = str;
        this.f15897b = i10;
        this.f15898c = j10;
    }

    public long R() {
        long j10 = this.f15898c;
        return j10 == -1 ? this.f15897b : j10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (((getName() != null && getName().equals(dVar.getName())) || (getName() == null && dVar.getName() == null)) && R() == dVar.R()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.f15896a;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(getName(), Long.valueOf(R()));
    }

    public final String toString() {
        q.a aVarD = com.google.android.gms.common.internal.q.d(this);
        aVarD.a("name", getName());
        aVarD.a(DiagnosticsEntry.VERSION_KEY, Long.valueOf(R()));
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, getName(), false);
        n5.c.t(parcel, 2, this.f15897b);
        n5.c.x(parcel, 3, R());
        n5.c.b(parcel, iA);
    }

    public d(String str, long j10) {
        this.f15896a = str;
        this.f15898c = j10;
        this.f15897b = -1;
    }
}
