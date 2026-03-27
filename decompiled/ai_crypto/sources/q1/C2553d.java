package q1;

import java.util.List;

/* JADX INFO: renamed from: q1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2553d extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f22184a;

    public C2553d(List list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f22184a = list;
    }

    @Override // q1.n
    public List c() {
        return this.f22184a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            return this.f22184a.equals(((n) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f22184a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f22184a + "}";
    }
}
