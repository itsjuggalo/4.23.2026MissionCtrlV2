package y1;

import java.util.List;

/* JADX INFO: renamed from: y1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2973d extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24337a;

    public C2973d(List list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f24337a = list;
    }

    @Override // y1.n
    public List c() {
        return this.f24337a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            return this.f24337a.equals(((n) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f24337a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f24337a + "}";
    }
}
