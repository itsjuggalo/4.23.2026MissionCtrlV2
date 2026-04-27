package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class T extends A1.a {
    public static final Parcelable.Creator<T> CREATOR = new U();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3396d;

    public T(int i4, int i5, int i6, int i7) {
        AbstractC0940s.o(i4 >= 0 && i4 <= 23, "Start hour must be in range [0, 23].");
        AbstractC0940s.o(i5 >= 0 && i5 <= 59, "Start minute must be in range [0, 59].");
        AbstractC0940s.o(i6 >= 0 && i6 <= 23, "End hour must be in range [0, 23].");
        AbstractC0940s.o(i7 >= 0 && i7 <= 59, "End minute must be in range [0, 59].");
        AbstractC0940s.o(((i4 + i5) + i6) + i7 > 0, "Parameters can't be all 0.");
        this.f3393a = i4;
        this.f3394b = i5;
        this.f3395c = i6;
        this.f3396d = i7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof T)) {
            return false;
        }
        T t4 = (T) obj;
        return this.f3393a == t4.f3393a && this.f3394b == t4.f3394b && this.f3395c == t4.f3395c && this.f3396d == t4.f3396d;
    }

    public final int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f3393a), Integer.valueOf(this.f3394b), Integer.valueOf(this.f3395c), Integer.valueOf(this.f3396d));
    }

    public final String toString() {
        int i4 = this.f3393a;
        int i5 = this.f3394b;
        int i6 = this.f3395c;
        int i7 = this.f3396d;
        StringBuilder sb = new StringBuilder(117);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(i4);
        sb.append(", startMinute=");
        sb.append(i5);
        sb.append(", endHour=");
        sb.append(i6);
        sb.append(", endMinute=");
        sb.append(i7);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        AbstractC0940s.k(parcel);
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f3393a);
        A1.c.t(parcel, 2, this.f3394b);
        A1.c.t(parcel, 3, this.f3395c);
        A1.c.t(parcel, 4, this.f3396d);
        A1.c.b(parcel, iA);
    }
}
