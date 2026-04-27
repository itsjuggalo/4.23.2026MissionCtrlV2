package Z0;

import S.i;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3936b;

    public a(int i, long j4) {
        if (i == 0) {
            throw new NullPointerException("Null status");
        }
        this.f3935a = i;
        this.f3936b = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return i.b(this.f3935a, aVar.f3935a) && this.f3936b == aVar.f3936b;
    }

    public final int hashCode() {
        int iC = (i.c(this.f3935a) ^ 1000003) * 1000003;
        long j4 = this.f3936b;
        return iC ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.f3935a;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.f3936b);
        sb.append("}");
        return sb.toString();
    }
}
