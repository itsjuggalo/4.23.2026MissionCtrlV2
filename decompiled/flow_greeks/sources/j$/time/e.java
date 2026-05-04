package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements j$.time.temporal.p, Comparable, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f13622c = new e(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13624b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        int iCompare = Long.compare(this.f13623a, eVar.f13623a);
        return iCompare != 0 ? iCompare : this.f13624b - eVar.f13624b;
    }

    static {
        BigInteger.valueOf(1000000000L);
    }

    public static e F(long j10) {
        long j11 = j10 / 1000000000;
        int i10 = (int) (j10 % 1000000000);
        if (i10 < 0) {
            i10 = (int) (((long) i10) + 1000000000);
            j11--;
        }
        return A(j11, i10);
    }

    public static e A(long j10, int i10) {
        if ((((long) i10) | j10) == 0) {
            return f13622c;
        }
        return new e(j10, i10);
    }

    public e(long j10, int i10) {
        this.f13623a = j10;
        this.f13624b = i10;
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        long j10 = this.f13623a;
        if (j10 != 0) {
            mVar = mVar.d(j10, j$.time.temporal.b.SECONDS);
        }
        int i10 = this.f13624b;
        return i10 != 0 ? mVar.d(i10, j$.time.temporal.b.NANOS) : mVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f13623a == eVar.f13623a && this.f13624b == eVar.f13624b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f13623a;
        return (this.f13624b * 51) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        if (this == f13622c) {
            return "PT0S";
        }
        long j10 = this.f13623a;
        if (j10 < 0 && this.f13624b > 0) {
            j10++;
        }
        long j11 = j10 / 3600;
        int i10 = (int) ((j10 % 3600) / 60);
        int i11 = (int) (j10 % 60);
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("PT");
        if (j11 != 0) {
            sb2.append(j11);
            sb2.append('H');
        }
        if (i10 != 0) {
            sb2.append(i10);
            sb2.append('M');
        }
        if (i11 == 0 && this.f13624b == 0 && sb2.length() > 2) {
            return sb2.toString();
        }
        if (this.f13623a < 0 && this.f13624b > 0 && i11 == 0) {
            sb2.append("-0");
        } else {
            sb2.append(i11);
        }
        if (this.f13624b > 0) {
            int length = sb2.length();
            if (this.f13623a < 0) {
                sb2.append(2000000000 - ((long) this.f13624b));
            } else {
                sb2.append(((long) this.f13624b) + 1000000000);
            }
            while (sb2.charAt(sb2.length() - 1) == '0') {
                sb2.setLength(sb2.length() - 1);
            }
            sb2.setCharAt(length, com.amazon.a.a.o.c.a.b.f4610a);
        }
        sb2.append('S');
        return sb2.toString();
    }

    private Object writeReplace() {
        return new t((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
