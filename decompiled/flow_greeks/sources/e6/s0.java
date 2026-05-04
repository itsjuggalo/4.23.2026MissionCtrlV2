package e6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends n5.a {
    public static final Parcelable.Creator<s0> CREATOR = new t0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8449d;

    public s0(int i10, int i11, int i12, int i13) {
        com.google.android.gms.common.internal.s.o(i10 >= 0 && i10 <= 23, "Start hour must be in range [0, 23].");
        com.google.android.gms.common.internal.s.o(i11 >= 0 && i11 <= 59, "Start minute must be in range [0, 59].");
        com.google.android.gms.common.internal.s.o(i12 >= 0 && i12 <= 23, "End hour must be in range [0, 23].");
        com.google.android.gms.common.internal.s.o(i13 >= 0 && i13 <= 59, "End minute must be in range [0, 59].");
        com.google.android.gms.common.internal.s.o(((i10 + i11) + i12) + i13 > 0, "Parameters can't be all 0.");
        this.f8446a = i10;
        this.f8447b = i11;
        this.f8448c = i12;
        this.f8449d = i13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return this.f8446a == s0Var.f8446a && this.f8447b == s0Var.f8447b && this.f8448c == s0Var.f8448c && this.f8449d == s0Var.f8449d;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.f8446a), Integer.valueOf(this.f8447b), Integer.valueOf(this.f8448c), Integer.valueOf(this.f8449d));
    }

    public final String toString() {
        int i10 = this.f8446a;
        int i11 = this.f8447b;
        int i12 = this.f8448c;
        int i13 = this.f8449d;
        StringBuilder sb2 = new StringBuilder(117);
        sb2.append("UserPreferredSleepWindow [startHour=");
        sb2.append(i10);
        sb2.append(", startMinute=");
        sb2.append(i11);
        sb2.append(", endHour=");
        sb2.append(i12);
        sb2.append(", endMinute=");
        sb2.append(i13);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        com.google.android.gms.common.internal.s.k(parcel);
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f8446a);
        n5.c.t(parcel, 2, this.f8447b);
        n5.c.t(parcel, 3, this.f8448c);
        n5.c.t(parcel, 4, this.f8449d);
        n5.c.b(parcel, iA);
    }
}
