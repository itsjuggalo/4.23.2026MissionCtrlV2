package j$.time;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class Duration implements j$.time.temporal.q, Comparable<Duration>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Duration f13108c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f13109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13110b;

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        Duration duration2 = duration;
        int iCompare = Long.compare(this.f13109a, duration2.f13109a);
        return iCompare != 0 ? iCompare : this.f13110b - duration2.f13110b;
    }

    static {
        BigInteger.valueOf(1000000000L);
    }

    public static Duration S(long j4) {
        return r(j4, 0);
    }

    public static Duration T(long j4, long j5) {
        return r(Math.addExact(j4, Math.floorDiv(j5, 1000000000L)), (int) Math.floorMod(j5, 1000000000L));
    }

    public static Duration ofMillis(long j4) {
        long j5 = j4 / 1000;
        int i4 = (int) (j4 % 1000);
        if (i4 < 0) {
            i4 += 1000;
            j5--;
        }
        return r(j5, i4 * 1000000);
    }

    private static Duration r(long j4, int i4) {
        if ((((long) i4) | j4) == 0) {
            return f13108c;
        }
        return new Duration(j4, i4);
    }

    private Duration(long j4, int i4) {
        this.f13109a = j4;
        this.f13110b = i4;
    }

    public final long J() {
        return this.f13109a;
    }

    public final int C() {
        return this.f13110b;
    }

    @Override // j$.time.temporal.q
    public final j$.time.temporal.m p(j$.time.temporal.m mVar) {
        long j4 = this.f13109a;
        if (j4 != 0) {
            mVar = mVar.d(j4, j$.time.temporal.b.SECONDS);
        }
        int i4 = this.f13110b;
        return i4 != 0 ? mVar.d(i4, j$.time.temporal.b.NANOS) : mVar;
    }

    public long toMillis() {
        long j4 = this.f13110b;
        long j5 = this.f13109a;
        if (j5 < 0) {
            j5++;
            j4 -= 1000000000;
        }
        return Math.addExact(Math.multiplyExact(j5, 1000), j4 / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            if (this.f13109a == duration.f13109a && this.f13110b == duration.f13110b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f13109a;
        return (this.f13110b * 51) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        if (this == f13108c) {
            return "PT0S";
        }
        long j4 = this.f13109a;
        int i4 = this.f13110b;
        long j5 = (j4 >= 0 || i4 <= 0) ? j4 : 1 + j4;
        long j6 = j5 / 3600;
        int i5 = (int) ((j5 % 3600) / 60);
        int i6 = (int) (j5 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j6 != 0) {
            sb.append(j6);
            sb.append('H');
        }
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        if (i6 == 0 && i4 == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (j4 < 0 && i4 > 0 && i6 == 0) {
            sb.append("-0");
        } else {
            sb.append(i6);
        }
        if (i4 > 0) {
            int length = sb.length();
            if (j4 < 0) {
                sb.append(2000000000 - ((long) i4));
            } else {
                sb.append(((long) i4) + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, com.amazon.a.a.o.c.a.b.f8816a);
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(this.f13109a);
        objectOutput.writeInt(this.f13110b);
    }
}
