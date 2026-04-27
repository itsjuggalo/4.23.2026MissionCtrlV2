package X0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3486a;

    public m(ArrayList arrayList) {
        this.f3486a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        return this.f3486a.equals(((m) ((x) obj)).f3486a);
    }

    public final int hashCode() {
        return this.f3486a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f3486a + "}";
    }
}
