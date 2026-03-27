package Z1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Comparable, Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3983b;

    public r(int i, long j4) {
        j.a(i, j4);
        this.f3982a = j4;
        this.f3983b = i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(r other) {
        kotlin.jvm.internal.j.e(other, "other");
        R4.l[] lVarArr = {p.f3980b, q.f3981b};
        for (int i = 0; i < 2; i++) {
            R4.l lVar = lVarArr[i];
            Comparable comparable = (Comparable) lVar.invoke(this);
            Comparable comparable2 = (Comparable) lVar.invoke(other);
            int iCompareTo = comparable == comparable2 ? 0 : comparable == null ? -1 : comparable2 == null ? 1 : comparable.compareTo(comparable2);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof r) && compareTo((r) obj) == 0;
        }
        return true;
    }

    public final int hashCode() {
        long j4 = this.f3982a;
        return (((((int) j4) * 1369) + ((int) (j4 >> 32))) * 37) + this.f3983b;
    }

    public final String toString() {
        return "Timestamp(seconds=" + this.f3982a + ", nanoseconds=" + this.f3983b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        kotlin.jvm.internal.j.e(dest, "dest");
        dest.writeLong(this.f3982a);
        dest.writeInt(this.f3983b);
    }

    public r(Date date) {
        G4.f fVar;
        kotlin.jvm.internal.j.e(date, "date");
        long j4 = 1000;
        long time = date.getTime() / j4;
        int time2 = (int) ((date.getTime() % j4) * ((long) 1000000));
        if (time2 < 0) {
            fVar = new G4.f(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000));
        } else {
            fVar = new G4.f(Long.valueOf(time), Integer.valueOf(time2));
        }
        long jLongValue = ((Number) fVar.f529a).longValue();
        int iIntValue = ((Number) fVar.f530b).intValue();
        j.a(iIntValue, jLongValue);
        this.f3982a = jLongValue;
        this.f3983b = iIntValue;
    }
}
