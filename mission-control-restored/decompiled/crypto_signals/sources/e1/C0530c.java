package e1;

import java.util.Set;

/* JADX INFO: renamed from: e1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0530c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f6047c;

    public C0530c(long j4, long j6, Set set) {
        this.f6045a = j4;
        this.f6046b = j6;
        this.f6047c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0530c) {
            C0530c c0530c = (C0530c) obj;
            if (this.f6045a == c0530c.f6045a && this.f6046b == c0530c.f6046b && this.f6047c.equals(c0530c.f6047c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f6045a;
        int i = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        long j6 = this.f6046b;
        return ((i ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.f6047c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f6045a + ", maxAllowedDelay=" + this.f6046b + ", flags=" + this.f6047c + "}";
    }
}
