package Q1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1293m;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: renamed from: Q1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0792d extends T1.a {
    public static final Parcelable.Creator<C0792d> CREATOR = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6688c;

    public C0792d(String str, int i8, long j8) {
        this.f6686a = str;
        this.f6687b = i8;
        this.f6688c = j8;
    }

    public long a() {
        long j8 = this.f6688c;
        return j8 == -1 ? this.f6687b : j8;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0792d) {
            C0792d c0792d = (C0792d) obj;
            if (((getName() != null && getName().equals(c0792d.getName())) || (getName() == null && c0792d.getName() == null)) && a() == c0792d.a()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.f6686a;
    }

    public final int hashCode() {
        return AbstractC1293m.b(getName(), Long.valueOf(a()));
    }

    public final String toString() {
        AbstractC1293m.a aVarC = AbstractC1293m.c(this);
        aVarC.a("name", getName());
        aVarC.a(DiagnosticsEntry.VERSION_KEY, Long.valueOf(a()));
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.p(parcel, 1, getName(), false);
        T1.c.j(parcel, 2, this.f6687b);
        T1.c.m(parcel, 3, a());
        T1.c.b(parcel, iA);
    }

    public C0792d(String str, long j8) {
        this.f6686a = str;
        this.f6688c = j8;
        this.f6687b = -1;
    }
}
