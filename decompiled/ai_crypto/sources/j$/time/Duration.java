package j$.time;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class Duration implements j$.time.temporal.q, Comparable<Duration>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Duration f17067c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17069b;

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        Duration duration2 = duration;
        int iCompare = Long.compare(this.f17068a, duration2.f17068a);
        return iCompare != 0 ? iCompare : this.f17069b - duration2.f17069b;
    }

    static {
        BigInteger.valueOf(1000000000L);
    }

    public static Duration S(long j7) {
        return r(j7, 0);
    }

    public static Duration T(long j7, long j8) {
        return r(Math.addExact(j7, Math.floorDiv(j8, 1000000000L)), (int) Math.floorMod(j8, 1000000000L));
    }

    public static Duration ofMillis(long j7) {
        long j8 = j7 / 1000;
        int i7 = (int) (j7 % 1000);
        if (i7 < 0) {
            i7 += 1000;
            j8--;
        }
        return r(j8, i7 * 1000000);
    }

    private static Duration r(long j7, int i7) {
        if ((((long) i7) | j7) == 0) {
            return f17067c;
        }
        return new Duration(j7, i7);
    }

    private Duration(long j7, int i7) {
        this.f17068a = j7;
        this.f17069b = i7;
    }

    public final long J() {
        return this.f17068a;
    }

    public final int C() {
        return this.f17069b;
    }

    @Override // j$.time.temporal.q
    public final j$.time.temporal.m p(j$.time.temporal.m mVar) {
        long j7 = this.f17068a;
        if (j7 != 0) {
            mVar = mVar.d(j7, j$.time.temporal.b.SECONDS);
        }
        int i7 = this.f17069b;
        return i7 != 0 ? mVar.d(i7, j$.time.temporal.b.NANOS) : mVar;
    }

    public long toMillis() {
        long j7 = this.f17069b;
        long j8 = this.f17068a;
        if (j8 < 0) {
            j8++;
            j7 -= 1000000000;
        }
        return Math.addExact(Math.multiplyExact(j8, 1000), j7 / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.f17068a == duration.f17068a && this.f17069b == duration.f17069b;
    }

    public final int hashCode() {
        long j7 = this.f17068a;
        return (this.f17069b * 51) + ((int) (j7 ^ (j7 >>> 32)));
    }

    public final String toString() {
        if (this == f17067c) {
            return "PT0S";
        }
        long j7 = this.f17068a;
        int i7 = this.f17069b;
        long j8 = (j7 >= 0 || i7 <= 0) ? j7 : 1 + j7;
        long j9 = j8 / 3600;
        int i8 = (int) ((j8 % 3600) / 60);
        int i9 = (int) (j8 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j9 != 0) {
            sb.append(j9);
            sb.append('H');
        }
        if (i8 != 0) {
            sb.append(i8);
            sb.append('M');
        }
        if (i9 == 0 && i7 == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (j7 < 0 && i7 > 0 && i9 == 0) {
            sb.append("-0");
        } else {
            sb.append(i9);
        }
        if (i7 > 0) {
            int length = sb.length();
            if (j7 < 0) {
                sb.append(2000000000 - ((long) i7));
            } else {
                sb.append(((long) i7) + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, com.amazon.a.a.o.c.a.b.f10001a);
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new t((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(this.f17068a);
        objectOutput.writeInt(this.f17069b);
    }
}
