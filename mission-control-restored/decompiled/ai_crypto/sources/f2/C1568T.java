package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: f2.T, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1568T extends Q1.a {
    public static final Parcelable.Creator<C1568T> CREATOR = new C1569U();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14061d;

    public C1568T(int i7, int i8, int i9, int i10) {
        AbstractC1207s.o(i7 >= 0 && i7 <= 23, "Start hour must be in range [0, 23].");
        AbstractC1207s.o(i8 >= 0 && i8 <= 59, "Start minute must be in range [0, 59].");
        AbstractC1207s.o(i9 >= 0 && i9 <= 23, "End hour must be in range [0, 23].");
        AbstractC1207s.o(i10 >= 0 && i10 <= 59, "End minute must be in range [0, 59].");
        AbstractC1207s.o(((i7 + i8) + i9) + i10 > 0, "Parameters can't be all 0.");
        this.f14058a = i7;
        this.f14059b = i8;
        this.f14060c = i9;
        this.f14061d = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1568T)) {
            return false;
        }
        C1568T c1568t = (C1568T) obj;
        return this.f14058a == c1568t.f14058a && this.f14059b == c1568t.f14059b && this.f14060c == c1568t.f14060c && this.f14061d == c1568t.f14061d;
    }

    public final int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f14058a), Integer.valueOf(this.f14059b), Integer.valueOf(this.f14060c), Integer.valueOf(this.f14061d));
    }

    public final String toString() {
        int i7 = this.f14058a;
        int i8 = this.f14059b;
        int i9 = this.f14060c;
        int i10 = this.f14061d;
        StringBuilder sb = new StringBuilder(117);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(i7);
        sb.append(", startMinute=");
        sb.append(i8);
        sb.append(", endHour=");
        sb.append(i9);
        sb.append(", endMinute=");
        sb.append(i10);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        AbstractC1207s.k(parcel);
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f14058a);
        Q1.c.t(parcel, 2, this.f14059b);
        Q1.c.t(parcel, 3, this.f14060c);
        Q1.c.t(parcel, 4, this.f14061d);
        Q1.c.b(parcel, iA);
    }
}
