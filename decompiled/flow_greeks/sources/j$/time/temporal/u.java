package j$.time.temporal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13763d;

    public static u f(long j10, long j11) {
        if (j10 > j11) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new u(j10, j10, j11, j11);
    }

    public static u g(long j10, long j11) {
        if (j10 > j11) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (1 > j11) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new u(1L, 1L, j10, j11);
    }

    public u(long j10, long j11, long j12, long j13) {
        this.f13760a = j10;
        this.f13761b = j11;
        this.f13762c = j12;
        this.f13763d = j13;
    }

    public final boolean d() {
        return this.f13760a >= -2147483648L && this.f13763d <= 2147483647L;
    }

    public final boolean e(long j10) {
        return j10 >= this.f13760a && j10 <= this.f13763d;
    }

    public final int a(long j10, q qVar) {
        if (d() && e(j10)) {
            return (int) j10;
        }
        throw new j$.time.c(c(j10, qVar));
    }

    public final void b(long j10, q qVar) {
        if (!e(j10)) {
            throw new j$.time.c(c(j10, qVar));
        }
    }

    public final String c(long j10, q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j10;
        }
        return "Invalid value (valid values " + this + "): " + j10;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        long j10 = this.f13760a;
        long j11 = this.f13761b;
        if (j10 > j11) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j12 = this.f13762c;
        long j13 = this.f13763d;
        if (j12 > j13) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j11 > j13) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f13760a == uVar.f13760a && this.f13761b == uVar.f13761b && this.f13762c == uVar.f13762c && this.f13763d == uVar.f13763d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f13760a;
        long j11 = this.f13761b;
        long j12 = j10 + (j11 << 16) + (j11 >> 48);
        long j13 = this.f13762c;
        long j14 = j12 + (j13 << 32) + (j13 >> 32);
        long j15 = this.f13763d;
        long j16 = j14 + (j15 << 48) + (j15 >> 16);
        return (int) (j16 ^ (j16 >>> 32));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f13760a);
        if (this.f13760a != this.f13761b) {
            sb2.append('/');
            sb2.append(this.f13761b);
        }
        sb2.append(" - ");
        sb2.append(this.f13762c);
        if (this.f13762c != this.f13763d) {
            sb2.append('/');
            sb2.append(this.f13763d);
        }
        return sb2.toString();
    }
}
