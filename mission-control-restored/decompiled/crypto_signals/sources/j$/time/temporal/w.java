package j$.time.temporal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f7564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f7565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f7566d;

    public static w j(long j4, long j6) {
        if (j4 > j6) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new w(j4, j4, j6, j6);
    }

    public static w k(long j4, long j6) {
        if (j4 > j6) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (1 > j6) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new w(1L, 1L, j4, j6);
    }

    private w(long j4, long j6, long j7, long j8) {
        this.f7563a = j4;
        this.f7564b = j6;
        this.f7565c = j7;
        this.f7566d = j8;
    }

    public final boolean g() {
        return this.f7563a == this.f7564b && this.f7565c == this.f7566d;
    }

    public final long e() {
        return this.f7563a;
    }

    public final long f() {
        return this.f7565c;
    }

    public final long d() {
        return this.f7566d;
    }

    public final boolean h() {
        return this.f7563a >= -2147483648L && this.f7566d <= 2147483647L;
    }

    public final boolean i(long j4) {
        return j4 >= this.f7563a && j4 <= this.f7566d;
    }

    public final int a(long j4, r rVar) {
        if (h() && i(j4)) {
            return (int) j4;
        }
        throw new j$.time.c(c(j4, rVar));
    }

    public final void b(long j4, r rVar) {
        if (!i(j4)) {
            throw new j$.time.c(c(j4, rVar));
        }
    }

    private String c(long j4, r rVar) {
        if (rVar != null) {
            return "Invalid value for " + rVar + " (valid values " + this + "): " + j4;
        }
        return "Invalid value (valid values " + this + "): " + j4;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        long j4 = this.f7563a;
        long j6 = this.f7564b;
        if (j4 > j6) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j7 = this.f7565c;
        long j8 = this.f7566d;
        if (j7 > j8) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j6 > j8) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.f7563a == wVar.f7563a && this.f7564b == wVar.f7564b && this.f7565c == wVar.f7565c && this.f7566d == wVar.f7566d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f7564b;
        long j6 = this.f7563a + (j4 << 16) + (j4 >> 48);
        long j7 = this.f7565c;
        long j8 = j6 + (j7 << 32) + (j7 >> 32);
        long j9 = this.f7566d;
        long j10 = j8 + (j9 << 48) + (j9 >> 16);
        return (int) ((j10 >>> 32) ^ j10);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        long j4 = this.f7563a;
        sb.append(j4);
        long j6 = this.f7564b;
        if (j4 != j6) {
            sb.append('/');
            sb.append(j6);
        }
        sb.append(" - ");
        long j7 = this.f7565c;
        sb.append(j7);
        long j8 = this.f7566d;
        if (j7 != j8) {
            sb.append('/');
            sb.append(j8);
        }
        return sb.toString();
    }
}
