package Q2;

import E5.t;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.B;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Comparable, Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f4519c = new b(null);
    public static final Parcelable.Creator<s> CREATOR = new a();

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s createFromParcel(Parcel source) {
            kotlin.jvm.internal.r.f(source, "source");
            return new s(source.readLong(), source.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public s[] newArray(int i7) {
            return new s[i7];
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        public final s c() {
            return new s(new Date());
        }

        public final E5.o d(Date date) {
            long j7 = 1000;
            long time = date.getTime() / j7;
            int time2 = (int) ((date.getTime() % j7) * ((long) 1000000));
            return time2 < 0 ? t.a(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000)) : t.a(Long.valueOf(time), Integer.valueOf(time2));
        }

        public final void e(long j7, int i7) {
            if (i7 < 0 || i7 >= 1000000000) {
                throw new IllegalArgumentException(("Timestamp nanoseconds out of range: " + i7).toString());
            }
            if (-62135596800L > j7 || j7 >= 253402300800L) {
                throw new IllegalArgumentException(("Timestamp seconds out of range: " + j7).toString());
            }
        }

        public b() {
        }
    }

    public s(long j7, int i7) {
        f4519c.e(j7, i7);
        this.f4520a = j7;
        this.f4521b = i7;
    }

    public static final s i() {
        return f4519c.c();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(s other) {
        kotlin.jvm.internal.r.f(other, "other");
        return G5.a.b(this, other, new B() { // from class: Q2.s.c
            @Override // kotlin.jvm.internal.B, X5.i
            public Object get(Object obj) {
                return Long.valueOf(((s) obj).h());
            }
        }, new B() { // from class: Q2.s.d
            @Override // kotlin.jvm.internal.B, X5.i
            public Object get(Object obj) {
                return Integer.valueOf(((s) obj).c());
            }
        });
    }

    public final int c() {
        return this.f4521b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof s) && compareTo((s) obj) == 0);
    }

    public final long h() {
        return this.f4520a;
    }

    public int hashCode() {
        long j7 = this.f4520a;
        return (((((int) j7) * 1369) + ((int) (j7 >> 32))) * 37) + this.f4521b;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.f4520a + ", nanoseconds=" + this.f4521b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i7) {
        kotlin.jvm.internal.r.f(dest, "dest");
        dest.writeLong(this.f4520a);
        dest.writeInt(this.f4521b);
    }

    public s(Date date) {
        kotlin.jvm.internal.r.f(date, "date");
        b bVar = f4519c;
        E5.o oVarD = bVar.d(date);
        long jLongValue = ((Number) oVarD.a()).longValue();
        int iIntValue = ((Number) oVarD.b()).intValue();
        bVar.e(jLongValue, iIntValue);
        this.f4520a = jLongValue;
        this.f4521b = iIntValue;
    }
}
