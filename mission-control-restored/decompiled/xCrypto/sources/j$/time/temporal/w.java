package j$.time.temporal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f13328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f13329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f13330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f13331d;

    public static w j(long j4, long j5) {
        if (j4 > j5) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new w(j4, j4, j5, j5);
    }

    public static w k(long j4, long j5) {
        if (j4 > j5) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (1 > j5) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new w(1L, 1L, j4, j5);
    }

    private w(long j4, long j5, long j6, long j7) {
        this.f13328a = j4;
        this.f13329b = j5;
        this.f13330c = j6;
        this.f13331d = j7;
    }

    public final boolean g() {
        return this.f13328a == this.f13329b && this.f13330c == this.f13331d;
    }

    public final long e() {
        return this.f13328a;
    }

    public final long f() {
        return this.f13330c;
    }

    public final long d() {
        return this.f13331d;
    }

    public final boolean h() {
        return this.f13328a >= -2147483648L && this.f13331d <= 2147483647L;
    }

    public final boolean i(long j4) {
        return j4 >= this.f13328a && j4 <= this.f13331d;
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
        long j4 = this.f13328a;
        long j5 = this.f13329b;
        if (j4 > j5) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j6 = this.f13330c;
        long j7 = this.f13331d;
        if (j6 > j7) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j5 > j7) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.f13328a == wVar.f13328a && this.f13329b == wVar.f13329b && this.f13330c == wVar.f13330c && this.f13331d == wVar.f13331d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f13329b;
        long j5 = this.f13328a + (j4 << 16) + (j4 >> 48);
        long j6 = this.f13330c;
        long j7 = j5 + (j6 << 32) + (j6 >> 32);
        long j8 = this.f13331d;
        long j9 = j7 + (j8 << 48) + (j8 >> 16);
        return (int) ((j9 >>> 32) ^ j9);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        long j4 = this.f13328a;
        sb.append(j4);
        long j5 = this.f13329b;
        if (j4 != j5) {
            sb.append('/');
            sb.append(j5);
        }
        sb.append(" - ");
        long j6 = this.f13330c;
        sb.append(j6);
        long j7 = this.f13331d;
        if (j6 != j7) {
            sb.append('/');
            sb.append(j7);
        }
        return sb.toString();
    }
}
