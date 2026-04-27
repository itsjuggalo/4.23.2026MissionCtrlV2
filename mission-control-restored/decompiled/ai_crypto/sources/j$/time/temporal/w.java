package j$.time.temporal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f17288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f17289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f17290d;

    public static w j(long j7, long j8) {
        if (j7 > j8) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new w(j7, j7, j8, j8);
    }

    public static w k(long j7, long j8) {
        if (j7 > j8) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (1 > j8) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new w(1L, 1L, j7, j8);
    }

    private w(long j7, long j8, long j9, long j10) {
        this.f17287a = j7;
        this.f17288b = j8;
        this.f17289c = j9;
        this.f17290d = j10;
    }

    public final boolean g() {
        return this.f17287a == this.f17288b && this.f17289c == this.f17290d;
    }

    public final long e() {
        return this.f17287a;
    }

    public final long f() {
        return this.f17289c;
    }

    public final long d() {
        return this.f17290d;
    }

    public final boolean h() {
        return this.f17287a >= -2147483648L && this.f17290d <= 2147483647L;
    }

    public final boolean i(long j7) {
        return j7 >= this.f17287a && j7 <= this.f17290d;
    }

    public final int a(long j7, r rVar) {
        if (h() && i(j7)) {
            return (int) j7;
        }
        throw new j$.time.c(c(j7, rVar));
    }

    public final void b(long j7, r rVar) {
        if (!i(j7)) {
            throw new j$.time.c(c(j7, rVar));
        }
    }

    private String c(long j7, r rVar) {
        if (rVar != null) {
            return "Invalid value for " + rVar + " (valid values " + this + "): " + j7;
        }
        return "Invalid value (valid values " + this + "): " + j7;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        long j7 = this.f17287a;
        long j8 = this.f17288b;
        if (j7 > j8) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j9 = this.f17289c;
        long j10 = this.f17290d;
        if (j9 > j10) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j8 > j10) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f17287a == wVar.f17287a && this.f17288b == wVar.f17288b && this.f17289c == wVar.f17289c && this.f17290d == wVar.f17290d;
    }

    public final int hashCode() {
        long j7 = this.f17288b;
        long j8 = this.f17287a + (j7 << 16) + (j7 >> 48);
        long j9 = this.f17289c;
        long j10 = j8 + (j9 << 32) + (j9 >> 32);
        long j11 = this.f17290d;
        long j12 = j10 + (j11 << 48) + (j11 >> 16);
        return (int) ((j12 >>> 32) ^ j12);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        long j7 = this.f17287a;
        sb.append(j7);
        long j8 = this.f17288b;
        if (j7 != j8) {
            sb.append('/');
            sb.append(j8);
        }
        sb.append(" - ");
        long j9 = this.f17289c;
        sb.append(j9);
        long j10 = this.f17290d;
        if (j9 != j10) {
            sb.append('/');
            sb.append(j10);
        }
        return sb.toString();
    }
}
