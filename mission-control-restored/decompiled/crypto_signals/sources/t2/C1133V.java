package t2;

/* JADX INFO: renamed from: t2.V, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1133V extends z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10032c;

    public C1133V(String str, String str2, long j4) {
        this.f10030a = str;
        this.f10031b = str2;
        this.f10032c = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z0) {
            z0 z0Var = (z0) obj;
            if (this.f10030a.equals(((C1133V) z0Var).f10030a)) {
                C1133V c1133v = (C1133V) z0Var;
                if (this.f10031b.equals(c1133v.f10031b) && this.f10032c == c1133v.f10032c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f10030a.hashCode() ^ 1000003) * 1000003) ^ this.f10031b.hashCode()) * 1000003;
        long j4 = this.f10032c;
        return iHashCode ^ ((int) ((j4 >>> 32) ^ j4));
    }

    public final String toString() {
        return "Signal{name=" + this.f10030a + ", code=" + this.f10031b + ", address=" + this.f10032c + "}";
    }
}
