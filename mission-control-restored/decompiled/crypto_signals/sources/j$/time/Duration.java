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
    public static final Duration f7357c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7359b;

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        Duration duration2 = duration;
        int iCompare = Long.compare(this.f7358a, duration2.f7358a);
        return iCompare != 0 ? iCompare : this.f7359b - duration2.f7359b;
    }

    static {
        BigInteger.valueOf(1000000000L);
    }

    public static Duration S(long j4) {
        return r(j4, 0);
    }

    public static Duration T(long j4, long j6) {
        return r(Math.addExact(j4, Math.floorDiv(j6, 1000000000L)), (int) Math.floorMod(j6, 1000000000L));
    }

    public static Duration ofMillis(long j4) {
        long j6 = j4 / 1000;
        int i = (int) (j4 % 1000);
        if (i < 0) {
            i += 1000;
            j6--;
        }
        return r(j6, i * 1000000);
    }

    private static Duration r(long j4, int i) {
        if ((((long) i) | j4) == 0) {
            return f7357c;
        }
        return new Duration(j4, i);
    }

    private Duration(long j4, int i) {
        this.f7358a = j4;
        this.f7359b = i;
    }

    public final long J() {
        return this.f7358a;
    }

    public final int C() {
        return this.f7359b;
    }

    @Override // j$.time.temporal.q
    public final j$.time.temporal.m p(j$.time.temporal.m mVar) {
        long j4 = this.f7358a;
        if (j4 != 0) {
            mVar = mVar.d(j4, j$.time.temporal.b.SECONDS);
        }
        int i = this.f7359b;
        return i != 0 ? mVar.d(i, j$.time.temporal.b.NANOS) : mVar;
    }

    public long toMillis() {
        long j4 = this.f7359b;
        long j6 = this.f7358a;
        if (j6 < 0) {
            j6++;
            j4 -= 1000000000;
        }
        return Math.addExact(Math.multiplyExact(j6, 1000), j4 / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            if (this.f7358a == duration.f7358a && this.f7359b == duration.f7359b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f7358a;
        return (this.f7359b * 51) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        if (this == f7357c) {
            return "PT0S";
        }
        long j4 = this.f7358a;
        int i = this.f7359b;
        long j6 = (j4 >= 0 || i <= 0) ? j4 : 1 + j4;
        long j7 = j6 / 3600;
        int i6 = (int) ((j6 % 3600) / 60);
        int i7 = (int) (j6 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j7 != 0) {
            sb.append(j7);
            sb.append('H');
        }
        if (i6 != 0) {
            sb.append(i6);
            sb.append('M');
        }
        if (i7 == 0 && i == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (j4 < 0 && i > 0 && i7 == 0) {
            sb.append("-0");
        } else {
            sb.append(i7);
        }
        if (i > 0) {
            int length = sb.length();
            if (j4 < 0) {
                sb.append(2000000000 - ((long) i));
            } else {
                sb.append(((long) i) + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
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
        objectOutput.writeLong(this.f7358a);
        objectOutput.writeInt(this.f7359b);
    }
}
