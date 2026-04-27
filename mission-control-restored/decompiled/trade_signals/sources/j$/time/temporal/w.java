package j$.time.temporal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19867d;

    private w(long j8, long j9, long j10, long j11) {
        this.f19864a = j8;
        this.f19865b = j9;
        this.f19866c = j10;
        this.f19867d = j11;
    }

    private String c(long j8, r rVar) {
        if (rVar == null) {
            return "Invalid value (valid values " + this + "): " + j8;
        }
        return "Invalid value for " + rVar + " (valid values " + this + "): " + j8;
    }

    public static w j(long j8, long j9) {
        if (j8 <= j9) {
            return new w(j8, j8, j9, j9);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static w k(long j8, long j9) {
        if (j8 > j9) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (1 <= j9) {
            return new w(1L, 1L, j8, j9);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        long j8 = this.f19864a;
        long j9 = this.f19865b;
        if (j8 > j9) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j10 = this.f19866c;
        long j11 = this.f19867d;
        if (j10 > j11) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j9 > j11) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final int a(long j8, r rVar) {
        if (h() && i(j8)) {
            return (int) j8;
        }
        throw new j$.time.c(c(j8, rVar));
    }

    public final void b(long j8, r rVar) {
        if (!i(j8)) {
            throw new j$.time.c(c(j8, rVar));
        }
    }

    public final long d() {
        return this.f19867d;
    }

    public final long e() {
        return this.f19864a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f19864a == wVar.f19864a && this.f19865b == wVar.f19865b && this.f19866c == wVar.f19866c && this.f19867d == wVar.f19867d;
    }

    public final long f() {
        return this.f19866c;
    }

    public final boolean g() {
        return this.f19864a == this.f19865b && this.f19866c == this.f19867d;
    }

    public final boolean h() {
        return this.f19864a >= -2147483648L && this.f19867d <= 2147483647L;
    }

    public final int hashCode() {
        long j8 = this.f19865b;
        long j9 = this.f19864a + (j8 << 16) + (j8 >> 48);
        long j10 = this.f19866c;
        long j11 = j9 + (j10 << 32) + (j10 >> 32);
        long j12 = this.f19867d;
        long j13 = j11 + (j12 << 48) + (j12 >> 16);
        return (int) ((j13 >>> 32) ^ j13);
    }

    public final boolean i(long j8) {
        return j8 >= this.f19864a && j8 <= this.f19867d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        long j8 = this.f19864a;
        sb.append(j8);
        long j9 = this.f19865b;
        if (j8 != j9) {
            sb.append('/');
            sb.append(j9);
        }
        sb.append(" - ");
        long j10 = this.f19866c;
        sb.append(j10);
        long j11 = this.f19867d;
        if (j10 != j11) {
            sb.append('/');
            sb.append(j11);
        }
        return sb.toString();
    }
}
