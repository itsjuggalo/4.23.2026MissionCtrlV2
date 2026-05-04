package a7;

import android.os.Parcel;
import android.os.Parcelable;
import cd.w;
import java.util.Date;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Comparable, Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f340c = new b(null);
    public static final Parcelable.Creator<s> CREATOR = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s createFromParcel(Parcel source) {
            t.f(source, "source");
            return new s(source.readLong(), source.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public s[] newArray(int i10) {
            return new s[i10];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final s c() {
            return new s(new Date());
        }

        public final cd.q d(Date date) {
            long j10 = 1000;
            long time = date.getTime() / j10;
            int time2 = (int) ((date.getTime() % j10) * ((long) 1000000));
            return time2 < 0 ? w.a(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000)) : w.a(Long.valueOf(time), Integer.valueOf(time2));
        }

        public final void e(long j10, int i10) {
            if (i10 < 0 || i10 >= 1000000000) {
                throw new IllegalArgumentException(("Timestamp nanoseconds out of range: " + i10).toString());
            }
            if (-62135596800L > j10 || j10 >= 253402300800L) {
                throw new IllegalArgumentException(("Timestamp seconds out of range: " + j10).toString());
            }
        }

        public b() {
        }
    }

    public s(long j10, int i10) {
        f340c.e(j10, i10);
        this.f341a = j10;
        this.f342b = i10;
    }

    public static final s i() {
        return f340c.c();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(s other) {
        t.f(other, "other");
        return fd.a.b(this, other, new g0() { // from class: a7.s.c
            @Override // kotlin.jvm.internal.g0, wd.o
            public Object get(Object obj) {
                return Long.valueOf(((s) obj).h());
            }
        }, new g0() { // from class: a7.s.d
            @Override // kotlin.jvm.internal.g0, wd.o
            public Object get(Object obj) {
                return Integer.valueOf(((s) obj).b());
            }
        });
    }

    public final int b() {
        return this.f342b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof s) && compareTo((s) obj) == 0;
        }
        return true;
    }

    public final long h() {
        return this.f341a;
    }

    public int hashCode() {
        long j10 = this.f341a;
        return (((((int) j10) * 1369) + ((int) (j10 >> 32))) * 37) + this.f342b;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.f341a + ", nanoseconds=" + this.f342b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        t.f(dest, "dest");
        dest.writeLong(this.f341a);
        dest.writeInt(this.f342b);
    }

    public s(Date date) {
        t.f(date, "date");
        b bVar = f340c;
        cd.q qVarD = bVar.d(date);
        long jLongValue = ((Number) qVarD.a()).longValue();
        int iIntValue = ((Number) qVarD.b()).intValue();
        bVar.e(jLongValue, iIntValue);
        this.f341a = jLongValue;
        this.f342b = iIntValue;
    }
}
