package j$.time;

import j$.time.chrono.InterfaceC2186b;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class Duration implements j$.time.temporal.q, Comparable<Duration>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Duration f19642c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19644b;

    static {
        BigInteger.valueOf(1000000000L);
    }

    private Duration(long j8, int i8) {
        this.f19643a = j8;
        this.f19644b = i8;
    }

    public static Duration M(long j8) {
        return q(j8, 0);
    }

    public static Duration R(long j8, long j9) {
        return q(Math.addExact(j8, Math.floorDiv(j9, 1000000000L)), (int) Math.floorMod(j9, 1000000000L));
    }

    public static Duration ofMillis(long j8) {
        long j9 = j8 / 1000;
        int i8 = (int) (j8 % 1000);
        if (i8 < 0) {
            i8 += 1000;
            j9--;
        }
        return q(j9, i8 * 1000000);
    }

    private static Duration q(long j8, int i8) {
        return (((long) i8) | j8) == 0 ? f19642c : new Duration(j8, i8);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 1, this);
    }

    public final int A() {
        return this.f19644b;
    }

    public final long H() {
        return this.f19643a;
    }

    final void U(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.f19643a);
        dataOutput.writeInt(this.f19644b);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        Duration duration2 = duration;
        int iCompare = Long.compare(this.f19643a, duration2.f19643a);
        return iCompare != 0 ? iCompare : this.f19644b - duration2.f19644b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.f19643a == duration.f19643a && this.f19644b == duration.f19644b;
    }

    public final int hashCode() {
        long j8 = this.f19643a;
        return (this.f19644b * 51) + ((int) (j8 ^ (j8 >>> 32)));
    }

    @Override // j$.time.temporal.q
    public final j$.time.temporal.m o(InterfaceC2186b interfaceC2186b) {
        long j8 = this.f19643a;
        InterfaceC2186b interfaceC2186bE = interfaceC2186b;
        if (j8 != 0) {
            interfaceC2186bE = interfaceC2186b.e(j8, (j$.time.temporal.u) j$.time.temporal.b.SECONDS);
        }
        int i8 = this.f19644b;
        return i8 != 0 ? interfaceC2186bE.e(i8, (j$.time.temporal.u) j$.time.temporal.b.NANOS) : interfaceC2186bE;
    }

    public long toMillis() {
        long j8 = this.f19644b;
        long j9 = this.f19643a;
        if (j9 < 0) {
            j9++;
            j8 -= 1000000000;
        }
        return Math.addExact(Math.multiplyExact(j9, 1000), j8 / 1000000);
    }

    public final String toString() {
        if (this == f19642c) {
            return "PT0S";
        }
        long j8 = this.f19643a;
        int i8 = this.f19644b;
        long j9 = (j8 >= 0 || i8 <= 0) ? j8 : 1 + j8;
        long j10 = j9 / 3600;
        int i9 = (int) ((j9 % 3600) / 60);
        int i10 = (int) (j9 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j10 != 0) {
            sb.append(j10);
            sb.append('H');
        }
        if (i9 != 0) {
            sb.append(i9);
            sb.append('M');
        }
        if (i10 == 0 && i8 == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (j8 >= 0 || i8 <= 0 || i10 != 0) {
            sb.append(i10);
        } else {
            sb.append("-0");
        }
        if (i8 > 0) {
            int length = sb.length();
            sb.append(j8 < 0 ? 2000000000 - ((long) i8) : ((long) i8) + 1000000000);
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, com.amazon.a.a.o.c.a.b.f14112a);
        }
        sb.append('S');
        return sb.toString();
    }
}
