package Q2;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2665b;

    public c(long j4, b bVar) {
        this.f2664a = j4;
        if (bVar == null) {
            throw new NullPointerException("Null offset");
        }
        this.f2665b = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f2664a == cVar.f2664a && this.f2665b.equals(cVar.f2665b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f2664a;
        return ((((int) ((j4 >>> 32) ^ j4)) ^ 1000003) * 1000003) ^ this.f2665b.hashCode();
    }

    public final String toString() {
        return "IndexState{sequenceNumber=" + this.f2664a + ", offset=" + this.f2665b + "}";
    }
}
