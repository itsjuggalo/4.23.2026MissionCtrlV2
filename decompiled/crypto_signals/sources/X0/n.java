package X0;

/* JADX INFO: loaded from: classes.dex */
public final class n extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f3487a;

    public n(l lVar) {
        this.f3487a = lVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        Object obj2 = y.f3515a;
        ((n) zVar).getClass();
        return obj2.equals(obj2) && this.f3487a.equals(((n) zVar).f3487a);
    }

    public final int hashCode() {
        return ((y.f3515a.hashCode() ^ 1000003) * 1000003) ^ this.f3487a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + y.f3515a + ", androidClientInfo=" + this.f3487a + "}";
    }
}
